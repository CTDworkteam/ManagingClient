package billbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.GiftBillPO.GiftBillItemPO;
import dataservice.*;
import vo.*;
import vo.GiftBillVO.GiftBillItemVO;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;
import vo.SalesBillVO.SalesBillItemVO;
import vo.SalesReturnBillVO.SalesReturnBillItemVO;
import enumType.ResultMessage;

public class BillImpl {
	public ResultMessage ArrpoveGiftBill(GiftBillVO vo) {   //该方法用于赠送单通过审批后的相关处理
		try{
			StockDataService service = (StockDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
		
			GiftBillPO po = service.find1(vo.getId());
			ArrayList<GiftBillItemVO> list = vo.getList();
			
			for(int i = 0;i<list.size();i++) {    //找到对应商品
				CommodityPO commodity = service2.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();  
			
				for(int j = 0;j<list2.size();j++) {   //找到对应商品的型号
					if(list2.get(j).getModel().equals(list.get(i).getModel())){
						list2.get(j).setStock(list2.get(j).getStock()-list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //更新商品数量
				service2.updateCommodity(commodity);  //更新商品
			}
			
			po.setPassed(true);
			service.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateGiftBill(GiftBillVO vo){
		try{
			StockDataService service=(StockDataService) Naming.lookup("");
			GiftBillPO temp=exchange(vo);
			GiftBillPO po=service.find1(vo.getId());
			for(int i=0;i<po.getList().size();i++){
				po.getList().get(i).setCommodity(temp.getList().get(i).getCommodity());
				po.getList().get(i).setModel(temp.getList().get(i).getModel());
				po.getList().get(i).setNumber(temp.getList().get(i).getNumber());
			}
			service.update(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage approveOverflowBill(OverflowBillVO vo) {   //该方法用于审批库存报溢单
		try {
			StockDataService service=(StockDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
			
			OverflowBillPO po = service.find(vo.getId());
			CommodityPO commodity = service2.findCommodityInName(vo.getCommodity());
			
			commodity.setTotal(vo.getActualNumber());   //将商品数量同步
			service2.updateCommodity(commodity);
			
			po.setPassed(true);
			service.update(po);      //更新库存报溢单
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateOverflowBill(OverflowBillVO vo){
		try{
			StockDataService service=(StockDataService) Naming.lookup("");
			OverflowBillPO temp=exchange(vo);
			OverflowBillPO po=service.find(vo.getId());
			po.setCommodity(temp.getCommodity());
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {    //该方法用于审批库存报溢单
		try {
			StockDataService service = (StockDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
		
			UnderflowBillPO po = service.find2(vo.getId());
			CommodityPO commodity = service2.findCommodityInName(vo.getCommodity());
			
			commodity.setTotal(vo.getActualNumber());   //将商品数量同步
			service2.updateCommodity(commodity);
	
			po.setPassed(true);     //更新库存报损单
			service.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateUnderflowBill(UnderflowBillVO vo){
 * 
 */
	
	public ResultMessage approvePurchaseBill(PurchaseBillVO vo) {    //该方法用于审批进货单
		try{
			PurchaseDataService service = (PurchaseDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
			ClientDataService service3 = (ClientDataService) Naming.lookup("");
			
			PurchaseBillPO po = service.find1(vo.getId());
			ClientPO client = service3.find(vo.getSupplier());       //更新客户的应收入金额
			client.setMoneyReserved(client.getMoneyReserved()+vo.getTotal());
			service3.update(client);
			
			ArrayList<PurchaseBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++) {        //更新对应商品型号的库存数量
				CommodityPO commodity = service2.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
			
				for(int j = 0;j<list2.size();j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())){
						list2.get(j).setStock(list2.get(j).getStock()+list.get(i).getNumber());
						list2.get(j).setRecentPurchasePrice(list.get(i).getPrice());
						break;
					}
				}
				
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal() + list.get(i).getNumber());  //更新该商品的总数量
				service2.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			service.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updatePurchaseBill(PurchaseBillVO vo){
		
	}
	*/
	
	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {   //该方法用于审批进货退货单
		try {
			PurchaseDataService service = (PurchaseDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
			ClientDataService service3 = (ClientDataService) Naming.lookup("");
			
			PurchaseBillPO po = service.find1(vo.getId());
			ClientPO client = service3.find(vo.getSupplier());      //更新客户的应收入金额
			client.setMoneyToPay(client.getMoneyReserved() + vo.getTotal());
			service3.update(client);
			
			ArrayList<PurchaseReturnBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++){       //更新对应商品型号的库存数量
				CommodityPO commodity = service2.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				
				for(int j = 0;j<list2.size();j++){
					if(list.get(i).getModel().equals(list2.get(j).getModel())){
						list2.get(j).setStock(list2.get(j).getStock() - list.get(i).getNumber());
						break;
					}
				}
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //更新商品总数量
				service2.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			service.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesBill(SalesBillVO vo) {      //该方法用于审批销售单
		try {
			SalesDataService service = (SalesDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
			ClientDataService service3 = (ClientDataService) Naming.lookup("");
			
			SalesBillPO po = service.find1(vo.getId());
			ClientPO client = service3.find(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() + vo.getTotal());   //更新客户应付金额
			service3.update(client);
			
			ArrayList<SalesBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {    //更新对应商品型号的数量
				CommodityPO commodity = service2.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
		
				for(int j = 0;j < list2.size(); j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())) {
						list2.get(j).setStock(list2.get(j).getStock()-list.get(i).getNumber());
						list2.get(j).setRecentRetailPrice(list.get(i).getPrice());
						break;
					}
				}

				commodity.setList(list2);          //更新相应商品的总数量
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());
				service2.updateCommodity(commodity);
			}
		
			po.setPassed(true);
			service.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		try {
			SalesDataService service = (SalesDataService) Naming.lookup("");
			CommodityDataService service2 = (CommodityDataService) Naming.lookup("");
			ClientDataService service3 = (ClientDataService) Naming.lookup("");
			
			SalesReturnBillPO po = service.find2(vo.getId());
			ClientPO client = service3.find(vo.getClient());
			client.setMoneyReserved(client.getMoneyToPay() + vo.getTotal());     //更新客户应收入金额
			service3.update(client);
			
			ArrayList<SalesReturnBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {     //更新对应商品型号的数量
				CommodityPO commodity = service2.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				for(int j = 0;j < list2.size();j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())) {
						list2.get(j).setStock(list2.get(j).getStock()+list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);              //更新商品总数量
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());
				service2.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			service.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveRecipt(ReciptVO vo) {     //该方法用于审批收款单
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("");
			AccountDataService service3 = (AccountDataService) Naming.lookup("");
			
			ClientPO client = service.findClient1(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() - vo.getTotal());  //更新客户应付金额
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {       //查看账户，更改账户的金额
				AccountPO account = service.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() + temp.get(i).getMoney());
				service3.update(account);
			}
		
			ReciptPO po = service.find1(vo.getId());
			po.setPassed(true);      //审批通过收款单
			service.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approvePayment(PaymentVO vo) {      //该方法用于审批付款单
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("");
			AccountDataService service3 = (AccountDataService) Naming.lookup("");
			
			ClientPO client = service.findClient1(vo.getClient());
			client.setMoneyReserved(client.getMoneyReserved() - vo.getTotal());    //更新客户应收金额
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {     //更新账户信息
				AccountPO account = service.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() - temp.get(i).getMoney());
				service3.update(account);
			}
		
			PaymentPO po = service.find2(vo.getId());
			po.setPassed(true);
			service.update(po);          //更新付款单
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}	
	
	public ResultMessage approveExpense(ExpenseVO vo) {    //该方法用于审批现金费用单
		try {
			AccountDataService service2 = (AccountDataService) Naming.lookup("");
			
			AccountPO account = service2.find(vo.getAccount());
			account.setMoney(account.getMoney()-vo.getTotal());   //修改对应账户的信息
			service2.update(account);
			
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
}

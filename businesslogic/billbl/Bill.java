package billbl;

import java.util.ArrayList;

import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;
import config.RMI;
public class Bill{
	private AccountDataService accountdataservice;
	private ClientDataService clientdataservice;
	private CommodityDataService commoditydataservice;
	private FinanceDataService financedataservice;
	private PurchaseDataService purchasedataservice;
	private SalesDataService salesdataservice;
	private StockDataService stockdataservice;
	public Bill(){
		accountdataservice=RMI.getAccountDataService();
		clientdataservice=RMI.getClientDataService();
		commoditydataservice=RMI.getCommodityDataService();
		financedataservice=RMI.getFinanceDataService();
		purchasedataservice=RMI.getPurchaseDataService();
		salesdataservice=RMI.getSalesDataService();
		stockdataservice=RMI.getStockDataService();
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {   //该方法用于赠送单通过审批后的相关处理
		try{
			GiftBillPO po = stockdataservice.find1(vo.getId());
			ArrayList<GiftBillVO.GiftBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++) {    //找到对应商品
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();  
			
				for(int j = 0;j<list2.size();j++) {   //找到对应商品的型号
					if(list2.get(j).getModel().equals(list.get(i).getModel())){
						list2.get(j).setStock(list2.get(j).getStock()-list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //更新商品数量
				commoditydataservice.updateCommodity(commodity);  //更新商品
			}
			po.setPassed(true);
			stockdataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	/*public ResultMessage updateGiftBill(GiftBillVO vo){
		try{
			GiftBillPO temp=exchange(vo);
			GiftBillPO po=stockdataservice.find1(vo.getId());
			for(int i=0;i<po.getList().size();i++){
				po.getList().get(i).setCommodity(temp.getList().get(i).getCommodity());
				po.getList().get(i).setModel(temp.getList().get(i).getModel());
				po.getList().get(i).setNumber(temp.getList().get(i).getNumber());
			}
			stockdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	public ResultMessage approveOverflowBill(OverflowBillVO vo) {   //该方法用于审批库存报溢单
		try {
			OverflowBillPO po = stockdataservice.find(vo.getId());
			CommodityPO commodity = commoditydataservice.findCommodityInName(vo.getCommodity());
			commodity.setTotal(vo.getActualNumber());   //将商品数量同步
			commoditydataservice.updateCommodity(commodity);
			po.setPassed(true);
			stockdataservice.update(po);      //更新库存报溢单
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateOverflowBill(OverflowBillVO vo){
		try{
			OverflowBillPO temp=exchange(vo);
			OverflowBillPO po=stockdataservice.find(vo.getId());
			po.setCommodity(temp.getCommodity());
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {    //该方法用于审批库存报溢单
		try {
			UnderflowBillPO po = stockdataservice.find2(vo.getId());
			CommodityPO commodity = commoditydataservice.findCommodityInName(vo.getCommodity());
			commodity.setTotal(vo.getActualNumber());   //将商品数量同步
			commoditydataservice.updateCommodity(commodity);
			po.setPassed(true);     //更新库存报损单
			stockdataservice.update(po);
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
			PurchaseBillPO po = purchasedataservice.find1(vo.getId());
			ClientPO client = clientdataservice.find(vo.getSupplier());       //更新客户的应收入金额
			client.setMoneyReserved(client.getMoneyReserved()+vo.getTotal());
			clientdataservice.update(client);
			
			ArrayList<PurchaseBillVO.PurchaseBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++) {        //更新对应商品型号的库存数量
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
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
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			purchasedataservice.update(po);
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
			PurchaseBillPO po = purchasedataservice.find1(vo.getId());
			ClientPO client = clientdataservice.find(vo.getSupplier());      //更新客户的应收入金额
			client.setMoneyToPay(client.getMoneyReserved() + vo.getTotal());
			clientdataservice.update(client);
			
			ArrayList<PurchaseReturnBillVO.PurchaseReturnBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++){       //更新对应商品型号的库存数量
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				
				for(int j = 0;j<list2.size();j++){
					if(list.get(i).getModel().equals(list2.get(j).getModel())){
						list2.get(j).setStock(list2.get(j).getStock() - list.get(i).getNumber());
						break;
					}
				}
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //更新商品总数量
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			purchasedataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesBill(SalesBillVO vo) {      //该方法用于审批销售单
		try {
			SalesBillPO po = salesdataservice.find1(vo.getId());
			ClientPO client = commoditydataservice.find(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() + vo.getTotal());   //更新客户应付金额
			clientdataservice.update(client);
			
			ArrayList<SalesBillVO.SalesBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {    //更新对应商品型号的数量
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
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
				commoditydataservice.updateCommodity(commodity);
			}
		
			po.setPassed(true);
			salesdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		try {
			SalesReturnBillPO po = salesdataservice.find2(vo.getId());
			ClientPO client = clientdataservice.find(vo.getClient());
			client.setMoneyReserved(client.getMoneyToPay() + vo.getTotal());     //更新客户应收入金额
			clientdataservice.update(client);
			
			ArrayList<SalesReturnBillVO.SalesReturnBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {     //更新对应商品型号的数量
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				for(int j = 0;j < list2.size();j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())) {
						list2.get(j).setStock(list2.get(j).getStock()+list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);              //更新商品总数量
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			salesdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveRecipt(ReciptVO vo) {     //该方法用于审批收款单
		try{
			ClientPO client = financedataservice.findClient1(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() - vo.getTotal());  //更新客户应付金额
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {       //查看账户，更改账户的金额
				AccountPO account = financedataservice.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() + temp.get(i).getMoney());
				accountdataservice.update(account);
			}
			ReciptPO po = financedataservice.find1(vo.getId());
			po.setPassed(true);      //审批通过收款单
			financedataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approvePayment(PaymentVO vo) {      //该方法用于审批付款单
		try{
			ClientPO client =financedataservice.findClient1(vo.getClient());
			client.setMoneyReserved(client.getMoneyReserved() - vo.getTotal());    //更新客户应收金额
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {     //更新账户信息
				AccountPO account = financedataservice.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() - temp.get(i).getMoney());
				accountdataservice.update(account);
			}
		
			PaymentPO po = financedataservice.find2(vo.getId());
			po.setPassed(true);
			financedataservice.update(po);          //更新付款单
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}	
	
	public ResultMessage approveExpense(ExpenseVO vo) {    //该方法用于审批现金费用单
		try {
			AccountPO account = accountdataservice.find(vo.getAccount());
			account.setMoney(account.getMoney()-vo.getTotal());   //修改对应账户的信息
			accountdataservice.update(account);
			
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
}
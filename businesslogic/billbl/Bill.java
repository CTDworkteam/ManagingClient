package billbl;

import java.util.*;

import blservice.*;
import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;
import config.RMI;
import convert.Convert;
public class Bill implements BillBLService{
	public Bill(){
		
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {
		StockDataService service1 = RMI.getStockDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		if(service1 == null || service2 == null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain1(vo.getId())) {
				return ResultMessage.No_Exist;
			}
			else {
				GiftBillPO po = service1.find1(vo.getId());
				po.setPassed(true);
				service1.update(po);
				ArrayList<GiftBillPO.GiftBillItemPO> list=new ArrayList<GiftBillPO.GiftBillItemPO>();
				for(int i=0;i<=list.size()-1;i++){
					CommodityPO commodity = service2.findCommodityInID(list.get(i).getCommodityID());
					for(int j=0;j<=commodity.getList().size()-1;j++){
						if(commodity.getList().get(j).getName().equals(list.get(i).getModel())){
							CommodityPO.CommodityModelPO modelPO=commodity.getList().get(j);
							commodity.getList().remove(j);
							modelPO.setStock(modelPO.getStock()-list.get(i).getNumber());
							commodity.getList().add(modelPO);
						}
					}
					service2.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveOverflowBill(OverflowBillVO vo) {
		StockDataService service1 = RMI.getStockDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		if(service1 == null ||service2 == null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain2(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				OverflowBillPO po = service1.find(vo.getId());
				po.setPassed(true);
				service1.update(po);
				CommodityPO commodity = service2.findCommodityInID(po.getId());
				commodity.setTotal(commodity.getTotal()+po.getActualNumber()-po.getRecordNumber());
				ArrayList<CommodityPO.CommodityModelPO> list = commodity.getList();
				for(int i = 0;i <= list.size()-1;i++){
					if(list.get(i).getName().equals(po.getModel())){
						list.get(i).setStock(po.getActualNumber());
						break;
					}
				}
				commodity.setList(list);
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {
		StockDataService service1 = RMI.getStockDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		if(service1 == null ||service2 == null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain2(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				UnderflowBillPO po = service1.find2(vo.getId());
				po.setPassed(true);
				service1.update(po);
				CommodityPO commodity = service2.findCommodityInID(po.getId());
				commodity.setTotal(commodity.getTotal()+po.getActualNumber()-po.getRecordNumber());
				ArrayList<CommodityPO.CommodityModelPO> list = commodity.getList();
				for(int i = 0;i <= list.size()-1;i++){
					if(list.get(i).getName().equals(po.getModel())){
						list.get(i).setStock(po.getActualNumber());
						break;
					}
				}
				commodity.setList(list);
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approvePurchaseBill(PurchaseBillVO vo) {
		PurchaseDataService service1 = RMI.getPurchaseDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1 == null||service2 == null||service3 == null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PurchaseBillPO bill = service1.find1(vo.getId());
				bill.setPassed(true);
				service1.update(bill);
				ClientPO client = service3.find(bill.getSupplier());
				client.setMoneyToPay(client.getMoneyToPay()+bill.getTotal());
				service3.update(client);
				Iterator<PurchaseBillPO.PurchaseBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					PurchaseBillPO.PurchaseBillItemPO item = iterator.next();
					CommodityPO  po = service2.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list = po.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setRecentPurchasePrice(item.getPrice());
							list.get(i).setStock(list.get(i).getStock()+item.getNumber());
							po.setTotal(po.getTotal()+item.getNumber());
							break;
						}
					}
					po.setList(list);
					service2.update(po);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {
		PurchaseDataService service1 = RMI.getPurchaseDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1==null||service2==null||service3==null){
			return ResultMessage.Failure;
		}
		else{
			if(service1.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PurchaseReturnBillPO returnBill = service1.find2(vo.getId());
				returnBill.setPassed(true);
				service1.update(returnBill);
				ClientPO client = service3.find(returnBill.getSupplier());
				client.setMoneyToPay(client.getMoneyToPay()-returnBill.getTotal());
				service3.update(client);
				Iterator<PurchaseReturnBillPO.PurchaseReturnBillItemPO> iterator=
						returnBill.getList().iterator();
				while(iterator.hasNext()){
					PurchaseReturnBillPO.PurchaseReturnBillItemPO item = iterator.next();
					CommodityPO commodity = service2.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list = commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setStock(list.get(i).getStock()-item.getNumber());
							commodity.setTotal(commodity.getTotal()-item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					service2.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}
	
	public ResultMessage approveSalesBill(SalesBillVO vo) {
		SalesDataService service1 = RMI.getSalesDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1==null||service2==null||service3==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				SalesBillPO bill=service1.find1(vo.getId());
				bill.setPassed(true);
				service1.update(bill);
				ClientPO client=service3.find(bill.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()+bill.getTotal());
				service3.update(client);
				Iterator<SalesBillPO.SalesBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					SalesBillPO.SalesBillItemPO item = iterator.next();
					CommodityPO commodity = service2.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list=commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setRecentRetailPrice(item.getPrice());
							list.get(i).setStock(list.get(i).getStock()-item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					service2.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		SalesDataService service1 = RMI.getSalesDataService();
		CommodityDataService service2 = RMI.getCommodityDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1==null||service2==null||service3==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				SalesReturnBillPO bill=service1.find2(vo.getId());
				bill.setPassed(true);
				service1.update(bill);
				ClientPO client=service3.find(bill.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()-bill.getTotal());
				service3.update(client);
				Iterator<SalesReturnBillPO.SalesReturnBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					SalesReturnBillPO.SalesReturnBillItemPO item = iterator.next();
					CommodityPO commodity = service2.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list=commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setStock(list.get(i).getStock()+item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					service2.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveRecipt(ReciptVO vo) {
		FinanceDataService service1 = RMI.getFinanceDataService();
		AccountDataService service2 = RMI.getAccountDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1==null||service2==null||service3==null){
			return ResultMessage.Failure;
		}
		else{
			if(service1.contain1(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				ReciptPO recipt = service1.find1(vo.getId());
				recipt.setPassed(true);
				service1.update(recipt);
				ClientPO client = service3.find(recipt.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()-recipt.getTotal());
				service3.update(client);
				Iterator<ReciptPO.ReciptItemPO> iterator=recipt.getList().iterator();
				while(iterator.hasNext()){
					ReciptPO.ReciptItemPO item = iterator.next();
					AccountPO account=service2.find(item.getAccount());
					account.setMoney(account.getMoney()+item.getMoney());
					service2.update(account);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approvePayment(PaymentVO vo) {
		FinanceDataService service1 = RMI.getFinanceDataService();
		AccountDataService service2 = RMI.getAccountDataService();
		ClientDataService service3 = RMI.getClientDataService();
		if(service1==null||service2==null||service3==null){
			return ResultMessage.Failure;
		}
		else{
			if(service1.contain1(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PaymentPO payment = service1.find2(vo.getId());
				payment.setPassed(true);
				service1.update(payment);
				ClientPO client = service3.find(payment.getClientID());
				client.setMoneyToPay(client.getMoneyToPay()-payment.getTotal());
				service3.update(client);
				Iterator<PaymentPO.PaymentItemPO> iterator=payment.getList().iterator();
				while(iterator.hasNext()){
					PaymentPO.PaymentItemPO item=iterator.next();
					AccountPO account=service2.find(item.getAccount());
					account.setMoney(account.getMoney()-item.getMoney());
					service2.update(account);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveExpense(ExpenseVO vo) {
		ExpenseDataService service1=RMI.getExpenseDataService();
		AccountDataService service2=RMI.getAccountDataService();
		if(service1==null||service2==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service1.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				ExpensePO expense=service1.find(vo.getId());
				expense.setPassed(true);
				service1.update(expense);
				AccountPO account=service2.find(expense.getAccountname());
				account.setMoney(account.getMoney()-expense.getTotal());
				service2.update(account);
				return ResultMessage.Success;
			}
		}
	}

	public ArrayList<GiftBillVO> listGiftBills() {
		StockDataService service=RMI.getStockDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<GiftBillVO> list=new ArrayList<GiftBillVO>();
			ArrayList<String> IDs=service.getGiftBillIDs();
			TreeMap<String,GiftBillPO> map=service.getGiftBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<OverflowBillVO> listOverflowBills() {
		StockDataService service=RMI.getStockDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<OverflowBillVO> list=new ArrayList<OverflowBillVO>();
			ArrayList<String> IDs=service.getOverflowBillIDs();
			TreeMap<String,OverflowBillPO> map=service.getOverflowBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<UnderflowBillVO> listUnderflowBills() {
		StockDataService service = RMI.getStockDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<UnderflowBillVO> list=new ArrayList<UnderflowBillVO>();
			ArrayList<String> IDs=service.getOverflowBillIDs();
			TreeMap<String,UnderflowBillPO> map=service.getUnderflowBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<PurchaseBillVO> listPurchaseBills() {
		PurchaseDataService service=RMI.getPurchaseDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<PurchaseBillVO> list=new ArrayList<PurchaseBillVO>();
			ArrayList<String> IDs=service.getIDs1();
			TreeMap<String,PurchaseBillPO> map=service.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<PurchaseReturnBillVO> listPurchaseReturnBills() {
		PurchaseDataService service=RMI.getPurchaseDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<PurchaseReturnBillVO> list=new ArrayList<PurchaseReturnBillVO>();
			ArrayList<String> IDs=service.getIDs2();
			TreeMap<String,PurchaseReturnBillPO> map=service.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<SalesBillVO> listSalesBills() {
		SalesDataService service=RMI.getSalesDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<SalesBillVO> list=new ArrayList<SalesBillVO>();
			ArrayList<String> IDs=service.getIDs1();
			TreeMap<String,SalesBillPO> map=service.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<SalesReturnBillVO> listSalesReturnBills() {
		SalesDataService service=RMI.getSalesDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<SalesReturnBillVO> list=new ArrayList<SalesReturnBillVO>();
			ArrayList<String> IDs=service.getIDs1();
			TreeMap<String,SalesReturnBillPO> map=service.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<ReciptVO> listRecipts() {
		FinanceDataService service=RMI.getFinanceDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<ReciptVO> list=new ArrayList<ReciptVO>();
			ArrayList<String> IDs=service.getReciptIDs();
			TreeMap<String,ReciptPO> map=service.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<PaymentVO> listPayments() {
		FinanceDataService service=RMI.getFinanceDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<PaymentVO> list=new ArrayList<PaymentVO>();
			ArrayList<String> IDs=service.getPaymentIDs();
			TreeMap<String,PaymentPO> map=service.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<ExpenseVO> listExpenses() {
		ExpenseDataService service=RMI.getExpenseDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<ExpenseVO> list=new ArrayList<ExpenseVO>();
			ArrayList<String> IDs=service.getIDs();
			TreeMap<String,ExpensePO> map=service.getDataList();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}
}
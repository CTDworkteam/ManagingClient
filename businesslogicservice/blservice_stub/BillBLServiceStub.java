package blservice_stub;

import java.util.*;
import po.*;
import vo.*;
import convert.Convert;
import dataservice.*;
import enumType.ResultMessage;
import dataservice_stub.*;
public class BillBLServiceStub {
	private AccountDataServiceStub accountdata = new AccountDataServiceStub();
	private StockDataServiceStub stockdata = new StockDataServiceStub();
	private CommodityDataServiceStub commoditydata = new CommodityDataServiceStub();
	private SalesDataServiceStub salesdata = new SalesDataServiceStub();
	private PurchaseDataServiceStub purchasedata = new PurchaseDataServiceStub();
	private ExpenseDataServiceStub expensedata = new ExpenseDataServiceStub();
	private FinanceDataServiceStub financedata = new FinanceDataServiceStub();
	private ClientDataServiceStub clientdata = new ClientDataServiceStub();
	public BillBLServiceStub(){
		
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {
		if(stockdata == null || commoditydata == null){
			return ResultMessage.Failure;
		}
		else{
			if(!stockdata.contain1(vo.getId())) {
				return ResultMessage.No_Exist;
			}
			else {
				GiftBillPO po = stockdata.find1(vo.getId());
				po.setPassed(true);
				stockdata.update(po);
				ArrayList<GiftBillPO.GiftBillItemPO> list=new ArrayList<GiftBillPO.GiftBillItemPO>();
				for(int i=0;i<=list.size()-1;i++){
					CommodityPO commodity = commoditydata.findCommodityInID(list.get(i).getCommodityID());
					for(int j=0;j<=commodity.getList().size()-1;j++){
						if(commodity.getList().get(j).getName().equals(list.get(i).getModel())){
							CommodityPO.CommodityModelPO modelPO=commodity.getList().get(j);
							commodity.getList().remove(j);
							modelPO.setStock(modelPO.getStock()-list.get(i).getNumber());
							commodity.getList().add(modelPO);
						}
					}
					commoditydata.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveOverflowBill(OverflowBillVO vo) {
		if(stockdata == null ||commoditydata == null){
			return ResultMessage.Failure;
		}
		else{
			if(!stockdata.contain2(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				OverflowBillPO po = stockdata.find(vo.getId());
				po.setPassed(true);
				stockdata.update(po);
				CommodityPO commodity = commoditydata.findCommodityInID(po.getId());
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
		if(stockdata == null ||commoditydata == null){
			return ResultMessage.Failure;
		}
		else{
			if(!stockdata.contain2(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				UnderflowBillPO po = stockdata.find2(vo.getId());
				po.setPassed(true);
				stockdata.update(po);
				CommodityPO commodity = commoditydata.findCommodityInID(po.getId());
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
		if(purchasedata == null||commoditydata == null||clientdata == null){
			return ResultMessage.Failure;
		}
		else{
			if(!purchasedata.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PurchaseBillPO bill = purchasedata.find1(vo.getId());
				bill.setPassed(true);
				purchasedata.update(bill);
				ClientPO client = clientdata.find(bill.getSupplier());
				client.setMoneyToPay(client.getMoneyToPay()+bill.getTotal());
				clientdata.update(client);
				Iterator<PurchaseBillPO.PurchaseBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					PurchaseBillPO.PurchaseBillItemPO item = iterator.next();
					CommodityPO  po = commoditydata.findCommodityInID(item.getCommodityID());
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
					commoditydata.update(po);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {
		if(purchasedata==null||commoditydata==null||clientdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(purchasedata.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PurchaseReturnBillPO returnBill = purchasedata.find2(vo.getId());
				returnBill.setPassed(true);
				purchasedata.update(returnBill);
				ClientPO client = clientdata.find(returnBill.getSupplier());
				client.setMoneyToPay(client.getMoneyToPay()-returnBill.getTotal());
				clientdata.update(client);
				Iterator<PurchaseReturnBillPO.PurchaseReturnBillItemPO> iterator=
						returnBill.getList().iterator();
				while(iterator.hasNext()){
					PurchaseReturnBillPO.PurchaseReturnBillItemPO item = iterator.next();
					CommodityPO commodity = commoditydata.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list = commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setStock(list.get(i).getStock()-item.getNumber());
							commodity.setTotal(commodity.getTotal()-item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					commoditydata.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}
	
	public ResultMessage approveSalesBill(SalesBillVO vo) {
		if(salesdata==null||commoditydata==null||clientdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!salesdata.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				SalesBillPO bill=salesdata.find1(vo.getId());
				bill.setPassed(true);
				salesdata.update(bill);
				ClientPO client=clientdata.find(bill.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()+bill.getTotal());
				clientdata.update(client);
				Iterator<SalesBillPO.SalesBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					SalesBillPO.SalesBillItemPO item = iterator.next();
					CommodityPO commodity = commoditydata.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list=commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setRecentRetailPrice(item.getPrice());
							list.get(i).setStock(list.get(i).getStock()-item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					commoditydata.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		if(salesdata==null||commoditydata==null||clientdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!salesdata.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				SalesReturnBillPO bill=salesdata.find2(vo.getId());
				bill.setPassed(true);
				salesdata.update(bill);
				ClientPO client=clientdata.find(bill.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()-bill.getTotal());
				clientdata.update(client);
				Iterator<SalesReturnBillPO.SalesReturnBillItemPO> iterator = bill.getList().iterator();
				while(iterator.hasNext()){
					SalesReturnBillPO.SalesReturnBillItemPO item = iterator.next();
					CommodityPO commodity = commoditydata.findCommodityInID(item.getCommodityID());
					ArrayList<CommodityPO.CommodityModelPO> list=commodity.getList();
					for(int i=0;i<=list.size()-1;i++){
						if(list.get(i).getName().equals(item.getModel())){
							list.get(i).setStock(list.get(i).getStock()+item.getNumber());
							break;
						}
					}
					commodity.setList(list);
					commoditydata.update(commodity);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveRecipt(ReciptVO vo) {
		if(financedata==null||accountdata==null||clientdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(financedata.contain1(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				ReciptPO recipt = financedata.find1(vo.getId());
				recipt.setPassed(true);
				financedata.update(recipt);
				ClientPO client = clientdata.find(recipt.getClientID());
				client.setMoneyReserved(client.getMoneyReserved()-recipt.getTotal());
				clientdata.update(client);
				Iterator<ReciptPO.ReciptItemPO> iterator=recipt.getList().iterator();
				while(iterator.hasNext()){
					ReciptPO.ReciptItemPO item = iterator.next();
					AccountPO account=accountdata.find(item.getAccount());
					account.setMoney(account.getMoney()+item.getMoney());
					accountdata.update(account);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approvePayment(PaymentVO vo) {
		if(financedata==null||accountdata==null||clientdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(financedata.contain1(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				PaymentPO payment = financedata.find2(vo.getId());
				payment.setPassed(true);
				financedata.update(payment);
				ClientPO client = clientdata.find(payment.getClientID());
				client.setMoneyToPay(client.getMoneyToPay()-payment.getTotal());
				clientdata.update(client);
				Iterator<PaymentPO.PaymentItemPO> iterator=payment.getList().iterator();
				while(iterator.hasNext()){
					PaymentPO.PaymentItemPO item=iterator.next();
					AccountPO account=accountdata.find(item.getAccount());
					account.setMoney(account.getMoney()-item.getMoney());
					accountdata.update(account);
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage approveExpense(ExpenseVO vo) {
		if(expensedata==null||accountdata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!expensedata.contain(vo.getId())){
				return ResultMessage.No_Exist;
			}
			else{
				ExpensePO expense=expensedata.find(vo.getId());
				expense.setPassed(true);
				expensedata.update(expense);
				AccountPO account=accountdata.find(expense.getAccountname());
				account.setMoney(account.getMoney()-expense.getTotal());
				accountdata.update(account);
				return ResultMessage.Success;
			}
		}
	}

	public ArrayList<GiftBillVO> listGiftBills() {
		if(stockdata==null){
			return null;
		}
		else{
			ArrayList<GiftBillVO> list=new ArrayList<GiftBillVO>();
			ArrayList<String> IDs=stockdata.getGiftBillIDs();
			TreeMap<String,GiftBillPO> map=stockdata.getGiftBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<OverflowBillVO> listOverflowBills() {
		if(stockdata==null){
			return null;
		}
		else{
			ArrayList<OverflowBillVO> list=new ArrayList<OverflowBillVO>();
			ArrayList<String> IDs=stockdata.getOverflowBillIDs();
			TreeMap<String,OverflowBillPO> map=stockdata.getOverflowBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<UnderflowBillVO> listUnderflowBills() {
		if(stockdata==null){
			return null;
		}
		else{
			ArrayList<UnderflowBillVO> list=new ArrayList<UnderflowBillVO>();
			ArrayList<String> IDs=stockdata.getOverflowBillIDs();
			TreeMap<String,UnderflowBillPO> map=stockdata.getUnderflowBillList();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<PurchaseBillVO> listPurchaseBills() {
		if(purchasedata==null){
			return null;
		}
		else{
			ArrayList<PurchaseBillVO> list=new ArrayList<PurchaseBillVO>();
			ArrayList<String> IDs=purchasedata.getIDs1();
			TreeMap<String,PurchaseBillPO> map=purchasedata.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<PurchaseReturnBillVO> listPurchaseReturnBills() {
		if(purchasedata==null){
			return null;
		}
		else{
			ArrayList<PurchaseReturnBillVO> list=new ArrayList<PurchaseReturnBillVO>();
			ArrayList<String> IDs=purchasedata.getIDs2();
			TreeMap<String,PurchaseReturnBillPO> map=purchasedata.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				if(map.get(IDs.get(i)).isPassed()==false){
					list.add(Convert.convert(map.get(IDs.get(i))));
				}
			}
			return list;
		}
	}

	public ArrayList<SalesBillVO> listSalesBills() {
		if(salesdata==null){
			return null;
		}
		else{
			ArrayList<SalesBillVO> list=new ArrayList<SalesBillVO>();
			ArrayList<String> IDs=salesdata.getIDs1();
			TreeMap<String,SalesBillPO> map=salesdata.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<SalesReturnBillVO> listSalesReturnBills() {
		if(salesdata==null){
			return null;
		}
		else{
			ArrayList<SalesReturnBillVO> list=new ArrayList<SalesReturnBillVO>();
			ArrayList<String> IDs=salesdata.getIDs1();
			TreeMap<String,SalesReturnBillPO> map=salesdata.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<ReciptVO> listRecipts() {
		if(financedata==null){
			return null;
		}
		else{
			ArrayList<ReciptVO> list=new ArrayList<ReciptVO>();
			ArrayList<String> IDs=financedata.getReciptIDs();
			TreeMap<String,ReciptPO> map=financedata.getList1();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<PaymentVO> listPayments() {
		if(financedata==null){
			return null;
		}
		else{
			ArrayList<PaymentVO> list=new ArrayList<PaymentVO>();
			ArrayList<String> IDs=financedata.getPaymentIDs();
			TreeMap<String,PaymentPO> map=financedata.getList2();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}

	public ArrayList<ExpenseVO> listExpenses() {
		if(expensedata==null){
			return null;
		}
		else{
			ArrayList<ExpenseVO> list=new ArrayList<ExpenseVO>();
			ArrayList<String> IDs=expensedata.getIDs();
			TreeMap<String,ExpensePO> map=expensedata.getDataList();
			for(int i=0;i<=IDs.size()-1;i++){
				list.add(Convert.convert(map.get(IDs.get(i))));
			}
			return list;
		}
	}
}
package financecheckbl;
import java.util.*;

import config.RMI;
import convert.Convert;
import po.*;
import po.CommodityPO.CommodityModelPO;
import po.GiftBillPO.GiftBillItemPO;
import po.SalesBillPO.SalesBillItemPO;
import purchasebl.Purchase;
import salesbl.Sales;
import dataservice.*;
import enumType.*;
import expensebl.Expense;
import financebl.Finance;
import utility.Utility;
import vo.*;
import vo.DetailListVO.DetailListItemVO;
import billbl.Bill;
import blservice.*;
public class FinanceCheck implements FinanceCheckBLService{
	public FinanceCheck(){
	}
	
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.contains1(start, end)){
				Iterator<SalesBillPO> i = service.finds1(start, end);
				ArrayList<DetailListItemVO> list2 = new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					ArrayList<SalesBillItemPO> list = sales.getList();
					String date = sales.getId().substring(3,11);
					
					for(int j = 0; j<list.size(); j++){
						list2.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(start.toString(),end.toString(),
						null,null,null,null,list2);
				return result;
			}
			return null;
		}
	}
	
	public DetailListVO getDetailList(String commodity){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containCommodity(commodity)){
				Iterator<SalesBillPO> i = service.findCommodity1(commodity);
				ArrayList<DetailListItemVO> vo = new ArrayList<DetailListItemVO>();
		
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					ArrayList<SalesBillItemPO> list = sales.getList();
					String date = sales.getId().substring(3,11);
					
					for(int j = 0; j<list.size();j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,commodity,
						null,null,null,vo);
				return result;
			}
			return null;
		}
	}
	
	public DetailListVO getDetailList(ClientVO client){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containsClient(client.getId())){
				Iterator<SalesBillPO> i = service.findClient1(client.getId());
				ArrayList<DetailListItemVO> vo = new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
					
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,null,
						client.getName(),null,vo);
				return result;
			}
			return null;
		}
	}

	public DetailListVO getDetailList(UserVO operator){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containsOperator(operator.getName())){
				Iterator<SalesBillPO> i = service.findOperator(operator.getName());
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
				
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,operator.getName(),
						null,null,vo);
				return result;
			}
			return null;
		}
	}


	public DetailListVO getDetailListInStorehouse(String storehouse) {
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containBillsByStorehouse(storehouse)){
				Iterator<SalesBillPO> i = service.findBillsByStorehouse(storehouse);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
				
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,null,
						null,storehouse,vo);
				return result;
			}
			return null;
		}
	}


	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		SalesDataService sales = RMI.getSalesDataService();
		ExpenseDataService expense = RMI.getExpenseDataService();
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		StockDataService stock = RMI.getStockDataService();
		FinanceDataService finance = RMI.getFinanceDataService();

		if(sales == null || expense == null ||
				purchase == null || stock == null || finance == null){
			return null;
		}
		
		else{
			ProcessListVO vo = new ProcessListVO(start.toString(),end.toString(),
					null,null,null,null,null,null,null,null, 
					null, null, null, null, null, null);
			
			Sales s = new Sales();
			ArrayList<SalesBillVO> salesBill = s.findBills(start, end);
			ArrayList<SalesReturnBillVO> salesReBill = s.findReturnBills(start, end);
		
			Purchase p = new Purchase();
			ArrayList<PurchaseBillVO> purchaseBill = p.findBills(start, end);
			ArrayList<PurchaseReturnBillVO> purchaseReturnBill =p.findReturnBills(start, end);
			
			Finance f = new Finance();
			ArrayList<ReciptVO> recipt = f.findRecipts(start, end);
			ArrayList<PaymentVO> payment = f.findPayments(start, end);
			
			Expense e = new Expense();
			ArrayList<ExpenseVO> expen = e.findByCalendar(start, end);
			
			ArrayList<OverflowBillVO> overflow = new ArrayList<OverflowBillVO>();
			Iterator<OverflowBillPO> of = stock.finds(start, end);
			while(of.hasNext()){
				overflow.add(Convert.convert(of.next()));
			}
			
			ArrayList<UnderflowBillVO> underflow = new ArrayList<UnderflowBillVO>();
			Iterator<UnderflowBillPO> uf = stock.finds2(start, end);
			while(uf.hasNext()){
				underflow.add(Convert.convert(uf.next()));
			}
			
			ArrayList<GiftBillVO> giftBill = new ArrayList<GiftBillVO>();
			Iterator<GiftBillPO> gb = stock.finds1(start,end);
			while(gb.hasNext())
				giftBill.add(Convert.convert(gb.next()));
			
			vo.setList1(salesBill);
			vo.setList2(salesReBill);
			vo.setList3(purchaseBill);
			vo.setList4(purchaseReturnBill);
			vo.setList5(recipt);
			vo.setList6(payment);
			vo.setList7(expen);
			vo.setList8(overflow);
			vo.setList9(underflow);
			vo.setList10(giftBill);
			
			return vo;
		}	
	}

	public ProcessListVO getProcessList(BillType type) {
		switch(type){
		case SalesBill:{
			ArrayList<SalesBillVO> l = calSales();
			return new ProcessListVO(null,null,type,null,null,
					null,l, null, null, null,
					null, null, null, null, null, null);
		}
		case SalesReturnBill:{
			ArrayList<SalesReturnBillVO> l = calSalesRe();
			return new ProcessListVO(null,null,type,null,null,
					null,null,l,  null, null,
					null, null, null, null, null, null);
		}
		case PurchaseBill:{
			ArrayList<PurchaseBillVO> l = calPurchase();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null,l, null,
					null, null, null, null, null, null);
		}
		case PurchaseReturnBill:{
			ArrayList<PurchaseReturnBillVO> l = calPuchaseRe();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,l,
					null, null, null, null, null, null);
		}
		case FinanceReciptBill:{
			ArrayList<ReciptVO> l = calRecipt();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					l, null, null, null, null, null);
		}
		case FinancePaymentBill:{
			ArrayList<PaymentVO> l =calPayment();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					null,l, null, null, null, null);
		}
		case FinanceExpenseBill:{
			ArrayList<ExpenseVO> l = calExpense();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					null,null, l, null, null, null);
		}
		case StockOverflowBill:{
			ArrayList<OverflowBillVO> l = calOverflow();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					null,null, null,l, null, null);
		}
		case StockUnderflowBill:{
			ArrayList<UnderflowBillVO> l =calUnderflow();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					null,null, null,null,l, null);
		}
		case StockGiftBill:{
			ArrayList<GiftBillVO> l = calGiftBill();
			return new ProcessListVO(null,null,type,null,null,
					null,null, null, null,null,
					null,null, null,null, null,l);
		}
		default:
			return null;
		}
	}

	private ArrayList<GiftBillVO> calGiftBill() {
		StockDataService stock = RMI.getStockDataService();
		
		if(stock == null)
			return null;
		else{
			ArrayList<GiftBillVO> l = new ArrayList<GiftBillVO>();
			TreeMap<String, GiftBillPO> list = stock.getGiftBillList();
			Iterator<GiftBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<UnderflowBillVO> calUnderflow() {
		StockDataService stock = RMI.getStockDataService();
		
		if(stock == null)
			return null;
		else{
			ArrayList<UnderflowBillVO> l = new ArrayList<UnderflowBillVO>();
			TreeMap<String, UnderflowBillPO> list = stock.getUnderflowBillList();
			Iterator<UnderflowBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<OverflowBillVO> calOverflow() {
		StockDataService stock = RMI.getStockDataService();
		
		if(stock == null)
			return null;
		else{
			ArrayList<OverflowBillVO> l = new ArrayList<OverflowBillVO>();
			TreeMap<String, OverflowBillPO> list = stock.getOverflowBillList();
			Iterator<OverflowBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<ExpenseVO> calExpense() {
		ExpenseDataService expense = RMI.getExpenseDataService();
		if(expense == null)
			return null;
		else{
			ArrayList<ExpenseVO> l = new ArrayList<ExpenseVO>();
			TreeMap<String, ExpensePO> list = expense.getDataList();
			Iterator<ExpensePO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<PaymentVO> calPayment() {
		FinanceDataService finance = RMI.getFinanceDataService();
		if(finance == null)
			return null;
		else{
			ArrayList<PaymentVO> l =new ArrayList<PaymentVO>();
			TreeMap<String, PaymentPO> list = finance.getList2();
			Iterator<PaymentPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<ReciptVO> calRecipt() {
		FinanceDataService finance = RMI.getFinanceDataService();
		if(finance == null)
			return null;
		else{
			ArrayList<ReciptVO> l =new ArrayList<ReciptVO>();
			TreeMap<String, ReciptPO> list = finance.getList1();
			Iterator<ReciptPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<PurchaseReturnBillVO> calPuchaseRe() {
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		
		if(purchase == null)
			return null;
		else{
			ArrayList<PurchaseReturnBillVO> l = new ArrayList<PurchaseReturnBillVO>();
			TreeMap<String, PurchaseReturnBillPO> list = purchase.getList2();
			Iterator<PurchaseReturnBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<PurchaseBillVO> calPurchase() {
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		
		if(purchase == null)
			return null;
		else{
			ArrayList<PurchaseBillVO> l = new ArrayList<PurchaseBillVO>();
			TreeMap<String, PurchaseBillPO> list = purchase.getList1();
			Iterator<PurchaseBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	private ArrayList<SalesBillVO> calSales(){
		SalesDataService sales = RMI.getSalesDataService();
		
		if(sales == null)
			return null;
		else{
			ArrayList<SalesBillVO> l = new ArrayList<SalesBillVO>();
			TreeMap<String, SalesBillPO> list = sales.getList1();
			Iterator<SalesBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}
	
	private ArrayList<SalesReturnBillVO> calSalesRe(){
		SalesDataService sales = RMI.getSalesDataService();
		
		if(sales == null)
			return null;
		else{
			ArrayList<SalesReturnBillVO> l = new ArrayList<SalesReturnBillVO>();
			TreeMap<String, SalesReturnBillPO> list = sales.getList2();
			Iterator<SalesReturnBillPO> i = list.values().iterator();
			while(i.hasNext())
				l.add(Convert.convert(i.next()));
			return l;
		}
	}

	public ProcessListVO getProcessList(UserVO operator) {
		SalesDataService sales = RMI.getSalesDataService();
		ExpenseDataService expense = RMI.getExpenseDataService();
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		StockDataService stock = RMI.getStockDataService();
		FinanceDataService finance = RMI.getFinanceDataService();

		if(sales == null || expense == null ||
				purchase == null || stock == null || finance == null){
			return null;
		}
		else{
			ProcessListVO vo = new ProcessListVO(null,null,null,operator.getName(),null,
					null,null, null, null,null,
					null,null, null,null, null,null);
			ArrayList<SalesBillVO> list = new ArrayList<SalesBillVO>();
			Iterator<SalesBillPO> i = sales.findOperator(operator.getName());
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			vo.setList1(list);
			
			ArrayList<SalesReturnBillVO> list2 = new ArrayList<SalesReturnBillVO>();
			Iterator<SalesReturnBillPO> is = sales.findOperator2(operator.getName());
			while(is.hasNext())
				list2.add(Convert.convert(is.next()));
			vo.setList2(list2);
			
			ArrayList<PurchaseBillVO> list3 = new ArrayList<PurchaseBillVO>();
			TreeMap<String, PurchaseBillPO> l = purchase.getList1();
			Iterator<PurchaseBillPO> ip = l.values().iterator();
			while(ip.hasNext()){
				if(ip.next().getOperator().equals(operator.getName())){
					list3.add(Convert.convert(ip.next()));
				}
			}
			vo.setList3(list3);
			
			ArrayList<PurchaseReturnBillVO> list4 = new ArrayList<PurchaseReturnBillVO>();
			TreeMap<String, PurchaseReturnBillPO> pr = purchase.getList2();
			Iterator<PurchaseReturnBillPO> ipr = pr.values().iterator();
			while(ipr.hasNext()){
				if(ipr.next().getOperator().equals(operator.getName())){
					list4.add(Convert.convert(ipr.next()));
				}
			}
			vo.setList4(list4);
			
			ArrayList<ReciptVO> list5 = new ArrayList<ReciptVO>();
			TreeMap<String, ReciptPO> recipt = finance.getList1();
			Iterator<ReciptPO> re = recipt.values().iterator();
			while(re.hasNext()){
				if(re.next().getOperator().equals(operator.getName()))
					list5.add(Convert.convert(re.next()));
			}
			vo.setList5(list5);
			
			ArrayList<PaymentVO> list6 = new ArrayList<PaymentVO>();
			TreeMap<String, PaymentPO> payment = finance.getList2();
			Iterator<PaymentPO> pay = payment.values().iterator();
			while(pay.hasNext()){
				if(pay.next().getOperator().equals(operator.getId()))
					list6.add(Convert.convert(pay.next()));
			}
			vo.setList6(list6);
			
			ArrayList<ExpenseVO> list7 = new ArrayList<ExpenseVO>();
			TreeMap<String, ExpensePO> expen = expense.getDataList();
			Iterator<ExpensePO> ex = expen.values().iterator();
			while(ex.hasNext()){
				if(ex.next().getOperator().equals(operator.getName()))
					list7.add(Convert.convert(ex.next()));
			}
			vo.setList7(list7);
			
			ArrayList<OverflowBillVO> list8 = new ArrayList<OverflowBillVO>();
			TreeMap<String, OverflowBillPO> overflow = stock.getOverflowBillList();
			Iterator<OverflowBillPO> over = overflow.values().iterator();
			while(over.hasNext()){
				if(over.next().getOperator().equals(operator.getName()))
					list8.add(Convert.convert(over.next()));
			}
			vo.setList8(list8);
			
			ArrayList<UnderflowBillVO> list9 = new ArrayList<UnderflowBillVO>();
			TreeMap<String, UnderflowBillPO> underflow = stock.getUnderflowBillList();
			Iterator<UnderflowBillPO> under = underflow.values().iterator();
			while(under.hasNext()){
				if(under.next().getOperator().equals(operator.getName()))
					list9.add(Convert.convert(under.next()));
			}
			vo.setList9(list9);
			
			ArrayList<GiftBillVO> list10= new ArrayList<GiftBillVO>();
			TreeMap<String, GiftBillPO> gift = stock.getGiftBillList();
			Iterator<GiftBillPO> gi = gift.values().iterator();
			while(gi.hasNext()){
				if(gi.next().getOperator().equals(operator.getName()))
					list10.add(Convert.convert(gi.next()));
			}
			vo.setList10(list10);
			return vo;
		}
	}


	public ProcessListVO getProcessList(ClientVO client) {
		SalesDataService sales = RMI.getSalesDataService();
		ExpenseDataService expense = RMI.getExpenseDataService();
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		StockDataService stock = RMI.getStockDataService();
		FinanceDataService finance = RMI.getFinanceDataService();

		if(sales == null || expense == null ||
				purchase == null || stock == null || finance == null){
			return null;
		}
		else{
			ProcessListVO vo = new ProcessListVO(null,null,null,client.getName(),null,
					null,null, null, null,null,
					null,null, null,null, null,null);
			ArrayList<SalesBillVO> list = new ArrayList<SalesBillVO>();
			Iterator<SalesBillPO> i = sales.findClient1(client.getId());
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			vo.setList1(list);
			
			ArrayList<SalesReturnBillVO> list2 = new ArrayList<SalesReturnBillVO>();
			Iterator<SalesReturnBillPO> is = sales.findClient2(client.getId());
			while(is.hasNext())
				list2.add(Convert.convert(is.next()));
			vo.setList2(list2);
			
			ArrayList<PurchaseBillVO> list3 = new ArrayList<PurchaseBillVO>();
			TreeMap<String, PurchaseBillPO> l = purchase.getList1();
			Iterator<PurchaseBillPO> ip = l.values().iterator();
			while(ip.hasNext()){
				if(ip.next().getSupplier().equals(client.getName())){
					list3.add(Convert.convert(ip.next()));
				}
			}
			vo.setList3(list3);
			
			ArrayList<PurchaseReturnBillVO> list4 = new ArrayList<PurchaseReturnBillVO>();
			TreeMap<String, PurchaseReturnBillPO> pr = purchase.getList2();
			Iterator<PurchaseReturnBillPO> ipr = pr.values().iterator();
			while(ipr.hasNext()){
				if(ipr.next().getSupplier().equals(client.getName())){
					list4.add(Convert.convert(ipr.next()));
				}
			}
			vo.setList4(list4);
			
			ArrayList<ReciptVO> list5 = new ArrayList<ReciptVO>();
			TreeMap<String, ReciptPO> recipt = finance.getList1();
			Iterator<ReciptPO> re = recipt.values().iterator();
			while(re.hasNext()){
				if(re.next().getClientID()==client.getId())
					list5.add(Convert.convert(re.next()));
			}
			vo.setList5(list5);
			
			ArrayList<PaymentVO> list6 = new ArrayList<PaymentVO>();
			TreeMap<String, PaymentPO> payment = finance.getList2();
			Iterator<PaymentPO> pay = payment.values().iterator();
			while(pay.hasNext()){
				if(pay.next().getClientID()==client.getId())
					list6.add(Convert.convert(pay.next()));
			}
			vo.setList6(list6);
			
			ArrayList<GiftBillVO> list10= new ArrayList<GiftBillVO>();
			TreeMap<String, GiftBillPO> gift = stock.getGiftBillList();
			Iterator<GiftBillPO> gi = gift.values().iterator();
			while(gi.hasNext()){
				if(gi.next().getClientID()==client.getId())
					list10.add(Convert.convert(gi.next()));
			}
			vo.setList10(list10);
			return vo;
		}
	}

	public ProcessListVO getProcessList(String storehouse) {
		SalesDataService sales = RMI.getSalesDataService();
		ExpenseDataService expense = RMI.getExpenseDataService();
		PurchaseDataService purchase = RMI.getPurchaseDataService();
		StockDataService stock = RMI.getStockDataService();
		FinanceDataService finance = RMI.getFinanceDataService();

		if(sales == null || expense == null ||
				purchase == null || stock == null || finance == null){
			return null;
		}
		else{
			ProcessListVO vo = new ProcessListVO(null,null,null,null,null,
					storehouse,null, null, null,null,
					null,null, null,null, null,null);
			ArrayList<SalesBillVO> list = new ArrayList<SalesBillVO>();
			Iterator<SalesBillPO> i = sales.findBillsByStorehouse(storehouse);
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			vo.setList1(list);
			
			ArrayList<SalesReturnBillVO> list2 = new ArrayList<SalesReturnBillVO>();
			Iterator<SalesReturnBillPO> is = sales.findReturnBillsByStorehouse(storehouse);
			while(is.hasNext())
				list2.add(Convert.convert(is.next()));
			vo.setList2(list2);
			
			ArrayList<PurchaseBillVO> list3 = new ArrayList<PurchaseBillVO>();
			TreeMap<String, PurchaseBillPO> l = purchase.getList1();
			Iterator<PurchaseBillPO> ip = l.values().iterator();
			while(ip.hasNext()){
				if(ip.next().getStorehouse().equals(storehouse)){
					list3.add(Convert.convert(ip.next()));
				}
			}
			vo.setList3(list3);
			
			ArrayList<PurchaseReturnBillVO> list4 = new ArrayList<PurchaseReturnBillVO>();
			TreeMap<String, PurchaseReturnBillPO> pr = purchase.getList2();
			Iterator<PurchaseReturnBillPO> ipr = pr.values().iterator();
			while(ipr.hasNext()){
				if(ipr.next().getStorehouse().equals(storehouse)){
					list4.add(Convert.convert(ipr.next()));
				}
			}
			vo.setList4(list4);
			
			ArrayList<OverflowBillVO> list8 = new ArrayList<OverflowBillVO>();
			TreeMap<String, OverflowBillPO> overflow = stock.getOverflowBillList();
			Iterator<OverflowBillPO> over = overflow.values().iterator();
			while(over.hasNext()){
				if(over.next().getStorehouse().equals(storehouse))
					list8.add(Convert.convert(over.next()));
			}
			vo.setList8(list8);
			
			ArrayList<UnderflowBillVO> list9 = new ArrayList<UnderflowBillVO>();
			TreeMap<String, UnderflowBillPO> underflow = stock.getUnderflowBillList();
			Iterator<UnderflowBillPO> under = underflow.values().iterator();
			while(under.hasNext()){
				if(under.next().getStorehouse().equals(storehouse))
					list9.add(Convert.convert(under.next()));
			}
			vo.setList9(list9);
			
			ArrayList<GiftBillVO> list10= new ArrayList<GiftBillVO>();
			TreeMap<String, GiftBillPO> gift = stock.getGiftBillList();
			Iterator<GiftBillPO> gi = gift.values().iterator();
			while(gi.hasNext()){
				if(gi.next().getStorehouse().equals(storehouse))
					list10.add(Convert.convert(gi.next()));
			}
			vo.setList10(list10);
			return vo;
		}
	}

	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		SalesDataService s = RMI.getSalesDataService();
		CommodityDataService c = RMI.getCommodityDataService();
		StockDataService st = RMI.getStockDataService();
		PurchaseDataService p = RMI.getPurchaseDataService();
		
		if(s == null || c == null|| st == null || p == null)
			return null;
		else{
			double salesIn=0.0;
			double VoucherIn=0.0;
			double discount=0.0;
			double total=0.0;
			Iterator<SalesBillPO> i = s.finds1(start, end);
			while(i.hasNext()){
				salesIn+=i.next().getInitialTotal();
				VoucherIn+=i.next().getVoucher();
				discount+=i.next().getDiscount();
				total+=i.next().getTotal();
			}
			double overflowIn=0.0;
			Iterator<OverflowBillPO> iof = st.finds(start, end);
			while(iof.hasNext()){
				CommodityPO temp = c.findCommodityInID(iof.next().getCommodityID());
				ArrayList<CommodityModelPO> list = temp.getList();
				for(int j=0;j<list.size();j++){
					if(list.get(j).getName().equals(iof.next().getModel())){
						overflowIn+=list.get(j).getRecentRetailPrice()*
							(iof.next().getActualNumber()-iof.next().getRecordNumber());
						break;
					}
				}
			}
			InVO in = new InVO(salesIn, overflowIn, 0, 0, VoucherIn, discount, total);
			
			double salesBase=0.0;
			double purchaseTotal=0.0;
			Iterator<PurchaseBillPO> ip = p.finds1(start, end);
			while(ip.hasNext()){
				salesBase+=ip.next().getTotal();
				purchaseTotal+=ip.next().getTotal();
			}
			double underflowOut=0.0;
			double giftOut=0.0;
			Iterator<UnderflowBillPO> iuf = st.finds2(start, end);
			while(iuf.hasNext()){
				CommodityPO temp = c.findCommodityInID(iuf.next().getCommodityID());
				ArrayList<CommodityModelPO> list = temp.getList();
				for(int j=0;j<list.size();j++){
					if(list.get(j).getName().equals(iuf.next().getModel())){
						underflowOut+=list.get(j).getRecentPurchasePrice()*
								(iuf.next().getRecordNumber()-iuf.next().getActualNumber());
						break;
					}
				}
			}
			Iterator<GiftBillPO> ig = st.finds1(start, end);
			while(ig.hasNext()){
				ArrayList<GiftBillItemPO> list = ig.next().getList();
				for(int j=0;j<list.size();j++){
					CommodityPO temp = c.findCommodityInID(list.get(j).getCommodityID());
					ArrayList<CommodityModelPO> l = temp.getList();
					for(int k=0;k<l.size();k++){
						if(l.get(k).getName().equals(list.get(j).getModel())){
							giftOut+=list.get(j).getNumber()*l.get(k).getRecentPurchasePrice();
						}
					}
				}
			}
			OutVO out = new OutVO(salesBase, underflowOut, giftOut, purchaseTotal);
			
			return new ConditionListVO(start.toString(),end.toString(),
					in, out,total-purchaseTotal);
		}
	}

	/*private OutVO calculate2(GregorianCalendar start, GregorianCalendar end) {
		
	}

	private InVO calculate(GregorianCalendar start, GregorianCalendar end) {
		SalesDataService s = RMI.getSalesDataService();
		StockDataService st = RMI.getStockDataService();
		
		if(s == null || st == null){
			return null;
		}
		
		else{
			InVO in = new InVO(0, 0, 0, 0, 0, 0, 0);
			Iterator<SalesBillPO> i = s.finds1(start, end);
			Iterator<SalesReturnBillPO> j = s.finds2(start, end);
			double total = 0;
			while(i.hasNext()){
				total+=i.next().getTotal();
			}
			while(j.hasNext()){
				total-=j.next().getTotal();
			}
			in.setSalesIn(total);
			
			Iterator<OverflowBillPO> over = st.finds(start, end);
		}
	}
*/
	public ResultMessage export(ProcessListVO list, String dest) {
	/*	try{
			String s = dest+".xls";
			WritableWorkbook book1 = Workbook.createWorkbook(new File(s));
			WritableSheet sheet = book1.createSheet("经营历程表",0);
			ArrayList<Label> llist = new ArrayList<Label>();
			llist.add(new Label(0,0,"单据编号"));
			llist.add(new Label(0,1,"客户"));
			llist.add(new Label(0,2,"业务员"));
			llist.add(new Label(0,3,"操作员"));
			llist.add(new Label(0,4,"仓库"));
			llist.add(new Label(0,5,"折让前总额"));
			llist.add(new Label(0,6,"折让"));
			llist.add(new Label(0,7,"使用代金卷金额"));
			llist.add(new Label(0,8,"折让后总额"));
			llist.add(new Label(0,9,"备注"));
			llist.add(new Label(0,10,"入库商品列表"));
			for(int i=0;i<llist.size();i++)
				sheet.addCell(llist.get(i));
			
			ArrayList<SalesBillVO> l = list.getList1();
			for(int i=0; i<l.size();i++){
				Label temp = new Label(i+1,0,l.get(i).getId());
				Label temp2 = new Label(i+1,1,l.get(i).getClient());
				Label temp3 = new Label(i+1,2,l.get(i).getDefaultOperator());
				Label temp4 = new Label(i+1,3,l.get(i).getOperator());
				Label temp5 = new Label(i+1,4,l.get(i).getStorehouse());
				jxl.write.Number temp6 = new jxl.write.Number(i+1,5,l.get(i).getInitialTotal());
				jxl.write.Number temp7 = new jxl.write.Number(i+1,6,l.get(i).getDiscount());
				jxl.write.Number temp8 = new jxl.write.Number(i+1,7,l.get(i).getVoucher());
				jxl.write.Number temp9 = new jxl.write.Number(i+1,8,l.get(i).getTotal());
				Label temp10 = new Label(i+1,9,l.get(i).getNote());
				for(int j=0;j<l.get(i).getList().size();j++){
					
				}
			}
		}*/
		return ResultMessage.Success;
	}


	public ResultMessage export(ConditionListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}


	public ResultMessage export(DetailListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}


	public ResultMessage deficitInvoice(SalesBillVO vo) {
		SalesDataService sales = RMI.getSalesDataService();
		
		if(sales == null){
			return ResultMessage.Failure;
		}
		else{
			SalesBillPO result = sales.find1(vo.getId());
			ArrayList<SalesBillPO.SalesBillItemPO> item = result.getList();
			for(int i=0; i<item.size();i++){
				item.get(i).setNumber(-item.get(i).getNumber());
			}
			result.setList(item);
			result.setId("XSD"+Utility.getDate()+
					Utility.getIntegerString(sales.numberOfBills(Utility.getDate())
					+1,5));
			result.setTotal(-vo.getTotal());
			sales.insert(result);
			Bill bill = new Bill();
			SalesBillVO temp = Convert.convert(result);
			if(bill.approveSalesBill(temp).equals(ResultMessage.Success))
				return ResultMessage.Success;
			return ResultMessage.Failure;
		}
	}


	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		SalesDataService sales = RMI.getSalesDataService();
		
		if(sales == null){
			return ResultMessage.Failure;
		}
		else{
			SalesReturnBillPO result = sales.find2(vo.getId());
			ArrayList<SalesReturnBillPO.SalesReturnBillItemPO> item = result.getList();
			
			for(int i=0; i<item.size();i++){
				item.get(i).setNumber(-item.get(i).getNumber());
			}
			result.setList(item);
			result.setId("XSTHD"+Utility.getDate()+
					Utility.getIntegerString(sales.numberOfReturnBills(Utility.getDate())
					+1,5));
			result.setTotal(-vo.getTotal());
			sales.insert(result);
			Bill bill = new Bill();
			SalesReturnBillVO temp = Convert.convert(result);
			if(bill.approveSalesReturnBill(temp)==ResultMessage.Success)
				return ResultMessage.Success;
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		PurchaseDataService service1 = RMI.getPurchaseDataService();
		
		if(service1==null){
			return ResultMessage.Failure;
		}
		else{
			PurchaseBillPO bill = service1.find1(vo.getId());
			ArrayList<PurchaseBillPO.PurchaseBillItemPO> item = bill.getList();
			for(int i=0; i<item.size();i++){
				item.get(i).setNumber(-item.get(i).getNumber());
			}
			bill.setList(item);
			bill.setId("JHD"+Utility.getDate()+
					Utility.getIntegerString(service1.numberOfBills(Utility.getDate())
					+1,5));
			bill.setTotal(-bill.getTotal());
			service1.insert(bill);
			Bill b = new Bill();
			PurchaseBillVO temp = Convert.convert(bill);
			if(b.approvePurchaseBill(temp)==ResultMessage.Success)
				return ResultMessage.Success;
			return ResultMessage.Failure;
		}
	}


	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		PurchaseDataService service1 = RMI.getPurchaseDataService();
		
		if(service1==null){
			return ResultMessage.Failure;
		}
		else{
			PurchaseReturnBillPO bill = service1.find2(vo.getId());
			ArrayList<PurchaseReturnBillPO.PurchaseReturnBillItemPO> item = bill.getList();
			for(int i=0; i<item.size();i++){
				item.get(i).setNumber(-item.get(i).getNumber());
			}
			bill.setList(item);
			bill.setId("JHTHD"+Utility.getDate()+
					Utility.getIntegerString(service1.numberOfBills(Utility.getDate())
					+1,5));
			bill.setTotal(-bill.getTotal());
			service1.insert(bill);
			Bill b = new Bill();
			PurchaseReturnBillVO temp = Convert.convert(bill);
			if(b.approvePurchaseReturnBill(temp)==ResultMessage.Success)
				return ResultMessage.Success;
			return ResultMessage.Failure;
		}
	}


	public ResultMessage deficitInvoice(ReciptVO vo) {
		FinanceDataService finance = RMI.getFinanceDataService();
		
		if(finance == null){
			return ResultMessage.Failure;
		}
		else{
			ReciptPO recipt = finance.find1(vo.getId());
			ArrayList<ReciptPO.ReciptItemPO> item = recipt.getList();
			for(int i=0;i<item.size();i++){
				item.get(i).setMoney(-item.get(i).getMoney());
			}
			recipt.setList(item);
			recipt.setId("SKD"+Utility.getDate()+
					Utility.getIntegerString(finance.numberOfRecipts(Utility.getDate())
							+1, 5));
			recipt.setTotal(-recipt.getTotal());
			finance.insert(recipt);
			Bill b = new Bill();
			ReciptVO temp = Convert.convert(recipt);
			if(b.approveRecipt(temp)==ResultMessage.Failure)
				return ResultMessage.Failure;
			return ResultMessage.Success;
		}
	}


	public ResultMessage deficitInvoice(PaymentVO vo) {
		FinanceDataService finance = RMI.getFinanceDataService();
		
		if(finance == null){
			return ResultMessage.Failure;
		}
		else{
			PaymentPO payment = finance.find2(vo.getId());
			ArrayList<PaymentPO.PaymentItemPO> item = payment.getList();
			for(int i=0;i<item.size();i++){
				item.get(i).setMoney(-item.get(i).getMoney());
			}
			payment.setList(item);
			payment.setId("FKD"+Utility.getDate()+
					Utility.getIntegerString(finance.numberOfPayments(Utility.getDate())
							+1, 5));
			payment.setTotal(-payment.getTotal());
			finance.insert(payment);
			Bill b = new Bill();
			PaymentVO temp = Convert.convert(payment);
			if(b.approvePayment(temp)==ResultMessage.Failure)
				return ResultMessage.Failure;
			return ResultMessage.Success;
		}
	}


	public ResultMessage deficitInvoice(ExpenseVO vo) {
		ExpenseDataService expense = RMI.getExpenseDataService();
		
		if(expense == null)
			return ResultMessage.Failure;
		else{
			ExpensePO ex = expense.find(vo.getId());
			ArrayList<ExpensePO.ExpenseItemPO> item = ex.getList();
			for(int i=0;i<item.size();i++){
				item.get(i).setMoney(-item.get(i).getMoney());
			}
			ex.setList(item);
			ex.setId("XJXFD"+Utility.getDate()+
					Utility.getIntegerString(expense.numberOfExpenses(Utility.getDate())
							+1, 5));
			ex.setTotal(-ex.getTotal());
			Bill b = new Bill();
			ExpenseVO temp = Convert.convert(ex);
			if(b.approveExpense(temp)==ResultMessage.Failure)
				return ResultMessage.Failure;
			return ResultMessage.Success;
		}
	}

	public ResultMessage deficitInvoice(GiftBillVO vo) {
		StockDataService stock = RMI.getStockDataService();
		
		if(stock == null){
			return ResultMessage.Failure;
		}
		else{
			GiftBillPO gift = stock.find1(vo.getId());
			ArrayList<GiftBillPO.GiftBillItemPO> item = gift.getList();
			for(int i=0;i<item.size();i++){
				item.get(i).setNumber(-item.get(i).getNumber());
			}
			gift.setList(item);
			gift.setId("ZS"+Utility.getDate()+
					Utility.getIntegerString(stock.numberOfGiftBills(Utility.getDate())
							+1, 5));
			Bill b = new Bill();
			GiftBillVO temp = Convert.convert(gift);
			if(b.approveGiftBill(temp)==ResultMessage.Failure)
				return ResultMessage.Failure;
			return ResultMessage.Success;
		}
	}
}

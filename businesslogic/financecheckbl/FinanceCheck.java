package financecheckbl;
import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import config.RMI;
import convert.Convert;
import po.ExpensePO;
import po.GiftBillPO;
import po.OverflowBillPO;
import po.PaymentPO;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import po.ReciptPO;
import po.SalesBillPO;
import po.SalesBillPO.SalesBillItemPO;
import po.SalesReturnBillPO;
import po.UnderflowBillPO;
import purchasebl.Purchase;
import salesbl.Sales;
import dataservice.*;
import enumType.*;
import expensebl.Expense;
import financebl.Finance;
import vo.*;
import vo.DetailListVO.DetailListItemVO;
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
		
		ConditionListVO result = new ConditionListVO(start.toString(),
				end.toString(),null,null,0);
		//InVO in = calculate(start,end);
		//OutVO out = calculate2(start,end);
		
		Iterator<SalesBillPO> i = s.finds1(start, end);
		Iterator<SalesReturnBillPO> j = s.finds2(start, end);
		double total = 0;
		while(i.hasNext()){
			total+=i.next().getTotal();
		}
		while(j.hasNext()){
			total-=j.next().getTotal();
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
		try{
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
		}
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

	@Override
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ReciptVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PaymentVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
}

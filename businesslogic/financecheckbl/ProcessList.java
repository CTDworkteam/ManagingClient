package financecheckbl;
import java.util.*;
import enumType.*;
import stockbl.*;
import salesbl.*;
import purchasebl.*;
import financebl.*;
import expensebl.*;
import clientbl.*;
import userbl.*;
public class ProcessList{
	public GregorianCalendar start;
	public GregorianCalendar end;
	public BillType billtype;
	public Client client;
	public User operator;
	public String storehouse;
	public ArrayList<SalesBill> list1;
	public ArrayList<SalesReturnBill> list2;
	public ArrayList<PurchaseBill> list3;
	public ArrayList<PurchaseReturnBill> list4;
	public ArrayList<Recipt> list5;
	public ArrayList<Payment> list6;
	public ArrayList<Expense> list7;
	public ArrayList<OverflowBill> list8;
	public ArrayList<UnderflowBill> list9;
	public ArrayList<GiftBill> list10;
	public ProcessList(GregorianCalendar start, GregorianCalendar end,
			BillType billtype, Client client, User operator, String storehouse,
			ArrayList<SalesBill> list1, ArrayList<SalesReturnBill> list2,
			ArrayList<PurchaseBill> list3, ArrayList<PurchaseReturnBill> list4,
			ArrayList<Recipt> list5, ArrayList<Payment> list6,
			ArrayList<Expense> list7, ArrayList<OverflowBill> list8,
			ArrayList<UnderflowBill> list9, ArrayList<GiftBill> list10) {
		super();
		this.start = start;
		this.end = end;
		this.billtype = billtype;
		this.client = client;
		this.operator = operator;
		this.storehouse = storehouse;
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
		this.list4 = list4;
		this.list5 = list5;
		this.list6 = list6;
		this.list7 = list7;
		this.list8 = list8;
		this.list9 = list9;
		this.list10 = list10;
	}
	
}
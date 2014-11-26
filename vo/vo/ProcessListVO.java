package vo;

import enumType.BillType;

import java.util.*;
public class ProcessListVO {
	private String start;
	private String end;
	private BillType billtype;
	private String client;
	private String operator;
	private String storehouse;
	private ArrayList<SalesBillVO> list1;
	private ArrayList<SalesReturnBillVO> list2;
	private ArrayList<PurchaseBillVO> list3;
	private ArrayList<PurchaseReturnBillVO> list4;
	private ArrayList<ReciptVO> list5;
	private ArrayList<PaymentVO> list6;
	private ArrayList<ExpenseVO> list7;
	private ArrayList<OverflowBillVO> list8;
	private ArrayList<UnderflowBillVO> list9;
	private ArrayList<GiftBillVO> list10;
	public ProcessListVO(String start, String end, BillType billtype,
			String client, String operator, String storehouse,
			ArrayList<SalesBillVO> list1, ArrayList<SalesReturnBillVO> list2,
			ArrayList<PurchaseBillVO> list3,
			ArrayList<PurchaseReturnBillVO> list4, ArrayList<ReciptVO> list5,
			ArrayList<PaymentVO> list6, ArrayList<ExpenseVO> list7,
			ArrayList<OverflowBillVO> list8, ArrayList<UnderflowBillVO> list9,
			ArrayList<GiftBillVO> list10) {
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
	public ProcessListVO() {
		this.start=null;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public BillType getBilltype() {
		return billtype;
	}
	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public ArrayList<SalesBillVO> getList1() {
		return list1;
	}
	public void setList1(ArrayList<SalesBillVO> list1) {
		this.list1 = list1;
	}
	public ArrayList<SalesReturnBillVO> getList2() {
		return list2;
	}
	public void setList2(ArrayList<SalesReturnBillVO> list2) {
		this.list2 = list2;
	}
	public ArrayList<PurchaseBillVO> getList3() {
		return list3;
	}
	public void setList3(ArrayList<PurchaseBillVO> list3) {
		this.list3 = list3;
	}
	public ArrayList<PurchaseReturnBillVO> getList4() {
		return list4;
	}
	public void setList4(ArrayList<PurchaseReturnBillVO> list4) {
		this.list4 = list4;
	}
	public ArrayList<ReciptVO> getList5() {
		return list5;
	}
	public void setList5(ArrayList<ReciptVO> list5) {
		this.list5 = list5;
	}
	public ArrayList<PaymentVO> getList6() {
		return list6;
	}
	public void setList6(ArrayList<PaymentVO> list6) {
		this.list6 = list6;
	}
	public ArrayList<ExpenseVO> getList7() {
		return list7;
	}
	public void setList7(ArrayList<ExpenseVO> list7) {
		this.list7 = list7;
	}
	public ArrayList<OverflowBillVO> getList8() {
		return list8;
	}
	public void setList8(ArrayList<OverflowBillVO> list8) {
		this.list8 = list8;
	}
	public ArrayList<UnderflowBillVO> getList9() {
		return list9;
	}
	public void setList9(ArrayList<UnderflowBillVO> list9) {
		this.list9 = list9;
	}
	public ArrayList<GiftBillVO> getList10() {
		return list10;
	}
	public void setList10(ArrayList<GiftBillVO> list10) {
		this.list10 = list10;
	}
}

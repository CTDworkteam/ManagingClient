package billbl;

import vo.*;
import enumType.ResultMessage;
import blservice.BillBLService;
public class BillController implements BillBLService{
	private Bill bill;
	public BillController(){
		bill=new Bill();
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {
		return bill.approveGiftBill(vo);
	}
	public ResultMessage approveOverflowBill(OverflowBillVO vo) {
		return bill.approveOverflowBill(vo);
	}
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {
		return bill.approveUnderflowBill(vo);
	}
	public ResultMessage approvePurchaseBill(PurchaseBillVO vo) {
		return bill.approvePurchaseBill(vo);
	}
	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {
		return bill.approvePurchaseReturnBill(vo);
	}
	public ResultMessage approveSalesBill(SalesBillVO vo) {
		return bill.approveSalesBill(vo);
	}
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		return bill.approveSalesReturnBill(vo);
	}
	public ResultMessage approveRecipt(ReciptVO vo) {
		return bill.approveRecipt(vo);
	}
	public ResultMessage approvePayment(PaymentVO vo) {
		return bill.approvePayment(vo);
	}
	public ResultMessage approveExpense(ExpenseVO vo) {
		return bill.approveExpense(vo);
	}
}
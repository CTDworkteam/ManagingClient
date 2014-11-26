package blservice;
import vo.*;
import enumType.*;
public interface BillBLService {
	public ResultMessage approveGiftBill(GiftBillVO vo);
	public ResultMessage updateGiftBill(GiftBillVO vo);
	public ResultMessage approveOverflowBill(OverflowBillVO vo);
	public ResultMessage updateOverflowBill(OverflowBillVO vo);
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo);
	public ResultMessage updateUnderflowBill(UnderflowBillVO vo);
	public ResultMessage approvePurchaseBill(PurchaseBillVO vo);
	public ResultMessage updatePurchaseBill(PurchaseBillVO vo);
	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo);
	public ResultMessage updatePurchaseReturnBill(PurchaseReturnBillVO vo);
	public ResultMessage approveSalesBill(SalesBillVO vo);
	public ResultMessage updateSalesBill(SalesBillVO vo);
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo);
	public ResultMessage updateSalesReturnBill(SalesBillVO vo);
	public ResultMessage approveRecipt(ReciptVO vo);
	public ResultMessage updateRecipt(ReciptVO vo);
	public ResultMessage approvePayment(PaymentVO vo);
	public ResultMessage updatePayment(PaymentVO vo);
	public ResultMessage approveExpense(ExpenseVO vo);
	public ResultMessage updateExpense(ExpenseVO vo);
}

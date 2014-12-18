package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface BillBLService {
	public ResultMessage approveGiftBill(GiftBillVO vo);
	public ResultMessage approveOverflowBill(OverflowBillVO vo);
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo);
	public ResultMessage approvePurchaseBill(PurchaseBillVO vo);
	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo);
	public ResultMessage approveSalesBill(SalesBillVO vo);
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo);
	public ResultMessage approveRecipt(ReciptVO vo);
	public ResultMessage approvePayment(PaymentVO vo);
	public ResultMessage approveExpense(ExpenseVO vo);
	public ArrayList<GiftBillVO> listGiftBills();
	public ArrayList<OverflowBillVO> listOverflowBills();
	public ArrayList<UnderflowBillVO> listUnderflowBills();
	public ArrayList<PurchaseBillVO> listPurchaseBills();
	public ArrayList<PurchaseReturnBillVO> listPurchaseReturnBills();
	public ArrayList<SalesBillVO> listSalesBills();
	public ArrayList<SalesReturnBillVO> listSalesReturnBills();
	public ArrayList<ReciptVO> listRecipts();
	public ArrayList<PaymentVO> listPayments();
	public ArrayList<ExpenseVO> listExpenses();
}

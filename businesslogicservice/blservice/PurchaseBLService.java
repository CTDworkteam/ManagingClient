package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface PurchaseBLService {
	public ResultMessage addBill(PurchaseBillVO vo);
	public ResultMessage addReturnBill(PurchaseReturnBillVO vo);
	public ResultMessage deleteBill(PurchaseBillVO vo);
	public ResultMessage deleteReturnBill(PurchaseReturnBillVO vo);
	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills);
	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills);
	public ResultMessage save();
	public ResultMessage executeBill(PurchaseBillVO bill);
	public ResultMessage executeBill(PurchaseReturnBillVO bill);
}

package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface PurchaseBLService {
	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills);
	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills);
	public ResultMessage save(PurchaseBillVO vo);
	public ResultMessage save(PurchaseReturnBillVO vo);
	public ResultMessage executeBill(PurchaseBillVO bill);
	public ResultMessage executeBill(PurchaseReturnBillVO bill);
	public ArrayList<PurchaseBillVO> findBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<PurchaseReturnBillVO> findReturnBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<PurchaseBillVO> getAllBills();
	public ArrayList<PurchaseReturnBillVO> getAllReturnBills();
}

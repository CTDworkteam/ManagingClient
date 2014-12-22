package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface SalesBLService {
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills);
	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills);
	public ResultMessage save(SalesBillVO vo);
	public ResultMessage save(SalesReturnBillVO vo);
	public ResultMessage executeBill(SalesBillVO bill);
	public ResultMessage executeReturnBill(SalesReturnBillVO bill);
	public ArrayList<SalesBillVO> findBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<SalesReturnBillVO> findReturnBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<SalesBillVO> getAllBills();
	public ArrayList<SalesReturnBillVO> getAllReturnBills();
	public String getNewBillID(GregorianCalendar date);
	public String getNewReturnBillID(GregorianCalendar date);
}

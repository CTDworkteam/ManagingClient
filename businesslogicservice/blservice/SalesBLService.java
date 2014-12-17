package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface SalesBLService {
<<<<<<< HEAD
/*	public ResultMessage addBill(SalesBillVO vo);
	public ResultMessage addReturnBill(SalesReturnBillVO vo);
	public ResultMessage deleteBill(SalesBillVO vo);
	public ResultMessage deleteReturnBill(SalesReturnBillVO vo);*/
=======
>>>>>>> refs/remotes/origin/master
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills);
	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills);
	public ResultMessage save(SalesBillVO vo);
	public ResultMessage save(SalesReturnBillVO vo);
<<<<<<< HEAD
	public ResultMessage executeBill(SalesBillVO bill);
	public ResultMessage executeReturnBill(SalesReturnBillVO bill);
=======
	public ArrayList<SalesBillVO> findBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<SalesReturnBillVO> findReturnBills(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<SalesBillVO> getAllBills();
	public ArrayList<SalesReturnBillVO> getAllReturnBills();
>>>>>>> refs/remotes/origin/master
}

package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface SalesBLService {
	public ResultMessage addBill(SalesBillVO vo);
	public ResultMessage addReturnBill(SalesReturnBillVO vo);
	public ResultMessage deleteBill(SalesBillVO vo);
	public ResultMessage deleteReturnBill(SalesReturnBillVO vo);
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills);
	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills);
	public ResultMessage save();
	public ResultMessage executeBill(SalesBillVO bill);
	public ResultMessage executeReturnBill(SalesReturnBillVO bill);
}

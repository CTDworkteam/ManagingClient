package salesbl;
import java.util.ArrayList;
import vo.*;
import enumType.ResultMessage;
import blservice.SalesBLService;
public class SalesController implements SalesBLService{
	public Sales sales;
	public SalesController(){
		sales=new Sales();
	}
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills) {
		return sales.sendBill(bills);
	}
	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills) {
		return sales.sendReturnBill(bills);
	}
	public ResultMessage save(SalesBillVO vo) {
		return sales.save(vo);
	}
	public ResultMessage save(SalesReturnBillVO vo) {
		return sales.save(vo);
	}
	public ResultMessage executeBill(SalesBillVO bill) {
		return sales.executeBill(bill);
	}
	public ResultMessage executeReturnBill(SalesReturnBillVO bill) {
		return sales.executeReturnBill(bill);
	}	
}
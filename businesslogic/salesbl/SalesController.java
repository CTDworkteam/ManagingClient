package salesbl;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	@Override
	public ArrayList<SalesBillVO> findBills(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesBillVO> getAllBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesReturnBillVO> getAllReturnBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getNewBillID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getNewReturnBillID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}	
}
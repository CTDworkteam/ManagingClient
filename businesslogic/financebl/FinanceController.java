package financebl;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import vo.PaymentVO;
import vo.ReciptVO;
import enumType.ResultMessage;
import blservice.*;
public class FinanceController implements FinanceBLService{
	public Finance finance;
	public FinanceController(){
		finance=new Finance();
	}
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills) {
		return finance.sendRecipt(bills);
	}
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills) {
		return finance.sendPayment(bills);
	}
	public ResultMessage save(ReciptVO vo) {
		return finance.save(vo);
	}
	public ResultMessage save(PaymentVO vo) {
		return finance.save(vo);
	}
	public ResultMessage executeBill(ReciptVO bill) {
		return finance.executeBill(bill);
	}
	public ResultMessage executeReturnBill(PaymentVO bill) {
		return finance.executeReturnBill(bill);
	}
	@Override
	public ReciptVO findRecipt(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PaymentVO findPayment(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReciptVO> findRecipts(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PaymentVO> findPayments(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReciptVO> getAllRecipts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PaymentVO> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}

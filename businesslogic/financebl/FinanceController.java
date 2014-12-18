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
	
	public ReciptVO findRecipt(String id) {
		return finance.findRecipt(id);
	}
	
	public PaymentVO findPayment(String id) {
		return finance.findPayment(id);
	}
	
	public ArrayList<ReciptVO> findRecipts(GregorianCalendar before,
			GregorianCalendar after) {
		return finance.findRecipts(before, after);
	}
	
	public ArrayList<PaymentVO> findPayments(GregorianCalendar before,
			GregorianCalendar after) {
		return finance.findPayments(before, after);
	}
	
	public ArrayList<ReciptVO> getAllRecipts() {
		return finance.getAllRecipts();
	}
	
	public ArrayList<PaymentVO> getAllPayments() {
		return finance.getAllPayments();
	}

}

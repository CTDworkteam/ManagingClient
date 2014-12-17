package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface FinanceBLService {
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills);
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills);
	public ResultMessage save(ReciptVO vo);
	public ResultMessage save(PaymentVO vo);
	public ReciptVO findRecipt(String id);
	public PaymentVO findPayment(String id);
	public ArrayList<ReciptVO> findRecipts(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<PaymentVO> findPayments(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<ReciptVO> getAllRecipts();
	public ArrayList<PaymentVO> getAllPayments();
}

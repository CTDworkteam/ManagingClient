package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface FinanceBLService {
<<<<<<< HEAD
/*	public ResultMessage addRecipt(ReciptVO vo);
	public ResultMessage addPayment(PaymentVO vo);
	public ResultMessage deleteRecipt(ReciptVO vo);
	public ResultMessage deletePayment(PaymentVO vo);*/
=======
>>>>>>> refs/remotes/origin/master
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills);
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills);
	public ResultMessage save(ReciptVO vo);
	public ResultMessage save(PaymentVO vo);
<<<<<<< HEAD
	public ResultMessage executeBill(ReciptVO bill);
	public ResultMessage executeReturnBill(PaymentVO bill);
=======
	public ReciptVO findRecipt(String id);
	public PaymentVO findPayment(String id);
	public ArrayList<ReciptVO> findRecipts(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<PaymentVO> findPayments(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<ReciptVO> getAllRecipts();
	public ArrayList<PaymentVO> getAllPayments();
>>>>>>> refs/remotes/origin/master
}

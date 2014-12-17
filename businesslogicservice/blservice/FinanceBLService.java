package blservice;
import vo.*;
import enumType.*;

import java.util.*;
public interface FinanceBLService {
/*	public ResultMessage addRecipt(ReciptVO vo);
	public ResultMessage addPayment(PaymentVO vo);
	public ResultMessage deleteRecipt(ReciptVO vo);
	public ResultMessage deletePayment(PaymentVO vo);*/
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills);
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills);
	public ResultMessage save(ReciptVO vo);
	public ResultMessage save(PaymentVO vo);
	public ResultMessage executeBill(ReciptVO bill);
	public ResultMessage executeReturnBill(PaymentVO bill);
}

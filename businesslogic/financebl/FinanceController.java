package financebl;
import java.util.ArrayList;
import vo.PaymentVO;
import vo.ReciptVO;
import enumType.ResultMessage;
import blservice.*;
public class FinanceController implements FinanceBLService{

	@Override
	public ResultMessage addRecipt(ReciptVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addPayment(PaymentVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deleteRecipt(ReciptVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deletePayment(PaymentVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage save() {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public ResultMessage executeBill(ReciptVO bill) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage executeReturnBill(PaymentVO bill) {
		// TODO 自动生成的方法存根
		return null;
	}

}

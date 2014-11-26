package financecheckbl;
import java.util.GregorianCalendar;

import vo.ClientVO;
import vo.ConditionListVO;
import vo.DetailListVO;
import vo.ExpenseVO;
import vo.GiftBillVO;
import vo.PaymentVO;
import vo.ProcessListVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReciptVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UserVO;
import enumType.BillType;
import enumType.ResultMessage;
import blservice.*;
public class FinanceCheckController implements FinanceCheckBLService{

	@Override
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DetailListVO getDetailList(String commodity) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DetailListVO getDetailList(ClientVO client) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DetailListVO getDetailList(UserVO operator) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(BillType type) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(UserVO operator) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(ClientVO client) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(String storehouse) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(ProcessListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(ConditionListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(DetailListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ReciptVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PaymentVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

}

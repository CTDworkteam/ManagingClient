package financecheckbl;
import java.util.GregorianCalendar;
import enumType.*;
import userbl.*;
import vo.*;
import blservice.*;
public class FinanceCheck implements FinanceCheckBLService{
	public User operator;

	@Override
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public DetailListVO getDetailList(String commodity) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public DetailListVO getDetailList(ClientVO client) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public DetailListVO getDetailList(UserVO operator) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ProcessListVO getProcessList(BillType type) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ProcessListVO getProcessList(UserVO operator) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ProcessListVO getProcessList(ClientVO client) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ProcessListVO getProcessList(String storehouse) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage export(ProcessListVO list, String dest) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage export(ConditionListVO list, String dest) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage export(DetailListVO list, String dest) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ReciptVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PaymentVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}

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
	public FinanceCheck check;
	public FinanceCheckController(){
		check=new FinanceCheck();
	}
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getDetailList(start, end);
	}
	public DetailListVO getDetailList(String commodity) {
		return check.getDetailList(commodity);
	}
	public DetailListVO getDetailList(ClientVO client) {
		return check.getDetailList(client);
	}
	public DetailListVO getDetailList(UserVO operator) {
		return check.getDetailList(operator);
	}
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		return check.getDetailListInStorehouse(storehouse);
	}
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getProcessList(start,end);
	}
	public ProcessListVO getProcessList(BillType type) {
		return check.getProcessList(type);
	}
	public ProcessListVO getProcessList(UserVO operator) {
		return check.getProcessList(operator);
	}
	public ProcessListVO getProcessList(ClientVO client) {
		return check.getProcessList(client);
	}
	public ProcessListVO getProcessList(String storehouse) {
		return check.getProcessList(storehouse);
	}
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getConditionList(start,end);
	}
	public ResultMessage export(ProcessListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage export(ConditionListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage export(DetailListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		return check.deficitInvoice(vo);
	}
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(ReciptVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PaymentVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		return check.defictInvoice(vo);
	}
}

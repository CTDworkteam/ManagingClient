package blservice;
import vo.*;
import java.util.*;
import enumType.*;
public interface FinanceCheckBLService {
	public DetailListVO getDetailList(GregorianCalendar start,GregorianCalendar end);
	public DetailListVO getDetailList(String commodity);
	public DetailListVO getDetailList(ClientVO client);
	public DetailListVO getDetailList(UserVO operator);
	public DetailListVO getDetailListInStorehouse(String storehouse);
	public ProcessListVO getProcessList(GregorianCalendar start,GregorianCalendar end);
	public ProcessListVO getProcessList(BillType type);		    
	public ProcessListVO getProcessList(UserVO operator);		  
	public ProcessListVO getProcessList(ClientVO client);		    
	public ProcessListVO getProcessList(String storehouse);		    
	public ConditionListVO getConditionList(GregorianCalendar start,GregorianCalendar end);
	public ResultMessage export(ProcessListVO list,String dest);
	public ResultMessage export(ConditionListVO list,String dest);
    public ResultMessage export(DetailListVO list,String dest);
	public ResultMessage deficitInvoice(SalesBillVO vo);
	public ResultMessage deficitInvoice(SalesReturnBillVO vo);
	public ResultMessage deficitInvoice(PurchaseBillVO vo);
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo);
	public ResultMessage deficitInvoice(ReciptVO vo);
	public ResultMessage deficitInvoice(PaymentVO vo);
	public ResultMessage deficitInvoice(ExpenseVO vo);
	public ResultMessage deficitInvoice(GiftBillVO vo);
}

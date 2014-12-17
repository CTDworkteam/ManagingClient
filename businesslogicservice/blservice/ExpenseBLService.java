package blservice;
import vo.*;
import enumType.*;
public interface ExpenseBLService {
//	public ResultMessage add(ExpenseVO vo);
//	public ResultMessage delete(ExpenseVO vo);   
	public ResultMessage save(ExpenseVO vo);
	public ResultMessage send(ExpenseVO vo);
	public ResultMessage execute(ExpenseVO vo);
}

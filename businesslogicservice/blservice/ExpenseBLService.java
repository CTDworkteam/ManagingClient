package blservice;
import vo.*;
import enumType.*;
<<<<<<< HEAD
public interface ExpenseBLService {
//	public ResultMessage add(ExpenseVO vo);
//	public ResultMessage delete(ExpenseVO vo);   
=======
import java.util.*;
public interface ExpenseBLService { 
>>>>>>> refs/remotes/origin/master
	public ResultMessage save(ExpenseVO vo);
	public ResultMessage send(ExpenseVO vo);
	public ExpenseVO find(String id);
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<ExpenseVO> getList();
}

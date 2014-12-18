package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface ExpenseBLService { 
	public ResultMessage save(ExpenseVO vo);
	public ResultMessage send(ExpenseVO vo);
	public ExpenseVO find(String id);
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<ExpenseVO> getList();
	public String getNewID(GregorianCalendar date);
}

package dataservice;
import java.util.*;
import po.ExpensePO;
public interface ExpenseDataService {
	public void insert(ExpensePO po);
	public boolean contain(String id);
	public void delete(ExpensePO po);
	public void update(ExpensePO po);
	public ExpensePO find(String id);
	public Iterator<ExpensePO> finds(GregorianCalendar before,GregorianCalendar after);
	public ArrayList<String> getIDs();
	public TreeMap<String,ExpensePO> getDataList();
	public boolean hasExpenses();
	public void init();
	public void save();
}

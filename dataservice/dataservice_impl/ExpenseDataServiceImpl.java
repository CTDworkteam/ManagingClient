package dataservice_impl;
import java.util.*;
import comparator.ExpenseComparator;
import po.ExpensePO;
import dataservice.ExpenseDataService;
public class ExpenseDataServiceImpl implements ExpenseDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3409996638566095223L;
	private Map<String,ExpensePO> list;
	private List<String> IDs;
	public ExpenseDataServiceImpl(){
		list=new TreeMap<String,ExpensePO>();
		IDs=new ArrayList<String>();
	}
	public ExpenseDataServiceImpl(TreeMap<String,ExpensePO> map,ArrayList<String> ids){
		list = map;
		IDs = ids;
	}
	public void insert(ExpensePO po) {
		IDs.add(po.getId());
		list.put(po.getId(),po);
	}
	public boolean contain(String id) {
		return list.get(id)==null?false:true;
	}
	public void delete(ExpensePO po) {
		list.remove(po.getId());
		Iterator<String> iterator=IDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(ExpensePO po) {
		delete(po);
		insert(po);
	}
	public ExpensePO find(String id) {
		return list.get(id);
	}
	public Iterator<ExpensePO> finds(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<ExpensePO> set=new TreeSet<ExpensePO>(new ExpenseComparator());
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=IDs.size()-1;i++){
			dateString=list.get(IDs.get(i)).getId().substring(5,13);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				set.add(list.get(IDs.get(i)));
			}
		}
		return set.descendingIterator();
	}
	public ArrayList<String> getIDs() {
		Iterator<String> iter = IDs.iterator();
		ArrayList<String> output = new ArrayList<String>();
		while(iter.hasNext()){
			output.add(iter.next());
		}
		return output;
	}
	public TreeMap<String, ExpensePO> getDataList() {
		TreeMap<String,ExpensePO> map = new TreeMap<String,ExpensePO>();
		Iterator<String> iter = IDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID,list.get(ID));
		}
		return map;
	}
	public boolean hasExpenses() {
		return list.size()==0?false:true;
	}
	public int numberOfExpenses(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = IDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(5,13);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count++;
			}
		}
		return count;
	}
}
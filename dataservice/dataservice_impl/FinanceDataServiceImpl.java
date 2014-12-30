package dataservice_impl;
import java.util.*;
import comparator.PaymentComparator;
import comparator.ReciptComparator;
import po.*;
import dataservice.FinanceDataService;
public class FinanceDataServiceImpl implements FinanceDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 908629851491475276L;
	private Map<String,ReciptPO> recipts;
	private Map<String,PaymentPO> payments;
	private List<String> reciptIDs;
	private List<String> paymentIDs;
	public FinanceDataServiceImpl(){
		recipts=new TreeMap<String,ReciptPO>();
		payments=new TreeMap<String,PaymentPO>();
		reciptIDs=new ArrayList<String>();
		paymentIDs=new ArrayList<String>();
	}
	public FinanceDataServiceImpl(TreeMap<String,ReciptPO> map1,TreeMap<String,PaymentPO> map2,
			ArrayList<String> list1,ArrayList<String> list2){
		recipts = map1;
		payments = map2;
		reciptIDs = list1;
		paymentIDs = list2;
	}
	public void insert(ReciptPO po) {
		recipts.put(po.getId(),po);
		reciptIDs.add(po.getId());
	}
	public void delete(ReciptPO po) {
		recipts.remove(po.getId());
		Iterator<String> iterator=reciptIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(ReciptPO po) {
		delete(po);
		insert(po);
	}
	public boolean contain1(String id) {
		return recipts.get(id)==null?false:true;
	}
	public GregorianCalendar getDate(String id){
		String dateString=id.substring(3,11);
		GregorianCalendar date=new GregorianCalendar();
		date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
		date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
		date.set(Calendar.MONTH,new Integer(dateString.substring(6,8)).intValue());
		return date;
	}
	public boolean contains1(GregorianCalendar start, GregorianCalendar end) {
		ReciptPO po=null;
		GregorianCalendar date=null;
		for(int i=0;i<=reciptIDs.size()-1;i++){
			po=recipts.get(reciptIDs.get(i));
			date=getDate(po.getId());
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public ReciptPO find1(String id) {
		return recipts.get(id);
	}
	public Iterator<ReciptPO> finds1(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<ReciptPO> treeset=new TreeSet<ReciptPO>(new ReciptComparator());
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=reciptIDs.size()-1;i++){
			date=getDate(recipts.get(reciptIDs.get(i)).getId());
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				treeset.add(recipts.get(reciptIDs.get(i)));
			}
		}
		return treeset.descendingIterator();
	}
	public TreeMap<String, ReciptPO> getList1() {
		TreeMap<String,ReciptPO> map = new TreeMap<String,ReciptPO>();
		Iterator<String> iter = reciptIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID,recipts.get(ID));
		}
		return map;
	}
	public ArrayList<String> getReciptIDs() {
		ArrayList<String> output = new ArrayList<String>();
		Iterator<String> iter = reciptIDs.iterator();
		while(iter.hasNext()){
			output.add(iter.next());
		}
		return output;
	}
	public boolean hasRecipts() {
		return recipts.size()==0?false:true;
	}
	public void insert(PaymentPO po) {
		payments.put(po.getId(),po);
		paymentIDs.add(po.getId());
	}
	public void delete(PaymentPO po) {
		payments.remove(po.getId());
		Iterator<String> iterator=paymentIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(PaymentPO po) {
		delete(po);
		insert(po);
	}
	public boolean contain2(String id) {
		return payments.get(id)==null?false:true;
	}
	public boolean contains2(GregorianCalendar start, GregorianCalendar end) {
		GregorianCalendar date=new GregorianCalendar();
		PaymentPO po=null;
		for(int i=0;i<=paymentIDs.size()-1;i++){
			po=payments.get(paymentIDs.get(i));
			date=getDate(po.getId());
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public PaymentPO find2(String id) {
		return payments.get(id);
	}
	public Iterator<PaymentPO> finds2(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<PaymentPO> treeset=new TreeSet<PaymentPO>(new PaymentComparator());
		GregorianCalendar date=new GregorianCalendar();
		PaymentPO po=null;
		for(int i=0;i<=paymentIDs.size()-1;i++){
			date=getDate(paymentIDs.get(i));
			po=payments.get(paymentIDs.get(i));
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				treeset.add(po);
			}
		}
		return treeset.descendingIterator();
	}
	public TreeMap<String, PaymentPO> getList2() {
		TreeMap<String,PaymentPO> map = new TreeMap<String,PaymentPO>();
		Iterator<String> iter = paymentIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID,payments.get(ID));
		}
		return map;
	}
	public ArrayList<String> getPaymentIDs() {
		ArrayList<String> output = new ArrayList<String>();
		Iterator<String> iter = paymentIDs.iterator();
		while(iter.hasNext()){
			output.add(iter.next());
		}
		return output;
	}
	public boolean hasPayments() {
		return payments.size()==0?false:true;
	}
	
	public int numberOfRecipts(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = reciptIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(3,11);
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
	public int numberOfPayments(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = paymentIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(3,11);
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
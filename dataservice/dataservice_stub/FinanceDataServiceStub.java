package dataservice_stub;
import java.util.*;
import po.PaymentPO;
import po.ReciptPO;
import comparator.PaymentComparator;
import comparator.ReciptComparator;
import dataservice.*;
public class FinanceDataServiceStub implements FinanceDataService{
	private Map<String,ReciptPO> recipts;
	private Map<String,PaymentPO> payments;
	private List<String> reciptIDs;
	private List<String> paymentIDs;
	public FinanceDataServiceStub(){
		recipts=new TreeMap<String,ReciptPO>();
		payments=new TreeMap<String,PaymentPO>();
		reciptIDs=new ArrayList<String>();
		paymentIDs=new ArrayList<String>();
		
		reciptIDs.add("SKD2014122900001");
		reciptIDs.add("SKD2014122900002");
		paymentIDs.add("FKD2014122900001");
		paymentIDs.add("FKD2014122900002");
		
		ArrayList<ReciptPO.ReciptItemPO> list1 = new ArrayList<ReciptPO.ReciptItemPO>();
		ArrayList<ReciptPO.ReciptItemPO> list2 = new ArrayList<ReciptPO.ReciptItemPO>();
		ArrayList<PaymentPO.PaymentItemPO> list3 = new ArrayList<PaymentPO.PaymentItemPO>();
		ArrayList<PaymentPO.PaymentItemPO> list4 = new ArrayList<PaymentPO.PaymentItemPO>();
		
		list1.add(new ReciptPO().new ReciptItemPO("工行账户",1000,"balabala"));
		list1.add(new ReciptPO().new ReciptItemPO("农行账户",1000,"balabala"));
		list2.add(new ReciptPO().new ReciptItemPO("工行账户",300,"balabala"));
		list2.add(new ReciptPO().new ReciptItemPO("农行账户",500,"balabala"));
		list3.add(new PaymentPO().new PaymentItemPO("工行账户",100,"balabala"));
		list3.add(new PaymentPO().new PaymentItemPO("农行账户",1000,"balabala"));
		list4.add(new PaymentPO().new PaymentItemPO("工行账户",300,"balbalba"));
		list4.add(new PaymentPO().new PaymentItemPO("农行账户",500,"balabala"));
		
		ReciptPO recipt1 = new ReciptPO(false,"SKD2014122900001",2,"马云",list1,2000);
		ReciptPO recipt2 = new ReciptPO(false,"SKD2014122900002",2,"马云",list2,800);
		PaymentPO payment1 = new PaymentPO(false,"FKD2014122900001","马云",3,list3,1100);
		PaymentPO payment2 = new PaymentPO(false,"FKD2014122900002","马云",1,list4,800);
		
		recipts.put(recipt1.getId(), recipt1);
		recipts.put(recipt2.getId(), recipt2);
		payments.put(payment1.getId(), payment1);
		payments.put(payment2.getId(),payment2);
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

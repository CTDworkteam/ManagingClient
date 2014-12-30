package dataservice_impl;
import java.util.*;
import comparator.PurchaseBillComparator;
import comparator.PurchaseReturnBillComparator;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import dataservice.PurchaseDataService;
public class PurchaseDataServiceImpl implements PurchaseDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424975583231013344L;
	private Map<String,PurchaseBillPO> bills;
	private Map<String,PurchaseReturnBillPO> returnbills;
	private List<String> billIDs;
	private List<String> returnbillIDs;
	public PurchaseDataServiceImpl(){
		bills=new TreeMap<String,PurchaseBillPO>();
		returnbills=new TreeMap<String,PurchaseReturnBillPO>();
		billIDs=new ArrayList<String>();
		returnbillIDs=new ArrayList<String>();
	}
	public PurchaseDataServiceImpl(TreeMap<String,PurchaseBillPO> map1,TreeMap<String,PurchaseReturnBillPO> map2,
			ArrayList<String> list1,ArrayList<String> list2){
		bills = map1;
		returnbills = map2;
		billIDs = list1;
		returnbillIDs = list2;
	}
	public void insert(PurchaseBillPO po) {
		bills.put(po.getId(),po);
		billIDs.add(po.getId());
	}
	public boolean contain(String id) {
		String type=id.substring(0,3);
		if(type.equals("JHD")){
			return bills.get(type)==null?false:true;
		}
		else{
			return returnbills.get(type+"HD")==null?false:true;
		}
	}
	public void delete(PurchaseBillPO po) {
		bills.remove(po.getId());
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(PurchaseBillPO po) {
		delete(po);
		insert(po);
	}
	public PurchaseBillPO find1(String id) {
		return bills.get(id);
	}
	public PurchaseReturnBillPO find2(String id) {
		return returnbills.get(id);
	}
	public void insert(PurchaseReturnBillPO po) {
		returnbills.put(po.getId(),po);
		returnbillIDs.add(po.getId());
	}
	public void delete(PurchaseReturnBillPO po) {
		returnbills.remove(po.getId());
		Iterator<String> iterator=returnbillIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(PurchaseReturnBillPO po) {
		delete(po);
		insert(po);
	}
	public boolean contains1(GregorianCalendar start, GregorianCalendar end) {
		GregorianCalendar date=new GregorianCalendar();
		String dateString=null;
		for(int i=0;i<=billIDs.size()-1;i++){
			dateString=billIDs.get(i).substring(3,11);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public boolean contains2(GregorianCalendar start, GregorianCalendar end) {
		GregorianCalendar date=new GregorianCalendar();
		String dateString=null;
		for(int i=0;i<=returnbillIDs.size()-1;i++){
			dateString=returnbillIDs.get(i).substring(3,11);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public Iterator<PurchaseBillPO> finds1(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<PurchaseBillPO> treeset=new TreeSet<PurchaseBillPO>(new PurchaseBillComparator());
		GregorianCalendar date=new GregorianCalendar();
		String dateString=null;
		for(int i=0;i<=billIDs.size()-1;i++){
			dateString=billIDs.get(i).substring(3,11);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				treeset.add(bills.get(billIDs.get(i)));
			}
		}
		return treeset.descendingIterator();
	}
	public Iterator<PurchaseReturnBillPO> finds2(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<PurchaseReturnBillPO> treeset=new TreeSet<PurchaseReturnBillPO>(new PurchaseReturnBillComparator());
		GregorianCalendar date=new GregorianCalendar();
		String dateString=null;
		for(int i=0;i<=returnbillIDs.size()-1;i++){
			dateString=returnbillIDs.get(i).substring(3,11);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				treeset.add(returnbills.get(returnbillIDs.get(i)));
			}
		}
		return treeset.descendingIterator();
	}
	public TreeMap<String, PurchaseBillPO> getList1() {
		TreeMap<String,PurchaseBillPO> map = new TreeMap<String,PurchaseBillPO>();
		Iterator<String> iter = billIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, bills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getIDs1() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = billIDs.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public TreeMap<String, PurchaseReturnBillPO> getList2() {
		TreeMap<String,PurchaseReturnBillPO> map = new TreeMap<String,PurchaseReturnBillPO>();
		Iterator<String> iter = returnbillIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, returnbills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getIDs2() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = returnbillIDs.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public boolean hasBills() {
		return bills.size()==0?false:true;
	}
	public boolean hasReturnBills() {
		return returnbills.size()==0?false:true;
	}
	
	public int numberOfBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = billIDs.iterator();
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
	public int numberOfReturnBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = returnbillIDs.iterator();
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
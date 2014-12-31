package dataservice_stub;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;

import comparator.PurchaseBillComparator;
import comparator.PurchaseReturnBillComparator;

import dataservice.*;
public class PurchaseDataServiceStub implements PurchaseDataService{
	private Map<String,PurchaseBillPO> bills;
	private Map<String,PurchaseReturnBillPO> returnbills;
	private List<String> billIDs;
	private List<String> returnbillIDs;
	public PurchaseDataServiceStub(){
		/*false:JHD2014122900001:张三:南京仓库:王一琦:balabala:2010300000000002,SR601,20,330,hehe
false:JHD2014123000001:张三:上海仓库:王一琦:balabala:2010100000000001,SR102,15,250,balabala
false:JHD2014123000002:张三:北京仓库:王一琦:balabala:2010300000000001,SR502,5,300,balabala*/
		ArrayList<String> IDs = new ArrayList<String>();
		ArrayList<String> returnIDs = new ArrayList<String>();
		TreeMap<String,PurchaseBillPO> map1 = new TreeMap<String,PurchaseBillPO>();
		TreeMap<String,PurchaseReturnBillPO> map2 = new TreeMap<String,PurchaseReturnBillPO>();
		////
		bills = map1;
		returnbills = map2;
		billIDs = IDs;
		returnbillIDs = returnIDs;
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
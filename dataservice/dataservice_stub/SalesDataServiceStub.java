package dataservice_stub;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import po.SalesBillPO;
import po.SalesReturnBillPO;

import comparator.SalesBillComparator;
import comparator.SalesReturnBillComparator;

import dataservice.*;
public class SalesDataServiceStub implements SalesDataService{
	private static final long serialVersionUID = 5253425497612135444L;
	private Map<String,SalesBillPO> bills;
	private List<String> billIDs;
	private Map<String,SalesReturnBillPO> returnbills;
	private List<String> returnbillIDs;
	public SalesDataServiceImpl() {
		bills=new TreeMap<String,SalesBillPO>();
		returnbills=new TreeMap<String,SalesReturnBillPO>();
		billIDs=new ArrayList<String>();
		returnbillIDs=new ArrayList<String>();
	}
	public SalesDataServiceImpl(TreeMap<String,SalesBillPO> map1,TreeMap<String,SalesReturnBillPO> map2,
			ArrayList<String> list1,ArrayList<String> list2){
		bills = map1;
		returnbills = map2;
		billIDs = list1;
		returnbillIDs = list2;
	}
	public void insert(SalesBillPO po) {
		bills.put(po.getId(),po);
		billIDs.add(po.getId());
	}
	public boolean contain(String id) {
		String type=id.substring(0,3);
		if(type.equals("XSD")){
			return bills.get(type)==null?false:true;
		}
		else{
			return returnbills.get(type+"HD")==null?false:true;
		}
	}
	public void delete(SalesBillPO po) {
		bills.remove(po.getId());
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(SalesBillPO po) {
		delete(po);
		insert(po);
		
	}
	public SalesBillPO find1(String id) {
		return bills.get(id);
	}
	public SalesReturnBillPO find2(String id) {
		return returnbills.get(id);
	}
	public void insert(SalesReturnBillPO po) {
		returnbills.put(po.getId(),po);
		returnbillIDs.add(po.getId());
	}
	public void delete(SalesReturnBillPO po) {
		returnbills.remove(po.getId());
		Iterator<String> iterator=returnbillIDs.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(SalesReturnBillPO po) {
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
	public Iterator<SalesBillPO> finds1(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<SalesBillPO> treeset=new TreeSet<SalesBillPO>(new SalesBillComparator());
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
	public Iterator<SalesReturnBillPO> finds2(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<SalesReturnBillPO> treeset=new TreeSet<SalesReturnBillPO>(new SalesReturnBillComparator());
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
	public TreeMap<String, SalesBillPO> getList1() {
		TreeMap<String,SalesBillPO> map = new TreeMap<String,SalesBillPO>();
		Iterator<String> iter = billIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID,bills.get(ID));
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
	public TreeMap<String, SalesReturnBillPO> getList2() {
		TreeMap<String,SalesReturnBillPO> map = new TreeMap<String,SalesReturnBillPO>();
		Iterator<String> iter = billIDs.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID,returnbills.get(ID));
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
	public boolean containCommodity(String commodityID) {
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			Iterator<SalesBillPO.SalesBillItemPO> it=bill.getList().iterator();
			while(it.hasNext()){
				SalesBillPO.SalesBillItemPO item=it.next();
				if(item.getCommodityID().equals(commodityID)){
					return true;
				}
			}
		}
		return false;
	}
	public Iterator<SalesBillPO> findCommodity1(String commodityID) {
		ArrayList<SalesBillPO> list=new ArrayList<SalesBillPO>();
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			Iterator<SalesBillPO.SalesBillItemPO> it=bill.getList().iterator();
			while(it.hasNext()){
				SalesBillPO.SalesBillItemPO item=it.next();
				if(item.getCommodityID().equals(commodityID)){
					list.add(bill);
					break;
				}
			}
		}
		return list.iterator();
	}
	public boolean containsClient(long id) {
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			if(bill.getClientID()==id){
				return true;
			}
		}
		return false;
	}
	public Iterator<SalesBillPO> findClient1(long id) {
		ArrayList<SalesBillPO> list=new ArrayList<SalesBillPO>();
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			if(bill.getClientID()==id){
				list.add(bill);
			}
		}
		return list.iterator();
	}
	public boolean containsOperator(String name) {
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			if(bill.getOperator().equals(name)){
				return true;
			}
		}
		return false;
	}
	public Iterator<SalesBillPO> findOperator(String name) {
		ArrayList<SalesBillPO> list=new ArrayList<SalesBillPO>();
		Iterator<String> iterator=billIDs.iterator();
		while(iterator.hasNext()){
			SalesBillPO bill=bills.get(iterator.next());
			if(bill.getOperator().equals(name)){
				list.add(bill);
			}
		}
		return list.iterator();
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
	public boolean containBillsByStorehouse(String storehouse) {
		Iterator<String> iterator = billIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			SalesBillPO bill = bills.get(ID);
			if(bill.getStorehouse().equals(storehouse)){
				return true;
			}
		}
		return false;
	}
	public Iterator<SalesBillPO> findBillsByStorehouse(String storehouse) {
		ArrayList<SalesBillPO> list = new ArrayList<SalesBillPO>();
		Iterator<String> iterator = billIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			SalesBillPO bill = bills.get(ID);
			if(bill.getStorehouse().equals(storehouse)){
				list.add(bill);
			}
		}
		return list.iterator();
	}
	public boolean containReturnBillsByStorehouse(String storehouse) {
		Iterator<String> iterator = returnbillIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			SalesReturnBillPO bill = returnbills.get(ID);
			if(bill.getStorehouse().equals(storehouse)){
				return true;
			}
		}
		return false;
	}
	public Iterator<SalesReturnBillPO> findReturnBillsByStorehouse(
			String storehouse) {
		ArrayList<SalesReturnBillPO> list = new ArrayList<SalesReturnBillPO>();
		Iterator<String> iterator = returnbillIDs.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			SalesReturnBillPO bill = returnbills.get(ID);
			if(bill.getStorehouse().equals(storehouse)){
				list.add(bill);
			}
		}
		return list.iterator();
	}
	public Iterator<SalesReturnBillPO> findClient2(long id) {
		ArrayList<SalesReturnBillPO> list = new ArrayList<SalesReturnBillPO>();
		Iterator<String> iter = returnbillIDs.iterator();
		while(iter.hasNext()){
			SalesReturnBillPO returnbill = returnbills.get(iter.next());
			if(returnbill.getClientID() == id){
				list.add(returnbill);
			}
		}
		return list.iterator();
	}
	public Iterator<SalesReturnBillPO> findOperator2(String name) {
		ArrayList<SalesReturnBillPO> list = new ArrayList<SalesReturnBillPO>();
		Iterator<String> iter = billIDs.iterator();
		while(iter.hasNext()){
			SalesReturnBillPO returnbill = returnbills.get(iter.next());
			if(returnbill.getOperator().equals(name)){
				list.add(returnbill);
			}
		}
		return list.iterator();
	}
}
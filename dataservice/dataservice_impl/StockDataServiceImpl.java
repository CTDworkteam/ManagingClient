package dataservice_impl;
import java.util.*;
import comparator.*;
import dataservice.StockDataService;
import po.*;
public class StockDataServiceImpl implements StockDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4320800527071503174L;
	private Map<String,GiftBillPO> giftbills;
	private List<String> giftbillIds;
	private Map<String,OverflowBillPO> overflowbills;
	private List<String> overflowbillIds;
	private Map<String,UnderflowBillPO> underflowbills;
	private List<String> underflowbillIds;
	private Map<String,NoticeBillPO> noticebills;
	private List<String> noticebillIds;
	public StockDataServiceImpl(){
		giftbills=new TreeMap<String,GiftBillPO>();
		giftbillIds=new ArrayList<String>();
		overflowbills=new TreeMap<String,OverflowBillPO>();
		overflowbillIds=new ArrayList<String>();
		underflowbills=new TreeMap<String,UnderflowBillPO>();
		underflowbillIds=new ArrayList<String>();
		noticebills=new TreeMap<String,NoticeBillPO>();
		noticebillIds=new ArrayList<String>();
	}
	public StockDataServiceImpl(TreeMap<String,GiftBillPO> map1,TreeMap<String,OverflowBillPO> map2,
			TreeMap<String,UnderflowBillPO> map3,TreeMap<String,NoticeBillPO> map4,ArrayList<String> list1,
			ArrayList<String> list2,ArrayList<String> list3,ArrayList<String> list4){
		this.giftbills = map1;
		this.giftbillIds = list1;
		this.overflowbills = map2;
		this.overflowbillIds = list2;
		this.underflowbills = map3;
		this.underflowbillIds = list3;
		this.noticebills = map4;
		this.noticebillIds = list4;
	}
	public void insert(GiftBillPO po) {
		giftbills.put(po.getId(),po);
		giftbillIds.add(po.getId());
	}
	public boolean contain1(String id) {
		return giftbills.get(id)==null?false:true;
	}
	public boolean contains1(GregorianCalendar start, GregorianCalendar end) {
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=giftbillIds.size()-1;i++){
			dateString=giftbillIds.get(i).substring(2,10);
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
	public GiftBillPO find1(String id) {
		return giftbills.get(id);
	}
	public Iterator<GiftBillPO> finds1(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<GiftBillPO> set=new TreeSet<GiftBillPO>(new GiftBillComparator());
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=giftbillIds.size()-1;i++){
			dateString=giftbillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)));
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)));
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)));
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				set.add(giftbills.get(giftbillIds.get(i)));
			}
		}
		return set.descendingIterator();
	}
	public void delete(GiftBillPO po) {
		giftbills.remove(po.getId());
		Iterator<String> iterator=giftbillIds.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(GiftBillPO po){
		delete(po);
		insert(po);
	}
	public TreeMap<String, GiftBillPO> getGiftBillList() {
		TreeMap<String,GiftBillPO> map = new TreeMap<String,GiftBillPO>();
		Iterator<String> iter = giftbillIds.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, giftbills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getGiftBillIDs() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = giftbillIds.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public boolean hasGiftBills() {
		return giftbills.size()==0?false:true;
	}
	public void insert(OverflowBillPO po) {
		overflowbills.put(po.getId(),po);
		overflowbillIds.add(po.getId());
	}
	public boolean contain2(String id) {
		return overflowbills.get(id)==null?false:true;
	}
	public boolean contains2(GregorianCalendar start, GregorianCalendar end) {
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=overflowbillIds.size()-1;i++){
			dateString=overflowbillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)));
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)));
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)));
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public OverflowBillPO find(String id) {
		return overflowbills.get(id);
	}
	public Iterator<OverflowBillPO> finds(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<OverflowBillPO> set=new TreeSet<OverflowBillPO>(new OverflowBillComparator());
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=overflowbillIds.size()-1;i++){
			dateString=overflowbillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				set.add(overflowbills.get(overflowbillIds.get(i)));
			}
		}
		return set.descendingIterator();
	}
	public void delete(OverflowBillPO po) {
		overflowbills.remove(po.getId());
		Iterator<String> iterator=overflowbillIds.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(OverflowBillPO po) {
		delete(po);
		insert(po);
	}
	public TreeMap<String, OverflowBillPO> getOverflowBillList() {
		TreeMap<String,OverflowBillPO> map = new TreeMap<String,OverflowBillPO>();
		Iterator<String> iter = overflowbillIds.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, overflowbills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getOverflowBillIDs() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = overflowbillIds.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public boolean hasOverflowBills() {
		return overflowbills.size()==0?false:true;
	}
	public void insert(UnderflowBillPO po) {
		underflowbills.put(po.getId(),po);
		underflowbillIds.add(po.getId());
	}
	public boolean contain3(String id) {
		return underflowbills.get(id)==null?false:true;
	}
	public boolean contains3(GregorianCalendar start, GregorianCalendar end) {
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=underflowbillIds.size()-1;i++){
			dateString=underflowbillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)));
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)));
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)));
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				return true;
			}
		}
		return false;
	}
	public UnderflowBillPO find2(String id) {
		return underflowbills.get(id);
	}
	public Iterator<UnderflowBillPO> finds2(GregorianCalendar before,
			GregorianCalendar after) {
		TreeSet<UnderflowBillPO> set=new TreeSet<UnderflowBillPO>(new UnderflowBillComparator());
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=underflowbillIds.size()-1;i++){
			dateString=underflowbillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)));
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)));
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)));
			if(date.before(before)||date.after(after)){
				continue;
			}
			else{
				set.add(underflowbills.get(underflowbillIds.get(i)));
			}
		}
		return set.descendingIterator();
	}
	public void delete(UnderflowBillPO po) {
		underflowbills.remove(po);
		Iterator<String> iterator=underflowbillIds.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(po.getId())){
				iterator.remove();
			}
		}
	}
	public void update(UnderflowBillPO po) {
		delete(po);
		insert(po);
	}
	public TreeMap<String, UnderflowBillPO> getUnderflowBillList() {
		TreeMap<String,UnderflowBillPO> map = new TreeMap<String,UnderflowBillPO>();
		Iterator<String> iter = underflowbillIds.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, underflowbills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getUnderflowBillIDs() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = underflowbillIds.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public boolean hasUnderflowBills() {
		return underflowbills.size()==0?false:true;
	}
	public void insert(NoticeBillPO po) {
		noticebills.put(po.getId(),po);
		noticebillIds.add(po.getId());
	}
	public boolean contain(GregorianCalendar start, GregorianCalendar end) {
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=noticebillIds.size()-1;i++){
			dateString=noticebillIds.get(i).substring(2,10);
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
	public Iterator<NoticeBillPO> find(GregorianCalendar start,
			GregorianCalendar end) {
		TreeSet<NoticeBillPO> set=new TreeSet<NoticeBillPO>(new NoticeBillComparator());
		String dateString=null;
		GregorianCalendar date=new GregorianCalendar();
		for(int i=0;i<=noticebillIds.size()-1;i++){
			dateString=noticebillIds.get(i).substring(2,10);
			date.set(Calendar.YEAR,new Integer(dateString.substring(0,4)).intValue());
			date.set(Calendar.MONTH,new Integer(dateString.substring(4,6)).intValue());
			date.set(Calendar.DAY_OF_MONTH,new Integer(dateString.substring(6)).intValue());
			if(date.before(start)||date.after(end)){
				continue;
			}
			else{
				set.add(noticebills.get(noticebillIds.get(i)));
			}
		}
		return set.descendingIterator();
	}
	public TreeMap<String, NoticeBillPO> getNoticeBillList() {
		TreeMap<String,NoticeBillPO> map = new TreeMap<String,NoticeBillPO>();
		Iterator<String> iter = noticebillIds.iterator();
		while(iter.hasNext()){
			String ID = iter.next();
			map.put(ID, noticebills.get(ID));
		}
		return map;
	}
	public ArrayList<String> getNoticeBillIDs() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> iter = noticebillIds.iterator();
		while(iter.hasNext()){
			list.add(iter.next());
		}
		return list;
	}
	public boolean hasNoticeBills() {
		return noticebills.size()==0?false:true;
	}
	public int numberOfGiftBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = giftbillIds.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(2,10);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfOverflowBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = overflowbillIds.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(2,10);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfUnderflowBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = underflowbillIds.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(2,10);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfNoticeBills(GregorianCalendar date) {
		int count = 0;
		Iterator<String> iterator = noticebillIds.iterator();
		while(iterator.hasNext()){
			String ID = iterator.next();
			String dateString = ID.substring(2,10);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
}
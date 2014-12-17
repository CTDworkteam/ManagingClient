package dataservice;
import java.util.*;
import po.*;
public interface StockDataService {
	public void insert(GiftBillPO po);
	public boolean contain1(String id);
	public boolean contains1(GregorianCalendar start,GregorianCalendar end);
	public GiftBillPO find1(String id);
	public Iterator<GiftBillPO> finds1(GregorianCalendar before,GregorianCalendar after);
	public void delete(GiftBillPO po);
	public void update(GiftBillPO po);
	public TreeMap<String,GiftBillPO> getGiftBillList();
	public ArrayList<String> getGiftBillIDs();
	public boolean hasGiftBills();
	
	public void insert(OverflowBillPO po);
	public boolean contain2(String id);
	public boolean contains2(GregorianCalendar start,GregorianCalendar end);
	public OverflowBillPO find(String id);
	public Iterator<OverflowBillPO> finds(GregorianCalendar before,GregorianCalendar after);
	public void delete(OverflowBillPO po);
	public void update(OverflowBillPO po);
	public TreeMap<String,OverflowBillPO> getOverflowBillList();
	public ArrayList<String> getOverflowBillIDs();
	public boolean hasOverflowBills();
	
	public void insert(UnderflowBillPO po);
	public boolean contain3(String id);
	public boolean contains3(GregorianCalendar start,GregorianCalendar end);
	public UnderflowBillPO find2(String id);
	public Iterator<UnderflowBillPO> finds2(GregorianCalendar before,GregorianCalendar after);
	public void delete(UnderflowBillPO po);
	public void update(UnderflowBillPO po);
	public TreeMap<String,UnderflowBillPO> getUnderflowBillList();
	public ArrayList<String> getUnderflowBillIDs();
	public boolean hasUnderflowBills();
	
	public void insert(NoticeBillPO po);
	public boolean contain(GregorianCalendar start,GregorianCalendar end);
	public Iterator<NoticeBillPO> find(GregorianCalendar start,GregorianCalendar end);
	public TreeMap<String,NoticeBillPO> getNoticeBillList();
	public ArrayList<String> getNoticeBillIDs();
	public boolean hasNoticeBills();
	
	public void init();
	public void save();
}

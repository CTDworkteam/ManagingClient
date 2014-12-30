package dataservice;
import java.util.*;
import po.*;
public interface PurchaseDataService {
	public void insert(PurchaseBillPO po);
    public boolean contain(String id);
    public void delete(PurchaseBillPO po);
    public void update(PurchaseBillPO po);
    public PurchaseBillPO find1(String id);
    public PurchaseReturnBillPO find2(String id);
    
    public void insert(PurchaseReturnBillPO po);
    public void delete(PurchaseReturnBillPO po);
    public void update(PurchaseReturnBillPO po);
    public boolean contains1(GregorianCalendar start,GregorianCalendar end);
    public boolean contains2(GregorianCalendar start,GregorianCalendar end);
    public Iterator<PurchaseBillPO> finds1(GregorianCalendar before,GregorianCalendar after);
    public Iterator<PurchaseReturnBillPO> finds2(GregorianCalendar before,GregorianCalendar after);
    public TreeMap<String,PurchaseBillPO> getList1();
    public ArrayList<String> getIDs1();
    public TreeMap<String,PurchaseReturnBillPO> getList2();
    public ArrayList<String> getIDs2();
    public boolean hasBills();
    public boolean hasReturnBills();
    
    public int numberOfBills(GregorianCalendar date);
    public int numberOfReturnBills(GregorianCalendar date);
}
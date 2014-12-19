package dataservice;
import java.util.*;
import po.*;
public interface SalesDataService {
	   public void insert(SalesBillPO po);
	    public boolean contain(String id);
	    public void delete(SalesBillPO po);
	    public void update(SalesBillPO po);
	    public SalesBillPO find1(String id);
	    public SalesReturnBillPO find2(String id);
	    public void insert(SalesReturnBillPO po);
	    public void delete(SalesReturnBillPO po);
	    public void update(SalesReturnBillPO po);
	    public boolean contains1(GregorianCalendar start,GregorianCalendar end);
	    public boolean contains2(GregorianCalendar start,GregorianCalendar end);
	    public Iterator<SalesBillPO> finds1(GregorianCalendar before,GregorianCalendar after);
	    public Iterator<SalesReturnBillPO> finds2(GregorianCalendar before,GregorianCalendar after);
	    public TreeMap<String,SalesBillPO> getList1();
	    public ArrayList<String> getIDs1();
	    public TreeMap<String,SalesReturnBillPO> getList2();
	    public ArrayList<String> getIDs2();
	    public boolean hasBills();
	    public boolean hasReturnBills();
	    public boolean containCommodity(String commodityID);
	    public Iterator<SalesBillPO> findCommodity1(String commodityID);
	    public boolean containsClient(long id);
	    public Iterator<SalesBillPO> findClient1(long id);
	    public boolean containsOperator(String name);
	    public Iterator<SalesBillPO> findOperator(String name);
	    
	    public int numberOfBills(GregorianCalendar date);
	    public int numberOfReturnBills(GregorianCalendar date);
	    
	    public void init();
	    public void save();
}

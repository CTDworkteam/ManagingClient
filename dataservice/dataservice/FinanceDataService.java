package dataservice;
import java.util.*;
import po.*;
public interface FinanceDataService {
	public void insert(ReciptPO po);
	public void delete(ReciptPO po);
	public void update(ReciptPO po);
	public boolean contain1(String id);
	public boolean contains1(GregorianCalendar start,GregorianCalendar end);
	public ReciptPO find1(String id);
	public Iterator<ReciptPO> finds1(GregorianCalendar before,GregorianCalendar after);
	public TreeMap<String,ReciptPO> getList1();
	public ArrayList<String> getReciptIDs();
	public boolean hasRecipts();
	
	public void insert(PaymentPO po);
	public void delete(PaymentPO po);
	public void update(PaymentPO po);
	public boolean contain2(String id);
	public boolean contains2(GregorianCalendar start,GregorianCalendar end);
	public PaymentPO find2(String id);
	public Iterator<PaymentPO> finds2(GregorianCalendar before,GregorianCalendar after);
	public TreeMap<String,PaymentPO> getList2();
	public ArrayList<String> getPaymentIDs();
	public boolean hasPayments();
	
	public void init();
	public void save();
}

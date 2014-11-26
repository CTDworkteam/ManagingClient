package dataservice;
import java.rmi.*;
import java.util.*;
import po.*;
public interface StockDataService extends Remote{
	public void insert(GiftBillPO po)throws RemoteException;
	public boolean contain1(String id)throws RemoteException;
	public boolean contains1(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public GiftBillPO find1(String id)throws RemoteException;
	public TreeSet<GiftBillPO> finds1(GregorianCalendar before,GregorianCalendar after)throws RemoteException;
	public void delete(GiftBillPO po)throws RemoteException;
	public void update(GiftBillPO po)throws RemoteException;
	public TreeMap<String,GiftBillPO> getGiftBillList() throws RemoteException;
	public String[] getGiftBillIDs() throws RemoteException;
	public boolean hasGiftBills() throws RemoteException;
	
	public void insert(OverflowBillPO po)throws RemoteException;
	public boolean contain2(String id)throws RemoteException;
	public boolean contains2(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public OverflowBillPO find(String id) throws RemoteException;
	public TreeSet<OverflowBillPO> finds(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
	public void delete(OverflowBillPO po)throws RemoteException;
	public void update(OverflowBillPO po)throws RemoteException;
	public TreeMap<String,OverflowBillPO> getOverflowBillList() throws RemoteException;
	public String[] getOverflowBillIDs() throws RemoteException;
	public boolean hasOverflowBills() throws RemoteException;
	
	public void insert(UnderflowBillPO po)throws RemoteException;
	public boolean contain3(String id)throws RemoteException;
	public boolean contains3(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public UnderflowBillPO find2(String id) throws RemoteException;
	public TreeSet<UnderflowBillPO> finds2(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
	public void delete(UnderflowBillPO po)throws RemoteException;
	public void update(UnderflowBillPO po)throws RemoteException;
	public TreeMap<String,UnderflowBillPO> getUnderflowBillList() throws RemoteException;
	public String[] getUnderflowBillIDs() throws RemoteException;
	public boolean hasUnderflowBills() throws RemoteException;
	
	public void insert(NoticeBillPO po)throws RemoteException;
	public boolean contain(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public TreeSet<NoticeBillPO> find(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public TreeMap<String,NoticeBillPO> getNoticeBillList() throws RemoteException;
	public String[] getNoticeBillIDs() throws RemoteException;
	public boolean hasNoticeBills() throws RemoteException;
}


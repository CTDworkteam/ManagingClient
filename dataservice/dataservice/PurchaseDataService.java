package dataservice;
import po.*;
import java.util.*;
import java.rmi.*;
public interface PurchaseDataService extends Remote{
	public void insert(PurchaseBillPO po) throws RemoteException;
    public boolean contain(String id) throws RemoteException;
    public void delete(PurchaseBillPO po) throws RemoteException;
    public void update(PurchaseBillPO po) throws RemoteException;
    public PurchaseBillPO find1(String id) throws RemoteException;
    public PurchaseReturnBillPO find2(String id) throws RemoteException;
    public void insert(PurchaseReturnBillPO po) throws RemoteException;
    public void delete(PurchaseReturnBillPO po) throws RemoteException;
    public void update(PurchaseReturnBillPO po) throws RemoteException;
    public boolean contains1(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
    public boolean contains2(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
    public TreeSet<PurchaseBillPO> finds1(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
    public TreeSet<PurchaseReturnBillPO> finds2(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
    public TreeMap<String,PurchaseBillPO> getList1() throws RemoteException;
    public String[] getIDs1() throws RemoteException;
    public TreeMap<String,PurchaseReturnBillPO> getList2() throws RemoteException;
    public String[] getIDs2() throws RemoteException;
    public boolean hasBills() throws RemoteException;
    public boolean hasReturnBills() throws RemoteException;
}

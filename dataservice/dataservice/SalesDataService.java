package dataservice;
import java.util.*;
import po.*;
import java.rmi.*;
public interface SalesDataService extends Remote{
	    public void insert(SalesBillPO po) throws RemoteException;
	    public boolean contain(String id) throws RemoteException;
	    public void delete(SalesBillPO po) throws RemoteException;
	    public void update(SalesBillPO po) throws RemoteException;
	    public SalesBillPO find1(String id) throws RemoteException;
	    public SalesReturnBillPO find2(String id) throws RemoteException;
	    public void insert(SalesReturnBillPO po) throws RemoteException;
	    public void delete(SalesReturnBillPO po) throws RemoteException;
	    public void update(SalesReturnBillPO po) throws RemoteException;
	    public boolean contains1(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	    public boolean contains2(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	    public TreeSet<SalesBillPO> finds1(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
	    public TreeSet<SalesReturnBillPO> finds2(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
	    public TreeMap<String,SalesBillPO> getList1() throws RemoteException;
	    public String[] getIDs1() throws RemoteException;
	    public TreeMap<String,SalesReturnBillPO> getList2() throws RemoteException;
	    public String[] getIDs2() throws RemoteException;
	    public boolean hasBills() throws RemoteException;
	    public boolean hasReturnBills() throws RemoteException;
}


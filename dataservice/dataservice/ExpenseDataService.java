package dataservice;
import po.*;
import java.rmi.*;
import java.util.*;
public interface ExpenseDataService extends Remote{
	public void insert(ExpensePO po)throws RemoteException;
	public boolean contain(String id)throws RemoteException;
	public void delete(ExpensePO po)throws RemoteException;
	public void update(ExpensePO po)throws RemoteException;
	public ExpensePO find(String id)throws RemoteException;
	public TreeSet<ExpensePO> finds(GregorianCalendar before,GregorianCalendar after) throws RemoteException;
	public String[] getIDs() throws RemoteException;
	public TreeMap<String,ExpensePO> getDataList() throws RemoteException;
	public boolean isEmpty() throws RemoteException;
}

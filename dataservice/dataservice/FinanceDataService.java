package dataservice;
import java.rmi.*;

import po.*;

import java.util.*;
public interface FinanceDataService {
	public void insert(ReciptPO po)throws RemoteException;
	public void delete(ReciptPO po)throws RemoteException;
	public void update(ReciptPO po)throws RemoteException;
	public boolean contain1(String id)throws RemoteException;
	public boolean contains1(GregorianCalendar start,GregorianCalendar end)throws RemoteException;
	public ReciptPO find1(String id)throws RemoteException;
	public TreeSet<ReciptPO> finds1(GregorianCalendar before,GregorianCalendar after)throws RemoteException;
	public TreeMap<String,ReciptPO> getList1() throws RemoteException;
	public String[] getReciptIDs() throws RemoteException;
	public boolean hasRecipts() throws RemoteException;
	
	public void insert(PaymentPO po)throws RemoteException;
	public void delete(PaymentPO po)throws RemoteException;
	public void update(PaymentPO po)throws RemoteException;
	public boolean contain2(String id)throws RemoteException;
	public boolean contains2(GregorianCalendar start,GregorianCalendar end) throws RemoteException;
	public PaymentPO find2(String id) throws RemoteException;
	public TreeSet<PaymentPO> finds2(GregorianCalendar before,GregorianCalendar after)throws RemoteException;
	public TreeMap<String,PaymentPO> getList2() throws RemoteException;
	public String[] getPaymentIDs() throws RemoteException;
	public boolean hasPayments() throws RemoteException;
	public ClientPO findClient1(String client) throws RemoteException;
	public AccountPO findAccount1(String account) throws RemoteException;
}

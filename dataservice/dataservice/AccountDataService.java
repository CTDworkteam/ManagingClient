package dataservice;
import java.rmi.*;
import po.*;
import java.util.*;
public interface AccountDataService extends Remote{
	public void insert(AccountPO po)throws RemoteException;//�����µ�PO����
	public void delete(AccountPO po)throws RemoteException;//ɾ��һ��PO����
	public boolean contain(String name)throws RemoteException;
	public AccountPO find(String name)throws RemoteException;
	public void update(AccountPO po)throws RemoteException;
	public TreeMap<Long,AccountPO> list() throws RemoteException;
	public long[] getIDs() throws RemoteException;
	public boolean isEmpty() throws RemoteException;
}

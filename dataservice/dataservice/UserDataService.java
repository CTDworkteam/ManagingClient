package dataservice;
import java.rmi.*;
import java.util.*;
import po.*;
import enumType.*;
public interface UserDataService extends Remote{
	public void insert(UserPO po) throws RemoteException;
	public boolean contain(long id)throws RemoteException;
	public UserPO find(long id) throws RemoteException;
	public void delete(UserPO po) throws RemoteException;
	public void update(UserPO po) throws RemoteException;
	public TreeSet<UserPO> getList() throws RemoteException;
	public boolean isEmpty() throws RemoteException;
}


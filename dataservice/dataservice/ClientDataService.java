package dataservice;
import po.*;
import java.rmi.*;
import java.util.*;
import enumType.*;
public interface ClientDataService extends Remote{
	public void insert(ClientPO po) throws RemoteException;
    public void delete(ClientPO po) throws RemoteException;
    public boolean contain(String name) throws RemoteException;
    public ClientPO find(String name) throws RemoteException;
    public ClientPO find(long id) throws RemoteException;
    public void update(ClientPO po) throws RemoteException;
    public TreeMap<ClientType,TreeSet<ClientPO> > list() throws RemoteException;
    public boolean isEmpty() throws RemoteException;
    public ClientPO findInID(String id) throws RemoteException;
    public ArrayList<ClientPO> findInKeyword(String key) throws RemoteException;
}

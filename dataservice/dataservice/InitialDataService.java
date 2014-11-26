package dataservice;
import java.rmi.*;
import po.*;
public interface InitialDataService extends Remote{
	public void insert(InitialPO po)throws RemoteException;
	public boolean contain(String id)throws RemoteException;
	public InitialPO find(String id)throws RemoteException;
	public boolean isEmpty() throws RemoteException;
}

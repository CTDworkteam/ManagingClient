package dataservice;
import java.rmi.*;
public interface PurchaseDataServiceTxtFileImpl extends Remote{
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}

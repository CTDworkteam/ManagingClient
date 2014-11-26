package dataservice;

import java.rmi.*;

public interface StockDataServiceTxtFileImpl extends Remote{
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
}

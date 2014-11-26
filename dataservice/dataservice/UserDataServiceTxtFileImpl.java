package dataservice;

import java.rmi.*;

public interface UserDataServiceTxtFileImpl extends Remote{
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
}

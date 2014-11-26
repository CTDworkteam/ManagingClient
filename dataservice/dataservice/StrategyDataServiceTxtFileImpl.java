package dataservice;
import java.rmi.*;
public interface StrategyDataServiceTxtFileImpl extends Remote{
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
}

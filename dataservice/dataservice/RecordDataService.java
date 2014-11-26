package dataservice;
import java.rmi.*;
import po.*;
import java.util.*;
import enumType.*;
public interface RecordDataService extends Remote{
	public void insert(RecordPO po) throws RemoteException;
	public TreeMap<RecordType,TreeSet<RecordPO> > list() throws RemoteException;
	public boolean isEmpty() throws RemoteException;
}

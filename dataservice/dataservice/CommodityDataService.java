package dataservice;
import java.rmi.*;
import java.util.*;
import po.*;
public interface CommodityDataService extends Remote{
	public void insertCommodity(CommodityPO po)throws RemoteException;
	public boolean containCommodity(String id)throws RemoteException;
	public CommodityPO findCommodity(String id)throws RemoteException;
	public boolean containCommodities(String keyword) throws RemoteException;
	public TreeSet<CommodityPO> findCommodities(String keyword)throws RemoteException;
	public void deleteCommodity(CommodityPO po) throws RemoteException;
	public void updateCommodity(CommodityPO po)throws RemoteException;
	public TreeSet<CommodityPO> getCommodityListByType(String id) throws RemoteException;
	public TreeMap<String,TreeSet<CommodityPO> > getCommodityList() throws RemoteException;
	public String[] getTypeNames() throws RemoteException;
	public boolean hasCommodity() throws RemoteException;
}

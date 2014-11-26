package dataservice;
import java.util.*;
import java.rmi.*;
import po.*;
import object.*;
public interface CommodityTypeDataService extends Remote{
	public void insertCommodityType(CommodityTypePO po) throws RemoteException;
	public boolean containCommdityType(String id) throws RemoteException;
	public CommodityTypePO findCommodityType(String id) throws RemoteException;
	public boolean containCommodityTypes(String keyword) throws RemoteException;
	public TreeSet<CommodityTypePO> findCommodityTypes(String keyword) throws RemoteException;
	public void deleteCommodityType(CommodityTypePO po) throws RemoteException;
	public void updateCommodityType(CommodityTypePO po) throws RemoteException;
	public TypeTree<CommodityTypePO> getTree() throws RemoteException;
	public boolean hasCommodityType() throws RemoteException;
}

package dataservice;
import java.rmi.*;
import java.util.*;
import po.*;
public interface StrategyDataService extends Remote{
	public void insert(DiscountStrategyPO po) throws RemoteException;
	public void delete(DiscountStrategyPO po) throws RemoteException;
	public void update(DiscountStrategyPO po) throws RemoteException;
	public boolean contain1(String id) throws RemoteException;
	public DiscountStrategyPO find1(String id) throws RemoteException;
	public TreeMap<String,DiscountStrategyPO> getDiscountStrategyList() throws RemoteException;
	public String[] getDiscountStrategyIDs() throws RemoteException;
	public boolean hasDiscountStrategy() throws RemoteException;
	
	public void insert(VoucherStrategyPO po) throws RemoteException;
	public void delete(VoucherStrategyPO po) throws RemoteException;
	public void update(VoucherStrategyPO po) throws RemoteException;
	public boolean contain2(String id) throws RemoteException;
	public VoucherStrategyPO find2(String id) throws RemoteException;
	public TreeMap<String,VoucherStrategyPO> getVoucherStrategyList() throws RemoteException;
	public String[] getVoucherStrategyIDs() throws RemoteException;
	public boolean hasVoucherStrategy() throws RemoteException;
	
	public void insert(CombinationStrategyPO po) throws RemoteException;
	public void delete(CombinationStrategyPO po) throws RemoteException;
	public void update(CombinationStrategyPO po) throws RemoteException;
	public boolean contain3(String id) throws RemoteException;
	public CombinationStrategyPO find3(String id) throws RemoteException;
	public TreeMap<String,CombinationStrategyPO> getCombinationStrategyList() throws RemoteException;
	public String[] getCombinationStrategyIDs() throws RemoteException;
	public boolean hasCombinationStrategy() throws RemoteException;
	
	public void insert(GiftStrategyPO po) throws RemoteException;
	public void delete(GiftStrategyPO po) throws RemoteException;
	public void update(GiftStrategyPO po) throws RemoteException;
	public boolean contain4(String id) throws RemoteException;
	public GiftStrategyPO find4(String id) throws RemoteException;
	public TreeMap<String,GiftStrategyPO> getGiftStrategyList() throws RemoteException;
	public String[] getGiftStrategyIDs() throws RemoteException;
	public boolean hasGiftStrategy() throws RemoteException;
	
	public void insert(GiftBasedOnTotalMoneyPO po) throws RemoteException;
	public void delete(GiftBasedOnTotalMoneyPO po) throws RemoteException;
	public void update(GiftBasedOnTotalMoneyPO po) throws RemoteException;
	public boolean contain5(String id) throws RemoteException;
	public GiftBasedOnTotalMoneyPO find5(String id) throws RemoteException;
	public TreeMap<String,GiftBasedOnTotalMoneyPO> getGBOTMList() throws RemoteException;
	public String[] getGBOTMIDs() throws RemoteException;
	public boolean hasGBOTM() throws RemoteException;
}

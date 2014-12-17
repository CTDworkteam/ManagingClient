package datafactory;
import java.rmi.*;
import dataservice.*;
public interface DataFactoryService extends Remote{
	public AccountDataService getAccountDataService() throws RemoteException;
	public ClientDataService getClientDataService() throws RemoteException;
	public CommodityDataService getCommodityDataService() throws RemoteException;
	public CommodityTypeDataService getCommodityTypeDataService() throws RemoteException;
	public ExpenseDataService getExpenseDataService() throws RemoteException;
	public FinanceDataService getFinanceDataService() throws RemoteException;
	public InitialDataService getInitialDataService() throws RemoteException;
	public PurchaseDataService getPurchaseDataService() throws RemoteException;
	public RecordDataService getRecordDataService() throws RemoteException;
	public SalesDataService getSalesDataService() throws RemoteException;
	public StockDataService getStockDataService() throws RemoteException;
	public StrategyDataService getStrategyDataService() throws RemoteException;
	public UserDataService getUserDataService() throws RemoteException;
}

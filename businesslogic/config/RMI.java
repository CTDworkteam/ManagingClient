package config;
import dataservice.*;
import java.net.*;
import java.rmi.*;
public class RMI {
	public static final String URL="rmi://127.0.0.1:8888";
	public static AccountDataService getAccountDataService(){
		AccountDataService service=null;
		try {
			service=(AccountDataService)Naming.lookup(RMI.URL+"/accountdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static ClientDataService getClientDataService(){
		ClientDataService service=null;
		try {
			service=(ClientDataService)Naming.lookup(RMI.URL+"/clientdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static CommodityDataService getCommodityDataService(){
		CommodityDataService service=null;
		try {
			service=(CommodityDataService)Naming.lookup(RMI.URL+"/commoditydata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static CommodityTypeDataService getCommodityTypeDataService(){
		CommodityTypeDataService service=null;
		try {
			service=(CommodityTypeDataService)Naming.lookup(RMI.URL+"/commoditydata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static ExpenseDataService getExpenseDataService(){
		ExpenseDataService service=null;
		try {
			service=(ExpenseDataService)Naming.lookup(RMI.URL+"/expensedata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static FinanceDataService getFinanceDataService(){
		FinanceDataService service=null;
		try {
			service=(FinanceDataService)Naming.lookup(RMI.URL+"/financedata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static InitialDataService getInitialDataService(){
		InitialDataService service=null;
		try {
			service=(InitialDataService)Naming.lookup(RMI.URL+"/initialdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static PurchaseDataService getPurchaseDataService(){
		PurchaseDataService service=null;
		try {
			service=(PurchaseDataService)Naming.lookup(RMI.URL+"/purchasedata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static RecordDataService getRecordDataService(){
		RecordDataService service=null;
		try {
			service=(RecordDataService)Naming.lookup(RMI.URL+"/recorddata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static SalesDataService getSalesDataService(){
		SalesDataService service=null;
		try {
			service=(SalesDataService)Naming.lookup(RMI.URL+"/salesdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static StockDataService getStockDataService(){
		StockDataService service=null;
		try {
			service=(StockDataService)Naming.lookup(RMI.URL+"/stockdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static StrategyDataService getStrategyDataService(){
		StrategyDataService service=null;
		try {
			service=(StrategyDataService)Naming.lookup(RMI.URL+"/strategydata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static UserDataService getUserDataService(){
		UserDataService service=null;
		try {
			service=(UserDataService)Naming.lookup(RMI.URL+"/userdata");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
}

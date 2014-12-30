package config;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import dataservice.*;
import datafactory.*;
public class RMI {
	public static String URL="rmi://114.212.42.149:7112/datafactory";
	public static DataFactoryService getDataFactoryService(){
		System.out.println("方法开始");
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		System.out.println(System.getProperty("java.security.policy"));
		System.setProperty("java.security.policy","client.policy");
		DataFactoryService service=null;
		try {
			service=(DataFactoryService)Naming.lookup(RMI.URL);
			System.out.println("Success");
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			System.out.println("RemoteException");
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			System.out.println("NoBoundException");
			e.printStackTrace();
			return null;
		}
		return service;
	}
	public static AccountDataService getAccountDataService(){
		AccountDataService service=null;
		try {
			service=getDataFactoryService().getAccountDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static ClientDataService getClientDataService(){
		ClientDataService service=null;
		try {
			service=getDataFactoryService().getClientDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static CommodityDataService getCommodityDataService(){
		CommodityDataService service=null;
		try {
			service=getDataFactoryService().getCommodityDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static CommodityTypeDataService getCommodityTypeDataService(){
		CommodityTypeDataService service=null;
		try {
			service=getDataFactoryService().getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static ExpenseDataService getExpenseDataService(){
		ExpenseDataService service=null;
		try {
			service=getDataFactoryService().getExpenseDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static FinanceDataService getFinanceDataService(){
		FinanceDataService service=null;
		try {
			service=getDataFactoryService().getFinanceDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static InitialDataService getInitialDataService(){
		InitialDataService service=null;
		try {
			service=getDataFactoryService().getInitialDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static PurchaseDataService getPurchaseDataService(){
		PurchaseDataService service=null;
		try {
			service=getDataFactoryService().getPurchaseDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static RecordDataService getRecordDataService(){
		RecordDataService service=null;
		try {
			service=getDataFactoryService().getRecordDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static SalesDataService getSalesDataService(){
		SalesDataService service=null;
		try {
			service=getDataFactoryService().getSalesDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static StockDataService getStockDataService(){
		StockDataService service=null;
		try {
			service=getDataFactoryService().getStockDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static StrategyDataService getStrategyDataService(){
		StrategyDataService service=null;
		try {
			service=getDataFactoryService().getStrategyDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
	public static UserDataService getUserDataService(){
		UserDataService service=null;
		try {
			service=getDataFactoryService().getUserDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}
}

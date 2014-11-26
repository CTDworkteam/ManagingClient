package userbl;

import java.util.*;


public class UserList{
	private ArrayList<User> purchasemanager;
	private ArrayList<User> salesmanager;
	private ArrayList<User> manager;
	private ArrayList<User> stockmanager;
	private ArrayList<User> financemanager;
	private ArrayList<User> systemmanager;
	
	public UserList(){
	}
	
	public UserList(ArrayList<User> purchasemanager,
			ArrayList<User> salesmanager, ArrayList<User> manager,
			ArrayList<User> stockmanager, ArrayList<User> financemanager,
			ArrayList<User> systemmanager){
		this.purchasemanager = purchasemanager;
		this.salesmanager = salesmanager;
		this.manager = manager;
		this.stockmanager = stockmanager;
		this.financemanager = financemanager;
		this.systemmanager = systemmanager;
	}
	
	public ArrayList<User> getPurchasemanager() {
		return purchasemanager;
	}
	public void setPurchasemanager(ArrayList<User> purchasemanager) {
		this.purchasemanager = purchasemanager;
	}
	public ArrayList<User> getSalesmanager() {
		return salesmanager;
	}
	public void setSalesmanager(ArrayList<User> salesmanager) {
		this.salesmanager = salesmanager;
	}
	public ArrayList<User> getManager() {
		return manager;
	}
	public void setManager(ArrayList<User> manager) {
		this.manager = manager;
	}
	public ArrayList<User> getStockmanager() {
		return stockmanager;
	}
	public void setStockmanager(ArrayList<User> stockmanager) {
		this.stockmanager = stockmanager;
	}
	public ArrayList<User> getFinancemanager() {
		return financemanager;
	}
	public void setFinancemanager(ArrayList<User> financemanager) {
		this.financemanager = financemanager;
	}
	public ArrayList<User> getSystemmanager() {
		return systemmanager;
	}
	public void setSystemmanager(ArrayList<User> systemmanager) {
		this.systemmanager = systemmanager;
	}
}
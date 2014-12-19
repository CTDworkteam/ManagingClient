package vo;

import java.util.ArrayList;

public class UserListVO {
	private ArrayList<UserVO> purchasemanager;
	private ArrayList<UserVO> salesmanager;
	private ArrayList<UserVO> manager;
	private ArrayList<UserVO> stockmanager;
	private ArrayList<UserVO> financemanager;
	private ArrayList<UserVO> systemmanager;
	public UserListVO(ArrayList<UserVO> purchasemanager,
			ArrayList<UserVO> salesmanager, ArrayList<UserVO> manager,
			ArrayList<UserVO> stockmanager, ArrayList<UserVO> financemanager,
			ArrayList<UserVO> systemmanager) {
		super();
		this.purchasemanager = purchasemanager;
		this.salesmanager = salesmanager;
		this.manager = manager;
		this.stockmanager = stockmanager;
		this.financemanager = financemanager;
		this.systemmanager = systemmanager;
	}
	public UserListVO() {
		// TODO 自动生成的构造函数存根
	}
	public ArrayList<UserVO> getPurchasemanager() {
		return purchasemanager;
	}
	public void setPurchasemanager(ArrayList<UserVO> purchasemanager) {
		this.purchasemanager = purchasemanager;
	}
	public ArrayList<UserVO> getSalesmanager() {
		return salesmanager;
	}
	public void setSalesmanager(ArrayList<UserVO> salesmanager) {
		this.salesmanager = salesmanager;
	}
	public ArrayList<UserVO> getManager() {
		return manager;
	}
	public void setManager(ArrayList<UserVO> manager) {
		this.manager = manager;
	}
	public ArrayList<UserVO> getStockmanager() {
		return stockmanager;
	}
	public void setStockmanager(ArrayList<UserVO> stockmanager) {
		this.stockmanager = stockmanager;
	}
	public ArrayList<UserVO> getFinancemanager() {
		return financemanager;
	}
	public void setFinancemanager(ArrayList<UserVO> financemanager) {
		this.financemanager = financemanager;
	}
	public ArrayList<UserVO> getSystemmanager() {
		return systemmanager;
	}
	public void setSystemmanager(ArrayList<UserVO> systemmanager) {
		this.systemmanager = systemmanager;
	}
}

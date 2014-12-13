package po;

import java.util.ArrayList;

public class ReciptPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private long clientID;
	private String operator;
	private ArrayList<ReciptItemPO> list;
	private double total;
	public ReciptPO(){
	}
	public ReciptPO(boolean isPassed, String id, long clientID,
			String operator, ArrayList<ReciptItemPO> list, double total) {
		this.isPassed = isPassed;
		this.id = id;
		this.clientID = clientID;
		this.operator = operator;
		this.list = list;
		this.total = total;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getClientID() {
		return clientID;
	}
	public void setClientID(long clientID) {
		this.clientID = clientID;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public ArrayList<ReciptItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<ReciptItemPO> list) {
		this.list = list;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public class ReciptItemPO implements java.io.Serializable{
		private String account;
		private double money;
		private String note;
		public ReciptItemPO(){
		}
		public ReciptItemPO(String account, double money, String note) {
			this.account = account;
			this.money = money;
			this.note = note;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public double getMoney() {
			return money;
		}
		public void setMoney(double money) {
			this.money = money;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
	}
}

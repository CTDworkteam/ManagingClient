package po;

import java.util.ArrayList;

public class ReciptPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private ClientPO client;
	private UserPO operator;
	private ArrayList<ReciptItemPO> list;
	private double total;
	public ReciptPO(String id, ClientPO client, UserPO operator,
			ArrayList<ReciptItemPO> list, double total) {
		this.id = id;
		this.client = client;
		this.operator = operator;
		this.list = list;
		this.total = total;
		this.isPassed=false;
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
	public ClientPO getClient() {
		return client;
	}
	public void setClient(ClientPO client) {
		this.client = client;
	}
	public UserPO getOperator() {
		return operator;
	}
	public void setOperator(UserPO operator) {
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
		private AccountPO account;
		private double money;
		private String note;
		public ReciptItemPO(AccountPO account, double money, String note) {
			this.account = account;
			this.money = money;
			this.note = note;
		}
		public AccountPO getAccount() {
			return account;
		}
		public void setAccount(AccountPO account) {
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

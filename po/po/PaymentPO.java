package po;

import java.util.ArrayList;

public class PaymentPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private UserPO operator;
	private ClientPO client;
	private ArrayList<PaymentItemPO> list;
	private double total;
	public PaymentPO(String id, UserPO operator, ClientPO client,
			ArrayList<PaymentItemPO> list, double total) {
		this.id = id;
		this.operator = operator;
		this.client = client;
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
	public UserPO getOperator() {
		return operator;
	}
	public void setOperator(UserPO operator) {
		this.operator = operator;
	}
	public ClientPO getClient() {
		return client;
	}
	public void setClient(ClientPO client) {
		this.client = client;
	}
	public ArrayList<PaymentItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<PaymentItemPO> list) {
		this.list = list;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public class PaymentItemPO implements java.io.Serializable{
		private AccountPO account;
		private double money;
		private String note;
		public PaymentItemPO(AccountPO account, double money, String note) {
			super();
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

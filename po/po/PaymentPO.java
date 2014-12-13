package po;
import java.util.ArrayList;
public class PaymentPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private String operator;
	private long clientID;
	private ArrayList<PaymentItemPO> list;
	private double total;
	public PaymentPO(){
	}
	public PaymentPO(boolean isPassed, String id, String operator,
			long clientID, ArrayList<PaymentItemPO> list, double total) {
		this.isPassed = isPassed;
		this.id = id;
		this.operator = operator;
		this.clientID = clientID;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public long getClientID() {
		return clientID;
	}
	public void setClientID(long clientID) {
		this.clientID = clientID;
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
		private String account;
		private double money;
		private String note;
		public PaymentItemPO(){
		}
		public PaymentItemPO(String account, double money, String note) {
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
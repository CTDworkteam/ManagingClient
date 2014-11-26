package po;
import java.util.ArrayList;
public class ExpensePO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private UserPO operator;
	private AccountPO account;
	private double total;
	private ArrayList<ExpenseItemPO> list;
	public ExpensePO(String id, UserPO operator, AccountPO account,
			double total, ArrayList<ExpenseItemPO> list) {
		this.id = id;
		this.operator = operator;
		this.account = account;
		this.total = total;
		this.list = list;
		this.isPassed=false;
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
	public AccountPO getAccount() {
		return account;
	}
	public void setAccount(AccountPO account) {
		this.account = account;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<ExpenseItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<ExpenseItemPO> list) {
		this.list = list;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public class ExpenseItemPO{
		private String itemName;
		private double money;
		private String note;
		public ExpenseItemPO(String itemName, double money, String note) {
			super();
			this.itemName = itemName;
			this.money = money;
			this.note = note;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
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

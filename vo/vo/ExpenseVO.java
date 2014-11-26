package vo;
import java.util.ArrayList;
public class ExpenseVO {
	private boolean isPassed;
	private String id;
	private String operator;
	private String account;
	private double total;
	private ArrayList<ExpenseItemVO> list;
	public ExpenseVO( String id, String operator,
			String account, double total, ArrayList<ExpenseItemVO> list) {
		super();
		this.id = id;
		this.operator = operator;
		this.account = account;
		this.total = total;
		this.list = list;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<ExpenseItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<ExpenseItemVO> list) {
		this.list = list;
	}
	public class ExpenseItemVO{
		private String itemName;
		private double money;
		private String note;
		public ExpenseItemVO(String itemName, double money, String note) {
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

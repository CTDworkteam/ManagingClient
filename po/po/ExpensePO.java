package po;
import java.util.ArrayList;
public class ExpensePO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8596576235670816984L;
	private boolean isPassed;
	private String id;
	private String operator;
	private String accountname;
	private double total;
	private ArrayList<ExpenseItemPO> list;
	public ExpensePO(){
	}
	public ExpensePO(boolean isPassed, String id, String operator,
			String accountname, double total, ArrayList<ExpenseItemPO> list) {
		this.isPassed = isPassed;
		this.id = id;
		this.operator = operator;
		this.accountname = accountname;
		this.total = total;
		this.list = list;
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
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
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
		public ExpenseItemPO() {
			// TODO Auto-generated constructor stub
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

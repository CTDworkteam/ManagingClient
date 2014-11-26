package vo;

public class FinanceItemVO {
	private String account;
	private double money;
	private String note;
	public FinanceItemVO(String account, double money, String note) {
		super();
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

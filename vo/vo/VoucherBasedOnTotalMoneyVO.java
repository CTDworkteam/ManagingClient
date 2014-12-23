package vo;

public class VoucherBasedOnTotalMoneyVO {
	private String id;
	private double money;
	private double upper;
	private double lower;
	public VoucherBasedOnTotalMoneyVO(String id, double money, double upper,
			double lower) {
		this.id = id;
		this.money = money;
		this.upper = upper;
		this.lower = lower;
	}
	public VoucherBasedOnTotalMoneyVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getUpper() {
		return upper;
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
	public double getLower() {
		return lower;
	}
	public void setLower(double lower) {
		this.lower = lower;
	}
}
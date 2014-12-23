package po;

public class VoucherBasedOnTotalMoneyPO {
	//ID:VBOTM2014122300001
	private String id;
	private double money;
	private double lower;
	private double upper;
	public VoucherBasedOnTotalMoneyPO(String id, double money, double lower,
			double upper) {
		this.id = id;
		this.money = money;
		this.lower = lower;
		this.upper = upper;
	}
	public VoucherBasedOnTotalMoneyPO() {
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
	public double getLower() {
		return lower;
	}
	public void setLower(double lower) {
		this.lower = lower;
	}
	public double getUpper() {
		return upper;
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
}

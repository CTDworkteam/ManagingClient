package vo;

public class InVO {
	private double salesIn;
	private double overflowIn;
	private double baseChangeIn;
	private double returnIn;
	private double voucherIn;
	private double discount;
	private double total;
	public InVO(double salesIn, double overflowIn, double baseChangeIn,
			double returnIn, double voucherIn, double discount, double total) {
		super();
		this.salesIn = salesIn;
		this.overflowIn = overflowIn;
		this.baseChangeIn = baseChangeIn;
		this.returnIn = returnIn;
		this.voucherIn = voucherIn;
		this.discount = discount;
		this.total = total;
	}
	public double getSalesIn() {
		return salesIn;
	}
	public void setSalesIn(double salesIn) {
		this.salesIn = salesIn;
	}
	public double getOverflowIn() {
		return overflowIn;
	}
	public void setOverflowIn(double overflowIn) {
		this.overflowIn = overflowIn;
	}
	public double getBaseChangeIn() {
		return baseChangeIn;
	}
	public void setBaseChangeIn(double baseChangeIn) {
		this.baseChangeIn = baseChangeIn;
	}
	public double getReturnIn() {
		return returnIn;
	}
	public void setReturnIn(double returnIn) {
		this.returnIn = returnIn;
	}
	public double getVoucherIn() {
		return voucherIn;
	}
	public void setVoucherIn(double voucherIn) {
		this.voucherIn = voucherIn;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}

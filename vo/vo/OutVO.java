package vo;

public class OutVO {
	private double salesBase;
	private double underflowOut;
	private double giftOut;
	private double total;
	public OutVO(double salesBase, double underflowOut, double giftOut,
			double total) {
		super();
		this.salesBase = salesBase;
		this.underflowOut = underflowOut;
		this.giftOut = giftOut;
		this.total = total;
	}
	public double getSalesBase() {
		return salesBase;
	}
	public void setSalesBase(double salesBase) {
		this.salesBase = salesBase;
	}
	public double getUnderflowOut() {
		return underflowOut;
	}
	public void setUnderflowOut(double underflowOut) {
		this.underflowOut = underflowOut;
	}
	public double getGiftOut() {
		return giftOut;
	}
	public void setGiftOut(double giftOut) {
		this.giftOut = giftOut;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}

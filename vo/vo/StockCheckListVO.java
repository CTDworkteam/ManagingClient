package vo;

public class StockCheckListVO {
	private String start;
	private String end;
	private int inNumber;
	private int outNumber;
	private double inMoney;
	private double outMoney;
	private int purchaseNumber;
	private int salesNumber;
	private double purchaseMoney;
	private double salesMoney;
	private int totalNumber;
	public StockCheckListVO(String start, String end, int inNumber,
			int outNumber, double inMoney, double outMoney, int purchaseNumber,
			int salesNumber, double purchaseMoney, double salesMoney,
			int totalNumber, double totalMoney) {
		super();
		this.start = start;
		this.end = end;
		this.inNumber = inNumber;
		this.outNumber = outNumber;
		this.inMoney = inMoney;
		this.outMoney = outMoney;
		this.purchaseNumber = purchaseNumber;
		this.salesNumber = salesNumber;
		this.purchaseMoney = purchaseMoney;
		this.salesMoney = salesMoney;
		this.totalNumber = totalNumber;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getInNumber() {
		return inNumber;
	}
	public void setInNumber(int inNumber) {
		this.inNumber = inNumber;
	}
	public int getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(int outNumber) {
		this.outNumber = outNumber;
	}
	public double getInMoney() {
		return inMoney;
	}
	public void setInMoney(double inMoney) {
		this.inMoney = inMoney;
	}
	public double getOutMoney() {
		return outMoney;
	}
	public void setOutMoney(double outMoney) {
		this.outMoney = outMoney;
	}
	public int getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(int purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public int getSalesNumber() {
		return salesNumber;
	}
	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}
	public double getPurchaseMoney() {
		return purchaseMoney;
	}
	public void setPurchaseMoney(double purchaseMoney) {
		this.purchaseMoney = purchaseMoney;
	}
	public double getSalesMoney() {
		return salesMoney;
	}
	public void setSalesMoney(double salesMoney) {
		this.salesMoney = salesMoney;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
}

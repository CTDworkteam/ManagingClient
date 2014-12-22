package vo;

public class StockCommodityInfoVO {
	private String name;
	private String model;
	private int numInStock;
	private double average;
	private long batch;
	private long batchNumber;
	private String date;
	public StockCommodityInfoVO(String name, String model, int numInStock,
			double average, long batch, long batchNumber, String date) {
		super();
		this.name = name;
		this.model = model;
		this.numInStock = numInStock;
		this.average = average;
		this.batch = batch;
		this.batchNumber = batchNumber;
		this.date = date;
	}
	public StockCommodityInfoVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumInStock() {
		return numInStock;
	}
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public long getBatch() {
		return batch;
	}
	public void setBatch(long batch) {
		this.batch = batch;
	}
	public long getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(long batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

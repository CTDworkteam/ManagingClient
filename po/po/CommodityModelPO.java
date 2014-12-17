package po;

public class CommodityModelPO implements java.io.Serializable{
	private String name;//commodity's name
	private String model;
	private int stock;
	private String storehouse;
	private int noticeNumber;
	private double purchasePrice;
	private double retailPrice;
	private double recentPurchasePrice;
	private double recentRetailPrice;
	public CommodityModelPO(String name,String model, int stock, String storehouse,
			int noticeNumber, double purchasePrice, double retailPrice,
			double recentPurchasePrice, double recentRetailPrice) {
		super();
		this.name = name;
		this.model =model;
		this.stock = stock;
		this.storehouse = storehouse;
		this.noticeNumber = noticeNumber;
		this.purchasePrice = purchasePrice;
		this.retailPrice = retailPrice;
		this.recentPurchasePrice = recentPurchasePrice;
		this.recentRetailPrice = recentRetailPrice;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public double getRecentPurchasePrice() {
		return recentPurchasePrice;
	}
	public void setRecentPurchasePrice(double recentPurchasePrice) {
		this.recentPurchasePrice = recentPurchasePrice;
	}
	public double getRecentRetailPrice() {
		return recentRetailPrice;
	}
	public void setRecentRetailPrice(double recentRetailPrice) {
		this.recentRetailPrice = recentRetailPrice;
	}
}

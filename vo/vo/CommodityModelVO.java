package vo;

public class CommodityModelVO {
	private String commodity;//commodity's id
	private String model;
	private String storehouse;
	private int noticeNumber;
	private int stockNumber;
	private double purchasePrice;
	private double retailPrice;
	private double recentPurchasePrice;
	private double recentRetailPrice;
	public CommodityModelVO(String commodity, String model, String storehouse,
			int noticeNumber, int stockNumber, double purchasePrice,
			double retailPrice, double recentPurchasePrice,
			double recentRetailPrice) {
		super();
		this.commodity = commodity;
		this.model = model;
		this.storehouse = storehouse;
		this.noticeNumber = noticeNumber;
		this.stockNumber = stockNumber;
		this.purchasePrice = purchasePrice;
		this.retailPrice = retailPrice;
		this.recentPurchasePrice = recentPurchasePrice;
		this.recentRetailPrice = recentRetailPrice;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public int getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
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

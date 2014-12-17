package po;
import java.util.ArrayList;
public class CommodityPO implements java.io.Serializable{
	private String id;
	private String name;
	private String typeid;
	private int total;
	private ArrayList<CommodityPO.CommodityModelPO> list;
	public CommodityPO(String id, String name, String type, int total,
			ArrayList<CommodityPO.CommodityModelPO> list) {
		this.id = id;
		this.name = name;
		this.typeid = type;
		this.total = total;
		this.list = list;
	}
	public CommodityPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return typeid;
	}
	public void setType(String type) {
		this.typeid = type;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<CommodityModelPO> getList() {
		return list;
	}
	public void setList(ArrayList<CommodityModelPO> list) {
		this.list = list;
	}
	public class CommodityModelPO implements java.io.Serializable{
		private String name;
		private int stock;
		private String storehouse;
		private int noticeNumber;
		private double purchasePrice;
		private double retailPrice;
		private double recentPurchasePrice;
		private double recentRetailPrice;
		public CommodityModelPO(String name, int stock, String storehouse,
				int noticeNumber, double purchasePrice, double retailPrice,
				double recentPurchasePrice, double recentRetailPrice) {
			super();
			this.name = name;
			this.stock = stock;
			this.storehouse = storehouse;
			this.noticeNumber = noticeNumber;
			this.purchasePrice = purchasePrice;
			this.retailPrice = retailPrice;
			this.recentPurchasePrice = recentPurchasePrice;
			this.recentRetailPrice = recentRetailPrice;
		}
		public CommodityModelPO() {
			// TODO 自动生成的构造函数存根
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
}

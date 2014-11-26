package po;

import java.util.ArrayList;

public class SalesReturnBillPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private ClientPO client;
	private String defaultOperator;
	private UserPO operator;
	private String storehouse;
	private ArrayList<SalesReturnBillItemPO> list;
	private double initialTotal;
	private double discount;
	private double voucher;
	private double total;
	private String note;
	public SalesReturnBillPO(String id, ClientPO client, String defaultOperator,
			UserPO operator, String storehouse,
			ArrayList<SalesReturnBillItemPO> list, double initialTotal,
			double discount, double voucher, double total, String note) {
		this.id = id;
		this.client = client;
		this.defaultOperator = defaultOperator;
		this.operator = operator;
		this.storehouse = storehouse;
		this.list = list;
		this.initialTotal = initialTotal;
		this.discount = discount;
		this.voucher = voucher;
		this.total = total;
		this.note = note;
		this.isPassed=false;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ClientPO getClient() {
		return client;
	}
	public void setClient(ClientPO client) {
		this.client = client;
	}
	public String getDefaultOperator() {
		return defaultOperator;
	}
	public void setDefaultOperator(String defaultOperator) {
		this.defaultOperator = defaultOperator;
	}
	public UserPO getOperator() {
		return operator;
	}
	public void setOperator(UserPO operator) {
		this.operator = operator;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public ArrayList<SalesReturnBillItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<SalesReturnBillItemPO> list) {
		this.list = list;
	}
	public double getInitialTotal() {
		return initialTotal;
	}
	public void setInitialTotal(double initialTotal) {
		this.initialTotal = initialTotal;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public class SalesReturnBillItemPO implements java.io.Serializable{
		private CommodityPO commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public SalesReturnBillItemPO(CommodityPO commodity, String model, int number,
				double price, String note) {
			this.commodity = commodity;
			this.model = model;
			this.number = number;
			this.price = price;
			this.note = note;
			this.total=price*(double)number;
		}
		public CommodityPO getCommodity() {
			return commodity;
		}
		public void setCommodity(CommodityPO commodity) {
			this.commodity = commodity;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}	
	}
}

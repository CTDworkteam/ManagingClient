package po;

import java.util.ArrayList;

public class SalesReturnBillPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5175571749909044150L;
	private boolean isPassed;
	private String id;
	private long clientID;
	private String defaultOperator;
	private String operator;
	private String storehouse;
	private ArrayList<SalesReturnBillItemPO> list;
	private double initialTotal;
	private double discount;
	private double voucher;
	private double total;
	private String note;
	public SalesReturnBillPO(){
	}
	public SalesReturnBillPO(boolean isPassed, String id, long clientID,
			String defaultOperator, String operator, String storehouse,
			ArrayList<SalesReturnBillItemPO> list, double initialTotal,
			double discount, double voucher, double total, String note) {
		this.isPassed = isPassed;
		this.id = id;
		this.clientID = clientID;
		this.defaultOperator = defaultOperator;
		this.operator = operator;
		this.storehouse = storehouse;
		this.list = list;
		this.initialTotal = initialTotal;
		this.discount = discount;
		this.voucher = voucher;
		this.total = total;
		this.note = note;
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
	public long getClientID() {
		return clientID;
	}
	public void setClientID(long clientID) {
		this.clientID = clientID;
	}
	public String getDefaultOperator() {
		return defaultOperator;
	}
	public void setDefaultOperator(String defaultOperator) {
		this.defaultOperator = defaultOperator;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
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
		/**
		 * 
		 */
		private static final long serialVersionUID = -2344203197391146238L;
		private String commodityID;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public SalesReturnBillItemPO(){
		}
		public SalesReturnBillItemPO(String commodityID, String model, int number,
				double price, double total, String note) {
			this.commodityID = commodityID;
			this.model = model;
			this.number = number;
			this.price = price;
			this.total = total;
			this.note = note;
		}
		public String getCommodityID() {
			return commodityID;
		}
		public void setCommodityID(String commodityID) {
			this.commodityID = commodityID;
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

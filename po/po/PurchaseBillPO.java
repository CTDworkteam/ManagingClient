package po;

import java.util.ArrayList;

public class PurchaseBillPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7077011420090905255L;
	private boolean isPassed;
	private String id;
	private String supplier;
	private String storehouse;
	private String operator;
	private ArrayList<PurchaseBillItemPO> list;
	private double total;
	private String note;
	public PurchaseBillPO(){
	}
	public PurchaseBillPO(boolean isPassed, String id, String supplier,
			String storehouse, String operator,
			ArrayList<PurchaseBillItemPO> list, double total, String note) {
		this.isPassed = isPassed;
		this.id = id;
		this.supplier = supplier;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public ArrayList<PurchaseBillItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<PurchaseBillItemPO> list) {
		this.list = list;
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
	public class PurchaseBillItemPO implements java.io.Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8692245763629895558L;
		private String commodityID;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public PurchaseBillItemPO(){
		}
		public PurchaseBillItemPO(String commodityID, String model, int number,
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
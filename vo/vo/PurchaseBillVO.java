package vo;

import java.util.ArrayList;

public class PurchaseBillVO {
	private boolean isPassed;
	private String id;
	private String supplier;
	private String storehouse;
	private String operator;
	private ArrayList<PurchaseBillItemVO> list;
	private double total;
	private String note;	
	public PurchaseBillVO(String id, String supplier, String storehouse,
			String operator, ArrayList<PurchaseBillItemVO> list, double total,
			String note) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
		this.total = total;
		this.note = note;
		this.isPassed=false;
	}
	public PurchaseBillVO() {
		// TODO 自动生成的构造函数存根
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
	public ArrayList<PurchaseBillItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<PurchaseBillItemVO> list) {
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
	public class PurchaseBillItemVO{
		private String commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public PurchaseBillItemVO(String commodity, String model, int number,
				double price, double total, String note) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
			this.price = price;
			this.total = total;
			this.note = note;
		}
		public PurchaseBillItemVO() {
			// TODO 自动生成的构造函数存根
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

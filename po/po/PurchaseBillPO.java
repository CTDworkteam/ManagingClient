package po;

import java.util.ArrayList;

public class PurchaseBillPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private ClientPO supplier;
	private String storehouse;
	private UserPO operator;
	private ArrayList<PurchaseBillItemPO> list;
	private double total;
	private String note;	
	public PurchaseBillPO(String id, ClientPO supplier, String storehouse,
			UserPO operator, ArrayList<PurchaseBillItemPO> list, double total,
			String note) {
		this.id = id;
		this.supplier = supplier;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
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
	public ClientPO getSupplier() {
		return supplier;
	}
	public void setSupplier(ClientPO supplier) {
		this.supplier = supplier;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public UserPO getOperator() {
		return operator;
	}
	public void setOperator(UserPO operator) {
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
		private CommodityPO commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public PurchaseBillItemPO(CommodityPO commodity,String model,int number,
				double price,String note){
			this.commodity=commodity;
			this.model=model;
			this.number=number;
			this.price=price;
			this.note=note;
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

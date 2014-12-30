package po;

import java.util.ArrayList;

public class GiftBillPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699891924523284804L;
	private boolean isPassed;
	private String id;
	private long clientID;
	private String storehouse;
	private String operator;
	private ArrayList<GiftBillItemPO> list;
	private String note;
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
	public ArrayList<GiftBillItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<GiftBillItemPO> list) {
		this.list = list;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public GiftBillPO(boolean isPassed, String id, long clientID,
			String storehouse, String operator, ArrayList<GiftBillItemPO> list,
			String note) {
		this.isPassed = isPassed;
		this.id = id;
		this.clientID = clientID;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
		this.note = note;
	}
	public GiftBillPO(){
	}
	public class GiftBillItemPO implements java.io.Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1038139684132440361L;
		private String commodityID;
		private String model;
		private int number;
		public GiftBillItemPO(){
		}
		public GiftBillItemPO(String commodityID, String model, int number) {
			this.commodityID = commodityID;
			this.model = model;
			this.number = number;
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
	}
}


package vo;

import java.util.ArrayList;

public class GiftBillVO {
	private boolean isPassed;
	private String id;
	private String client;
	private String storehouse;
	private String operator;
	private ArrayList<GiftBillItemVO> list;
	public GiftBillVO(String id, String client, String storehouse,
			String operator, ArrayList<GiftBillItemVO> list) {
		super();
		this.id = id;
		this.client = client;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
		this.isPassed=false;
	}
	public GiftBillVO() {
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
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
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
	public ArrayList<GiftBillItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<GiftBillItemVO> list) {
		this.list = list;
	}
	public class GiftBillItemVO{
		private String commodity;
		private String model;
		private int number;
		public GiftBillItemVO(String commodity, String model, int number) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
		}
		public GiftBillItemVO() {
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
	}
}

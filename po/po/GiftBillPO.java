package po;

import java.util.ArrayList;

public class GiftBillPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private ClientPO client;
	private String storehouse;
	private UserPO operator;
	private ArrayList<GiftBillItemPO> list;
	public GiftBillPO(String id, ClientPO client, String storehouse,
			UserPO operator, ArrayList<GiftBillItemPO> list) {
		this.id = id;
		this.client = client;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
		this.isPassed=false;
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

	public ArrayList<GiftBillItemPO> getList() {
		return list;
	}

	public void setList(ArrayList<GiftBillItemPO> list) {
		this.list = list;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}

	public class GiftBillItemPO implements java.io.Serializable{
		private CommodityPO commodity;
		private String model;
		private int number;
		public GiftBillItemPO(CommodityPO commodity, String model,int number) {
			this.commodity = commodity;
			this.number = number;
			this.model=model;
		}
		public CommodityPO getCommodity() {
			return commodity;
		}
		public void setCommodity(CommodityPO commodity) {
			this.commodity = commodity;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
	}

}


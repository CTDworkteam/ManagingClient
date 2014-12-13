package po;
import java.util.*;
public class GiftStrategyPO implements java.io.Serializable{
	public class GiftItemPO implements java.io.Serializable{
		private String commodityID;
		private String model;
		private int number;
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
		public GiftItemPO(){
		}
		public GiftItemPO(String commodityID, String model, int number) {
			super();
			this.commodityID = commodityID;
			this.model = model;
			this.number = number;
		}
	}
	private String id;
	private ArrayList<GiftItemPO> itemlist;
	private ArrayList<String> clientList;
	private String operator;
	public GiftStrategyPO(String id, String operator,
			ArrayList<String> clientList, ArrayList<GiftItemPO> itemlist) {
		this.id = id;
		this.itemlist = itemlist;
		this.clientList = clientList;
		this.operator = operator;
	}
	public GiftStrategyPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<GiftItemPO> getItemlist() {
		return itemlist;
	}
	public void setItemlist(ArrayList<GiftItemPO> itemlist) {
		this.itemlist = itemlist;
	}
	public ArrayList<String> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<String> clientList) {
		this.clientList = clientList;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}

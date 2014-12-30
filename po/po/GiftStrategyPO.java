package po;
import java.util.*;
public class GiftStrategyPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2780702677643755342L;
	public class GiftItemPO implements java.io.Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -6059673036093425848L;
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
	private int rank;
	private String operator;
	public GiftStrategyPO(){
	}
	public GiftStrategyPO(String id, ArrayList<GiftItemPO> itemlist, int rank,
			String operator) {
		super();
		this.id = id;
		this.itemlist = itemlist;
		this.rank = rank;
		this.operator = operator;
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
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
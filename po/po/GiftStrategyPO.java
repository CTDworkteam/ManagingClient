package po;
import java.util.*;
public class GiftStrategyPO implements java.io.Serializable{
	public class GiftItemPO implements java.io.Serializable{
		private CommodityPO commodity;
		private String model;
		private int number;
		private GiftItemPO next;
		public GiftItemPO(CommodityPO commodity, String model, int number,
				GiftItemPO next) {
			this.commodity = commodity;
			this.model = model;
			this.number = number;
			this.next = next;
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
		public GiftItemPO getNext() {
			return next;
		}
		public void setNext(GiftItemPO next) {
			this.next = next;
		}
	}
	private String id;
	private GiftItemPO first;
	private GiftItemPO last;
	private ArrayList<ClientPO> clientList;
	private UserPO operator;
	public GiftStrategyPO(String id, GiftItemPO first, GiftItemPO last,
			ArrayList<ClientPO> clientList, UserPO operator) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.clientList = clientList;
		this.operator = operator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GiftItemPO getFirst() {
		return first;
	}
	public void setFirst(GiftItemPO first) {
		this.first = first;
	}
	public GiftItemPO getLast() {
		return last;
	}
	public void setLast(GiftItemPO last) {
		this.last = last;
	}
	public ArrayList<ClientPO> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<ClientPO> clientList) {
		this.clientList = clientList;
	}
	public UserPO getOperator() {
		return operator;
	}
	public void setOperator(UserPO operator) {
		this.operator = operator;
	}
}

package vo;

import java.util.ArrayList;

public class GiftStrategyVO {
	public class GiftItemVO {
		private String commodity;
		private String model;
		private int number;
		public GiftItemVO(String commodity, String model, int number) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
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
	private String id;
	private ArrayList<String> clientList;
	private String operator;
	private ArrayList<GiftItemVO> list;
	public GiftStrategyVO(String id, ArrayList<String> clientList,
			String operator, ArrayList<GiftItemVO> list) {
		super();
		this.id = id;
		this.clientList = clientList;
		this.operator = operator;
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public ArrayList<GiftItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<GiftItemVO> list) {
		this.list = list;
	}	
	
}

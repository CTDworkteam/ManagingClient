package vo;

import java.util.ArrayList;

import financecheckbl.DetailListItem;

public class DetailListVO {
	private String start;
	private String end;
	private String commodity;
	private String operator;
	private String client;
	private String storehouse;
	private ArrayList<DetailListItemVO> list;
	public DetailListVO(String start, String end, String commodity,
			String operator, String client, String storehouse,
			ArrayList<DetailListItemVO> list) {
		super();
		this.start = start;
		this.end = end;
		this.commodity = commodity;
		this.operator = operator;
		this.client = client;
		this.storehouse = storehouse;
		this.list = list;
	}
	public DetailListVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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
	public ArrayList<DetailListItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<DetailListItemVO> list) {
		this.list = list;
	}
	public class DetailListItemVO{
		private String date;
		private String commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		public DetailListItemVO(String date, String commodity, String model,
				int number, double price, double total) {
			super();
			this.date = date;
			this.commodity = commodity;
			this.model = model;
			this.number = number;
			this.price = price;
			this.total = total;
		}
		public DetailListItemVO() {
			// TODO 自动生成的构造函数存根
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
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
		public void update(DetailListItem item){
			
		}
		public DetailListItem makeItem(){
			return null;
		}
	}
}

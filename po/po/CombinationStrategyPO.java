package po;
import java.util.ArrayList;
public class CombinationStrategyPO implements java.io.Serializable{
	//ID:COMBINATION2014122300001
	private String id;
	private ArrayList<CombinationItemPO> list;
	private double total;
	public CombinationStrategyPO(String id, ArrayList<CombinationItemPO> list, double total) {
		this.id = id;
		this.list = list;
		this.total = total;
	}
	public CombinationStrategyPO() {
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<CombinationItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<CombinationItemPO> list) {
		this.list = list;
	}
	public double getTotal(){
		return total;
	}
	public void setTotal(double total){
		this.total=total;
	}
	public class CombinationItemPO implements java.io.Serializable{
		private String commodityID;
		private String model;
		private int number;
		public CombinationItemPO(String commodityID, String model, int number) {
			super();
			this.commodityID = commodityID;
			this.model = model;
			this.number = number;
		}
		public CombinationItemPO() {
			// TODO 自动生成的构造函数存根
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

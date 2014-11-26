package po;
import java.util.ArrayList;
public class CombinationStrategyPO implements java.io.Serializable{
	private String id;
	private ArrayList<CombinationItemPO> list;
	private double initialMoney;
	private double laterMoney;
	public CombinationStrategyPO(String id, ArrayList<CombinationItemPO> list,
			double initialMoney, double laterMoney) {
		this.id = id;
		this.list = list;
		this.initialMoney = initialMoney;
		this.laterMoney = laterMoney;
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
	public double getInitialMoney() {
		return initialMoney;
	}
	public void setInitialMoney(double initialMoney) {
		this.initialMoney = initialMoney;
	}
	public double getLaterMoney() {
		return laterMoney;
	}
	public void setLaterMoney(double laterMoney) {
		this.laterMoney = laterMoney;
	}
	public class CombinationItemPO implements java.io.Serializable{
		private CommodityPO commodity;
		private String model;
		private int number;
		public CombinationItemPO(CommodityPO commodity, String model, int number) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
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
	}
}

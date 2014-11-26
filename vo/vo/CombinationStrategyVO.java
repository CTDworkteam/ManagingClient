package vo;
import java.util.ArrayList;
public class CombinationStrategyVO {
	private String id;
	private ArrayList<CombinationItemVO> list;
	private double initialMoney;
	private double laterMoney;
	public CombinationStrategyVO(String id, ArrayList<CombinationItemVO> list,
			double initialMoney, double laterMoney) {
		super();
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
	public ArrayList<CombinationItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<CombinationItemVO> list) {
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
	public class CombinationItemVO{
		private String commodity;
		private String model;
		private int number;
		public CombinationItemVO(String commodity, String model, int number) {
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
}

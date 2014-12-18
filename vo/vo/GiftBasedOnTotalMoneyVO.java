package vo;
import java.util.*;
public class GiftBasedOnTotalMoneyVO {
	private String id;
	private double lower;
	private double upper;
	private ArrayList<GBOTMItemVO> list;
	public GiftBasedOnTotalMoneyVO(double lower, double upper,
			ArrayList<GBOTMItemVO> list) {
		super();
		this.lower = lower;
		this.upper = upper;
		this.list = list;
	}
	public GiftBasedOnTotalMoneyVO() {
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLower() {
		return lower;
	}
	public void setLower(double lower) {
		this.lower = lower;
	}
	public double getUpper() {
		return upper;
	}
	public void setUpper(double upper) {
		this.upper = upper;
	}
	public ArrayList<GBOTMItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<GBOTMItemVO> list) {
		this.list = list;
	}
	public class GBOTMItemVO{
		private String commodity;
		private String model;
		private int number;
		public GBOTMItemVO( String commodity, String model, int number) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
		}
		public GBOTMItemVO() {
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

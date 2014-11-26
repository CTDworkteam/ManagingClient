package po;
import java.util.*;
public class GiftBasedOnTotalMoneyPO {
	private String id;
	private double lower;
	private double upper;
	private ArrayList<GBOTMItemPO> list;
	public GiftBasedOnTotalMoneyPO(double lower, double upper,
			ArrayList<GBOTMItemPO> list) {
		super();
		this.lower = lower;
		this.upper = upper;
		this.list = list;
	}
	public String getID(){
		return id;
	}
	public void setID(String id){
		this.id=id;
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
	public ArrayList<GBOTMItemPO> getList() {
		return list;
	}
	public void setList(ArrayList<GBOTMItemPO> list) {
		this.list = list;
	}
	public class GBOTMItemPO{
		private CommodityPO commodity;
		private String model;
		private int number;
		public GBOTMItemPO(CommodityPO commodity, int number) {
			super();
			this.commodity = commodity;
			this.number = number;
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
	}
}

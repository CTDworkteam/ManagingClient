package po;
import java.util.*;
public class GiftBasedOnTotalMoneyPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4394990357791305488L;
	private String id;
	private double lower;
	private double upper;
	private ArrayList<GBOTMItemPO> list;
	public GiftBasedOnTotalMoneyPO(String id,double lower, double upper,
			ArrayList<GBOTMItemPO> list) {
		this.id=id;
		this.lower = lower;
		this.upper = upper;
		this.list = list;
	}
	public GiftBasedOnTotalMoneyPO() {
		// TODO 自动生成的构造函数存根
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
		private String commodityid;
		private String model;
		private int number;
		public GBOTMItemPO(){
		}
		public GBOTMItemPO(String commodityid, String model, int number) {
			this.commodityid = commodityid;
			this.model = model;
			this.number = number;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public String getCommodityid() {
			return commodityid;
		}
		public void setCommodityid(String commodityid) {
			this.commodityid = commodityid;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		
	}
}

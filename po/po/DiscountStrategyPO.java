package po;
public class DiscountStrategyPO implements java.io.Serializable{
	//ID:DISCOUNT2014122300001
	private String id;
	private double discount;
	private int rank;
	public DiscountStrategyPO(){
	}
	public DiscountStrategyPO(String id, double discount, int rank) {
		super();
		this.id = id;
		this.discount = discount;
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
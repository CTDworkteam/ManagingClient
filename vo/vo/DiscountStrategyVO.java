package vo;
public class DiscountStrategyVO {
	private String id;
	private double discount;
	private int rank;
	public DiscountStrategyVO(){
	}
	public DiscountStrategyVO(String id, double discount, int rank) {
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
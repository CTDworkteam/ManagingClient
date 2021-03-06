package po;

public class VoucherStrategyPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3019873137675505214L;
	private String id;
	private double voucher;
	private int rank;
	public VoucherStrategyPO(){
	}
	public VoucherStrategyPO(String id, double voucher, int rank) {
		super();
		this.id = id;
		this.voucher = voucher;
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
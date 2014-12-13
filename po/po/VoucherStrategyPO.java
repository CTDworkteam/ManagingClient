package po;

import java.util.ArrayList;

public class VoucherStrategyPO implements java.io.Serializable{
	private String id;
	private double voucher;
	private ArrayList<String> clientList;
	public VoucherStrategyPO(String id, double voucher,
			ArrayList<String> clientList) {
		super();
		this.id = id;
		this.voucher = voucher;
		this.clientList = clientList;
	}
	public VoucherStrategyPO() {
		// TODO 自动生成的构造函数存根
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
	public ArrayList<String> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<String> clientList) {
		this.clientList = clientList;
	}
}

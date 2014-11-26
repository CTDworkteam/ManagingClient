package vo;

import java.util.ArrayList;

public class VoucherStrategyVO {
	private String id;
	private double voucher;
	private ArrayList<String> clientList;
	public VoucherStrategyVO(String id, double voucher,
			ArrayList<String> clientList) {
		super();
		this.id = id;
		this.voucher = voucher;
		this.clientList = clientList;
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

package po;

import java.util.ArrayList;

public class VoucherStrategyPO implements java.io.Serializable{
	private String id;
	private double voucher;
	private ArrayList<ClientPO> clientList;
	public VoucherStrategyPO(String id, double voucher,
			ArrayList<ClientPO> clientList) {
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
	public ArrayList<ClientPO> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<ClientPO> clientList) {
		this.clientList = clientList;
	}
}

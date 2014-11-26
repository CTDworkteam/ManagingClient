package vo;
import java.util.ArrayList;
public class DiscountStrategyVO {
	private String id;
	private double discount;
	private ArrayList<String> clientList;
	public DiscountStrategyVO(String id, double discount,
			ArrayList<String> clientList) {
		super();
		this.id = id;
		this.discount = discount;
		this.clientList = clientList;
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
	public ArrayList<String> getClientList() {
		return clientList;
	}
	public void setClientList(ArrayList<String> clientList) {
		this.clientList = clientList;
	}
}

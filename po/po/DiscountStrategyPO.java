package po;
import java.util.ArrayList;
public class DiscountStrategyPO implements java.io.Serializable{
	private String id;
	private double discount;
	private ArrayList<String> clientList;
	public DiscountStrategyPO(){
	}
	public DiscountStrategyPO(String id, double discount,
			ArrayList<String> clientList) {
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

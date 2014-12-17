package po;

import java.util.ArrayList;

public class InitialPO implements java.io.Serializable{
	private String id;
	private ArrayList<String> commodity;
	private ArrayList<String> type;
	private ArrayList<String> client;
	private ArrayList<String> account;
	public InitialPO(){
	}
	public InitialPO(String id, ArrayList<String> commodity,
			ArrayList<String> type, ArrayList<String> client,
			ArrayList<String> account) {
		this.id = id;
		this.commodity = commodity;
		this.type = type;
		this.client = client;
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getCommodity() {
		return commodity;
	}
	public void setCommodity(ArrayList<String> commodity) {
		this.commodity = commodity;
	}
	public ArrayList<String> getType() {
		return type;
	}
	public void setType(ArrayList<String> type) {
		this.type = type;
	}
	public ArrayList<String> getClient() {
		return client;
	}
	public void setClient(ArrayList<String> client) {
		this.client = client;
	}
	public ArrayList<String> getAccount() {
		return account;
	}
	public void setAccount(ArrayList<String> account) {
		this.account = account;
	}
}
package vo;

import java.util.ArrayList;

public class InitialVO {
	private String id;
	private ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
	private ArrayList<CommodityTypeVO> type=new ArrayList<CommodityTypeVO>();
	private ArrayList<ClientVO> client=new ArrayList<ClientVO>();
	private ArrayList<AccountVO> account=new ArrayList<AccountVO>();
	
	public InitialVO(ArrayList<CommodityVO> c,ArrayList<CommodityTypeVO> ct,ArrayList<ClientVO> cl,ArrayList<AccountVO> a){
		super();
		this.commodity=c;
		this.type=ct;
		this.client=cl;
		this.account=a;
	}
	
	public InitialVO() {
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<CommodityVO> getCommodityList(){
		return commodity;
	}
	
	public void setCommodityList(ArrayList<CommodityVO> c){
		this.commodity=c;
	}
	
	public ArrayList<CommodityTypeVO> getCommodityTypeList(){
		return type;
	}
	
	public void setCommodityTypeList(ArrayList<CommodityTypeVO> c){
		this.type=c;
	}
	
	public ArrayList<ClientVO> getClientList(){
		return client;
	}
	
	public void setClientList(ArrayList<ClientVO> c){
		this.client=c;
	}
	
	public ArrayList<AccountVO> getAccountList(){
		return account;
	}
	
	public void setAccountList(ArrayList<AccountVO> a){
		this.account=a;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<CommodityVO> getCommodity() {
		return commodity;
	}

	public void setCommodity(ArrayList<CommodityVO> commodity) {
		this.commodity = commodity;
	}

	public ArrayList<CommodityTypeVO> getType() {
		return type;
	}

	public void setType(ArrayList<CommodityTypeVO> type) {
		this.type = type;
	}

	public ArrayList<ClientVO> getClient() {
		return client;
	}

	public void setClient(ArrayList<ClientVO> client) {
		this.client = client;
	}

	public ArrayList<AccountVO> getAccount() {
		return account;
	}

	public void setAccount(ArrayList<AccountVO> account) {
		this.account = account;
	}
}

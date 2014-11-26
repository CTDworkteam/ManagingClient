package po;

import java.util.ArrayList;

public class InitialPO implements java.io.Serializable{
	private String id;
	private ArrayList<CommodityPO> commodity=new ArrayList<CommodityPO>();
	private ArrayList<CommodityTypePO> type=new ArrayList<CommodityTypePO>();
	private ArrayList<ClientPO> client=new ArrayList<ClientPO>();
	private ArrayList<AccountPO> account=new ArrayList<AccountPO>();
	
	public InitialPO(ArrayList<CommodityPO> c,ArrayList<CommodityTypePO> ct,ArrayList<ClientPO> cl,ArrayList<AccountPO> a){
		this.commodity=c;
		this.type=ct;
		this.client=cl;
		this.account=a;
	}
	public String getID(){
		return id;
	}
	public void setID(String id){
		this.id=id;
	}
	public ArrayList<CommodityPO> getCommodityList(){
		return commodity;
	}
	
	public void setCommodityList(ArrayList<CommodityPO> c){
		this.commodity=c;
	}
	
	public ArrayList<CommodityTypePO> getCommodityTypeList(){
		return type;
	}
	
	public void setCommodityTypeList(ArrayList<CommodityTypePO> c){
		this.type=c;
	}
	
	public ArrayList<ClientPO> getClientList(){
		return client;
	}
	
	public void setClientList(ArrayList<ClientPO> c){
		this.client=c;
	}
	
	public ArrayList<AccountPO> getAccountList(){
		return account;
	}
	
	public void setAccountList(ArrayList<AccountPO> a){
		this.account=a;
	}
}

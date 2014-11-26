package initialbl;

import java.util.ArrayList;

import clientbl.Client;
import accountbl.Account;
import commoditybl.Commodity;
import commoditytypebl.CommodityType;

public class Initial {
	public ArrayList<Commodity> commodity=new ArrayList<Commodity>();
	public ArrayList<CommodityType> type=new ArrayList<CommodityType>();
	public ArrayList<Client> client=new ArrayList<Client>();
	public ArrayList<Account> account=new ArrayList<Account>();
	
	public Initial(ArrayList<Commodity> c,ArrayList<CommodityType> ct,ArrayList<Client> cl,ArrayList<Account> a){
		this.commodity=c;
		this.type=ct;
		this.client=cl;
		this.account=a;
	}
	
	public Initial(){
	}
	
	public ArrayList<Commodity> getCommodityList(){
		return commodity;
	}
	
	public void setCommodityList(ArrayList<Commodity> c){
		this.commodity=c;
	}
	
	public ArrayList<CommodityType> getCommodityTypeList(){
		return type;
	}
	
	public void setCommodityTypeList(ArrayList<CommodityType> c){
		this.type=c;
	}
	
	public ArrayList<Client> getClientList(){
		return client;
	}
	
	public void setClientList(ArrayList<Client> c){
		this.client=c;
	}
	
	public ArrayList<Account> getAccountList(){
		return account;
	}
	
	public void setAccountList(ArrayList<Account> a){
		this.account=a;
	}
}

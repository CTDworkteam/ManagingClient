package initialbl;

import java.util.ArrayList;

import object.TypeTree;
import vo.AccountVO;
import vo.ClientVO;
import vo.CommodityTypeVO;
import vo.CommodityVO;
import accountbl.Account;
import clientbl.Client;
import commoditybl.Commodity;
import commoditytypebl.CommodityType;
import enumType.ResultMessage;

public class MockInitial extends Initial{
	ArrayList<Commodity> commodity=new ArrayList<Commodity>();
	ArrayList<CommodityType> type=new ArrayList<CommodityType>();
	ArrayList<Client> client=new ArrayList<Client>();
	ArrayList<Account> account=new ArrayList<Account>();
	MockInitial ini=new MockInitial(commodity,type,client,account);
	
	public MockInitial(){
	}
	
	public MockInitial(ArrayList<Commodity> c,ArrayList<CommodityType> t,
			ArrayList<Client> cl,ArrayList<Account> a){
		this.commodity=c;
		this.type=t;
		this.client=cl;
		this.account=a;
	}
	
	public ResultMessage addCommodityType(TypeTree<CommodityTypeVO> tree){
		return ResultMessage.Success;
	}
	
	public ResultMessage addCommodity(ArrayList<CommodityVO> list){
		for(int i=0;i<list.size();i++){
			for(int j=0;j<ini.getCommodityList().size();j++)
				if(list.get(i).getName().equals(ini.getCommodityList().get(j))
						&&list.get(i).getType().equals(ini.getCommodityList().get(j))){
					return ResultMessage.Failure;
				}
		}
		return ResultMessage.Failure;
	}
	
	public ResultMessage addClient(ArrayList<ClientVO> c){
		for(int i=0;i<c.size();i++){
			for(int j=0;j<ini.getClientList().size();j++)
				if(c.get(i).getName().equals(ini.getClientList().get(j))){
					return ResultMessage.Failure;
				}
		}
		return ResultMessage.Failure;
	}
	
	public ResultMessage addAccount(ArrayList<AccountVO> a){
		for(int i=0;i<a.size();i++){
			for(int j=0;j<ini.getAccountList().size();j++)
				if(a.get(i).getName().equals(ini.getAccountList().get(j))){
					return ResultMessage.Failure;
				}
		}
		return ResultMessage.Failure;
	}
}

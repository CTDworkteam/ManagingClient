package initialbl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import object.TypeTree;
import blservice.InitialBLService;
import po.InitialPO;
import vo.AccountVO;
import vo.ClientVO;
import vo.CommodityTypeVO;
import vo.CommodityVO;
import vo.InitialVO;
import clientbl.Client;
import accountbl.Account;
import commoditybl.Commodity;
import commoditytypebl.CommodityType;
import config.RMI;
import convert.Convert;
import dataservice.AccountDataService;
import dataservice.ClientDataService;
import dataservice.CommodityDataService;
import dataservice.CommodityTypeDataService;
import dataservice.InitialDataService;
import enumType.ResultMessage;

public class Initial implements InitialBLService{
	public Initial(){
	}
	
	public ResultMessage addCommodityType(ArrayList<CommodityTypeVO> tree){
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			CommodityType type = new CommodityType();
			ArrayList<String> po = new ArrayList<String>();
			
			for(int i = 0; i<tree.size(); i++){
				po.add(tree.get(i).getName());
				
				if(type.addType(tree.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			
			service.insert(new InitialPO("1",null,po,null,null));
			return ResultMessage.Success;
		}
	}

	public ResultMessage addCommodity(ArrayList<CommodityVO> list){
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Commodity commodity = new Commodity();
			ArrayList<String> po = new ArrayList<String>();
			
			for(int i = 0; i<list.size(); i++){
				po.add(list.get(i).getName());
				
				if(commodity.addCommodity(list.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			
			service.insert(new InitialPO("1",po,null,null,null));
			return ResultMessage.Success;
		}
	}

	public ResultMessage addClient(ArrayList<ClientVO> client){
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Client c = new Client();
			ArrayList<String> po=new ArrayList<String>();
	
			for(int i = 0; i<client.size(); i++){
				po.add(client.get(i).getName());
		
				if(c.add(client.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			service.insert(new InitialPO("1",null, null, po, null));
			return ResultMessage.Success;
		}
	}

	public ResultMessage addAccount(ArrayList<AccountVO> account){
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Account a = new Account();
			ArrayList<String> po = new ArrayList<String>();
		
			for(int i = 0; i<account.size(); i++){
				po.add(account.get(i).getName());
			
				if(a.add(account.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			service.insert(new InitialPO("1",null, null, null, po));
			return ResultMessage.Success;
		}
	}

	public InitialVO getInitialInfo(String id){
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			InitialPO po = service.find(id);
		
			if(po == null)
				return null;
			
			else
				return Convert.convert(po);
		}
	}

	public ArrayList<InitialVO> getList() {
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<InitialVO> result = new ArrayList<InitialVO>();
			Iterator<InitialPO> i = service.getAllInitials();
			
			while(i.hasNext()){
				result.add(Convert.convert(i.next()));
			}
			return result;
		}
	}

	public String getNewID(GregorianCalendar date) {
		InitialDataService service = RMI.getInitialDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id = "CSH";
			id+=date;
			return id;
		}
	}
}

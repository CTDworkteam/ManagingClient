package blservice_stub;
import java.util.*;
import commoditybl.Commodity;
import commoditytypebl.CommodityType;
import convert.Convert;
import dataservice_stub.*;
import enumType.ResultMessage;
import blservice.*;
import vo.*;
import po.*;
public class InitialBLServiceStub implements InitialBLService{
	private InitialDataServiceStub service = new InitialDataServiceStub();
	public InitialBLServiceStub(){
		
	}
	public ResultMessage addCommodityType(ArrayList<CommodityTypeVO> tree){
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
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ClientBLServiceStub c = new ClientBLServiceStub();
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
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			AccountBLServiceStub a = new AccountBLServiceStub();
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

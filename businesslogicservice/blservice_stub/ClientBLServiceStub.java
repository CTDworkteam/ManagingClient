package blservice_stub;
import java.util.*;
import po.ClientPO;
import vo.ClientVO;
import config.RMI;
import convert.Convert;
import dataservice.ClientDataService;
import dataservice_stub.*;
import enumType.ResultMessage;
import blservice.*;
public class ClientBLServiceStub implements ClientBLService{
	private ClientDataServiceStub service = new ClientDataServiceStub();
	public ClientBLServiceStub(){
		
	}
	public ResultMessage add(ClientVO vo) {    //该方法用于添加客户
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ClientPO po = Convert.convert(vo);
		
			if(!service.contain(vo.getName())){   //判断是否存在该客户
				service.insert(po);
				return ResultMessage.Success;
			}
			
			else{
				ClientPO temp = service.find(vo.getName());
				if(temp.getTelephone() == vo.getTelephone()){
					return ResultMessage.Failure;
				}
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage delete(ClientVO vo) {   //该方法用于删除client
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ClientPO po = Convert.convert(vo);
		
			//判断是否存在该客户                  //判断应付与应收是否相等
			if(service.contain(vo.getName()) &&
					(service.find(vo.getName()).getMoneyReserved() == 
					service.find(vo.getName()).getMoneyToPay())){   
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage update(ClientVO vo) {  //该方法用于更新客户信息
		if(service == null){
			return ResultMessage.Failure;
		}	
		
		else{
			ClientPO po = Convert.convert(vo);
			
			if(service.contain(vo.getName())) {     //判断是否存在该客户
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ClientVO find(long id) {  //该方法用于id查找客户
		if(service == null){
			return null;
		}
		
		else{
			ClientPO po = service.find(id);
			if(!(po == null)){   //判断是否存在该客户
				ClientVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ClientVO> finds(String key) {   //该方法用于关键词查找
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<ClientPO> po = service.findInKeyword(key);	
			if(!(po == null)) {     //判断是否存在客户
				for(int i = 0;i < po.size();i++) {
					ClientVO temp = Convert.convert(po.get(i));
					vo.add(temp);
				}
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ClientVO> getList() {    //该方法用于获取客户列表
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		if(service == null){
			return null;
		}
		
		else{
			Iterator<ClientPO> i = service.list();
			while(i.hasNext()) {                         //迭代器遍历
				vo.add(Convert.convert(i.next())); 
			}
			return vo;
		}
	}
	public long getNewClientID() {
		if(service == null){
			return -1;
		}
		
		else{
			return service.number()+1;
		}
	}
}

package clientbl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import blservice.ClientBLService;
import config.RMI;
import convert.Convert;
import po.ClientPO;
import vo.ClientVO;
import dataservice.ClientDataService;
import enumType.ClientType;
import enumType.ResultMessage;

public class Client implements ClientBLService{
	public Client(){
	}
	
	public ResultMessage add(ClientVO vo) {    //�÷���������ӿͻ�
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ClientPO po = Convert.convert(vo);
		
			if(!service.contain(vo.getName())){   //�ж��Ƿ���ڸÿͻ�
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

	public ResultMessage delete(ClientVO vo) {   //�÷�������ɾ���ͻ�
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ClientPO po = Convert.convert(vo);
		
			//�ж��Ƿ���ڸÿͻ�                  //�ж�Ӧ����Ӧ���Ƿ����
			if(service.contain(vo.getName()) &&
					(service.find(vo.getName()).getMoneyReserved() == 
					service.find(vo.getName()).getMoneyToPay())){   
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage update(ClientVO vo) {  //�÷������ڸ��¿ͻ���Ϣ
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}	
		
		else{
			ClientPO po = Convert.convert(vo);
			
			if(service.contain(vo.getName())) {     //�ж��Ƿ���ڸÿͻ�
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ClientVO find(long id) {  //�÷�������id���ҿͻ�
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ClientPO po = service.find(id);
			if(!(po == null)){   //�ж��Ƿ���ڸÿͻ�
				ClientVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ClientVO> finds(String key) {   //�÷������ڹؼ��ʲ���
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		ClientDataService service = RMI.getClientDataService();

		if(service == null){
			return null;
		}
		
		else{
			ArrayList<ClientPO> po = service.findInKeyword(key);	
			if(!(po == null)) {     //�ж��Ƿ���ڿͻ�
				for(int i = 0;i < po.size();i++) {
					ClientVO temp = Convert.convert(po.get(i));
					vo.add(temp);
				}
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ClientVO> getList() {    //�÷������ڻ�ȡ�ͻ��б�
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<ClientPO> i = service.list();
			while(i.hasNext()) {                         //����������
				vo.add(Convert.convert(i.next())); 
			}
			return vo;
		}
	}
	public long getNewClientID() {
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return -1;
		}
		
		else{
			return service.number()+1;
		}
	}
}
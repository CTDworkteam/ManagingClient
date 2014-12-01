package clientbl;

import java.rmi.Naming;
import java.util.*;
import java.util.Map.Entry;

import dataservice.ClientDataService;
import po.ClientPO;
import vo.ClientVO;
import enumType.ClientType;
import enumType.ResultMessage;

public class ClientImpl extends ClientController {
	public ResultMessage add(ClientVO vo) {    //�÷���������ӿͻ�
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/addClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
		
			if(!result){   //�ж��Ƿ���ڸÿͻ�
				service.insert(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage delete(ClientVO vo) {   //�÷�������ɾ���ͻ�
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/delClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
		
			if(result) {   //�ж��Ƿ���ڸÿͻ�
				if(service.find(vo.getName()).getMoneyReserved() == 
						service.find(vo.getName()).getMoneyToPay())   //�ж�Ӧ����Ӧ���Ƿ����
					service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage update(ClientVO vo) {  //�÷������ڸ��¿ͻ���Ϣ
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/updateClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
			
			if(result) {     //�ж��Ƿ���ڸÿͻ�
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ClientVO find(String id) {  //�÷�������id���ҿͻ�
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/findClientInID");
			ClientPO po = service.findInID(id);
			if(!(po == null)){   //�ж��Ƿ���ڸÿͻ�
				ClientVO vo = exchange(po);
				return vo;
			}
			return null;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ClientVO> finds(String key) {   //�÷������ڹؼ��ʲ���
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/findClientInKeyword");

			ArrayList<ClientPO> po = service.findInKeyword(key);	
			if(!(po == null)) {     //�ж��Ƿ���ڿͻ�
				for(int i = 0;i < po.size();i++) {
					ClientVO temp = exchange(po.get(i));
					vo.add(temp);
				}
				return vo;
			}
			return null;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ClientVO> getList() {    //�÷������ڻ�ȡ�ͻ��б�
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/getClientList");
			TreeMap<ClientType, TreeSet<ClientPO>> po = service.list();
			
			TreeSet<ClientPO> first = po.get(ClientType.Seller);   //��ò�ͬ���͵Ŀͻ�
			TreeSet<ClientPO> second = po.get(ClientType.Supplier);
			
			Iterator i = first.iterator();
			Iterator j = second.iterator();
			while(i.hasNext()) {                         //����������
				vo.add(exchange((ClientPO) i.next())); 
			}
			while(j.hasNext()) {                         //����������
				vo.add(exchange((ClientPO) j.next()));
			}
			return vo;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private ClientPO exchange(ClientVO vo) {   //VO����ת��ΪPO����
		ClientPO po = new ClientPO(vo.getId(),vo.getName(),vo.getType(),
				vo.getRank(),vo.getTelephone(),vo.getAddress(),vo.getPostcode(),
				vo.getEmail(),vo.getAmountReserved(),vo.getMoneyReserved(),
				vo.getMoneyToPay(),vo.getCourterman(),vo.getDiscount(),
				vo.getVoucher());
		return po;
	}
	
	private ClientVO exchange(ClientPO po) {    //PO����ת��ΪVO����
		ClientVO vo = new ClientVO(po.getId(),po.getName(),po.getType(),
				po.getRank(),po.getTelephone(),po.getAddress(),po.getPostcode(),
				po.getEmail(),po.getAmountReserved(),po.getMoneyReserved(),
				po.getMoneyToPay(),po.getCourterman(),po.getDiscount(),
				po.getVoucher());
		return vo;
	}
}

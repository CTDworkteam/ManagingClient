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
	public ResultMessage add(ClientVO vo) {    //该方法用于添加客户
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/addClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
		
			if(!result){   //判断是否存在该客户
				service.insert(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage delete(ClientVO vo) {   //该方法用于删除客户
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/delClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
		
			if(result) {   //判断是否存在该客户
				if(service.find(vo.getName()).getMoneyReserved() == 
						service.find(vo.getName()).getMoneyToPay())   //判断应付与应收是否相等
					service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage update(ClientVO vo) {  //该方法用于更新客户信息
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/updateClient");
		
			ClientPO po = exchange(vo);
			boolean result = service.contain(vo.getName());
			
			if(result) {     //判断是否存在该客户
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ClientVO find(String id) {  //该方法用于id查找客户
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/findClientInID");
			ClientPO po = service.findInID(id);
			if(!(po == null)){   //判断是否存在该客户
				ClientVO vo = exchange(po);
				return vo;
			}
			return null;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ClientVO> finds(String key) {   //该方法用于关键词查找
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/findClientInKeyword");

			ArrayList<ClientPO> po = service.findInKeyword(key);	
			if(!(po == null)) {     //判断是否存在客户
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
	
	public ArrayList<ClientVO> getList() {    //该方法用于获取客户列表
		ArrayList<ClientVO> vo = new ArrayList<ClientVO>();
		try {
			ClientDataService service = (ClientDataService) Naming.lookup("rmi://localhost:1099/getClientList");
			TreeMap<ClientType, TreeSet<ClientPO>> po = service.list();
			
			TreeSet<ClientPO> first = po.get(ClientType.Seller);   //获得不同类型的客户
			TreeSet<ClientPO> second = po.get(ClientType.Supplier);
			
			Iterator i = first.iterator();
			Iterator j = second.iterator();
			while(i.hasNext()) {                         //迭代器遍历
				vo.add(exchange((ClientPO) i.next())); 
			}
			while(j.hasNext()) {                         //迭代器遍历
				vo.add(exchange((ClientPO) j.next()));
			}
			return vo;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private ClientPO exchange(ClientVO vo) {   //VO对象转化为PO对象
		ClientPO po = new ClientPO(vo.getId(),vo.getName(),vo.getType(),
				vo.getRank(),vo.getTelephone(),vo.getAddress(),vo.getPostcode(),
				vo.getEmail(),vo.getAmountReserved(),vo.getMoneyReserved(),
				vo.getMoneyToPay(),vo.getCourterman(),vo.getDiscount(),
				vo.getVoucher());
		return po;
	}
	
	private ClientVO exchange(ClientPO po) {    //PO对象转化为VO对象
		ClientVO vo = new ClientVO(po.getId(),po.getName(),po.getType(),
				po.getRank(),po.getTelephone(),po.getAddress(),po.getPostcode(),
				po.getEmail(),po.getAmountReserved(),po.getMoneyReserved(),
				po.getMoneyToPay(),po.getCourterman(),po.getDiscount(),
				po.getVoucher());
		return vo;
	}
}

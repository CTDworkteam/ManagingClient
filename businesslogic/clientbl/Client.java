package clientbl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import config.RMI;
import po.ClientPO;
import vo.ClientVO;
import dataservice.ClientDataService;
import enumType.ClientType;
import enumType.ResultMessage;

public class Client{
	public String id;
	public ClientType type;
	public int rank;
	public String name;
	public String telephone;
	public String address;
	public String postcode;
	public String email;
	public double amountReserved;
	public double moneyReserved;
	public double moneyToPay;
	public String counterman;
	public double discount;
	public double voucher;
	public Client(){
	}
	public Client(String id, String name, ClientType type, int rank,
			String telephone, String address, String postcode, String email,
			double amountReserved, double moneyReserved, double moneyToPay,
			String courterman, double discount, double voucher) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.rank = rank;
		this.telephone = telephone;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.amountReserved = amountReserved;
		this.moneyReserved = moneyReserved;
		this.moneyToPay = moneyToPay;
		this.counterman = courterman;
		this.discount = discount;
		this.voucher = voucher;
	}
	public ResultMessage add(ClientVO vo) {    //该方法用于添加客户
		try {
			ClientDataService service = RMI.getClientDataService();
		
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
			ClientDataService service = RMI.getClientDataService();
		
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
			ClientDataService service = RMI.getClientDataService();
		
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
			ClientDataService service = RMI.getClientDataService();
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
			ClientDataService service = RMI.getClientDataService();

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
			ClientDataService service = RMI.getClientDataService();
			TreeMap<ClientType, TreeSet<ClientPO>> po = service.list();
			
			TreeSet<ClientPO> first = po.get(ClientType.Seller);   //获得不同类型的客户
			TreeSet<ClientPO> second = po.get(ClientType.Supplier);
			
			Iterator<ClientPO> i = first.iterator();
			Iterator<ClientPO> j = second.iterator();
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
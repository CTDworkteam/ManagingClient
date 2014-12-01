package initialbl;

import java.rmi.Naming;
import java.util.ArrayList;

import accountbl.AccountImpl;
import clientbl.ClientImpl;
import commoditybl.CommodityImpl;
import dataservice.*;
import object.TypeTree;
import po.*;
import vo.*;
import enumType.ResultMessage;

public class InitialImpl {
/*	public ResultMessage addCommodityType(TypeTree<CommodityTypeVO> tree){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage addCommodity(ArrayList<CommodityVO> list){
		try{
			InitialDataService service=(InitialDataService) Naming.lookup("rmi://localhost:1099/asdsd");
			CommodityDataService service2=(CommodityDataService) Naming.lookup("");
			CommodityImpl impl=new CommodityImpl();
			
			ArrayList<CommodityPO> po=new ArrayList<CommodityPO>();
			for(int i=0;i<list.size();i++){
				CommodityPO temp=exchange(list.get(i));
				po.add(temp);
				if(impl.addCommodity(list.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			service.insert(new InitialPO(po,null,null,null));
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	public ResultMessage addClient(ArrayList<ClientVO> client){
		try{
			InitialDataService service=(InitialDataService) Naming.lookup("");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			ClientImpl impl=new ClientImpl();
			
			ArrayList<ClientPO> po=new ArrayList<ClientPO>();
			for(int i=0;i<client.size();i++){
				ClientPO temp=exchange(client.get(i));
				po.add(temp);
				if(impl.add(client.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			service.insert(new InitialPO(null, null, po, null));
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage addAccount(ArrayList<AccountVO> account){
		try{
			InitialDataService service=(InitialDataService) Naming.lookup("");
			AccountDataService service2=(AccountDataService) Naming.lookup("");
			AccountImpl impl=new AccountImpl();
			
			ArrayList<AccountPO> po=new ArrayList<AccountPO>();
			for(int i=0;i<account.size();i++){
				AccountPO temp=exchange(account.get(i));
				po.add(temp);
				if(impl.add(account.get(i)).equals(ResultMessage.Failure)){
					return ResultMessage.Failure;
				}
			}
			service.insert(new InitialPO(null, null, null, po));
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public InitialVO getInitialInfo(String id){
		try{
			InitialDataService service=(InitialDataService) Naming.lookup("");
			InitialPO po=service.find(id);
			
			ArrayList<CommodityVO> vo=new ArrayList<CommodityVO>();
			ArrayList<ClientVO> vo2=new ArrayList<ClientVO>();
			ArrayList<AccountVO> vo3=new ArrayList<AccountVO>();
			
			ArrayList<CommodityPO> po1=po.getCommodityList();
			ArrayList<ClientPO> po2=po.getClientList();
			ArrayList<AccountPO> po3=po.getAccountList();
			
			for(int i=0;i<po1.size();i++){
				vo.add(exchange(po1.get(i)));
			}
			for(int i=0;i<po1.size();i++){
				vo2.add(exchange(po2.get(i)));
			}
			for(int i=0;i<po1.size();i++){
				vo3.add(exchange(po3.get(i)));
			}
			return new InitialVO(vo, null, vo2, vo3);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public CommodityPO exchange(CommodityVO vo) {        //VOת��ΪPO
		try{
			CommodityTypeDataService service = (CommodityTypeDataService) Naming.lookup("");
			ArrayList<CommodityModelPO> list=new ArrayList<CommodityModelPO>();
			ArrayList<CommodityModelVO> list2=vo.getList();
			for(int i=0;i<list2.size();i++){
				CommodityModelPO a=new CommodityModelPO(list2.get(i).getCommodity(),list2.get(i).getModel(),list2.get(i).getStockNumber(),
						list2.get(i).getStorehouse(),list2.get(i).getNoticeNumber(),
						list2.get(i).getPurchasePrice(),list2.get(i).getRetailPrice(),
						list2.get(i).getRecentPurchasePrice(),list2.get(i).getRecentRetailPrice());
				list.add(a);
			}
			CommodityTypePO type=service.findCommodityTypeInName(vo.getType());
			CommodityPO po=new CommodityPO(vo.getId(),vo.getName(),type,vo.getTotal(),list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public CommodityVO exchange(CommodityPO po){          //POת��ΪVO
		try{
			CommodityTypeDataService service = (CommodityTypeDataService) Naming.lookup("");
			ArrayList<CommodityModelPO> list=po.getList();
			ArrayList<CommodityModelVO> list2=new ArrayList<CommodityModelVO>();
			for(int i=0;i<list.size();i++){
				CommodityModelVO a=new CommodityModelVO(list.get(i).getName(),list.get(i).getModel(),
						list.get(i).getStorehouse(),list.get(i).getNoticeNumber(),list.get(i).getStock(),
						list.get(i).getPurchasePrice(),list.get(i).getRetailPrice(),
						list.get(i).getRecentPurchasePrice(),list.get(i).getRecentRetailPrice());
				list2.add(a);
			}
			String type = po.getType().getName();
			CommodityVO vo=new CommodityVO(po.getId(),po.getName(),type,po.getTotal(),list2);
			return vo;
		}catch(Exception ex){
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
	
	public AccountPO exchange(AccountVO vo) {   //�÷������ڽ�VO����ת��ΪPO����
		AccountPO po = new AccountPO(vo.getId(),vo.getName(),vo.getMoney());
		return po;
	}
	
	public AccountVO exchange(AccountPO po){   //�÷������ڽ�PO����ת��ΪVO����
		AccountVO vo = new AccountVO(po.getId(),po.getName(),po.getMoney());
		return vo;
	}
}
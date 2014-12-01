package strategybl;

import java.rmi.Naming;
import java.util.ArrayList;

import dataservice.*;
import enumType.ResultMessage;
import po.*;
import po.CombinationStrategyPO.CombinationItemPO;
import po.GiftStrategyPO.GiftItemPO;
import vo.*;
import vo.CombinationStrategyVO.CombinationItemVO;
import vo.GiftStrategyVO.GiftItemVO;

public class StrategyImpl {
	public ResultMessage setVoucher(VoucherStrategyVO vo){
		try{
			StrategyDataService service=(StrategyDataService) Naming.lookup("");
			VoucherStrategyPO po=exchange(vo);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage setDiscount(DiscountStrategyVO vo){
		try{
			StrategyDataService service=(StrategyDataService) Naming.lookup("");
			DiscountStrategyPO po=exchange(vo);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage setCombination(CombinationStrategyVO vo){
		try{
			StrategyDataService service=(StrategyDataService) Naming.lookup("");
			CombinationStrategyPO po=exchange(vo);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage setGift(GiftStrategyVO vo){
		try{
			StrategyDataService service=(StrategyDataService) Naming.lookup("");
			GiftStrategyPO po=exchange(vo);
			
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	private GiftStrategyPO exchange(GiftStrategyVO vo) {
		try{
			CommodityDataService service=(CommodityDataService) Naming.lookup("");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			UserDataService service3=(UserDataService) Naming.lookup("");
			
			ArrayList<ClientPO> list=new ArrayList<ClientPO>();
			for(int i=0;i<vo.getClientList().size();i++){
				ClientPO temp=service2.find(vo.getClientList().get(i));
				list.add(temp);
			}
			
			UserPO operator=service3.find(vo.getOperator());
			
			ArrayList<GiftItemVO> item=vo.getList();
			ArrayList<GiftItemPO> result=new ArrayList<GiftItemPO>();
			
			GiftStrategyPO po=new GiftStrategyPO(vo.getId(), null, null, list, operator);
			for(int i=0;i<item.size();i++){
				CommodityPO co=service.findCommodityInName(item.get(i).getCommodity());
				GiftStrategyPO.GiftItemPO first=po.new GiftItemPO(co,item.get(i).getModel(),
				item.get(i).getNumber(),null);
				result.add(first);
			}
			
			for(int i=0;i<result.size();i++){
				if(i==result.size()-1){
				}
				else{
					result.get(i).setNext(result.get(i+1));
				}
			}
			GiftItemPO first=result.get(0);
			GiftItemPO last=result.get(result.size()-1);
			po.setFirst(first);
			po.setLast(last);
			
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private CombinationStrategyPO exchange(CombinationStrategyVO vo) {
		try{
			CommodityDataService c=(CommodityDataService) Naming.lookup("");
			ArrayList<CombinationItemPO> list=new ArrayList<CombinationItemPO>();
			ArrayList<CombinationItemVO> list2=vo.getList();
			CombinationStrategyPO po=new CombinationStrategyPO(vo.getId(),null,
					vo.getInitialMoney(),vo.getLaterMoney());
			for(int i=0;i<list2.size();i++){
				list.add(po.new CombinationItemPO(c.findCommodityInName(list2.get(i).getCommodity()),
						list2.get(i).getModel(),list2.get(i).getNumber()));
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private DiscountStrategyPO exchange(DiscountStrategyVO vo) {
		try{
			ClientDataService service=(ClientDataService) Naming.lookup("");
			ArrayList<ClientPO> list=new ArrayList<ClientPO>();
			for(int i=0;i<vo.getClientList().size();i++){
				ClientPO temp=service.find(vo.getClientList().get(i));
				temp.setDiscount(vo.getDiscount());;
				service.update(temp);
				list.add(temp);
			}
			DiscountStrategyPO po=new DiscountStrategyPO(vo.getId(),vo.getDiscount(),list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private VoucherStrategyPO exchange(VoucherStrategyVO vo) {
		try{
			ClientDataService service=(ClientDataService) Naming.lookup("");
			ArrayList<ClientPO> list=new ArrayList<ClientPO>();
			for(int i=0;i<vo.getClientList().size();i++){
				ClientPO temp=service.find(vo.getClientList().get(i));
				temp.setVoucher(vo.getVoucher());
				service.update(temp);
				list.add(temp);
			}
			VoucherStrategyPO po=new VoucherStrategyPO(vo.getId(),vo.getVoucher(),list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

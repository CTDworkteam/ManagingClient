package strategybl;
import java.util.*;

import config.RMI;
import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;

public class Strategy{
	public ArrayList<ClientStrategy> clientStrategy;
	public ArrayList<SalesStrategy> salesStrategy;
	public ArrayList<StockGift> stockGift;
	public Strategy(){
		
	}
	public Strategy(ArrayList<ClientStrategy> clientStrategy,ArrayList<SalesStrategy> salesStrategy,ArrayList<StockGift> stockGift){
		this.clientStrategy=clientStrategy;
		this.salesStrategy=salesStrategy;
		this.stockGift=stockGift;
	}
	public ResultMessage setVoucher(VoucherStrategyVO vo){
		try{
			StrategyDataService service=RMI.getStrategyDataService();
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
			StrategyDataService service=RMI.getStrategyDataService();
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
			StrategyDataService service=RMI.getStrategyDataService();
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
			StrategyDataService service=RMI.getStrategyDataService();
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
			CommodityDataService service=RMI.getCommodityDataService();
			ClientDataService service2=RMI.getClientDataService();
			UserDataService service3=RMI.getUserDataService();
			
			ArrayList<ClientPO> list=new ArrayList<ClientPO>();
			for(int i=0;i<vo.getClientList().size();i++){
				ClientPO temp=service2.find(vo.getClientList().get(i));
				list.add(temp);
			}
			
			UserPO operator=service3.find(vo.getOperator());
			
			ArrayList<GiftStrategyVO.GiftItemVO> item=vo.getList();
			ArrayList<GiftStrategyPO.GiftItemPO> result=new ArrayList<GiftStrategyPO.GiftItemPO>();
			
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
			GiftStrategyPO.GiftItemPO first=result.get(0);
			GiftStrategyPO.GiftItemPO last=result.get(result.size()-1);
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
			CommodityDataService c=RMI.getCommodityDataService();
			ArrayList<CombinationStrategyPO.CombinationItemPO> list=new ArrayList<CombinationStrategyPO.CombinationItemPO>();
			ArrayList<CombinationStrategyVO.CombinationItemVO> list2=vo.getList();
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
			ClientDataService service=RMI.getClientDataService();
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
			ClientDataService service=RMI.getClientDataService();
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
package strategybl;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import blservice.StrategyBLService;
import config.RMI;
import convert.Convert;
import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;

public class Strategy implements StrategyBLService{
	public Strategy(){
	}
	
	public ResultMessage setVoucher(VoucherStrategyVO vo){
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			VoucherStrategyPO po = Convert.convert(vo);
			service.insert(po);
			return ResultMessage.Success;
		}
	}

	public ResultMessage setDiscount(DiscountStrategyVO vo){
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			DiscountStrategyPO po = Convert.convert(vo);
			service.insert(po);
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage setCombination(CombinationStrategyVO vo){
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			CombinationStrategyPO po = Convert.convert(vo);
			service.insert(po);
 			return ResultMessage.Success;
		}
	}
	
	public ResultMessage setGift(GiftStrategyVO vo){
		StrategyDataService service = RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			GiftStrategyPO po = Convert.convert(vo);
			service.insert(po);
			return ResultMessage.Success;
		}
	}


	public ResultMessage setGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		StrategyDataService service = RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			GiftBasedOnTotalMoneyPO po = Convert.convert(vo);
			service.insert(po);
			return ResultMessage.Success;
		}
	}


	public ResultMessage executeVoucher(VoucherStrategyVO vo) {
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Iterator<ClientPO> i = service.findByRank(vo.getRank());
			
			while(i.hasNext()){
				ClientPO temp = i.next();
				temp.setVoucher(vo.getVoucher());
				service.update(temp);
			}
			return ResultMessage.Success;
		}
	}

	public ResultMessage executeDiscount(DiscountStrategyVO vo) {
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Iterator<ClientPO> i = service.findByRank(vo.getRank());
			
			while(i.hasNext()){
				ClientPO temp = i.next();
				temp.setDiscount(vo.getDiscount());
				service.update(temp);
			}
			return ResultMessage.Success;
		}
	}

	public ResultMessage executeCombination(CombinationStrategyVO vo) {
		ClientDataService service = RMI.getClientDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			Iterator<ClientPO> i = service.findByRank(vo.getRank());
			
			while(i.hasNext()){
				ClientPO temp = i.next();
				temp.setDiscount(vo.getDiscount());
				service.update(temp);
			}
			return ResultMessage.Success;
		}
	}

	public ResultMessage executeGift(GiftStrategyVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage executeGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage deleteDiscount(DiscountStrategyVO vo) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain1(vo.getId())){
				DiscountStrategyPO temp = service.find1(vo.getId());
				service.delete(temp);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deleteCombination(CombinationStrategyVO vo) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain1(vo.getId())){
				DiscountStrategyPO temp = service.find1(vo.getId());
				service.delete(temp);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}

	@Override
	public ResultMessage deleteGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<DiscountStrategyVO> getAllDiscounts() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<VoucherStrategyVO> getAllVouchers() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<CombinationStrategyVO> getAllCombinations() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<GiftStrategyVO> getAllGifts() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<GiftBasedOnTotalMoneyVO> getAllGBOTMs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewVoucherStrategyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewDiscountStrateyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewCombinationStrategyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewGiftStrategyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewGiftBasedOnTotalMoney(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
}
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
			if(service.containDiscountStrategy(vo.getId())){
				DiscountStrategyPO temp = service.findDiscountStrategy(vo.getId());
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
			if(service.containCombinationStrategy(vo.getId())){
				CombinationStrategyPO temp = service.findCombinationStrategy(vo.getId());
				service.delete(temp);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deleteGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.containGBOTM(vo.getId())){
				GiftBasedOnTotalMoneyPO temp = service.findGBOTM(vo.getId());
				service.delete(temp);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}

	public ArrayList<DiscountStrategyVO> getAllDiscounts() {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<DiscountStrategyPO> i = service.getDiscountStrategyList();
			ArrayList<DiscountStrategyVO> vo = new ArrayList<DiscountStrategyVO>();
			
			while(i.hasNext()){
				DiscountStrategyPO temp = i.next();
				vo.add(Convert.convert(temp));
			}
			return vo;
		}
	}

	public ArrayList<VoucherStrategyVO> getAllVouchers() {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<VoucherStrategyPO> i = service.getVoucherStrategyList();
			ArrayList<VoucherStrategyVO> vo = new ArrayList<VoucherStrategyVO>();
			
			while(i.hasNext()){
				VoucherStrategyPO temp = i.next();
				vo.add(Convert.convert(temp));
			}
			return vo;
		}
	}

	public ArrayList<CombinationStrategyVO> getAllCombinations() {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<CombinationStrategyPO> i = service.getCombinationStrategyList();
			ArrayList<CombinationStrategyVO> vo = new ArrayList<CombinationStrategyVO>();
			
			while(i.hasNext()){
				CombinationStrategyPO temp = i.next();
				vo.add(Convert.convert(temp));
			}
			return vo;
		}
	}

	public ArrayList<GiftStrategyVO> getAllGifts() {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<GiftStrategyPO> i = service.getGiftStrategyList();
			ArrayList<GiftStrategyVO> vo = new ArrayList<GiftStrategyVO>();
			
			while(i.hasNext()){
				GiftStrategyPO temp = i.next();
				vo.add(Convert.convert(temp));
			}
			return vo;
		}
	}

	public ArrayList<GiftBasedOnTotalMoneyVO> getAllGBOTMs() {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<GiftBasedOnTotalMoneyPO> i = service.getGBOTMList();
			ArrayList<GiftBasedOnTotalMoneyVO> vo = new ArrayList<GiftBasedOnTotalMoneyVO>();
			
			while(i.hasNext()){
				GiftBasedOnTotalMoneyPO temp = i.next();
				vo.add(Convert.convert(temp));
			}
			return vo;
		}
	}

	public String getNewVoucherStrategyID(GregorianCalendar date) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="DJQ";
			id+=date;
			id+=service.numberOfVouchers(date);
			return id;
		}
	}

	public String getNewDiscountStrateyID(GregorianCalendar date) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="DZ";
			id+=date;
			id+=service.numberOfDiscounts(date);
			return id;
		}
	}

	public String getNewCombinationStrategyID(GregorianCalendar date) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="ZH";
			id+=date;
			id+=service.numberOfCombinations(date);
			return id;
		}
	}

	public String getNewGiftStrategyID(GregorianCalendar date) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="ZS";
			id+=date;
			id+=service.numberOfGifts(date);
			return id;
		}
	}

	public String getNewGiftBasedOnTotalMoney(GregorianCalendar date) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="ZJ";
			id+=date;
			id+=service.numberOfGBOTMs(date);
			return id;
		}
	}

	public ResultMessage setVoucherBasedOnTotalMoney(
			VoucherBasedOnTotalMoneyVO vo) {
		StrategyDataService service=RMI.getStrategyDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			VoucherBasedOnTotalMoneyPO po = Convert.convert(vo);
			service.insert(po);
			return ResultMessage.Success;
		}
	}

	public ResultMessage executeVoucherBasedOnTotalMoney(
			VoucherBasedOnTotalMoneyVO vo) {
		
	}

	public ResultMessage deleteVoucher(VoucherStrategyVO vo) {
		
	}

	public ResultMessage deleteGift(GiftStrategyVO vo) {
		
	}

	public ResultMessage deleteVoucherBasedOnTotalMoney(
			VoucherBasedOnTotalMoneyVO vo) {
		
	}

	@Override
	public ArrayList<VoucherBasedOnTotalMoneyVO> getAllVBOTMs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewGiftBasedOnTotalMoneyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getNewVoucherBasedOnTotalMoneyID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
}
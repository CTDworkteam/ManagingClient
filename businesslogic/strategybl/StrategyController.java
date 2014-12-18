package strategybl;
import java.util.ArrayList;
import vo.*;
import enumType.ResultMessage;
import blservice.*;

public class StrategyController implements StrategyBLService{
	public Strategy strategy;
	public StrategyController(){
		strategy=new Strategy();
	}
	public ResultMessage setVoucher(VoucherStrategyVO vo) {
		return strategy.setVoucher(vo);
	}
	public ResultMessage setDiscount(DiscountStrategyVO vo) {
		return strategy.setDiscount(vo);
	}
	public ResultMessage setCombination(CombinationStrategyVO vo) {
		return strategy.setCombination(vo);
	}
	public ResultMessage setGift(GiftStrategyVO vo) {
		return strategy.setGift(vo);
	}
	
	public ResultMessage setGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		return strategy.setGiftBasedOnTotalMoney(vo);
	}
	
	public ResultMessage executeVoucher(VoucherStrategyVO vo) {
		return strategy.executeVoucher(vo);
	}
	
	public ResultMessage executeDiscount(DiscountStrategyVO vo) {
		return strategy.executeDiscount(vo);
	}
	
	public ResultMessage executeCombination(CombinationStrategyVO vo) {
		return strategy.executeCombination(vo);
	}
	
	public ResultMessage executeGift(GiftStrategyVO vo) {
		return strategy.executeGift(vo);
	}
	
	public ResultMessage executeGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		return strategy.executeGiftBasedOnTotalMoney(vo);
	}
	
	public ResultMessage deleteDiscount(DiscountStrategyVO vo) {
		return strategy.deleteDiscount(vo);
	}
	
	public ResultMessage deleteCombination(CombinationStrategyVO vo) {
		return strategy.deleteCombination(vo);
	}
	
	public ResultMessage deleteGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo) {
		return strategy.deleteGiftBasedOnTotalMoney(vo);
	}
	
	public ArrayList<DiscountStrategyVO> getAllDiscounts() {
		return strategy.getAllDiscounts();
	}
	
	public ArrayList<VoucherStrategyVO> getAllVouchers() {
		return strategy.getAllVouchers();
	}
	
	public ArrayList<CombinationStrategyVO> getAllCombinations() {
		return strategy.getAllCombinations();
	}
	
	public ArrayList<GiftStrategyVO> getAllGifts() {
		return strategy.getAllGifts();
	}
	
	public ArrayList<GiftBasedOnTotalMoneyVO> getAllGBOTMs() {
		return strategy.getAllGBOTMs();
	}
}
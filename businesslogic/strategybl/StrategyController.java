package strategybl;
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
}
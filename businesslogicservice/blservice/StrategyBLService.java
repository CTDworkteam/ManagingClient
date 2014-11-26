package blservice;
import enumType.*;
import vo.*;
public interface StrategyBLService {
	public ResultMessage setVoucher(VoucherStrategyVO vo);
	public ResultMessage setDiscount(DiscountStrategyVO vo);
	public ResultMessage setCombination(CombinationStrategyVO vo);
	public ResultMessage setGift(GiftStrategyVO vo);
}

package blservice;
import enumType.*;
import vo.*;
import java.util.*;
public interface StrategyBLService {
	public ResultMessage setVoucher(VoucherStrategyVO vo);
	public ResultMessage setDiscount(DiscountStrategyVO vo);
	public ResultMessage setCombination(CombinationStrategyVO vo);
	public ResultMessage setGift(GiftStrategyVO vo);
	public ResultMessage setGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo);
	public ResultMessage executeVoucher(VoucherStrategyVO vo);
	public ResultMessage executeDiscount(DiscountStrategyVO vo);
	public ResultMessage executeCombination(CombinationStrategyVO vo);
	public ResultMessage executeGift(GiftStrategyVO vo);
	public ResultMessage executeGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo);
	public ResultMessage deleteDiscount(DiscountStrategyVO vo);
	public ResultMessage deleteCombination(CombinationStrategyVO vo);
	public ResultMessage deleteGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo);
	public ArrayList<DiscountStrategyVO> getAllDiscounts();
	public ArrayList<VoucherStrategyVO> getAllVouchers();
	public ArrayList<CombinationStrategyVO> getAllCombinations();
	public ArrayList<GiftStrategyVO> getAllGifts();
	public ArrayList<GiftBasedOnTotalMoneyVO> getAllGBOTMs();
}

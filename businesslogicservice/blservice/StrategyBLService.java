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
	public ResultMessage setVoucherBasedOnTotalMoney(VoucherBasedOnTotalMoneyVO vo);
	
	public ResultMessage executeVoucher(VoucherStrategyVO vo);
	public ResultMessage executeDiscount(DiscountStrategyVO vo);
	public ResultMessage executeCombination(CombinationStrategyVO vo);
	public ResultMessage executeGift(GiftStrategyVO vo);
	public ResultMessage executeGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo);
	public ResultMessage executeVoucherBasedOnTotalMoney(VoucherBasedOnTotalMoneyVO vo);
	
	public ResultMessage deleteVoucher(VoucherStrategyVO vo);
	public ResultMessage deleteDiscount(DiscountStrategyVO vo);
	public ResultMessage deleteCombination(CombinationStrategyVO vo);
	public ResultMessage deleteGift(GiftStrategyVO vo);
	public ResultMessage deleteGiftBasedOnTotalMoney(GiftBasedOnTotalMoneyVO vo);
	public ResultMessage deleteVoucherBasedOnTotalMoney(VoucherBasedOnTotalMoneyVO vo);
	
	public ArrayList<DiscountStrategyVO> getAllDiscounts();
	public ArrayList<VoucherStrategyVO> getAllVouchers();
	public ArrayList<CombinationStrategyVO> getAllCombinations();
	public ArrayList<GiftStrategyVO> getAllGifts();
	public ArrayList<GiftBasedOnTotalMoneyVO> getAllGBOTMs();
	public ArrayList<VoucherBasedOnTotalMoneyVO> getAllVBOTMs();
	
	public String getNewVoucherStrategyID(GregorianCalendar date);
	public String getNewDiscountStrateyID(GregorianCalendar date);
	public String getNewCombinationStrategyID(GregorianCalendar date);
	public String getNewGiftStrategyID(GregorianCalendar date);
	public String getNewGiftBasedOnTotalMoneyID(GregorianCalendar date);
	public String getNewVoucherBasedOnTotalMoneyID(GregorianCalendar date);
}

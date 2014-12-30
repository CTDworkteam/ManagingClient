package dataservice;
import java.util.*;
import po.*;
public interface StrategyDataService {
	public void insert(DiscountStrategyPO po);
	public void delete(DiscountStrategyPO po);
	public void update(DiscountStrategyPO po);
	public boolean containDiscountStrategy(String id);
	public DiscountStrategyPO findDiscountStrategy(String id);
	public Iterator<DiscountStrategyPO> getDiscountStrategyList();
	public int numberOfDiscounts(GregorianCalendar date);
	public boolean hasDiscountStrategy();
	
	public void insert(VoucherStrategyPO po);
	public void delete(VoucherStrategyPO po);
	public void update(VoucherStrategyPO po);
	public boolean containVoucherStrategy(String id);
	public VoucherStrategyPO findVoucherStrategy(String id);
	public Iterator<VoucherStrategyPO> getVoucherStrategyList();
	public int numberOfVouchers(GregorianCalendar date);
	public boolean hasVoucherStrategy();
	
	public void insert(CombinationStrategyPO po);
	public void delete(CombinationStrategyPO po);
	public void update(CombinationStrategyPO po);
	public boolean containCombinationStrategy(String id);
	public CombinationStrategyPO findCombinationStrategy(String id);
	public Iterator<CombinationStrategyPO> getCombinationStrategyList();
	public int numberOfCombinations(GregorianCalendar date);
	public boolean hasCombinationStrategy();
	
	public void insert(GiftStrategyPO po);
	public void delete(GiftStrategyPO po);
	public void update(GiftStrategyPO po);
	public boolean containGiftStrategy(String id);
	public GiftStrategyPO findGiftStrategy(String id);
	public Iterator<GiftStrategyPO> getGiftStrategyList();
	public int numberOfGifts(GregorianCalendar date);
	public boolean hasGiftStrategy();
	
	public void insert(GiftBasedOnTotalMoneyPO po);
	public void delete(GiftBasedOnTotalMoneyPO po);
	public void update(GiftBasedOnTotalMoneyPO po);
	public boolean containGBOTM(String id);
	public GiftBasedOnTotalMoneyPO findGBOTM(String id);
	public Iterator<GiftBasedOnTotalMoneyPO> getGBOTMList();
	public int numberOfGBOTMs(GregorianCalendar date);
	public boolean hasGBOTM();
	
	public void insert(VoucherBasedOnTotalMoneyPO po);
	public void delete(VoucherBasedOnTotalMoneyPO po);
	public void update(VoucherBasedOnTotalMoneyPO po);
	public boolean containVBOTM(String id);
	public VoucherBasedOnTotalMoneyPO findVBOTM(String id);
	public Iterator<VoucherBasedOnTotalMoneyPO> getVBOTMList();
	public int numberOfVBOTMs(GregorianCalendar date);
	public boolean hasVBOTM();
}
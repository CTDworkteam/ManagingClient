package dataservice;
import java.util.*;
import po.*;
public interface StrategyDataService {
	public void insert(DiscountStrategyPO po);
	public void delete(DiscountStrategyPO po);
	public void update(DiscountStrategyPO po);
	public boolean contain1(String id);
	public DiscountStrategyPO find1(String id);
	public Iterator<DiscountStrategyPO> getDiscountStrategyList();
	public boolean hasDiscountStrategy();
	
	public void insert(VoucherStrategyPO po);
	public void delete(VoucherStrategyPO po);
	public void update(VoucherStrategyPO po);
	public boolean contain2(String id);
	public VoucherStrategyPO find2(String id);
	public Iterator<VoucherStrategyPO> getVoucherStrategyList();
	public boolean hasVoucherStrategy();
	
	public void insert(CombinationStrategyPO po);
	public void delete(CombinationStrategyPO po);
	public void update(CombinationStrategyPO po);
	public boolean contain3(String id);
	public CombinationStrategyPO find3(String id);
	public Iterator<CombinationStrategyPO> getCombinationStrategyList();
	public boolean hasCombinationStrategy();
	
	public void insert(GiftStrategyPO po);
	public void delete(GiftStrategyPO po);
	public void update(GiftStrategyPO po);
	public boolean contain4(String id);
	public GiftStrategyPO find4(String id);
	public Iterator<GiftStrategyPO> getGiftStrategyList();
	public boolean hasGiftStrategy();
	
	public void insert(GiftBasedOnTotalMoneyPO po);
	public void delete(GiftBasedOnTotalMoneyPO po);
	public void update(GiftBasedOnTotalMoneyPO po);
	public boolean contain5(String id);
	public GiftBasedOnTotalMoneyPO find5(String id);
	public Iterator<GiftBasedOnTotalMoneyPO> getGBOTMList();
	public boolean hasGBOTM();
	
	public void init();
	public void save();
}
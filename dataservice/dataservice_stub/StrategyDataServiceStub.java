package dataservice_stub;
import java.util.*;
import po.*;
import dataservice.*;
public class StrategyDataServiceStub implements StrategyDataService{
	private List<DiscountStrategyPO> discounts;
	private List<VoucherStrategyPO> vouchers;
	private List<CombinationStrategyPO> combinations;
	private List<GiftStrategyPO> gifts;
	private List<GiftBasedOnTotalMoneyPO> gbotms;
	private List<VoucherBasedOnTotalMoneyPO> vbotms;
	public StrategyDataServiceStub() {///////
		discounts=new ArrayList<DiscountStrategyPO>();
		vouchers=new ArrayList<VoucherStrategyPO>();
		combinations=new ArrayList<CombinationStrategyPO>();
		gifts=new ArrayList<GiftStrategyPO>();
		gbotms=new ArrayList<GiftBasedOnTotalMoneyPO>();
		vbotms=new ArrayList<VoucherBasedOnTotalMoneyPO>();
	}
	public void insert(DiscountStrategyPO po) {
		discounts.add(po);
	}
	public void delete(DiscountStrategyPO po) {
		Iterator<DiscountStrategyPO> iterator=discounts.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(DiscountStrategyPO po) {
		delete(po);
		insert(po);
	}
	public boolean containDiscountStrategy(String id) {
		Iterator<DiscountStrategyPO> iterator=discounts.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public DiscountStrategyPO findDiscountStrategy(String id) {
		for(int i=0;i<=discounts.size()-1;i++){
			if(discounts.get(i).getId().equals(id)){
				return discounts.get(i);
			}
		}
		return null;
	}
	public Iterator<DiscountStrategyPO> getDiscountStrategyList() {
		return discounts.iterator();
	}
	public boolean hasDiscountStrategy() {
		return discounts.size()==0?true:false;
	}
	public void insert(VoucherStrategyPO po) {
		vouchers.add(po);
	}
	public void delete(VoucherStrategyPO po) {
		Iterator<VoucherStrategyPO> iterator=vouchers.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(VoucherStrategyPO po) {
		delete(po);
		insert(po);
	}
	public boolean containVoucherStrategy(String id) {
		Iterator<VoucherStrategyPO> iterator=vouchers.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public VoucherStrategyPO findVoucherStrategy(String id) {
		for(int i=0;i<=vouchers.size()-1;i++){
			if(vouchers.get(i).getId().equals(id)){
				return vouchers.get(i);
			}
		}
		return null;
	}
	public Iterator<VoucherStrategyPO> getVoucherStrategyList() {
		return vouchers.iterator();
	}
	public boolean hasVoucherStrategy() {
		return vouchers.size()==0?false:true;
	}
	public void insert(CombinationStrategyPO po) {
		combinations.add(po);
	}
	public void delete(CombinationStrategyPO po) {
		Iterator<CombinationStrategyPO> iterator=combinations.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(CombinationStrategyPO po) {
		delete(po);
		insert(po);
	}
	public boolean containCombinationStrategy(String id) {
		Iterator<CombinationStrategyPO> iterator=combinations.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public CombinationStrategyPO findCombinationStrategy(String id) {
		for(int i=0;i<=combinations.size()-1;i++){
			if(combinations.get(i).getId().equals(id)){
				return combinations.get(i);
			}
		}
		return null;
	}
	public Iterator<CombinationStrategyPO> getCombinationStrategyList() {
		return combinations.iterator();
	}
	public boolean hasCombinationStrategy() {
		return combinations.size()==0?false:true;
	}
	public void insert(GiftStrategyPO po) {
		gifts.add(po);
	}
	public void delete(GiftStrategyPO po) {
		Iterator<GiftStrategyPO> iterator=gifts.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(GiftStrategyPO po) {
		delete(po);
		insert(po);
	}
	public boolean containGiftStrategy(String id) {
		Iterator<GiftStrategyPO> iterator=gifts.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public GiftStrategyPO findGiftStrategy(String id) {
		for(int i=0;i<=gifts.size()-1;i++){
			if(gifts.get(i).getId().equals(id)){
				return gifts.get(i);
			}
		}
		return null;
	}
	public Iterator<GiftStrategyPO> getGiftStrategyList() {
		return gifts.iterator();
	}
	public boolean hasGiftStrategy() {
		return gifts.size()==0?false:true;
	}
	public void insert(GiftBasedOnTotalMoneyPO po) {
		gbotms.add(po);
	}
	public void delete(GiftBasedOnTotalMoneyPO po) {
		Iterator<GiftBasedOnTotalMoneyPO> iterator=gbotms.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getID().equals(po.getID())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(GiftBasedOnTotalMoneyPO po) {
		delete(po);
		insert(po);
	}
	public boolean containGBOTM(String id) {
		Iterator<GiftBasedOnTotalMoneyPO> iterator=gbotms.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getID().equals(id)){
				return true;
			}
		}
		return false;
	}
	public GiftBasedOnTotalMoneyPO findGBOTM(String id) {
		for(int i=0;i<=gbotms.size()-1;i++){
			if(gbotms.get(i).getID().equals(id)){
				return gbotms.get(i);
			}
		}
		return null;
	}
	public Iterator<GiftBasedOnTotalMoneyPO> getGBOTMList() {
		return gbotms.iterator();
	}
	public boolean hasGBOTM() {
		return gbotms.size()==0?false:true;
	}
	public int numberOfDiscounts(GregorianCalendar date) {
		int count = 0;
		Iterator<DiscountStrategyPO> iterator = discounts.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getId().substring(8,16);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfVouchers(GregorianCalendar date) {
		int count = 0;
		Iterator<VoucherStrategyPO> iterator = vouchers.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getId().substring(7,15);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfCombinations(GregorianCalendar date) {
		int count = 0;
		Iterator<CombinationStrategyPO> iterator = combinations.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getId().substring(11,19);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfGifts(GregorianCalendar date) {
		int count = 0;
		Iterator<GiftStrategyPO> iterator = gifts.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getId().substring(4,12);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	public int numberOfGBOTMs(GregorianCalendar date) {
		int count = 0;
		Iterator<GiftBasedOnTotalMoneyPO> iterator = gbotms.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getID().substring(5,13);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH, Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}

	public void insert(VoucherBasedOnTotalMoneyPO po) {
		vbotms.add(po);
	}

	public void delete(VoucherBasedOnTotalMoneyPO po) {
		Iterator<VoucherBasedOnTotalMoneyPO> iterator = vbotms.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	
	public void update(VoucherBasedOnTotalMoneyPO po) {
		delete(po);
		insert(po);
		
	}

	public boolean containVBOTM(String id) {
		Iterator<VoucherBasedOnTotalMoneyPO> iterator = vbotms.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}

	public VoucherBasedOnTotalMoneyPO findVBOTM(String id) {
		for(int i=0;i<=vbotms.size()-1;i++){
			if(vbotms.get(i).getId().equals(id)){
				return vbotms.get(i);
			}
		}
		return null;
	}

	public Iterator<VoucherBasedOnTotalMoneyPO> getVBOTMList() {
		return vbotms.iterator();
	}
	
	public int numberOfVBOTMs(GregorianCalendar date) {
		int count = 0;
		Iterator<VoucherBasedOnTotalMoneyPO> iterator = vbotms.iterator();
		while(iterator.hasNext()){
			String dateString = iterator.next().getId().substring(5,13);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0,4)));
			calendar.set(Calendar.MONTH,Integer.parseInt(dateString.substring(4,6)));
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(6)));
			if((!calendar.before(date))&&(!calendar.after(date))){
				count ++;
			}
		}
		return count;
	}
	
	public boolean hasVBOTM() {
		return vbotms.size()==0?false:true;
	}
}
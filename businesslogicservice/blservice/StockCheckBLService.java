package blservice;
import vo.*;
import java.util.*;
public interface StockCheckBLService {
	public StockCheckListVO check(String storehouse,GregorianCalendar start,GregorianCalendar end);
	public StockCommodityListVO lookover(String storehouse);
}

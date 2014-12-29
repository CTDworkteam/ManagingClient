package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface StockCheckBLService {
	public StockCheckListVO check(String storehouse,GregorianCalendar start,GregorianCalendar end);
	public StockCommodityListVO lookover(String storehouse);
	public ResultMessage export(StockCommodityListVO list,String dest);
}

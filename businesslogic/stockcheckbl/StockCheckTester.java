package stockcheckbl;
import java.util.*;
import vo.*;
public class StockCheckTester {
	public StockCheckListVO stockCheckListTester(String storehouse,GregorianCalendar start,GregorianCalendar end){
		MockStockCheck mock=new MockStockCheck();
		return mock.check(storehouse, start, end);
	}
	public StockCommodityListVO stockCommodityListTester(String storehouse){
		MockStockCheck mock=new MockStockCheck();
		return mock.lookover(storehouse);
	}
}

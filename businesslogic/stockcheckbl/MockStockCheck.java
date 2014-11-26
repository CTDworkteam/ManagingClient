package stockcheckbl;
import java.util.GregorianCalendar;

import vo.StockCheckListVO;
import vo.StockCommodityListVO;
public class MockStockCheck extends StockCheck{
	@Override
	public StockCheckListVO check(String storehouse, GregorianCalendar start,
			GregorianCalendar end) {
		return new StockCheckListVO(start.toString(),end.toString(),10,20,23,34,28,32,21,43,22,0);
	}
	@Override
	public StockCommodityListVO lookover(String storehouse) {
		return null;
	}
}

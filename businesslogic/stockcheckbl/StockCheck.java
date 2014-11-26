package stockcheckbl;
import java.util.GregorianCalendar;
import userbl.*;
import vo.StockCheckListVO;
import vo.StockCommodityListVO;
import blservice.*;
public class StockCheck implements StockCheckBLService{
	public User operator;
	@Override
	public StockCheckListVO check(String storehouse, GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockCommodityListVO lookover(String storehouse) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
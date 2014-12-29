package stockcheckbl;
import java.util.GregorianCalendar;
import enumType.*;
import vo.StockCheckListVO;
import vo.StockCommodityListVO;
import blservice.*;
public class StockCheckController implements StockCheckBLService{
	public StockCheck check;
	public StockCheckController(){
		check=new StockCheck();
	}
	public StockCheckListVO check(String storehouse, GregorianCalendar start,
			GregorianCalendar end) {
		return check.check(storehouse, start, end);
	}
	public StockCommodityListVO lookover(String storehouse) {
		return check.lookover(storehouse);
	}
	public ResultMessage export(StockCommodityListVO list,String dest){
		return check.export(list, dest);
	}
}
package stockcheckbl;
import java.util.*;
public class StockCommodityList{
	public String storehouse;
	public GregorianCalendar date;
	public LinkedList<StockCommodityInfo> list;
	public StockCommodityList(){
		
	}
	public StockCommodityList(String storehouse,GregorianCalendar date,LinkedList<StockCommodityInfo> list){
		this.storehouse=storehouse;
		this.date=date;
		this.list=list;
	}
}
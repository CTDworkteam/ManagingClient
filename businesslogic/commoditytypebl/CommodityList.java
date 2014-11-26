package commoditytypebl;
import commoditybl.*;
import java.util.*;
public class CommodityList{
	public CommodityType type;
	public LinkedList<Commodity> list;
	public CommodityList(){
		
	}
	public CommodityList(CommodityType type,LinkedList<Commodity> list){
		this.type=type;
		this.list=list;
	}
}
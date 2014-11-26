package commoditytypebl;
import java.util.*;
public class SubTypeList{
	public CommodityType father;
	public ArrayList<CommodityType> list;
	public SubTypeList(){
	}
	public SubTypeList(CommodityType father,ArrayList<CommodityType> list){
		this.father=father;
		this.list=list;
	}
}
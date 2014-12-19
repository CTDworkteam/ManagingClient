package vo;
import java.util.*;
public class StockCommodityListVO {
	private ArrayList<StockCommodityInfoVO> list;
	public StockCommodityListVO(){
		list=new ArrayList<StockCommodityInfoVO>();
	}
	public StockCommodityListVO(ArrayList<StockCommodityInfoVO> list) {
		this.list = list;
	}
	public ArrayList<StockCommodityInfoVO> getList() {
		return list;
	}
	public void setList(ArrayList<StockCommodityInfoVO> list) {
		this.list = list;
	}
}
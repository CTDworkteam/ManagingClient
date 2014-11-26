package stockbl;
import commoditybl.Commodity;

public class GiftBillItem{
	
	public Commodity commodity;//商品名称、编号及类型
	public String model;//商品型号
	public int count;//赠送商品数量
	public String note;//备注信息
	public GiftBillItem(){
	}
	public GiftBillItem(Commodity commodity,int count,String note){
		this.commodity=commodity;
		this.count=count;
		this.note=note;
	}
}
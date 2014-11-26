package stockbl;
import commoditybl.Commodity;

public class NoticeBill{
	public String id;//单据编号
	public String storehouse;//仓库
	public Commodity commodity;//商品名称、编号、类型
	public String model;//商品编号
	public int noticeData;//报警数量
	public int actualData;//实际库存数量
	public NoticeBill(){
	}
	public NoticeBill(String id,String storehouse,Commodity commodity,String model,int noticeData,int actualData){
		this.id=id;
		this.storehouse=storehouse;
		this.commodity=commodity;
		this.model=model;
		this.noticeData=noticeData;
		this.actualData=actualData;
	}
}
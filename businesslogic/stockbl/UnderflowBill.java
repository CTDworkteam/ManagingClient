package stockbl;
import userbl.User;
import commoditybl.Commodity;

public class UnderflowBill{
	public String id;//单据编号
	public String storehouse;//仓库
	public User operator;//系统操作员
	public Commodity commodity;//商品
	public String model;//???
	public int systemData;//系统记录商品数量
	public int actualData;//商品实际库存数量
	public String note;//备注信息
	public UnderflowBill(){
	}
	public UnderflowBill(String id,String storehouse,User operator,Commodity commodity,String model,int systemData,int actualData,String note){
		this.id=id;
		this.storehouse=storehouse;
		this.operator=operator;
		this.commodity=commodity;
		this.model=model;
		this.systemData=systemData;
		this.actualData=actualData;
		this.note=note;
	}
}
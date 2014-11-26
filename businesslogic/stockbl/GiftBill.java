package stockbl;
import java.util.*;
import clientbl.Client;
import userbl.User;

public class GiftBill {
	public String id;//库存赠送单编号
	public Client client;//？？？
	public String storehouse;//仓库
	public User operator;//系统操作员
	public ArrayList<GiftBillItem> list;//赠品列表
	public String note;//赠送理由
	public GiftBill(){
	}
	public GiftBill(String id,Client client,String storehouse,User operator,ArrayList<GiftBillItem> list,String note){
		this.id=id;
		this.client=client;
		this.storehouse=storehouse;
		this.operator=operator;
		this.list=list;
		this.note=note;
	}
	public void addItem(GiftBillItem item){
		list.add(item);
	}
	public void deleteItem(GiftBillItem item){
		int i;
		for(i=0;i<list.size();i++){
			if(list.get(i)==item){
				list.remove(i);
				break;
			}
		}
	}
}
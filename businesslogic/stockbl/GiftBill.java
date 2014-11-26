package stockbl;
import java.util.*;
import clientbl.Client;
import userbl.User;

public class GiftBill {
	public String id;//������͵����
	public Client client;//������
	public String storehouse;//�ֿ�
	public User operator;//ϵͳ����Ա
	public ArrayList<GiftBillItem> list;//��Ʒ�б�
	public String note;//��������
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
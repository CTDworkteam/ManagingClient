package stockbl;
import commoditybl.Commodity;

public class GiftBillItem{
	
	public Commodity commodity;//��Ʒ���ơ���ż�����
	public String model;//��Ʒ�ͺ�
	public int count;//������Ʒ����
	public String note;//��ע��Ϣ
	public GiftBillItem(){
	}
	public GiftBillItem(Commodity commodity,int count,String note){
		this.commodity=commodity;
		this.count=count;
		this.note=note;
	}
}
package stockbl;
import userbl.User;
import commoditybl.Commodity;

public class UnderflowBill{
	public String id;//���ݱ��
	public String storehouse;//�ֿ�
	public User operator;//ϵͳ����Ա
	public Commodity commodity;//��Ʒ
	public String model;//???
	public int systemData;//ϵͳ��¼��Ʒ����
	public int actualData;//��Ʒʵ�ʿ������
	public String note;//��ע��Ϣ
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
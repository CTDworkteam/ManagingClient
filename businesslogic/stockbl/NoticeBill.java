package stockbl;
import commoditybl.Commodity;

public class NoticeBill{
	public String id;//���ݱ��
	public String storehouse;//�ֿ�
	public Commodity commodity;//��Ʒ���ơ���š�����
	public String model;//��Ʒ���
	public int noticeData;//��������
	public int actualData;//ʵ�ʿ������
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
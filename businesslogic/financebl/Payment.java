package financebl;
import java.util.*;
import clientbl.Client;
import userbl.User;

public class Payment {
	
	public String id;//���ݱ��
	public Client client;//�ͻ���
	public User operator;//ϵͳ����Ա
	public ArrayList<FinanceItem> list;//������Ŀ
	public double total;//ת���ܶ�
	public Payment(){
	}
	public Payment(String id,Client client,User operator,ArrayList<FinanceItem> list,double total){
		this.id=id;
		this.client=client;
		this.operator=operator;
		this.list=list;
		this.total=total;
	}
}

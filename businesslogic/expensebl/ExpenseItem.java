package expensebl;

public class ExpenseItem{
	public String name;//��Ŀ��
	public double money;//��Ŀ���
	public String note;//��ע��Ϣ
	public ExpenseItem(){
	}
	public ExpenseItem(String name,double money,String note){
		this.name=name;
		this.money=money;
		this.note=note;
	}
}
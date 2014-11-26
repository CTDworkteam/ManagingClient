package expensebl;

public class ExpenseItem{
	public String name;//条目名
	public double money;//条目金额
	public String note;//备注信息
	public ExpenseItem(){
	}
	public ExpenseItem(String name,double money,String note){
		this.name=name;
		this.money=money;
		this.note=note;
	}
}
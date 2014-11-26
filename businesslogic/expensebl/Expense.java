package expensebl;
import userbl.User;
import java.util.*;

public class Expense {
	
	public String id;
	public User operator;
	public String account;
	public double total;
	public ArrayList<ExpenseItem> list;
	public Expense(){
	}
	public Expense(String id,User operator,String account,ArrayList<ExpenseItem> list,double total){
		this.id=id;
		this.operator=operator;
		this.account=account;
		this.total=total;
		this.list=list;
	}

}

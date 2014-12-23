package expensebl;
import vo.*;
import enumType.*;
import accountbl.Account;
import java.util.*;
import userbl.User;

public class MockExpense extends Expense{
	
/*	private static Account[] account={new Account(1,"A",1000),new Account(2,"B",2000)};
	private static Expense[] expense={new Expense("XJFYD2014111500001",new User(),"A",new ArrayList<ExpenseItem>(),100),new Expense("XJFYD2014111500002",new User(),"B",new ArrayList<ExpenseItem>(),100)};
	public ResultMessage add(ExpenseVO vo){
		if((vo.getAccount().equals(account[0].name)&&vo.getTotal()<=account[0].money)||(vo.getAccount().equals(account[1].name)&&vo.getTotal()<=account[1].money))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	public ResultMessage delete(ExpenseVO vo){
		if(vo.getId().equals(expense[0].id)||vo.getId().equals(expense[1].id))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	public ResultMessage save(ExpenseVO vo){
		return ResultMessage.Success;
	}
	public ResultMessage send(ExpenseVO vo){
		if(vo.getId().equals(expense[0].id)||vo.getId().equals(expense[1].id))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	public ResultMessage execute(ExpenseVO vo){
		if((vo.getAccount().equals(account[0].name)&&vo.getTotal()<=account[0].money)||(vo.getAccount().equals(account[1].name)&&vo.getTotal()<=account[1].money))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}*/
}

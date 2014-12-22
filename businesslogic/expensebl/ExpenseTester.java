package expensebl;
import vo.*;
import enumType.*;

public class ExpenseTester {
	/*public void testAdd(ExpenseVO vo){
		MockExpense expense=new MockExpense();
		if(expense.add(vo)==ResultMessage.Failure)
			System.out.println("We have failed to add an expense");
		else
			System.out.println("We have succeeded to add an expense");
	}
	public void testDelete(ExpenseVO vo){
		MockExpense expense=new MockExpense();
		if(expense.delete(vo)==ResultMessage.Failure)
			System.out.println("We have failed to delete an expense");
		else
			System.out.println("We have succeeded to delete an expense");
	}*/
	public void testSend(ExpenseVO vo){
		MockExpense expense=new MockExpense();
		if(expense.send(vo)==ResultMessage.Failure)
			System.out.println("We have failed to send an expense");
		else
			System.out.println("We have succeeded to send an expense");
	}
}

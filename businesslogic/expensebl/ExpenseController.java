package expensebl;

import vo.ExpenseVO;
import enumType.ResultMessage;
import blservice.ExpenseBLService;

public class ExpenseController implements ExpenseBLService{
	public Expense expense;
	public ExpenseController(){
		expense=new Expense();
	}
	public ResultMessage save(ExpenseVO vo) {
		return expense.save(vo);
	}
	public ResultMessage send(ExpenseVO vo) {
		return expense.send(vo);
	}
	public ResultMessage execute(ExpenseVO vo) {
		return expense.execute(vo);
	}
}
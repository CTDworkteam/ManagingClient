package expensebl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	public ExpenseVO find(String id) {
		return expense.find(id);
	}
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,
			GregorianCalendar after) {
		return expense.findByCalendar(before, after);
	}
	public ArrayList<ExpenseVO> getList() {
		return expense.getList();
	}
	public String getNewID(GregorianCalendar date) {
		return expense.getNewID(date);
	}
}
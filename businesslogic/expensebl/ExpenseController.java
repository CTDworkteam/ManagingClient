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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ExpenseVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNewID(GregorianCalendar date) {
		// TODO Auto-generated method stub
		return null;
	}
}
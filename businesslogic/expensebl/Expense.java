package expensebl;
import userbl.User;
import vo.ExpenseVO;
import vo.ExpenseVO.ExpenseItemVO;

import java.io.*;
import java.rmi.Naming;
import java.util.*;

import config.RMI;
import po.AccountPO;
import po.ExpensePO;
import po.UserPO;
import po.ExpensePO.ExpenseItemPO;
import dataservice.AccountDataService;
import dataservice.ExpenseDataService;
import dataservice.UserDataService;
import enumType.ResultMessage;

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
	public ResultMessage save(ExpenseVO vo){
		try {
			FileWriter fr = new FileWriter("saveForExpense.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getOperator()+":"+vo.getAccount()+
					":"+vo.getTotal()+":");
			ArrayList<ExpenseItemVO> list=vo.getList();
			for(int i = 0;i<list.size();i++){
				if(i == list.size()-1){
					bf.write(list.get(i).getItemName()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+'\n');
				}
				else{
					bf.write(list.get(i).getItemName()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+":");
				}
			}
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}	
	}
	
	public ResultMessage send(ExpenseVO vo){
		try{
			ExpenseDataService service = RMI.getExpenseDataService();
		
			ExpensePO po = exchange(vo);		
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage execute(ExpenseVO vo){
		try{
			ExpenseDataService service = RMI.getExpenseDataService();
			AccountDataService account = RMI.getAccountDataService();
			ExpensePO temp = service.find(vo.getId());
			AccountPO user = account.find(vo.getAccount());
			if(temp.isPassed()){
				user.setMoney(user.getMoney()-vo.getTotal());
				account.update(user);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	private ExpensePO exchange(ExpenseVO vo){
		try{
			UserDataService service=RMI.getUserDataService();
			AccountDataService service2=RMI.getAccountDataService();
			String operator=vo.getOperator();
			UserPO userpo=service.find(operator);
			AccountPO accountpo=service2.find(vo.getAccount());
			ArrayList<ExpenseItemPO> list=new ArrayList<ExpenseItemPO>();
			
			ExpensePO po=new ExpensePO(vo.getId(),userpo,accountpo,vo.getTotal(),null);
			for(int i=0;i<vo.getList().size();i++){
				ExpensePO.ExpenseItemPO temp=po.new ExpenseItemPO(vo.getList().get(i).getItemName(),
						vo.getList().get(i).getMoney(),vo.getList().get(i).getNote());
				list.add(temp);
			}
			po.setList(list);
			return po;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return null;
		}
	}
}

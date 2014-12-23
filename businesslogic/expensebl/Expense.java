package expensebl;
import userbl.User;
import utility.Utility;
import vo.ExpenseVO;
import vo.ExpenseVO.ExpenseItemVO;

import java.io.*;
import java.rmi.Naming;
import java.util.*;

import blservice.ExpenseBLService;
import config.RMI;
import convert.Convert;
import po.AccountPO;
import po.ExpensePO;
import po.UserPO;
import po.ExpensePO.ExpenseItemPO;
import dataservice.AccountDataService;
import dataservice.ExpenseDataService;
import dataservice.UserDataService;
import enumType.ResultMessage;

public class Expense implements ExpenseBLService{
	public Expense(){
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
			bf.close();
			fr.close();
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}	
	}
	
	public ResultMessage send(ExpenseVO vo){
		ExpenseDataService service = RMI.getExpenseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ExpensePO po = Convert.convert(vo);		
			service.insert(po);
			return ResultMessage.Success;
		}
	}
	
/*	public ResultMessage execute(ExpenseVO vo){
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
	}*/
	
	public ExpenseVO find(String id){
		ExpenseDataService service = RMI.getExpenseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.contain(id)){
				ExpensePO po = service.find(id);
				ExpenseVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,GregorianCalendar after){
		ExpenseDataService service = RMI.getExpenseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<ExpensePO> i = service.finds(before, after);
			ArrayList<ExpenseVO> list = new ArrayList<ExpenseVO>();
			
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			return list;
		}
	}
	
	public ArrayList<ExpenseVO> getList(){
		ExpenseDataService service = RMI.getExpenseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<ExpenseVO> list = new ArrayList<ExpenseVO>();
			TreeMap<String,ExpensePO> list2 = service.getDataList();
			Iterator<ExpensePO> i = list2.values().iterator();
			
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			return list;
		}
	}

	public String getNewID(GregorianCalendar date) {
		ExpenseDataService service = RMI.getExpenseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id="XJXFD";
			id+=Utility.getDate();
			int number = service.numberOfExpenses(date);
			id+=Utility.getIntegerString(number,5);
			return id;
		}
	}
}

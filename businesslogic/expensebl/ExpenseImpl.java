package expensebl;

import java.io.*;
import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.ExpensePO.ExpenseItemPO;
import dataservice.*;
import vo.*;
import vo.ExpenseVO.ExpenseItemVO;
import enumType.ResultMessage;

public class ExpenseImpl {
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
			ExpenseDataService service = (ExpenseDataService) Naming.lookup("rmi://localhost:1099/sendExpense");
		
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
			ExpenseDataService service = (ExpenseDataService) Naming.lookup("rmi://localhost:1099/executeExpense");
			AccountDataService account = (AccountDataService) Naming.lookup("");
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
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			AccountDataService service2=(AccountDataService) Naming.lookup("rmi://localhost:1099/account");
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

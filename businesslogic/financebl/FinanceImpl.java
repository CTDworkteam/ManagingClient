package financebl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.PaymentPO.PaymentItemPO;
import po.ReciptPO.*;
import dataservice.AccountDataService;
import dataservice.ClientDataService;
import dataservice.FinanceDataService;
import dataservice.UserDataService;
import vo.*;
import vo.ExpenseVO.ExpenseItemVO;
import enumType.ResultMessage;

public class FinanceImpl{
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills){
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("rmi://localhost:1099/addRecipt");
			for(int i = 0;i<bills.size();i++){
				ReciptPO po = exchange(bills.get(i));
				service.insert(po);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills){
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("rmi://localhost:1099/addRecipt");
			for(int i = 0;i<bills.size();i++){
				PaymentPO po = exchange(bills.get(i));
				service.insert(po);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage save(ReciptVO vo){
		try {
			FileWriter fr = new FileWriter("saveForFinance.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getClient()+":"+vo.getOperator()+":");
			ArrayList<FinanceItemVO> list=vo.getList();
			for(int i = 0;i<list.size();i++){
				if(i == list.size()-1){
					bf.write(list.get(i).getAccount()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+'\n');
				}
				else{
					bf.write(list.get(i).getAccount()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+":");
				}
			}
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}	
	}
	
	public ResultMessage save(PaymentVO vo){
		try {
			FileWriter fr = new FileWriter("saveForFinance.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getClient()+":"+vo.getOperator()+":");
			ArrayList<FinanceItemVO> list=vo.getList();
			for(int i = 0;i<list.size();i++){
				if(i == list.size()-1){
					bf.write(list.get(i).getAccount()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+'\n');
				}
				else{
					bf.write(list.get(i).getAccount()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+":");
				}
			}
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeBill(ReciptVO bill){
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("rmi://localhost:1099/addRecipt");
			AccountDataService account = (AccountDataService) Naming.lookup("");
		
			ReciptPO po=service.find1(bill.getId());
			if(po.isPassed()){
				ArrayList<ReciptItemPO> temp=po.getList();
				for(int i=0;i<temp.size();i++){
					AccountPO a=temp.get(i).getAccount();
					a.setMoney(a.getMoney()+temp.get(i).getMoney());
					account.update(a);
				}			
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeReturnBill(PaymentVO bill){
		try{
			FinanceDataService service = (FinanceDataService) Naming.lookup("rmi://localhost:1099/addRecipt");
			AccountDataService account = (AccountDataService) Naming.lookup("");
		
			PaymentPO po=service.find2(bill.getId());
			if(po.isPassed()){
				ArrayList<PaymentItemPO> temp=po.getList();
				for(int i=0;i<temp.size();i++){
					AccountPO a=temp.get(i).getAccount();
					a.setMoney(a.getMoney()-temp.get(i).getMoney());
					account.update(a);
				}			
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	private PaymentPO exchange(PaymentVO vo){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("rmi://localhost:1099/account");
			AccountDataService service3=(AccountDataService) Naming.lookup("rmi://localhost:1099/account");
			String operator=vo.getOperator();
			UserPO userpo=service.find(operator);
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<PaymentItemPO> list=new ArrayList<PaymentItemPO>();
			PaymentPO po=new PaymentPO(vo.getId(), userpo, clientpo, null,vo.getTotal() );
			
			for(int i=0;i<vo.getList().size();i++){
				AccountPO accountpo=service3.find(vo.getList().get(i).getAccount());
				PaymentPO.PaymentItemPO temp=po.new PaymentItemPO(accountpo,vo.getList().get(i).getMoney(),
						vo.getList().get(i).getNote());
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	private ReciptPO exchange(ReciptVO vo){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("rmi://localhost:1099/account");
			AccountDataService service3=(AccountDataService) Naming.lookup("rmi://localhost:1099/account");
			String operator=vo.getOperator();
			UserPO userpo=service.find(operator);
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<ReciptItemPO> list=new ArrayList<ReciptItemPO>();
			ReciptPO po=new ReciptPO(vo.getId(),clientpo,userpo,null,vo.getTotal());
			for(int i=0;i<vo.getList().size();i++){
				AccountPO accountpo=service3.find(vo.getList().get(i).getAccount());
				ReciptPO.ReciptItemPO temp=po.new ReciptItemPO(accountpo,vo.getList().get(i).getMoney(),
						vo.getList().get(i).getNote());
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

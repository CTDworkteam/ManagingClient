package financebl;
import userbl.*;
import vo.FinanceItemVO;
import vo.PaymentVO;
import vo.ReciptVO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.util.*;

import config.RMI;
import po.AccountPO;
import po.ClientPO;
import po.PaymentPO;
import po.ReciptPO;
import po.UserPO;
import po.PaymentPO.PaymentItemPO;
import po.ReciptPO.ReciptItemPO;
import dataservice.AccountDataService;
import dataservice.ClientDataService;
import dataservice.FinanceDataService;
import dataservice.UserDataService;
import enumType.ResultMessage;

public class Finance {
	public User operator;
	public ArrayList<Payment> list1;
	public ArrayList<Recipt> list2;
	public Finance(){
		
	}
	public Finance(User operator,ArrayList<Payment> list1,ArrayList<Recipt> list2){
		this.operator=operator;
		this.list1=list1;
		this.list2=list2;
	}
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills){
		try{
			FinanceDataService service = RMI.getFinanceDataService();
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
			FinanceDataService service = RMI.getFinanceDataService();
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
			FinanceDataService service = RMI.getFinanceDataService();
			AccountDataService account = RMI.getAccountDataService();
		
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
			FinanceDataService service = RMI.getFinanceDataService();
			AccountDataService account = RMI.getAccountDataService();
		
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
			UserDataService service=RMI.getUserDataService();
			ClientDataService service2=RMI.getClientDataService();
			AccountDataService service3=RMI.getAccountDataService();
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
			UserDataService service=RMI.getUserDataService();
			ClientDataService service2=RMI.getClientDataService();
			AccountDataService service3=RMI.getAccountDataService();
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

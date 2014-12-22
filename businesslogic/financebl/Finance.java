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

import blservice.FinanceBLService;
import config.RMI;
import convert.Convert;
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

public class Finance implements FinanceBLService{
	public Finance(){
	}
	
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				ReciptPO po = Convert.convert(bills.get(i));
				service.insert(po);
			}
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				PaymentPO po = Convert.convert(bills.get(i));
				service.insert(po);
			}
			return ResultMessage.Success;
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
			bf.close();
			fr.close();
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
			
			bf.close();
			fr.close();
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	/*public ResultMessage executeBill(ReciptVO bill){
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
	}*/
	
	/*public ResultMessage executeReturnBill(PaymentVO bill){
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
	}*/
	
	public ReciptVO findRecipt(String id){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ReciptPO po = service.find1(id);
			return Convert.convert(po);
		}
	}
	
	public PaymentVO findPayment(String id){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			PaymentPO po = service.find2(id);
			return Convert.convert(po);
		}
	}
	
	public ArrayList<ReciptVO> findRecipts(GregorianCalendar before,GregorianCalendar after){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<ReciptVO> vo = new ArrayList<ReciptVO>();
			Iterator<ReciptPO> i = service.finds1(before, after);
			
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}
	
	public ArrayList<PaymentVO> findPayments(GregorianCalendar before,GregorianCalendar after){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<PaymentVO> vo = new ArrayList<PaymentVO>();
			Iterator<PaymentPO> i = service.finds2(before, after);
			
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}
	public ArrayList<ReciptVO> getAllRecipts(){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			
		}
	}
	public ArrayList<PaymentVO> getAllPayments(){
		return null;
	}
	
	public String getNewReciptID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getNewPaymentID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
}

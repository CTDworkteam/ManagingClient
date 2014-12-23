package financebl;
import utility.Utility;
import vo.FinanceItemVO;
import vo.PaymentVO;
import vo.ReciptVO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import blservice.FinanceBLService;
import config.RMI;
import convert.Convert;
import po.PaymentPO;
import po.ReciptPO;
import dataservice.FinanceDataService;
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
			ArrayList<ReciptVO> list = new ArrayList<ReciptVO>();
			TreeMap<String,ReciptPO> list2 = service.getList1();
			Iterator<ReciptPO> i = list2.values().iterator();
			
			while(i.hasNext()){
				ReciptVO temp = Convert.convert(i.next());
				list.add(temp);
			}
			return list;
		}
	}
	public ArrayList<PaymentVO> getAllPayments(){
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<PaymentVO> list = new ArrayList<PaymentVO>();
			TreeMap<String,PaymentPO> list2 = service.getList2();
			Iterator<PaymentPO> i = list2.values().iterator();
			
			while(i.hasNext()){
				PaymentVO temp = Convert.convert(i.next());
				list.add(temp);
			}
			return list;
		}
	}
	
	public String getNewReciptID(GregorianCalendar date) {
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id = "SKD";
			id+=Utility.getDate();
			int number = service.numberOfRecipts(date);
			id+=Utility.getIntegerString(number,5);
			return id;
		}
	}

	public String getNewPaymentID(GregorianCalendar date) {
		FinanceDataService service = RMI.getFinanceDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			String id = "FKD";
			id+=Utility.getDate();
			int number = service.numberOfPayments(date);
			id+=Utility.getIntegerString(number,5);
			return id;
		}
	}
}

package blservice_stub;

import java.io.*;
import java.util.*;
import po.*;
import utility.Utility;
import vo.*;
import convert.Convert;
import enumType.ResultMessage;
import blservice.*;
import dataservice_stub.*;

public class SalesBLServiceStub implements SalesBLService{
	private SalesDataServiceStub service = new SalesDataServiceStub();
	public SalesBLServiceStub(){
		
	}
	public ResultMessage addBill(SalesBillVO vo){
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.numberOfBills(Utility.getDate()) == 99999){
				return ResultMessage.Failure;
			}
			
			else{
				SalesBillPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}
	}
	
	public ResultMessage addReturnBill(SalesReturnBillVO vo){
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.numberOfReturnBills(Utility.getDate()) == 99999){
				return ResultMessage.Failure;
			}
			
			else{
				SalesReturnBillPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}
	}
	
	public ResultMessage deleteBill(SalesBillVO vo){
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getId())){
				SalesBillPO po = Convert.convert(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteReturnBill(SalesReturnBillVO vo){
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getId())){
				SalesReturnBillPO po = Convert.convert(vo);
				service.delete(po);
 				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills){	
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				SalesBillPO temp = Convert.convert(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}
	}

	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills){	
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				SalesReturnBillPO temp = Convert.convert(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage save(SalesBillVO vo){
		try{
			FileWriter fr = new FileWriter("saveForSale.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getClient()+":"+
			vo.getDefaultOperator()+":"+vo.getOperator()+
			":"+vo.getStorehouse()+":"+vo.getInitialTotal()+
			":"+vo.getDiscount()+":"+vo.getVoucher()+
			":"+vo.getTotal()+":"+vo.getNote()+":");
			
			ArrayList<SalesBillVO.SalesBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				SalesBillVO.SalesBillItemVO temp=list.get(i);
				if(list.size()-1==i){
					bf.write(temp.getCommodity()+","+temp.getModel()+
							","+temp.getNumber()+","+temp.getPrice()+
							","+temp.getNote()+'\n');
				}
				else{
					bf.write(temp.getCommodity()+","+temp.getModel()+
							","+temp.getNumber()+","+temp.getPrice()+
							","+temp.getNote()+":");
				}
			}
			bf.close();
			fr.close();
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage save(SalesReturnBillVO vo){
		try{
			FileWriter fr = new FileWriter("saveForSale.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getClient()+":"+
			vo.getDefaultOperator()+":"+vo.getOperator()+
			":"+vo.getStorehouse()+":"+vo.getInitialTotal()+
			":"+vo.getDiscount()+":"+vo.getVoucher()+
			":"+vo.getTotal()+":"+vo.getNote()+":");
			
			ArrayList<SalesReturnBillVO.SalesReturnBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				SalesReturnBillVO.SalesReturnBillItemVO temp=list.get(i);
				if(list.size()-1==i){
					bf.write(temp.getCommodity()+","+temp.getModel()+
							","+temp.getNumber()+","+temp.getPrice()+
							","+temp.getNote()+'\n');
				}
				else{
					bf.write(temp.getCommodity()+","+temp.getModel()+
							","+temp.getNumber()+","+temp.getPrice()+
							","+temp.getNote()+":");
				}
			}
			bf.close();
			fr.close();
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ArrayList<SalesBillVO> findBills(GregorianCalendar before,
			GregorianCalendar after) {
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<SalesBillVO> list = new ArrayList<SalesBillVO>();
			Iterator<SalesBillPO> i = service.finds1(before, after);
			
			while(i.hasNext()){
				SalesBillVO temp = Convert.convert(i.next());
				list.add(temp);
			}
			return list;
		}
	}

	public ArrayList<SalesReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<SalesReturnBillVO> list = new ArrayList<SalesReturnBillVO>();
			Iterator<SalesReturnBillPO> i = service.finds2(before, after);
			
			while(i.hasNext()){
				SalesReturnBillVO temp = Convert.convert(i.next());
				list.add(temp);
			}
			return list;
		}
	}

	public ArrayList<SalesBillVO> getAllBills() {
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<SalesBillVO> vo = new ArrayList<SalesBillVO>();
			TreeMap<String,SalesBillPO> po = service.getList1();
			Iterator<SalesBillPO> i = po.values().iterator();
			
			while(i.hasNext()){
				SalesBillVO temp = Convert.convert(i.next());
				vo.add(temp);
			}
			return vo;
		}
	}

	public ArrayList<SalesReturnBillVO> getAllReturnBills() {
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<SalesReturnBillVO> vo = new ArrayList<SalesReturnBillVO>();
			TreeMap<String,SalesReturnBillPO> po = service.getList2();
			Iterator<SalesReturnBillPO> i = po.values().iterator();
			
			while(i.hasNext()){
				SalesReturnBillVO temp = Convert.convert(i.next());
				vo.add(temp);
			}
			return vo;
		}
	}

	public String getNewBillID(GregorianCalendar date) {
		if(service == null){
			return null;
		}
		else{
			String id = "XSD";
			id+=date;
			id+=Utility.getIntegerString(service.numberOfBills(date),5);
			return id;
		}
	}

	public String getNewReturnBillID(GregorianCalendar date) {
		if(service == null){
			return null;
		}
		
		else{
			String id = "XSTHD";
			id+=date;
			id+=Utility.getIntegerString(service.numberOfBills(date),5);
			return id;
		}
	}
}
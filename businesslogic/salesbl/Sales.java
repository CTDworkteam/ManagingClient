package salesbl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import blservice.SalesBLService;
import config.RMI;
import convert.Convert;
import po.*;
import utility.Utility;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;
public class Sales implements SalesBLService{
	public Sales(){	
	}
	
	public ResultMessage addBill(SalesBillVO vo){
		SalesDataService service=RMI.getSalesDataService();
		
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
		SalesDataService service=RMI.getSalesDataService();
		
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
		SalesDataService service=RMI.getSalesDataService();
		
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
		SalesDataService service=RMI.getSalesDataService();
		
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
		SalesDataService service = RMI.getSalesDataService();
			
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
		SalesDataService service = RMI.getSalesDataService();
			
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
		SalesDataService service = RMI.getSalesDataService();
		
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
		SalesDataService service = RMI.getSalesDataService();
		
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
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesReturnBillVO> getAllReturnBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getNewBillID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public String getNewReturnBillID(GregorianCalendar date) {
		// TODO 自动生成的方法存根
		return null;
	}
}
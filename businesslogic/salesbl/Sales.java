package salesbl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import blservice.SalesBLService;
import config.RMI;
import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;
public class Sales{
	public String operator;
	public ArrayList<SalesBill> list1;
	public ArrayList<SalesReturnBill> list2;
	public Sales(){
		
	}
	public Sales(String operator){
		this.operator=operator;
		list1=new ArrayList<SalesBill>();
		list2=new ArrayList<SalesReturnBill>();
	}
	public ResultMessage addBill(SalesBillVO vo){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(service.getIDs1().length==99999){
				return ResultMessage.Failure;
			}
			else{
				SalesBillPO po=exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage addReturnBill(SalesReturnBillVO vo){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(service.getIDs1().length==99999){
				return ResultMessage.Failure;
			}
			else{
				SalesReturnBillPO po=exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteBill(SalesBillVO vo){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(service.contain(vo.getId())){
				SalesBillPO po=exchange(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();		
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteReturnBill(SalesReturnBillVO vo){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(service.contain(vo.getId())){
				SalesReturnBillPO po=exchange(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();		
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills){
		try{
			SalesDataService service = RMI.getSalesDataService();
			
			for(int i=0;i<bills.size();i++){
				SalesBillPO temp=exchange(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills){
		try{
			SalesDataService service = RMI.getSalesDataService();
			
			for(int i=0;i<bills.size();i++){
				SalesReturnBillPO temp=exchange(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
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
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeBill(SalesBillVO bill){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(bill.isPassed()){
				SalesBillPO po=exchange(bill);
				service.update(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();		
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeReturnBill(SalesReturnBillVO bill){
		try{
			SalesDataService service=RMI.getSalesDataService();
			if(bill.isPassed()){
				SalesReturnBillPO po=exchange(bill);
				service.update(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();		
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	private SalesReturnBillPO exchange(SalesReturnBillVO vo) {
		try{
			UserDataService service=RMI.getUserDataService();
			ClientDataService service2=RMI.getClientDataService();
			CommodityDataService service3=RMI.getCommodityDataService();
	
			UserPO userpo=service.find(vo.getOperator());
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<SalesReturnBillPO.SalesReturnBillItemPO> list=new ArrayList<SalesReturnBillPO.SalesReturnBillItemPO>();
			SalesReturnBillPO po=new SalesReturnBillPO(vo.getId(),clientpo,vo.getDefaultOperator(),
					userpo,vo.getStorehouse(),null,vo.getInitialTotal(),
					vo.getDiscount(),vo.getVoucher(),vo.getTotal(),vo.getNote());
			
			for(int i=0;i<vo.getList().size();i++){
				CommodityPO commoditypo=service3.findCommodityInName(vo.getList().get(i).getCommodity());
				SalesReturnBillPO.SalesReturnBillItemPO temp=po.new SalesReturnBillItemPO(commoditypo,
						vo.getList().get(i).getModel(),vo.getList().get(i).getNumber(),
						vo.getList().get(i).getPrice(),vo.getList().get(i).getNote());
				list.add(temp);
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private SalesBillPO exchange(SalesBillVO vo) {
		try{
			UserDataService service=RMI.getUserDataService();
			ClientDataService service2=RMI.getClientDataService();
			CommodityDataService service3=RMI.getCommodityDataService();
	
			UserPO userpo=service.find(vo.getOperator());
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<SalesBillPO.SalesBillItemPO> list=new ArrayList<SalesBillPO.SalesBillItemPO>();
			SalesBillPO po=new SalesBillPO(vo.getId(),clientpo,vo.getDefaultOperator(),
					userpo,vo.getStorehouse(),null,vo.getInitialTotal(),
					vo.getDiscount(),vo.getVoucher(),vo.getTotal(),vo.getNote());
			
			for(int i=0;i<vo.getList().size();i++){
				CommodityPO commoditypo=service3.findCommodityInName(vo.getList().get(i).getCommodity());
				SalesBillPO.SalesBillItemPO temp=po.new SalesBillItemPO(commoditypo,
						vo.getList().get(i).getModel(),vo.getList().get(i).getNumber(),
						vo.getList().get(i).getPrice(),vo.getList().get(i).getNote());
				list.add(temp);
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public ArrayList<SalesBillVO> findBills(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesBillVO> getAllBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<SalesReturnBillVO> getAllReturnBills() {
		// TODO 自动生成的方法存根
		return null;
	}
}
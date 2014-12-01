package salesbl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.SalesReturnBillPO.SalesReturnBillItemPO;
import po.SalesBillPO.*;
import dataservice.*;
import vo.*;
import vo.SalesBillVO.SalesBillItemVO;
import vo.SalesReturnBillVO.SalesReturnBillItemVO;
import enumType.ResultMessage;

public class SalesImpl{
/*	public ResultMessage addBill(SalesBillVO vo){
		try{
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
	}*/
	
	public ResultMessage sendBill(ArrayList<SalesBillVO> bills){
		try{
			SalesDataService service = (SalesDataService) Naming.lookup("");
			
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
			SalesDataService service = (SalesDataService) Naming.lookup("");
			
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
			
			ArrayList<SalesBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				SalesBillItemVO temp=list.get(i);
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
			
			ArrayList<SalesReturnBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				SalesReturnBillItemVO temp=list.get(i);
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
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
			SalesDataService service=(SalesDataService) Naming.lookup("");
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
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			CommodityDataService service3=(CommodityDataService) Naming.lookup("");
	
			UserPO userpo=service.find(vo.getOperator());
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<SalesReturnBillItemPO> list=new ArrayList<SalesReturnBillItemPO>();
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
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			CommodityDataService service3=(CommodityDataService) Naming.lookup("");
	
			UserPO userpo=service.find(vo.getOperator());
			ClientPO clientpo=service2.find(vo.getClient());
			ArrayList<SalesBillItemPO> list=new ArrayList<SalesBillItemPO>();
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
}

package purchasebl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.PurchaseBillPO.PurchaseBillItemPO;
import po.PurchaseReturnBillPO.PurchaseReturnBillItemPO;
import dataservice.*;
import vo.PurchaseBillVO;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import vo.PurchaseReturnBillVO;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;
import enumType.ResultMessage;

public class PurchaseImpl {
/*	public ResultMessage addBill(PurchaseBillVO vo){
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(service.getIDs1().length==99999){
				return ResultMessage.Failure;
			}
			else{
				PurchaseBillPO po=exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage addReturnBill(PurchaseReturnBillVO vo){
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(service.getIDs2().length==99999){
				return ResultMessage.Failure;
			}
			else{
				PurchaseReturnBillPO po=exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}	
	}
	
	public ResultMessage deleteBill(PurchaseBillVO vo) {
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(service.contain(vo.getId())){
				PurchaseBillPO po=exchange(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteReturnBill(PurchaseReturnBillVO vo){
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(service.contain(vo.getId())){
				PurchaseReturnBillPO po=exchange(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills){
		try{
			PurchaseDataService service = (PurchaseDataService) Naming.lookup("");
			
			for(int i=0;i<bills.size();i++){
				PurchaseBillPO temp=exchange(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills){
		try{
			PurchaseDataService service = (PurchaseDataService) Naming.lookup("");
			
			for(int i=0;i<bills.size();i++){
				PurchaseReturnBillPO temp=exchange(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage save(PurchaseBillVO vo){
		try{
			FileWriter fr = new FileWriter("saveForPurchase.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getSupplier()+":"+
					vo.getStorehouse()+":"+vo.getOperator()+":"+
					vo.getNote()+":");
			ArrayList<PurchaseBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				PurchaseBillItemVO temp=list.get(i);
				if(i==list.size()-1){
					bf.write(temp.getCommodity()+","+temp.getModel()+","+
							temp.getNumber()+","+temp.getPrice()+","+
							","+temp.getNote()+'\n');
				}
				else{
					bf.write(temp.getCommodity()+","+temp.getModel()+","+
							temp.getNumber()+","+temp.getPrice()+","+temp.getTotal()+
							","+temp.getNote()+":");
				}
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage save(PurchaseReturnBillVO vo){
		try{
			FileWriter fr = new FileWriter("saveForPurchase.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getSupplier()+":"+
					vo.getStorehouse()+":"+vo.getOperator()+":"+
					vo.getNote()+":");
			ArrayList<PurchaseReturnBillItemVO> list=vo.getList();
			for(int i=0;i<list.size();i++){
				PurchaseReturnBillItemVO temp=list.get(i);
				if(i==list.size()-1){
					bf.write(temp.getCommodity()+","+temp.getModel()+","+
							temp.getNumber()+","+temp.getPrice()+","+temp.getTotal()+
							","+temp.getNote()+'\n');
				}
				else{
					bf.write(temp.getCommodity()+","+temp.getModel()+","+
							temp.getNumber()+","+temp.getPrice()+","+temp.getTotal()+
							","+temp.getNote()+":");
				}
			}
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeBill(PurchaseBillVO bill){
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(bill.isPassed()){
				PurchaseBillPO po=exchange(bill);
				service.update(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage executeBill(PurchaseReturnBillVO bill){
		try{
			PurchaseDataService service=(PurchaseDataService) Naming.lookup("");
			if(bill.isPassed()){
				PurchaseReturnBillPO po=exchange(bill);
				service.update(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}

	private PurchaseBillPO exchange(PurchaseBillVO vo) {
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			CommodityDataService service3=(CommodityDataService) Naming.lookup("");
			ClientPO clientpo=service2.find(vo.getSupplier());
			UserPO userpo=service.find(vo.getOperator());
			ArrayList<PurchaseBillItemPO> list=new ArrayList<PurchaseBillItemPO>();
			PurchaseBillPO po=new PurchaseBillPO(vo.getId(),clientpo,vo.getStorehouse(),
					userpo,null,vo.getTotal(),vo.getNote());
			
			for(int i=0;i<vo.getList().size();i++){
				CommodityPO commoditypo=service3.findCommodityInName(vo.getList().get(i).getCommodity());
				PurchaseBillPO.PurchaseBillItemPO temp=po.new PurchaseBillItemPO(commoditypo,
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
	
	private PurchaseReturnBillPO exchange(PurchaseReturnBillVO vo){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/operator");
			ClientDataService service2=(ClientDataService) Naming.lookup("");
			CommodityDataService service3=(CommodityDataService) Naming.lookup("");
			ClientPO clientpo=service2.find(vo.getSupplier());
			UserPO userpo=service.find(vo.getOperator());
			ArrayList<PurchaseReturnBillItemPO> list=new ArrayList<PurchaseReturnBillItemPO>();
			PurchaseReturnBillPO po=new PurchaseReturnBillPO(vo.getId(),clientpo,vo.getStorehouse(),
					userpo,null,vo.getTotal(),vo.getNote());
			
			for(int i=0;i<vo.getList().size();i++){
				CommodityPO commoditypo=service3.findCommodityInName(vo.getList().get(i).getCommodity());
				PurchaseReturnBillPO.PurchaseReturnBillItemPO temp=po.new PurchaseReturnBillItemPO(commoditypo,
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

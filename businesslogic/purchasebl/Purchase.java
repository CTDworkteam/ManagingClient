package purchasebl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

import config.RMI;
import convert.Convert;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import utility.Utility;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;
import dataservice.PurchaseDataService;
import enumType.ResultMessage;

public class Purchase{
    public Purchase(){	
	}
	
	public ResultMessage addBill(PurchaseBillVO vo){
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.numberOfBills(Utility.getDate()) == 99999){
			return ResultMessage.Failure;
			}
			
			else{
				PurchaseBillPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage addReturnBill(PurchaseReturnBillVO vo){
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.numberOfReturnBills(Utility.getDate()) == 99999){
				return ResultMessage.Failure;
			}
			else{
				PurchaseReturnBillPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}
	}

	public ResultMessage deleteBill(PurchaseBillVO vo) {
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getId())){
				PurchaseBillPO po = Convert.convert(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deleteReturnBill(PurchaseReturnBillVO vo){
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getId())){
				PurchaseReturnBillPO po = Convert.convert(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
		return ResultMessage.Failure;
		}
	}

	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills){
		PurchaseDataService service = RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				PurchaseBillPO temp = Convert.convert(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
		}
	}

	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills){
		PurchaseDataService service = RMI.getPurchaseDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			for(int i = 0; i<bills.size(); i++){
				PurchaseReturnBillPO temp = Convert.convert(bills.get(i));
				service.insert(temp);
			}
			return ResultMessage.Success;
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
			
			bf.close();
			fr.close();
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
			
			bf.close();
			fr.close();
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ArrayList<PurchaseBillVO> findBills(GregorianCalendar before,
		GregorianCalendar after) {
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<PurchaseBillVO> vo = new ArrayList<PurchaseBillVO>();
			Iterator<PurchaseBillPO> i = service.finds1(before, after);
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}

	public ArrayList<PurchaseReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<PurchaseReturnBillVO> vo = new ArrayList<PurchaseReturnBillVO>();
			Iterator<PurchaseReturnBillPO> i = service.finds2(before, after);
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}

	public ArrayList<PurchaseBillVO> getAllBills() {
		PurchaseDataService service=RMI.getPurchaseDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<PurchaseBillVO> vo = new ArrayList<PurchaseBillVO>();
			TreeMap<String,PurchaseBillPO> po = service.getList1();
		}
	}

	public ArrayList<PurchaseReturnBillVO> getAllReturnBills() {
	
	}
}

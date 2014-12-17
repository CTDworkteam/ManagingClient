package stockbl;
import userbl.User;
import vo.*;

import java.rmi.Naming;
import java.util.*;

import config.RMI;
import po.*;
import dataservice.*;
import enumType.ResultMessage;
public class Stock{
	HashMap<String,GiftBill> listOfGiftBill;
	HashMap<String,OverflowBill> listOfOverflowBill;
	HashMap<String,UnderflowBill> listOfUnderflowBill;
	HashMap<String,NoticeBill> listOfNoticeBill;
	User operator;
	public Stock(){
	}
	public Stock(HashMap<String,GiftBill> listOfGiftBill,HashMap<String,OverflowBill> listOfOverflowBill,HashMap<String,UnderflowBill> listOfUnderflowBill,HashMap<String,NoticeBill> listOfNoticeBill,User operator){
		this.listOfGiftBill=listOfGiftBill;
		this.listOfOverflowBill=listOfOverflowBill;
		this.listOfUnderflowBill=listOfUnderflowBill;
		this.listOfNoticeBill=listOfNoticeBill;
		this.operator=operator;
	}
	public ResultMessage send(GiftBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			GiftBillPO po=exchange(bill);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage send(NoticeBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			NoticeBillPO po=exchange(bill);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage send(OverflowBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			OverflowBillPO po=exchange(bill);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage send(UnderflowBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			UnderflowBillPO po=exchange(bill);
			service.insert(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	

	public ResultMessage execute(GiftBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			
			if(service.contain1(bill.getId())){
				GiftBillPO po=service.find1(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ResultMessage.Failure;
	}
	
	public ResultMessage execute(OverflowBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			
			if(service.contain2(bill.getId())){
				OverflowBillPO po=service.find(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ResultMessage.Failure;
	}
	
	public ResultMessage execute(UnderflowBillVO bill){
		try{
			StockDataService service=RMI.getStockDataService();
			
			if(service.contain3(bill.getId())){
				UnderflowBillPO po=service.find2(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ResultMessage.Failure;
	}
	
	private UnderflowBillPO exchange(UnderflowBillVO bill) {
		try{
			CommodityDataService service=RMI.getCommodityDataService();
			CommodityPO commodity=service.findCommodityInName(bill.getCommodity());
			
			UnderflowBillPO po=new UnderflowBillPO(bill.getId(),bill.getStorehouse(),
					commodity,bill.getModel(),bill.getRecordNumber(),
					bill.getActualNumber());
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	private OverflowBillPO exchange(OverflowBillVO bill) {
		try{
			CommodityDataService service=RMI.getCommodityDataService();
			CommodityPO commodity=service.findCommodityInName(bill.getCommodity());
			
			OverflowBillPO po=new OverflowBillPO(bill.getId(),bill.getStorehouse(),
					commodity,bill.getModel(),bill.getRecordNumber(),
					bill.getActualNumber());
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private NoticeBillPO exchange(NoticeBillVO bill) {
		try{
			CommodityDataService service=RMI.getCommodityDataService();
			CommodityPO commodity=service.findCommodityInName(bill.getCommodity());
			
			NoticeBillPO po=new NoticeBillPO(bill.getId(),bill.getStorehouse(),
					commodity,bill.getModel(),bill.getNoticeNumber(),
					bill.getActualNumber());
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private GiftBillPO exchange(GiftBillVO bill) {
		try{
			ClientDataService service=(ClientDataService) Naming.lookup("");
			UserDataService service2=(UserDataService) Naming.lookup("");
			CommodityDataService service3=(CommodityDataService) Naming.lookup("");
			
			ArrayList<GiftBillPO.GiftBillItemPO> list=new ArrayList<GiftBillPO.GiftBillItemPO>();
			ClientPO client=service.find(bill.getClient());
			UserPO user=service2.find(bill.getOperator());
			GiftBillPO po=new GiftBillPO(bill.getId(),client,bill.getStorehouse(),
					user,null);
			
			for(int i=0;i<bill.getList().size();i++){
				CommodityPO commodity=service3.findCommodityInName(bill.getList().get(i).getCommodity());
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
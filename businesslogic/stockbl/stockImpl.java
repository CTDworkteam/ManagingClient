package stockbl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.*;
import po.GiftBillPO.GiftBillItemPO;
import dataservice.*;
import vo.*;
import enumType.ResultMessage;

public class stockImpl extends StockController{	
	public ResultMessage send(GiftBillVO bill){
		try{
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
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
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
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
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
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
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
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
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
			
			if(service.contain1(bill.getId())){
				GiftBillPO po=service.find1(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage execute(OverflowBillVO bill){
		try{
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
			
			if(service.contain2(bill.getId())){
				OverflowBillPO po=service.find(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage execute(UnderflowBillVO bill){
		try{
			StockDataService service=(StockDataService) Naming.lookup("rmi://localhost:1099/sendGiftBill");
			
			if(service.contain3(bill.getId())){
				UnderflowBillPO po=service.find2(bill.getId());
				if(po.isPassed())
					return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	private UnderflowBillPO exchange(UnderflowBillVO bill) {
		try{
			CommodityDataService service=(CommodityDataService) Naming.lookup("");
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
			CommodityDataService service=(CommodityDataService) Naming.lookup("");
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
			CommodityDataService service=(CommodityDataService) Naming.lookup("");
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
			
			ArrayList<GiftBillItemPO> list=new ArrayList<GiftBillItemPO>();
			ClientPO client=service.find(bill.getClient());
			UserPO user=service2.find(bill.getOperator());
			GiftBillPO po=new GiftBillPO(bill.getId(),client,bill.getStorehouse(),
					user,null);
			
			for(int i=0;i<bill.getList().size();i++){
				CommodityPO commodity=service3.findCommodityInName(bill.getList().get(i).getCommodity());
				GiftBillPO.GiftBillItemPO temp=po.new GiftBillItemPO(commodity,
						bill.getList().get(i).getModel(),bill.getList().get(i).getNumber());
			}
			po.setList(list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

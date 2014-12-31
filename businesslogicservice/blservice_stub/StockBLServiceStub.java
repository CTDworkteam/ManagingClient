package blservice_stub;

import java.text.SimpleDateFormat;
import java.util.*;
import po.*;
import utility.Utility;
import vo.*;
import convert.Convert;
import enumType.ResultMessage;
import blservice.*;
import dataservice_stub.*;

public class StockBLServiceStub implements StockBLService{
	private SimpleDateFormat format=new SimpleDateFormat("yyyymmdd");
	private StockDataServiceStub service = new StockDataServiceStub();
	public StockBLServiceStub(){
		
	}
	public ResultMessage send(GiftBillVO bill){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(bill));
			if(!service.contain1(bill.getId())){
				return ResultMessage.Failure;
			}
			else{
				return ResultMessage.Success;
			}
		}
	}
	
	public ResultMessage send(NoticeBillVO bill){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(bill));
			return ResultMessage.Success;
		}
	}

	public ResultMessage send(OverflowBillVO bill){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(bill));
			if(service.contain2(bill.getId())){
				return ResultMessage.Success;
			}
			else{
				return ResultMessage.Failure;
			}
		}
	}
	
	public ResultMessage send(UnderflowBillVO bill){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(bill));
			if(service.contain2(bill.getId())){
				return ResultMessage.Success;
			}
			else{
				return ResultMessage.Failure;
			}
		}
	}
	
	public ArrayList<GiftBillVO> getAllGiftBills() {
		if(service==null){
			return null;
		}
		else{
			ArrayList<GiftBillVO> list=new ArrayList<GiftBillVO>();
			TreeMap<String,GiftBillPO> treemap=service.getGiftBillList();
			ArrayList<String> ids=service.getGiftBillIDs();
			for(int i=0;i<=ids.size()-1;i++){
				list.add(Convert.convert(treemap.get(ids.get(i))));
			}
			return list;
		}
	}
	
	public ArrayList<OverflowBillVO> getAllOverflowBills() {
		if(service==null){
			return null;
		}
		else{
			ArrayList<OverflowBillVO> list=new ArrayList<OverflowBillVO>();
			TreeMap<String,OverflowBillPO> treemap=service.getOverflowBillList();
			ArrayList<String> ids=service.getOverflowBillIDs();
			for(int i=0;i<=ids.size()-1;i++){
				list.add(Convert.convert(treemap.get(ids.get(i))));
			}
			return list;
		}
	}
	
	public ArrayList<UnderflowBillVO> getAllUnderflowBills() {
		if(service==null){
			return null;
		}
		else{
			ArrayList<UnderflowBillVO> list=new ArrayList<UnderflowBillVO>();
			TreeMap<String,UnderflowBillPO> treemap=service.getUnderflowBillList();
			ArrayList<String> ids=service.getUnderflowBillIDs();
			for(int i=0;i<=ids.size()-1;i++){
				list.add(Convert.convert(treemap.get(ids.get(i))));
			}
			return list;
		}
	}
	
	public ArrayList<NoticeBillVO> getAllNoticeBills() {
		if(service==null){
			return null;
		}
		else{
			ArrayList<NoticeBillVO> list=new ArrayList<NoticeBillVO>();
			TreeMap<String,NoticeBillPO> treemap=service.getNoticeBillList();
			ArrayList<String> ids=service.getNoticeBillIDs();
			for(int i=0;i<=ids.size()-1;i++){
				list.add(Convert.convert(treemap.get(ids.get(i))));
			}
			return list;
		}
	}
	public String getNewGiftBillID(GregorianCalendar date) {
		if(service==null){
			return "ÍøÂçÁ¬½Ó´íÎó";
		}
		else{
			String ID="ZS";
			ID+=format.format(date);
			int number=service.numberOfGiftBills(date)+1;
			ID+=Utility.getIntegerString(number,5);
			return ID;
		}
	}
	public String getNewOverflowBillID(GregorianCalendar date) {
		if(service==null){
			return "ÍøÂçÁ¬½Ó´íÎó";
		}
		else{
			String ID="BY";
			ID+=format.format(date);
			int number=service.numberOfOverflowBills(date)+1;
			ID+=Utility.getIntegerString(number, 5);
			return ID;
		}
	}
	public String getNewUnderflowBillID(GregorianCalendar date) {
		if(service==null){
			return "ÍøÂçÁ¬½Ó´íÎó";
		}
		else{
			String ID="BS";
			ID+=format.format(date);
			int number=service.numberOfUnderflowBills(date)+1;
			ID+=Utility.getIntegerString(number,5);
			return ID;
		}
	}
	public String getNewNoticeBillID(GregorianCalendar date) {
		if(service==null){
			return "ÍøÂçÁ¬½Ó´íÎó";
		}
		else{
			String ID="BJ";
			ID+=format.format(date);
			int number=service.numberOfNoticeBills(date)+1;
			ID+=Utility.getIntegerString(number,5);
			return ID;
		}
	}
}
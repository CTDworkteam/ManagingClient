package stockbl;
import userbl.User;
import utility.Utility;
import vo.*;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.*;

import blservice.StockBLService;
import config.RMI;
import convert.Convert;
import po.*;
import dataservice.*;
import enumType.ResultMessage;
public class Stock implements StockBLService{
	private SimpleDateFormat format=new SimpleDateFormat("yyyymmdd");
	public Stock(){
	}
	public ResultMessage send(GiftBillVO bill){
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(bill));
			return ResultMessage.Success;
		}
	}

	public ResultMessage send(OverflowBillVO bill){
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
		StockDataService service=RMI.getStockDataService();
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
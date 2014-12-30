package stockbl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import vo.*;
import enumType.ResultMessage;
import blservice.StockBLService;

public class StockController implements StockBLService{
	public Stock stock;
	public StockController(){
		stock=new Stock();
	}
	@Override
	public ResultMessage send(GiftBillVO bill) {
		
		return stock.send(bill);
	}
	@Override
	public ResultMessage send(OverflowBillVO bill) {
		
		return stock.send(bill);
	}
	@Override
	public ResultMessage send(UnderflowBillVO bill) {
		
		return stock.send(bill);
	}
	@Override
	public ResultMessage send(NoticeBillVO bill) {
		
		return stock.send(bill);
	}
	@Override
	public ArrayList<GiftBillVO> getAllGiftBills() {
		
		return stock.getAllGiftBills();
	}
	@Override
	public ArrayList<OverflowBillVO> getAllOverflowBills() {
		
		return stock.getAllOverflowBills();
	}
	@Override
	public ArrayList<UnderflowBillVO> getAllUnderflowBills() {
		
		return stock.getAllUnderflowBills();
	}
	@Override
	public ArrayList<NoticeBillVO> getAllNoticeBills() {
		
		return stock.getAllNoticeBills();
	}
	@Override
	public String getNewGiftBillID(GregorianCalendar date) {
		
		return stock.getNewGiftBillID(date);
	}
	@Override
	public String getNewOverflowBillID(GregorianCalendar date) {
		
		return stock.getNewOverflowBillID(date);
	}
	@Override
	public String getNewUnderflowBillID(GregorianCalendar date) {
		
		return stock.getNewUnderflowBillID(date);
	}
	@Override
	public String getNewNoticeBillID(GregorianCalendar date) {
		
		return stock.getNewNoticeBillID(date);
	}
	
}
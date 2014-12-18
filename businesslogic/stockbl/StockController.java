package stockbl;

import java.util.ArrayList;

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
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage send(OverflowBillVO bill) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage send(UnderflowBillVO bill) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage send(NoticeBillVO bill) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<GiftBillVO> getAllGiftBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<OverflowBillVO> getAllOverflowBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<UnderflowBillVO> getAllUnderflowBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ArrayList<NoticeBillVO> getAllNoticeBills() {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
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
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ResultMessage send(OverflowBillVO bill) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ResultMessage send(UnderflowBillVO bill) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ResultMessage send(NoticeBillVO bill) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ArrayList<GiftBillVO> getAllGiftBills() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ArrayList<OverflowBillVO> getAllOverflowBills() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ArrayList<UnderflowBillVO> getAllUnderflowBills() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ArrayList<NoticeBillVO> getAllNoticeBills() {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
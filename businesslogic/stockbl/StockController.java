package stockbl;

import vo.*;
import enumType.ResultMessage;
import blservice.StockBLService;

public class StockController implements StockBLService{
	public Stock stock;
	public StockController(){
		stock=new Stock();
	}
	public ResultMessage send(GiftBillVO bill) {
		return stock.send(bill);
	}
	public ResultMessage send(OverflowBillVO bill) {
		return stock.send(bill);
	}
	public ResultMessage send(UnderflowBillVO bill) {
		return stock.send(bill);
	}
	public ResultMessage send(NoticeBillVO bill) {
		return stock.send(bill);
	}
	public ResultMessage execute(GiftBillVO bill) {
		return stock.execute(bill);
		
	}
	public ResultMessage execute(OverflowBillVO bill) {
		return stock.execute(bill);
	}
	public ResultMessage execute(UnderflowBillVO bill) {
		return stock.execute(bill);
	}
}
package stockcheckbl;
import java.util.*;
public class StockCheckList{
	public GregorianCalendar start;
	public GregorianCalendar end;
	public int inNumber;
	public int outNumber;
	public double inMoney;
	public double outMoney;
	public int purchaseNumber;
	public int salesNumber;
	public double purchaseMoney;
	public double salesMoney;
	public int totalNumber;
	public StockCheckList(){
	}
	public StockCheckList(GregorianCalendar start, GregorianCalendar end,
			int inNumber, int outNumber, double inMoney, double outMoney,
			int purchaseNumber, int salesNumber, double purchaseMoney,
			double salesMoney, int totalNumber) {
		this.start = start;
		this.end = end;
		this.inNumber = inNumber;
		this.outNumber = outNumber;
		this.inMoney = inMoney;
		this.outMoney = outMoney;
		this.purchaseNumber = purchaseNumber;
		this.salesNumber = salesNumber;
		this.purchaseMoney = purchaseMoney;
		this.salesMoney = salesMoney;
		this.totalNumber = totalNumber;
	}
}
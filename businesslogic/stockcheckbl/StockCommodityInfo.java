package stockcheckbl;
import java.util.*;
public class StockCommodityInfo{
	public String name;
	public String model;
	public int numInStock;
	public double average;
	public long batch;
	public long batchNumber;
	public GregorianCalendar date;
	public StockCommodityInfo(){
		
	}
	public StockCommodityInfo(String name, String model, int numInStock,
			double average, long batch, long batchNumber, GregorianCalendar date) {
		this.name = name;
		this.model = model;
		this.numInStock = numInStock;
		this.average = average;
		this.batch = batch;
		this.batchNumber = batchNumber;
		this.date = date;
	}
}
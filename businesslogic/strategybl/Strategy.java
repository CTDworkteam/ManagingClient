package strategybl;
import java.util.*;

public class Strategy{
	public ArrayList<ClientStrategy> clientStrategy;
	public ArrayList<SalesStrategy> salesStrategy;
	public ArrayList<StockGift> stockGift;
	public Strategy(){
		
	}
	public Strategy(ArrayList<ClientStrategy> clientStrategy,ArrayList<SalesStrategy> salesStrategy,ArrayList<StockGift> stockGift){
		this.clientStrategy=clientStrategy;
		this.salesStrategy=salesStrategy;
		this.stockGift=stockGift;
	}
}
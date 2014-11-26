package financecheckbl;
import java.util.*;
import commoditybl.*;
public class DetailListItem{
	public GregorianCalendar date;
	public Commodity commodity;
	public String model;
	public int number;
	public double price;
	public double total;
	public DetailListItem(){
		this.date=null;
		this.commodity=null;
		this.model=null;
		this.number=0;
		this.price=0;
		this.total=0;
	}
	public DetailListItem(GregorianCalendar date,Commodity commodity,String model,int number,double price){
		this.date=date;
		this.commodity=commodity;
		this.model=model;
		this.number=number;
		this.price=price;
		this.total=this.price*(double)this.number;
	}
}
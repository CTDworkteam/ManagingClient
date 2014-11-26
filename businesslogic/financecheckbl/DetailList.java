package financecheckbl;
import java.util.*;
import commoditybl.*;
import clientbl.*;
import userbl.*;
public class DetailList{
	public GregorianCalendar start;
	public GregorianCalendar end;
	public Commodity commodity;
	public User operator;
	public Client client;
	public String storehouse;
	public ArrayList<DetailListItem> list;
	public DetailList(){
	}
	public DetailList(GregorianCalendar start,GregorianCalendar end,
			Commodity commodity,User operator,Client client,String storehouse,
			ArrayList<DetailListItem> list){
		this.start=start;
		this.end=end;
		this.commodity=commodity;
		this.operator=operator;
		this.storehouse=storehouse;
		this.client=client;
		this.list=list;
	}
}
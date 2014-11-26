package financebl;
import java.util.*;
import clientbl.Client;
import userbl.User;

public class Recipt {
	
	public String id;
	public Client client;
	public User operator;
	public ArrayList<FinanceItem> list;
	public double total;
	public Recipt(){
	}
	public Recipt(String id,Client client,User operator,ArrayList<FinanceItem> list,double total){
		this.id=id;
		this.client=client;
		this.operator=operator;
		this.list=list;
		this.total=total;
	}
}

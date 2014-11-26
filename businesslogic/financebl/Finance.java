package financebl;
import userbl.*;
import java.util.*;

public class Finance {
	public User operator;
	public ArrayList<Payment> list1;
	public ArrayList<Recipt> list2;
	public Finance(){
		
	}
	public Finance(User operator,ArrayList<Payment> list1,ArrayList<Recipt> list2){
		this.operator=operator;
		this.list1=list1;
		this.list2=list2;
	}
}

package salesbl;

import java.util.ArrayList;



public class Sales
{
	public String operator;
	public ArrayList<SalesBill> list1;
	public ArrayList<SalesReturnBill> list2;
	
	public Sales(){
		
	}
	public Sales(String operator){
		this.operator=operator;
		list1=new ArrayList<SalesBill>();
		list2=new ArrayList<SalesReturnBill>();
	}
}
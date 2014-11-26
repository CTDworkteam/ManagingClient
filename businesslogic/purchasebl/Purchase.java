package purchasebl;

import java.util.*;

public class Purchase
{
	public String operator;
	public ArrayList<PurchaseBill> list1;
	public ArrayList<PurchaseReturnBill> list2;

public Purchase(){
		
	}
	public Purchase(String operator){
		this.operator=operator;
		list1=new ArrayList<PurchaseBill>();
		list2=new ArrayList<PurchaseReturnBill>();
	}
}

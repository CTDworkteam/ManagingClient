package purchasebl;

import java.util.ArrayList;

import vo.PurchaseBillVO;
import enumType.ResultMessage;

public class PurchaseTester {
	public void testAddBill(PurchaseBillVO vo){
		MockPurchase purchase=new MockPurchase();
		if(purchase.addBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to add the new bill");
		else
			System.out.println("We have succeeded to add the new bill");
	}
	public void testDeleteBill(PurchaseBillVO vo){
		MockPurchase purchase=new MockPurchase();
		if(purchase.deleteBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to delete the bill");
		else
			System.out.println("We have succeeded to delete the bill");
	}
	public void testSendBill(ArrayList<PurchaseBillVO> bills){
		MockPurchase purchase=new MockPurchase();
		if(purchase.sendBill(bills)==ResultMessage.Failure)
			System.out.println("We have failed to send the bills");
		else
			System.out.println("We have succeeded to send the bills");
	}
	public void testSave(){
		MockPurchase purchase=new MockPurchase();
		if(purchase.save()==ResultMessage.Failure)
			System.out.println("We have failed to save the bills");
		else
			System.out.println("We have succeeded to save the bills");
	}
	public void testExecuteBill(PurchaseBillVO vo){
		MockPurchase purchase=new MockPurchase();
		if(purchase.executeBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to execute the bill");
		else
			System.out.println("We have succeeded to execute the bill");
	}
}

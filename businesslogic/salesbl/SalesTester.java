package salesbl;

import java.util.ArrayList;

import vo.SalesBillVO;
import enumType.ResultMessage;

public class SalesTester {
	public void testAddBill(SalesBillVO vo){
		MockSales purchase=new MockSales();
		if(purchase.addBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to add the new bill");
		else
			System.out.println("We have succeeded to add the new bill");
	}
	public void testDeleteBill(SalesBillVO vo){
		MockSales sales=new MockSales();
		if(sales.deleteBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to delete the bill");
		else
			System.out.println("We have succeeded to delete the bill");
	}
	public void testSendBill(ArrayList<SalesBillVO> bills){
		MockSales sales=new MockSales();
		if(sales.sendBill(bills)==ResultMessage.Failure)
			System.out.println("We have failed to send the bills");
		else
			System.out.println("We have succeeded to send the bills");
	}
	public void testSave(){
		MockSales sales=new MockSales();
		if(sales.save()==ResultMessage.Failure)
			System.out.println("We have failed to save the bills");
		else
			System.out.println("We have succeeded to save the bills");
	}
	public void testExecuteBill(SalesBillVO vo){
		MockSales sales=new MockSales();
		if(sales.executeBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to execute the bill");
		else
			System.out.println("We have succeeded to execute the bill");
	}
}

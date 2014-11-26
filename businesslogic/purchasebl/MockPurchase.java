package purchasebl;

import java.util.*;

import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import enumType.ResultMessage;

public class MockPurchase extends Purchase
{
	
	public MockPurchase(){
		
	}
	public MockPurchase(String operator){
		this.operator=operator;
		list1=new ArrayList<PurchaseBill>();
		list2=new ArrayList<PurchaseReturnBill>();
	}
	public ResultMessage addBill(PurchaseBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage addReturnBill(PurchaseReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage deleteBill(PurchaseBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage deleteReturnBill(PurchaseReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills) {
		if(bills.get(0).getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills) {
		if(bills.get(0).getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage save() {
		
			return ResultMessage.Success;
		
	}

	public ResultMessage executeBill(PurchaseBillVO bill) {
		if(bill.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage executeBill(PurchaseReturnBillVO bill) {
		if(bill.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}
	
}

package salesbl;

import java.util.ArrayList;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import enumType.ResultMessage;

public class MockSales extends Sales {
	public MockSales(){
		
	}
	public MockSales(String operator){
		this.operator=operator;
		list1=new ArrayList<SalesBill>();
		list2=new ArrayList<SalesReturnBill>();
	}
	public ResultMessage addBill(SalesBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage addReturnBill(SalesReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage deleteBill(SalesBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage deleteReturnBill(SalesReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage sendBill(ArrayList<SalesBillVO> bills) {
		if(bills.get(0).getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}


	public ResultMessage sendReturnBill(ArrayList<SalesReturnBillVO> bills) {
		if(bills.get(0).getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage save() {
		
			return ResultMessage.Success;
		
	}

	public ResultMessage executeBill(SalesBillVO bill) {
		if(bill.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage executeBill(SalesReturnBillVO bill) {
		if(bill.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}
}

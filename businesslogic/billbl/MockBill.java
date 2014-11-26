package billbl;

import vo.ExpenseVO;
import vo.GiftBillVO;
import vo.OverflowBillVO;
import vo.PaymentVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReciptVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.UnderflowBillVO;
import enumType.ResultMessage;

public class MockBill extends Bill{
	public MockBill(){
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateGiftBill(GiftBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveOverflowBill(OverflowBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateOverflowBill(OverflowBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateUnderflowBill(UnderflowBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approvePurchaseBill(PurchaseBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updatePurchaseBill(PurchaseBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updatePurchaseReturnBill(PurchaseReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveSalesBill(SalesBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}
	
	public ResultMessage updateSalesBill(SalesBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateSalesReturnBill(SalesReturnBillVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveRecipt(ReciptVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateRecipt(ReciptVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approvePayment(PaymentVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updatePayment(PaymentVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage approveExpense(ExpenseVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	public ResultMessage updateExpense(ExpenseVO vo) {
		if(vo.getId().equals("0001"))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}
	
}

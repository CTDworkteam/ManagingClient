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

public class BillTester {
	public void testApproveGiftBill(GiftBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveGiftBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the giftbill");
		else
			System.out.println("We have succeeded to approve the giftbill");
	}

	public void testUpdateGiftBill(GiftBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateGiftBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the giftbill");
		else
			System.out.println("We have succeeded to update the giftbill");
	}

	public void testApproveOverflowBill(OverflowBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveOverflowBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the overflowbill");
		else
			System.out.println("We have succeeded to approve the overflowbill");
	}

	public void testUpdateOverflowBill(OverflowBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateOverflowBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the overflowbill");
		else
			System.out.println("We have succeeded to update the overflowbill");
	}

	public void testApproveUnderflowBill(UnderflowBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveUnderflowBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the underflowbill");
		else
			System.out.println("We have succeeded to approve the underflowbill");
	}

	public void testUpdateUnderflowBill(UnderflowBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateUnderflowBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the underflowbill");
		else
			System.out.println("We have succeeded to update the underflowbill");
	}

	public void testApprovePurchaseBill(PurchaseBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approvePurchaseBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the purchasebill");
		else
			System.out.println("We have succeeded to approve the purchasebill");
	}

	public void testUpdatePurchaseBill(PurchaseBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updatePurchaseBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the purchasebill");
		else
			System.out.println("We have succeeded to update the purchasebill");
	}

	public void testApprovePurchaseReturnBill(PurchaseReturnBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approvePurchaseReturnBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the purchaseReturnbill");
		else
			System.out.println("We have succeeded to approve the purchaseReturnbill");
	}

	public void testUpdatePurchaseReturnBill(PurchaseReturnBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updatePurchaseReturnBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the purchaseReturnbill");
		else
			System.out.println("We have succeeded to update the purchaseReturnbill");
	}

	public void testApproveSalesBill(SalesBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveSalesBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the salesbill");
		else
			System.out.println("We have succeeded to approve the salesbill");
	}
	
	public void testUpdateSalesBill(SalesBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateSalesBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the salesbill");
		else
			System.out.println("We have succeeded to update the salesbill");
	}

	public void testApproveSalesReturnBill(SalesReturnBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveSalesReturnBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the salesReturnbill");
		else
			System.out.println("We have succeeded to approve the salesReturnbill");
	}

	public void testUpdateSalesReturnBill(SalesReturnBillVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateSalesReturnBill(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the salesReturnbill");
		else
			System.out.println("We have succeeded to approve the salesReturnbill");
	}

	public void testApproveRecipt(ReciptVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveRecipt(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the recipt");
		else
			System.out.println("We have succeeded to approve the recipt");
	}

	public void testUpdateRecipt(ReciptVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateRecipt(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the recipt");
		else
			System.out.println("We have succeeded to update the recipt");
	}

	public void testApprovePayment(PaymentVO vo) {
		MockBill bill=new MockBill();
		if(bill.approvePayment(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the payment");
		else
			System.out.println("We have succeeded to approve the payment");
	}

	public void updatePayment(PaymentVO vo) {
		MockBill bill=new MockBill();
		if(bill.updatePayment(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the payment");
		else
			System.out.println("We have succeeded to update the payment");
	}

	public void testApproveExpense(ExpenseVO vo) {
		MockBill bill=new MockBill();
		if(bill.approveExpense(vo)==ResultMessage.Failure)
			System.out.println("We have failed to approve the expense");
		else
			System.out.println("We have succeeded to approve the expense");
	}

	public void testUpdateExpense(ExpenseVO vo) {
		MockBill bill=new MockBill();
		if(bill.updateExpense(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the expense");
		else
			System.out.println("We have succeeded to update the expense");
	}
}

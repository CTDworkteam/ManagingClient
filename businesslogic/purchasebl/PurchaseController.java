package purchasebl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import enumType.ResultMessage;
import blservice.PurchaseBLService;

public class PurchaseController implements PurchaseBLService{
	public Purchase purchase;
	public PurchaseController(){
		purchase=new Purchase();
	}
	public ResultMessage sendBill(ArrayList<PurchaseBillVO> bills) {
		return purchase.sendBill(bills);
	}
	public ResultMessage sendReturnBill(ArrayList<PurchaseReturnBillVO> bills) {
		return purchase.sendReturnBill(bills);
	}
	public ResultMessage save(PurchaseBillVO vo) {
		return purchase.save(vo);
	}
	public ResultMessage save(PurchaseReturnBillVO vo) {
		return purchase.save(vo);
	}
	public ResultMessage executeBill(PurchaseBillVO bill) {
		return purchase.executeBill(bill);
	}
	public ResultMessage executeBill(PurchaseReturnBillVO bill) {
		return purchase.executeBill(bill);
	}
	@Override
	public ArrayList<PurchaseBillVO> findBills(GregorianCalendar before,
			GregorianCalendar after) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PurchaseReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PurchaseBillVO> getAllBills() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PurchaseReturnBillVO> getAllReturnBills() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNewBillID(GregorianCalendar date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNewReturnBillID(GregorianCalendar date) {
		// TODO Auto-generated method stub
		return null;
	}
}
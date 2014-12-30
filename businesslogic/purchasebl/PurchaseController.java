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
	
	
	@Override
	public ArrayList<PurchaseBillVO> findBills(GregorianCalendar before,
			GregorianCalendar after) {
		
		return purchase.findBills(before, after);
	}
	@Override
	public ArrayList<PurchaseReturnBillVO> findReturnBills(
			GregorianCalendar before, GregorianCalendar after) {

		return purchase.findReturnBills(before, after);
	}
	@Override
	public ArrayList<PurchaseBillVO> getAllBills() {
	
		return purchase.getAllBills();
	}
	@Override
	public ArrayList<PurchaseReturnBillVO> getAllReturnBills() {
		
		return purchase.getAllReturnBills();
	}
	@Override
	public String getNewBillID(GregorianCalendar date) {
		
		return "00";
	}
	@Override
	public String getNewReturnBillID(GregorianCalendar date) {
		return "01";
	}
}

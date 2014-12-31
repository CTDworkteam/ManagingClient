package billbl;
import purchasebl.*;
import salesbl.*;
import financebl.*;
import stockbl.*;
import enumType.ResultMessage;
import expensebl.*;

import java.util.*;

import vo.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import salesbl.*;

public class BillTest {
	private Bill bill = new Bill();
	private Purchase purchase = new Purchase();
	private Sales sales = new Sales();
	private Stock stock = new Stock();
	private Finance finance = new Finance();
	private Expense expense = new Expense();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testApproveExpense(){
		ArrayList<ExpenseVO> list = bill.listExpenses();
		ResultMessage result = bill.approveExpense(list.get(0));
		assertEquals(ResultMessage.Success,result);
		ExpenseVO vo = expense.find(list.get(0).getId());
		assertEquals(true,vo.isPassed());
	}
	
	@Test
	public void testApproveGiftBill(){
		ArrayList<GiftBillVO> list = bill.listGiftBills();
		ResultMessage result = bill.approveGiftBill(list.get(0));
		assertEquals(ResultMessage.Success,result);
		GiftBillVO vo = 
	}
	
	@Test
	public void testApproveOverflowBill(){
		
	}
	
	@Test
	public void testApprovePaymentBill(){
		
	}
	
	@Test
	public void testApprovePurchaseBill(){
		
	}
	
	@Test
	public void testApprovePurchaseReturnBill(){
		
	}
	
	@Test
	public void testApproveRecipt(){
		
	}
	
	@Test
	public void testApproveSalesBill(){
		
	}
	
	@Test
	public void testApproveSalesReturnBill(){
		
	}
	
	@Test
	public void testApproveUnderflowBill(){
		
	}
}
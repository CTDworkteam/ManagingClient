package billui;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import billbl.*;
import vo.*;

/*
 * 审批单据界面
 */
public class Billui {
	
	public JPanel panelBill=new JPanel();
	
	Bill bill=new Bill();
	
	ArrayList<ReciptVO> recipt=bill.listRecipts();
	ArrayList<PaymentVO> payment=bill.listPayments();
	ArrayList<ExpenseVO> expense=bill.listExpenses();
	ArrayList<GiftBillVO> giftBill=bill.listGiftBills();
	ArrayList<OverflowBillVO> overFlowBill=bill.listOverflowBills();
	ArrayList<UnderflowBillVO> underFlowBill=bill.listUnderflowBills();
	ArrayList<PurchaseBillVO> purchaseBill=bill.listPurchaseBills();
	ArrayList<PurchaseReturnBillVO> purchaseReturnBill=bill.listPurchaseReturnBills();
	ArrayList<SalesBillVO> salesBill=bill.listSalesBills();
	ArrayList<SalesReturnBillVO> salesReturnBill=bill.listSalesReturnBills();
	
	public Billui(){
		JButton buttonMoney=new JButton("财务单据");
		buttonMoney.addActionListener(new financeListener());
		
		JButton buttonStock=new JButton("库存单据");
		buttonStock.addActionListener(new stockListener());
		
		JButton buttonBuy=new JButton("进货单据");
		buttonBuy.addActionListener(new purchaseListener());
		
		JButton buttonSale=new JButton("销售单据");
		buttonSale.addActionListener(new salesListener());
		
		panelBill.setLayout(null);
		buttonMoney.setBounds(100,200,100,25);
		buttonStock.setBounds(290,200,100,25);
		buttonBuy.setBounds(480,100,100,25);
		buttonSale.setBounds(480,300,100,25);
		
		panelBill.add(buttonMoney);
		panelBill.add(buttonStock);
		panelBill.add(buttonBuy);
		panelBill.add(buttonSale);
	}
	
	class financeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			BillFinanceui finance=new BillFinanceui();
			finance.go(recipt, payment, expense);
		}
	}
	
	class stockListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			BillStockui stock=new BillStockui();
			stock.go(giftBill, overFlowBill, underFlowBill);
		}
	}
	
	class purchaseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			BillPurchaseui purchase=new BillPurchaseui();
			purchase.go(purchaseBill, purchaseReturnBill);
		}
	}
	
	class salesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			BillSalesui sale=new BillSalesui();
			sale.go(salesBill, salesReturnBill);
		}
	}

}

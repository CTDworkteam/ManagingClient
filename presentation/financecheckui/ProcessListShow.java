package financecheckui;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;

import vo.*;
import enumType.UserJob;
import enumType.BillType;
import salesbl.SalesController;
import purchasebl.PurchaseController;
import financebl.FinanceController;
import expensebl.ExpenseController;
import stockbl.StockController;

public class ProcessListShow {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型"};
	String[][] data;
	JTable table=new JTable(data,heading);
	
	UserJob theJob;

	public void go(ProcessListVO vo,UserJob job){
		
		this.theJob=job;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-150);
		frame.setLocation(wide/3,high/4);
		
		String theType="";
		BillType type=vo.getBilltype();
		if(type==BillType.SalesBill){
			theType="销售单";
		}else{
			if(type==BillType.SalesReturnBill){
				theType="销售退货单";
			}else{
				if(type==BillType.PurchaseBill){
					theType="进货单";
				}else{
					if(type==BillType.PurchaseReturnBill){
						theType="进货退货单";
					}else{
						if(type==BillType.FinanceReciptBill){
							theType="收款单";
						}else{
							if(type==BillType.FinancePaymentBill){
								theType="付款单";
							}else{
								if(type==BillType.FinanceExpenseBill){
									theType="现金费用单";
								}else{
									if(type==BillType.StockOverflowBill){
										theType="库存报溢单";
									}else{
										if(type==BillType.StockUnderflowBill){
											theType="库存报损单";
										}else{
											if(type==BillType.StockGiftBill){
												theType="库存赠送单";
											}else{
												theType="";
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		JLabel label=new JLabel("经营历程表");
		JLabel labelStart=new JLabel("开始时间："+vo.getStart());
		JLabel labelEnd=new JLabel("结束时间："+vo.getEnd());
		JLabel labelType=new JLabel("单据类型:"+theType);
		JLabel labelClient=new JLabel("客户："+vo.getClient());
		JLabel labelOperator=new JLabel("操作员："+vo.getOperator());
		JLabel labelStorehouse=new JLabel("仓库："+vo.getStorehouse());
		
		ArrayList<SalesBillVO> listSales=vo.getList1();
		ArrayList<SalesReturnBillVO> listSalesReturn=vo.getList2();
		ArrayList<PurchaseBillVO> listPurchase=vo.getList3();
		ArrayList<PurchaseReturnBillVO> listPurchaseReturn=vo.getList4();
		ArrayList<ReciptVO> listRecipt=vo.getList5();
		ArrayList<PaymentVO> listPayment=vo.getList6();
		ArrayList<ExpenseVO> listExpense=vo.getList7();
		ArrayList<OverflowBillVO> listOverflow=vo.getList8();
		ArrayList<UnderflowBillVO> listUnderflow=vo.getList9();
		ArrayList<GiftBillVO> listGift=vo.getList10();
		for(int t=0;t<listSales.size();t++){
			data[t][0]=listSales.get(t).getId();
			data[t][1]="销售单";
		}
		for(int t=0;t<listSalesReturn.size();t++){
			data[t][0]=listSalesReturn.get(t).getId();
			data[t][1]="销售退货单";
		}
		for(int t=0;t<listPurchase.size();t++){
			data[t][0]=listPurchase.get(t).getId();
			data[t][1]="进货单";
		}
		for(int t=0;t<listPurchaseReturn.size();t++){
			data[t][0]=listPurchaseReturn.get(t).getId();
			data[t][1]="进货退货单";
		}
		for(int t=0;t<listRecipt.size();t++){
			data[t][0]=listRecipt.get(t).getId();
			data[t][1]="收款单";
		}
		for(int t=0;t<listPayment.size();t++){
			data[t][0]=listPayment.get(t).getId();
			data[t][1]="付款单";
		}
		for(int t=0;t<listExpense.size();t++){
			data[t][0]=listExpense.get(t).getId();
			data[t][1]="现金费用单";
		}
		for(int t=0;t<listOverflow.size();t++){
			data[t][0]=listOverflow.get(t).getId();
			data[t][1]="库存报溢单";
		}
		for(int t=0;t<listUnderflow.size();t++){
			data[t][0]=listUnderflow.get(t).getId();
			data[t][1]="库存报损单";
		}
		for(int t=0;t<listGift.size();t++){
			data[t][0]=listGift.get(t).getId();
			data[t][1]="库存赠送单";
		}
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		JScrollPane scroller=new JScrollPane(table);
		scroller.setEnabled(false);
		
		panel.setLayout(null);
		
		label.setBounds(wide/6-100,10,200,50);
		labelStart.setBounds(30,80,140,25);
		labelEnd.setBounds(190,80,140,25);
		labelType.setBounds(30,115,140,25);
		labelOperator.setBounds(190,115,140,25);
		labelClient.setBounds(30,150,140,25);
		labelStorehouse.setBounds(190,150,140,25);
		scroller.setBounds(30,190,350,300);
		
		panel.add(label);
		panel.add(labelStart);
		panel.add(labelEnd);
		panel.add(labelType);
		panel.add(labelOperator);
		panel.add(labelClient);
		panel.add(labelStorehouse);
		panel.add(scroller);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class tableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			String id=(String)table.getValueAt(table.getSelectedRow(), 0);
			String billType=(String)table.getValueAt(table.getSelectedRow(), 0);
			if(billType.equals("销售单")){
				SalesController controller=new SalesController();
				ArrayList<SalesBillVO> billSales=controller.getAllBills();
				SalesBillVO theBill=new SalesBillVO();
				for(int t=0;t<billSales.size();t++){
					if(billSales.get(t).getId().equals(id)){
						theBill=billSales.get(t);
					}
				}
				ProcessListShowSales showSales=new ProcessListShowSales();
				showSales.go(theBill,theJob);
			}else{
				if(billType.equals("销售退货单")){
					SalesController controller=new SalesController();
					ArrayList<SalesReturnBillVO> billSalesReturn=controller.getAllReturnBills();
					SalesReturnBillVO theBill=new SalesReturnBillVO();	
					for(int t=0;t<billSalesReturn.size();t++){
						if(billSalesReturn.get(t).getId().equals(id)){
							theBill=billSalesReturn.get(t);
						}
					}
				}else{
					if(billType.equals("进货单")){
						PurchaseController controller=new PurchaseController();
						ArrayList<PurchaseBillVO> billPurchase=controller.getAllBills();
						PurchaseBillVO theBill=new PurchaseBillVO();
						for(int t=0;t<billPurchase.size();t++){
							if(billPurchase.get(t).getId().equals(id)){
								theBill=billPurchase.get(t);
							}
						}
					}else{
						if(billType.equals("进货退货单")){
							PurchaseController controller=new PurchaseController();
							ArrayList<PurchaseReturnBillVO> billPurchaseReturn=controller.getAllReturnBills();
							PurchaseReturnBillVO theBill=new PurchaseReturnBillVO();
							for(int t=0;t<billPurchaseReturn.size();t++){
								if(billPurchaseReturn.get(t).getId().equals(id)){
									theBill=billPurchaseReturn.get(t);
								}
							}
						}else{
							if(billType.equals("收款单")){
								FinanceController controller=new FinanceController();
								ReciptVO recipt=controller.findRecipt(id);
							}else{
								if(billType.equals("付款单")){
									FinanceController controller=new FinanceController();
									PaymentVO payment=controller.findPayment(id);
								}else{
									if(billType.equals("现金费用单")){
										ExpenseController controller=new ExpenseController();
										ExpenseVO expense=controller.find(id);
									}else{
										if(billType.equals("库存报溢单")){
											StockController controller=new StockController();
											ArrayList<OverflowBillVO> billOverflow=controller.getAllOverflowBills();
											OverflowBillVO theBill=new OverflowBillVO();
											for(int t=0;t<billOverflow.size();t++){
												if(billOverflow.get(t).getId().equals(id)){
													theBill=billOverflow.get(t);
												}
											}
 										}else{
 											if(billType.equals("库存报损单")){
 												StockController controller=new StockController();
 												ArrayList<UnderflowBillVO> billUnderflow=controller.getAllUnderflowBills();
 												UnderflowBillVO theBill=new UnderflowBillVO();
 												for(int t=0;t<billUnderflow.size();t++){
 													if(billUnderflow.get(t).getId().equals(id)){
 														theBill=billUnderflow.get(t);
 													}
 												}
 											}else{
 												if(billType.equals("库存赠送单")){
 													StockController controller=new StockController();
 													ArrayList<GiftBillVO> billGift=controller.getAllGiftBills();
 													GiftBillVO theBill=new GiftBillVO();
 													for(int t=0;t<billGift.size();t++){
 														if(billGift.get(t).getId().equals(id)){
 															theBill=billGift.get(t);
 														}
 													}
 												}
 											}
 										}
									}
								}
							}
						}
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

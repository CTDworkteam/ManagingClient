package financecheckui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import enumType.UserJob;
import enumType.BillType;
import clientbl.ClientController;
import userbl.UserController;
import vo.*;
import confirmui.*;
import financecheckbl.FinanceCheckController;

/*
 * 查看经营里程表界面
 */
public class ProcessListCheck {

	JPanel panel=new JPanel();
	
	JTextField fieldStart;
	JTextField fieldEnd;
	JComboBox<String> boxType;
	JComboBox<String> boxClient;
	JComboBox<String> boxOperator;
	JTextField fieldStorehouse;
	
	UserJob theJob;
	
	public ProcessListCheck(UserJob job){
		
		this.theJob=job;
		
		JLabel labelStart=new JLabel("开始时间：");
		fieldStart=new JTextField();
		JLabel labelEnd=new JLabel("结束时间：");
		fieldEnd=new JTextField();
		
		JLabel labelType=new JLabel("单据类型");
		boxType=new JComboBox<String>();
		boxType.addItem(null);
		boxType.addItem("销售单");
		boxType.addItem("销售退货单");
		boxType.addItem("进货单");
		boxType.addItem("进货退货单");
		boxType.addItem("付款单");
		boxType.addItem("收款单");
		boxType.addItem("现金费用单");
		boxType.addItem("库存报溢单");
		boxType.addItem("库存报损单");
		boxType.addItem("库存赠送单");
		
		JLabel labelClient=new JLabel("客户：");
		boxClient=new JComboBox<String>();
		boxClient.addItem(null);
		ClientController clientController=new ClientController();
		ArrayList<ClientVO> clients=clientController.getList();
		for(int t=0;t<clients.size();t++){
			boxClient.addItem(Long.toString(clients.get(t).getId()));
		}
		
		JLabel labelOperator=new JLabel("操作员：");
		boxOperator=new JComboBox<String>();
		boxOperator.addItem(null);
		UserController userController=new UserController();
		ArrayList<UserVO> salers=userController.getAll().getSalesmanager();
		ArrayList<UserVO> purchasers=userController.getAll().getPurchasemanager();
		ArrayList<UserVO> financers=userController.getAll().getFinancemanager();
		ArrayList<UserVO> stockers=userController.getAll().getStockmanager();
		for(int t=0;t<salers.size();t++){
			boxOperator.addItem(Long.toString(salers.get(t).getId()));
		}
		for(int t=0;t<purchasers.size();t++){
			boxOperator.addItem(Long.toString(purchasers.get(t).getId()));
		}
		for(int t=0;t<financers.size();t++){
			boxOperator.addItem(Long.toString(financers.get(t).getId()));
		}
		for(int t=0;t<stockers.size();t++){
			boxOperator.addItem(Long.toString(stockers.get(t).getId()));
		}
		
		JLabel labelStorehouse=new JLabel("仓库：");
		fieldStorehouse=new JTextField();
		JButton button=new JButton("查询");
		
		panel.setLayout(null);
		
		labelStart.setBounds(20,10,60,25);
		fieldStart.setBounds(80,10,80,25);
		labelEnd.setBounds(180,10,60,25);
		fieldEnd.setBounds(240,10,80,25);
		labelType.setBounds(100,50,60,25);
		boxType.setBounds(160,50,80,25);
		labelClient.setBounds(100,85,60,25);
		boxClient.setBounds(160,85,80,25);
		labelOperator.setBounds(100,120,60,25);
		boxOperator.setBounds(160,120,80,25);
		labelStorehouse.setBounds(100,155,60,25);
		fieldStorehouse.setBounds(160,155,80,25);
		button.setBounds(350,80,65,65);
		
		panel.add(labelStart);
		panel.add(fieldStart);
		panel.add(labelEnd);
		panel.add(fieldEnd);
		panel.add(labelType);
		panel.add(boxType);
		panel.add(labelClient);
		panel.add(boxClient);
		panel.add(labelOperator);
		panel.add(boxOperator);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(button);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			 if(fieldStart.getText().equals(null)&&((String)boxType.getSelectedItem()).equals(null)&&((String)boxClient.getSelectedItem()).equals(null)&&((String)boxOperator.getSelectedItem()).equals(null)&&fieldStorehouse.getText().equals(null)){
				 Runnable r=new Confirmui("请填写查询筛选条件");
				 Thread thread=new Thread(r);
				 thread.start();
			 }else{
				 FinanceCheckController controller=new FinanceCheckController();
				 ArrayList<SalesBillVO> listSales=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturn=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchase=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturn=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listRecipt=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPayment=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpense=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflow=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflow=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGift=new ArrayList<GiftBillVO>();
				 
				 ArrayList<SalesBillVO> listSalesTime=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturnTime=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchaseTime=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturnTime=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listReciptTime=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPaymentTime=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpenseTime=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflowTime=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflowTime=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGiftTime=new ArrayList<GiftBillVO>();
				 if(!fieldStart.getText().equals(null)){
					 if(fieldEnd.getText().equals(null)){
						 Runnable r=new Confirmui("请填写完整时间信息");
						 Thread thread=new Thread(r);
						 thread.start();
					 }else{
						 String[] theStart=fieldStart.getText().split("/");
						 String[] theEnd=fieldEnd.getText().split("/");
						 GregorianCalendar start=new GregorianCalendar();
						 GregorianCalendar end=new GregorianCalendar();
						 start.set(Integer.parseInt(theStart[0]), Integer.parseInt(theStart[1]), Integer.parseInt(theStart[2]));
						 end.set(Integer.parseInt(theEnd[0]), Integer.parseInt(theEnd[1]), Integer.parseInt(theEnd[2]));
						 ProcessListVO processList=controller.getProcessList(start, end);
						 listSalesTime=processList.getList1();
						 listSalesReturnTime=processList.getList2();
						 listPurchaseTime=processList.getList3();
						 listPurchaseReturnTime=processList.getList4();
						 listReciptTime=processList.getList5();
						 listPaymentTime=processList.getList6();
						 listExpenseTime=processList.getList7();
						 listOverflowTime=processList.getList8();
						 listUnderflowTime=processList.getList9();
						 listGiftTime=processList.getList10();
					 }
				 }
				 
				 BillType type = null;
				 ArrayList<SalesBillVO> listSalesType=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturnType=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchaseType=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturnType=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listReciptType=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPaymentType=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpenseType=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflowType=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflowType=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGiftType=new ArrayList<GiftBillVO>();
				 if(!((String)boxType.getSelectedItem()).equals(null)){
					 String theType=(String)boxType.getSelectedItem();
					 if(theType.equals("销售单")){
						 type=BillType.SalesBill;
					 }else{
						 if(theType.equals("销售退货单")){
							 type=BillType.SalesReturnBill;
						 }else{
							 if(theType.equals("进货单")){
								 type=BillType.PurchaseBill;
							 }else{
								 if(theType.equals("进货退货单")){
									 type=BillType.PurchaseReturnBill;
								 }else{
									 if(theType.equals("收款单")){
										 type=BillType.FinanceReciptBill;
									 }else{
										 if(theType.equals("付款单")){
											 type=BillType.FinancePaymentBill;
										 }else{
											 if(theType.equals("现金费用单")){
												 type=BillType.FinanceExpenseBill;
											 }else{
												 if(theType.equals("库存报溢单")){
													 type=BillType.StockOverflowBill;
												 }else{
													 if(theType.equals("库存报损单")){
														 type=BillType.StockUnderflowBill;
													 }else{
														 type=BillType.StockGiftBill;
													 }
												 }
											 }
										 }
									 }
								 }
							 }
						 }
					 }
					 
					 ProcessListVO processList=controller.getProcessList(type);
					 listSalesType=processList.getList1();
					 listSalesReturnType=processList.getList2();
					 listPurchaseType=processList.getList3();
					 listPurchaseReturnType=processList.getList4();
					 listReciptType=processList.getList5();
					 listPaymentType=processList.getList6();
					 listExpenseType=processList.getList7();
					 listOverflowType=processList.getList8();
					 listUnderflowType=processList.getList9();
					 listGiftType=processList.getList10();
				 }
				 
				 ArrayList<SalesBillVO> listSalesClient=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturnClient=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchaseClient=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturnClient=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listReciptClient=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPaymentClient=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpenseClient=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflowClient=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflowClient=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGiftClient=new ArrayList<GiftBillVO>();
				 if(!((String)boxClient.getSelectedItem()).equals(null)){
					 ClientController clientController=new ClientController();
					 ClientVO client=clientController.find(Long.parseLong((String)boxClient.getSelectedItem()));
					 ProcessListVO processList=controller.getProcessList(client);
					 listSalesClient=processList.getList1();
					 listSalesReturnClient=processList.getList2();
					 listPurchaseClient=processList.getList3();
					 listPurchaseReturnClient=processList.getList4();
					 listReciptClient=processList.getList5();
					 listPaymentClient=processList.getList6();
					 listExpenseClient=processList.getList7();
					 listOverflowClient=processList.getList8();
					 listUnderflowClient=processList.getList9();
					 listGiftClient=processList.getList10();
				 }
				 
				 ArrayList<SalesBillVO> listSalesOperator=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturnOperator=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchaseOperator=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturnOperator=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listReciptOperator=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPaymentOperator=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpenseOperator=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflowOperator=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflowOperator=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGiftOperator=new ArrayList<GiftBillVO>();
				 if(!((String)boxOperator.getSelectedItem()).equals(null)){
					 UserController userController=new UserController();
					 UserVO operator=userController.findUser(Long.parseLong((String)boxOperator.getSelectedItem()));
					 ProcessListVO processList=controller.getProcessList(operator);
					 listSalesOperator=processList.getList1();
					 listSalesReturnOperator=processList.getList2();
					 listPurchaseOperator=processList.getList3();
					 listPurchaseReturnOperator=processList.getList4();
					 listReciptOperator=processList.getList5();
					 listPaymentOperator=processList.getList6();
					 listExpenseOperator=processList.getList7();
					 listOverflowOperator=processList.getList8();
					 listUnderflowOperator=processList.getList9();
					 listGiftOperator=processList.getList10();
				 }
				 
				 ArrayList<SalesBillVO> listSalesStorehouse=new ArrayList<SalesBillVO>();
				 ArrayList<SalesReturnBillVO> listSalesReturnStorehouse=new ArrayList<SalesReturnBillVO>();
				 ArrayList<PurchaseBillVO> listPurchaseStorehouse=new ArrayList<PurchaseBillVO>();
				 ArrayList<PurchaseReturnBillVO> listPurchaseReturnStorehouse=new ArrayList<PurchaseReturnBillVO>();
				 ArrayList<ReciptVO> listReciptStorehouse=new ArrayList<ReciptVO>();
				 ArrayList<PaymentVO> listPaymentStorehouse=new ArrayList<PaymentVO>();
				 ArrayList<ExpenseVO> listExpenseStorehouse=new ArrayList<ExpenseVO>();
				 ArrayList<OverflowBillVO> listOverflowStorehouse=new ArrayList<OverflowBillVO>();
				 ArrayList<UnderflowBillVO> listUnderflowStorehouse=new ArrayList<UnderflowBillVO>();
				 ArrayList<GiftBillVO> listGiftStorehouse=new ArrayList<GiftBillVO>();
				 if(!fieldStorehouse.getText().equals(null)){
					 ProcessListVO processList=controller.getProcessList(fieldStorehouse.getText());
					 listSalesStorehouse=processList.getList1();
					 listSalesReturnStorehouse=processList.getList2();
					 listPurchaseStorehouse=processList.getList3();
					 listPurchaseReturnStorehouse=processList.getList4();
					 listReciptStorehouse=processList.getList5();
					 listPaymentStorehouse=processList.getList6();
					 listExpenseStorehouse=processList.getList7();
					 listOverflowStorehouse=processList.getList8();
					 listUnderflowStorehouse=processList.getList9();
					 listGiftStorehouse=processList.getList10();
				 }
				 
				 listSales=controller.getSales(listSalesTime, listSalesType, listSalesClient, listSalesOperator, listSalesStorehouse);
				 listSalesReturn=controller.getSalesReturn(listSalesReturnTime, listSalesReturnType, listSalesReturnClient, listSalesReturnOperator, listSalesReturnStorehouse);
				 listPurchase=controller.getPurchase(listPurchaseTime, listPurchaseType, listPurchaseClient, listPurchaseOperator, listPurchaseStorehouse);
				 listPurchaseReturn=controller.getPurchaseReturn(listPurchaseReturnTime, listPurchaseReturnType, listPurchaseReturnClient, listPurchaseReturnOperator, listPurchaseReturnStorehouse);
				 listRecipt=controller.getRecipt(listReciptTime, listReciptType, listReciptClient, listReciptOperator, listReciptStorehouse);
				 listPayment=controller.getPayment(listPaymentTime, listPaymentType, listPaymentClient, listPaymentOperator, listPaymentStorehouse);
				 listExpense=controller.getExpense(listExpenseTime, listExpenseType, listExpenseClient, listExpenseOperator, listExpenseStorehouse);
				 listOverflow=controller.getOverflow(listOverflowTime, listOverflowType, listOverflowClient, listOverflowOperator, listOverflowStorehouse);
				 listUnderflow=controller.getUnderflow(listUnderflowTime, listUnderflowType, listUnderflowClient, listUnderflowOperator, listUnderflowStorehouse);
				 listGift=controller.getGift(listGiftTime, listGiftType, listGiftClient, listGiftOperator, listGiftStorehouse);
				 
				 ProcessListVO list=new ProcessListVO(fieldStart.getText(),fieldEnd.getText(),type,(String)boxClient.getSelectedItem(),(String)boxOperator.getSelectedItem(),fieldStorehouse.getText(),listSales,listSalesReturn,listPurchase,listPurchaseReturn,listRecipt,listPayment,listExpense,listOverflow,listUnderflow,listGift);
				 ProcessListShow show=new ProcessListShow();
				 show.go(list, theJob);
			 }
		}
	}
}

package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import financebl.FinanceController;
import expensebl.ExpenseController;

public class BillFinanceui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型","操作员"};
	
	String[][] dataRecipt=new String[100][3];
	String[][] dataPayment=new String[100][3];
	String[][] dataExpense=new String[100][3];
	
	JTable tableRecipt=new JTable(dataRecipt,heading);
	JTable tablePayment=new JTable(dataPayment,heading);
	JTable tableExpense=new JTable(dataExpense,heading);
	
	ArrayList<ReciptVO> recipt=new ArrayList<ReciptVO>();
	ArrayList<PaymentVO> payment=new ArrayList<PaymentVO>();
	ArrayList<ExpenseVO> expense=new ArrayList<ExpenseVO>();
	
	public void go(ArrayList<ReciptVO> recipt,ArrayList<PaymentVO> payment,ArrayList<ExpenseVO> expense){
		
		this.recipt=recipt;
		this.payment=payment;
		this.expense=expense;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		JButton button=new JButton("刷新");//刷新三个表格内容
		button.addActionListener(new buttonListener());
		
		for(int t=0;t<recipt.size();t++){
			dataRecipt[t][0]=recipt.get(t).getId();
			dataRecipt[t][1]="收款单";
			dataRecipt[t][2]=recipt.get(t).getOperator();
		}
		tableRecipt.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableRecipt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableRecipt.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//每次只能选择一行即一个单据
		tableRecipt.addMouseListener(new reciptListener());
		JScrollPane scrollerRecipt=new JScrollPane(tableRecipt);
		
		for(int t=0;t<payment.size();t++){
			dataPayment[t][0]=payment.get(t).getId();
			dataPayment[t][1]="付款单";
			dataPayment[t][2]=payment.get(t).getOperator();
		}
		tablePayment.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablePayment.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePayment.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tablePayment.addMouseListener(new paymentListener());
		JScrollPane scrollerPayment=new JScrollPane(tablePayment);
		
		for(int t=0;t<expense.size();t++){
			dataExpense[t][0]=expense.get(t).getId();
			dataExpense[t][1]="现金费用单";
			dataExpense[t][2]=expense.get(t).getOperator();
		}
		tableExpense.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableExpense.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableExpense.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableExpense.addMouseListener(new expenseListener());
		JScrollPane scrollerExpense=new JScrollPane(tableExpense);
		
		panel.setLayout(null);
		button.setBounds(630,3,65,25);
		scrollerRecipt.setBounds(30,40,180,360);
		scrollerPayment.setBounds(230,40,180,360);
		scrollerExpense.setBounds(430,40,180,360);
		
		panel.add(button);
		panel.add(scrollerRecipt);
		panel.add(scrollerPayment);
		panel.add(scrollerExpense);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			for(int t=0;t<recipt.size();t++){
				dataRecipt[t][0]=recipt.get(t).getId();
				dataRecipt[t][1]="收款单";
				dataRecipt[t][2]=recipt.get(t).getOperator();
			}
			
			for(int t=0;t<payment.size();t++){
				dataPayment[t][0]=payment.get(t).getId();
				dataPayment[t][1]="付款单";
				dataPayment[t][2]=payment.get(t).getOperator();
			}
			
			for(int t=0;t<expense.size();t++){
				dataExpense[t][0]=expense.get(t).getId();
				dataExpense[t][1]="现金费用单";
				dataExpense[t][2]=expense.get(t).getOperator();
			}
		}
	}
	
	class reciptListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			FinanceController controller=new FinanceController();
			ReciptVO theRecipt=controller.findRecipt((String)tableRecipt.getValueAt(tableRecipt.getSelectedRow(), 0));
			ReciptExamine examine=new ReciptExamine();
			examine.go(theRecipt);
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
	
	class paymentListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			FinanceController controller=new FinanceController();
			PaymentVO thePayment=controller.findPayment((String)tablePayment.getValueAt(tablePayment.getSelectedRow(), 0));
			PaymentExamine examine=new PaymentExamine();
			examine.go(thePayment);
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
	
	class expenseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			ExpenseController controller=new ExpenseController();
			ExpenseVO theExpense=controller.find((String)tableExpense.getValueAt(tableExpense.getSelectedRow(), 0));
			ExpenseExamine examine=new ExpenseExamine();
			examine.go(theExpense);
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

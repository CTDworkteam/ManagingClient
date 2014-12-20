package financeui;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

import vo.*;
import financebl.FinanceController;
import java.util.*;

/*
 * 制定付款单界面
 */
public class FinanceBillui {
	
	public JPanel panel=new JPanel();
	
	JTable table;
	
	JTextField fieldCustomer;//客户
	JTable tableFinanceItem;//转账信息
	JTextField fieldOperator;//操作员
	
	String[][] data;
	
	String billType;
	
	public FinanceBillui(String billType){
		
		this.billType=billType;
		
		FinanceController controller=new FinanceController();
		
		JButton button=new JButton("刷新");//刷新单据列表
		String[] heading={"编号","状态","操作员","客户"};//付款单列表表头
		//获取付款单或收款单列表信息
		if(billType=="付款单"){
			ArrayList<PaymentVO> payments=controller.getAllPayments();
			int size=payments.size();
			int count=0;
			for(int i=0;i<size;i++){
				if(payments.get(i).isPassed()==false){
					data[i][0]=payments.get(i).getId();
					data[i][1]="false";
					data[i][2]=payments.get(i).getOperator();
					data[i][3]=payments.get(i).getClient();
					count++;
				}
			}
			for(int i=0;i<size;i++){
				if(payments.get(i).isPassed()==true){
					data[i+count][0]=payments.get(i).getId();
					data[i+count][1]="true";
					data[i+count][2]=payments.get(i).getOperator();
					data[i+count][3]=payments.get(i).getClient();
				}
			}
		}else{
			ArrayList<ReciptVO> recipts=controller.getAllRecipts();
			int size=recipts.size();
			int count=0;
			for(int i=0;i<size;i++){
				if(recipts.get(i).isPassed()==false){
					data[i][0]=recipts.get(i).getId();
					data[i][1]="false";
					data[i][2]=recipts.get(i).getOperator();
					data[i][3]=recipts.get(i).getClient();
					count++;
				}
			}
			for(int i=0;i<size;i++){
				if(recipts.get(i).isPassed()==true){
					data[i+count][0]=recipts.get(i).getId();
					data[i+count][1]="true";
					data[i+count][2]=recipts.get(i).getOperator();
					data[i+count][3]=recipts.get(i).getClient();
				}
			}
		}
		//单据列表设置
		JTable table=new JTable(data,heading);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(true);
		JScrollPane scrollTable=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		
		JLabel labelNew=new JLabel("新建"+billType);
		JLabel labelCustomer=new JLabel("客户名",JLabel.RIGHT);
		fieldCustomer=new JTextField();
		JLabel labelOperator=new JLabel("操作员",JLabel.RIGHT);
		fieldOperator=new JTextField();
		
		//转账信息列表设置
		String[] headingItem={"银行帐户名","转账金额","备注"};
		String[][] dataItem=new String[6][3];
		tableFinanceItem=new JTable(dataItem,headingItem);
		tableFinanceItem.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableFinanceItem.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableFinanceItem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerItem=new JScrollPane(tableFinanceItem);
		
		JButton buttonAdd=new JButton("增加行");
		JButton buttonDelete=new JButton("删除行");
		
		buttonAdd.addActionListener(new addListener());
		buttonDelete.addActionListener(new deleteListener());
		
		JButton buttonCancel=new JButton("取消");
		buttonCancel.addActionListener(new cancelListener());
		JButton buttonOkay=new JButton("生成");
		buttonOkay.addActionListener(new okayListener());

		panel.setLayout(null);
		button.setBounds(150,10,65,25);
		scrollTable.setBounds(20,50,230,360);
		labelNew.setBounds(400,10,100,25);
		labelCustomer.setBounds(250,45,100,25);
		fieldCustomer.setBounds(360,45,150,25);
		labelOperator.setBounds(250,80,100,25);
		fieldOperator.setBounds(360,80,150,25);
		scrollerItem.setBounds(270,115,170,150);
		buttonAdd.setBounds(350,125,70,25);
		buttonDelete.setBounds(350,160,70,25);
		buttonCancel.setBounds(500,380,65,25);
		buttonOkay.setBounds(400,380,65,25);
		
		panel.add(button);
		panel.add(scrollTable);
		panel.add(labelNew);
		panel.add(labelCustomer);
		panel.add(fieldCustomer);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scrollerItem);
		panel.add(buttonAdd);
		panel.add(buttonDelete);
		panel.add(buttonCancel);
		panel.add(buttonOkay);
	}
	
	public int rowCount(JTable table){
		return table.getRowCount();
	}
	
	/*
	 * 选中付款单或收款单查看其内容
	 */
	class selectListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			FinanceController controller=new FinanceController();
			if(billType=="付款单"){
				PaymentVO vo=controller.findPayment((String)table.getValueAt(table.getSelectedRow(), 0));
				PaymentLook look=new PaymentLook();
				look.go(vo);
			}else{
				ReciptVO vo=controller.findRecipt((String)table.getValueAt(table.getSelectedRow(), 0));
				ReciptLook look=new ReciptLook();
				look.go(vo);
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
	
	/*
	 * 刷新列表
	 */
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			FinanceController controller=new FinanceController();
			
			if(billType=="付款单"){
				ArrayList<PaymentVO> payments=controller.getAllPayments();
				int size=payments.size();
				int count=0;
				for(int i=0;i<size;i++){
					if(payments.get(i).isPassed()==false){
						data[i][0]=payments.get(i).getId();
						data[i][1]="false";
						data[i][2]=payments.get(i).getOperator();
						data[i][3]=payments.get(i).getClient();
						count++;
					}
				}
				for(int i=0;i<size;i++){
					if(payments.get(i).isPassed()==true){
						data[i+count][0]=payments.get(i).getId();
						data[i+count][1]="true";
						data[i+count][2]=payments.get(i).getOperator();
						data[i+count][3]=payments.get(i).getClient();
					}
				}
			}else{
				ArrayList<ReciptVO> recipts=controller.getAllRecipts();
				int size=recipts.size();
				int count=0;
				for(int i=0;i<size;i++){
					if(recipts.get(i).isPassed()==false){
						data[i][0]=recipts.get(i).getId();
						data[i][1]="false";
						data[i][2]=recipts.get(i).getOperator();
						data[i][3]=recipts.get(i).getClient();
						count++;
					}
				}
				for(int i=0;i<size;i++){
					if(recipts.get(i).isPassed()==true){
						data[i+count][0]=recipts.get(i).getId();
						data[i+count][1]="true";
						data[i+count][2]=recipts.get(i).getOperator();
						data[i+count][3]=recipts.get(i).getClient();
					}
				}
			}

		}
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Vector<String[]> rowData=new Vector<String[]>();
			((DefaultTableModel)tableFinanceItem.getModel()).addRow(rowData);
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int theRow=tableFinanceItem.getSelectedRow();
			((DefaultTableModel)tableFinanceItem.getModel()).removeRow(theRow);
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fieldCustomer.setText(null);
			for(int t=0;t<rowCount(tableFinanceItem);t++){
				((DefaultTableModel)tableFinanceItem.getModel()).removeRow(t);
			}
		}
	}
	
	class okayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			FinanceController controller=new FinanceController();
			
			//获取单据编号
			GregorianCalendar date=new GregorianCalendar();
			String idPayment=controller.getNewPaymentID(date);
			String idRecipt=controller.getNewReciptID(date);
			
			//获取转账信息
			int size=rowCount(tableFinanceItem);
			double total=0;
			ArrayList<FinanceItemVO> items=new ArrayList<FinanceItemVO>();
			for(int t=0;t<size;t++){
				total=total+(Double)tableFinanceItem.getValueAt(t, 1);
				FinanceItemVO vo=new FinanceItemVO((String)tableFinanceItem.getValueAt(t, 0),(Double)tableFinanceItem.getValueAt(t, 1),(String)tableFinanceItem.getValueAt(t, 2));
				items.add(vo);
			}

			if(billType=="付款单"){
				PaymentConfirm payment=new PaymentConfirm();
				payment.go(new PaymentVO(idPayment,fieldOperator.getText(),fieldCustomer.getText(),items,total));
			}else{
				ReciptConfirm recipt=new ReciptConfirm();
				recipt.go(new ReciptVO(idRecipt,fieldOperator.getText(),fieldCustomer.getText(),items,total));
			}
		}
		
		
	}

}

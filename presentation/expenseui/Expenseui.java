package expenseui;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Expenseui {
	
	public JPanel panel=new JPanel();
	ExpenseConfirm expense=new ExpenseConfirm();
	
	JTable tableNew;
	
	public Expenseui(){
		String[] headingLook={"单据编号","银行账户名"};
		String[][] dataLook={{"XJFYD2014120100001","account1"},{" ","account2"},{"XJFYD2014120100002","account2"}};
		JTable tableLook=new JTable(dataLook,headingLook);
		JLabel labelNew=new JLabel("新建现金费用单");
		String[] headingNew={"银行账户","条目名","条目金额","备注信息"};
		String[][] dataNew=new String[5][4];
		tableNew=new JTable(dataNew,headingNew);
		JButton buttonOkay=new JButton("生成");
		buttonOkay.addActionListener(new okayListener());
		JButton buttonCancel=new JButton("取消");
		buttonCancel.addActionListener(new cancelListener());
		
		tableLook.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableLook.setColumnSelectionAllowed(false);
		tableLook.setRowSelectionAllowed(true);
		
		JScrollPane scrollerLook=new JScrollPane(tableLook);
		tableLook.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		JScrollPane scrollerNew=new JScrollPane(tableNew);
		tableNew.setPreferredScrollableViewportSize(new Dimension(460,60));
		int i;
		for(i=0;i<getColumnNum(tableNew);i++){
			tableNew.setEditingColumn(i);
		}
		
		panel.setLayout(null);
		scrollerLook.setBounds(20,10,300,400);
		scrollerNew.setBounds(350,45,300,300);
		labelNew.setBounds(450,10,150,25);
		buttonOkay.setBounds(410,380,65,25);
		buttonCancel.setBounds(520,380,65,25);
		
		panel.add(scrollerLook);
		panel.add(labelNew);
		panel.add(scrollerNew);
		panel.add(buttonOkay);
		panel.add(buttonCancel);
	}
	
	public int getColumnNum(JTable table){
		int n=table.getColumnCount();
		return n;
	}
	
	public int getRowNum(JTable table){
		int n=table.getRowCount();
		return n;
	}
	
	class okayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			expense.go();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
}

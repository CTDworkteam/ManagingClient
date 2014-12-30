package financecheckui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import vo.FinanceItemVO;
import vo.ReciptVO;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import financeui.*;

public class CopyRecipt {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel("收款单");
	
	JTextField fieldClient=new JTextField();
	JTextField fieldOperator=new JTextField();
	JTextField fieldTotal=new JTextField();
	
	String[] heading={"帐户名","转账金额","备注"};
	String[][] data=new String[5][3];
	JTable table=new JTable(data,heading);
	
	String id="";
	
	public void go(String id){
		
		this.id=id;
		
		JLabel labelID=new JLabel(id);
		JLabel labelClient=new JLabel("客户：");
		JLabel labelOperator=new JLabel("操作员：");
		JLabel labelTotal=new JLabel("总计：");
		
		//转账信息列表设置		
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		JButton buttonAdd=new JButton("增加行");
		JButton buttonDelete=new JButton("删除行");
		
		JButton buttonConfirm=new JButton("确定");
		JButton buttonCancel=new JButton("取消");
		
		buttonAdd.addActionListener(new addListener());
		buttonDelete.addActionListener(new deleteListener());
		buttonConfirm.addActionListener(new confirmListener());
		buttonCancel.addActionListener(new cancelListener());
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);		
		labelClient.setBounds(20,150,60,25);
		fieldClient.setBounds(80,150,90,25);
		labelOperator.setBounds(300,150,60,25);
		fieldOperator.setBounds(360,150,90,25);
		scroller.setBounds(20,190,300,300);
		buttonAdd.setBounds(340,200,70,25);
		buttonDelete.setBounds(340,240,70,25);
		labelTotal.setBounds(wide/4,400,55,25);
		fieldTotal.setBounds(wide/4+55,400,45,25);
		buttonConfirm.setBounds(50,440,65,25);
		buttonCancel.setBounds(135,440,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelClient);
		panel.add(fieldClient);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scroller);
		panel.add(buttonAdd);
		panel.add(buttonDelete);
		panel.add(labelTotal);
		panel.add(fieldTotal);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Vector<String[]> rowData=new Vector<String[]>();
			((DefaultTableModel)table.getModel()).addRow(rowData);
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int theRow=table.getSelectedRow();
			((DefaultTableModel)table.getModel()).removeRow(theRow);
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//获取转账信息
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			double total=0;
			ArrayList<FinanceItemVO> items=new ArrayList<FinanceItemVO>();
			for(int t=0;t<size;t++){
				total=total+(Double)table.getValueAt(t, 1);
				FinanceItemVO vo=new FinanceItemVO((String)table.getValueAt(t, 0),(Double)table.getValueAt(t, 1),(String)table.getValueAt(t, 2));
				items.add(vo);
			}
			fieldTotal.setText(Double.toString(total));
			ReciptConfirm recipt=new ReciptConfirm();
			recipt.go(new ReciptVO(id,fieldOperator.getText(),fieldClient.getText(),items,total));
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

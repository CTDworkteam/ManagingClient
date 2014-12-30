package financecheckui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import expenseui.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import vo.*;
import vo.ExpenseVO.ExpenseItemVO;

public class CopyExpense {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("�ֽ���õ�");
	JTextField fieldOperator=new JTextField();
	JTextField fieldAccount=new JTextField();
	JTextField fieldTotal=new JTextField();
	
	String[] heading={"��Ŀ��","��Ŀ���","��ע"};
	String[][] data=new String[5][3];
	JTable table=new JTable(data,heading);
	
	String id="";

	public void go(String id){
		
		this.id=id;
		
		JLabel labelID=new JLabel(id);
		JLabel labelOperator=new JLabel("����Ա��");
		JLabel labelAccount=new JLabel("�˻���");
		JLabel labelTotal=new JLabel("�ܼƣ�");
		
		//��Ŀ��Ϣ�б�����
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JButton buttonAdd=new JButton("������");
		JButton buttonDelete=new JButton("ɾ����");
		JScrollPane scroller=new JScrollPane(table);
		JButton buttonConfirm=new JButton("ȷ��");
		JButton buttonCancel=new JButton("ȡ��");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);
		labelAccount.setBounds(20,150,60,25);
		fieldAccount.setBounds(80,150,90,25);
		labelOperator.setBounds(300,150,60,25);
		fieldOperator.setBounds(360,150,90,25);
		scroller.setBounds(20,190,300,300);
		buttonAdd.setBounds(340,200,65,25);
		buttonDelete.setBounds(340,240,65,25);
		labelTotal.setBounds(wide/4,400,55,25);
		fieldTotal.setBounds(wide/4+55,400,45,25);
		buttonConfirm.setBounds(50,440,65,25);
		buttonCancel.setBounds(135,440,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelAccount);
		panel.add(fieldAccount);
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
			
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			double total=0;
			ArrayList<ExpenseItemVO> items=new ArrayList<ExpenseItemVO>();
			for(int t=0;t<size;t++){
				total=total+(Double)table.getValueAt(t, 1);
				ExpenseVO.ExpenseItemVO vo=new ExpenseVO().new ExpenseItemVO((String)table.getValueAt(t, 0),(Double)table.getValueAt(t, 1),(String)table.getValueAt(t, 2));
				items.add(vo);
			}
			fieldTotal.setText(Double.toString(total));
			
			ExpenseConfirm expense=new ExpenseConfirm();
			expense.go(new ExpenseVO(id,fieldOperator.getText(),fieldAccount.getText(),total,items));
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

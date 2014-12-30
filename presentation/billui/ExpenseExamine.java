package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import billbl.Bill;
import confirmui.*;
import enumType.ResultMessage;
import vo.*;
import vo.ExpenseVO.ExpenseItemVO;

/*
 * �����ֽ���õ���������
 */
public class ExpenseExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("�ֽ���õ�");
	
	String[] heading={"��Ŀ��","��Ŀ���","��ע"};
	String[][] data=new String[100][3];
	JTable table=new JTable(data,heading);
	
	JTextField fieldOperator=new JTextField();
	JTextField fieldAccount=new JTextField();
	JTextField fieldTotal=new JTextField();
	JComboBox<String> boxState=new JComboBox<String>();
	
	ExpenseVO vo=new ExpenseVO();
	
	public void go(ExpenseVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		ArrayList<ExpenseItemVO> items=vo.getList();
		//��Ŀ��Ϣ�б�����
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getItemName();
			data[t][1]=Double.toString(items.get(t).getMoney());
			data[t][2]=items.get(t).getNote();
		}
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);		
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelOperator=new JLabel("����Ա��");
		fieldOperator.setText(vo.getOperator());
		JLabel labelAccount=new JLabel("�˻���");
		fieldAccount.setText(vo.getAccount());
		JLabel labelTotal=new JLabel("�ܼƣ�");
		fieldTotal.setText(Double.toString(vo.getTotal()));
		boxState.addItem("δͨ��");
		boxState.addItem("ͨ��");
		JButton button=new JButton("ȷ��");
		
        panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);
		labelAccount.setBounds(20,120,65,25);
		fieldAccount.setBounds(85,120,85,25);
		labelOperator.setBounds(300,120,65,25);
		fieldOperator.setBounds(365,120,85,25);
		scroller.setBounds(50,160,300,300);
		labelTotal.setBounds(wide/4,370,60,25);
		fieldTotal.setBounds(wide/4+60,370,40,25);
		boxState.setBounds(wide/4,400,100,25);
		button.setBounds(wide/6,435,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelAccount);
		panel.add(fieldAccount);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scroller);
		panel.add(labelTotal);
		panel.add(fieldTotal);
		panel.add(boxState);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int count=0;
			if((String)table.getValueAt(0, 0)==null){
				Runnable r=new Confirmui("����д�����˻���");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				 while((String)table.getValueAt(count, 1)!=null||(String)table.getValueAt(count, 2)!=null){
					 count++;
				 }
				 
				 for(int t=0;t<count;t++){
					 if((String)table.getValueAt(t,1)==null||(String)table.getValueAt(t, 2)==null){
						 Runnable r=new Confirmui("��������д��Ŀ��Ϣ");
						 Thread thread=new Thread(r);
						 thread.start();
					 }else{
						 if(t==count-1){
							double total=0;
							ArrayList<ExpenseItemVO> item=new ArrayList<ExpenseItemVO>();
							for(int k=0;k<count;k++){
								ExpenseVO.ExpenseItemVO expenseItem=new ExpenseVO().new ExpenseItemVO();
								expenseItem.setItemName((String)table.getValueAt(k,1));
								expenseItem.setMoney(Double.parseDouble((String)table.getValueAt(k, 2)));
								expenseItem.setNote((String)table.getValueAt(k, 3));
								total=total+Double.parseDouble((String)table.getValueAt(k, 2));
							}
							 
							fieldTotal.setText(Double.toString(total));
							 
							ExpenseVO theExpense=new ExpenseVO(vo.getId(),fieldOperator.getText(),(String)table.getValueAt(0, 0),total,item);
							String state=(String) boxState.getSelectedItem();
							if(state=="ͨ��"){
								theExpense.setPassed(true);
							}else{
								theExpense.setPassed(false);
							}
							
							Bill bill=new Bill();
							ResultMessage result=bill.approveExpense(theExpense);
							String message="";
							if(result==ResultMessage.Failure){
									message="����ʧ��";
							}else{
								message="�ѳɹ�������������";
							}
							Runnable r=new Confirmui(message);
							Thread thread=new Thread(r);
							thread.start();
						 }
					 }
				 }
			}
		}
	}

}

package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import billbl.Bill;
import confirmui.*;
import enumType.ResultMessage;

/*
 * �����տ��������
 */
public class ReciptExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("�տ");
	
	String[][] data;
	JTable table;
	
	JTextField fieldClient;
	JTextField fieldOperator;
	JTextField fieldTotal;
	JComboBox<String> boxState;
	
	ReciptVO vo;
	
	public void go(ReciptVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		ArrayList<FinanceItemVO> items=vo.getList();
		//ת����Ϣ�б�����
		String[] heading={"�ʻ���","ת�˽��","��ע"};
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getAccount();
			data[t][1]=Double.toString(items.get(t).getMoney());
			data[t][2]=items.get(t).getNote();
		}
		table=new JTable(data,heading);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelClient=new JLabel("�ͻ���");
		fieldClient=new JTextField();
		fieldClient.setText(vo.getClient());
		JLabel labelOperator=new JLabel("����Ա��");
		fieldOperator=new JTextField();
		fieldOperator.setText(vo.getOperator());
		JLabel labelTotal=new JLabel("�ܼƣ�");
		fieldTotal=new JTextField();
		fieldTotal.setText(Double.toString(vo.getTotal()));
		boxState=new JComboBox<String>();
		boxState.addItem("δͨ��");
		boxState.addItem("ͨ��");
		JButton button=new JButton("ȷ��");//�������
		
		button.addActionListener(new buttonListener());
		
        panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);
		labelClient.setBounds(20,120,65,25);
		fieldClient.setBounds(85,120,85,25);
		labelOperator.setBounds(300,120,65,25);
		fieldOperator.setBounds(365,120,85,25);
		scroller.setBounds(50,160,400,300);
		labelTotal.setBounds(wide/4,370,60,25);
		fieldTotal.setBounds(wide/4+60,370,40,25);
		boxState.setBounds(wide/4,400,100,25);
		button.setBounds(wide/6,435,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelClient);
		panel.add(fieldClient);
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
			//����ת����Ϣ��Ŀ��
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			
			double total=0;
			ArrayList<FinanceItemVO> items=new ArrayList<FinanceItemVO>();
			for(int t=0;t<size;t++){
				total=total+(Double)table.getValueAt(t, 1);
				FinanceItemVO theItem=new FinanceItemVO((String)table.getValueAt(t, 0),(Double)table.getValueAt(t, 1),(String)table.getValueAt(t, 2));
				items.add(theItem);
			}
			
			fieldTotal.setText(Double.toString(total));
			
			Bill bill=new Bill();
			ReciptVO theRecipt=new ReciptVO(vo.getId(),fieldOperator.getText(),fieldClient.getText(),items,total);
			String state=(String)boxState.getSelectedItem();
			if(state=="ͨ��"){
				theRecipt.setPassed(true);
			}else{
				theRecipt.setPassed(false);
			}
			ResultMessage result=bill.approveRecipt(theRecipt);
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

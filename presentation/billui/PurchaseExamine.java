package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import billbl.Bill;
import enumType.ResultMessage;
import confirmui.*;

/*
 * ������������������
 */
public class PurchaseExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("������");
	
	String[][] data;
	JTable table;
	
	JTextField fieldSupplier;
	JTextField fieldStorehouse;
	JTextField fieldOperator;
	JTextField fieldTotal;
	JTextArea text;
	JComboBox<String> boxState;
	
	PurchaseBillVO vo;
	
	public void go(PurchaseBillVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high/5);
		
		ArrayList<PurchaseBillItemVO> items=vo.getList();
		
		String[] heading={"��Ʒ���","�ͺ�","����","����","�ܼ�","��ע"};
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getCommodity();
			data[t][1]=items.get(t).getModel();
			data[t][2]=Integer.toString(items.get(t).getNumber());
			data[t][3]=Double.toString(items.get(t).getPrice());
			data[t][4]=Double.toString(items.get(t).getTotal());
			data[t][5]=items.get(t).getNote();
		}
		table=new JTable(data,heading);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		
		JLabel labelID=new JLabel("���");
		JLabel labelSupplier=new JLabel("������");
		fieldSupplier=new JTextField();
		fieldSupplier.setText(vo.getSupplier());
		JLabel labelStorehouse=new JLabel("�ֿ�");
		fieldStorehouse=new JTextField();
		fieldStorehouse.setText(vo.getStorehouse());
		JLabel labelOperator=new JLabel("����Ա");
		fieldOperator=new JTextField();
		fieldOperator.setText(vo.getOperator());
		JLabel labelTotal=new JLabel("�ܼ�");
		fieldTotal=new JTextField();
		fieldTotal.setText(Double.toString(vo.getTotal()));
		text=new JTextArea();
		text.setLineWrap(true);
		text.setText(vo.getNote());
		JScrollPane scrollerText=new JScrollPane(text);
		boxState=new JComboBox<String>();
		boxState.addItem("δͨ��");
		boxState.addItem("ͨ��");
		JButton button=new JButton("ȷ��");
		
		button.addActionListener(new buttonListener());
		
		panel.setLayout(null);
		
		label.setBounds(wide/7,30,100,25);
		labelID.setBounds(wide/6,65,200,25);
		labelSupplier.setBounds(20,100,65,25);
		fieldSupplier.setBounds(85,100,85,25);
		labelStorehouse.setBounds(170,100,50,25);
		fieldStorehouse.setBounds(220,100,85,25);
		labelOperator.setBounds(315,100,65,25);
		fieldOperator.setBounds(365,100,85,25);
		scroller.setBounds(50,140,400,150);
		labelTotal.setBounds(wide/4-50,300,50,25);
		fieldTotal.setBounds(wide/4,300,50,25);
		scrollerText.setBounds(50,335,400,100);
		boxState.setBounds(wide/4-50,445,80,25);
		button.setBounds(wide/7,480,65,25);
			
		panel.add(label);
		panel.add(labelID);
		panel.add(labelSupplier);
		panel.add(fieldSupplier);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scroller);
		panel.add(labelTotal);
		panel.add(fieldTotal);
		panel.add(scrollerText);
		panel.add(boxState);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//����������Ʒ����
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			
			double total=0;
			ArrayList<PurchaseBillItemVO> items=new ArrayList<PurchaseBillItemVO>();
			for(int t=0;t<size;t++){
				total=total+(double)table.getValueAt(t, 4);
				PurchaseBillVO.PurchaseBillItemVO theItem=new PurchaseBillVO().new PurchaseBillItemVO((String)table.getValueAt(t, 0),(String)table.getValueAt(t, 1),(int)table.getValueAt(t, 2),(double)table.getValueAt(t, 3),(double)table.getValueAt(t, 4),(String)table.getValueAt(t, 5));
				items.add(theItem);
			}
			
			fieldTotal.setText(Double.toString(total));
			
			PurchaseBillVO thePurchaseBill=new PurchaseBillVO(vo.getId(),fieldSupplier.getText(),fieldStorehouse.getText(),fieldOperator.getText(),items,Double.parseDouble(fieldTotal.getText()),text.getText());
			String state=(String) boxState.getSelectedItem();
			if(state=="ͨ��"){
				thePurchaseBill.setPassed(true);
			}else{
				thePurchaseBill.setPassed(false);
			}
			
			Bill bill=new Bill();
			ResultMessage result=bill.approvePurchaseBill(thePurchaseBill);
			String message="";
			if(result==ResultMessage.Failure){
				message="����ʧ��";
			}else{
				message="�ѳɹ���������";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}

}

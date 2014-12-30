package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;
import billbl.Bill;
import enumType.ResultMessage;
import confirmui.*;

public class PurchaseReturnExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("进货退货单");
	
	String[] heading={"商品编号","型号","数量","单价","总价","备注"};
	String[][] data=new String[100][6];
	JTable table=new JTable(data,heading);
	
	JTextField fieldSupplier=new JTextField();
	JTextField fieldStorehouse=new JTextField();
	JTextField fieldOperator=new JTextField();
	JTextField fieldTotal=new JTextField();
	JTextArea text=new JTextArea();
	JComboBox<String> boxState=new JComboBox<String>();
	
	PurchaseReturnBillVO vo=new PurchaseReturnBillVO();
	
	public void go(PurchaseReturnBillVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high/5);
		
		ArrayList<PurchaseReturnBillItemVO> items=vo.getList();
		
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getCommodity();
			data[t][1]=items.get(t).getModel();
			data[t][2]=Integer.toString(items.get(t).getNumber());
			data[t][3]=Double.toString(items.get(t).getPrice());
			data[t][4]=Double.toString(items.get(t).getTotal());
			data[t][5]=items.get(t).getNote();
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelSupplier=new JLabel("进货商");
		fieldSupplier.setText(vo.getSupplier());
		JLabel labelStorehouse=new JLabel("仓库");
		fieldStorehouse.setText(vo.getStorehouse());
		JLabel labelOperator=new JLabel("操作员");
		fieldOperator.setText(vo.getOperator());
		JLabel labelTotal=new JLabel("总价");
		fieldTotal.setText(Double.toString(vo.getTotal()));
		text.setLineWrap(true);
		text.setText(vo.getNote());
		JScrollPane scrollerText=new JScrollPane(text);
		boxState.addItem("未通过");
		boxState.addItem("通过");
		JButton button=new JButton("确定");
		
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
			//计数进货商品种数
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			
			double total=0;
			ArrayList<PurchaseReturnBillItemVO> items=new ArrayList<PurchaseReturnBillItemVO>();
			for(int t=0;t<size;t++){
				total=total+(double)table.getValueAt(t, 4);
				PurchaseReturnBillVO.PurchaseReturnBillItemVO theItem=new PurchaseReturnBillVO().new PurchaseReturnBillItemVO((String)table.getValueAt(t, 0),(String)table.getValueAt(t, 1),(int)table.getValueAt(t, 2),(double)table.getValueAt(t, 3),(double)table.getValueAt(t, 4),(String)table.getValueAt(t, 5));
				items.add(theItem);
			}
			
			fieldTotal.setText(Double.toString(total));
			
			PurchaseReturnBillVO thePurchaseReturnBill=new PurchaseReturnBillVO(vo.getId(),fieldSupplier.getText(),fieldStorehouse.getText(),fieldOperator.getText(),items,Double.parseDouble(fieldTotal.getText()),text.getText());
			String state=(String) boxState.getSelectedItem();
			if(state=="通过"){
				thePurchaseReturnBill.setPassed(true);
			}else{
				thePurchaseReturnBill.setPassed(false);
			}
			
			Bill bill=new Bill();
			ResultMessage result=bill.approvePurchaseReturnBill(thePurchaseReturnBill);
			String message="";
			if(result==ResultMessage.Failure){
				message="操作失败";
			}else{
				message="已成功进行审批";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}


}

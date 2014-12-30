package billui;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;

import enumType.ResultMessage;
import confirmui.*;
import billbl.Bill;
import vo.*;
import vo.GiftBillVO.GiftBillItemVO;

/*
 * 单个库存赠送单审批界面
 */
public class GiftBillExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("库存赠送单");
	
	JTextField fieldClient=new JTextField();
	JTextField fieldStorehouse=new JTextField();
	JTextField fieldOperator=new JTextField();
	JComboBox<String> boxState=new JComboBox<String>();
	
	String[] heading={"编号","型号","数量"};
	String[][] data=new String[3][3];
	JTable table=new JTable(data,heading);
	
	GiftBillVO vo=new GiftBillVO();

	public void go(GiftBillVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2-250,high*3/4);
		frame.setLocation(wide/4,high/8);
		
		ArrayList<GiftBillItemVO> items=new ArrayList<GiftBillItemVO>();
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getCommodity();
			data[t][1]=items.get(t).getModel();
			data[t][2]=Integer.toString(items.get(t).getNumber());
		}
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		JScrollPane scroller=new JScrollPane(table);
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelClient=new JLabel("客户：");
		fieldClient.setText(vo.getClient());
		JLabel labelStorehouse=new JLabel("仓库：");
		fieldStorehouse.setText(vo.getStorehouse());
		JLabel labelOperator=new JLabel("操作员：");
		fieldOperator.setText(vo.getOperator());
		boxState.addItem("未通过");
		boxState.addItem("通过");
		JButton button=new JButton("确定");
		
		button.addActionListener(new buttonListener());
		
		panel.setLayout(null);
		
		label.setBounds(wide/7+20,30,100,50);
		labelID.setBounds(wide/7+70,110,200,25);
		labelClient.setBounds(70,155,60,25);
		fieldClient.setBounds(130,155,80,25);
		labelStorehouse.setBounds(70,200,60,25);
		fieldStorehouse.setBounds(130,200,80,25);
		labelOperator.setBounds(300,200,60,25);
		fieldOperator.setBounds(360,200,80,25);
		scroller.setBounds(70,260,400,100);
		boxState.setBounds(350,390,80,25);
		button.setBounds(wide/7+20,490,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelClient);
		panel.add(fieldClient);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scroller);
		panel.add(boxState);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//计数赠品种数
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			
			ArrayList<GiftBillItemVO> gifts=new ArrayList<GiftBillItemVO>();
			for(int t=0;t<size;t++){
				GiftBillVO.GiftBillItemVO theItem=new GiftBillVO().new GiftBillItemVO((String)table.getValueAt(t, 0),(String)table.getValueAt(t, 1),(int)table.getValueAt(t, 2));
				gifts.add(theItem);
			}
			
			GiftBillVO theBill=new GiftBillVO(vo.getId(),fieldClient.getText(),fieldStorehouse.getText(),fieldOperator.getText(),gifts);
			String state=(String)boxState.getSelectedItem();
			if(state=="未通过"){
				theBill.setPassed(false);
			}else{
				theBill.setPassed(true);
			}
			
			Bill bill=new Bill();
			ResultMessage result=bill.approveGiftBill(theBill);
			String message="";
			if(result==ResultMessage.Failure){
				message="操作失败";
			}else{
				message="成功审批";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}
}

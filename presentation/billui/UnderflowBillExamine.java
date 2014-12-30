package billui;
import javax.swing.*;

import java.awt.event.*;

import billbl.Bill;
import enumType.ResultMessage;
import confirmui.*;
import vo.*;

public class UnderflowBillExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("库存报损");
	
	JTextField fieldStorehouse=new JTextField();
	JTextField fieldCommodity=new JTextField();
	JTextField fieldModel=new JTextField();
	JTextField fieldRecordNumber=new JTextField();
	JTextField fieldActualNumber=new JTextField();
	JTextField fieldOperator=new JTextField();
	JTextArea text=new JTextArea();
	JComboBox<String> boxState=new JComboBox<String>();
	
	UnderflowBillVO vo=new UnderflowBillVO();

	public void go(UnderflowBillVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/4,high/2+20);
		frame.setLocation(wide/3,high/4);
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelStorehouse=new JLabel("仓库：");
		fieldStorehouse.setText(vo.getStorehouse());
		JLabel labelCommodity=new JLabel("商品：");
		fieldCommodity.setText(vo.getCommodity());
		JLabel labelModel=new JLabel("型号：");
		fieldModel.setText(vo.getModel());
		JLabel labelRecordNumber=new JLabel("记录数量：");
		fieldRecordNumber.setText(Integer.toString(vo.getRecordNumber()));
		JLabel labelActualNumber=new JLabel("实际数量：");
		fieldActualNumber.setText(Integer.toString(vo.getActualNumber()));
		JLabel labelOperator=new JLabel("操作员");
		fieldOperator.setText(vo.getOperator());
		text.setLineWrap(true);
		text.setText(vo.getNote());
		JScrollPane scroller=new JScrollPane(text);
		boxState.addItem("未通过");
		boxState.addItem("通过");
		JButton button=new JButton("确定");
		
		panel.setLayout(null);
		
		label.setBounds(150,10,100,30);
		labelID.setBounds(170,50,200,25);
		labelStorehouse.setBounds(20,85,60,25);
		fieldStorehouse.setBounds(80,85,80,25);
		labelOperator.setBounds(190,85,80,25);
		fieldOperator.setBounds(270,85,80,25);
		labelCommodity.setBounds(20,120,60,25);
		fieldCommodity.setBounds(80,120,80,25);
		labelModel.setBounds(190,120,80,25);
		fieldModel.setBounds(270,120,80,25);
		labelRecordNumber.setBounds(190,155,80,25);
		fieldRecordNumber.setBounds(270,155,80,25);
		labelActualNumber.setBounds(190,190,80,25);
		fieldActualNumber.setBounds(270,190,80,25);
		scroller.setBounds(20,230,320,100);
		boxState.setBounds(260,340,80,25);
		button.setBounds(170,380,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(labelCommodity);
		panel.add(fieldCommodity);
		panel.add(labelModel);
		panel.add(fieldModel);
		panel.add(labelRecordNumber);
		panel.add(fieldRecordNumber);
		panel.add(labelActualNumber);
		panel.add(fieldActualNumber);
		panel.add(scroller);
		panel.add(boxState);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			UnderflowBillVO theBill=new UnderflowBillVO(vo.getId(),fieldStorehouse.getText(),fieldCommodity.getText(),fieldModel.getText(),Integer.parseInt(fieldRecordNumber.getText()),Integer.parseInt(fieldActualNumber.getText()));
			theBill.setOperator(fieldOperator.getText());
			String state=(String)boxState.getSelectedItem();
			if(state=="未通过"){
				theBill.setPassed(false);
			}else{
				theBill.setPassed(true);
			}
			Bill bill=new Bill();
			ResultMessage result=bill.approveUnderflowBill(theBill);
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

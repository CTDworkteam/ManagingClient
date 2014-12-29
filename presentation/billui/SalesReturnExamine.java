package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import billbl.Bill;
import enumType.ResultMessage;
import confirmui.*;
import vo.SalesReturnBillVO.SalesReturnBillItemVO;
import vo.*;

/*
 * 单个销售退货单审批界面
 */
public class SalesReturnExamine {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("销售单");
	
	String[][] data=new String[6][6];
	JTable table;
	
	JTextField fieldClient;
	JTextField fieldDefaultOperator;
	JTextField fieldOperator;
	JTextField fieldStorehouse;
	JTextField fieldInitialTotal;
	JTextField fieldDiscount;
	JTextField fieldVoucher;
	JTextField fieldTotal;
	JTextArea text;
	JComboBox<String> boxState;
	
	SalesReturnBillVO vo;
	
	public void go(SalesReturnBillVO vo){
		
        this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2-200,high*3/4);
		frame.setLocation(wide/4,high/8);
		
		String[] heading={"编号","型号","数量","单价","总价","备注"};
		ArrayList<SalesReturnBillItemVO> items=vo.getList();
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
		
		JLabel labelID=new JLabel("编号");
		JLabel labelClient=new JLabel("客户：");
		fieldClient=new JTextField();
		fieldClient.setText(vo.getClient());
		JLabel labelDefaultOperator=new JLabel("默认业务员:");
		fieldDefaultOperator=new JTextField();
		fieldDefaultOperator.setText(vo.getDefaultOperator());
		JLabel labelOperator=new JLabel("操作员：");
		fieldOperator=new JTextField();
		fieldOperator.setText(vo.getOperator());
		JLabel labelStorehouse=new JLabel("仓库：");
		fieldStorehouse=new JTextField();
		fieldStorehouse.setText(vo.getStorehouse());
		JLabel labelInitialTotal=new JLabel("原始总价：");
		fieldInitialTotal=new JTextField();
		fieldInitialTotal.setText(Double.toString(vo.getInitialTotal()));
		JLabel labelDiscount=new JLabel("折扣：");
		fieldDiscount=new JTextField();
		fieldDiscount.setText(Double.toString(vo.getDiscount()));
		JLabel labelVoucher=new JLabel("代金券：");
		fieldVoucher=new JTextField();
		fieldVoucher.setText(Double.toString(vo.getVoucher()));
		JLabel labelTotal=new JLabel("最终总价：");
		fieldTotal=new JTextField();
		fieldTotal.setText(Double.toString(vo.getTotal()));
		text=new JTextArea();
		text.setLineWrap(true);
		text.setText(vo.getNote());
		JScrollPane scrollerText=new JScrollPane(text);
		boxState=new JComboBox<String>();
		boxState.addItem("未通过");
		boxState.addItem("通过");
		JButton button=new JButton("确定");
		
		button.addActionListener(new buttonListener());
		
		panel.setLayout(null);
		
		label.setBounds(wide/7,10,100,50);
		labelID.setBounds(wide/7+50,70,200,25);
		labelClient.setBounds(50,105,60,25);
		fieldClient.setBounds(110,105,85,25);
		labelDefaultOperator.setBounds(215,105,80,25);
		fieldDefaultOperator.setBounds(295,105,85,25);
		labelStorehouse.setBounds(50,140,60,25);
		fieldStorehouse.setBounds(110,140,85,25);
		labelOperator.setBounds(215,140,60,25);
		fieldOperator.setBounds(275,140,85,25);
		scroller.setBounds(50,175,430,150);
		labelInitialTotal.setBounds(50,335,80,25);
		fieldInitialTotal.setBounds(130,335,60,25);
		labelDiscount.setBounds(210,335,60,25);
		fieldDiscount.setBounds(270,335,60,25);
		labelVoucher.setBounds(210,370,60,25);
		fieldVoucher.setBounds(270,370,60,25);
		labelTotal.setBounds(350,335,80,25);
		fieldTotal.setBounds(430,335,60,25);
		scrollerText.setBounds(50,405,430,100);
		boxState.setBounds(430,515,80,25);
		button.setBounds(wide/7,550,65,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelClient);
		panel.add(fieldClient);
		panel.add(labelDefaultOperator);
		panel.add(fieldDefaultOperator);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scroller);
		panel.add(labelInitialTotal);
		panel.add(fieldInitialTotal);
		panel.add(labelDiscount);
		panel.add(fieldDiscount);
		panel.add(labelVoucher);
		panel.add(fieldVoucher);
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
			//计数销售商品种数
			int size=0;
			while(table.getValueAt(size, 0)!=null){
				size++;
			}
			
			double total=0;
			ArrayList<SalesReturnBillItemVO> items=new ArrayList<SalesReturnBillItemVO>();
			for(int t=0;t<size;t++){
				total=total+(double)table.getValueAt(t, 4);
				SalesReturnBillVO.SalesReturnBillItemVO theItem=new SalesReturnBillVO().new SalesReturnBillItemVO((String)table.getValueAt(t, 0),(String)table.getValueAt(t, 1),(int)table.getValueAt(t,2),(double)table.getValueAt(t,3),(double)table.getValueAt(t, 4),(String)table.getValueAt(t, 5));
				items.add(theItem);
			}
			
			fieldTotal.setText(Double.toString(total));
			
			SalesReturnBillVO theSalesReturn=new SalesReturnBillVO(vo.getId(),fieldClient.getText(),fieldDefaultOperator.getText(),fieldOperator.getText(),fieldStorehouse.getText(),items,Double.parseDouble(fieldInitialTotal.getText()),Double.parseDouble(fieldDiscount.getText()),Double.parseDouble(fieldVoucher.getText()),Double.parseDouble(fieldTotal.getText()),text.getText());
			String state=(String) boxState.getSelectedItem();
			if(state=="通过"){
				theSalesReturn.setPassed(true);
			}else{
				theSalesReturn.setPassed(false);
			}
			
			Bill bill=new Bill();
			ResultMessage result=bill.approveSalesReturnBill(theSalesReturn);
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

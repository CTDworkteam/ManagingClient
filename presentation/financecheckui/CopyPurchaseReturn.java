package financecheckui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import purchasebl.PurchaseController;
import confirmui.Confirmui;
import enumType.ResultMessage;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import vo.*;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;

public class CopyPurchaseReturn {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("进货单");
	
	String[] heading={"商品","型号","数量","单价","总价","备注"};
	String[][] data=new String[100][6];
	JTable table=new JTable(data,heading);
	
	JTextField fieldSupplier=new JTextField();
	JTextField fieldDefaultOperator=new JTextField();
	JTextField fieldOperator=new JTextField();
	JTextField fieldStorehouse=new JTextField();
	JTextField fieldTotal=new JTextField();
	JTextArea text=new JTextArea();
	
	String id="";

	public void go(String id){
		
		this.id=id;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-250);
		frame.setLocation(wide/3,high/8);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JButton buttonAdd=new JButton("增加行");
		JButton buttonDelete=new JButton("删除行");
		
		
		text.setLineWrap(true);
		
		JLabel labelID=new JLabel(id);
		JLabel labelSupplier=new JLabel("客户：");
		JLabel labelOperator=new JLabel("操作员：");
		JLabel labelStorehouse=new JLabel("仓库:");
		JScrollPane scrollerTable=new JScrollPane(table);
		JLabel labelTotal=new JLabel("总额：");
		JScrollPane scrollerText=new JScrollPane(text);
		JButton buttonConfirm=new JButton("确定");
		JButton buttonCancel=new JButton("取消");
		
		panel.setLayout(null);
		
		label.setBounds(200,20,100,50);
		labelID.setBounds(250,80,200,25);
		labelSupplier.setBounds(30,150,60,25);
		fieldSupplier.setBounds(90,150,90,25);
		labelStorehouse.setBounds(30,185,60,25);
		fieldStorehouse.setBounds(90,185,90,25);
		labelOperator.setBounds(210,185,60,25);
		fieldOperator.setBounds(270,185,90,25);
		scrollerTable.setBounds(30,220,350,100);
		buttonAdd.setBounds(400,230,70,25);
		buttonDelete.setBounds(400,265,70,25);
		labelTotal.setBounds(250,330,55,25);
		fieldTotal.setBounds(305,330,45,25);
		scrollerText.setBounds(30,400,400,80);
		buttonConfirm.setBounds(50,500,90,25);
		buttonCancel.setBounds(160,500,90,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelSupplier);
		panel.add(fieldSupplier);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(scrollerTable);
		panel.add(buttonAdd);
		panel.add(buttonDelete);
		panel.add(labelTotal);
		panel.add(fieldTotal);
		panel.add(scrollerText);
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
			ArrayList<PurchaseReturnBillItemVO> items=new ArrayList<PurchaseReturnBillItemVO>();
			for(int t=0;t<size;t++){
				total=total+(Double)table.getValueAt(t, 1);
				PurchaseReturnBillVO.PurchaseReturnBillItemVO vo=new PurchaseReturnBillVO().new PurchaseReturnBillItemVO((String)table.getValueAt(t, 0),(String)table.getValueAt(t, 1),(int)table.getValueAt(t, 2),(double)table.getValueAt(t, 3),(double)table.getValueAt(t, 4),(String)table.getValueAt(t, 5));
				items.add(vo);
			}
			fieldTotal.setText(Double.toString(total));
			fieldTotal.setText(Double.toString(total));
			PurchaseReturnBillVO theBill=new PurchaseReturnBillVO(id,fieldSupplier.getText(),fieldStorehouse.getText(),fieldOperator.getText(),items,total,text.getText());
			ArrayList<PurchaseReturnBillVO> bills=new ArrayList<PurchaseReturnBillVO>();
			bills.add(theBill);
			PurchaseController controller=new PurchaseController();
			ResultMessage result=controller.sendReturnBill(bills);
			String message="";
			if(result==ResultMessage.Failure){
				message="提交失败";
			}else{
				message="已成功提交复制进货单";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

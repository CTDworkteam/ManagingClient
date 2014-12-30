package financecheckui;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;

import vo.*;
import vo.SalesBillVO.SalesBillItemVO;
import enumType.ResultMessage;
import enumType.UserJob;
import financecheckbl.FinanceCheckController;
import confirmui.*;

public class ProcessListShowSales {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("销售单");
	
	SalesBillVO vo=new SalesBillVO();

	public void go(SalesBillVO vo,UserJob job){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-250);
		frame.setLocation(wide/3,high/8);
		
		String state="";
		if(vo.isPassed()==true){
			state="通过";
		}else{
			state="未通过";
		}
		
		ArrayList<SalesBillItemVO> billItem=vo.getList();
		String[] heading={"商品","型号","数量","单价","总价","备注"};
		String[][] data=new String[100][6];
		for(int t=0;t<billItem.size();t++){
			data[t][0]=billItem.get(t).getCommodity();
			data[t][1]=billItem.get(t).getModel();
			data[t][2]=Integer.toString(billItem.get(t).getNumber());
			data[t][3]=Double.toString(billItem.get(t).getPrice());
			data[t][4]=Double.toString(billItem.get(t).getTotal());
			data[t][5]=billItem.get(t).getNote();
		}
		JTable table=new JTable(data,heading);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JTextArea text=new JTextArea();
		text.setLineWrap(true);
		text.setText(vo.getNote());
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelState=new JLabel(state);
		JLabel labelClient=new JLabel("客户："+vo.getClient());
		JLabel labelDefaultOperator=new JLabel("默认业务员："+vo.getDefaultOperator());
		JLabel labelOperator=new JLabel("操作员："+vo.getOperator());
		JLabel labelStorehouse=new JLabel("仓库:"+vo.getStorehouse());
		JScrollPane scrollerTable=new JScrollPane(table);
		JLabel labelInitialTotal=new JLabel("起始金额："+Double.toString(vo.getInitialTotal()));
		JLabel labelDiscount=new JLabel("折扣："+Double.toString(vo.getDiscount()));
		JLabel labelVoucher=new JLabel("代金券："+Double.toString(vo.getVoucher()));
		JLabel labelTotal=new JLabel("总额："+Double.toString(vo.getTotal()));
		JScrollPane scrollerText=new JScrollPane(text);
		JButton button=new JButton("红冲");
		JButton buttonCopy=new JButton("红冲并复制");
		
		button.addActionListener(new buttonListener());
		buttonCopy.addActionListener(new buttonCopyListener());
		
		panel.setLayout(null);
		
		label.setBounds(200,20,100,50);
		labelID.setBounds(250,80,200,25);
		labelState.setBounds(250,115,70,25);
		labelClient.setBounds(30,150,150,25);
		labelDefaultOperator.setBounds(210,150,150,25);
		labelStorehouse.setBounds(30,185,150,25);
		labelOperator.setBounds(210,185,150,25);
		scrollerTable.setBounds(30,220,400,100);
		labelInitialTotal.setBounds(30,330,100,25);
		labelDiscount.setBounds(140,330,100,25);
		labelVoucher.setBounds(140,365,100,25);
		labelTotal.setBounds(250,330,100,25);
		scrollerText.setBounds(30,400,400,80);
		button.setBounds(50,500,90,25);
		buttonCopy.setBounds(160,500,90,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelState);
		panel.add(labelClient);
		panel.add(labelDefaultOperator);
		panel.add(labelOperator);
		panel.add(labelStorehouse);
		panel.add(scrollerTable);
		panel.add(labelInitialTotal);
		panel.add(labelDiscount);
		panel.add(labelVoucher);
		panel.add(labelTotal);
		panel.add(scrollerText);
		if(job==UserJob.FinanceManager){
			panel.add(button);
			panel.add(buttonCopy);
		}
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			ResultMessage result=controller.deficitInvoice(vo);
			String message="";
			if(result==ResultMessage.Failure){
				message="红冲失败";
			}else{
				message="已成功进行红冲";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}
	
	class buttonCopyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			ResultMessage result=controller.deficitInvoice(vo);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("红冲失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				Runnable r=new Confirmui("已成功进行红冲");
				Thread thread=new Thread(r);
				thread.start();
				CopySales copy=new CopySales();
				copy.go(vo.getId());
			}
		}
	}
}

package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;

/*
 * 库存单据审批界面
 */
public class BillStockui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型","操作员"};
	
	String[][] dataGift;
	String[][] dataOverFlow;
	String[][] dataUnderFlow;
	
	JTable tableGift=new JTable(dataGift,heading);
	JTable tableOverFlow=new JTable(dataOverFlow,heading);
	JTable tableUnderFlow=new JTable(dataUnderFlow,heading);
	
	ArrayList<GiftBillVO> giftBill;
	ArrayList<OverflowBillVO> overFlowBill;
	ArrayList<UnderflowBillVO> underFlowBill;
	
	public void go(ArrayList<GiftBillVO> giftBill,ArrayList<OverflowBillVO> overFlowBill,ArrayList<UnderflowBillVO> underFlowBill){
		
		this.giftBill=giftBill;
		this.overFlowBill=overFlowBill;
		this.underFlowBill=underFlowBill;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		JButton button=new JButton("刷新");//刷新三个表格内容
		
		
		for(int t=0;t<giftBill.size();t++){
			dataGift[t][0]=giftBill.get(t).getId();
			dataGift[t][1]="库存赠送单";
			dataGift[t][2]=giftBill.get(t).getOperator();
		}
		tableGift.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableGift.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerGift=new JScrollPane(tableGift);
		
		for(int t=0;t<overFlowBill.size();t++){
			dataOverFlow[t][0]=overFlowBill.get(t).getId();
			dataOverFlow[t][1]="库存报溢单";
			dataOverFlow[t][2]=overFlowBill.get(t).getOperator();
		}
		tableOverFlow.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableOverFlow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerOverFlow=new JScrollPane(tableOverFlow);
		
		for(int t=0;t<underFlowBill.size();t++){
			dataUnderFlow[t][0]=underFlowBill.get(t).getId();
			dataUnderFlow[t][1]="库存报损单";
			dataUnderFlow[t][2]=underFlowBill.get(t).getOperator();
		}
		tableUnderFlow.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableUnderFlow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerUnderFlow=new JScrollPane(tableUnderFlow);
		
		panel.setLayout(null);
		button.setBounds(630,3,65,25);
		scrollerGift.setBounds(30,40,180,360);
		scrollerOverFlow.setBounds(230,40,180,360);
		scrollerUnderFlow.setBounds(430,40,180,360);
		
		panel.add(button);
		panel.add(scrollerGift);
		panel.add(scrollerOverFlow);
		panel.add(scrollerUnderFlow);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			for(int t=0;t<giftBill.size();t++){
				dataGift[t][0]=giftBill.get(t).getId();
				dataGift[t][1]="库存赠送单";
				dataGift[t][2]=giftBill.get(t).getOperator();
			}
			
			for(int t=0;t<overFlowBill.size();t++){
				dataOverFlow[t][0]=overFlowBill.get(t).getId();
				dataOverFlow[t][1]="库存报溢单";
				dataOverFlow[t][2]=overFlowBill.get(t).getOperator();
			}
			
			for(int t=0;t<underFlowBill.size();t++){
				dataUnderFlow[t][0]=underFlowBill.get(t).getId();
				dataUnderFlow[t][1]="库存报损单";
				dataUnderFlow[t][2]=underFlowBill.get(t).getOperator();
			}
		}
	}

}

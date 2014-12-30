package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import stockbl.StockController;

/*
 * 库存单据审批界面
 */
public class BillStockui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型","操作员"};
	
	String[][] dataGift=new String[100][3];
	String[][] dataOverFlow=new String[100][3];
	String[][] dataUnderFlow=new String[100][3];
	
	JTable tableGift=new JTable(dataGift,heading);
	JTable tableOverFlow=new JTable(dataOverFlow,heading);
	JTable tableUnderFlow=new JTable(dataUnderFlow,heading);
	
	ArrayList<GiftBillVO> giftBill=new ArrayList<GiftBillVO>();
	ArrayList<OverflowBillVO> overFlowBill=new ArrayList<OverflowBillVO>();
	ArrayList<UnderflowBillVO> underFlowBill=new ArrayList<UnderflowBillVO>();
	
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
		tableGift.addMouseListener(new giftListener());
		JScrollPane scrollerGift=new JScrollPane(tableGift);
		
		for(int t=0;t<overFlowBill.size();t++){
			dataOverFlow[t][0]=overFlowBill.get(t).getId();
			dataOverFlow[t][1]="库存报溢单";
			dataOverFlow[t][2]=overFlowBill.get(t).getOperator();
		}
		tableOverFlow.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableOverFlow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableOverFlow.addMouseListener(new overflowListener());
		JScrollPane scrollerOverFlow=new JScrollPane(tableOverFlow);
		
		for(int t=0;t<underFlowBill.size();t++){
			dataUnderFlow[t][0]=underFlowBill.get(t).getId();
			dataUnderFlow[t][1]="库存报损单";
			dataUnderFlow[t][2]=underFlowBill.get(t).getOperator();
		}
		tableUnderFlow.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableUnderFlow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableUnderFlow.addMouseListener(new underflowListener());
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
	
	class giftListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			StockController controller=new StockController();
			ArrayList<GiftBillVO> bills=controller.getAllGiftBills();
			String id=(String)tableGift.getValueAt(tableGift.getSelectedRow(), 0);
			GiftBillVO theBill=new GiftBillVO();
			for(int t=0;t<bills.size();t++){
				if(bills.get(t).getId()==id){
					theBill=bills.get(t);
				}
			}
			GiftBillExamine examine=new GiftBillExamine();
			examine.go(theBill);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class overflowListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			StockController controller=new StockController();
			ArrayList<OverflowBillVO> bills=controller.getAllOverflowBills();
			String id=(String)tableOverFlow.getValueAt(tableOverFlow.getSelectedRow(), 0);
			OverflowBillVO theBill=new OverflowBillVO();
			for(int t=0;t<bills.size();t++){
				if(bills.get(t).getId()==id){
					theBill=bills.get(t);
				}
			}
			OverflowBillExamine examine=new OverflowBillExamine();
			examine.go(theBill);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class underflowListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			StockController controller=new StockController();
			ArrayList<UnderflowBillVO> bills=controller.getAllUnderflowBills();
			String id=(String)tableUnderFlow.getValueAt(tableUnderFlow.getSelectedRow(), 0);
			UnderflowBillVO theBill=new UnderflowBillVO();
			for(int t=0;t<bills.size();t++){
				if(bills.get(t).getId()==id){
					theBill=bills.get(t);
				}
			}
			UnderflowBillExamine examine=new UnderflowBillExamine();
			examine.go(theBill);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

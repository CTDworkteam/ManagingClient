package billui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import purchasebl.PurchaseController;

/*
 * 进货单据审批界面
 */
public class BillPurchaseui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型","操作员"};
	
	String[][] dataPurchase=new String[100][3];
	String[][] dataPurchaseReturn=new String[100][3];
	
	JTable tablePurchase=new JTable(dataPurchase,heading);
	JTable tablePurchaseReturn=new JTable(dataPurchaseReturn,heading);
	
	ArrayList<PurchaseBillVO> purchaseBill=new ArrayList<PurchaseBillVO>();
	ArrayList<PurchaseReturnBillVO> purchaseReturnBill=new ArrayList<PurchaseReturnBillVO>();
	
	public void go(ArrayList<PurchaseBillVO> purchaseBill,ArrayList<PurchaseReturnBillVO> purchaseReturnBill){
		
		this.purchaseBill=purchaseBill;
		this.purchaseReturnBill=purchaseReturnBill;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		JButton button=new JButton("刷新");//刷新两个表格内容
		button.addActionListener(new buttonListener());
		
		for(int t=0;t<purchaseBill.size();t++){
			dataPurchase[t][0]=purchaseBill.get(t).getId();
			dataPurchase[t][1]="进货单";
			dataPurchase[t][2]=purchaseBill.get(t).getOperator();
		}
		tablePurchase.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablePurchase.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePurchase.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//每次选中一个单据
		tablePurchase.addMouseListener(new purchaseListener());
		JScrollPane scrollerPurchase=new JScrollPane(tablePurchase);
		
		for(int t=0;t<purchaseReturnBill.size();t++){
			dataPurchaseReturn[t][0]=purchaseReturnBill.get(t).getId();
			dataPurchaseReturn[t][1]="进货退货单";
			dataPurchaseReturn[t][2]=purchaseReturnBill.get(t).getOperator();
		}
		tablePurchaseReturn.getColumnModel().getColumn(0).setPreferredWidth(100);
		tablePurchaseReturn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tablePurchaseReturn.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tablePurchaseReturn.addMouseListener(new purchaseReturnListener());
		JScrollPane scrollerPurchaseReturn=new JScrollPane(tablePurchaseReturn);
		
		panel.setLayout(null);
		button.setBounds(630,3,65,25);
		scrollerPurchase.setBounds(100,40,180,360);
		scrollerPurchaseReturn.setBounds(350,40,180,360);
		
		panel.add(button);
		panel.add(scrollerPurchase);
		panel.add(scrollerPurchaseReturn);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			for(int t=0;t<purchaseBill.size();t++){
				dataPurchase[t][0]=purchaseBill.get(t).getId();
				dataPurchase[t][1]="";
				dataPurchase[t][2]=purchaseBill.get(t).getOperator();
			}
			
			for(int t=0;t<purchaseReturnBill.size();t++){
				dataPurchaseReturn[t][0]=purchaseReturnBill.get(t).getId();
				dataPurchaseReturn[t][1]="";
				dataPurchaseReturn[t][2]=purchaseReturnBill.get(t).getOperator();
			}
		}
	}
	
	class purchaseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PurchaseController controller=new PurchaseController();
			ArrayList<PurchaseBillVO> purchase=controller.getAllBills();
			String id=(String)tablePurchase.getValueAt(tablePurchase.getSelectedRow(), 0);
			PurchaseBillVO theBill=new PurchaseBillVO();
			for(int t=0;t<purchase.size();t++){
				if(purchase.get(t).getId()==id){
					theBill=purchase.get(t);
				}
			}
			PurchaseExamine examine=new PurchaseExamine();
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
	
	class purchaseReturnListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			PurchaseController controller=new PurchaseController();
			ArrayList<PurchaseReturnBillVO> purchaseReturn=controller.getAllReturnBills();
			String id=(String)tablePurchase.getValueAt(tablePurchase.getSelectedRow(), 0);
			PurchaseReturnBillVO theBill=new PurchaseReturnBillVO();
			for(int t=0;t<purchaseReturn.size();t++){
				if(purchaseReturn.get(t).getId()==id){
					theBill=purchaseReturn.get(t);
				}
			}
			PurchaseReturnExamine examine=new PurchaseReturnExamine();
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

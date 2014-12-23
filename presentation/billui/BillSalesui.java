package billui;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import vo.*;

/*
 * 销售单据审批界面
 */
public class BillSalesui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[] heading={"编号","类型","操作员"};
	
	String[][] dataSales;
	String[][] dataSalesReturn;
	
	JTable tableSales=new JTable(dataSales,heading);
	JTable tableSalesReturn=new JTable(dataSalesReturn,heading);
	
	ArrayList<SalesBillVO> salesBill;
	ArrayList<SalesReturnBillVO> salesReturnBill;
	
	public void go(ArrayList<SalesBillVO> salesBill,ArrayList<SalesReturnBillVO> salesReturnBill){
		
		this.salesBill=salesBill;
		this.salesReturnBill=salesReturnBill;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		JButton button=new JButton("刷新");//刷新两个表格的内容
		button.addActionListener(new buttonListener());
		
		for(int t=0;t<salesBill.size();t++){
			dataSales[t][0]=salesBill.get(t).getId();
			dataSales[t][1]="销售单";
			dataSales[t][2]=salesBill.get(t).getOperator();
		}
		tableSales.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableSales.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerSales=new JScrollPane(tableSales);
		
		for(int t=0;t<salesReturnBill.size();t++){
			dataSalesReturn[t][0]=salesReturnBill.get(t).getId();
			dataSalesReturn[t][1]="销售退货单";
			dataSalesReturn[t][2]=salesReturnBill.get(t).getOperator();
		}
		tableSalesReturn.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableSalesReturn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerSalesReturn=new JScrollPane(tableSalesReturn);
		
		panel.setLayout(null);
		button.setBounds(630,3,65,25);
		scrollerSales.setBounds(100,40,180,360);
		scrollerSalesReturn.setBounds(350,40,180,360);
		
		panel.add(button);
		panel.add(scrollerSales);
		panel.add(scrollerSalesReturn);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			for(int t=0;t<salesBill.size();t++){
				dataSales[t][0]=salesBill.get(t).getId();
				dataSales[t][1]="销售单";
				dataSales[t][2]=salesBill.get(t).getOperator();
			}
			
			for(int t=0;t<salesReturnBill.size();t++){
				dataSalesReturn[t][0]=salesReturnBill.get(t).getId();
				dataSalesReturn[t][1]="销售退货单";
				dataSalesReturn[t][2]=salesReturnBill.get(t).getOperator();
			}
		}
	}

}

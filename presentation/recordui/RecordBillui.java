package recordui;
import java.awt.Dimension;
import java.util.*;

import javax.swing.*;

import recordbl.RecordController;
import vo.*;
import enumType.Operation;

/*
 * 查询制定单据操作日志记录界面
 */
public class RecordBillui {
	
	public JPanel panel=new JPanel();
	
	public RecordBillui(){
		
		RecordController controller=new RecordController();
		ArrayList<RecordVO> theRecord=controller.list();
		ArrayList<RecordVO> records=new ArrayList<RecordVO>();
		for(int t=0;t<theRecord.size();t++){
			Operation theOperation=theRecord.get(t).getOperation();
			if(theOperation==Operation.Expense||theOperation==Operation.Payment||theOperation==Operation.Expense||theOperation==Operation.PurchaseBill||theOperation==Operation.PurchaseReturnBill||theOperation==Operation.SalesBill||theOperation==Operation.SalesReturnBill){
				records.add(theRecord.get(t));
			}
		}
		String[] heading={"单据类型","操作","操作内容","操作员"};
		String[][] data=new String[100][4];
		for(int t=0;t<records.size();t++){
			data[t][0]=controller.changeOperation(records.get(t).getOperation());
			data[t][1]=controller.changeAction(records.get(t).getAction());
			data[t][2]=records.get(t).getNote();
			data[t][3]=records.get(t).getOperator();
		}
		JTable table=new JTable(data,heading);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setPreferredSize(new Dimension(460,60));
		JScrollPane scroller=new JScrollPane(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.setLayout(null);
		scroller.setBounds(0,0,745,440);
		
		panel.add(scroller);
	}

}

package recordui;
import java.awt.Dimension;

import javax.swing.*;

/*
 * 查询制定单据操作日志记录界面
 */
public class RecordBillui {
	
	public JPanel panel=new JPanel();
	
	public RecordBillui(){
		
		String[] heading={"ID","操作者","操作行为","单据类型","单据ID"};
		String[][] data=new String[5][5];
		JTable table=new JTable(data,heading);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setPreferredSize(new Dimension(460,60));
		JScrollPane scroller=new JScrollPane(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.setLayout(null);
		scroller.setBounds(0,0,745,440);
		
		panel.add(scroller);
	}

}

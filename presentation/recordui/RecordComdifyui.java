package recordui;
import java.awt.Dimension;

import javax.swing.*;

/*
 * 查看修改操作日志记录界面
 */
public class RecordComdifyui {
	
	public JPanel panel=new JPanel();
	
	public RecordComdifyui(){
		
		String[] heading={"ID","操作者","操作行为","操作对象","修改属性","修改前数据","修改后数据"};
		String[][] data=new String[5][7];
		JTable table=new JTable(data,heading);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		table.setPreferredSize(new Dimension(460,60));
		JScrollPane scroller=new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel.setLayout(null);
		scroller.setBounds(0,0,745,440);
		
		panel.add(scroller);
	}

}

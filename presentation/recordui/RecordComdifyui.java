package recordui;
import java.awt.Dimension;

import javax.swing.*;

/*
 * �鿴�޸Ĳ�����־��¼����
 */
public class RecordComdifyui {
	
	public JPanel panel=new JPanel();
	
	public RecordComdifyui(){
		
		String[] heading={"ID","������","������Ϊ","��������","�޸�����","�޸�ǰ����","�޸ĺ�����"};
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

package recordui;
import java.awt.Dimension;

import javax.swing.*;

/*
 * ��ѯ�ƶ����ݲ�����־��¼����
 */
public class RecordBillui {
	
	public JPanel panel=new JPanel();
	
	public RecordBillui(){
		
		String[] heading={"ID","������","������Ϊ","��������","����ID"};
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

package strategyui;
import javax.swing.*;

import java.awt.*;

public class MessageStock {
	
	public JPanel panel=new JPanel();
	
	public MessageStock(){
		String[] heading={"�ֿ���","��Ʒ���","��Ʒ��","��Ʒ�ͺ�","�������","����","�ۼ�","�������","����ۼ�"};
		String[][] data={{"01","***********001","�չ��","SR01","100","20.0","21.0","20.0","21.0"}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane();
		scroller.getViewport().add(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.setSize(new Dimension(460,60));
		
		panel.setLayout(null);
		scroller.setBounds(0,0,410,460);
		
		panel.add(scroller);
	}

}

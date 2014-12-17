package strategyui;
import javax.swing.*;

import java.awt.*;

public class MessageStrategy {
	
	public JPanel panel=new JPanel();
	
	public MessageStrategy(){
		String[] heading={"实施起始日期","实施结束日期","策略内容"};
		String[][] data={{"2014/1/2","2014/3/5","*******************************"}};
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

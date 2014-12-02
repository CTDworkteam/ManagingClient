package strategyui;
import javax.swing.*;

import java.awt.*;

public class MessageStock {
	
	public JPanel panel=new JPanel();
	
	public MessageStock(){
		String[] heading={"仓库编号","商品编号","商品名","商品型号","库存数量","进价","售价","最近进价","最近售价"};
		String[][] data={{"01","***********001","日光灯","SR01","100","20.0","21.0","20.0","21.0"}};
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

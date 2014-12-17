package initialui;
import javax.swing.*;

public class InitialCommodity {
	
	public JPanel panelCommodity=new JPanel();
	
	public InitialCommodity(){
		JButton button=new JButton("导入");
		String[] heading={"类名","类名","类名","类名","类名","商品名","型号","进价","售价","最近进价","最近售价"};
		String[][] data={{"***","***","***","***","***","日光灯","SR01","50.0","55.0",null,null},{"***","***","***","***","***","日光灯","DK01","46.0","50.5",null,null}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panelCommodity.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,440);
		
		panelCommodity.add(button);
		panelCommodity.add(scroller);
	}

}

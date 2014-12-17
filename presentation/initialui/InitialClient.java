package initialui;
import javax.swing.*;

public class InitialClient {
	
	public JPanel panelClient=new JPanel();
	
	public InitialClient(){
		JButton button=new JButton("导入");
		String[] heading={"编号","客户类别","客户级别","姓名","电话","地址","邮编","电子邮箱","应收额度","应收","应付","默认业务员"};
		String[][] data={{"01","进货商","1","李某","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","进货员***"},
				{"02","销售商","1","林某","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","销售员***"}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setPreferredWidth(100);
		
		panelClient.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,440);
		
		panelClient.add(button);
		panelClient.add(scroller);
	}

}

package initialui;
import javax.swing.*;

public class InitialClient {
	
	public JPanel panelClient=new JPanel();
	
	public InitialClient(){
		JButton button=new JButton("����");
		String[] heading={"���","�ͻ����","�ͻ�����","����","�绰","��ַ","�ʱ�","��������","Ӧ�ն��","Ӧ��","Ӧ��","Ĭ��ҵ��Ա"};
		String[][] data={{"01","������","1","��ĳ","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","����Ա***"},
				{"02","������","1","��ĳ","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","����Ա***"}};
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

package initialui;
import java.awt.*;
import javax.swing.*;

public class InitialClient {
	
	public JPanel panelClient=new JPanel();
	
	public InitialClient(){
		JButton button=new JButton("����");
		String[] heading={"���","�ͻ����","�ͻ�����","����","�绰","��ַ","�ʱ�","�����ʼ�","Ӧ�ն��","Ӧ��","Ӧ��","Ĭ��ҵ��Ա"};
		String[][] data={{"01","������","1","��ĳ","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","����Ա***"},
				{"02","������","1","��ĳ","13211112211","**********","091121","2132143242@163.com","30000.0","1000.0","1000.0","����Ա***"}};
		JTable table=new JTable(data,heading);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelClient.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelClient.add(button);
		panelClient.add(scroller);
	}

}

package initialui;
import javax.swing.*;

import java.awt.*;

public class InitialCommodity {
	
	public JPanel panelCommodity=new JPanel();
	
	public InitialCommodity(){
		JButton button=new JButton("����");
		String[] heading={"����","����","����","����","����","��Ʒ��","�ͺ�","����","�ۼ�","�������","����ۼ�"};
		String[][] data={{"***","***","***","***","***","�չ��","SR01","50.0","55.0",null,null},{"***","***","***","***","***","�չ��","DK01","46.0","50.5",null,null}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelCommodity.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelCommodity.add(button);
		panelCommodity.add(scroller);
	}
}

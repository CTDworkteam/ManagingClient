package initialui;
import javax.swing.*;

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

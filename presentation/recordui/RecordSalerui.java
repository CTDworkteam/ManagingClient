package recordui;
import javax.swing.*;

import java.awt.*;

public class RecordSalerui {
	
	public JPanel panel=new JPanel();
	
	public RecordSalerui(){
		String[] heading={"��½ʱ��","�����������ֹʱ��","��������","�˳���½ʱ��"};
		String[][] data={{"******","***********","**********","*****"}};
		JTable table=new JTable(data,heading);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panel.setLayout(null);
		scroller.setBounds(0,0,745,460);
		
		panel.add(scroller);
	}

}
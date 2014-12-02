package recordui;
import javax.swing.*;

import java.awt.*;

public class RecordStockerui {
	
	public JPanel panel=new JPanel();
	
	public RecordStockerui(){
		String[] heading={"登陆时间","操作项及操作起止时间","操作内容","退出登陆时间"};
		String[][] data={{"******","***********","**********","*****"}};
		JTable table=new JTable(data,heading);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panel.setLayout(null);
		scroller.setBounds(0,0,745,460);
		
		panel.add(scroller);
	}

}

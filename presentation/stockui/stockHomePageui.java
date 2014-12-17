package stockui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class stockHomePageui extends JPanel{
	String information="库存管理人员操作注意事项：";
	JTextArea stockInformation=new JTextArea(information);
	JScrollPane stockJscrollPane=new JScrollPane(stockInformation);
	
	stockHomePageui(){
		stockInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(stockJscrollPane,BorderLayout.CENTER);
	}
}

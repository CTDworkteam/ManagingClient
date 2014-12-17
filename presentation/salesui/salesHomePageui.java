package salesui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class salesHomePageui extends JPanel{
	String information="销售人员操作注意事项：";
	JTextArea salesInformation=new JTextArea(information);
	JScrollPane salesJscrollPane=new JScrollPane(salesInformation);
	
	salesHomePageui(){
		salesInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(salesJscrollPane,BorderLayout.CENTER);
	}
}

package salesui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class salesHomePageui extends JPanel{
	String information="������Ա����ע�����";
	JTextArea salesInformation=new JTextArea(information);
	JScrollPane salesJscrollPane=new JScrollPane(salesInformation);
	
	salesHomePageui(){
		salesInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(salesJscrollPane,BorderLayout.CENTER);
	}
}

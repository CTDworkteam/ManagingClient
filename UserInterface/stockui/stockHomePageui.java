package stockui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class stockHomePageui extends JPanel{
	String information="��������Ա����ע�����";
	JTextArea stockInformation=new JTextArea(information);
	JScrollPane stockJscrollPane=new JScrollPane(stockInformation);
	
	stockHomePageui(){
		stockInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(stockJscrollPane,BorderLayout.CENTER);
	}
}

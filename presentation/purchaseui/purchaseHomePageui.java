package purchaseui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class purchaseHomePageui extends JPanel{
	String information="������Ա����ע�����";
	JTextArea purchaseInformation=new JTextArea(information);
	JScrollPane purchaseJscrollPane=new JScrollPane(purchaseInformation);
	
	purchaseHomePageui(){
		purchaseInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(purchaseJscrollPane,BorderLayout.CENTER);
	}
}

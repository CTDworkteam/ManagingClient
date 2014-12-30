package purchaseui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class PurchaseHomePageui extends JPanel{
	String information="进货人员操作注意事项：";
	JTextArea purchaseInformation=new JTextArea(information);
	JScrollPane purchaseJscrollPane=new JScrollPane(purchaseInformation);
	
	PurchaseHomePageui(){
		purchaseInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(purchaseJscrollPane,BorderLayout.CENTER);
	}
}

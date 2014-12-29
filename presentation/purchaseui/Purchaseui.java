package purchaseui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class Purchaseui extends JFrame{
	private JTabbedPane purchaseGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("������Ŷ�Ǻ�");
	private JLabel UserPosition=new JLabel("ְλ������Ա");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("�˳�");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private PurchaseHomePageui homePage=new PurchaseHomePageui();
	private PurchaseCustomerManagementui customerManagement=new PurchaseCustomerManagementui();
	private PurchaseImportPanelui importPanel=new PurchaseImportPanelui();
	
	public void go(){
		purchaseGuide.setTabPlacement(JTabbedPane.LEFT);
		purchaseGuide.addTab("��ҳ", homePage);
		purchaseGuide.addTab("�ͻ�����",customerManagement);
		purchaseGuide.addTab("��������", importPanel);
		purchaseGuide.setSelectedIndex(0);
		textPanel.add(purchaseGuide);
		topInfoPanel.add(UserName);
		topInfoPanel.add(UserPosition);
		topTotalPanel.add(topInfoPanel,BorderLayout.WEST);
		topTotalPanel.add(jbtExit,BorderLayout.EAST);
		framePanel.add(topTotalPanel,BorderLayout.NORTH);
		framePanel.add(textPanel,BorderLayout.CENTER);
		add(framePanel);
	}
	public static void main(String[] args){
		Purchaseui frame=new Purchaseui();
		frame.pack();
		frame.setTitle("����Ա");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}


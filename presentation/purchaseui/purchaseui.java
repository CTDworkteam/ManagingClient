package purchaseui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class purchaseui extends JFrame{
	private JTabbedPane purchaseGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("姓名：哦呵呵");
	private JLabel UserPosition=new JLabel("职位：进货员");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("退出");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private purchaseHomePageui homePage=new purchaseHomePageui();
	private purchaseCustomerManagementui customerManagement=new purchaseCustomerManagementui();
	private purchaseImportPanelui importPanel=new purchaseImportPanelui();
	
	public void go(){
		purchaseGuide.setTabPlacement(JTabbedPane.LEFT);
		purchaseGuide.addTab("首页", homePage);
		purchaseGuide.addTab("客户管理",customerManagement);
		purchaseGuide.addTab("进货管理", importPanel);
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
		purchaseui frame=new purchaseui();
		frame.pack();
		frame.setTitle("进货员");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}


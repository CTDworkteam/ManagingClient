package salesui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class salesui extends JFrame{
	private JTabbedPane salesGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("������Ŷ�Ǻ�");
	private JLabel UserPosition=new JLabel("ְλ������Ա");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("�˳�");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private salesHomePageui homePage=new salesHomePageui();
	private salesCustomerManagementui customerManagement=new salesCustomerManagementui();
	private salesImportPanelui importPanel=new salesImportPanelui();
		
	public void go(String operator){
		salesGuide.setTabPlacement(JTabbedPane.LEFT);
		salesGuide.addTab("��ҳ", homePage);
		salesGuide.addTab("�ͻ�����",customerManagement);
		salesGuide.addTab("���۹���",importPanel);
		salesGuide.setSelectedIndex(0);
		textPanel.add(salesGuide);
		topInfoPanel.add(UserName);
		topInfoPanel.add(UserPosition);
		topTotalPanel.add(topInfoPanel,BorderLayout.WEST);
		topTotalPanel.add(jbtExit,BorderLayout.EAST);
		framePanel.add(topTotalPanel,BorderLayout.NORTH);
		framePanel.add(textPanel,BorderLayout.CENTER);
		add(framePanel);
	}
	public static void main(String[] args){
		salesui frame=new salesui();
		frame.pack();
		frame.setTitle("����Ա");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}

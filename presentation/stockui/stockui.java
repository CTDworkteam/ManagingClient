package stockui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class stockui extends JFrame{
	private JTabbedPane stockGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("����: �ό�");
	private JLabel UserPosition=new JLabel("ְλ:  ������Ա");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("�˳�");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private stockHomePageui homePage=new stockHomePageui();
	private stockTypeui type=new stockTypeui();
	private stockGoodsui goods=new stockGoodsui();
	private stockManagementui management=new stockManagementui();
	
	public void go(String operator){
		stockGuide.setTabPlacement(JTabbedPane.LEFT);
		stockGuide.addTab("��ҳ", homePage);
		stockGuide.addTab("��Ʒ�������", type);
		stockGuide.addTab("��Ʒ��Ϣ����", goods);
		stockGuide.addTab("������", management);
		stockGuide.setSelectedIndex(0);
		textPanel.add(stockGuide);
		topInfoPanel.add(UserName);
		topInfoPanel.add(UserPosition);
		topTotalPanel.add(topInfoPanel,BorderLayout.WEST);
		topTotalPanel.add(jbtExit,BorderLayout.EAST);
		framePanel.add(topTotalPanel,BorderLayout.NORTH);
		framePanel.add(textPanel,BorderLayout.CENTER);
		add(framePanel);
		
	
		stockui frame=new stockui();
		frame.pack();
		frame.setTitle("������Ա");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}
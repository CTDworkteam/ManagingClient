package initialui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import initialbl.Initial;
import vo.*;

public class InitialLook {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JTabbedPane tab=new JTabbedPane();
	
	public void go(String id){
		
		Initial initial=new Initial();
		InitialVO vo=initial.getInitialInfo(id);
		
		frame.setTitle("新建期初信息");
		
		LookAccount account=new LookAccount(vo.getAccount());
		LookClient client=new LookClient(vo.getClientList());
		LookCommodity commodity=new LookCommodity(vo.getCommodityList());
		LookCommodityType commodityType=new LookCommodityType(vo.getCommodityTypeList());
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JButton buttonCancel=new JButton("取消");
		buttonCancel.addActionListener(new cancelListener());
		
		tab.add("账户信息",account.panelAccount);
		tab.add("客户信息",client.panelClient);
		tab.add("商品分类信息",commodityType.panelCommodityType);
		tab.add("商品信息",commodity.panelCommodity);
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		buttonCancel.setBounds(600,10,65,25);
		tab.setBounds(30,50,820,500);
		
		tab.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int selectedIndex=tab.getSelectedIndex();
				tab.getToolTipTextAt(selectedIndex);
			}
		});
		
		panel.add(buttonCancel);
		panel.add(tab);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
}

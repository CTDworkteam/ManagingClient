package managerui;
import javax.swing.*;
import javax.swing.event.*;
import billui.Billui;
import strategyui.Strategyui;
import financecheckui.Financecheckui;
import recordui.Recordui;
import java.awt.event.*;

public class Managerui implements ChangeListener,ActionListener{
	
	JFrame frame;
	JPanel panel;
	JTabbedPane tab;
	
	Billui bill=new Billui();
	Strategyui strategy=new Strategyui();
	Financecheckui financecheck=new Financecheckui();
	Recordui record=new Recordui();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("总经理");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JPanel panelFace=new JPanel();
		tab=new JTabbedPane();
		JLabel labelName=new JLabel("姓名");
		JLabel labelWork=new JLabel("职务 总经理");
		JButton button=new JButton("退出");
		button.addActionListener(this);
		
		JTextArea text=new JTextArea();
		JScrollPane scroller=new JScrollPane(text);
		text.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.setSize(wide/2+100, high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		panelFace.setLayout(null);
		panelFace.add(scroller);
		tab.setBounds(50,50,wide/2-30,high/2+50);
		labelName.setBounds(50,5,100,30);
		labelWork.setBounds(120,5,200,30);
		scroller.setBounds(0,0,wide/2-350,high-430);
		button.setBounds(800,10,65,25);
		
		panelFace.add(scroller);
		tab.add("首页",panelFace);
		tab.add("审批单据",bill.panelBill);
		tab.add("制定促销策略",strategy.panelStrategy);
		tab.add("查看财务报表",financecheck.panelFinancecheck);
		tab.add("查看系统操作日志记录",record.panelRecord);
		panel.add(tab);
		panel.add(labelName);
		panel.add(labelWork);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	
	tab.addChangeListener(new ChangeListener(){
		public void stateChanged(ChangeEvent e){
			int selectedIndex=tab.getSelectedIndex();
			tab.getToolTipTextAt(selectedIndex);
		}
	});
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent event){
		frame.dispose();
	}

}

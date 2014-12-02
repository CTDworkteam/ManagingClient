package financemanagerui;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import financeui.Financeui;
import initialui.Initialui;
import accountui.Accountui;
import financecheckui.Financecheckui;
import recordui.Recordui;


public class Financemanagerui implements ChangeListener,ActionListener{
	
	JFrame frame;
	JPanel panel;
	JTabbedPane tab;
	
	Accountui account=new Accountui();
	Financeui finance=new Financeui();
	Initialui initial=new Initialui();
	Financecheckui financecheck=new Financecheckui();
	Recordui record=new Recordui();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("财务人员");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JPanel panelFace=new JPanel();
		tab=new JTabbedPane();
		JLabel labelName=new JLabel("姓名");
		JLabel labelWork=new JLabel("职务 财务人员");
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
		tab.setBounds(50,50,wide/2-50,high/2+50);
		labelName.setBounds(50,5,100,30);
		labelWork.setBounds(120,5,200,30);
		scroller.setBounds(0,0,wide/2-350,high-430);
		button.setBounds(800,10,65,25);
		
		panelFace.add(scroller);
		tab.add("首页",panelFace);
		tab.add("账户管理",account.panelAccount);
		tab.add("财务管理",finance.panelFinance);
		tab.add("期初建账",initial.panelInitial);
		tab.add("查看财务报表",financecheck.panelFinancecheck);
		tab.add("查询系统操作日志记录",record.panelRecord);
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
	
	public void actionPerformed(ActionEvent e){
		frame.dispose();
	}
	
}

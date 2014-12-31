package financemanagerui;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import financeui.Financeui;
import initialui.Initialui;
import accountui.Accountui;
import financecheckui.Financecheckui;
import recordui.Recordui;
import enumType.UserJob;

/*
 * ������Ա��������
 */
public class Financemanagerui implements ChangeListener,ActionListener{
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JTabbedPane tab=new JTabbedPane();
	
	Accountui account=new Accountui();
	Financeui finance=new Financeui();
	Initialui initial=new Initialui();
	Financecheckui financecheck=new Financecheckui(UserJob.FinanceManager);
	Recordui record=new Recordui();
	
	public void go(String name){
		
		frame.setTitle("������Ա");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelFace=new JPanel();
		JLabel labelName=new JLabel("���� "+name);
		JLabel labelWork=new JLabel("ְ�� ������Ա");
		JButton button=new JButton("�˳�");
		button.addActionListener(this);
		
		JTextArea text=new JTextArea();
		JScrollPane scroller=new JScrollPane(text);
		text.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.setSize(900, 650);
		frame.setLocation(400,150);
		
		panel.setLayout(null);
		panelFace.setLayout(null);
		panelFace.add(scroller);
		tab.setBounds(50,50,750,500);
		labelName.setBounds(50,5,100,30);
		labelWork.setBounds(120,5,200,30);
		scroller.setBounds(0,0,450,470);
		button.setBounds(800,10,65,25);
		
		panelFace.add(scroller);
		tab.add("��ҳ",panelFace);
		tab.add("�˻�����",account.panelAccount);
		tab.add("�������",finance.panelFinance);
		tab.add("�ڳ�����",initial.panelInitial);
		tab.add("�鿴���񱨱�",financecheck.panelFinancecheck);
		tab.add("��ѯϵͳ������־��¼",record.panelRecord);
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

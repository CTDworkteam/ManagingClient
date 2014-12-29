package financecheckui;
import javax.swing.*;
import javax.swing.event.*;
import enumType.UserJob;

public class Financecheckui {
	
	public JPanel panelFinancecheck=new JPanel();
	JTabbedPane tab;
	
	public Financecheckui(UserJob job){
		
		DetailListCheck detailList=new DetailListCheck();
		ProcessListCheck processList=new ProcessListCheck(job);
		ConditionListCheck conditionList=new ConditionListCheck();
		
		tab=new JTabbedPane(JTabbedPane.LEFT);
		tab.add("������ϸ��",detailList.panel);
		tab.add("��Ӫ���̱�",processList.panel);
		tab.add("��Ӫ�����",conditionList.panel);
		tab.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int selectedIndex=tab.getSelectedIndex();
				tab.getToolTipTextAt(selectedIndex);
			}
		});
		
		panelFinancecheck.setLayout(null);
		tab.setBounds(0,0,765,470);
		
		panelFinancecheck.add(tab);
	}

}

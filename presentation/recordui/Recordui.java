package recordui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * ��ѯϵͳ������־��¼����
 */
public class Recordui {
	
	public JPanel panelRecord=new JPanel();
	JTabbedPane tab;
	
	RecordComdifyui comdify=new RecordComdifyui();
	RecordBillui bill=new RecordBillui();
	
	public Recordui(){
		
		tab=new JTabbedPane();
		tab.add("�����޸Ĳ�����־",comdify.panel);
		tab.add("�����ƶ�������־",bill.panel);
		panelRecord.setLayout(null);
		tab.setBounds(0,0,765,470);
		panelRecord.add(tab);
		tab.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int selectedIndex=tab.getSelectedIndex();
				tab.getToolTipTextAt(selectedIndex);
			}
		});
	}

}

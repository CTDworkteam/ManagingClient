package recordui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * ������־��¼����
 */
public class Recordui {
	
	public JPanel panelRecord=new JPanel();
	JTabbedPane tab;
	
	RecordBillui bill=new RecordBillui();
	RecordComdifyui comdify=new RecordComdifyui();
	
	public Recordui(){
		tab=new JTabbedPane();
		tab.add("�����޸�",bill.panel);
		tab.add("�����ƶ�",comdify.panel);
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

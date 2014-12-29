package recordui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 操作日志记录界面
 */
public class Recordui {
	
	public JPanel panelRecord=new JPanel();
	JTabbedPane tab;
	
	RecordBillui bill=new RecordBillui();
	RecordComdifyui comdify=new RecordComdifyui();
	
	public Recordui(){
		tab=new JTabbedPane();
		tab.add("数据修改",bill.panel);
		tab.add("单据制定",comdify.panel);
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

package recordui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 查询系统操作日志记录界面
 */
public class Recordui {
	
	public JPanel panelRecord=new JPanel();
	JTabbedPane tab;
	
	RecordComdifyui comdify=new RecordComdifyui();
	RecordBillui bill=new RecordBillui();
	
	public Recordui(){
		
		tab=new JTabbedPane();
		tab.add("数据修改操作日志",comdify.panel);
		tab.add("单据制定操作日志",bill.panel);
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

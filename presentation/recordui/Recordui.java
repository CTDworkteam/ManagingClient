package recordui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Recordui {
	
	public JPanel panelRecord=new JPanel();
	JTabbedPane tab;
	
	RecordFinancerui finance=new RecordFinancerui();
	RecordBuyerui buy=new RecordBuyerui();
	RecordStockerui stock=new RecordStockerui();
	RecordSalerui sale=new RecordSalerui();
	RecordManagerui manager=new RecordManagerui();
	
	public Recordui(){
		tab=new JTabbedPane();
		tab.add("财务人员",finance.panel);
		tab.add("进货人员",buy.panel);
		tab.add("库存管理人员",stock.panel);
		tab.add("销售人员",sale.panel);
		tab.add("总经理",manager.panel);
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

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
		tab.add("������Ա",finance.panel);
		tab.add("������Ա",buy.panel);
		tab.add("��������Ա",stock.panel);
		tab.add("������Ա",sale.panel);
		tab.add("�ܾ���",manager.panel);
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

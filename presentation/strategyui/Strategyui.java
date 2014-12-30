package strategyui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*
 * �ƶ��������Խ���
 */
public class Strategyui {
	
	public JPanel panelStrategy=new JPanel();
	JTabbedPane tabMessage=new JTabbedPane();
	JTabbedPane tabNew=new JTabbedPane();
	
	StrategyClientui client=new StrategyClientui();
	StrategyPackui pack=new StrategyPackui();
	StrategyPriceui price=new StrategyPriceui();
	MessageStock stock=new MessageStock();
	MessageStrategy strategy=new MessageStrategy();

	public Strategyui(){
		tabMessage.addChangeListener(new messageChangeListener());
		tabMessage.add("�����Ϣ",stock.panel);
		tabMessage.add("��������",strategy.panel);
		tabNew.addChangeListener(new newChangeListener());
		tabNew.add("��ͬ�ͻ�",client.panel);
		tabNew.add("�ؼ۰�",pack.panel);
		tabNew.add("��ͬ�ܼ�",price.panel);
		JButton buttonCancel=new JButton("ȡ��");
		JButton buttonConfirm=new JButton("ȷ��");
		String[] heading={"�ͻ�����","�ܼ�","�ؼ۰�","��Ʒ","����","����ȯ","���۱���"};
		String[][] data={};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.setSize(new Dimension(460,60));
		
		panelStrategy.setLayout(null);
		tabMessage.setBounds(3,0,410,470);
		tabNew.setBounds(430,0,320,230);
		scroller.setBounds(430,240,320,190);
		buttonCancel.setBounds(450,440,65,25);
		buttonConfirm.setBounds(620,440,65,25);
		
		panelStrategy.add(tabMessage);
		panelStrategy.add(tabNew);
		panelStrategy.add(scroller);
		panelStrategy.add(buttonCancel);
		panelStrategy.add(buttonConfirm);
	}
	
	class messageChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e){
			int selectedIndex=tabMessage.getSelectedIndex();
			tabMessage.getToolTipTextAt(selectedIndex);
		}
	}
	
	class newChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e){
			int selectedIndex=tabNew.getSelectedIndex();
			tabNew.getToolTipTextAt(selectedIndex);
		}
	}
	
}

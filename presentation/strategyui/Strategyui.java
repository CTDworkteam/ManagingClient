package strategyui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		
		panelStrategy.setLayout(null);
		tabMessage.setBounds(3,0,410,450);
		tabNew.setBounds(430,0,320,450);
		
		panelStrategy.add(tabMessage);
		panelStrategy.add(tabNew);
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

package strategyui;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 制定促销策略界面
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
		tabMessage.add("库存信息",stock.panel);
		tabMessage.add("促销策略",strategy.panel);
		tabNew.addChangeListener(new newChangeListener());
		tabNew.add("不同客户",client.panel);
		tabNew.add("特价包",pack.panel);
		tabNew.add("不同总价",price.panel);
		
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

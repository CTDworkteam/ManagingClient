package financeui;
import javax.swing.*;
import javax.swing.event.*;
import expenseui.Expenseui;

/*
 * ����������
 */
public class Financeui implements ChangeListener{
	
	public JPanel panelFinance=new JPanel();
	JTabbedPane tab=new JTabbedPane(JTabbedPane.LEFT);
	
	Reciptui recipt=new Reciptui();
	Paymentui payment=new Paymentui();
	Expenseui expense=new Expenseui();
	
	public Financeui(){
		tab.add("�տ",recipt.panel);
		tab.add("���",payment.panel);
		tab.add("�ֽ���õ�",expense.panel);
		tab.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				int selectedIndex=tab.getSelectedIndex();
				tab.getToolTipTextAt(selectedIndex);
			}
		});
		panelFinance.setLayout(null);
		tab.setBounds(0,20,745,430);
		panelFinance.add(tab);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
}

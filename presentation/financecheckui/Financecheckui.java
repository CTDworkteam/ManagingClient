package financecheckui;
import javax.swing.*;

public class Financecheckui {
	
	public JPanel panelFinancecheck=new JPanel();
	
	public Financecheckui(){
		JButton buttonSaleslist=new JButton("销售明细表");
		JButton buttonBusinessprocess=new JButton("经营历程表");
		JButton buttonBusinessstatus=new JButton("经营情况表");
		
		panelFinancecheck.setLayout(null);
		buttonSaleslist.setBounds(100,200,100,25);
		buttonBusinessprocess.setBounds(290,200,100,25);
		buttonBusinessstatus.setBounds(480,200,100,25);
		
		panelFinancecheck.add(buttonSaleslist);
		panelFinancecheck.add(buttonBusinessprocess);
		panelFinancecheck.add(buttonBusinessstatus);
	}

}

package financecheckui;
import javax.swing.*;

public class Financecheckui {
	
	public JPanel panelFinancecheck=new JPanel();
	
	public Financecheckui(){
		JButton buttonSaleslist=new JButton("������ϸ��");
		JButton buttonBusinessprocess=new JButton("��Ӫ���̱�");
		JButton buttonBusinessstatus=new JButton("��Ӫ�����");
		
		panelFinancecheck.setLayout(null);
		buttonSaleslist.setBounds(100,200,100,25);
		buttonBusinessprocess.setBounds(290,200,100,25);
		buttonBusinessstatus.setBounds(480,200,100,25);
		
		panelFinancecheck.add(buttonSaleslist);
		panelFinancecheck.add(buttonBusinessprocess);
		panelFinancecheck.add(buttonBusinessstatus);
	}

}

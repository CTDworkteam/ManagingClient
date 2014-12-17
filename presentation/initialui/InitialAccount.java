package initialui;
import java.awt.Dimension;

import javax.swing.*;

public class InitialAccount {
	
	public JPanel panelAccount=new JPanel();
	
	public InitialAccount(){
		JButton button=new JButton("导入");
		String[] heading={"账户名","账户余额"};
		String[][] data={{"account1","1000,0"},{"account2","2103.0"},{"account3","120193.0"},{"account4","167982.0"},{"account5","2200.0"}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelAccount.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelAccount.add(button);
		panelAccount.add(scroller);
	}

}

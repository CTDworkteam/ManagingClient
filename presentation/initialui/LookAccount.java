package initialui;
import java.util.*;
import java.awt.Dimension;
import javax.swing.*;
import vo.*;

public class LookAccount {

    public JPanel panelAccount=new JPanel();
	
	String[] heading={"’Àªß√˚","’Àªß”‡∂Ó"};
	String[][] data=new String[100][2];
	JTable table=new JTable(data,heading);
	
	public LookAccount(ArrayList<AccountVO> account){
		
		for(int t=0;t<account.size();t++){
			data[t][0]=account.get(t).getName();
			data[t][1]=Double.toString(account.get(t).getMoney());
		}
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelAccount.setLayout(null);
		scroller.setBounds(0,35,820,500);
		
		panelAccount.add(scroller);
	}
	
}

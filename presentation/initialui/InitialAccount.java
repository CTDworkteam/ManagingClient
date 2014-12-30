package initialui;
import java.util.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import initialbl.Initial;
import enumType.ResultMessage;
import confirmui.*;
import accountbl.AccountController;
import vo.*;

public class InitialAccount {
	
	public JPanel panelAccount=new JPanel();
	
	String[] heading={"账户名","账户余额"};
	String[][] data=new String[100][2];
	JTable table=new JTable(data,heading);
	
	public InitialAccount(){
		JButton button=new JButton("导入");
		
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
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Initial initial=new Initial();
			AccountController controller=new AccountController();
			ArrayList<AccountVO> account=controller.getList();
			ResultMessage result=initial.addAccount(account);
			if(result==ResultMessage.Failure){
				
			}
		}
	}

}

package initialui;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import initialbl.Initial;
import clientbl.ClientController;
import vo.*;
import enumType.ResultMessage;
import enumType.ClientType;
import confirmui.*;

public class InitialClient {
	
	public JPanel panelClient=new JPanel();
	
	String[] heading={"编号","客户类别","客户级别","姓名","电话","地址","邮编","电子邮件","应收额度","应收","应付","默认业务员"};
	String[][] data=new String[100][12];
	JTable table=new JTable(data,heading);
	
	public InitialClient(){
		JButton button=new JButton("导入");
		
		button.addActionListener(new buttonListener());
		
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelClient.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelClient.add(button);
		panelClient.add(scroller);
	}

	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Initial initial=new Initial();
			ClientController controller=new ClientController();
			ArrayList<ClientVO> client=controller.getList();
			ResultMessage result=initial.addClient(client);
			ClientType theType;
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("导入失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				for(int t=0;t<client.size();t++){
					data[t][0]=Long.toString(client.get(t).getId());
					String type="";
					theType=client.get(t).getType();
					if(theType==ClientType.Seller){
						type="销售商";
					}else{
						type="供应商";
					}
					data[t][1]=type;
					data[t][2]=Integer.toString(client.get(t).getRank());
					data[t][3]=client.get(t).getName();
					data[t][4]=client.get(t).getTelephone();
					data[t][5]=client.get(t).getAddress();
					data[t][6]=client.get(t).getPostcode();
					data[t][7]=client.get(t).getEmail();
					data[t][8]=Double.toString(client.get(t).getAmountReserved());
					data[t][9]=Double.toString(client.get(t).getMoneyReserved());
					data[t][10]=Double.toString(client.get(t).getMoneyToPay());
					data[t][11]=client.get(t).getCourterman();
				}
			}
		}
	}
}

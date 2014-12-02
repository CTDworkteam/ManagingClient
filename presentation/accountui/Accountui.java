package accountui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Accountui {
	
	public JPanel panelAccount=new JPanel();
	JTextField fieldNum;
	JTable table;
	AccountAddui add=new AccountAddui();
	AccountLookui look=new AccountLookui();
	AccountModifyui modify=new AccountModifyui();
	AccountDeleteui delete=new AccountDeleteui();
	
	public Accountui(){
		String[] heading={"序号","银行账户名"};
		String[][] data={{"1","account1"},{"2","account2"}};
		table=new JTable(data,heading);
		JLabel labelNumber=new JLabel("共有            个账户");
		fieldNum=new JTextField();
		setNum();
		JLabel labelName=new JLabel("银行帐户名");
		JTextField fieldName=new JTextField();//银行帐户名输入
		JButton buttonAdd=new JButton("增加");//增加账户操作
		buttonAdd.addActionListener(new addListener());
		JButton buttonLook=new JButton("查看");//查看账户属性操作按钮
		buttonLook.addActionListener(new lookListener());
		JButton buttonModify=new JButton("修改");//修改账户属性操作按钮
		buttonModify.addActionListener(new modifyListener());
		JButton buttonDelete=new JButton("删除");//删除账户操作
		buttonDelete.addActionListener(new deleteListener());
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(true);
		
		panelAccount.setLayout(null);
		scroller.setBounds(70,10,250,450);
		labelNumber.setBounds(350,33,130,25);
		fieldNum.setBounds(380,33,30,25);
		buttonAdd.setBounds(600,33,65,25);
	    labelName.setBounds(350,180,90,25);
	    fieldName.setBounds(400,207,150,25);
	    buttonLook.setBounds(600,150,65,25);
	    buttonModify.setBounds(600,200,65,25);
	    buttonDelete.setBounds(600,250,65,25);
	    
	    panelAccount.add(scroller);
	    panelAccount.add(labelNumber);
	    panelAccount.add(fieldNum);
	    panelAccount.add(labelName);
	    panelAccount.add(fieldName);
	    panelAccount.add(buttonAdd);
	    panelAccount.add(buttonLook);
	    panelAccount.add(buttonModify);
	    panelAccount.add(buttonDelete);
	}
	
	private void setNum(){
		int n=table.getRowCount();
		fieldNum.setText(Integer.toString(n));
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			add.go();
		}
	}
	
	class lookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			look.go();
		}
	}
	
	class modifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			modify.go();
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			delete.go();
		}
	}
}

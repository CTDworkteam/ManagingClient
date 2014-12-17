package accountui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import vo.AccountVO;
import accountbl.AccountController;

/*
 * 财务管理panel
 */
public class Accountui {
	
	public JPanel panelAccount=new JPanel();
	JTextField fieldNum;
	JTable table;
	JTextField fieldName;
	
	AccountController controller=new AccountController();
	
	public Accountui(){
		
		JButton button=new JButton("刷新");//刷新账户列表按钮
		button.addActionListener(new buttonListener());
		String[] heading={"序号","银行账户名"};
		String[][] data={{"1","account1"},{"2","account2"}};
		table=new JTable(data,heading);
		table.addMouseListener(new tableListener());
		JLabel labelNumber=new JLabel("共有            个账户");
		fieldNum=new JTextField();
		setNum();
		JLabel labelName=new JLabel("银行帐户名");
		fieldName=new JTextField();//银行帐户名输入
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
		button.setBounds(70,10,65,25);
		scroller.setBounds(70,50,250,440);
		labelNumber.setBounds(350,33,130,25);
		fieldNum.setBounds(380,33,30,25);
		buttonAdd.setBounds(600,33,65,25);
	    labelName.setBounds(350,180,90,25);
	    fieldName.setBounds(400,207,150,25);
	    buttonLook.setBounds(600,150,65,25);
	    buttonModify.setBounds(600,200,65,25);
	    buttonDelete.setBounds(600,250,65,25);
	    
	    panelAccount.add(button);
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
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class tableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Object aim=e.getSource();
			JTable tableTwo=(JTable)aim;
			String result=(String) tableTwo.getValueAt(tableTwo.getSelectedRow(), tableTwo.getSelectedColumn());
			fieldName.setText(result);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AccountAddui add=new AccountAddui();
			add.go();
		}
	}
	
	class lookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AccountLookui look=new AccountLookui();
			AccountVO theAccount=new AccountVO();
			theAccount=controller.find(fieldName.getText());
			look.go(theAccount);
		}
	}
	
	class modifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AccountModifyui modify=new AccountModifyui();
			AccountVO theAccount=new AccountVO();
			theAccount=controller.find(fieldName.getText());
			modify.go(theAccount);
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			AccountDeleteui delete=new AccountDeleteui();
			AccountVO theAccount=new AccountVO();
			theAccount=controller.find(fieldName.getText());
			delete.go(theAccount);
		}
	}

}

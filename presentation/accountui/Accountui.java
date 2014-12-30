package accountui;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

import accountbl.AccountController;
import vo.*;
import confirmui.*;

/*
 * �˻��������
 */
public class Accountui {
	
	public JPanel panelAccount=new JPanel();
	JTextField fieldNum=new JTextField();
	JTextField fieldName=new JTextField();
	String[] heading={"���","�����˻���"};
	String[][] data=new String[100][2];
	JTable table=new JTable(data,heading);
	
	AccountVO vo=new AccountVO();
	
	AccountAddui add=new AccountAddui();
	AccountLookui look=new AccountLookui();
	AccountModifyui modify=new AccountModifyui();
	AccountDeleteui delete=new AccountDeleteui();
	
	AccountController controller=new AccountController();
	
	public Accountui(){
		
		JButton button=new JButton("");
		button.addActionListener(new newListener());
		
		ArrayList<AccountVO> accounts=new ArrayList<AccountVO>();
		accounts=controller.getList();
		int size=accounts.size();
		for(int i=0;i<size;i++){
			data[i][0]=Long.toString(accounts.get(i).getId());
			data[i][1]=accounts.get(i).getName();
		}
		JLabel labelNumber=new JLabel("����            ���˻�");
		setNum();
		JLabel labelName=new JLabel("�����ʻ���");
		JButton buttonAdd=new JButton("����");//�����˻�����
		buttonAdd.addActionListener(new addListener());
		JButton buttonLook=new JButton("�鿴");//�鿴�˻����Բ�����ť
		buttonLook.addActionListener(new lookListener());
		JButton buttonModify=new JButton("�޸�");//�޸��˻����Բ�����ť
		buttonModify.addActionListener(new modifyListener());
		JButton buttonDelete=new JButton("ɾ��");//ɾ���˻�����
		buttonDelete.addActionListener(new deleteListener());
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(true);
		
		panelAccount.setLayout(null);
		button.setBounds(70,10,65,25);
		scroller.setBounds(70,50,250,410);
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
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<AccountVO> accounts=new ArrayList<AccountVO>();
			accounts=controller.getList();
			int size=accounts.size();
			for(int i=0;i<size;i++){
				data[i][0]=Long.toString(accounts.get(i).getId());
				data[i][1]=accounts.get(i).getName();
			}
		}
	}
	
	class textListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String name=(String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
			fieldName.setText(name);
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
			add.go();
		}
	}
	
	class lookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vo=controller.find(fieldName.getText());
			if(vo==null){
				Runnable r=new Confirmui();
				Thread t=new Thread(r);
				t.start();
			}else{
				look.go(vo);
			}
		}
	}
	
	class modifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vo=controller.find(fieldName.getText());
			if(vo==null){
				Runnable r=new Confirmui();
				Thread t=new Thread(r);
				t.start();
			}else{
				modify.go(vo);
			}
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			vo=controller.find(fieldName.getText());
			if(vo==null){
				Runnable r=new Confirmui();
				Thread t=new Thread(r);
				t.start();
			}else{
				delete.go(vo);
			}
		}
	}
}

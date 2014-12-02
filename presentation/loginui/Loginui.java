package loginui;
import javax.swing.*;
import java.awt.event.*;
import financemanagerui.Financemanagerui;
import managerui.Managerui;

public class Loginui {
	
	JFrame frame;
	JPanel panel;
	JComboBox<String> box;
	
	Financemanagerui finance=new Financemanagerui();
	Managerui manager=new Managerui();
	Registerui register=new Registerui();
	FindPasswordui find=new FindPasswordui();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("欢迎登陆进销存系统");
		
		JLabel labelWork=new JLabel("职务",JLabel.RIGHT);
		box=new JComboBox<String>();
		box.setEditable(true);
		box.addItem("财务人员");
		box.addItem("进货人员");
		box.addItem("库存管理员");
		box.addItem("销售人员");
		box.addItem("总经理");
		JLabel labelName=new JLabel("用户名",JLabel.RIGHT);
		JLabel labelPassword=new JLabel("密码",JLabel.RIGHT);
		JTextField fieldName=new JTextField();
		JTextField fieldPassword=new JTextField();
		JButton buttonSure=new JButton("登陆");
		buttonSure.addActionListener(new loginListener());
		JButton buttonRegister=new JButton("注册");
		buttonRegister.addActionListener(new registerListener());
		JButton buttonFind=new JButton("忘记密码");
		buttonFind.addActionListener(new findListener());
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		labelWork.setBounds(300,220,50,25);
		box.setBounds(360,220,150,25);
		labelName.setBounds(300,270,50,25);
		fieldName.setBounds(360,270,150,25);
		labelPassword.setBounds(300,320,50,25);
		fieldPassword.setBounds(360,320,150,25);
		buttonSure.setBounds(400,370,65,25);
		buttonRegister.setBounds(550,270,90,25);
		buttonFind.setBounds(550,320,90,25);
		
		panel.add(labelWork);
		panel.add(box);
		panel.add(labelName);
		panel.add(labelPassword);
		panel.add(fieldPassword);
		panel.add(fieldName);
		panel.add(buttonFind);
		panel.add(buttonRegister);
		panel.add(buttonSure);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class loginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String work=(String) box.getSelectedItem();
			if(work=="财务人员"){
				finance.go();
			}
			if(work=="进货人员"){
				
			}
			if(work=="库存管理员"){
				
			}
			if(work=="销售人员"){
				
			}
			if(work=="总经理"){
				manager.go();
			}
			frame.dispose();
		}
	}
	
	class registerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			register.go();
		}
	}
	
	class findListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			find.go();
		}
	}
	
	public static void main(String args[]){
		Loginui l=new Loginui();
		l.go();
	}
}

package loginui;
import javax.swing.*;
import java.awt.event.*;
import mainui.Mainui;
import loginbl.Login;
import userbl.UserController;
import vo.*;
import enumType.ResultMessage;
import confirmui.*;

public class Loginui {
	
	JFrame frame;
	JPanel panel;
	JTextField fieldID;
	JPasswordField fieldPassword;
	
	Registerui register=new Registerui();
	FindPasswordui find=new FindPasswordui();
	
	Mainui mainui=new Mainui();
	
	Login login=new Login();
	UserController userController=new UserController();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("��ӭ��½������ϵͳ");
		
		JLabel labelWork=new JLabel("ְ��",JLabel.RIGHT);
		JLabel labelName=new JLabel("�û���",JLabel.RIGHT);
		JLabel labelPassword=new JLabel("����",JLabel.RIGHT);
		fieldID=new JTextField();
		fieldPassword=new JPasswordField();
		JButton buttonSure=new JButton("��½");
		buttonSure.addActionListener(new loginListener());
		JButton buttonRegister=new JButton("ע��");
		buttonRegister.addActionListener(new registerListener());
		JButton buttonFind=new JButton("��������");
		buttonFind.addActionListener(new findListener());
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		
		panel.setLayout(null);
		labelWork.setBounds(300,220,50,25);
		labelName.setBounds(300,270,50,25);
		fieldID.setBounds(360,270,150,25);
		labelPassword.setBounds(300,320,50,25);
		fieldPassword.setBounds(360,320,150,25);
		buttonSure.setBounds(400,370,65,25);
		buttonRegister.setBounds(550,270,90,25);
		buttonFind.setBounds(550,320,90,25);
		
		panel.add(labelWork);
		panel.add(labelName);
		panel.add(labelPassword);
		panel.add(fieldPassword);
		panel.add(fieldID);
		panel.add(buttonFind);
		panel.add(buttonRegister);
		panel.add(buttonSure);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class loginListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			long id=Long.parseLong(fieldID.getText());
			String password=fieldPassword.getPassword().toString();
			ResultMessage result=login.verify(id, password);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("");
				Thread t=new Thread(r);
				t.start();
			}else{
				UserVO user=userController.findUser(id);
				mainui.go(user);
				frame.dispose();
			}
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

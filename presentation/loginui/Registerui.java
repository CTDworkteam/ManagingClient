package loginui;
import javax.swing.*;
import java.awt.event.*;
import enumType.UserJob;
import enumType.ResultMessage;
import loginbl.Login;
import confirmui.*;

/*
 * ����ע�����
 */
public class Registerui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JTextField fieldName;
	JComboBox<UserJob> boxWork;
	JPasswordField password;
	JPasswordField passwordConfirm;
	
	public void go(){
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("����ע��");
		
		JLabel labelName=new JLabel("����",JLabel.RIGHT);
		JLabel labelWork=new JLabel("ְ��",JLabel.RIGHT);
		JLabel labelPassword=new JLabel("����",JLabel.RIGHT);
		JLabel labelPasswAgain=new JLabel("ȷ������",JLabel.RIGHT);
		fieldName=new JTextField();
		boxWork=new JComboBox<UserJob>();
		password=new JPasswordField();
		passwordConfirm=new JPasswordField();
		JButton buttonSure=new JButton("ȷ��");
		JButton buttonCancel=new JButton("ȡ��");
		
		boxWork.addItem(UserJob.FinanceManager);
		boxWork.addItem(UserJob.PurchaseManager);
		boxWork.addItem(UserJob.StockManager);
		boxWork.addItem(UserJob.SalesManager);
		boxWork.addItem(UserJob.Manager);
		
		buttonSure.addActionListener(new sureListener());
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelName.setBounds(250,100,70,25);
		fieldName.setBounds(325,100,150,25);
		labelWork.setBounds(250,135,70,25);
		boxWork.setBounds(325,135,150,25);
		labelPassword.setBounds(250,170,70,25);
		password.setBounds(325,170,150,25);
		labelPasswAgain.setBounds(250,205,70,25);
		passwordConfirm.setBounds(325,205,150,25);
		buttonCancel.setBounds(330,245,65,25);
		buttonSure.setBounds(410,245,65,25);
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelWork);
		panel.add(boxWork);
		panel.add(password);
		panel.add(labelPassword);
		panel.add(labelPasswAgain);
		panel.add(passwordConfirm);
		panel.add(buttonSure);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class sureListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Login login=new Login();
			if(password.getPassword()!=passwordConfirm.getPassword()){
				Runnable r=new Confirmui("��ȷ����������");
				Thread t=new Thread(r);
				t.start();
			}else{
				ResultMessage result=login.register(fieldName.getText(), password.getPassword().toString(), (UserJob)boxWork.getSelectedItem());
				if(result==ResultMessage.Success){
					Runnable r=new Confirmui("ע���������ύ");
					Thread t=new Thread(r);
					t.start();
					frame.dispose();
				}else{
					Runnable r=new Confirmui("����ʧ��");
					Thread t=new Thread(r);
					t.start();
				}
			}
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}

}

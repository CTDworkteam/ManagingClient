package loginui;
import javax.swing.*;
import enumType.UserJob;
import java.awt.event.*;
import userbl.UserController;
import vo.*;
import confirmui.*;
import loginbl.Login;

/*
 * 查询密码界面
 */
public class FindPasswordui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JTextField fieldID=new JTextField();
	JTextField fieldName=new JTextField();
	JComboBox<UserJob> box=new JComboBox<UserJob>();
	JTextArea areaMessage=new JTextArea();//反馈信息
	
	UserController controller=new UserController();
	Login login=new Login();
	
	public void go(){
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("找回密码");
		
		JLabel labelID=new JLabel("用户名",JLabel.RIGHT);
		JLabel labelName=new JLabel("姓名",JLabel.RIGHT);
		JLabel labelWork=new JLabel("职务",JLabel.RIGHT);
		box.addItem(UserJob.FinanceManager);
		box.addItem(UserJob.PurchaseManager);
		box.addItem(UserJob.StockManager);
		box.addItem(UserJob.SalesManager);
		box.addItem(UserJob.Manager);
		areaMessage.setLineWrap(true);
		JButton buttonSearch=new JButton("找回");
		JButton buttonAgain=new JButton("重置");
		JButton buttonSure=new JButton("确认");
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelID.setBounds(150, 100, 50, 25);
		fieldID.setBounds(210,100,150,25);
		labelName.setBounds(150,135,50,25);
		fieldName.setBounds(210,135,150,25);
		labelWork.setBounds(150,170,50,25);
		box.setBounds(210,170,150,25);
		areaMessage.setBounds(450,100,200,70);
		buttonSearch.setBounds(210,210,65,25);
		buttonSearch.addActionListener(new searchListener());
		buttonAgain.setBounds(290,210,65,25);
		buttonAgain.addActionListener(new againListener());
		buttonSure.setBounds(520,200,65,25);
		buttonSure.addActionListener(new sureListener());
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelID);
		panel.add(fieldID);
		panel.add(labelWork);
		panel.add(box);
		panel.add(areaMessage);
		panel.add(buttonSure);
		panel.add(buttonAgain);
		panel.add(buttonSearch);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class searchListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			UserJob role=(UserJob) box.getSelectedItem();
			Long id=Long.parseLong(fieldID.getText());
			String name=fieldName.getName();
			UserVO user=controller.findUser(id);
			if(user.getName()!=name||user.getRole()!=role){
				Runnable r=new Confirmui("信息输入错误");
				Thread t=new Thread(r);
				t.start();
			}else{
				String result=login.getPassword(id, name, role);
				areaMessage.setText(result);
			}
		}
	}
	
	class againListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			fieldID.setText(null);
			fieldName.setText(null);
		}
	}
	
	class sureListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

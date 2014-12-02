package loginui;
import javax.swing.*;

public class Registerui {
	
	JFrame frame;
	JPanel panel;
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("申请注册");
		
		JLabel labelName=new JLabel("姓名",JLabel.RIGHT);
		JLabel labelWork=new JLabel("职务",JLabel.RIGHT);
		JLabel labelPassword=new JLabel("密码",JLabel.RIGHT);
		JLabel labelPasswAgain=new JLabel("确认密码",JLabel.RIGHT);
		JTextField fieldName=new JTextField();
		JTextField fieldWork=new JTextField();
		JTextField fieldPassword=new JTextField();
		JTextField fieldPasswAgain=new JTextField();
		JButton buttonSure=new JButton("确定");
		JButton buttonCancel=new JButton("取消");
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelName.setBounds(250,100,70,25);
		fieldName.setBounds(325,100,150,25);
		labelWork.setBounds(250,135,70,25);
		fieldWork.setBounds(325,135,150,25);
		labelPassword.setBounds(250,170,70,25);
		fieldPassword.setBounds(325,170,150,25);
		labelPasswAgain.setBounds(250,205,70,25);
		fieldPasswAgain.setBounds(325,205,150,25);
		buttonCancel.setBounds(330,245,65,25);
		buttonSure.setBounds(410,245,65,25);
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelWork);
		panel.add(fieldWork);
		panel.add(fieldPassword);
		panel.add(labelPassword);
		panel.add(labelPasswAgain);
		panel.add(fieldPasswAgain);
		panel.add(buttonSure);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	public static void main(String args[]){
		Registerui r=new Registerui();
		r.go();
	}

}

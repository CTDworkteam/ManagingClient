package loginui;
import javax.swing.*;

public class FindPasswordui {
	
	JFrame frame;
	JPanel panel;
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("找回密码");
		
		JLabel labelSName=new JLabel("用户名",JLabel.RIGHT);
		JLabel labelName=new JLabel("姓名",JLabel.RIGHT);
		JLabel labelWork=new JLabel("职务",JLabel.RIGHT);
		JTextField fieldSName=new JTextField();
		JTextField fieldName=new JTextField();
		JTextField fieldWork=new JTextField();
		JTextArea areaMessage=new JTextArea();
		areaMessage.setLineWrap(true);
		JButton buttonSearch=new JButton("找回");
		JButton buttonAgain=new JButton("重置");
		JButton buttonSure=new JButton("确认");
		
		frame.setSize(wide/3+200,high/3+100);
		frame.setLocation(wide/3,high/3);
		
		panel.setLayout(null);
		labelSName.setBounds(150, 100, 50, 25);
		fieldSName.setBounds(210,100,150,25);
		labelName.setBounds(150,135,50,25);
		fieldName.setBounds(210,135,150,25);
		labelWork.setBounds(150,170,50,25);
		fieldWork.setBounds(210,170,150,25);
		areaMessage.setBounds(450,100,200,70);
		buttonSearch.setBounds(210,210,65,25);
		buttonAgain.setBounds(290,210,65,25);
		buttonSure.setBounds(520,200,65,25);
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelSName);
		panel.add(fieldSName);
		panel.add(labelWork);
		panel.add(fieldWork);
		panel.add(areaMessage);
		panel.add(buttonSure);
		panel.add(buttonAgain);
		panel.add(buttonSearch);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
}

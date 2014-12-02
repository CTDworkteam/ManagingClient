package accountui;
import javax.swing.*;
import java.awt.event.*;

public class AccountAddui {
	
	JFrame frame;
	JPanel panel;
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("增加账户");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("账户名",JLabel.RIGHT);
		JTextField fieldName=new JTextField();
		JLabel labelMoney=new JLabel("初始金额",JLabel.RIGHT);
		JTextField fieldMoney=new JTextField();
		JButton buttonAdd=new JButton("增加");
		buttonAdd.addActionListener(new addListener());
		JButton buttonCancel=new JButton("取消");
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(400,200);
		frame.setLocation(wide/3,high/4);
		
		panel.setLayout(null);
		labelName.setBounds(80,30,70,25);
		fieldName.setBounds(160,30,100,25);
		labelMoney.setBounds(80,65,70,25);
		fieldMoney.setBounds(160,65,100,25);
		buttonAdd.setBounds(190,120,65,25);
		buttonCancel.setBounds(100,120,65,25);
		
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelMoney);
		panel.add(fieldMoney);
		panel.add(buttonAdd);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

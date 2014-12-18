package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.*;

/*
 * �鿴�˻����Խ���
 */
public class AccountLookui implements ActionListener{
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	public void go(AccountVO vo){
		
		frame.setTitle("�鿴�˻�");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("�����˻���  "+vo.getName());
		JLabel labelMoney=new JLabel("�˻���� "+Double.toString(vo.getMoney()));
		JButton button=new JButton("ȷ��");
		button.addActionListener(this);
		
		frame.setSize(400,200);
		frame.setLocation(wide/3,high/4);
		
		panel.setLayout(null);
		labelName.setBounds(100,30,150,25);
		labelMoney.setBounds(100,65,150,25);
		button.setBounds(130,120,65,25);
		
		panel.add(labelName);
		panel.add(labelMoney);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		frame.dispose();
	}

}

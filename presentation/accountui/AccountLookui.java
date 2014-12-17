package accountui;
import javax.swing.*;
import java.awt.event.*;

public class AccountLookui implements ActionListener{
	
	JFrame frame;
	JPanel panel;
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("�鿴�˻�");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("�����˻���  ********");
		JLabel labelMoney=new JLabel("�˻���� *****");
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

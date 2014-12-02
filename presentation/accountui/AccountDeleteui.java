package accountui;
import javax.swing.*;
import java.awt.event.*;

public class AccountDeleteui{
	
	JFrame frame;
	JPanel panel;
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("ɾ���˻�");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("�����˻���  ********");
		JLabel labelMoney=new JLabel("�˻���� *****");
		JButton buttonConfirm=new JButton("ȷ��");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("ȡ��");
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(400,200);
		frame.setLocation(wide/3,high/4);
		
		panel.setLayout(null);
		labelName.setBounds(100,30,150,25);
		labelMoney.setBounds(100,65,150,25);
		buttonConfirm.setBounds(120,120,65,25);
		buttonCancel.setBounds(210,120,65,25);
		
		panel.add(labelName);
		panel.add(labelMoney);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class confirmListener implements ActionListener{
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

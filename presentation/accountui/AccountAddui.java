package accountui;
import javax.swing.*;
import java.awt.event.*;
import accountbl.AccountController;
import enumType.ResultMessage;
import vo.*;
import confirmui.*;

/*
 * ����˻�����
 */
public class AccountAddui {
	
	JFrame frame;
	JPanel panel;
	JTextField fieldName;
	JTextField fieldMoney;
	
	AccountController controller=new AccountController();
	
	public void go(){
		frame=new JFrame();
		panel=new JPanel();
		
		frame.setTitle("�����˻�");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("�˻���",JLabel.RIGHT);
		fieldName=new JTextField();
		JLabel labelMoney=new JLabel("��ʼ���",JLabel.RIGHT);
		fieldMoney=new JTextField();
		JButton buttonAdd=new JButton("����");
		buttonAdd.addActionListener(new addListener());
		JButton buttonCancel=new JButton("ȡ��");
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
			String name=fieldName.getText();
			String money=fieldMoney.getText();
			if(controller.JudgeMoney(money)==ResultMessage.Success){
				AccountVO vo=new AccountVO();
				vo.setName(name);
				vo.setMoney(Double.parseDouble(money));
				if(controller.add(vo)==ResultMessage.Success){
					Runnable r=new Confirmui("�ɹ������˻�");
					Thread t=new Thread(r);
					t.start();
					frame.dispose();
				}else{
					Runnable r=new Confirmui("�˻����ظ��������˻�ʧ��");
					Thread t=new Thread(r);
					t.start();
				}
			}else{
				Runnable r=new Confirmui("�˻���ʼ����ʽ����");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
}

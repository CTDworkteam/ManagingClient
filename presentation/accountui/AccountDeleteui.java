package accountui;
import javax.swing.*;

import enumType.ResultMessage;

import java.awt.event.*;

import accountbl.AccountController;
import vo.*;
import confirmui.*;

/*
 * ɾ���˻�����
 */
public class AccountDeleteui{
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	AccountController controller=new AccountController();
	
	AccountVO theAccount;//�˻���Ϣ
	
	public void go(AccountVO vo){
		
		theAccount=vo;
		
		frame.setTitle("ɾ���˻�");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("�����˻���  "+vo.getName());
		JLabel labelMoney=new JLabel("�˻���� "+Double.toString(vo.getMoney()));
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
			String result="";
			if(controller.delete(theAccount)==ResultMessage.Success){
				result="�ѳɹ�ɾ���˻�";
				frame.dispose();
			}
			else
				result="�޷�ɾ���˻�";
			Runnable r=new Confirmui(result);
			Thread t=new Thread(r);
			t.start();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
}

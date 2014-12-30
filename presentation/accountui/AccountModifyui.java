package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.*;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.*;

/*
 * �޸��˻����Խ���
 */
public class AccountModifyui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JTextField fieldName=new JTextField();//���ĺ���ʻ���
	
	AccountController controller=new AccountController();
	
	AccountVO theAccount=new AccountVO();//�˻�ԭʼ��Ϣ
	
	public void go(AccountVO vo){
		
		theAccount=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("�޸��˻�����");
		
		JLabel labelInitial=new JLabel("�˻�ԭ������:"+vo.getName()+"   "+Double.toString(vo.getMoney()));
		JLabel labelName=new JLabel("�˻���",JLabel.RIGHT);
		JButton buttonConfirm=new JButton("ȷ��");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("ȡ��");
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(400,200);
		frame.setLocation(wide/3,high/4);
		
		panel.setLayout(null);
		labelInitial.setBounds(100,30,200,25);
		labelName.setBounds(80,60,70,25);
		fieldName.setBounds(160,60,100,25);
		buttonConfirm.setBounds(190,150,65,25);
		buttonCancel.setBounds(100,150,65,25);
		
		panel.add(labelInitial);
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String name=fieldName.getText();
			AccountVO vo=new AccountVO();
			vo.setName(name);
			vo.setMoney(theAccount.getMoney());
			if(controller.update(vo)==ResultMessage.Success){
				Runnable r=new Confirmui("�ɹ������˻�����");
				Thread t=new Thread(r);
				t.start();
			}
			else{
				Runnable r=new Confirmui("�����ʻ�������");
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

package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.AccountVO;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.ConfirmFailui;
import confirmui.ConfirmSuccessui;

/*
 * ɾ���˻�����
 */
public class AccountDeleteui{
	
	JFrame frame;
	JPanel panel;
	AccountVO theAccount;
	
	AccountController controller=new AccountController();
	
	public void go(AccountVO vo){
		frame=new JFrame();
		panel=new JPanel();
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
			ResultMessage result=controller.delete(theAccount);
			if(result==ResultMessage.Success){
				Runnable r=new ConfirmSuccessui("��ɾ����Ӧ�˻�");
				Thread t=new Thread(r);
				t.start();
			}
			if(result==ResultMessage.Failure){
				Runnable r=new ConfirmFailui("ɾ���˻�ʧ��");
				Thread t=new Thread(r);
				t.start();
			}
			frame.dispose();
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
}

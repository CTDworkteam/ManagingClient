package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.AccountVO;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.ConfirmSuccessui;
import confirmui.ConfirmFailui;

/*
 * �޸��˻����Խ���
 */
public class AccountModifyui {
	
	JFrame frame;
	JPanel panel;
	JTextField fieldName;
	
	AccountController controller=new AccountController();
	
	public void go(AccountVO vo){
		
		frame=new JFrame();
		panel=new JPanel(); 
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("�޸��˻�����");
		
		JLabel label=new JLabel("ԭ���˻�����"+":"+vo.getName()+"   "+Double.toString(vo.getMoney()));
		JLabel labelName=new JLabel("�˻���",JLabel.RIGHT);
		fieldName=new JTextField();
		JButton buttonConfirm=new JButton("ȷ��");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("ȡ��");
		buttonCancel.addActionListener(new cancelListener());
		
		frame.setSize(400,200);
		frame.setLocation(wide/3,high/4);
		
		panel.setLayout(null);
		label.setBounds(80,20,150,25);
		labelName.setBounds(80,60,70,25);
		fieldName.setBounds(160,60,100,25);
		buttonConfirm.setBounds(190,150,65,25);
		buttonCancel.setBounds(100,150,65,25);
		
		panel.add(label);
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(buttonConfirm);
		panel.add(buttonCancel);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//�½�AccountVO����
			AccountVO theAccount=new AccountVO();
			theAccount.setName(fieldName.getText());
			
			ResultMessage result=controller.update(theAccount);
			
			if(result==ResultMessage.Success){
				Runnable r=new ConfirmSuccessui("�ʻ����޸ĳɹ�");
				Thread t=new Thread(r);
				t.start();
			}
			if(result==ResultMessage.Failure){
				Runnable r=new ConfirmFailui("�����ʻ����Ѵ���");
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

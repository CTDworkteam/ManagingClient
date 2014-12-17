package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.AccountVO;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.ConfirmSuccessui;
import confirmui.ConfirmFailui;

/*
 * 修改账户属性界面
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
		
		frame.setTitle("修改账户属性");
		
		JLabel label=new JLabel("原有账户属性"+":"+vo.getName()+"   "+Double.toString(vo.getMoney()));
		JLabel labelName=new JLabel("账户名",JLabel.RIGHT);
		fieldName=new JTextField();
		JButton buttonConfirm=new JButton("确定");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("取消");
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
			//新建AccountVO对象
			AccountVO theAccount=new AccountVO();
			theAccount.setName(fieldName.getText());
			
			ResultMessage result=controller.update(theAccount);
			
			if(result==ResultMessage.Success){
				Runnable r=new ConfirmSuccessui("帐户名修改成功");
				Thread t=new Thread(r);
				t.start();
			}
			if(result==ResultMessage.Failure){
				Runnable r=new ConfirmFailui("新设帐户名已存在");
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

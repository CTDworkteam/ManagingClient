package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.AccountVO;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.ConfirmFailui;
import confirmui.ConfirmSuccessui;

/*
 * 删除账户界面
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
		
		frame.setTitle("删除账户");
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		JLabel labelName=new JLabel("银行账户名  "+vo.getName());
		JLabel labelMoney=new JLabel("账户余额 "+Double.toString(vo.getMoney()));
		JButton buttonConfirm=new JButton("确定");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("取消");
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
				Runnable r=new ConfirmSuccessui("已删除相应账户");
				Thread t=new Thread(r);
				t.start();
			}
			if(result==ResultMessage.Failure){
				Runnable r=new ConfirmFailui("删除账户失败");
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

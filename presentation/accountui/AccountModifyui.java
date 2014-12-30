package accountui;
import javax.swing.*;
import java.awt.event.*;
import vo.*;
import accountbl.AccountController;
import enumType.ResultMessage;
import confirmui.*;

/*
 * 修改账户属性界面
 */
public class AccountModifyui {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JTextField fieldName=new JTextField();//更改后的帐户名
	
	AccountController controller=new AccountController();
	
	AccountVO theAccount=new AccountVO();//账户原始信息
	
	public void go(AccountVO vo){
		
		theAccount=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("修改账户属性");
		
		JLabel labelInitial=new JLabel("账户原有属性:"+vo.getName()+"   "+Double.toString(vo.getMoney()));
		JLabel labelName=new JLabel("账户名",JLabel.RIGHT);
		JButton buttonConfirm=new JButton("确定");
		buttonConfirm.addActionListener(new confirmListener());
		JButton buttonCancel=new JButton("取消");
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
				Runnable r=new Confirmui("成功更改账户属性");
				Thread t=new Thread(r);
				t.start();
			}
			else{
				Runnable r=new Confirmui("重置帐户名错误");
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

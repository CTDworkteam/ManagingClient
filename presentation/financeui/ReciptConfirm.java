package financeui;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.*;

import vo.*;
import financebl.FinanceController;
import enumType.ResultMessage;
import confirmui.*;

/*
 * 收款单确认界面
 */
public class ReciptConfirm {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[][] data;
	
	ArrayList<ReciptVO> recipt=new ArrayList<ReciptVO>();
	
	public void go(ReciptVO vo){
		
		recipt.add(vo);
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("财务人员——财务管理——收款单生成");
		
		String id=vo.getId();
		//单据状态
		String state;
		if(vo.isPassed()==true){
			state="已通过";
		}else{
			state="未通过";
		}
		
		String client=vo.getClient();
		String operator=vo.getOperator();
		ArrayList<FinanceItemVO> items=vo.getList();
		double total=vo.getTotal();
		
		JLabel labelID=new JLabel(id);
		JLabel labelState=new JLabel(state);
		JLabel labelClient=new JLabel("客户："+client);
		JLabel labelOperator=new JLabel("操作员："+operator);
		JLabel labelTotal=new JLabel("总计："+Double.toString(total));
		
		//转账信息列表设置
		String[] heading={"帐户名","转账金额","备注"};
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getAccount();
			data[t][1]=Double.toString(items.get(t).getMoney());
			data[t][2]=items.get(t).getNote();
		}
		JTable table=new JTable(data,heading);
		table.setEnabled(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		JButton buttonCancel=new JButton("取消");
		JButton buttonComdify=new JButton("修改");
		JButton buttonSubmit=new JButton("提交");
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		panel.setLayout(null);
		labelID.setBounds(280,65,200,25);
		labelState.setBounds(380,120,100,25);
		labelClient.setBounds(130,150,150,25);
		labelOperator.setBounds(300,150,150,25);
		scroller.setBounds(180,190,300,300);
		labelTotal.setBounds(500,400,100,25);
		buttonCancel.setBounds(690,90,65,25);
		buttonComdify.setBounds(690,135,65,25);
		buttonSubmit.setBounds(690,180,65,25);
		
		panel.add(labelID);
		panel.add(labelState);
		panel.add(labelClient);
		panel.add(labelOperator);
		panel.add(scroller);
		panel.add(labelTotal);
		panel.add(buttonCancel);
		panel.add(buttonComdify);
		panel.add(buttonSubmit);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
	class modifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
	class submitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceController controller=new FinanceController();
			ResultMessage result=controller.sendRecipt(recipt);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("提交失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				Runnable r=new Confirmui("提交成功");
				Thread thread=new Thread(r);
				thread.start();
			}
		}
	}
	
}

package financecheckui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.ExpenseVO.ExpenseItemVO;
import financecheckbl.FinanceCheckController;
import enumType.ResultMessage;
import confirmui.*;

public class ProcessListShowExpense {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("现金费用单");
	
	String[] heading={"条目名","条目金额","备注"};
	String[][] data=new String[100][3];
	
	ExpenseVO vo=new ExpenseVO();

	public void go(ExpenseVO vo){
		
		this.vo=vo;
		
		String id=vo.getId();
		//单据状态
		String state;
		if(vo.isPassed()==true){
			state="已通过";
		}else{
			state="未通过";
		}
		
		String operator=vo.getOperator();
		String account=vo.getAccount();
		ArrayList<ExpenseItemVO> items=vo.getList();
		double total=vo.getTotal();
		
		JLabel labelID=new JLabel(id);
		JLabel labelState=new JLabel(state);
		JLabel labelOperator=new JLabel("操作员："+operator);
		JLabel labelAccount=new JLabel("账户："+account);
		JLabel labelTotal=new JLabel("总计："+Double.toString(total));
		JButton button=new JButton("红冲");
		JButton buttonCopy=new JButton("红冲并复制");
		
		button.addActionListener(new buttonListener());
		buttonCopy.addActionListener(new buttonCopyListener());
		
		//条目信息列表设置
		for(int t=0;t<items.size();t++){
			data[t][0]=items.get(t).getItemName();
			data[t][1]=Double.toString(items.get(t).getMoney());
			data[t][2]=items.get(t).getNote();
		}
		JTable table=new JTable(data,heading);
		table.setEnabled(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroller=new JScrollPane(table);
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);
		labelState.setBounds(wide/4,120,100,25);
		labelAccount.setBounds(20,150,150,25);
		labelOperator.setBounds(300,150,150,25);
		scroller.setBounds(50,190,300,300);
		labelTotal.setBounds(wide/4,400,100,25);
		button.setBounds(50,440,80,25);
		buttonCopy.setBounds(150,440,80,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelState);
		panel.add(labelAccount);
		panel.add(labelOperator);
		panel.add(scroller);
		panel.add(labelTotal);
		panel.add(button);
		panel.add(buttonCopy);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			ResultMessage result=controller.deficitInvoice(vo);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("红冲失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				Runnable r=new Confirmui("已成功进行红冲");
				Thread thread=new Thread(r);
				thread.start();
			}
		}
	}
	
	class buttonCopyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			ResultMessage result=controller.deficitInvoice(vo);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("红冲失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				Runnable r=new Confirmui("已成功进行红冲");
				Thread thread=new Thread(r);
				thread.start();
			}
			
		}
	}
}

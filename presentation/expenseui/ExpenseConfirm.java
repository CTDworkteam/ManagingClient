package expenseui;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.*;

import vo.*;
import vo.ExpenseVO.ExpenseItemVO;
import enumType.ResultMessage;
import expensebl.ExpenseController;
import confirmui.*;

/*
 * �ֽ���õ�ȷ�Ͻ���
 */
public class ExpenseConfirm {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	String[][] data;
	
	ExpenseVO expense;
	
	public void go(ExpenseVO vo){
		
		expense=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("������Ա��������������ֽ���õ�����");
		
		String id=vo.getId();
		//����״̬
		String state;
		if(vo.isPassed()==true){
			state="��ͨ��";
		}else{
			state="δͨ��";
		}
		
		String operator=vo.getOperator();
		String account=vo.getAccount();
		ArrayList<ExpenseItemVO> items=vo.getList();
		double total=vo.getTotal();
		
		JLabel labelID=new JLabel(id);
		JLabel labelState=new JLabel(state);
		JLabel labelOperator=new JLabel("����Ա��"+operator);
		JLabel labelAccount=new JLabel("�˻���"+account);
		JLabel labelTotal=new JLabel("�ܼƣ�"+Double.toString(total));
		
		//��Ŀ��Ϣ�б�����
		String[] heading={"��Ŀ��","��Ŀ���","��ע"};
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
		
		JButton buttonCancel=new JButton("ȡ��");
		JButton buttonComdify=new JButton("�޸�");
		JButton buttonSubmit=new JButton("�ύ");
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		panel.setLayout(null);
		labelID.setBounds(280,65,200,25);
		labelState.setBounds(380,120,100,25);
		labelAccount.setBounds(130,150,150,25);
		labelOperator.setBounds(300,150,150,25);
		scroller.setBounds(180,190,300,300);
		labelTotal.setBounds(500,400,100,25);
		buttonCancel.setBounds(690,90,65,25);
		buttonComdify.setBounds(690,135,65,25);
		buttonSubmit.setBounds(690,180,65,25);
		
		panel.add(scroller);
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
	
	class comdifyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
	class submitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ExpenseController controller=new ExpenseController();
			ResultMessage result=controller.send(expense);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("�ύʧ��");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				Runnable r=new Confirmui("�ύ�ɹ�");
				Thread thread=new Thread(r);
				thread.start();
			}
		}
	}

}

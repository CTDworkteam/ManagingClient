package financeui;
import javax.swing.*;

import java.util.*;

import vo.*;

/*
 * �鿴��ѡ�տ����
 */
public class ReciptLook {
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel("�տ");
	
	public void go(ReciptVO vo){
		
		String id=vo.getId();
		//����״̬
		String state;
		if(vo.isPassed()==true){
			state="��ͨ��";
		}else{
			state="δͨ��";
		}
		
		String client=vo.getClient();
		String operator=vo.getOperator();
		ArrayList<FinanceItemVO> items=vo.getList();
		double total=vo.getTotal();
		
		JLabel labelID=new JLabel(id);
		JLabel labelState=new JLabel(state);
		JLabel labelClient=new JLabel("�ͻ���"+client);
		JLabel labelOperator=new JLabel("����Ա��"+operator);
		JLabel labelTotal=new JLabel("�ܼƣ�"+Double.toString(total));
		
		//ת����Ϣ�б�����
		String[] heading={"�ʻ���","ת�˽��","��ע"};
		String[][] data=new String[100][3];
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
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,high-150);
		
		panel.setLayout(null);
		
		label.setBounds(wide/12,30,100,25);
		labelID.setBounds(wide/12,65,200,25);
		labelState.setBounds(wide/4,120,100,25);
		labelClient.setBounds(20,150,150,25);
		labelOperator.setBounds(300,150,150,25);
		scroller.setBounds(50,190,300,300);
		labelTotal.setBounds(wide/4,400,100,25);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelState);
		panel.add(labelClient);
		panel.add(labelOperator);
		panel.add(scroller);
		panel.add(labelTotal);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}

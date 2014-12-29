package financecheckui;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import vo.*;
import vo.DetailListVO.DetailListItemVO;

/*
 * �鿴������ϸ����
 */
public class DetailListShow {

	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("������ϸ��");
	
	String[] heading={"����","��Ʒ","�ͺ�","����","����","�ܼ�"};
	String[][] data;
	JTable table;
	
	public void go(DetailListVO vo){
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-300);
		frame.setLocation(wide/3,150);
		
		JLabel labelStart=new JLabel("��ʼʱ�䣺"+vo.getStart());
		JLabel labelEnd=new JLabel("����ʱ�䣺"+vo.getEnd());
		JLabel labelStorehouse=new JLabel("�ֿ⣺"+vo.getStorehouse());
		JLabel labelCommodity=new JLabel("��Ʒ��"+vo.getCommodity());
		JLabel labelClient=new JLabel("�ͻ���"+vo.getClient());
		JLabel labelOperator=new JLabel("����Ա��"+vo.getOperator());
		
		ArrayList<DetailListItemVO> theList=vo.getList();
		for(int t=0;t<theList.size();t++){
			data[t][0]=theList.get(t).getDate();
			data[t][1]=theList.get(t).getCommodity();
			data[t][2]=theList.get(t).getModel();
			data[t][3]=Integer.toString(theList.get(t).getNumber());
			data[t][4]=Double.toString(theList.get(t).getPrice());
			data[t][5]=Double.toString(theList.get(t).getTotal());
		}
		JTable table=new JTable(data,heading);
		JScrollPane scroller=new JScrollPane(table);
		
		JButton button=new JButton("����");
		
		button.addActionListener(new buttonListener());
		
		panel.setLayout(null);
		
		label.setBounds(220,10,100,50);
		labelStart.setBounds(50,80,150,25);
		labelEnd.setBounds(220,80,150,25);
		labelStorehouse.setBounds(50,115,100,25);
		labelCommodity.setBounds(220,115,100,25);
		labelClient.setBounds(50,150,100,25);
		labelOperator.setBounds(220,150,100,25);
		scroller.setBounds(50,190,400,200);
		button.setBounds(220,450,65,25);
		
		panel.add(label);
		panel.add(labelStart);
		panel.add(labelEnd);
		panel.add(labelStorehouse);
		panel.add(labelCommodity);
		panel.add(labelClient);
		panel.add(labelOperator);
		panel.add(scroller);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}
	}
	
}

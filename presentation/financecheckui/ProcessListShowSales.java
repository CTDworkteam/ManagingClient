package financecheckui;
import javax.swing.*;
import java.util.*;

import vo.*;
import vo.SalesBillVO.SalesBillItemVO;
import enumType.UserJob;

public class ProcessListShowSales {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("���۵�");
	
	String[] heading={"��Ʒ","�ͺ�","����","����","�ܼ�","��ע"};
	String[][] data;

	public void go(SalesBillVO vo,UserJob job){
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-250);
		frame.setLocation(wide/3,high/8);
		
		String state="";
		if(vo.isPassed()==true){
			state="ͨ��";
		}else{
			state="δͨ��";
		}
		
		ArrayList<SalesBillItemVO> billItem=vo.getList();
		for(int t=0;t<billItem.size();t++){
			data[t][0]=billItem.get(t).getCommodity();
			data[t][1]=billItem.get(t).getModel();
			data[t][2]=Integer.toString(billItem.get(t).getNumber());
			data[t][3]=Double.toString(billItem.get(t).getPrice());
			data[t][4]=Double.toString(billItem.get(t).getTotal());
			data[t][5]=billItem.get(t).getNote();
		}
		JTable table=new JTable(data,heading);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JTextArea text=new JTextArea();
		text.setLineWrap(true);
		text.setText(vo.getNote());
		
		JLabel labelID=new JLabel(vo.getId());
		JLabel labelState=new JLabel(state);
		JLabel labelClient=new JLabel("�ͻ���"+vo.getClient());
		JLabel labelDefaultOperator=new JLabel("Ĭ��ҵ��Ա��"+vo.getDefaultOperator());
		JLabel labelOperator=new JLabel("����Ա��"+vo.getOperator());
		JLabel labelStorehouse=new JLabel("�ֿ�:"+vo.getStorehouse());
		JScrollPane scrollerTable=new JScrollPane(table);
		JLabel labelInitialTotal=new JLabel("��ʼ��"+Double.toString(vo.getInitialTotal()));
		JLabel labelDiscount=new JLabel("�ۿۣ�"+Double.toString(vo.getDiscount()));
		JLabel labelVoucher=new JLabel("����ȯ��"+Double.toString(vo.getVoucher()));
		JLabel labelTotal=new JLabel("�ܶ"+Double.toString(vo.getTotal()));
		JScrollPane scrollerText=new JScrollPane(text);
		
		
		panel.setLayout(null);
		
		label.setBounds(200,20,100,50);
		labelID.setBounds(250,80,200,25);
		labelState.setBounds(250,115,70,25);
		labelClient.setBounds(30,150,150,25);
		labelDefaultOperator.setBounds(210,150,150,25);
		labelStorehouse.setBounds(30,185,150,25);
		labelOperator.setBounds(210,185,150,25);
		scrollerTable.setBounds(30,220,400,100);
		labelInitialTotal.setBounds(30,330,100,25);
		labelDiscount.setBounds(140,330,100,25);
		labelVoucher.setBounds(140,365,100,25);
		labelTotal.setBounds(250,330,100,25);
		scrollerText.setBounds(30,400,400,80);
		
		panel.add(label);
		panel.add(labelID);
		panel.add(labelState);
		panel.add(labelClient);
		panel.add(labelDefaultOperator);
		panel.add(labelOperator);
		panel.add(labelStorehouse);
		panel.add(scrollerTable);
		panel.add(labelInitialTotal);
		panel.add(labelDiscount);
		panel.add(labelVoucher);
		panel.add(labelTotal);
		panel.add(scrollerText);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
}

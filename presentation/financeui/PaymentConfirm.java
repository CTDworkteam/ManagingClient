package financeui;
import javax.swing.*;
import vo.*;

public class PaymentConfirm {
	
	JFrame frame;
	JPanel panel;
	
	public void go(PaymentVO vo){
		frame=new JFrame();
		panel=new JPanel();
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setTitle("������Ա��������������������");
		
		JTextArea text=new JTextArea();
		JScrollPane scroller=new JScrollPane(text);
		text.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton buttonCancel=new JButton("ȡ��");
		JButton buttonComdify=new JButton("�޸�");
		JButton buttonSubmit=new JButton("�ύ");
		
		frame.setSize(wide/2+100,high/2+200);
		frame.setLocation(wide/4,high/6);
		panel.setLayout(null);
		scroller.setBounds(130,3,500,high/2+180);
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
}

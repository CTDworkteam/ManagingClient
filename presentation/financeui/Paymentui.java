package financeui;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;

/*
 * �ƶ��������
 */
public class Paymentui {
	
	public JPanel panel=new JPanel();
	JTextField fieldCustomer;
	JTextField fieldAccount;
	JTextField fieldMoney;
	JTextArea text;

	public Paymentui(){
		
		JButton button=new JButton("ˢ��");//ˢ�¸���б�ť
		button.addActionListener(new buttonListener());
		String[] heading={"���","�˻���","ת�˽��"};
		String[][] data={{"1","account1","100.0"},{"2","account2","200,0"}};
		JTable table=new JTable(data,heading);
		JLabel labelNew=new JLabel("�½����");
		JLabel labelCustomer=new JLabel("�ͻ���",JLabel.RIGHT);
		fieldCustomer=new JTextField();
		JLabel labelAccount=new JLabel("�����ʻ���",JLabel.RIGHT);
		fieldAccount=new JTextField();
		JLabel labelMoney=new JLabel("ת�˽��",JLabel.RIGHT);
		fieldMoney=new JTextField();
		JLabel labelNote=new JLabel("��ע",JLabel.RIGHT);
		text=new JTextArea();
		JScrollPane scroller=new JScrollPane(text);
		text.setLineWrap(true);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JButton buttonCancel=new JButton("ȡ��");
		buttonCancel.addActionListener(new cancelListener());
		JButton buttonOkay=new JButton("����");
		buttonOkay.addActionListener(new okayListener());

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(true);
		
		JScrollPane scrollTable=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panel.setLayout(null);
		button.setBounds(20,10,65,25);
		scrollTable.setBounds(20,50,230,360);
		labelNew.setBounds(400,10,100,25);
		labelCustomer.setBounds(250,45,100,25);
		fieldCustomer.setBounds(360,45,150,25);
		labelAccount.setBounds(250,85,100,25);
		fieldAccount.setBounds(360,85,150,25);
		labelMoney.setBounds(250,125,100,25);
		fieldMoney.setBounds(360,125,150,25);
		labelNote.setBounds(250,165,100,25);
		scroller.setBounds(360,165,250,200);
		buttonCancel.setBounds(500,380,65,25);
		buttonOkay.setBounds(400,380,65,25);
		
		panel.add(button);
		panel.add(scrollTable);
		panel.add(labelNew);
		panel.add(labelCustomer);
		panel.add(fieldCustomer);
		panel.add(labelAccount);
		panel.add(fieldAccount);
		panel.add(labelMoney);
		panel.add(fieldMoney);
		panel.add(labelNote);
		panel.add(scroller);
		panel.add(buttonCancel);
		panel.add(buttonOkay);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//��������������
			fieldCustomer.setText(null);
			fieldAccount.setText(null);
			fieldMoney.setText(null);
			text.setText(null);
		}
	}
	
	class okayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			PaymentConfirm payment=new PaymentConfirm();
			payment.go();
		}
	}

}

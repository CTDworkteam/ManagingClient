package strategyui;
import javax.swing.*;
import java.awt.event.*;

/*
 * ���д��������б����
 */
public class MessageStrategy {
	
	public JPanel panel=new JPanel();
	
	public MessageStrategy(){
		
		JButton button=new JButton("ˢ��");//ˢ�����д��������б�ť
		button.addActionListener(new buttonListener());
		String[] heading={"ʵʩ��ʼ����","ʵʩ��������","��������"};
		String[][] data={{"2014/1/2","2014/3/5","*******************************"}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane();
		scroller.getViewport().add(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		panel.setLayout(null);
		button.setBounds(330,0,65,25);
		scroller.setBounds(0,35,410,405);
		
		panel.add(button);
		panel.add(scroller);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}

}

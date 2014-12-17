package strategyui;
import javax.swing.*;
import java.awt.event.*;

/*
 * 已有促销策略列表界面
 */
public class MessageStrategy {
	
	public JPanel panel=new JPanel();
	
	public MessageStrategy(){
		
		JButton button=new JButton("刷新");//刷新已有促销策略列表按钮
		button.addActionListener(new buttonListener());
		String[] heading={"实施起始日期","实施结束日期","策略内容"};
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

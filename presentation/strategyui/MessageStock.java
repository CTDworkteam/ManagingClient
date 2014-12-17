package strategyui;
import java.awt.event.*;
import javax.swing.*;

/*
 * 库存信息列表界面
 */
public class MessageStock {
	
	public JPanel panel=new JPanel();
	
	public MessageStock(){
		
		JButton button=new JButton("刷新");//刷新库存信息列表按钮
		button.addActionListener(new buttonListener());
		String[] heading={"仓库编号","商品编号","商品名","商品型号","库存数量","进价","售价","最近进价","最近售价"};
		String[][] data={{"01","***********001","日光灯","SR01","100","20.0","21.0","20.0","21.0"}};
		JTable table=new JTable(data,heading);
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane();
		scroller.getViewport().add(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
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

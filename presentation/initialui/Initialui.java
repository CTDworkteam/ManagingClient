package initialui;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;

public class Initialui {

	public JPanel panelInitial=new JPanel();
	InitialNew inew=new InitialNew();
	
	public Initialui(){
		JLabel label=new JLabel("期初标识");
		JTextField text=new JTextField();
		JButton buttonLook=new JButton("查看");
		buttonLook.addActionListener(new lookListener());
		String[] heading={"序号","期初标识"};
		String[][] data={{"1","2013"},{"2","2014"}};
		JTable table=new JTable(data,heading);
		JButton buttonNew=new JButton("新建");
		buttonNew.addActionListener(new newListener());
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelInitial.setLayout(null);
		label.setBounds(125,20,70,25);
		text.setBounds(205,20,100,25);
		buttonLook.setBounds(330,20,65,25);
		scroller.setBounds(150,65,200,370);
		buttonNew.setBounds(530,70,65,65);
		
		panelInitial.add(label);
		panelInitial.add(text);
		panelInitial.add(buttonLook);
		panelInitial.add(scroller);
		panelInitial.add(buttonNew);
	}
	
	class lookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			inew.go();
		}
	}

}

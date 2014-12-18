package initialui;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.event.*;

/*
 * �ڳ����˽���
 */
public class Initialui {

	public JPanel panelInitial=new JPanel();
	JTextField text;
	
	InitialNew inew=new InitialNew();
	
	public Initialui(){
		
		JLabel label=new JLabel("�ڳ���ʶ");
		text=new JTextField();
		JButton buttonLook=new JButton("�鿴");
		buttonLook.addActionListener(new lookListener());
		JButton button=new JButton("");
		String[] heading={"���","�ڳ���ʶ"};
		String[][] data={{"1","2013"},{"2","2014"}};
		JTable table=new JTable(data,heading);
		table.addMouseListener(new selectListener());
		JButton buttonNew=new JButton("�½�");
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
		button.setBounds(70,65,65,25);
		scroller.setBounds(150,65,200,370);
		buttonNew.setBounds(530,70,65,65);
		
		panelInitial.add(label);
		panelInitial.add(text);
		panelInitial.add(buttonLook);
		panelInitial.add(button);
		panelInitial.add(scroller);
		panelInitial.add(buttonNew);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class lookListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String identification=text.getText();
		}
	}
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			inew.go();
		}
	}
	
	class selectListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			Object o=e.getSource();
			JTable t=(JTable)o;
			String identification=(String) t.getModel().getValueAt(t.getSelectedRow(), t.getSelectedColumn());
			text.setText(identification);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

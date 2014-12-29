package financecheckui;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import financecheckbl.FinanceCheckController;
import vo.*;

public class ConditionListCheck {

	JPanel panel=new JPanel();
	
	JLabel labelStart=new JLabel("开始时间：");
	JTextField fieldStartYear=new JTextField();
	JTextField fieldStartMonth=new JTextField();
	JTextField fieldStartDay=new JTextField();
	
	JLabel labelEnd=new JLabel("结束时间：");
	JTextField fieldEndYear=new JTextField();
	JTextField fieldEndMonth=new JTextField();
	JTextField fieldEndDay=new JTextField();
	
	public ConditionListCheck(){
		
		JButton button=new JButton("查询");
		
		button.addActionListener(new buttonListener());
		
		panel.setLayout(null);
		
		labelStart.setBounds(100,50,80,25);
		fieldStartYear.setBounds(180,50,50,25);
		fieldStartMonth.setBounds(233,50,50,25);
		fieldStartDay.setBounds(286,50,50,25);
		labelEnd.setBounds(100,100,80,25);
		fieldEndYear.setBounds(180,100,50,25);
		fieldEndMonth.setBounds(233,100,50,25);
		fieldEndDay.setBounds(286,100,50,25);
		button.setBounds(250,80,65,65);
		
		panel.add(labelStart);
		panel.add(fieldStartYear);
		panel.add(fieldStartMonth);
		panel.add(fieldStartDay);
		panel.add(labelEnd);
		panel.add(fieldEndYear);
		panel.add(fieldEndMonth);
		panel.add(fieldEndDay);
		panel.add(button);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			GregorianCalendar start=new GregorianCalendar();
			GregorianCalendar end=new GregorianCalendar();
			start.set(Integer.parseInt(fieldStartYear.getText()), Integer.parseInt(fieldStartMonth.getText()), Integer.parseInt(fieldStartDay.getText()));
			end.set(Integer.parseInt(fieldEndYear.getText()), Integer.parseInt(fieldEndMonth.getText()), Integer.parseInt(fieldEndDay.getText()));
			ConditionListVO vo=controller.getConditionList(start, end);
			ConditionListShow show=new ConditionListShow();
			show.go(vo);
		}
	}
}

package expenseui;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import vo.*;
import vo.ExpenseVO.ExpenseItemVO;
import expensebl.ExpenseController;
import confirmui.*;

import java.util.*;

public class Expenseui {
	
	public JPanel panel=new JPanel();
	ExpenseConfirm expense=new ExpenseConfirm();
	
	JTable tableLook;
	JTable tableNew;
	JTextField fieldOperator;
	
	String[][] dataLook;
	String[][] dataNew;
	
	int theRow=-1;//选中的新建现金费用单的行标
	
	public Expenseui(){
		JButton buttonNew=new JButton("刷新");
		
		String[] headingLook={"单据编号","银行账户名","状态"};
		//获取现金费用单列表数据
		ExpenseController controller=new ExpenseController();
		ArrayList<ExpenseVO> expenses=controller.getList();
		int count=0;
		for(int t=0;t<expenses.size();t++){
			if(expenses.get(t).isPassed()==false){
				dataLook[t][0]=expenses.get(t).getId();
				dataLook[t][1]=expenses.get(t).getAccount();
				dataLook[t][2]="未通过";
				count++;
			}
		}
		for(int t=0;t<expenses.size();t++){
			if(expenses.get(t).isPassed()==true){
				dataLook[t+count][0]=expenses.get(t).getId();
				dataLook[t+count][1]=expenses.get(t).getAccount();
				dataLook[t+count][2]="通过";
			}
		}
		tableLook=new JTable(dataLook,headingLook);
		tableLook.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableLook.setColumnSelectionAllowed(false);
		tableLook.setRowSelectionAllowed(true);
		JScrollPane scrollerLook=new JScrollPane(tableLook);
		tableLook.setPreferredScrollableViewportSize(new Dimension(460,60));
		tableLook.addMouseListener(new lookListener());
		
		JLabel labelOperator=new JLabel("操作员",JLabel.RIGHT);
		fieldOperator=new JTextField();
		
		String[] headingNew={"银行账户","条目名","条目金额","备注信息"};
		dataNew=new String[5][4];
		tableNew=new JTable(dataNew,headingNew);
		JScrollPane scrollerNew=new JScrollPane(tableNew);
		tableNew.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableNew.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		int i;
		for(i=0;i<getColumnNum(tableNew);i++){
			tableNew.setEditingColumn(i);
		}
		tableNew.addMouseListener(new newTableListener());
		JButton buttonAdd=new JButton("增加行");//增加行
		buttonAdd.addActionListener(new addListener());
		JButton buttonDelete=new JButton("删除行");//删除行
		buttonDelete.addActionListener(new deleteListener());
		
		JButton buttonOkay=new JButton("生成");
		buttonOkay.addActionListener(new okayListener());
		JButton buttonCancel=new JButton("取消");
		buttonCancel.addActionListener(new cancelListener());
		
		panel.setLayout(null);
		buttonNew.setBounds(230,3,65,25);
		scrollerLook.setBounds(20,33,300,377);
		labelOperator.setBounds(350,10,80,25);
		fieldOperator.setBounds(435,10,80,25);
		scrollerNew.setBounds(350,45,230,300);
		buttonAdd.setBounds(590,60,70,25);
		buttonDelete.setBounds(590,95,70,25);
		buttonOkay.setBounds(410,380,65,25);
		buttonCancel.setBounds(520,380,65,25);
		
		panel.add(buttonNew);
		panel.add(scrollerLook);
		panel.add(labelOperator);
		panel.add(fieldOperator);
		panel.add(scrollerNew);
		panel.add(buttonAdd);
		panel.add(buttonDelete);
		panel.add(buttonOkay);
		panel.add(buttonCancel);
	}
	
	public int getColumnNum(JTable table){
		int n=table.getColumnCount();
		return n;
	}
	
	public int getRowNum(JTable table){
		int n=table.getRowCount();
		return n;
	}
	
	class lookListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			int selectRow=tableLook.getSelectedRow();
			String id=(String) tableLook.getValueAt(selectRow, 0);
			ExpenseController controller=new ExpenseController();
			ExpenseLook look=new ExpenseLook();
			look.go(controller.find(id));
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
	
	class newTableListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			theRow=tableNew.getSelectedRow();
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
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//获取现金费用单列表数据
			ExpenseController controller=new ExpenseController();
			ArrayList<ExpenseVO> expenses=controller.getList();
			int count=0;
			for(int t=0;t<expenses.size();t++){
				if(expenses.get(t).isPassed()==false){
					dataLook[t][0]=expenses.get(t).getId();
					dataLook[t][1]=expenses.get(t).getAccount();
					dataLook[t][2]="未通过";
					count++;
				}
			}
			for(int t=0;t<expenses.size();t++){
				if(expenses.get(t).isPassed()==true){
					dataLook[t+count][0]=expenses.get(t).getId();
					dataLook[t+count][1]=expenses.get(t).getAccount();
					dataLook[t+count][2]="通过";
				}
			}
		}
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DefaultTableModel tableModel=(DefaultTableModel)tableNew.getModel();
			tableModel.addRow(new String[4]);
		}
	}
	
	class deleteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(theRow==-1){
				Runnable r=new Confirmui("请选择需要删除的行");
				Thread t=new Thread(r);
				t.start();
			}else{
				((DefaultTableModel)tableNew.getModel()).removeRow(theRow);
			}
		}
	}
	
	class okayListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int count=0;
			if((String)tableNew.getValueAt(0, 0)==null){
				Runnable r=new Confirmui("请填写所用账户名");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				 while((String)tableNew.getValueAt(count, 1)!=null||(String)tableNew.getValueAt(count, 2)!=null){
					 count++;
				 }
				 
				 for(int t=0;t<count;t++){
					 if((String)tableNew.getValueAt(t,1)==null||(String)tableNew.getValueAt(t, 2)==null){
						 Runnable r=new Confirmui("请完整填写条目信息");
						 Thread thread=new Thread(r);
						 thread.start();
					 }else{
						 if(t==count-1){
							 ExpenseController controller=new ExpenseController();
							 
							 Double total=0.0;
							 ArrayList<ExpenseItemVO> item=new ArrayList<ExpenseItemVO>();
							 for(int k=0;k<count;k++){
								 ExpenseVO.ExpenseItemVO expenseItem=new ExpenseVO().new ExpenseItemVO();
								 expenseItem.setItemName((String)tableNew.getValueAt(k,1));
								 expenseItem.setMoney(Double.parseDouble((String)tableNew.getValueAt(k, 2)));
								 expenseItem.setNote((String)tableNew.getValueAt(k, 3));
								 total=total+Double.parseDouble((String)tableNew.getValueAt(k, 2));
							 }
							 
							 GregorianCalendar date=new GregorianCalendar();
							 String id=controller.getNewID(date);
							 
							 ExpenseVO vo=new ExpenseVO(id,fieldOperator.getText(),(String)tableNew.getValueAt(0, 0),total,item);
							 
							 ExpenseConfirm expense=new ExpenseConfirm();
							 expense.go(vo);
						 }
					 }
				 }
			}
			ExpenseVO vo=new ExpenseVO();
			vo.setAccount((String) tableNew.getValueAt(0, 0));
		}
	}
	
	class cancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			tableNew.removeAll();
		}
	}
	
}

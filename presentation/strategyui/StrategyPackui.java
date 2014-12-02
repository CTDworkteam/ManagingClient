package strategyui;
import javax.swing.*;
import java.awt.event.*;

public class StrategyPackui {
	
	public JPanel panel=new JPanel();
	
	public StrategyPackui(){
		JLabel labelDiscount=new JLabel("降价比例",JLabel.RIGHT);
		JTextField fieldDiscount=new JTextField();
		JLabel labelName=new JLabel("商品名",JLabel.RIGHT);
		JComboBox<String> boxName=new JComboBox<String>();
		boxName.setEditable(true);
		JLabel labelNumber=new JLabel("商品编号",JLabel.RIGHT);
		JComboBox<String> boxNumber=new JComboBox<String>();
		boxNumber.setEditable(true);
		JButton buttonAdd=new JButton("加入");//加入特价包中的一项商品
		JButton buttonConfirmItem=new JButton("确定");//确定加入该促销策略中的一个特价包
		
		panel.setLayout(null);
		labelDiscount.setBounds(10,10,80,25);
		fieldDiscount.setBounds(100,10,80,25);
		labelName.setBounds(10,65,80,25);
		boxName.setBounds(100,65,80,25);
		labelNumber.setBounds(10,100,80,25);
		boxNumber.setBounds(100,100,80,25);
		buttonAdd.setBounds(223,85,65,25);
		buttonConfirmItem.setBounds(223,165,65,25);
		
		panel.add(labelName);
		panel.add(fieldDiscount);
		panel.add(labelDiscount);
		panel.add(boxName);
		panel.add(labelNumber);
		panel.add(boxNumber);
		panel.add(buttonAdd);
		panel.add(buttonConfirmItem);
	}
	
	class boxNameListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class boxNumberListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}

package strategyui;
import javax.swing.*;
import java.awt.event.*;

public class StrategyClientui {
	
	public JPanel panel=new JPanel();
	
	public StrategyClientui(){
		JLabel labelLevel=new JLabel("客户级别",JLabel.RIGHT);
		JComboBox<String> boxLevel=new JComboBox<String>();
		boxLevel.setEditable(true);
		boxLevel.addItem("1");
		boxLevel.addItem("2");
		boxLevel.addItem("3");
		boxLevel.addItem("4");
		boxLevel.addItem("5");
		boxLevel.addActionListener(new boxLevelListener());
		JLabel labelName=new JLabel("商品名称",JLabel.RIGHT);
		JComboBox<String> boxName=new JComboBox<String>();
		boxName.setEditable(true);
		boxName.addActionListener(new boxNameListener());
		JLabel labelNumber=new JLabel("商品编号",JLabel.RIGHT);
		JComboBox<String> boxNumber=new JComboBox<String>();
		boxNumber.setEditable(true);
		boxNumber.addActionListener(new boxNumberListener());
		JLabel labelCount=new JLabel("数量",JLabel.RIGHT);
		JTextField fieldCount=new JTextField();
		JLabel labelDiscount=new JLabel("折让",JLabel.RIGHT);
		JTextField fieldDiscount=new JTextField();
		JLabel labelVoucher=new JLabel("代金券",JLabel.RIGHT);
		JTextField fieldVoucher=new JTextField();
		JButton buttonAdd=new JButton("加入");
		JButton buttonConfirmItem=new JButton("确定");//确定该促销策略中一项的加入
		
		panel.setLayout(null);
		labelLevel.setBounds(30,3,100,25);
		boxLevel.setBounds(140,3,50,25);
		labelName.setBounds(3,38,80,25);
		boxName.setBounds(93,38,80,25);
		labelNumber.setBounds(3,70,80,25);
		boxNumber.setBounds(93,70,80,25);
		labelCount.setBounds(3,102,80,25);
		fieldCount.setBounds(93,102,80,25);
		labelDiscount.setBounds(153,50,80,25);
		fieldDiscount.setBounds(243,50,60,25);
		labelVoucher.setBounds(153,105,80,25);
		fieldVoucher.setBounds(243,105,60,25);
		buttonAdd.setBounds(93,140,65,25);
		buttonConfirmItem.setBounds(243,175,65,25);
		
		panel.add(labelLevel);
		panel.add(boxLevel);
		panel.add(labelName);
		panel.add(boxName);
		panel.add(labelNumber);
		panel.add(boxNumber);
		panel.add(labelCount);
		panel.add(fieldCount);
		panel.add(labelDiscount);
		panel.add(fieldDiscount);
		panel.add(labelVoucher);
		panel.add(fieldVoucher);
		panel.add(buttonAdd);
		panel.add(buttonConfirmItem);
	}
	
	class boxLevelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
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

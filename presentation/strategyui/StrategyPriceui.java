package strategyui;
import javax.swing.*;
import java.awt.event.*;

public class StrategyPriceui {
	
	public JPanel panel=new JPanel();
	
	public StrategyPriceui(){
		JLabel labelPrice=new JLabel("�ܼ�",JLabel.RIGHT);
		JTextField fieldPrice=new JTextField();
		JLabel labelName=new JLabel("��Ʒ��",JLabel.RIGHT);
		JComboBox<String> boxName=new JComboBox<String>();
		boxName.setEditable(true);
		JLabel labelNumber=new JLabel("��Ʒ���",JLabel.RIGHT);
		JComboBox<String> boxNumber=new JComboBox<String>();
		boxNumber.setEditable(true);
		JLabel labelCount=new JLabel("��Ʒ����",JLabel.RIGHT);
		JTextField fieldCount=new JTextField();
		JLabel labelVoucher=new JLabel("����ȯ",JLabel.RIGHT);
		JTextField fieldVoucher=new JTextField();
		JButton buttonAdd=new JButton("����");//����һ����Ʒ
		JButton buttonConfirmItem=new JButton("ȷ��");//ȷ��һ������ƶ�
		
		panel.setLayout(null);
		labelPrice.setBounds(30,3,100,25);
		fieldPrice.setBounds(140,3,50,25);
		labelName.setBounds(3,38,75,25);
		boxName.setBounds(93,38,75,25);
		labelNumber.setBounds(3,70,75,25);
		boxNumber.setBounds(93,70,75,25);
		labelCount.setBounds(3,102,75,25);
		fieldCount.setBounds(93,102,75,25);
		labelVoucher.setBounds(153,70,75,25);
		fieldVoucher.setBounds(243,70,60,25);
		buttonAdd.setBounds(93,140,65,25);
		buttonConfirmItem.setBounds(243,175,65,25);
		
		panel.add(labelPrice);
		panel.add(fieldPrice);
		panel.add(labelName);
		panel.add(boxName);
		panel.add(labelNumber);
		panel.add(boxNumber);
		panel.add(labelCount);
		panel.add(fieldCount);
		panel.add(labelVoucher);
		panel.add(fieldVoucher);
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

package strategyui;
import javax.swing.*;
import java.awt.event.*;

public class StrategyPackui {
	
	public JPanel panel=new JPanel();
	
	public StrategyPackui(){
		JLabel labelDiscount=new JLabel("���۱���",JLabel.RIGHT);
		JTextField fieldDiscount=new JTextField();
		JLabel labelName=new JLabel("��Ʒ��",JLabel.RIGHT);
		JComboBox<String> boxName=new JComboBox<String>();
		boxName.setEditable(true);
		JLabel labelNumber=new JLabel("��Ʒ���",JLabel.RIGHT);
		JComboBox<String> boxNumber=new JComboBox<String>();
		boxNumber.setEditable(true);
		JButton buttonAdd=new JButton("����");//�����ؼ۰��е�һ����Ʒ
		JButton buttonConfirmItem=new JButton("ȷ��");//ȷ������ô��������е�һ���ؼ۰�
		
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

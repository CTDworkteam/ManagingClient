package strategyui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.GiftStrategyVO.GiftItemVO;
import strategybl.StrategyController;
import confirmui.*;

/*
 * ��Բ�ͬ����ͻ�ָ���������Խ���
 */
public class StrategyClientui {
	
	public JPanel panel=new JPanel();
	
	JComboBox<String> boxLevel;
	JTextField fieldName;
	JTextField fieldModel;
	JTextField fieldCount;
	JTextField fieldDiscount;
	JTextField fieldVoucher;
	
	ArrayList<GiftItemVO> gifts=new ArrayList<GiftItemVO>();
	
	public StrategyClientui(){
		JLabel labelLevel=new JLabel("�ͻ�����",JLabel.RIGHT);
		boxLevel=new JComboBox<String>();
		boxLevel.setEditable(true);
		boxLevel.addItem("1");
		boxLevel.addItem("2");
		boxLevel.addItem("3");
		boxLevel.addItem("4");
		boxLevel.addItem("5");
		JLabel labelName=new JLabel("��Ʒ����",JLabel.RIGHT);
		fieldName=new JTextField();
		JLabel labelModel=new JLabel("��Ʒ�ͺ�",JLabel.RIGHT);
		fieldModel=new JTextField();
		JLabel labelCount=new JLabel("����",JLabel.RIGHT);
		fieldCount=new JTextField();
		JLabel labelDiscount=new JLabel("����",JLabel.RIGHT);
		fieldDiscount=new JTextField();
		JLabel labelVoucher=new JLabel("����ȯ",JLabel.RIGHT);
		fieldVoucher=new JTextField();
		JButton buttonAdd=new JButton("����");//ȷ��һ����Ʒ
		JButton buttonConfirmItem=new JButton("ȷ��");//ȷ���ô���������һ��ļ���
		
		panel.setLayout(null);
		labelLevel.setBounds(30,3,100,25);
		boxLevel.setBounds(140,3,50,25);
		labelName.setBounds(3,38,80,25);
		fieldName.setBounds(93,38,80,25);
		labelModel.setBounds(3,70,80,25);
		fieldModel.setBounds(93,70,80,25);
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
		panel.add(fieldName);
		panel.add(labelModel);
		panel.add(fieldModel);
		panel.add(labelCount);
		panel.add(fieldCount);
		panel.add(labelDiscount);
		panel.add(fieldDiscount);
		panel.add(labelVoucher);
		panel.add(fieldVoucher);
		panel.add(buttonAdd);
		panel.add(buttonConfirmItem);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fieldName.getText()!=null&&fieldModel.getText()!=null&&fieldCount.getText()!=null){
				GiftStrategyVO.GiftItemVO item=new GiftStrategyVO().new GiftItemVO();
				item.setCommodity(fieldName.getText());
				item.setModel(fieldModel.getText());
				item.setNumber(Integer.parseInt(fieldCount.getText()));
				gifts.add(item);
			}else{
				Runnable r=new Confirmui("��������д��Ʒ��Ϣ");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String level=(String) boxLevel.getSelectedItem();
			int client=Integer.parseInt((String)boxLevel.getSelectedItem());
			StrategyController strategyController=new StrategyController();
			GregorianCalendar date=new GregorianCalendar();//�õ����������ò��Ա��
			if(gifts.get(0)!=null){
				GiftStrategyVO vo=new GiftStrategyVO();
				String id=strategyController.getNewGiftStrategyID(date);
				vo.setId(id);
				vo.setRank(client);
				vo.setList(gifts);
			}
			if(fieldDiscount.getText()!=null){
				DiscountStrategyVO vo=new DiscountStrategyVO();
				String id=strategyController.getNewDiscountStrateyID(date);
				vo.setId(id);
				vo.setRank(client);
				vo.setDiscount(Double.parseDouble(fieldDiscount.getText()));
			}
			if(fieldVoucher.getText()!=null){
				VoucherStrategyVO vo=new VoucherStrategyVO();
				String id=strategyController.getNewVoucherStrategyID(date);
				vo.setId(id);
				vo.setRank(client);
				vo.setVoucher(Double.parseDouble(fieldVoucher.getText()));
			}
		}
	}
	
}

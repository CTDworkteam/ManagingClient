package strategyui;
import javax.swing.*;

import vo.*;
import vo.GiftBasedOnTotalMoneyVO.GBOTMItemVO;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;

import confirmui.*;
import strategybl.StrategyController;
import enumType.ResultMessage;

public class StrategyPriceui {
	
	public JPanel panel=new JPanel();
	
	JTextField fieldLow=new JTextField();
	JTextField fieldHigh=new JTextField();
	JTextField fieldName=new JTextField();
	JTextField fieldModel=new JTextField();
	JTextField fieldCount=new JTextField();
	JTextField fieldVoucher=new JTextField();
	
	String[] heading={"��Ʒ����","��Ʒ�ͺ�","��Ʒ����"};
	String[][] data=new String[100][3];
	JTable table=new JTable(data,heading);
	
	ArrayList<GBOTMItemVO> item=new ArrayList<GBOTMItemVO>();
	
	public StrategyPriceui(){
		JLabel labelLow=new JLabel("�۸�����",JLabel.RIGHT);
		JLabel labelHigh=new JLabel("�۸�����",JLabel.RIGHT);
		JLabel labelName=new JLabel("��Ʒ��",JLabel.RIGHT);
		JLabel labelModel=new JLabel("�ͺ�",JLabel.RIGHT);
		JLabel labelCount=new JLabel("����",JLabel.RIGHT);
		JLabel labelVoucher=new JLabel("����ȯ",JLabel.RIGHT);
		JButton buttonAdd=new JButton("����");//����һ����Ʒ
		JButton buttonConfirmItem=new JButton("ȷ��");//ȷ��һ������ƶ�
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panel.setLayout(null);
		labelLow.setBounds(30,3,80,25);
		fieldLow.setBounds(115,3,50,25);
		labelHigh.setBounds(175,3,80,25);
		fieldHigh.setBounds(260,3,50,25);
		labelName.setBounds(3,38,75,25);
		fieldName.setBounds(93,38,75,25);
		labelModel.setBounds(3,70,75,25);
		fieldModel.setBounds(93,70,75,25);
		labelCount.setBounds(3,102,75,25);
		fieldCount.setBounds(93,102,75,25);
		labelVoucher.setBounds(153,70,75,25);
		fieldVoucher.setBounds(243,70,60,25);
		buttonAdd.setBounds(93,140,65,25);
		scroller.setBounds(3,140,300,200);
		buttonConfirmItem.setBounds(243,360,65,25);
		
		panel.add(labelLow);
		panel.add(fieldLow);
		panel.add(labelHigh);
		panel.add(fieldHigh);
		panel.add(labelName);
		panel.add(fieldName);
		panel.add(labelModel);
		panel.add(fieldModel);
		panel.add(labelCount);
		panel.add(fieldCount);
		panel.add(labelVoucher);
		panel.add(fieldVoucher);
		panel.add(buttonAdd);
		panel.add(scroller);
		panel.add(buttonConfirmItem);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fieldName.getText()!=null&&fieldModel.getText()!=null&&fieldCount.getText()!=null){
				GiftBasedOnTotalMoneyVO.GBOTMItemVO vo=new GiftBasedOnTotalMoneyVO().new GBOTMItemVO();
				vo.setCommodity(fieldName.getText());
				vo.setModel(fieldModel.getText());
				vo.setNumber(Integer.parseInt(fieldCount.getText()));
				item.add(vo);
				int size=item.size();
				data[size-1][0]=fieldName.getText();
				data[size-1][1]=fieldModel.getText();
				data[size-1][2]=fieldCount.getText();
			}else{
				Runnable r=new Confirmui("��������д��Ʒ��Ϣ");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			StrategyController controller=new StrategyController();
			GregorianCalendar date=new GregorianCalendar();
			
			if(item.get(0)!=null){
				String id=controller.getNewGiftBasedOnTotalMoneyID(date);
				GiftBasedOnTotalMoneyVO gift=new GiftBasedOnTotalMoneyVO();
				gift.setId(id);
				gift.setList(item);
				gift.setLower(Double.parseDouble(fieldLow.getText()));
				gift.setUpper(Double.parseDouble(fieldHigh.getText()));
				ResultMessage result=controller.setGiftBasedOnTotalMoney(gift);
				if(result==ResultMessage.Failure){
					Runnable r=new Confirmui("δ�ܳɹ��ƶ�����ܼ۵Ĵ�������");
					Thread t=new Thread(r);
					t.start();
				}else{
					Runnable r=new Confirmui("�ɹ��ƶ�����ܼ۵Ĵ�������");
					Thread t=new Thread(r);
					t.start();
				}
			}else{
				if(fieldVoucher.getText()!=null){
					String id=controller.getNewVoucherBasedOnTotalMoneyID(date);
					VoucherBasedOnTotalMoneyVO voucher=new VoucherBasedOnTotalMoneyVO();
					voucher.setId(id);
					voucher.setLower(Double.parseDouble(fieldLow.getText()));
					voucher.setUpper(Double.parseDouble(fieldHigh.getText()));
					voucher.setMoney(Double.parseDouble(fieldVoucher.getText()));
					ResultMessage result=controller.setVoucherBasedOnTotalMoney(voucher);
					if(result==ResultMessage.Failure){
						Runnable r=new Confirmui("δ�ܳɹ��ƶ�����ܼ۵Ĵ�������");
						Thread t=new Thread(r);
						t.start();
					}else{
						Runnable r=new Confirmui("�ɹ��ƶ�����ܼ۵Ĵ�������");
						Thread t=new Thread(r);
						t.start();
					}
				}else{
					Runnable r=new Confirmui("���������������Ϣ");
					Thread t=new Thread(r);
					t.start();
				}
			}
		}
	}
}

package strategyui;
import javax.swing.*;

import vo.GiftBasedOnTotalMoneyVO;
import vo.GiftBasedOnTotalMoneyVO.GBOTMItemVO;

import java.awt.event.*;
import java.util.*;
import confirmui.*;
import strategybl.StrategyController;
import enumType.ResultMessage;

public class StrategyPriceui {
	
	public JPanel panel=new JPanel();
	
	JTextField fieldLow;
	JTextField fieldHigh;
	JTextField fieldName;
	JTextField fieldModel;
	JTextField fieldCount;
	JTextField fieldVoucher;
	
	ArrayList<GBOTMItemVO> item=new ArrayList<GBOTMItemVO>();
	
	public StrategyPriceui(){
		JLabel labelLow=new JLabel("价格下限",JLabel.RIGHT);
		fieldLow=new JTextField();
		JLabel labelHigh=new JLabel("价格上限",JLabel.RIGHT);
		fieldHigh=new JTextField();
		JLabel labelName=new JLabel("商品名",JLabel.RIGHT);
		fieldName=new JTextField();
		JLabel labelModel=new JLabel("型号",JLabel.RIGHT);
		fieldModel=new JTextField();
		JLabel labelCount=new JLabel("数量",JLabel.RIGHT);
		fieldCount=new JTextField();
		JLabel labelVoucher=new JLabel("代金券",JLabel.RIGHT);
		fieldVoucher=new JTextField();
		JButton buttonAdd=new JButton("加入");//加入一项赠品
		JButton buttonConfirmItem=new JButton("确定");//确定一项策略制定
		
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
		buttonConfirmItem.setBounds(243,175,65,25);
		
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
			}else{
				Runnable r=new Confirmui("");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			StrategyController controller=new StrategyController();
			GregorianCalendar date=new GregorianCalendar();
			String id=controller.getNewGiftBasedOnTotalMoney(date);
			if(item.get(0)!=null){
				GiftBasedOnTotalMoneyVO gift=new GiftBasedOnTotalMoneyVO();
				gift.setId(id);
				gift.setList(item);
				gift.setLower(Double.parseDouble(fieldLow.getText()));
				gift.setUpper(Double.parseDouble(fieldHigh.getText()));
				ResultMessage result=controller.setGiftBasedOnTotalMoney(gift);
				if(result==ResultMessage.Failure){
					Runnable r=new Confirmui("未能成功制定针对总价的促销策略");
					Thread t=new Thread(r);
					t.start();
				}else{
					Runnable r=new Confirmui("成功制定针对总价的促销策略");
					Thread t=new Thread(r);
					t.start();
					
				}
			}else{
				if(fieldVoucher.getText()!=null){
					
				}else{
					Runnable r=new Confirmui("");
					Thread t=new Thread(r);
					t.start();
				}
			}
		}
	}
}

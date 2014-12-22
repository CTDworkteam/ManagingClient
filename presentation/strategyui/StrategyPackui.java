package strategyui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.CombinationStrategyVO.CombinationItemVO;
import strategybl.StrategyController;
import confirmui.*;
import enumType.ResultMessage;

/*
 * 制定特价包界面
 */
public class StrategyPackui {
	
	public JPanel panel=new JPanel();
	
	JTextField fieldInitial;
	JTextField fieldLater;
	JTextField fieldCommodity;
	JTextField fieldModel;
	JTextField fieldNumber;
	
	ArrayList<CombinationItemVO> item=new ArrayList<CombinationItemVO>();
	
	public StrategyPackui(){
		JLabel labelInitial=new JLabel("原价");
		fieldInitial=new JTextField();
		JLabel labelLater=new JLabel("现价");
		fieldLater=new JTextField();
		JLabel labelCommodity=new JLabel("名称",JLabel.RIGHT);
		fieldCommodity=new JTextField();
		JLabel labelModel=new JLabel("型号",JLabel.RIGHT);
		fieldModel=new JTextField();
		JLabel labelNumber=new JLabel("数量",JLabel.RIGHT);
		fieldNumber=new JTextField();
		JButton buttonAdd=new JButton("加入");//加入特价包中的一项商品
		JButton buttonConfirmItem=new JButton("确定");//确定加入该促销策略中的一个特价包
		
		panel.setLayout(null);
		labelInitial.setBounds(10,3,65,25);
		fieldInitial.setBounds(85,3,70,25);
		labelLater.setBounds(165,3,65,25);
		fieldLater.setBounds(240,3,70,25);
		labelCommodity.setBounds(3,38,80,25);
		fieldCommodity.setBounds(93,38,100,25);
		labelCommodity.setBounds(3,70,80,25);
		fieldCommodity.setBounds(93,70,100,25);
		labelNumber.setBounds(3,102,80,25);
		fieldNumber.setBounds(93,102,100,25);
		buttonAdd.setBounds(223,70,65,25);
		buttonConfirmItem.setBounds(223,165,65,25);
		
		panel.add(fieldInitial);
		panel.add(labelInitial);
		panel.add(labelLater);
		panel.add(fieldLater);
		panel.add(labelCommodity);
		panel.add(fieldCommodity);
		panel.add(labelModel);
		panel.add(fieldModel);
		panel.add(labelNumber);
		panel.add(fieldNumber);
		panel.add(buttonAdd);
		panel.add(buttonConfirmItem);
	}
	
	class addListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(fieldCommodity.getText()!=null&&fieldModel.getText()!=null&&fieldNumber.getText()!=null){
				CombinationStrategyVO.CombinationItemVO vo=new CombinationStrategyVO().new CombinationItemVO();
				vo.setCommodity(fieldCommodity.getText());
				vo.setModel(fieldModel.getText());
				vo.setNumber(Integer.parseInt(fieldNumber.getText()));
				item.add(vo);
			}else{
				Runnable r=new Confirmui("请完整填写特价包中商品信息");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
	class confirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			StrategyController controller=new StrategyController();
			if(fieldInitial.getText()!=null&&fieldLater.getText()!=null&&item.get(0)!=null){
				CombinationStrategyVO vo=new CombinationStrategyVO();
				GregorianCalendar date=new GregorianCalendar();
				String id=controller.getNewCombinationStrategyID(date);
				vo.setId(id);
				vo.setInitialMoney(Double.parseDouble(fieldInitial.getText()));
				vo.setLaterMoney(Double.parseDouble(fieldLater.getText()));
				vo.setList(item);
				ResultMessage result=controller.setCombination(vo);
				if(result==ResultMessage.Failure){
					Runnable r=new Confirmui("未能成功制定特价包策略");
					Thread t=new Thread(r);
					t.start();
				}else{
					Runnable r=new Confirmui("特价包添加成功");
					Thread t=new Thread(r);
					t.start();
				}
			}else{
				Runnable r=new Confirmui("请输入特价包完整信息");
				Thread t=new Thread(r);
				t.start();
			}
		}
	}
	
}

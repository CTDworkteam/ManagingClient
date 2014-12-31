package strategyui;
import javax.swing.*;

import java.awt.Dimension;
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
	
	JTextField fieldInitial=new JTextField();
	JTextField fieldLater=new JTextField();
	JTextField fieldCommodity=new JTextField();
	JTextField fieldModel=new JTextField();
	JTextField fieldNumber=new JTextField();
	
	String[] heading={"商品名称","商品型号","商品数量"};
	String[][] data=new String[100][3];
	JTable table=new JTable(data,heading);
	
	ArrayList<CombinationItemVO> item=new ArrayList<CombinationItemVO>();
	
	public StrategyPackui(){
		JLabel labelInitial=new JLabel("原价");
		JLabel labelLater=new JLabel("现价");
		JLabel labelCommodity=new JLabel("名称",JLabel.RIGHT);
		JLabel labelModel=new JLabel("型号",JLabel.RIGHT);
		JLabel labelNumber=new JLabel("数量",JLabel.RIGHT);
		JButton buttonAdd=new JButton("加入");//加入特价包中的一项商品
		JButton buttonConfirmItem=new JButton("确定");//确定加入该促销策略中的一个特价包
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
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
		scroller.setBounds(3,140,300,200);
		buttonConfirmItem.setBounds(223,360,65,25);
		
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
		panel.add(scroller);
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
				int size=item.size();
				data[size-1][0]=fieldCommodity.getText();
				data[size-1][1]=fieldModel.getText();
				data[size-1][2]=fieldNumber.getText();
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

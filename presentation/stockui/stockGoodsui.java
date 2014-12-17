package stockui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vo.CommodityModelVO;
import vo.CommodityVO;

import commoditybl.CommodityController;

class stockGoodsui extends JPanel{
	private String[] columnName={"编号","名称","型号","类型","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
	private Object[][] rowData={
			{00001,"飞利浦","hehe",5,10,0,0,0,0}
	};
	private DefaultTableModel tableModel=new DefaultTableModel(rowData,columnName);
	private JTable jTable=new JTable(tableModel);
	private JLabel tip=new JLabel("输入商品关键字");
	private JTextField keyField=new JTextField();
	private JButton jbtSearch=new JButton("搜索");
	private JButton jbtSee=new JButton("查看");
	private JButton jbtAdd=new JButton("增加");
	private JButton jbtDelete=new JButton("删除");
	private JButton jbtUpdate=new JButton("修改");
	private JScrollPane jScrollPane=new JScrollPane(jTable);
	
	JFrame insFrame;
	JLabel newName=new JLabel("新商品名称");
	JTextField nameField=new JTextField();
	JLabel newType=new JLabel("新商品型号");
	JTextField typeField=new JTextField();
	JLabel newTipLine=new JLabel("库存报警线");
	JTextField TipLineField=new JTextField();
	JButton jbtAssure=new JButton("确认");
	JButton jbtCancel=new JButton("取消");
	
	public stockGoodsui(){
		setLayout(new BorderLayout());
		JPanel top=new JPanel(new GridLayout(1,3));
		JPanel bottom=new JPanel(new GridLayout(1,3));
		top.add(tip);
		top.add(keyField);
		top.add(jbtSearch);
		bottom.add(jbtSee);
		bottom.add(jbtAdd);
		bottom.add(jbtDelete);
		bottom.add(jbtUpdate);
		add(top,BorderLayout.NORTH);
		add(jScrollPane,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		//未实现
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityController commodity=new CommodityController();
				String key=keyField.getText();
				ArrayList<CommodityVO> list=commodity.findCommodityInKeyword(key);
				int voNum=list.size();
				int modelNum;
				int total=0;
				CommodityVO vo;
				CommodityModelVO modelvo;
				String[][] emptyRow={};
				tableModel=new DefaultTableModel(emptyRow,columnName);
				jTable=new JTable(tableModel);
				for(int p=0;p<voNum;p++){
					vo=list.get(p);
					modelNum=list.get(p).getList().size();
					for(int q=0;q<modelNum;q++){
						modelvo=vo.getList().get(q);
						Object[] resultRow={vo.getId(),vo.getName(),modelvo.getModel(),vo.getType(),modelvo.getNoticeNumber(),modelvo.getStockNumber(),modelvo.getPurchasePrice(),modelvo.getRetailPrice(),modelvo.getRecentPurchasePrice(),modelvo.getRecentRetailPrice()};
					}
				}
			}
		});
		//未实现
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		//未更新数据
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				insFrame=new JFrame();
				insFrame.pack();
				newName=new JLabel("新商品名称");
				nameField=new JTextField();
				newType=new JLabel("新商品型号");
				typeField=new JTextField();
				newTipLine=new JLabel("库存报警线");
				TipLineField=new JTextField();
				jbtAssure=new JButton("确认");
				jbtCancel=new JButton("取消");
				JPanel insPanel=new JPanel(new BorderLayout());
				JPanel head=new JPanel(new GridLayout(3,2));
				JPanel tool=new JPanel(new GridLayout(1,2));
				nameField.setText("");
				typeField.setText("");
				TipLineField.setText("");
				head.add(newName);
				head.add(nameField);
				head.add(newType);
				head.add(typeField);
				head.add(newTipLine);
				head.add(TipLineField);
				tool.add(jbtAssure);
				tool.add(jbtCancel);
				insPanel.add(head,BorderLayout.CENTER);
				insPanel.add(tool,BorderLayout.SOUTH);
				insFrame.add(insPanel);
				insFrame.setLocationRelativeTo(null);
				insFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				insFrame.setSize(200,150);
				insFrame.setVisible(true);
				
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						String nameInfo=nameField.getText();
						String typeInfo=typeField.getText();
						String warmInfo=TipLineField.getText();
						Object[] newRow={"00002",nameInfo,typeInfo," ",0,0,0,0,0,warmInfo};
						tableModel.addRow(newRow);
						insFrame.dispose();
					}
				});
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						insFrame.dispose();
					}
				});
			}
		});
		//未更新数据：
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jTable.getSelectedRow()>=0)
					tableModel.removeRow(jTable.getSelectedRow());
			}
		});
		//未实现：
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}

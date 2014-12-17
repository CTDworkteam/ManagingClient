package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.border.*;

import vo.*;
import enumType.*;
import blservice.*;

public class stockFrame extends JFrame{
	private JTabbedPane stockGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("姓名: 迪屌");
	private JLabel UserPosition=new JLabel("职位:  库存管理员");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("退出");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private stockHomePage homePage=new stockHomePage();
	private stockType type=new stockType();
	private stockGoods goods=new stockGoods();
	private stockManagement management=new stockManagement();
	
	public stockFrame(){
		stockGuide.setTabPlacement(JTabbedPane.LEFT);
		stockGuide.addTab("首页", homePage);
		stockGuide.addTab("商品分类管理", type);
		stockGuide.addTab("商品信息管理", goods);
		stockGuide.addTab("库存管理", management);
		stockGuide.setSelectedIndex(0);
		textPanel.add(stockGuide);
		topInfoPanel.add(UserName);
		topInfoPanel.add(UserPosition);
		topTotalPanel.add(topInfoPanel,BorderLayout.WEST);
		topTotalPanel.add(jbtExit,BorderLayout.EAST);
		framePanel.add(topTotalPanel,BorderLayout.NORTH);
		framePanel.add(textPanel,BorderLayout.CENTER);
		add(framePanel);
		
	}
	public static void main(String[] args){
		stockFrame frame=new stockFrame();
		frame.pack();
		frame.setTitle("库存管理员");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}

class stockHomePage extends JPanel{
	String information="库存管理人员操作注意事项：";
	JTextArea stockInformation=new JTextArea(information);
	JScrollPane stockJscrollPane=new JScrollPane(stockInformation);
	
	stockHomePage(){
		stockInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(stockJscrollPane,BorderLayout.CENTER);
	}
}

class stockType extends JPanel{
	private JTree jTree;
	private JLabel name=new JLabel("    分类名");
	private JTextField nameField=new JTextField();
	private JLabel ID=new JLabel("分类编号");
	private JTextField IDField=new JTextField();
	private JButton jbtSearch=new JButton("搜索");
	private JPanel panelSearch=new JPanel(new BorderLayout());
	private JPanel panelSearch2=new JPanel(new BorderLayout());
 	private JPanel panelSearchPlus=new JPanel(new BorderLayout());
	private JPanel panelOperation=new JPanel(new GridLayout(1,4));
	private JButton jbtSee=new JButton("查看");
	private JButton jbtAdd=new JButton("增加");
	private JButton jbtDelete=new JButton("删除");
	private JButton jbtUpdate=new JButton("修改");
	DefaultMutableTreeNode parent;
	//insFrame的属性：
	JFrame insFrame=new JFrame();
	JLabel newName=new JLabel("新分类名称");
    JTextField newNameField=new JTextField();
	JLabel newID=new JLabel("新分类编号");
	JTextField newIDField=new JTextField();
	JButton assure=new JButton("确认");
	JButton cancel=new JButton("取消");
	JPanel top=new JPanel(new GridLayout(2,2));
	JPanel down=new JPanel(new GridLayout(1,2));
	JPanel splitPane=new JPanel(new BorderLayout());
	private JPanel panelSearch3=new JPanel(new GridLayout(2,1));
	
	stockType(){
		DefaultMutableTreeNode type=new DefaultMutableTreeNode("商品分类");
		type.add(new DefaultMutableTreeNode("分类1"));
		type.add(new DefaultMutableTreeNode("分类2"));
		type.add(new DefaultMutableTreeNode("分类3"));
		jTree=new JTree(type);
		setLayout(new BorderLayout());
		panelSearch.add(name,BorderLayout.WEST);
		panelSearch.add(nameField,BorderLayout.CENTER);
		panelSearch2.add(ID,BorderLayout.WEST);
		panelSearch2.add(IDField,BorderLayout.CENTER);
		panelSearch3.add(panelSearch);
		panelSearch3.add(panelSearch2);
		panelSearchPlus.add(panelSearch3,BorderLayout.CENTER);
		panelSearchPlus.add(jbtSearch,BorderLayout.EAST);
		splitPane.add(panelSearchPlus,BorderLayout.NORTH);
		splitPane.add(new JScrollPane(jTree),BorderLayout.CENTER);
		panelOperation.add(jbtSee);
		panelOperation.add(jbtAdd);
		panelOperation.add(jbtDelete);
		panelOperation.add(jbtUpdate);
		add(splitPane,BorderLayout.CENTER);
		add(panelOperation,BorderLayout.SOUTH);
	//unfinished:
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
    //unfinished:
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				insFrame.pack();
				insFrame=new JFrame();
				newName=new JLabel("新分类名称");
			    newNameField=new JTextField();
				newID=new JLabel("新分类编号");
				newIDField=new JTextField();
				assure=new JButton("确认");
				cancel=new JButton("取消");
				top=new JPanel(new GridLayout(2,2));
				down=new JPanel(new GridLayout(1,2));
				parent=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
				
				if(parent==null){
					JOptionPane.showMessageDialog(null, "Error:未选择上一级分类");
					return;
				}
				newNameField.setText("");
				newIDField.setText("");
				top.add(newName);
				top.add(newNameField);
				top.add(newID);
				top.add(newIDField);
				down.add(assure);
				down.add(cancel);
				JPanel total=new JPanel(new BorderLayout());
				total.add(top,BorderLayout.CENTER);
				total.add(down,BorderLayout.SOUTH);
				
				insFrame.add(total);
				insFrame.setLocationRelativeTo(null);
				insFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				insFrame.setSize(200,150);
				insFrame.setVisible(true);
		//未更新数据库		
				assure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String addName=newNameField.getText();
						parent.add(new DefaultMutableTreeNode(addName));
						((DefaultTreeModel)(jTree.getModel())).reload();
						
						insFrame.dispose();
					}
				});
				cancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						insFrame.dispose();
						
					}
				});
				
			}
		});
	//未更新数据库：
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				TreePath[] paths=jTree.getSelectionPaths();
				if(paths==null){
					JOptionPane.showMessageDialog(null, "Error:未选择目标分类");
					return;
				}
				for(int i=0;i<paths.length;i++){
					DefaultMutableTreeNode node=(DefaultMutableTreeNode)(paths[i].getLastPathComponent());
					if(node.isRoot()){
						JOptionPane.showMessageDialog(null, "Error：根分类不可删除");
					}
					else
						node.removeFromParent();
				}
				((DefaultTreeModel)(jTree.getModel())).reload();
			}
		});
		//未实现
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
}

class stockGoods extends JPanel{
	private String[] columnName={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
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
	
	public stockGoods(){
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
						Object[] newRow={"00002",nameInfo,typeInfo,0,0,0,0,0,warmInfo};
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
	class stockManagement extends JPanel{
		private JPanel stock=new JPanel();
		private JPanel bills=new JPanel();
		private JButton jbtCheck=new JButton("库存查看");
		private JButton jbtSnapshot=new JButton("库存快照");
		private JButton jbtPresent=new JButton("库存赠送");
		private JButton jbtOverflow=new JButton("库存报溢");
		private JButton jbtLoss=new JButton("库存报损");
		private JButton jbtWarming=new JButton("库存报警");
		
		//insFrame:
		JFrame checkFrame=new JFrame();
		JPanel totalPanel=new JPanel(new BorderLayout());
		String[] columnName={"序号","仓库名"};
		Object[][] rowData={{"0001","hehe"},{"0002","haha"}};
		DefaultTableModel tableModel=new DefaultTableModel(rowData,columnName);
		JTable checkTable=new JTable(tableModel);
		JScrollPane stockListPane=new JScrollPane(checkTable); 
		JLabel startTime=new JLabel("开始时间");
		JTextField startTimeField=new JTextField(20);
		JLabel endTime=new JLabel("结束时间");
		JTextField endTimeField=new JTextField(20);
		JPanel time1=new JPanel(new BorderLayout());
		JPanel time2=new JPanel(new BorderLayout());
		JPanel operation=new JPanel(new GridLayout(1,2));
		JButton jbtAssure=new JButton("确认");
		JButton jbtCancel=new JButton("取消");
		JPanel rightPanel=new JPanel();
		JLabel stockListTitle=new JLabel("仓库列表");
		JPanel time=new JPanel(new GridLayout(2,1));
		JPanel leftPanel=new JPanel(new BorderLayout());
		
		//shotFrame:
		JFrame shotFrame=new JFrame();
		JButton jbtSelect=new JButton("确定");
		JButton jbtNotSelect=new JButton("取消");
		String[] columnName1={"序号","仓库名"};
		String[][] rowData1={{"0001","hehe"},{"0002","haha"}};
		DefaultTableModel tableModel1=new DefaultTableModel(rowData1,columnName1);
		JTable shotTable=new JTable(tableModel1);
		JScrollPane shotListPane=new JScrollPane(shotTable);
		JLabel shotListTitle=new JLabel("仓库列表");
		JPanel biao=new JPanel(new BorderLayout());
		JPanel butt=new JPanel();
		
		//oneStockInfoFrame:
		JFrame oneStockInfoFrame=new JFrame();
		JPanel systemPanel=new JPanel(new BorderLayout());
		JPanel topInfoPanel=new JPanel();
		JPanel middlePanel=new JPanel(new BorderLayout());
		JLabel info1=new JLabel("仓库名  迪");
		JLabel info2=new JLabel("盘点时间  刁");
		JButton jbtPath=new JButton("选择路径");
		JButton jbtPathCancel=new JButton("取消");
		String[] goodsColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
		Object[][] goodsRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
		DefaultTableModel goodsTableModel=new DefaultTableModel(goodsRowData,goodsColumn);
		JTable goodsTable=new JTable(goodsTableModel);
		JScrollPane goodsListPane=new JScrollPane(goodsTable);
		JPanel butto=new JPanel();
		
		//presentFrame:
		JFrame presentFrame=new JFrame();
		JButton jbtPresentSelect=new JButton("确定");
		JButton jbtPresentNotSelect=new JButton("取消");
		String[] presentColumnName1={"序号","仓库名"};
		String[][] presentRowData1={{"0001","hehe"},{"0002","haha"}};
		DefaultTableModel presentTableModel=new DefaultTableModel(presentRowData1,presentColumnName1);
		JTable presentTable=new JTable(presentTableModel);
		JScrollPane presentListPane=new JScrollPane(presentTable);
		JLabel presentListTitle=new JLabel("仓库列表");
		JPanel presentBiao=new JPanel(new BorderLayout());
		JPanel presentButt=new JPanel();
		JSplitPane presentSplit;
		
		//present_subFrame:
		JFrame subPresentFrame=new JFrame();
		String[] presentColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
		Object[][] presentRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
		DefaultTableModel presentListTableModel=new DefaultTableModel(presentRowData,presentColumn);
		JTable presentListTable=new JTable(presentListTableModel);
		JScrollPane presentJScrollPane=new JScrollPane(presentListTable);
		JButton jbtPresentSelected=new JButton("赠送");
		JButton jbtPresentNotSelected=new JButton("取消");
		JPanel rightPresentPanel=new JPanel(new BorderLayout());
		JPanel rightTopPresentPanel=new JPanel(new BorderLayout());
		JPanel rightBottomPresentPanel=new JPanel(new BorderLayout());
		JPanel rightTotalPanel=new JPanel(new BorderLayout());
		JPanel presentButtons=new JPanel();
		JPanel subPresentPanel=new JPanel(new FlowLayout());
		JLabel number=new JLabel("数量");
		JTextField numberField=new JTextField();
		JLabel tip=new JLabel("备注");
		JTextArea tipArea=new JTextArea(5,20);
		
		//overFlowFrame:
		JFrame overFlowFrame=new JFrame();
		String[] overColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
		Object[][] overRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
		DefaultTableModel overTableModel=new DefaultTableModel(overRowData,overColumn);
		JTable overTable=new JTable(overTableModel);
		JScrollPane overJScrollPane=new JScrollPane(overTable);
		JSplitPane overSplit;
		JLabel stockName=new JLabel("仓库名称");
		JLabel goodsName=new JLabel("商品名称");
		JLabel goodsID=new JLabel("商品编号");
		JTextField stockNameField=new JTextField();
		JTextField goodsNameField=new JTextField();
		JTextField goodsIDField=new JTextField();
		JButton overSearch=new JButton("搜索");
		JButton overAssure=new JButton("确定");
		JButton overCancel=new JButton("取消");
		JPanel inputOnePanel=new JPanel(new BorderLayout());
		JPanel inputTwoPanel=new JPanel(new BorderLayout());
		JPanel inputThreePanel=new JPanel(new BorderLayout());
		JPanel overButtons=new JPanel();
		JPanel overRightPanel=new JPanel(new GridLayout(3,1));
		JPanel overRight=new JPanel(new BorderLayout());
		
		//overListFrame:
		JFrame overListFrame=new JFrame();
		JLabel overListTitle=new JLabel("库存报溢单",SwingConstants.CENTER);
		JLabel overStockName=new JLabel("仓库名",SwingConstants.RIGHT);
		JLabel overGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
		JLabel overGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
		JLabel overGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
		JLabel overSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
		JLabel overActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
		JLabel overTip=new JLabel("备注",SwingConstants.RIGHT);
		JTextField overStockNameField=new JTextField();
		JTextField overGoodsIDField=new JTextField();
		JTextField overGoodsNameField=new JTextField();
		JTextField overGoodsTypeField=new JTextField();
		JTextField overSystemNumField=new JTextField();
		JTextField overActualNumField=new JTextField();
		JTextArea  overTipArea       =new JTextArea();
		JButton overOutput=new JButton("生成");
		JButton overNotOutput=new JButton("取消");
		JPanel overListPanel=new JPanel(new GridLayout(6,2) );
		JPanel overOutputPanel=new JPanel();
		JPanel overListPanelPlus=new JPanel(new BorderLayout());
		JPanel overTipPanel=new JPanel(new GridLayout(1,2));
		JPanel overTipPlusPanel=new JPanel(new GridLayout(2,1));
		
		//lossFrame:
				JFrame lossFrame=new JFrame();
				String[] lossColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
				Object[][] lossRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
				DefaultTableModel lossTableModel=new DefaultTableModel(lossRowData,lossColumn);
				JTable lossTable=new JTable(lossTableModel);
				JScrollPane lossJScrollPane=new JScrollPane(lossTable);
				JSplitPane lossSplit;
				JLabel stockLossName=new JLabel("仓库名称");
				JLabel goodsLossName=new JLabel("商品名称");
				JLabel goodsLossID=new JLabel("商品编号");
				JTextField stockLossNameField=new JTextField();
				JTextField goodsLossNameField=new JTextField();
				JTextField goodsLossIDField=new JTextField();
				JButton lossSearch=new JButton("搜索");
				JButton lossAssure=new JButton("确定");
				JButton lossCancel=new JButton("取消");
				JPanel lossinputOnePanel=new JPanel(new BorderLayout());
				JPanel lossinputTwoPanel=new JPanel(new BorderLayout());
				JPanel lossinputThreePanel=new JPanel(new BorderLayout());
				JPanel lossButtons=new JPanel();
				JPanel lossRightPanel=new JPanel(new GridLayout(3,1));
				JPanel lossRight=new JPanel(new BorderLayout());
				
				//lossListFrame:
				JFrame lossListFrame=new JFrame();
				JLabel lossListTitle=new JLabel("库存报损单",SwingConstants.CENTER);
				JLabel lossStockName=new JLabel("仓库名",SwingConstants.RIGHT);
				JLabel lossGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
				JLabel lossGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
				JLabel lossGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
				JLabel lossSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
				JLabel lossActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
				JLabel lossTip=new JLabel("备注",SwingConstants.RIGHT);
				JTextField lossStockNameField=new JTextField();
				JTextField lossGoodsIDField=new JTextField();
				JTextField lossGoodsNameField=new JTextField();
				JTextField lossGoodsTypeField=new JTextField();
				JTextField lossSystemNumField=new JTextField();
				JTextField lossActualNumField=new JTextField();
				JTextArea  lossTipArea       =new JTextArea();
				JButton lossOutput=new JButton("生成");
				JButton lossNotOutput=new JButton("取消");
				JPanel lossListPanel=new JPanel(new GridLayout(6,2) );
				JPanel lossOutputPanel=new JPanel();
				JPanel lossListPanelPlus=new JPanel(new BorderLayout());
				JPanel lossTipPanel=new JPanel(new GridLayout(1,2));
				JPanel lossTipPlusPanel=new JPanel(new GridLayout(2,1));
			
			//warmingFrame:
				JFrame warmingFrame=new JFrame();
				String[] warmingListColumn={"仓库名","编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
				Object[][] warmingRowData={{"1A231","00001","淫迪","1号",1,4,4,4,4,4}};
				DefaultTableModel warmingTableModel=new DefaultTableModel(warmingRowData,warmingListColumn);
				JTable warmingTable=new JTable(warmingTableModel);
				JScrollPane warmingScrollPane=new JScrollPane(warmingTable);
				JLabel warmingTitle=new JLabel("库存报警单列表");
				JButton jbtSubmit=new JButton("提交");
				JButton jbtNotSubmit=new JButton("取消");
				JPanel warmingButtons=new JPanel();
				JPanel warmingTotal=new JPanel(new BorderLayout());
				
				
		public stockManagement()
		{
			stockListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			setLayout(new GridLayout(10,1));
			stock.add(jbtCheck);
			stock.add(jbtSnapshot);
			bills.add(jbtPresent);
			bills.add(jbtOverflow);
			bills.add(jbtLoss);
			bills.add(jbtWarming);
			stock.setBorder(new TitledBorder("库存查看"));
			bills.setBorder(new TitledBorder("单据制定"));
			add(stock);
			add(bills);
			
			jbtCheck.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					startTime.setHorizontalAlignment(SwingConstants.RIGHT);
					endTime.setHorizontalAlignment(SwingConstants.RIGHT);
					time1.add(startTime,BorderLayout.WEST);
					time1.add(startTimeField,BorderLayout.CENTER);
					time2.add(endTime,BorderLayout.WEST);
					time2.add(endTimeField,BorderLayout.CENTER);
					time.add(time1);
					time.add(time2);
					operation.add(jbtAssure);
					operation.add(jbtCancel);
					rightPanel.add(time);
					rightPanel.add(operation);;
					leftPanel.add(stockListTitle,BorderLayout.NORTH);
					leftPanel.add(stockListPane,BorderLayout.CENTER);
					totalPanel.add(leftPanel,BorderLayout.CENTER);
					totalPanel.add(rightPanel,BorderLayout.SOUTH);
					checkFrame.add(totalPanel);
					checkFrame.pack();
					checkFrame.setLocationRelativeTo(null);
					checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					checkFrame.setTitle("库存查看");
					checkFrame.setVisible(true);
			//未实现		
					jbtAssure.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							
							
							
							//最后：
							checkFrame.dispose();
						}
					});
					
					jbtCancel.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							checkFrame.dispose();
						}
					});
					
				}
			});
			
			jbtSnapshot.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					shotListTitle.setHorizontalAlignment(SwingConstants.CENTER);
					biao.add(shotListTitle,BorderLayout.NORTH);
					biao.add(shotListPane,BorderLayout.CENTER);
					
					butt.add(jbtSelect);
					butt.add(jbtNotSelect);
					biao.add(butt,BorderLayout.SOUTH);
					shotFrame.add(biao);
					shotFrame.pack();
					shotFrame.setLocationRelativeTo(null);
					shotFrame.setTitle("库存快照");
					shotFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					shotFrame.setVisible(true);
			//未实现选择仓库		
					jbtSelect.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							topInfoPanel.add(info1);
							topInfoPanel.add(info2);
							middlePanel.add(topInfoPanel,BorderLayout.NORTH);
							middlePanel.add(goodsListPane,BorderLayout.CENTER);
							systemPanel.add(middlePanel,BorderLayout.CENTER);
							butto.add(jbtPath);
							butto.add(jbtPathCancel);
							systemPanel.add(butto,BorderLayout.SOUTH);
							oneStockInfoFrame.add(systemPanel);
							oneStockInfoFrame.pack();
							oneStockInfoFrame.setLocationRelativeTo(null);
							oneStockInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							oneStockInfoFrame.setTitle("库存信息");
							oneStockInfoFrame.setVisible(true);
							
			//未实现excel导出	
							jbtPath.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									
								}
							});
							jbtPathCancel.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									oneStockInfoFrame.dispose();
									
								}
							});
						}
					});
					jbtNotSelect.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
						    shotFrame.dispose();
						}
					});
				}
			});
			
			jbtPresent.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					presentFrame=new JFrame();
					jbtPresentSelect=new JButton("确定");
					jbtPresentNotSelect=new JButton("取消");
					presentTableModel=new DefaultTableModel(presentRowData1,presentColumnName1);
					presentTable=new JTable(presentTableModel);
					presentListPane=new JScrollPane(presentTable);
					presentListTitle=new JLabel("仓库列表");
					presentBiao=new JPanel(new BorderLayout());
					presentButt=new JPanel();
					
					
					presentListTitle.setHorizontalAlignment(SwingConstants.CENTER);
                    presentBiao.add(presentListTitle,BorderLayout.NORTH);
					presentBiao.add(presentListPane,BorderLayout.CENTER);
					
					presentButt.add(jbtPresentSelect);
					presentButt.add(jbtPresentNotSelect);
					presentBiao.add(presentButt,BorderLayout.SOUTH);
					presentFrame.add(presentBiao);
					presentFrame.pack();
					presentFrame.setLocationRelativeTo(null);
					presentFrame.setTitle("库存赠送");
					presentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					presentFrame.setVisible(true);
					
					jbtPresentSelect.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							subPresentFrame=new JFrame();
							String[] presentColumn={"编号","名称","型号","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
							Object[][] presentRowData={{"00001","淫迪","1号",1,4,4,4,4,4}};
							presentListTableModel=new DefaultTableModel(presentRowData,presentColumn);
							presentListTable=new JTable(presentListTableModel);
							presentJScrollPane=new JScrollPane(presentListTable);
						    jbtPresentSelected=new JButton("赠送");
							jbtPresentNotSelected=new JButton("取消");
							rightPresentPanel=new JPanel(new BorderLayout());
							rightTopPresentPanel=new JPanel(new BorderLayout());
							rightBottomPresentPanel=new JPanel(new BorderLayout());
							rightTotalPanel=new JPanel(new BorderLayout());
							presentButtons=new JPanel();
							subPresentPanel=new JPanel(new FlowLayout());
							number=new JLabel("数量");
							numberField=new JTextField();
							tip=new JLabel("备注");
							tipArea=new JTextArea(5,20);
							
							rightTopPresentPanel.add(number,BorderLayout.WEST);
							rightTopPresentPanel.add(numberField,BorderLayout.CENTER);
							rightBottomPresentPanel.add(tip,BorderLayout.WEST);
							rightBottomPresentPanel.add(tipArea,BorderLayout.CENTER);
							rightPresentPanel.add(rightTopPresentPanel,BorderLayout.NORTH);
							rightPresentPanel.add(rightBottomPresentPanel,BorderLayout.CENTER);
							presentButtons.add(jbtPresentSelected);
							presentButtons.add(jbtPresentNotSelected);
							
							
							rightTotalPanel.add(rightPresentPanel,BorderLayout.CENTER);
							rightTotalPanel.add(presentButtons,BorderLayout.SOUTH);
							presentSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,presentJScrollPane,rightTotalPanel);
							subPresentPanel.add(presentSplit);
							subPresentFrame.add(subPresentPanel);
							subPresentFrame.pack();
							subPresentFrame.setLocationRelativeTo(null);
							subPresentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							subPresentFrame.setTitle("赠送选择");
							subPresentFrame.setVisible(true);
							
							jbtPresentSelected.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									if(presentListTable.getSelectedRow()==-1)
										JOptionPane.showMessageDialog(null, "未选择赠送商品");
									else
									{
									/*StockController stock=new StockController();
									GiftBillVO vo=new GiftBillVO();
									ArrayList<vo.GiftBillItemVO> list=new ArrayList<vo.GiftBillItemVO>();
									vo.GiftBillItemVO item=new vo.GiftBillItemVO(presentListTableModel.getValueAt(presentListTable.getSelectedRow(),1),presentListTableModel.getValueAt(presentListTable.getSelectedRow(), 2),numberField.getText());
									list.add(item);
									//未知：！！！！！！！！！！！！！！！
									vo.setID("GiftBill");
									//客户信息输入未导入
									vo.setClient("迪");
									vo.setStorehouse(presentTableModel.getValueAt(presentTable.getSelectedRow(),1));
									//无法实现
									vo.setOperator("di");
									vo.setList(list);
									ResultMessage result=stock.send(vo);
									if(result==ResultMessage。Success)
									{
									JOptionPane.showMessageDialog(null, "赠送成功");
									subPresentFrame.dispose();
									}
									else
									{
									JOptionPane.showMessageDialog(null, "赠送失败");
									subPresentFrame.dispose();
									}*/
									}
								}
							});
							jbtPresentNotSelected.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									subPresentFrame.dispose();
								}
							});
						}
					});
					jbtPresentNotSelect.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							presentFrame.dispose();
						}
					});
				}
			});
			
			jbtOverflow.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					overFlowFrame=new JFrame();
					overTableModel=new DefaultTableModel(overRowData,overColumn);
					overTable=new JTable(overTableModel);
					overJScrollPane=new JScrollPane(overTable);
					stockName=new JLabel("仓库名称");
					goodsName=new JLabel("商品名称");
					goodsID=new JLabel("商品编号");
					stockNameField=new JTextField();
					goodsNameField=new JTextField();
					goodsIDField=new JTextField();
					overSearch=new JButton("搜索");
					overAssure=new JButton("确定");
					overCancel=new JButton("取消");
					inputOnePanel=new JPanel(new BorderLayout());
					inputTwoPanel=new JPanel(new BorderLayout());
			        inputThreePanel=new JPanel(new BorderLayout());
					overButtons=new JPanel();
					overRightPanel=new JPanel(new GridLayout(3,1));
					overRight=new JPanel(new BorderLayout());
					
					inputOnePanel.add(stockName,BorderLayout.WEST);
					inputOnePanel.add(stockNameField,BorderLayout.CENTER);
					inputTwoPanel.add(goodsName,BorderLayout.WEST);
					inputTwoPanel.add(goodsNameField,BorderLayout.CENTER);
					inputThreePanel.add(goodsID,BorderLayout.WEST);
					inputThreePanel.add(goodsIDField,BorderLayout.CENTER);
					overButtons.add(overSearch);
					overButtons.add(overAssure);
					overButtons.add(overCancel);
					overRightPanel.add(inputOnePanel);
					overRightPanel.add(inputTwoPanel);
					overRightPanel.add(inputThreePanel);
					overRight.add(overRightPanel,BorderLayout.CENTER);
					overRight.add(overButtons,BorderLayout.SOUTH);
					overSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,overJScrollPane,overRight);
					overFlowFrame.add(overSplit);
					
					overFlowFrame.pack();
					overFlowFrame.setLocationRelativeTo(null);
					overFlowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					overFlowFrame.setTitle("库存报溢");
					overFlowFrame.setVisible(true);
					//未实现
					overSearch.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
						    JOptionPane.showMessageDialog(null, "功能未实现");	
						}
					});
					
					overAssure.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							overListFrame=new JFrame();
							overListTitle=new JLabel("库存报溢单",SwingConstants.CENTER);
							overStockName=new JLabel("仓库名",SwingConstants.RIGHT);
							overGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
							overGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
							overGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
							overSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
							overActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
							overTip=new JLabel("备注",SwingConstants.RIGHT);
							overStockNameField=new JTextField();
							overGoodsIDField=new JTextField();
							overGoodsNameField=new JTextField();
							overGoodsTypeField=new JTextField();
							overSystemNumField=new JTextField();
							overActualNumField=new JTextField();
							overTipArea       =new JTextArea();
							overOutput=new JButton("生成");
							overNotOutput=new JButton("取消");
							overListPanel=new JPanel(new GridLayout(6,2) );
							overOutputPanel=new JPanel();
						    overListPanelPlus=new JPanel(new BorderLayout());
							overTipPanel=new JPanel(new GridLayout(1,2));
						    overTipPlusPanel=new JPanel(new GridLayout(2,1));
							
							overListTitle.setSize(overSystemNum.getSize());
							overStockName.setSize(overSystemNum.getSize());
							overGoodsID.setSize(overSystemNum.getSize());
							overGoodsName.setSize(overSystemNum.getSize());
							overGoodsType.setSize(overSystemNum.getSize());
							overSystemNum.setSize(overSystemNum.getSize());
							overActualNum.setSize(overSystemNum.getSize());
							overTip.setSize(overSystemNum.getSize());
							overListPanel.add(overStockName);
							overListPanel.add(overStockNameField);
							overListPanel.add(overGoodsID);
							overListPanel.add(overGoodsIDField);
							overListPanel.add(overGoodsName);
							overListPanel.add(overGoodsNameField);
							overListPanel.add(overGoodsType);
							overListPanel.add(overGoodsTypeField);
							overListPanel.add(overSystemNum);
							overListPanel.add(overSystemNumField);
							overListPanel.add(overActualNum);
							overListPanel.add(overActualNumField);
							overTipPanel.add(overTip);
							overTipPanel.add(overTipArea);
							overTipPlusPanel.add(overListPanel);
							overTipPlusPanel.add(overTipPanel);
							overListPanelPlus.add(overListTitle,BorderLayout.NORTH);
							overListPanelPlus.add(overTipPlusPanel,BorderLayout.CENTER);
							overListPanelPlus.setBorder(new LineBorder(Color.BLACK,2));
							overOutputPanel.add(overListPanelPlus);
							overOutputPanel.add(overOutput);
							overOutputPanel.add(overNotOutput);
							overListFrame.add(overOutputPanel);
							overListFrame.setLocationRelativeTo(null);
							overListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							overListFrame.setTitle("制定库存报溢单");
							overListFrame.pack();
							overListFrame.setVisible(true);
							
							overOutput.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									JOptionPane.showMessageDialog(null, "单据生成成功");
									overListFrame.dispose();
								}
							});
							overNotOutput.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									overListFrame.dispose();
								}
							});
						}
					});
					overCancel.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							overFlowFrame.dispose();
						}
					});
				}
			});
			
			jbtLoss.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					lossFrame=new JFrame();
					lossTableModel=new DefaultTableModel(lossRowData,lossColumn);
					lossTable=new JTable(lossTableModel);
					lossJScrollPane=new JScrollPane(lossTable);
					stockLossName=new JLabel("仓库名称");
					goodsLossName=new JLabel("商品名称");
					goodsLossID=new JLabel("商品编号");
					stockLossNameField=new JTextField();
					goodsLossNameField=new JTextField();
					goodsLossIDField=new JTextField();
					lossSearch=new JButton("搜索");
					lossAssure=new JButton("确定");
					lossCancel=new JButton("取消");
					lossinputOnePanel=new JPanel(new BorderLayout());
					lossinputTwoPanel=new JPanel(new BorderLayout());
					lossinputThreePanel=new JPanel(new BorderLayout());
					lossButtons=new JPanel();
					lossRightPanel=new JPanel(new GridLayout(3,1));
					lossRight=new JPanel(new BorderLayout());
					
					lossinputOnePanel.add(stockLossName,BorderLayout.WEST);
					lossinputOnePanel.add(stockLossNameField,BorderLayout.CENTER);
					lossinputTwoPanel.add(goodsLossName,BorderLayout.WEST);
					lossinputTwoPanel.add(goodsLossNameField,BorderLayout.CENTER);
					lossinputThreePanel.add(goodsLossID,BorderLayout.WEST);
					lossinputThreePanel.add(goodsLossIDField,BorderLayout.CENTER);
					lossButtons.add(lossSearch);
					lossButtons.add(lossAssure);
					lossButtons.add(lossCancel);
					lossRightPanel.add(lossinputOnePanel);
					lossRightPanel.add(lossinputTwoPanel);
					lossRightPanel.add(lossinputThreePanel);
					lossRight.add(lossRightPanel,BorderLayout.CENTER);
					lossRight.add(lossButtons,BorderLayout.SOUTH);
					lossSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lossJScrollPane,lossRight);
					lossFrame.add(lossSplit);
					
					lossFrame.pack();
					lossFrame.setLocationRelativeTo(null);
					lossFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					lossFrame.setTitle("库存报损");
					lossFrame.setVisible(true);
					//未实现
					overSearch.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
						    JOptionPane.showMessageDialog(null, "功能未实现");	
						}
					});
					
					lossAssure.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							lossListFrame=new JFrame();
							lossListTitle=new JLabel("库存报损单",SwingConstants.CENTER);
					        lossStockName=new JLabel("仓库名",SwingConstants.RIGHT);
							lossGoodsID=new JLabel("商品编号",SwingConstants.RIGHT);
							lossGoodsName=new JLabel("商品名",SwingConstants.RIGHT);
							lossGoodsType=new JLabel("商品型号",SwingConstants.RIGHT);
							lossSystemNum=new JLabel("系统记录数量",SwingConstants.RIGHT);
							lossActualNum=new JLabel("实际库存数量",SwingConstants.RIGHT);
						    lossTip=new JLabel("备注",SwingConstants.RIGHT);
							lossStockNameField=new JTextField();
							lossGoodsIDField=new JTextField();
							lossGoodsNameField=new JTextField();
							lossGoodsTypeField=new JTextField();
							lossSystemNumField=new JTextField();
							lossActualNumField=new JTextField();
							lossTipArea       =new JTextArea();
							lossOutput=new JButton("生成");
						    lossNotOutput=new JButton("取消");
							lossListPanel=new JPanel(new GridLayout(6,2) );
							lossOutputPanel=new JPanel();
							lossListPanelPlus=new JPanel(new BorderLayout());
							lossTipPanel=new JPanel(new GridLayout(1,2));
							lossTipPlusPanel=new JPanel(new GridLayout(2,1));
							
							lossListTitle.setSize(lossSystemNum.getSize());
						    lossStockName.setSize(lossSystemNum.getSize());
							lossGoodsID.setSize(lossSystemNum.getSize());
							lossGoodsName.setSize(lossSystemNum.getSize());
							lossGoodsType.setSize(lossSystemNum.getSize());
							lossSystemNum.setSize(lossSystemNum.getSize());
						    lossActualNum.setSize(lossSystemNum.getSize());
							lossTip.setSize(lossSystemNum.getSize());
							lossListPanel.add(lossStockName);
							lossListPanel.add(lossStockNameField);
							lossListPanel.add(lossGoodsID);
							lossListPanel.add(lossGoodsIDField);
							lossListPanel.add(lossGoodsName);
							lossListPanel.add(lossGoodsNameField);
							lossListPanel.add(lossGoodsType);
							lossListPanel.add(lossGoodsTypeField);
							lossListPanel.add(lossSystemNum);
							lossListPanel.add(lossSystemNumField);
							lossListPanel.add(lossActualNum);
							lossListPanel.add(lossActualNumField);
							lossTipPanel.add(lossTip);
							lossTipPanel.add(lossTipArea);
							lossTipPlusPanel.add(lossListPanel);
							lossTipPlusPanel.add(lossTipPanel);
							lossListPanelPlus.add(lossListTitle,BorderLayout.NORTH);
							lossListPanelPlus.add(lossTipPlusPanel,BorderLayout.CENTER);
							lossListPanelPlus.setBorder(new LineBorder(Color.BLACK,2));
							lossOutputPanel.add(lossListPanelPlus);
							lossOutputPanel.add(lossOutput);
							lossOutputPanel.add(lossNotOutput);
							lossListFrame.add(lossOutputPanel);
							lossListFrame.setLocationRelativeTo(null);
							lossListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							lossListFrame.setTitle("制定库存报损单");
							lossListFrame.pack();
							lossListFrame.setVisible(true);
							
							lossOutput.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									JOptionPane.showMessageDialog(null, "单据生成成功");
									lossListFrame.dispose();
								}
							});
							lossNotOutput.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									lossListFrame.dispose();
								}
							});
						}
					});
					lossCancel.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							lossFrame.dispose();
						}
					});
				}
			});
			
			jbtWarming.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					warmingFrame=new JFrame();
					warmingTableModel=new DefaultTableModel(warmingRowData,warmingListColumn);
					warmingTable=new JTable(warmingTableModel);
				    warmingScrollPane=new JScrollPane(warmingTable);
					warmingTitle=new JLabel("库存报警单列表");
					jbtSubmit=new JButton("提交");
					jbtNotSubmit=new JButton("取消");
					warmingButtons=new JPanel();
					warmingTotal=new JPanel(new BorderLayout());
					
					warmingButtons.add(jbtSubmit);
					warmingButtons.add(jbtNotSubmit);
					warmingTotal.add(warmingTitle,BorderLayout.NORTH);
					warmingTotal.add(warmingScrollPane,BorderLayout.CENTER);
					warmingTotal.add(warmingButtons,BorderLayout.SOUTH);
					warmingFrame.add(warmingTotal);
					warmingFrame.pack();
					warmingFrame.setLocationRelativeTo(null);
					warmingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					warmingFrame.setTitle("库存报警");
					warmingFrame.setVisible(true);
					
					jbtSubmit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(warmingTable.getSelectedRow()>=0)
								warmingTableModel.removeRow(warmingTable.getSelectedRow());
							JOptionPane.showMessageDialog(null, "提交成功");
							
						}
					});
					jbtNotSubmit.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							warmingFrame.dispose();
						}
					});
				}
			});
		}
		
		
		
		
		
		
	}
	
	

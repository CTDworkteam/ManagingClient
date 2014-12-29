package stockui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vo.CommodityModelVO;
import vo.CommodityVO;
import commoditybl.CommodityController;
import enumType.ResultMessage;

class stockGoodsui extends JPanel{
	//
//	private String[] columnName={"编号","名称","型号","类型","库存报警线","库存数量","进价","零售价","最近进价","最近零售价"};
	private String[] columnName={"编号","名称","型号","总数"};
	private Object[][] rowData={
			{}
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
	//private JButton jbtAddModel=new JButton("增加型号");
	private JScrollPane jScrollPane=new JScrollPane(jTable);
	
	//add commdity ui
	JFrame insFrame;
	JLabel newName=new JLabel("新商品名称");
	JTextField nameField=new JTextField();
	JLabel newType=new JLabel("新商品型号");
	JTextField typeField=new JTextField();
	JLabel newTipLine=new JLabel("库存报警线");
	JTextField TipLineField=new JTextField();
	JButton jbtAssure=new JButton("确认");
	JButton jbtCancel=new JButton("取消");
	
	//add commdityModel ui
	JFrame modelFrame=new JFrame();
	JLabel newModel=new JLabel("新类型名称");
	JLabel newStorehouse=new JLabel("所属仓库");
	JLabel newWarming=new JLabel("库存报警线");
	JTextField newModelField=new JTextField();
	JTextField newStorehouseField=new JTextField();
	JTextField newWarmingField=new JTextField();
	JButton jbtModelAssure=new JButton("确定");
	JButton jbtModelCancel=new JButton("取消");
	
	//check the aimed commodity
	JFrame checkFrame=new JFrame();
	JLabel mainInfo;
	DefaultTableModel checkTableModel;
	JTable checkTable;
	JButton jbtCheckAssure=new JButton("确定");
	
	//update the commodity
	JFrame updateFrame=new JFrame();
	JPanel updatePanel=new JPanel();
	JLabel updateTitle=new JLabel("商品信息");
	JLabel updateID;
	JLabel updateName;
	JLabel updateType;
	JTextField updateIDField;
	JTextField updateNameField;
	JTextField updateTypeField;
	DefaultTableModel updateModelTableModel;
	JTable updateModelTable;
	JButton jbtAddModel;
	JButton jbtDeleteModel;
	JButton jbtUpdateModel;
	JButton jbtUpdateAssure;
	JButton jbtUpdateCancel;
	//update the commodityModel
	JFrame updateModelFrame=new JFrame();
	JPanel updateModelPanel;
	JLabel updateCommodity;
	JLabel updateModel;
	JLabel updateStorehouse;
	JLabel updateNoticeNumber;
	JTextField updateCommodityField;
	JTextField updateModelField;
	JTextField updateNoticeNumberField;
	JComboBox updateStorehouseField;
	JButton jbtUpdateModelAssure;
	JButton jbtUpdateModelCancel;
	
	JPopupMenu popupMenu;
	CommodityVO vo;
	CommodityModelVO modelvo;
	
	public stockGoodsui(){
		/*
		 * 
		 * 初始化表格   "编号","名称","型号","总数" 12.27
		 */
		CommodityController commodity=new CommodityController();
		ArrayList<CommodityVO> allCommodity=commodity.getAllCommodity();
		for(int i=0;i<allCommodity.size();i++)
		{
			CommodityVO insvo=allCommodity.get(i);
			Object[] newRow={insvo.getId(),insvo.getName(),insvo.getType(),insvo.getTotal()};
			tableModel.addRow(newRow);
		}
		
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
		//右键菜单：
		popupMenu=new JPopupMenu();
		JMenuItem popFlash=new JMenuItem("刷新");
		popupMenu.add(popFlash);
		add(popupMenu);
		popFlash.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//初始化表格：
				tableModel=new DefaultTableModel(rowData,columnName);
				jTable=new JTable(tableModel);
				//重构：
				CommodityController commodity=new CommodityController();
				ArrayList<CommodityVO> allCommodity=commodity.getAllCommodity();
				for(int i=0;i<allCommodity.size();i++)
				{
					CommodityVO insvo=allCommodity.get(i);
					Object[] newRow={insvo.getId(),insvo.getName(),insvo.getType(),insvo.getTotal()};
					tableModel.addRow(newRow);
				}
				
			}
		});
		this.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mousePressed(MouseEvent e){
				this_mousePressed(e);
			}
		});
		
		//12.19
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
						Object[] resultRow={vo.getId(),vo.getName(),vo.getType(),vo.getTotal()};
					    tableModel.addRow(resultRow);
					    
					}
				}
				
			}
		});
		//12.19
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityController commodity=new CommodityController();
				if(jTable.getSelectedRow()>=0)
				{
					CommodityVO vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(), 0));
					mainInfo=new JLabel("商品ID:"+vo.getId()+" 商品名称:"+vo.getName()+" 商品类型:"+vo.getType()+" 商品总数:"+vo.getTotal());
					checkFrame=new JFrame();
					JPanel checkPanel=new JPanel(new BorderLayout());
					JPanel checkButtons=new JPanel();
					String[] checkColumn={"型号","仓库","报警线","库存数","进价","零售价","最近进价","最近零售价"};
					ArrayList<CommodityModelVO> checkModelList=vo.getList();
					int insnum=vo.getList().size();
					Object[][] checkRow=new Object[insnum][8];
					for(int i=0;i<insnum;i++)
					{
						checkRow[i][0]=checkModelList.get(i).getModel();
						checkRow[i][1]=checkModelList.get(i).getStorehouse();
						checkRow[i][2]=checkModelList.get(i).getNoticeNumber();
						checkRow[i][3]=checkModelList.get(i).getStockNumber();
						checkRow[i][4]=checkModelList.get(i).getPurchasePrice();
						checkRow[i][5]=checkModelList.get(i).getRetailPrice();
						checkRow[i][6]=checkModelList.get(i).getRecentPurchasePrice();
						checkRow[i][7]=checkModelList.get(i).getRecentRetailPrice();
					}
					checkTableModel=new DefaultTableModel(checkRow,checkColumn);
					checkTable=new JTable(checkTableModel);
					JScrollPane checkJS=new JScrollPane(checkTable);
					checkButtons.add(jbtCheckAssure);
					checkPanel.add(mainInfo,BorderLayout.NORTH);
					checkPanel.add(checkJS,BorderLayout.CENTER);
					checkPanel.add(checkButtons,BorderLayout.SOUTH);
					
					checkFrame.add(checkPanel);
				    checkFrame.pack();
				    checkFrame.setLocationRelativeTo(null);
				    checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    checkFrame.setTitle("查看商品信息");
				    checkFrame.setVisible(true);
				    
				    jbtCheckAssure.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent e){
				    		checkFrame.dispose();
				    	}
				    });
				}
				else
				{
					JOptionPane.showMessageDialog(null, "未选择目标商品");
				}
			}
		});
		//12.19
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				insFrame=new JFrame();
				insFrame.pack();
				newName=new JLabel("新商品名称");
				nameField=new JTextField();
				newType=new JLabel("新商品编号");
				typeField=new JTextField();
				newTipLine=new JLabel("商品类型编号");
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
						CommodityController commodity=new CommodityController();
						String nameInfo=nameField.getText();
						String typeInfo=typeField.getText();
						String warmInfo=TipLineField.getText();
						
						CommodityVO vo=new CommodityVO(typeInfo,nameInfo,warmInfo,0,new ArrayList<CommodityModelVO>());
						ResultMessage result=commodity.addCommodity(vo);
						if(result==ResultMessage.Success)
						{
						Object[] newRow={typeInfo,nameInfo,warmInfo,0};
						tableModel.addRow(newRow);
						insFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "添加失败");
						}
						
					}
				});
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						insFrame.dispose();
					}
				});
			}
		});
		//12/19
		/*jbtAddModel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityController commodity=new CommodityController();
				if(jTable.getSelectedRow()>=0)
				{
					vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(), 0));
					modelFrame=new JFrame();
					newModel=new JLabel("新类型名称");
					newStorehouse=new JLabel("所属仓库");
					newWarming=new JLabel("库存报警线");
					newModelField=new JTextField();
					newStorehouseField=new JTextField();
					newWarmingField=new JTextField();
					jbtModelAssure=new JButton("确定");
					jbtModelCancel=new JButton("取消");
					JPanel modelPanel=new JPanel(new BorderLayout());
					JPanel head=new JPanel(new GridLayout(3,2));
					JPanel tool=new JPanel(new GridLayout(1,2));
					
					head.add(newModel);
					head.add(newModelField);
					head.add(newStorehouse);
					head.add(newStorehouseField);
					head.add(newWarming);
					head.add(newWarmingField);
					tool.add(jbtModelAssure);
					tool.add(jbtModelCancel);
					
					modelPanel.add(head,BorderLayout.CENTER);
					modelPanel.add(tool,BorderLayout.SOUTH);
					modelFrame.add(modelPanel);
					modelFrame.pack();
					modelFrame.setLocationRelativeTo(null);
					modelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					modelFrame.setTitle("添加商品型号");
					modelFrame.setVisible(true);
					
					jbtModelAssure.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							CommodityController commodity=new CommodityController();
							String modelInfo=newModelField.getText();
							String storehouseInfo=newStorehouseField.getText();
							int warmingInfo=Integer.parseInt(newWarmingField.getText());
							
							CommodityModelVO modelvo=new CommodityModelVO(vo.getId(),modelInfo,storehouseInfo,warmingInfo,0,0,0,0,0);
							ResultMessage result=commodity.addModel(modelvo);
							if(result==ResultMessage.Success)
							{
								JOptionPane.showMessageDialog(null, "添加成功");
								modelFrame.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "添加失败");
							}
						}
					});
				}
				else
				{
					JOptionPane.showMessageDialog(null, "未选择目标商品");
				}
			}
		});*/
		//12,19
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jTable.getSelectedRow()>=0)
				{
					CommodityController commodity=new CommodityController();
					CommodityVO vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(), 0));
					ResultMessage result=commodity.deleteCommodity(vo);
					if(result==ResultMessage.Success)
					{
						JOptionPane.showMessageDialog(null, "删除成功");
						tableModel.removeRow(jTable.getSelectedRow());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "未选择目标商品");
				}
			}
		});
		//hehe
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityController commodity=new CommodityController();
				vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(),0));
				updateFrame=new JFrame();
				updatePanel=new JPanel(new BorderLayout());
				JPanel updateTop=new JPanel(new BorderLayout());
				JPanel updateTopPanel=new JPanel(new GridLayout(3,2));
				updateTitle=new JLabel("商品信息");
				
				updateID=new JLabel("商品编号");
				updateName=new JLabel("商品名称");
				updateType=new JLabel("商品类型");
				updateIDField=new JTextField(vo.getId());
				updateNameField=new JTextField(vo.getName());
				updateType=new JLabel(vo.getType());
				jbtAddModel=new JButton("增加");
				jbtDeleteModel=new JButton("删除");
				jbtUpdateModel=new JButton("修改");
				jbtUpdateAssure=new JButton("确定");
				jbtUpdateCancel=new JButton("取消");
				jbtUpdateModelAssure=new JButton("确定");
				jbtUpdateModelCancel=new JButton("取消");
				updateTopPanel.add(updateID);
				updateTopPanel.add(updateIDField);
				updateTopPanel.add(updateName);
				updateTopPanel.add(updateNameField);
				updateTopPanel.add(updateType);
				updateTopPanel.add(updateTypeField);
				updateTop.add(updateTitle,BorderLayout.NORTH);
				updateTop.add(updateTopPanel,BorderLayout.CENTER);
				String[] modelColumn={"商品","型号","仓库","报警线","库存数量"};
				ArrayList<CommodityModelVO> modelList=vo.getList();
				int modelNum=modelList.size();
				Object[][] modelRow=new Object[modelNum][5];
				for(int i=0;i<modelNum;i++)
				{
					modelRow[i][0]=modelList.get(i).getCommodity();
					modelRow[i][1]=modelList.get(i).getModel();
					modelRow[i][2]=modelList.get(i).getStorehouse();
					modelRow[i][3]=modelList.get(i).getNoticeNumber();
					modelRow[i][4]=modelList.get(i).getStockNumber();
				}
				updateModelTableModel=new DefaultTableModel(modelRow,modelColumn);
				updateModelTable=new JTable(updateModelTableModel);
				JScrollPane JSUpdateModelTable=new JScrollPane(updateModelTable);
				JPanel updateMiddle=new JPanel(new BorderLayout());
				JPanel updateMiddleButtons=new JPanel();
				updateMiddleButtons.add(jbtAddModel);
				updateMiddleButtons.add(jbtUpdateModel);
				updateMiddleButtons.add(jbtDeleteModel);
				updateMiddle.add(JSUpdateModelTable,BorderLayout.CENTER);
				updateMiddle.add(updateMiddleButtons,BorderLayout.SOUTH);
				
				JPanel updateButtons=new JPanel();
				updateButtons.add(jbtUpdateAssure);
				updateButtons.add(jbtUpdateCancel);
				updatePanel.add(updateTop,BorderLayout.NORTH);
				updatePanel.add(updateMiddle,BorderLayout.CENTER);
				updatePanel.add(updateButtons,BorderLayout.SOUTH);
				updateFrame.add(updatePanel);
				
				updateFrame.pack();
				updateFrame.setLocationRelativeTo(null);
				updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateFrame.setTitle("更新商品");
				updateFrame.setVisible(true);
				//等待代码转移
				jbtAddModel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CommodityController commodity=new CommodityController();
						if(updateModelTable.getSelectedRow()>=0)
						{
							modelFrame=new JFrame();
							newModel=new JLabel("新类型名称");
							newStorehouse=new JLabel("所属仓库");
							newWarming=new JLabel("库存报警线");
							newModelField=new JTextField();
							newStorehouseField=new JTextField();
							newWarmingField=new JTextField();
							jbtModelAssure=new JButton("确定");
							jbtModelCancel=new JButton("取消");
							JPanel modelPanel=new JPanel(new BorderLayout());
							JPanel head=new JPanel(new GridLayout(3,2));
							JPanel tool=new JPanel(new GridLayout(1,2));
							
							head.add(newModel);
							head.add(newModelField);
							head.add(newStorehouse);
							head.add(newStorehouseField);
							head.add(newWarming);
							head.add(newWarmingField);
							tool.add(jbtModelAssure);
							tool.add(jbtModelCancel);
							
							modelPanel.add(head,BorderLayout.CENTER);
							modelPanel.add(tool,BorderLayout.SOUTH);
							modelFrame.add(modelPanel);
							modelFrame.pack();
							modelFrame.setLocationRelativeTo(null);
							modelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							modelFrame.setTitle("添加商品型号");
							modelFrame.setVisible(true);
							
							jbtModelAssure.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									CommodityController commodity=new CommodityController();
									String modelInfo=newModelField.getText();
									String storehouseInfo=newStorehouseField.getText();
									int warmingInfo=Integer.parseInt(newWarmingField.getText());
									
									CommodityModelVO modelvo=new CommodityModelVO(vo.getId(),modelInfo,storehouseInfo,warmingInfo,0,0,0,0,0);
									ResultMessage result=commodity.addModel(modelvo);
									if(result==ResultMessage.Success)
									{
										JOptionPane.showMessageDialog(null, "添加成功");
										modelFrame.dispose();
									}
									else
									{
										JOptionPane.showMessageDialog(null, "添加失败");
									}
								}
							});
						}
						else
						{
							JOptionPane.showMessageDialog(null, "未选择目标商品");
						}
					}
				});
				
				jbtDeleteModel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CommodityController commodity=new CommodityController();
						CommodityModelVO returnvo=commodity.getModel(vo.getId(),(String)updateModelTable.getValueAt(updateModelTable.getSelectedRow(),1));
						ResultMessage result=commodity.deleteModel(vo.getId(), returnvo.getModel());
						if(result==ResultMessage.Success)
						{
							JOptionPane.showMessageDialog(null, "删除成功");
					        updateModelTableModel.removeRow(updateModelTable.getSelectedRow());
						}
						else
						{
							JOptionPane.showMessageDialog(null, "删除失败");
						}
					}
				});
				
				jbtUpdateModel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CommodityController commodity=new CommodityController();
						modelvo=commodity.getModel(vo.getId(),(String)updateModelTable.getValueAt(updateModelTable.getSelectedRow(),1));
						updateModelFrame=new JFrame();
						updateModelPanel=new JPanel(new BorderLayout());
						JPanel updateModelCenter=new JPanel(new GridLayout(2,4));
						JPanel updateModelButtons=new JPanel();
						updateCommodity=new JLabel("商品名");
						updateModel=new JLabel("型号");
						updateStorehouse=new JLabel("仓库");
						updateNoticeNumber=new JLabel("库存报警线");
						updateCommodityField=new JTextField(modelvo.getCommodity());
						updateCommodityField.setEditable(false);
						updateModelField=new JTextField(modelvo.getModel());
						updateNoticeNumberField=new JTextField(modelvo.getNoticeNumber());
						//枚举未完成！
						updateStorehouseField=new JComboBox();
						updateModelCenter.add(updateCommodity);
						updateModelCenter.add(updateCommodityField);
						updateModelCenter.add(updateModel);
						updateModelCenter.add(updateModelField);
						updateModelCenter.add(updateStorehouse);
						updateModelCenter.add(updateStorehouseField);
						updateModelCenter.add(updateNoticeNumber);
						updateModelCenter.add(updateStorehouseField);
						updateModelButtons.add(jbtUpdateModelAssure);
						updateModelButtons.add(jbtUpdateModelCancel);
						updateModelPanel.add(updateModelCenter,BorderLayout.CENTER);
						updateModelPanel.add(updateModelButtons,BorderLayout.SOUTH);
						updateModelFrame.add(updateModelPanel);
						
						updateModelFrame.pack();
						updateModelFrame.setLocationRelativeTo(null);
						updateModelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						updateModelFrame.setTitle("修改型号");
						updateModelFrame.setVisible(true);
						
						jbtUpdateModelAssure.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								String beforeName=modelvo.getModel();
								CommodityController commodity=new CommodityController();
								modelvo.setModel(updateModelField.getText());
								modelvo.setStorehouse(updateStorehouse.getText());
								modelvo.setNoticeNumber(Integer.parseInt(updateNoticeNumber.getText()));
								ResultMessage result=commodity.updateModel(beforeName, modelvo);
								if(result==ResultMessage.Success)
								{
									JOptionPane.showMessageDialog(null, "修改成功");
									updateModelFrame.dispose();
									//flash
								}
								else
								{
									JOptionPane.showMessageDialog(null, "修改失败");
								}
							}
						});
						jbtUpdateModelCancel.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								updateModelFrame.dispose();
							}
						});
					}
				});
				jbtUpdateAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						CommodityController commodity=new CommodityController();
						vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(),0));
						vo.setId(updateIDField.getText());
						vo.setName(updateNameField.getText());
						vo.setType(updateTypeField.getText());
						ResultMessage result=commodity.updateCommodity(vo);
						if(result==ResultMessage.Success)
						{
							JOptionPane.showMessageDialog(null, "修改成功");
							updateFrame.dispose();
							//flash
						}
						else
						{
							JOptionPane.showMessageDialog(null, "修改失败");
						}
					}
				});
				jbtUpdateCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						updateFrame.dispose();
					}
				});
			}
		});
		
	}
	void this_mousePressed(MouseEvent e){
		int mods=e.getModifiers();
		if((mods&InputEvent.BUTTON3_DOWN_MASK)!=0){
			popupMenu.show(this, e.getX(), e.getY());
		}
	}
}

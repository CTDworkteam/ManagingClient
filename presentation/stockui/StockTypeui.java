package stockui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import vo.CommodityTypeVO;
import vo.CommodityVO;
import commoditybl.CommodityController;
import commoditytypebl.CommodityTypeController;
import enumType.ResultMessage;

class StockTypeui extends JPanel{
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
	
	//checkFrame的属性：
	JFrame checkFrame=new JFrame();
	String[] checkColumn={"编号","名称"};
	Object[][] rowData={{}};
	DefaultTableModel checkTableModel=new DefaultTableModel(rowData,checkColumn);
	JTable checkTable=new JTable(checkTableModel);
	JScrollPane checkTableJS=new JScrollPane(checkTable);
	JButton jbtcheckAssure=new JButton("确定");
	JPanel checkPanel=new JPanel(new BorderLayout());
	
	//searchFrame的属性：
	JFrame searchFrame=new JFrame();
	JPanel searchPanel=new JPanel(new BorderLayout());
	JPanel searchTopInfo=new JPanel(new GridLayout(1,2));
	JPanel searchButtons=new JPanel();
	String[][] emptyRowData={{}};
	String[] searchColumn={"分类名称","分类编号"};
	DefaultTableModel searchTableModel=new DefaultTableModel(emptyRowData,searchColumn);
	JTable searchTable=new JTable(searchTableModel);
	JScrollPane searchTableJS=new JScrollPane(searchTable);
	JButton jbtNextFloor=new JButton("查看");
	JButton jbtCancelFloor=new JButton("取消");
	JLabel topInfo1;
	JLabel topInfo2;
	
	//vosFrame的属性：
	JFrame vosFrame=new JFrame();
	JPanel vosPanel=new JPanel(new BorderLayout());
	JPanel vosButtons=new JPanel();
	JLabel vosTitle=new JLabel("搜索结果");
	JButton jbtEnter=new JButton("查看");
	JButton jbtNotEnter=new JButton("取消");
	DefaultTableModel vosTableModel=new DefaultTableModel(emptyRowData,searchColumn);
	JTable vosTable=new JTable(vosTableModel);
	JScrollPane vosTableJS=new JScrollPane(vosTable);
	
	//endFrame的属性：
	JFrame endFrame=new JFrame();
	JPanel endPanel=new JPanel(new BorderLayout());
	JPanel endButtons=new JPanel();
	JPanel endTopInfo=new JPanel(new GridLayout(1,2));
	String[] endColumn={"商品名称","商品编号"};
	DefaultTableModel endTableModel=new DefaultTableModel(emptyRowData,endColumn);
	JTable endTable=new JTable(endTableModel);
	JScrollPane endTableJS=new JScrollPane(endTable);
	JButton jbtEnd=new JButton("确定");
	JLabel typeInfo1;
	JLabel typeInfo2;
	
	//updateFrame的属性：
	JFrame updateFrame;
	JPanel updatePanel=new JPanel(new GridLayout(3,1));
	JLabel updateLabel=new JLabel("输入所选分类的新名称");
	JTextField updateField=new JTextField();
	JButton jbtUpdateAssure=new JButton("确定");
	JButton jbtUpdateCancel=new JButton("取消");
	
	JPopupMenu popupMenu;
	
	StockTypeui(){
		CommodityTypeController commodityType=new CommodityTypeController();
		DefaultMutableTreeNode type=new DefaultMutableTreeNode("商品分类");
	/*	type.add(new DefaultMutableTreeNode("分类1"));
		type.add(new DefaultMutableTreeNode("分类2"));
		type.add(new DefaultMutableTreeNode("分类3"));*/
		jTree=new JTree(type);
		ArrayList<CommodityTypeVO> allType=commodityType.getAllCommodityType();
		ArrayList<CommodityTypeVO> allRootType=new ArrayList<CommodityTypeVO>();
		for(int i=0;i<allType.size();i++)
		{
			if(allType.get(i).isRootNode())
				allRootType.add(allType.get(i));
		}
		for(int i=0;i<allRootType.size();i++)
		{
			DefaultMutableTreeNode headNode=new DefaultMutableTreeNode(allRootType.get(i).getName()+" "+allRootType.get(i).getId());
		    type.add(headNode);
		    initialTree(headNode,allRootType.get(i).getChild());
		}
		
		//刷新：
		//右键菜单：
				popupMenu=new JPopupMenu();
				JMenuItem popFlash=new JMenuItem("刷新");
				popupMenu.add(popFlash);
				add(popupMenu);
				popFlash.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						CommodityTypeController commodityType=new CommodityTypeController();
						DefaultMutableTreeNode type=new DefaultMutableTreeNode("商品分类");
					    jTree=new JTree(type);
						ArrayList<CommodityTypeVO> allType=commodityType.getAllCommodityType();
						ArrayList<CommodityTypeVO> allRootType=new ArrayList<CommodityTypeVO>();
						for(int i=0;i<allType.size();i++)
						{
							if(allType.get(i).isRootNode())
								allRootType.add(allType.get(i));
						}
						for(int i=0;i<allRootType.size();i++)
						{
							DefaultMutableTreeNode headNode=new DefaultMutableTreeNode(allRootType.get(i).getName()+" "+allRootType.get(i).getId());
						    type.add(headNode);
						    initialTree(headNode,allRootType.get(i).getChild());
						}
						
					}
				});
				this.addMouseListener(new java.awt.event.MouseAdapter(){
					public void mousePressed(MouseEvent e){
						this_mousePressed(e);
					}
				});
		
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
	//12.29
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			    CommodityTypeVO returnvo;
			    ArrayList<CommodityTypeVO> returnvos;
				CommodityTypeController commodityType=new CommodityTypeController();
				if(IDField.getText()!="")
				{
					returnvo=commodityType.findInID(IDField.getText());
					//显示结果！！！！！！！！！！！！！！！
					
					//依次初始化组件：
					vosFrame=new JFrame();
					vosPanel=new JPanel(new BorderLayout());
					vosButtons=new JPanel();
					vosTitle=new JLabel("搜索结果");
					jbtEnter=new JButton("查看");
					jbtNotEnter=new JButton("取消");
					vosTableModel=new DefaultTableModel(emptyRowData,searchColumn);
					vosTable=new JTable(vosTableModel);
					vosTableJS=new JScrollPane(vosTable);
					

					searchFrame=new JFrame();
					searchPanel=new JPanel(new BorderLayout());
					searchTopInfo=new JPanel(new GridLayout(1,2));
					searchButtons=new JPanel();
					searchTableModel=new DefaultTableModel(emptyRowData,searchColumn);
					searchTable=new JTable(searchTableModel);
					searchTableJS=new JScrollPane(searchTable);
					jbtNextFloor=new JButton("查看");
					jbtCancelFloor=new JButton("取消");
					topInfo1=new JLabel();
					topInfo2=new JLabel();
					
					searchTopInfo.add(topInfo1);
					searchTopInfo.add(topInfo2);
					searchButtons.add(jbtNextFloor);
					searchButtons.add(jbtCancelFloor);
					searchPanel.add(searchTopInfo,BorderLayout.NORTH);
					searchPanel.add(searchTableJS,BorderLayout.CENTER);
					searchPanel.add(searchButtons,BorderLayout.SOUTH);
					searchFrame.add(searchPanel);
					
					
					endFrame=new JFrame();
					endPanel=new JPanel(new BorderLayout());
					endButtons=new JPanel();
				    endTopInfo=new JPanel(new GridLayout(1,2));
					endTableModel=new DefaultTableModel(emptyRowData,endColumn);
					endTable=new JTable(endTableModel);
					endTableJS=new JScrollPane(endTable);
					jbtEnd=new JButton("确定");
					typeInfo1=new JLabel();
					typeInfo2=new JLabel();
					
					endTopInfo.add(typeInfo1);
					endTopInfo.add(typeInfo2);
					endButtons.add(jbtEnd);
					endPanel.add(endTopInfo,BorderLayout.NORTH);
					endPanel.add(endTableJS,BorderLayout.CENTER);
					endPanel.add(endButtons,BorderLayout.SOUTH);
					endFrame.add(endPanel);
					
					vosButtons.add(jbtEnter);
					vosButtons.add(jbtNotEnter);
					vosPanel.add(vosTitle,BorderLayout.NORTH);
					vosPanel.add(vosTableJS,BorderLayout.CENTER);
					vosPanel.add(vosButtons,BorderLayout.SOUTH);
					vosFrame.add(vosPanel);
			//缺少无效提示：		int resultNum=returnvos.size();
			/*		if(resultNum==0)
						JOptionPane.showMessageDialog(null, "未找到目标");
					else
					{
					for(int i=0;i<resultNum;i++)
					 {
					   String[] resultRow={returnvos.get(i).getName(),returnvos.get(i).getId()};
					   vosTableModel.addRow(resultRow);
					 }*/
					String[] resultRow={returnvo.getName(),returnvo.getId()};
				    vosTableModel.addRow(resultRow);
					   
					vosFrame.pack();
					vosFrame.setLocationRelativeTo(null);
					vosFrame.setTitle("搜索结果");
					vosFrame.setVisible(true);
					vosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					jbtEnter.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							CommodityTypeController commodityType=new CommodityTypeController();
							ArrayList<CommodityTypeVO> insArray=commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).getChild();
							if(!commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).isLeafNode())
							{
								String insName=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),0);
								String insId=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1);
								topInfo1=new JLabel("上一级名称："+insName);
								topInfo2=new JLabel("上一级编号："+insId);
								int rowNum=vosTableModel.getRowCount();
								for(int i=0;i<rowNum;i++)
									vosTableModel.removeRow(0);
								vosFrame.dispose();
								
						        int typeNum=insArray.size();
						        for(int i=0;i<typeNum;i++)
						        {
						        	Object[] insRow={insArray.get(i).getName(),insArray.get(i).getId()};
						        	searchTableModel.addRow(insRow);
						        }
						        searchFrame.pack();
						        searchFrame.setLocationRelativeTo(null);
						        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        searchFrame.setTitle("搜索结果");
						        searchFrame.setVisible(true);
								
						        jbtNextFloor.addActionListener(new ActionListener(){
						        	public void actionPerformed(ActionEvent e){
						        		CommodityTypeController commodityType=new CommodityTypeController();
										ArrayList<CommodityVO> insArray=commodityType.findInID((String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1)).getCommodityList();
										if(!commodityType.findInID((String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1)).isLeafNode())
										{
											int rowNum=searchTableModel.getRowCount();
											for(int i=0;i<rowNum;i++)
												searchTableModel.removeRow(0);
											
									        int typeNum=insArray.size();
									        for(int i=0;i<typeNum;i++)
									        {
									        	Object[] insRow={insArray.get(i).getName(),insArray.get(i).getId()};
									        	searchTableModel.addRow(insRow);
									        }
										}
										else
										{
											searchFrame.dispose();
											String insName=(String)searchTableModel.getValueAt(searchTable.getSelectedRow(),0);
											String insId=(String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1);
											typeInfo1=new JLabel("上一级名称："+insName);
											typeInfo2=new JLabel("上一级编号："+insId);
											ArrayList<CommodityVO> endArray=commodityType.findInID((String)searchTableModel.getValueAt(vosTable.getSelectedRow(),1)).getCommodityList();
											int endNum=endArray.size();
											for(int i=0;i<endNum;i++)
											{
												Object[] insRow={endArray.get(i).getName(),endArray.get(i).getId()};
												endTableModel.addRow(insRow);
											}
											endFrame.pack();
											endFrame.setLocationRelativeTo(null);
											endFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
											endFrame.setTitle("搜索结果");
											endFrame.setVisible(true);
											
											jbtEnd.addActionListener(new ActionListener(){
												public void actionPerformed(ActionEvent e){
													endFrame.dispose();
												}
											});
										}
						        	}
						        });
						        jbtCancelFloor.addActionListener(new ActionListener(){
						        	public void actionPerformed(ActionEvent e){
						        		searchFrame.dispose();
						        	}
						        });
							}
							else
							{
								vosFrame.dispose();
								String insName=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),0);
								String insId=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1);
								typeInfo1=new JLabel("上一级名称："+insName);
								typeInfo2=new JLabel("上一级编号："+insId);
								ArrayList<CommodityVO> endArray=commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).getCommodityList();
								int endNum=endArray.size();
								for(int i=0;i<endNum;i++)
								{
									Object[] insRow={endArray.get(i).getName(),endArray.get(i).getId()};
									endTableModel.addRow(insRow);
								}
								endFrame.pack();
								endFrame.setLocationRelativeTo(null);
								endFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								endFrame.setTitle("搜索结果");
								endFrame.setVisible(true);
								
								jbtEnd.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										endFrame.dispose();
									}
								});
							}
						}
					});
					
				}
				else
				{
					returnvos=commodityType.findInKeyword(nameField.getText());
					//依次初始化组件：
					vosFrame=new JFrame();
					vosPanel=new JPanel(new BorderLayout());
					vosButtons=new JPanel();
					vosTitle=new JLabel("搜索结果");
					jbtEnter=new JButton("查看");
					jbtNotEnter=new JButton("取消");
					vosTableModel=new DefaultTableModel(emptyRowData,searchColumn);
					vosTable=new JTable(vosTableModel);
					vosTableJS=new JScrollPane(vosTable);
					

					searchFrame=new JFrame();
					searchPanel=new JPanel(new BorderLayout());
					searchTopInfo=new JPanel(new GridLayout(1,2));
					searchButtons=new JPanel();
					searchTableModel=new DefaultTableModel(emptyRowData,searchColumn);
					searchTable=new JTable(searchTableModel);
					searchTableJS=new JScrollPane(searchTable);
					jbtNextFloor=new JButton("查看");
					jbtCancelFloor=new JButton("取消");
					topInfo1=new JLabel();
					topInfo2=new JLabel();
					
					searchTopInfo.add(topInfo1);
					searchTopInfo.add(topInfo2);
					searchButtons.add(jbtNextFloor);
					searchButtons.add(jbtCancelFloor);
					searchPanel.add(searchTopInfo,BorderLayout.NORTH);
					searchPanel.add(searchTableJS,BorderLayout.CENTER);
					searchPanel.add(searchButtons,BorderLayout.SOUTH);
					searchFrame.add(searchPanel);
					
					
					endFrame=new JFrame();
					endPanel=new JPanel(new BorderLayout());
					endButtons=new JPanel();
				    endTopInfo=new JPanel(new GridLayout(1,2));
					endTableModel=new DefaultTableModel(emptyRowData,endColumn);
					endTable=new JTable(endTableModel);
					endTableJS=new JScrollPane(endTable);
					jbtEnd=new JButton("确定");
					typeInfo1=new JLabel();
					typeInfo2=new JLabel();
					
					endTopInfo.add(typeInfo1);
					endTopInfo.add(typeInfo2);
					endButtons.add(jbtEnd);
					endPanel.add(endTopInfo,BorderLayout.NORTH);
					endPanel.add(endTableJS,BorderLayout.CENTER);
					endPanel.add(endButtons,BorderLayout.SOUTH);
					endFrame.add(endPanel);
					
					vosButtons.add(jbtEnter);
					vosButtons.add(jbtNotEnter);
					vosPanel.add(vosTitle,BorderLayout.NORTH);
					vosPanel.add(vosTableJS,BorderLayout.CENTER);
					vosPanel.add(vosButtons,BorderLayout.SOUTH);
					vosFrame.add(vosPanel);
					int resultNum=returnvos.size();
					if(resultNum==0)
						JOptionPane.showMessageDialog(null, "未找到目标");
					else
					{
					for(int i=0;i<resultNum;i++)
					 {
					   String[] resultRow={returnvos.get(i).getName(),returnvos.get(i).getId()};
					   vosTableModel.addRow(resultRow);
					 }
					vosFrame.pack();
					vosFrame.setLocationRelativeTo(null);
					vosFrame.setTitle("搜索结果");
					vosFrame.setVisible(true);
					vosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
					jbtEnter.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							CommodityTypeController commodityType=new CommodityTypeController();
							ArrayList<CommodityTypeVO> insArray=commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).getChild();
							if(!commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).isLeafNode())
							{
								String insName=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),0);
								String insId=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1);
								topInfo1=new JLabel("上一级名称："+insName);
								topInfo2=new JLabel("上一级编号："+insId);
								int rowNum=vosTableModel.getRowCount();
								for(int i=0;i<rowNum;i++)
									vosTableModel.removeRow(0);
								vosFrame.dispose();
								
						        int typeNum=insArray.size();
						        for(int i=0;i<typeNum;i++)
						        {
						        	Object[] insRow={insArray.get(i).getName(),insArray.get(i).getId()};
						        	searchTableModel.addRow(insRow);
						        }
						        searchFrame.pack();
						        searchFrame.setLocationRelativeTo(null);
						        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        searchFrame.setTitle("搜索结果");
						        searchFrame.setVisible(true);
								
						        jbtNextFloor.addActionListener(new ActionListener(){
						        	public void actionPerformed(ActionEvent e){
						        		CommodityTypeController commodityType=new CommodityTypeController();
										ArrayList<CommodityVO> insArray=commodityType.findInID((String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1)).getCommodityList();
										if(!commodityType.findInID((String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1)).isLeafNode())
										{
											int rowNum=searchTableModel.getRowCount();
											for(int i=0;i<rowNum;i++)
												searchTableModel.removeRow(0);
											
									        int typeNum=insArray.size();
									        for(int i=0;i<typeNum;i++)
									        {
									        	Object[] insRow={insArray.get(i).getName(),insArray.get(i).getId()};
									        	searchTableModel.addRow(insRow);
									        }
										}
										else
										{
											searchFrame.dispose();
											String insName=(String)searchTableModel.getValueAt(searchTable.getSelectedRow(),0);
											String insId=(String)searchTableModel.getValueAt(searchTable.getSelectedRow(),1);
											typeInfo1=new JLabel("上一级名称："+insName);
											typeInfo2=new JLabel("上一级编号："+insId);
											ArrayList<CommodityVO> endArray=commodityType.findInID((String)searchTableModel.getValueAt(vosTable.getSelectedRow(),1)).getCommodityList();
											int endNum=endArray.size();
											for(int i=0;i<endNum;i++)
											{
												Object[] insRow={endArray.get(i).getName(),endArray.get(i).getId()};
												endTableModel.addRow(insRow);
											}
											endFrame.pack();
											endFrame.setLocationRelativeTo(null);
											endFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
											endFrame.setTitle("搜索结果");
											endFrame.setVisible(true);
											
											jbtEnd.addActionListener(new ActionListener(){
												public void actionPerformed(ActionEvent e){
													endFrame.dispose();
												}
											});
										}
						        	}
						        });
						        jbtCancelFloor.addActionListener(new ActionListener(){
						        	public void actionPerformed(ActionEvent e){
						        		searchFrame.dispose();
						        	}
						        });
							}
							else
							{
								vosFrame.dispose();
								String insName=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),0);
								String insId=(String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1);
								typeInfo1=new JLabel("上一级名称："+insName);
								typeInfo2=new JLabel("上一级编号："+insId);
								ArrayList<CommodityVO> endArray=commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).getCommodityList();
								int endNum=endArray.size();
								for(int i=0;i<endNum;i++)
								{
									Object[] insRow={endArray.get(i).getName(),endArray.get(i).getId()};
									endTableModel.addRow(insRow);
								}
								endFrame.pack();
								endFrame.setLocationRelativeTo(null);
								endFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								endFrame.setTitle("搜索结果");
								endFrame.setVisible(true);
								
								jbtEnd.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										endFrame.dispose();
									}
								});
							}
						}
					});
					}
				////实现显示所查询,换种方式如何(前缀与含有)
		/*		TreePath path=jTree.getNextMatch(nameField.getText(),0, null);
				while(path!=null)
				  {
					DefaultMutableTreeNode matchNode=(DefaultMutableTreeNode)path.getLastPathComponent();
					jTree.addSelectionPath(path);
					path=jTree.getNextMatch(nameField.getText(), jTree.getRowForPath(path),null);
				  }    */
				//点击查看：
				
				}
			}
		});
    //12.29
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				checkFrame=new JFrame();
				String[] checkColumn={"编号","名称"};
				Object[][] rowData={{}};
				checkTableModel=new DefaultTableModel(rowData,checkColumn);
				checkTable=new JTable(checkTableModel);
				checkTableJS=new JScrollPane(checkTable);
				jbtcheckAssure=new JButton("确定");
				checkPanel=new JPanel(new BorderLayout());
				JPanel checkButtons=new JPanel();
				checkButtons.add(jbtcheckAssure);
				checkPanel.add(checkTableJS,BorderLayout.CENTER);
				checkPanel.add(checkButtons,BorderLayout.SOUTH);
				checkFrame.add(checkPanel);
				
				parent=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
				String[] parentInfo=parent.toString().split(" ");
				if(parent==null)
				{
					JOptionPane.showMessageDialog(null, "未选择目标分类");
				}
				else
				{
					checkFrame.pack();
					checkFrame.setLocationRelativeTo(null);
					checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					checkFrame.setTitle("查看分类");
					checkFrame.setVisible(true);
					
					CommodityTypeController commodityType=new CommodityTypeController();
					CommodityTypeVO vo=commodityType.findInID(parentInfo[1]);
					if(vo.isLeafNode())
					{
						ArrayList<CommodityVO> checkCommodity=vo.getCommodityList();
						int commodityNum=checkCommodity.size();
						for(int i=0;i<commodityNum;i++)
						{
							Object[] insRow={checkCommodity.get(i).getId(),checkCommodity.get(i).getName()};
							checkTableModel.addRow(insRow);
						}
					}
				}
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
						CommodityTypeController commodityType=new CommodityTypeController();
				        String[] parentInfo=parent.toString().split(" ");
					    CommodityTypeVO vo=new CommodityTypeVO(commodityType.getNewID(parentInfo[1]),newNameField.getText(),false,true,new ArrayList<CommodityVO>(),commodityType.findInID(parentInfo[1]),new ArrayList<CommodityTypeVO>());
						ResultMessage result=commodityType.addType(vo);
					    String addName=newNameField.getText();
					    
					    if(result==ResultMessage.Success){
						parent.add(new DefaultMutableTreeNode(addName+" "+newIDField.getText()));
						((DefaultTreeModel)(jTree.getModel())).reload();
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(null, "添加失败");
					    }
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
	//！！！！！！！！！！！！！！！！！！！！！！！！！！关于分类下商品
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityTypeController commodityType=new CommodityTypeController();
				TreePath[] paths=jTree.getSelectionPaths();
				ResultMessage result=ResultMessage.Failure;
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
					{
						
						String[] parentInfo=node.getParent().toString().split(" ");
						String[] typeInfo=node.toString().split(" ");
					/*	if(node.isLeaf()){
							if(node.isRoot()){
								CommodityTypeVO vo=commodityType.findInID(typeInfo[1]);
								result=commodityType.deleteType(vo);
							}
							else
							{
								CommodityTypeVO vo=new CommodityTypeVO(typeInfo[1],typeInfo[0],false,true,new ArrayList<String>(),parentInfo[0],new ArrayList<String>());	
								result=commodityType.deleteType(vo);
							}
							}
						else
						{
							int childNum=node.getChildCount();
							ArrayList<String> childs=new ArrayList<String>();
							for(int o=0;o<childNum;o++)
							{
								String[] childName=node.getChildAt(o).toString().split(" ");
								childs.add(childName[0]);
							}
							CommodityTypeVO vo=new CommodityTypeVO(typeInfo[1],typeInfo[0],false,false,new ArrayList<String>(),parentInfo[0],childs);
							result=commodityType.deleteType(vo);*/
						CommodityTypeVO vo=commodityType.findInID(typeInfo[1]);
					    result=commodityType.deleteType(vo);
					}
					if(result==ResultMessage.Success)
						node.removeFromParent();
					else
						JOptionPane.showMessageDialog(null, "删除失败");
						
					}
				
				((DefaultTreeModel)(jTree.getModel())).reload();
			}
		});
		
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateFrame=new JFrame();
				updatePanel=new JPanel(new GridLayout(3,1));
				updateLabel=new JLabel("输入所选分类的新名称");
				JPanel updateButtons=new JPanel();
				updateField=new JTextField();
				jbtUpdateAssure=new JButton("确定");
				
				updatePanel.add(updateLabel);
				updateButtons.add(jbtUpdateAssure);
				updateButtons.add(jbtUpdateCancel);
				updatePanel.add(updateField);
				updatePanel.add(updateButtons);
				updateFrame.add(updatePanel);
				
				parent=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
				if(parent==null)
				{
					JOptionPane.showMessageDialog(null, "未选择目标分类");
				}
				else
				{
				    updateFrame.pack();
				    updateFrame.setLocationRelativeTo(null);
				    updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    updateFrame.setTitle("更新分类");
				    updateFrame.setVisible(true);
				    
				    jbtUpdateAssure.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent e){
				    		CommodityTypeController commodityType=new CommodityTypeController();
				    		String[] parentInfo=parent.toString().split(" ");
				    		CommodityTypeVO vo=commodityType.findInID(parentInfo[1]);
				    		vo.setName(updateField.getText());
				    		ResultMessage result=commodityType.updateType(vo);
				    		if(result==ResultMessage.Success)
				    		{
				    			JOptionPane.showMessageDialog(null,"修改成功");
				    		}
				    		else
				    		{
				    			JOptionPane.showMessageDialog(null, "添加失败");
				    		}
				    	}
				    });
				    jbtUpdateCancel.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent e){
				    		updateFrame.dispose();
				    	}
				    });
				}
			}
		});
	}
	
	public void initialTree(DefaultMutableTreeNode e,ArrayList<CommodityTypeVO> list){
		if(list.size()!=0)
		{
			int listNum=list.size();
			for(int i=0;i<listNum;i++)
			{
				DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(list.get(i).getName()+" "+list.get(i).getId());
			    e.add(newNode);
			    initialTree(newNode,list.get(i).getChild());
			}
		}
		else
		{
			
		}
	}
	void this_mousePressed(MouseEvent e){
		int mods=e.getModifiers();
		if((mods&InputEvent.BUTTON3_DOWN_MASK)!=0){
			popupMenu.show(this, e.getX(), e.getY());
		}
	}
}
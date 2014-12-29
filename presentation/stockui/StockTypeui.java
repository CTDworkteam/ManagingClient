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
	private JLabel name=new JLabel("    ������");
	private JTextField nameField=new JTextField();
	private JLabel ID=new JLabel("������");
	private JTextField IDField=new JTextField();
	private JButton jbtSearch=new JButton("����");
	private JPanel panelSearch=new JPanel(new BorderLayout());
	private JPanel panelSearch2=new JPanel(new BorderLayout());
 	private JPanel panelSearchPlus=new JPanel(new BorderLayout());
	private JPanel panelOperation=new JPanel(new GridLayout(1,4));
	private JButton jbtSee=new JButton("�鿴");
	private JButton jbtAdd=new JButton("����");
	private JButton jbtDelete=new JButton("ɾ��");
	private JButton jbtUpdate=new JButton("�޸�");
	DefaultMutableTreeNode parent;
	//insFrame�����ԣ�
	JFrame insFrame=new JFrame();
	JLabel newName=new JLabel("�·�������");
    JTextField newNameField=new JTextField();
	JLabel newID=new JLabel("�·�����");
	JTextField newIDField=new JTextField();
	JButton assure=new JButton("ȷ��");
	JButton cancel=new JButton("ȡ��");
	JPanel top=new JPanel(new GridLayout(2,2));
	JPanel down=new JPanel(new GridLayout(1,2));
	JPanel splitPane=new JPanel(new BorderLayout());
	private JPanel panelSearch3=new JPanel(new GridLayout(2,1));
	
	//checkFrame�����ԣ�
	JFrame checkFrame=new JFrame();
	String[] checkColumn={"���","����"};
	Object[][] rowData={{}};
	DefaultTableModel checkTableModel=new DefaultTableModel(rowData,checkColumn);
	JTable checkTable=new JTable(checkTableModel);
	JScrollPane checkTableJS=new JScrollPane(checkTable);
	JButton jbtcheckAssure=new JButton("ȷ��");
	JPanel checkPanel=new JPanel(new BorderLayout());
	
	//searchFrame�����ԣ�
	JFrame searchFrame=new JFrame();
	JPanel searchPanel=new JPanel(new BorderLayout());
	JPanel searchTopInfo=new JPanel(new GridLayout(1,2));
	JPanel searchButtons=new JPanel();
	String[][] emptyRowData={{}};
	String[] searchColumn={"��������","������"};
	DefaultTableModel searchTableModel=new DefaultTableModel(emptyRowData,searchColumn);
	JTable searchTable=new JTable(searchTableModel);
	JScrollPane searchTableJS=new JScrollPane(searchTable);
	JButton jbtNextFloor=new JButton("�鿴");
	JButton jbtCancelFloor=new JButton("ȡ��");
	JLabel topInfo1;
	JLabel topInfo2;
	
	//vosFrame�����ԣ�
	JFrame vosFrame=new JFrame();
	JPanel vosPanel=new JPanel(new BorderLayout());
	JPanel vosButtons=new JPanel();
	JLabel vosTitle=new JLabel("�������");
	JButton jbtEnter=new JButton("�鿴");
	JButton jbtNotEnter=new JButton("ȡ��");
	DefaultTableModel vosTableModel=new DefaultTableModel(emptyRowData,searchColumn);
	JTable vosTable=new JTable(vosTableModel);
	JScrollPane vosTableJS=new JScrollPane(vosTable);
	
	//endFrame�����ԣ�
	JFrame endFrame=new JFrame();
	JPanel endPanel=new JPanel(new BorderLayout());
	JPanel endButtons=new JPanel();
	JPanel endTopInfo=new JPanel(new GridLayout(1,2));
	String[] endColumn={"��Ʒ����","��Ʒ���"};
	DefaultTableModel endTableModel=new DefaultTableModel(emptyRowData,endColumn);
	JTable endTable=new JTable(endTableModel);
	JScrollPane endTableJS=new JScrollPane(endTable);
	JButton jbtEnd=new JButton("ȷ��");
	JLabel typeInfo1;
	JLabel typeInfo2;
	
	//updateFrame�����ԣ�
	JFrame updateFrame;
	JPanel updatePanel=new JPanel(new GridLayout(3,1));
	JLabel updateLabel=new JLabel("������ѡ�����������");
	JTextField updateField=new JTextField();
	JButton jbtUpdateAssure=new JButton("ȷ��");
	JButton jbtUpdateCancel=new JButton("ȡ��");
	
	JPopupMenu popupMenu;
	
	StockTypeui(){
		CommodityTypeController commodityType=new CommodityTypeController();
		DefaultMutableTreeNode type=new DefaultMutableTreeNode("��Ʒ����");
	/*	type.add(new DefaultMutableTreeNode("����1"));
		type.add(new DefaultMutableTreeNode("����2"));
		type.add(new DefaultMutableTreeNode("����3"));*/
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
		
		//ˢ�£�
		//�Ҽ��˵���
				popupMenu=new JPopupMenu();
				JMenuItem popFlash=new JMenuItem("ˢ��");
				popupMenu.add(popFlash);
				add(popupMenu);
				popFlash.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						CommodityTypeController commodityType=new CommodityTypeController();
						DefaultMutableTreeNode type=new DefaultMutableTreeNode("��Ʒ����");
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
					//��ʾ���������������������������������
					
					//���γ�ʼ�������
					vosFrame=new JFrame();
					vosPanel=new JPanel(new BorderLayout());
					vosButtons=new JPanel();
					vosTitle=new JLabel("�������");
					jbtEnter=new JButton("�鿴");
					jbtNotEnter=new JButton("ȡ��");
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
					jbtNextFloor=new JButton("�鿴");
					jbtCancelFloor=new JButton("ȡ��");
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
					jbtEnd=new JButton("ȷ��");
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
			//ȱ����Ч��ʾ��		int resultNum=returnvos.size();
			/*		if(resultNum==0)
						JOptionPane.showMessageDialog(null, "δ�ҵ�Ŀ��");
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
					vosFrame.setTitle("�������");
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
								topInfo1=new JLabel("��һ�����ƣ�"+insName);
								topInfo2=new JLabel("��һ����ţ�"+insId);
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
						        searchFrame.setTitle("�������");
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
											typeInfo1=new JLabel("��һ�����ƣ�"+insName);
											typeInfo2=new JLabel("��һ����ţ�"+insId);
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
											endFrame.setTitle("�������");
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
								typeInfo1=new JLabel("��һ�����ƣ�"+insName);
								typeInfo2=new JLabel("��һ����ţ�"+insId);
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
								endFrame.setTitle("�������");
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
					//���γ�ʼ�������
					vosFrame=new JFrame();
					vosPanel=new JPanel(new BorderLayout());
					vosButtons=new JPanel();
					vosTitle=new JLabel("�������");
					jbtEnter=new JButton("�鿴");
					jbtNotEnter=new JButton("ȡ��");
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
					jbtNextFloor=new JButton("�鿴");
					jbtCancelFloor=new JButton("ȡ��");
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
					jbtEnd=new JButton("ȷ��");
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
						JOptionPane.showMessageDialog(null, "δ�ҵ�Ŀ��");
					else
					{
					for(int i=0;i<resultNum;i++)
					 {
					   String[] resultRow={returnvos.get(i).getName(),returnvos.get(i).getId()};
					   vosTableModel.addRow(resultRow);
					 }
					vosFrame.pack();
					vosFrame.setLocationRelativeTo(null);
					vosFrame.setTitle("�������");
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
								topInfo1=new JLabel("��һ�����ƣ�"+insName);
								topInfo2=new JLabel("��һ����ţ�"+insId);
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
						        searchFrame.setTitle("�������");
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
											typeInfo1=new JLabel("��һ�����ƣ�"+insName);
											typeInfo2=new JLabel("��һ����ţ�"+insId);
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
											endFrame.setTitle("�������");
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
								typeInfo1=new JLabel("��һ�����ƣ�"+insName);
								typeInfo2=new JLabel("��һ����ţ�"+insId);
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
								endFrame.setTitle("�������");
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
				////ʵ����ʾ����ѯ,���ַ�ʽ���(ǰ׺�뺬��)
		/*		TreePath path=jTree.getNextMatch(nameField.getText(),0, null);
				while(path!=null)
				  {
					DefaultMutableTreeNode matchNode=(DefaultMutableTreeNode)path.getLastPathComponent();
					jTree.addSelectionPath(path);
					path=jTree.getNextMatch(nameField.getText(), jTree.getRowForPath(path),null);
				  }    */
				//����鿴��
				
				}
			}
		});
    //12.29
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				checkFrame=new JFrame();
				String[] checkColumn={"���","����"};
				Object[][] rowData={{}};
				checkTableModel=new DefaultTableModel(rowData,checkColumn);
				checkTable=new JTable(checkTableModel);
				checkTableJS=new JScrollPane(checkTable);
				jbtcheckAssure=new JButton("ȷ��");
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
					JOptionPane.showMessageDialog(null, "δѡ��Ŀ�����");
				}
				else
				{
					checkFrame.pack();
					checkFrame.setLocationRelativeTo(null);
					checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					checkFrame.setTitle("�鿴����");
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
				newName=new JLabel("�·�������");
			    newNameField=new JTextField();
				newID=new JLabel("�·�����");
				newIDField=new JTextField();
				assure=new JButton("ȷ��");
				cancel=new JButton("ȡ��");
				top=new JPanel(new GridLayout(2,2));
				down=new JPanel(new GridLayout(1,2));
				parent=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
				
				if(parent==null){
					JOptionPane.showMessageDialog(null, "Error:δѡ����һ������");
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
		//δ�������ݿ�		
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
					    	JOptionPane.showMessageDialog(null, "���ʧ��");
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
	//�������������������������������������������������������ڷ�������Ʒ
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityTypeController commodityType=new CommodityTypeController();
				TreePath[] paths=jTree.getSelectionPaths();
				ResultMessage result=ResultMessage.Failure;
				if(paths==null){
					JOptionPane.showMessageDialog(null, "Error:δѡ��Ŀ�����");
					return;
				}
				for(int i=0;i<paths.length;i++){
					DefaultMutableTreeNode node=(DefaultMutableTreeNode)(paths[i].getLastPathComponent());
					if(node.isRoot()){
						JOptionPane.showMessageDialog(null, "Error�������಻��ɾ��");
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
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						
					}
				
				((DefaultTreeModel)(jTree.getModel())).reload();
			}
		});
		
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				updateFrame=new JFrame();
				updatePanel=new JPanel(new GridLayout(3,1));
				updateLabel=new JLabel("������ѡ�����������");
				JPanel updateButtons=new JPanel();
				updateField=new JTextField();
				jbtUpdateAssure=new JButton("ȷ��");
				
				updatePanel.add(updateLabel);
				updateButtons.add(jbtUpdateAssure);
				updateButtons.add(jbtUpdateCancel);
				updatePanel.add(updateField);
				updatePanel.add(updateButtons);
				updateFrame.add(updatePanel);
				
				parent=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
				if(parent==null)
				{
					JOptionPane.showMessageDialog(null, "δѡ��Ŀ�����");
				}
				else
				{
				    updateFrame.pack();
				    updateFrame.setLocationRelativeTo(null);
				    updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    updateFrame.setTitle("���·���");
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
				    			JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
				    		}
				    		else
				    		{
				    			JOptionPane.showMessageDialog(null, "���ʧ��");
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
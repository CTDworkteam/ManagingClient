package stockui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import vo.CommodityTypeVO;
import commoditytypebl.CommodityTypeController;
import enumType.ResultMessage;

class stockTypeui extends JPanel{
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
	
	
	stockTypeui(){
		CommodityTypeController commodityType=new CommodityTypeController();
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
			    CommodityTypeVO returnvo;
			    ArrayList<CommodityTypeVO> returnvos;
				CommodityTypeController commodityType=new CommodityTypeController();
				if(IDField.getText()!="")
				{
					returnvo=commodityType.findInID(IDField.getText());
					//显示结果！！！！！！！！！！！！！！！
					
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
							ArrayList insArray=commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).getCommodityList();
							if(!commodityType.findInID((String)vosTableModel.getValueAt(vosTable.getSelectedRow(),1)).isLeafNode())
							{
								int rowNum=vosTableModel.getRowCount();
								for(int i=0;i<rowNum;i++)
									vosTableModel.removeRow(0);
								
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
						CommodityTypeController commodityType=new CommodityTypeController();
				        String[] parentInfo=parent.toString().split(" ");
					    CommodityTypeVO vo=new CommodityTypeVO(newIDField.getText(),newNameField.getText(),false,true,new ArrayList<String>(),parentInfo[0],new ArrayList<String>());
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
						ResultMessage result;
						String[] parentInfo=node.getParent().toString().split(" ");
						String[] typeInfo=node.toString().split(" ");
						if(node.isLeaf()){
							if(node.isRoot()){
								CommodityTypeVO vo=new CommodityTypeVO(typeInfo[1],typeInfo[0],true,true,new ArrayList<String>(),parentInfo[0],new ArrayList<String>());
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
							result=commodityType.deleteType(vo);
						}
					if(result==ResultMessage.Success)
						node.removeFromParent();
					else
						JOptionPane.showMessageDialog(null, "删除失败");
						
					}
				}
				((DefaultTreeModel)(jTree.getModel())).reload();
			}
		});
		//未实现:与添加一致。修改分类信息究竟修改的是什么？？？？？？？？、
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
}

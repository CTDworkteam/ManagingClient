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
	
	
	stockTypeui(){
		CommodityTypeController commodityType=new CommodityTypeController();
		DefaultMutableTreeNode type=new DefaultMutableTreeNode("��Ʒ����");
		type.add(new DefaultMutableTreeNode("����1"));
		type.add(new DefaultMutableTreeNode("����2"));
		type.add(new DefaultMutableTreeNode("����3"));
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
					//��ʾ���������������������������������
					
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
    //unfinished:
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
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
					    CommodityTypeVO vo=new CommodityTypeVO(newIDField.getText(),newNameField.getText(),false,true,new ArrayList<String>(),parentInfo[0],new ArrayList<String>());
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
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
						
					}
				}
				((DefaultTreeModel)(jTree.getModel())).reload();
			}
		});
		//δʵ��:�����һ�¡��޸ķ�����Ϣ�����޸ĵ���ʲô������������������
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
}

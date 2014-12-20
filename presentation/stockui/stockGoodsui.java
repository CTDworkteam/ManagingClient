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
import javax.swing.table.DefaultTableModel;

import vo.CommodityModelVO;
import vo.CommodityVO;
import commoditybl.CommodityController;
import enumType.ResultMessage;

class stockGoodsui extends JPanel{
//	private String[] columnName={"���","����","�ͺ�","����","��汨����","�������","����","���ۼ�","�������","������ۼ�"};
	private String[] columnName={"���","����","�ͺ�","����"};
	private Object[][] rowData={
			{00001,"������","hehe",5}
	};
	private DefaultTableModel tableModel=new DefaultTableModel(rowData,columnName);
	private JTable jTable=new JTable(tableModel);
	private JLabel tip=new JLabel("������Ʒ�ؼ���");
	private JTextField keyField=new JTextField();
	private JButton jbtSearch=new JButton("����");
	private JButton jbtSee=new JButton("�鿴");
	private JButton jbtAdd=new JButton("������Ʒ");
	private JButton jbtDelete=new JButton("ɾ��");
	private JButton jbtUpdate=new JButton("�޸�");
	private JButton jbtAddModel=new JButton("�����ͺ�");
	private JScrollPane jScrollPane=new JScrollPane(jTable);
	
	//add commdity ui
	JFrame insFrame;
	JLabel newName=new JLabel("����Ʒ����");
	JTextField nameField=new JTextField();
	JLabel newType=new JLabel("����Ʒ�ͺ�");
	JTextField typeField=new JTextField();
	JLabel newTipLine=new JLabel("��汨����");
	JTextField TipLineField=new JTextField();
	JButton jbtAssure=new JButton("ȷ��");
	JButton jbtCancel=new JButton("ȡ��");
	
	//add commdityModel ui
	JFrame modelFrame=new JFrame();
	JLabel newModel=new JLabel("����������");
	JLabel newStorehouse=new JLabel("�����ֿ�");
	JLabel newWarming=new JLabel("��汨����");
	JTextField newModelField=new JTextField();
	JTextField newStorehouseField=new JTextField();
	JTextField newWarmingField=new JTextField();
	JButton jbtModelAssure=new JButton("ȷ��");
	JButton jbtModelCancel=new JButton("ȡ��");
	
	//check the aimed commodity
	JFrame checkFrame=new JFrame();
	JLabel mainInfo;
	DefaultTableModel checkTableModel;
	JTable checkTable;
	JButton jbtCheckAssure=new JButton("ȷ��");
	
	CommodityVO vo;
	
	public stockGoodsui(){
		setLayout(new BorderLayout());
		JPanel top=new JPanel(new GridLayout(1,3));
		JPanel bottom=new JPanel(new GridLayout(1,3));
		JPanel addButtons=new JPanel(new GridLayout(2,1));
		addButtons.add(jbtAdd);
		addButtons.add(jbtAddModel);
		top.add(tip);
		top.add(keyField);
		top.add(jbtSearch);
		bottom.add(jbtSee);
		bottom.add(addButtons);
		bottom.add(jbtDelete);
		bottom.add(jbtUpdate);
		add(top,BorderLayout.NORTH);
		add(jScrollPane,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
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
					mainInfo=new JLabel("��ƷID:"+vo.getId()+" ��Ʒ����:"+vo.getName()+" ��Ʒ����:"+vo.getType()+" ��Ʒ����:"+vo.getTotal());
					checkFrame=new JFrame();
					JPanel checkPanel=new JPanel(new BorderLayout());
					JPanel checkButtons=new JPanel();
					String[] checkColumn={"�ͺ�","�ֿ�","������","�����","����","���ۼ�","�������","������ۼ�"};
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
				    checkFrame.setTitle("�鿴��Ʒ��Ϣ");
				    checkFrame.setVisible(true);
				    
				    jbtCheckAssure.addActionListener(new ActionListener(){
				    	public void actionPerformed(ActionEvent e){
				    		checkFrame.dispose();
				    	}
				    });
				}
				else
				{
					JOptionPane.showMessageDialog(null, "δѡ��Ŀ����Ʒ");
				}
			}
		});
		//12.19
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				insFrame=new JFrame();
				insFrame.pack();
				newName=new JLabel("����Ʒ����");
				nameField=new JTextField();
				newType=new JLabel("����Ʒ���");
				typeField=new JTextField();
				newTipLine=new JLabel("��Ʒ���ͱ��");
				TipLineField=new JTextField();
				jbtAssure=new JButton("ȷ��");
				jbtCancel=new JButton("ȡ��");
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
							JOptionPane.showMessageDialog(null, "���ʧ��");
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
		jbtAddModel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CommodityController commodity=new CommodityController();
				if(jTable.getSelectedRow()>=0)
				{
					vo=commodity.findCommodityByID((String)jTable.getValueAt(jTable.getSelectedRow(), 0));
					modelFrame=new JFrame();
					newModel=new JLabel("����������");
					newStorehouse=new JLabel("�����ֿ�");
					newWarming=new JLabel("��汨����");
					newModelField=new JTextField();
					newStorehouseField=new JTextField();
					newWarmingField=new JTextField();
					jbtModelAssure=new JButton("ȷ��");
					jbtModelCancel=new JButton("ȡ��");
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
					modelFrame.setTitle("�����Ʒ�ͺ�");
					modelFrame.setVisible(true);
					
					jbtModelAssure.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							CommodityController commodity=new CommodityController();
							String modelInfo=newModelField.getText();
							String storehouseInfo=newStorehouseField.getText();
							int warmingInfo=Integer.parseInt(newWarmingField.getText());
							
							CommodityModelVO modelvo=new CommodityModelVO(vo.getId(),modelInfo,storehouseInfo,warmingInfo,0,0,0,0,0);
							ResultMessage result=commodity.addModel(vo,modelvo);
							if(result==ResultMessage.Success)
							{
								JOptionPane.showMessageDialog(null, "��ӳɹ�");
								modelFrame.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "���ʧ��");
							}
						}
					});
				}
				else
				{
					JOptionPane.showMessageDialog(null, "δѡ��Ŀ����Ʒ");
				}
			}
		});
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
						JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						tableModel.removeRow(jTable.getSelectedRow());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "δѡ��Ŀ����Ʒ");
				}
			}
		});
		//δʵ�֣�!!!!!!!!!!!!!!!!!!!!!!!!!!aaaaaaaaaaaa
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}

package salesui;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import enumType.ResultMessage;
import purchasebl.PurchaseController;
import salesbl.SalesController;
import utility.Utility;
import vo.PurchaseBillVO;

class salesImportPanelui extends JPanel{
	JButton jbtImport=new JButton("销售");
	JButton jbtImportReturn=new JButton("销售退货");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JPanel importListPanel=new JPanel();
	JLabel importTitle=new JLabel("新建销售单");
	JLabel importName=new JLabel("商品名",SwingConstants.RIGHT);
	JLabel importType=new JLabel("型号",SwingConstants.RIGHT);
//	JLabel importID=new JLabel("编号",SwingConstants.RIGHT); 
	JLabel importNum=new JLabel("数量",SwingConstants.RIGHT);
	JLabel importPrice=new JLabel("单价",SwingConstants.RIGHT);
	JTextField importNameField=new JTextField("点击选择商品");
	JTextField importTypeField=new JTextField();
	JTextField importIDField=new JTextField();
	JTextField importNumField=new JTextField();
	JTextField importPriceField=new JTextField();
	JTextArea importTipArea=new JTextArea("备注");
	JPanel importTopPlusTitle=new JPanel(new BorderLayout());
	JPanel importTop=new JPanel(new GridLayout(4,2));
	JPanel importBottom=new JPanel(new BorderLayout());
	JPanel importButtons=new JPanel();
	JPanel importTotal=new JPanel(new GridLayout(2,1));
	JScrollPane TipJS=new JScrollPane(importTipArea);
	JButton jbtAssure=new JButton("提交");
	JButton jbtCancel=new JButton("取消");
	
	JPanel salesItemPanel=new JPanel(new BorderLayout());
	JPanel salesItemButtons=new JPanel();
	JLabel salesTableTitle=new JLabel("已添加商品",SwingConstants.CENTER);
	String[] salesItemColumn={"商品","型号","数量","单价","总金额","备注"};
	Object[][] salesItemRow={{}};
	DefaultTableModel salesItemTableModel=new DefaultTableModel(salesItemRow,salesItemColumn);
	JTable salesItemTable=new JTable(salesItemTableModel);
	JScrollPane salesItemJS=new JScrollPane(salesItemTable);
	JButton jbtSave=new JButton("保存");
	JButton jbtSend=new JButton("提交");
	JButton jbtCheck=new JButton("查看保存单据");
	JLabel supplier=new JLabel("客户",SwingConstants.CENTER);
	JLabel storehouse=new JLabel("仓库",SwingConstants.CENTER);
	JTextField supplierField=new JTextField();
	JTextField storehouseField=new JTextField();
	JPanel mainInfoPanel=new JPanel(new GridLayout(1,4));
	JPanel mainSubPanel=new JPanel(new BorderLayout());
	
	//importReturnFrame:
	JFrame importReturnFrame=new JFrame();
	JPanel TopPanel=new JPanel();
	JPanel returnButtons=new JPanel();
	JPanel returnTotal=new JPanel(new BorderLayout());
	JLabel returnSearch=new JLabel("退回销售单的编号");
	JTextField returnSearchField=new JTextField();
	JButton jbtReturnSearch=new JButton("搜索");
	JButton jbtReturnAssure=new JButton("确定");
	JButton jbtReturnCancel=new JButton("取消");
	String[] returnColumn={"销售单编号","商品名","商品型号","单价","数量"};
	Object[][] returnRowData={{"xxx_xxx","di","XX",30,30}};
	DefaultTableModel returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
	JTable returnTable=new JTable(returnTableModel);
	JScrollPane returnJS=new JScrollPane(returnTable);
	
	ArrayList<PurchaseBillVO> allBills;
	
	
	salesImportPanelui(){
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(jbtImport);
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel());
		mainPanel.add(jbtImportReturn);
		
		
		
		add(mainPanel);
	
		jbtImport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				importListFrame=new JFrame();
				importListPanel=new JPanel();
				importTitle=new JLabel("新建销售单");
				importName=new JLabel("商品名",SwingConstants.RIGHT);
				importType=new JLabel("型号",SwingConstants.RIGHT);
	//			importID=new JLabel("编号",SwingConstants.RIGHT); 
				importNum=new JLabel("数量",SwingConstants.RIGHT);
				importPrice=new JLabel("单价",SwingConstants.RIGHT);
				importNameField=new JTextField("点击选择商品");
				importTypeField=new JTextField();
				importIDField=new JTextField();
				importNumField=new JTextField();
				importPriceField=new JTextField();
				importTipArea=new JTextArea("备注");
				importTopPlusTitle=new JPanel(new BorderLayout());
				importTop=new JPanel(new GridLayout(5,2));
				importBottom=new JPanel(new BorderLayout());
				importButtons=new JPanel();
				importTotal=new JPanel(new GridLayout(2,1));
				TipJS=new JScrollPane(importTipArea);
				jbtAssure=new JButton("提交");
				jbtCancel=new JButton("取消");
				
				
				importTop.add(importName);
				importTop.add(importNameField);
				importTop.add(importType);
				importTop.add(importTypeField);
		//		importTop.add(importID);
		//		importTop.add(importIDField);
				importTop.add(importNum);
				importTop.add(importNumField);
				importTop.add(importPrice);
				importTop.add(importPriceField);
				importTopPlusTitle.add(importTitle,BorderLayout.NORTH);
				importTopPlusTitle.add(importTop,BorderLayout.CENTER);
				importButtons.add(jbtAssure);
				importButtons.add(jbtCancel);
				importBottom.add(TipJS,BorderLayout.CENTER);
				importBottom.add(importButtons,BorderLayout.SOUTH);
				importTotal.add(importTopPlusTitle);
				importTotal.add(importBottom);
				
				mainInfoPanel.add(supplier);
				mainInfoPanel.add(supplierField);
				mainInfoPanel.add(storehouse);
				mainInfoPanel.add(storehouseField);
			    salesItemButtons.add(jbtCheck);
				salesItemButtons.add(jbtSave);
				salesItemButtons.add(jbtSend);
				
				salesItemPanel.add(salesTableTitle,BorderLayout.NORTH);
				salesItemPanel.add(salesItemJS,BorderLayout.CENTER);
				salesItemPanel.add(mainInfoPanel,BorderLayout.SOUTH);
				mainSubPanel.add(salesItemPanel,BorderLayout.CENTER);
				mainSubPanel.add(salesItemButtons,BorderLayout.SOUTH);
				importListPanel.add(mainSubPanel);
				importListFrame.add(importListPanel);
				importListPanel.add(importTotal);
				
				importListFrame.pack();
				importListFrame.setLocationRelativeTo(null);
				importListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				importListFrame.setTitle("销售");
				importListFrame.setVisible(true);
				//12.26
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Object[] newItem={importNameField.getText(),importTypeField.getText(),importNumField.getText(),importPriceField.getText(),Double.parseDouble(importNumField.getText())*Double.parseDouble(importPriceField.getText()),importTipArea.getText()};
					    salesItemTableModel.addRow(newItem);
					}
				});
				
		/*		jbtSend.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ArrayList<SalesBillVO> vos=new ArrayList<SalesBillVO>();
						
						SalesBillVO vo=new SalesBillVO("XXX",supplierField.getText(),storehouseField.getText(),"didi",null,0,"");
						ArrayList<PurchaseBillVO.PurchaseBillItemVO> itemList=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
					    int itemNum=commodityItemTable.getRowCount();
					    for(int i=0;i<itemNum;i++){
						PurchaseBillVO.PurchaseBillItemVO items=vo.new PurchaseBillItemVO((String)commodityItemTableModel.getValueAt(i, 0),(String)commodityItemTableModel.getValueAt(i, 1),(int)commodityItemTableModel.getValueAt(i, 2),(double)commodityItemTableModel.getValueAt(i, 3),(double)commodityItemTableModel.getValueAt(i, 4),(String)commodityItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    }
					    vo.setList(itemList);
					    vos.add(vo);
					    PurchaseController purchase=new PurchaseController();
					    ResultMessage result=purchase.sendBill(vos);
					    if(result==ResultMessage.Success){
					    	JOptionPane.showMessageDialog(null, "提交成功");
					    	importListFrame.dispose();
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "提交失败");
					    
					}
				});             */
				
				
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						importListFrame.dispose();
					}
				});
				/*jbtSend.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						PurchaseController sales=new PurchaseController();
						Utility utility=new Utility();
						int itemNum=salesItemTable.getRowCount();
						double total=0;
						PurchaseBillVO insvo=new PurchaseBillVO();
						ArrayList<PurchaseBillVO.PurchaseBillItemVO> list=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
						for(int i=0;i<itemNum;i++)
						{
							PurchaseBillVO.PurchaseBillItemVO insItemVO=insvo.new PurchaseBillItemVO((String)salesItemTable.getValueAt(i, 0),(String)salesItemTable.getValueAt(i, 1),Integer.parseInt((String)salesItemTable.getValueAt(i, 2)),Double.parseDouble((String)salesItemTable.getValueAt(i, 3)),Double.parseDouble((String)salesItemTable.getValueAt(i, 4)),(String)salesItemTable.getValueAt(i, 5));
						    total=total+Double.parseDouble((String)salesItemTable.getValueAt(i, 4));
						    list.add(insItemVO);
						}
						//获取操作人员信息
						PurchaseBillVO vo=new PurchaseBillVO(sales.getNewBillID(utility.getDate()),supplierField.getText(),storehouseField.getText(),"di",list,total,"");
						ArrayList<PurchaseBillVO> vos=new ArrayList<PurchaseBillVO>();
						vos.add(vo);
						ResultMessage result=sales.sendBill(vos);
						if(result==ResultMessage.Success)
					}
				});*/
			}
		});
		
		jbtImportReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				importReturnFrame=new JFrame();
				TopPanel=new JPanel(new BorderLayout());
				returnButtons=new JPanel();
				returnTotal=new JPanel(new BorderLayout());
				returnSearch=new JLabel("退回销售单的编号");
				returnSearchField=new JTextField();
				jbtReturnSearch=new JButton("搜索");
				jbtReturnAssure=new JButton("确定");
				jbtReturnCancel=new JButton("取消");
				returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
			    /*
			     * 
			     * 
			     * 
			     * 
			     * 
			     * 
			     * 初始化表格
			     */
				returnTable=new JTable(returnTableModel);
				returnJS=new JScrollPane(returnTable);
				
				TopPanel.add(returnSearch,BorderLayout.WEST);
				TopPanel.add(returnSearchField,BorderLayout.CENTER);
				TopPanel.add(jbtReturnSearch,BorderLayout.EAST);
				returnButtons.add(jbtReturnAssure);
				returnButtons.add(jbtReturnCancel);
				returnTotal.add(TopPanel,BorderLayout.NORTH);
				returnTotal.add(returnJS,BorderLayout.CENTER);
				returnTotal.add(returnButtons,BorderLayout.SOUTH);
				importReturnFrame.add(returnTotal);
				
				importReturnFrame.pack();
				importReturnFrame.setLocationRelativeTo(null);
				importReturnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				importReturnFrame.setTitle("制定销售退货单");
				importReturnFrame.setVisible(true);
				//未实现：
				jbtReturnSearch.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
					}
				});
				
				jbtReturnAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					    
						JOptionPane.showMessageDialog(null, "提交成功");
					}
				});
				
				jbtReturnCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						importReturnFrame.dispose();
					}
				});
			}
		});
	}
}



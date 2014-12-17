package purchaseui;

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

import purchasebl.PurchaseController;
import vo.PurchaseBillVO;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import enumType.ResultMessage;

class purchaseImportPanelui extends JPanel{
	JButton jbtImport=new JButton("进货");
	JButton jbtImportReturn=new JButton("进货退货");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JPanel importListPanel=new JPanel();
	JLabel importTitle=new JLabel("新增条目",SwingConstants.CENTER);
	JLabel importName=new JLabel("商品名",SwingConstants.RIGHT);
	JLabel importType=new JLabel("型号",SwingConstants.RIGHT);
	//JLabel importID=new JLabel("编号",SwingConstants.RIGHT); 
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
	JButton jbtAssure=new JButton("增加");
	JButton jbtCancel=new JButton("取消");
	JPanel commodityItemPanel=new JPanel(new BorderLayout());
	JPanel commodityItemButtons=new JPanel();
	JLabel commodityTableTitle=new JLabel("已添加商品",SwingConstants.CENTER);
	String[] commodityItemColumn={"商品","型号","数量","单价","总金额","备注"};
	Object[][] commodityItemRow={{}};
	DefaultTableModel commodityItemTableModel=new DefaultTableModel(commodityItemRow,commodityItemColumn);
	JTable commodityItemTable=new JTable(commodityItemTableModel);
	JScrollPane commodityItemJS=new JScrollPane(commodityItemTable);
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
	JLabel returnSearch=new JLabel("退回进货单的编号");
	JTextField returnSearchField=new JTextField();
	JButton jbtReturnSearch=new JButton("搜索");
	JButton jbtReturnAssure=new JButton("确定");
	JButton jbtReturnCancel=new JButton("取消");
	String[] returnColumn={"进货单编号","客户","仓库","操作员","总额","备注"};
	Object[][] returnRowData={{"xxx_xxx","di","XX","XX",30,"XXX"}};
	DefaultTableModel returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
	JTable returnTable=new JTable(returnTableModel);
	JScrollPane returnJS=new JScrollPane(returnTable);
	
	purchaseImportPanelui(){
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
				importTitle=new JLabel("新增条目",SwingConstants.CENTER);
				importName=new JLabel("商品名",SwingConstants.RIGHT);
				importType=new JLabel("型号",SwingConstants.RIGHT);
		//		importID=new JLabel("编号",SwingConstants.RIGHT); 
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
				
			//尚未重置新增内容！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！	
				importTop.add(importName);
				importTop.add(importNameField);
				importTop.add(importType);
				importTop.add(importTypeField);
		//		importTop.add(importID);
			//	importTop.add(importIDField);
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
				commodityItemButtons.add(jbtCheck);
				commodityItemButtons.add(jbtSave);
				commodityItemButtons.add(jbtSend);
				
				commodityItemPanel.add(commodityTableTitle,BorderLayout.NORTH);
				commodityItemPanel.add(commodityItemJS,BorderLayout.CENTER);
				commodityItemPanel.add(mainInfoPanel,BorderLayout.SOUTH);
				mainSubPanel.add(commodityItemPanel,BorderLayout.CENTER);
				mainSubPanel.add(commodityItemButtons,BorderLayout.SOUTH);
				importListPanel.add(mainSubPanel);
				importListFrame.add(importListPanel);
				importListPanel.add(importTotal);
				
				importListFrame.pack();
				importListFrame.setLocationRelativeTo(null);
				importListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				importListFrame.setTitle("进货");
				importListFrame.setVisible(true);
				
				jbtSend.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ArrayList<PurchaseBillVO> vos=new ArrayList<PurchaseBillVO>();
						
						PurchaseBillVO vo=new PurchaseBillVO("XXX",supplierField.getText(),storehouseField.getText(),"didi",null,0,"");
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
				});
				
				jbtSave.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						PurchaseBillVO vo=new PurchaseBillVO("XXX",supplierField.getText(),storehouseField.getText(),"didi",null,0,"");
						ArrayList<PurchaseBillVO.PurchaseBillItemVO> itemList=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
					    int itemNum=commodityItemTable.getRowCount();
					    for(int i=0;i<itemNum;i++){
						PurchaseBillVO.PurchaseBillItemVO items=vo.new PurchaseBillItemVO((String)commodityItemTableModel.getValueAt(i, 0),(String)commodityItemTableModel.getValueAt(i, 1),(int)commodityItemTableModel.getValueAt(i, 2),(double)commodityItemTableModel.getValueAt(i, 3),(double)commodityItemTableModel.getValueAt(i, 4),(String)commodityItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    }
					    vo.setList(itemList);
					    PurchaseController purchaseController=new PurchaseController();
					    ResultMessage result=purchaseController.save(vo);
					    if(result==ResultMessage.Success)
					    {
					    	JOptionPane.showMessageDialog(null, "保存成功");
					    	importListFrame.dispose();
					    }
					   	else
					    	JOptionPane.showMessageDialog(null, "保存失败");
					}
				});
			//	*.*未实现啦啦啦啦
				jbtCheck.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
					}
				});
				
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Object[] insItem={importNameField.getText(),importTypeField.getText(),Integer.parseInt(importNumField.getText()),Double.parseDouble(importPriceField.getText()),Integer.parseInt(importNumField.getText())*Double.parseDouble(importPriceField.getText()),importTipArea.getText()};
						commodityItemTableModel.addRow(insItem);
						importNameField.setText("");
						importTypeField.setText("");
						importNumField.setText("");
						importPriceField.setText("");
						importTipArea.setText("备注");
					}
				});
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						importListFrame.dispose();
					}
				});
			}
		});
		
		jbtImportReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				importReturnFrame=new JFrame();
				TopPanel=new JPanel(new BorderLayout());
				returnButtons=new JPanel();
				returnTotal=new JPanel(new BorderLayout());
				returnSearch=new JLabel("退回进货单的编号");
				returnSearchField=new JTextField();
				jbtReturnSearch=new JButton("搜索");
				jbtReturnAssure=new JButton("确定");
				jbtReturnCancel=new JButton("取消");
				returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
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
				importReturnFrame.setTitle("制定进货退货单");
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


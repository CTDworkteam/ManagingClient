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
import salesbl.SalesBill;
import salesbl.SalesController;
import utility.Utility;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;
import vo.SalesReturnBillVO.SalesReturnBillItemVO;



class SalesImportPanelui extends JPanel{
	JButton jbtImport=new JButton("����");
	JButton jbtImportReturn=new JButton("�����˻�");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JPanel importListPanel=new JPanel();
	JLabel importTitle=new JLabel("�½����۵�");
	JLabel importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
	JLabel importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
//	JLabel importID=new JLabel("���",SwingConstants.RIGHT); 
	JLabel importNum=new JLabel("����",SwingConstants.RIGHT);
	JLabel importPrice=new JLabel("����",SwingConstants.RIGHT);
	JTextField importNameField=new JTextField("���ѡ����Ʒ");
	JTextField importTypeField=new JTextField();
	JTextField importIDField=new JTextField();
	JTextField importNumField=new JTextField();
	JTextField importPriceField=new JTextField();
	JTextArea importTipArea=new JTextArea("��ע");
	JPanel importTopPlusTitle=new JPanel(new BorderLayout());
	JPanel importTop=new JPanel(new GridLayout(4,2));
	JPanel importBottom=new JPanel(new BorderLayout());
	JPanel importButtons=new JPanel();
	JPanel importTotal=new JPanel(new GridLayout(2,1));
	JScrollPane TipJS=new JScrollPane(importTipArea);
	JButton jbtAssure=new JButton("�ύ");
	JButton jbtCancel=new JButton("ȡ��");
	
	JPanel salesItemPanel=new JPanel(new BorderLayout());
	JPanel salesItemButtons=new JPanel();
	JLabel salesTableTitle=new JLabel("�������Ʒ",SwingConstants.CENTER);
	String[] salesItemColumn={"��Ʒ","�ͺ�","����","����","�ܽ��","��ע"};
	Object[][] salesItemRow={{}};
	DefaultTableModel salesItemTableModel=new DefaultTableModel(salesItemRow,salesItemColumn);
	JTable salesItemTable=new JTable(salesItemTableModel);
	JScrollPane salesItemJS=new JScrollPane(salesItemTable);
	JButton jbtSave=new JButton("����");
	JButton jbtSend=new JButton("�ύ");
	JButton jbtCheck=new JButton("�鿴���浥��");
	JLabel supplier=new JLabel("�ͻ�",SwingConstants.CENTER);
	JLabel storehouse=new JLabel("�ֿ�",SwingConstants.CENTER);
	JLabel discount=new JLabel("",SwingConstants.CENTER);
	JLabel voucher=new JLabel("",SwingConstants.CENTER);
	JTextField supplierField=new JTextField();
	JTextField storehouseField=new JTextField();
	JTextField discountField=new JTextField();
	JTextField voucherField=new JTextField();
    JPanel mainInfoPanel=new JPanel(new GridLayout(1,8));
	JPanel mainSubPanel=new JPanel(new BorderLayout());
	
	//importReturnFrame:
	JFrame importReturnFrame=new JFrame();
	JPanel TopPanel=new JPanel();
	JPanel returnButtons=new JPanel();
	JPanel returnTotal=new JPanel(new BorderLayout());
	JLabel returnSearch=new JLabel("�˻����۵��ı��");
	JTextField returnSearchField=new JTextField();
	JButton jbtReturnSearch=new JButton("����");
	JButton jbtReturnAssure=new JButton("ȷ��");
	JButton jbtReturnCancel=new JButton("ȡ��");
	String[] returnColumn={"���۵����","�ͻ�","����Ա","�ֿ�","�ܶ�"};
	Object[][] returnRowData={{}};
	DefaultTableModel returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
	JTable returnTable=new JTable(returnTableModel);
	JScrollPane returnJS=new JScrollPane(returnTable);
	
	ArrayList<SalesBillVO> allBills;
	
	
	SalesImportPanelui(){
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
				importTitle=new JLabel("�½����۵�");
				importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
				importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
	//			importID=new JLabel("���",SwingConstants.RIGHT); 
				importNum=new JLabel("����",SwingConstants.RIGHT);
				importPrice=new JLabel("����",SwingConstants.RIGHT);
				importNameField=new JTextField("���ѡ����Ʒ");
				importTypeField=new JTextField();
				importIDField=new JTextField();
				importNumField=new JTextField();
				importPriceField=new JTextField();
				importTipArea=new JTextArea("��ע");
				importTopPlusTitle=new JPanel(new BorderLayout());
				importTop=new JPanel(new GridLayout(5,2));
				importBottom=new JPanel(new BorderLayout());
				importButtons=new JPanel();
				importTotal=new JPanel(new GridLayout(2,1));
				TipJS=new JScrollPane(importTipArea);
				jbtAssure=new JButton("�ύ");
				jbtCancel=new JButton("ȡ��");
				
				
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
				mainInfoPanel.add(discount);
				mainInfoPanel.add(discountField);
				mainInfoPanel.add(voucher);
				mainInfoPanel.add(voucherField);
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
				importListFrame.setTitle("����");
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
					    	JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
					    	importListFrame.dispose();
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "�ύʧ��");
					    
					}
				});             */
				
				
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						importListFrame.dispose();
					}
				});
				//12.27
				jbtSend.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ArrayList<SalesBillVO> vos=new ArrayList<SalesBillVO>();
						Utility utility=new Utility();
						SalesController sales=new SalesController();
						double total=0;
						SalesBillVO vo=new SalesBillVO(sales.getNewBillID(utility.getDate()),supplierField.getText(),"","",storehouseField.getText(),null,0,Double.parseDouble(discountField.getText()),Double.parseDouble(voucherField.getText()),0,"");
						ArrayList<SalesBillVO.SalesBillItemVO> itemList=new ArrayList<SalesBillVO.SalesBillItemVO>();
					    int itemNum=salesItemTable.getRowCount();
					    for(int i=0;i<itemNum;i++){
						SalesBillVO.SalesBillItemVO items=vo.new SalesBillItemVO((String)salesItemTableModel.getValueAt(i, 0),(String)salesItemTableModel.getValueAt(i, 1),(int)salesItemTableModel.getValueAt(i, 2),(double)salesItemTableModel.getValueAt(i, 3),(double)salesItemTableModel.getValueAt(i, 4),(String)salesItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    total=total+Double.parseDouble((String)salesItemTable.getValueAt(i, 4));
					    }
					    vo.setInitialTotal(total);
					    vo.setTotal(total-Double.parseDouble(discountField.getText())-Double.parseDouble(voucherField.getText()));
					    vo.setList(itemList);
					    vo.setId(sales.getNewBillID(utility.getDate()));
					    vos.add(vo);
					    
					    ResultMessage result=sales.sendBill(vos);
					    if(result==ResultMessage.Success){
					    	JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
					    	importListFrame.dispose();
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "�ύʧ��");
					}
				});
				//12.27
				jbtSave.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ArrayList<SalesBillVO> vos=new ArrayList<SalesBillVO>();
						Utility utility=new Utility();
						SalesController sales=new SalesController();
						double total=0;
						SalesBillVO vo=new SalesBillVO(sales.getNewBillID(utility.getDate()),supplierField.getText(),"","",storehouseField.getText(),null,0,Double.parseDouble(discountField.getText()),Double.parseDouble(voucherField.getText()),0,"");
						ArrayList<SalesBillVO.SalesBillItemVO> itemList=new ArrayList<SalesBillVO.SalesBillItemVO>();
					    int itemNum=salesItemTable.getRowCount();
					    for(int i=0;i<itemNum;i++){
						SalesBillVO.SalesBillItemVO items=vo.new SalesBillItemVO((String)salesItemTableModel.getValueAt(i, 0),(String)salesItemTableModel.getValueAt(i, 1),(int)salesItemTableModel.getValueAt(i, 2),(double)salesItemTableModel.getValueAt(i, 3),(double)salesItemTableModel.getValueAt(i, 4),(String)salesItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    total=total+Double.parseDouble((String)salesItemTable.getValueAt(i, 4));
					    }
					    vo.setInitialTotal(total);
					    vo.setTotal(total-Double.parseDouble(discountField.getText())-Double.parseDouble(voucherField.getText()));
					    vo.setList(itemList);
					    vo.setId(sales.getNewBillID(utility.getDate()));
					    
					    
					    ResultMessage result=sales.save(vo);
					    if(result==ResultMessage.Success){
					    	JOptionPane.showMessageDialog(null, "����ɹ�");
					    	importListFrame.dispose();
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "����ʧ��");
					}
				});
				//δʵ��
				jbtCheck.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
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
				returnSearch=new JLabel("�˻����۵��ı��");
				returnSearchField=new JTextField();
				jbtReturnSearch=new JButton("����");
				jbtReturnAssure=new JButton("ȷ��");
				jbtReturnCancel=new JButton("ȡ��");
				returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
			    /*
			     * 
			     * 
			     * ��ʼ�����
			     */
				SalesController sales=new SalesController();
				allBills=sales.getAllBills();
				int billNum=allBills.size();
				for(int i=0;i<billNum;i++)
				{
					SalesBillVO insvo=allBills.get(i);
					Object[] newRow={insvo.getId(),insvo.getClient(),insvo.getOperator(),insvo.getStorehouse(),insvo.getTotal()};
				//	"���۵����","�ͻ�","����Ա","�ֿ�","�ܶ�"
					returnTableModel.addRow(newRow);
				}
				
				
				
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
				importReturnFrame.setTitle("�ƶ������˻���");
				importReturnFrame.setVisible(true);
				//δʵ�֣�
				jbtReturnSearch.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
					}
				});
			//12.27	
				jbtReturnAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						SalesController sales=new SalesController();
					    Utility utility=new Utility();
					    int selectedRow=salesItemTable.getSelectedRow();
					    SalesBillVO oldvo=allBills.get(selectedRow);
					    ArrayList<SalesBillVO.SalesBillItemVO> oldItems=oldvo.getList();
					    SalesReturnBillVO insvo=new SalesReturnBillVO();
					    ArrayList<SalesReturnBillVO.SalesReturnBillItemVO> list=new ArrayList<SalesReturnBillVO.SalesReturnBillItemVO>();
					    SalesReturnBillVO vo=new SalesReturnBillVO(sales.getNewReturnBillID(utility.getDate()),oldvo.getClient(),oldvo.getDefaultOperator(),oldvo.getOperator(),oldvo.getStorehouse(),list,oldvo.getInitialTotal(),oldvo.getDiscount(),oldvo.getVoucher(),oldvo.getTotal(),oldvo.getNote());
						int itemNum=oldItems.size();
						for(int i=0;i<itemNum;i++)
						{
							SalesReturnBillItemVO newItem=insvo.new SalesReturnBillItemVO(oldItems.get(i).getCommodity(),oldItems.get(i).getModel(),oldItems.get(i).getNumber(),oldItems.get(i).getPrice(),oldItems.get(i).getTotal(),oldItems.get(i).getNote());
							list.add(newItem);
						}
						vo.setList(list);
						ArrayList<SalesReturnBillVO> voarray=new ArrayList<SalesReturnBillVO>();
						voarray.add(vo);
					    ResultMessage result=sales.sendReturnBill(voarray);
					    if(result==ResultMessage.Success)
					    {
					    	JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
					    	importReturnFrame.dispose();
					    }
					    else
					    {
					    	JOptionPane.showMessageDialog(null, "�ύʧ��");
					    }
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



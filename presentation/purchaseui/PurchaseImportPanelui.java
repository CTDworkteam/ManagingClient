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
import recordbl.RecordController;
import utility.Utility;
import vo.PurchaseBillVO;
import vo.PurchaseBillVO.PurchaseBillItemVO;
import vo.PurchaseReturnBillVO;
import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;
import enumType.ActionType;
import enumType.Operation;
import enumType.ResultMessage;

class PurchaseImportPanelui extends JPanel{
	JButton jbtImport=new JButton("����");
	JButton jbtImportReturn=new JButton("�����˻�");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JPanel importListPanel=new JPanel();
	JLabel importTitle=new JLabel("������Ŀ",SwingConstants.CENTER);
	JLabel importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
	JLabel importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
	//JLabel importID=new JLabel("���",SwingConstants.RIGHT); 
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
	JButton jbtAssure=new JButton("����");
	JButton jbtCancel=new JButton("ȡ��");
	JPanel commodityItemPanel=new JPanel(new BorderLayout());
	JPanel commodityItemButtons=new JPanel();
	JLabel commodityTableTitle=new JLabel("��������Ʒ",SwingConstants.CENTER);
	String[] commodityItemColumn={"��Ʒ","�ͺ�","����","����","�ܽ��","��ע"};
	Object[][] commodityItemRow={{}};
	DefaultTableModel commodityItemTableModel=new DefaultTableModel(commodityItemRow,commodityItemColumn);
	JTable commodityItemTable=new JTable(commodityItemTableModel);
	JScrollPane commodityItemJS=new JScrollPane(commodityItemTable);
	JButton jbtSave=new JButton("����");
	JButton jbtSend=new JButton("�ύ");
	JButton jbtCheck=new JButton("�鿴���浥��");
	JLabel supplier=new JLabel("�ͻ�",SwingConstants.CENTER);
	JLabel storehouse=new JLabel("�ֿ�",SwingConstants.CENTER);
	JTextField supplierField=new JTextField();
	JTextField storehouseField=new JTextField();
	JPanel mainInfoPanel=new JPanel(new GridLayout(1,4));
	JPanel mainSubPanel=new JPanel(new BorderLayout());
	
	//importReturnFrame:
	JFrame importReturnFrame=new JFrame();
	JPanel TopPanel=new JPanel();
	JPanel returnButtons=new JPanel();
	JPanel returnTotal=new JPanel(new BorderLayout());
	JLabel returnSearch=new JLabel("�˻ؽ������ı��");
	JTextField returnSearchField=new JTextField();
	JButton jbtReturnSearch=new JButton("����");
	JButton jbtReturnAssure=new JButton("ȷ��");
	JButton jbtReturnCancel=new JButton("ȡ��");
	String[] returnColumn={"���۵����","�ͻ�","����Ա","�ֿ�","�ܶ�"};
	Object[][] returnRowData={{}};
	DefaultTableModel returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
	JTable returnTable=new JTable(returnTableModel);
	JScrollPane returnJS=new JScrollPane(returnTable);
	
	ArrayList<PurchaseBillVO> allBills;
	RecordController record=new RecordController();
	String operator;
	
	PurchaseImportPanelui(String ope){
		operator=ope;
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
				importTitle=new JLabel("������Ŀ",SwingConstants.CENTER);
				importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
				importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
		//		importID=new JLabel("���",SwingConstants.RIGHT); 
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
				
			//��δ�����������ݣ���������������������������������������������������������������������������	
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
				importListFrame.setTitle("����");
				importListFrame.setVisible(true);
				
				jbtSend.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						ArrayList<PurchaseBillVO> vos=new ArrayList<PurchaseBillVO>();
						Utility utility=new Utility();
						PurchaseController purchase=new PurchaseController();
						PurchaseBillVO vo=new PurchaseBillVO(purchase.getNewBillID(utility.getDate()),supplierField.getText(),storehouseField.getText(),"didi",null,0,"");
						ArrayList<PurchaseBillVO.PurchaseBillItemVO> itemList=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
					    int itemNum=commodityItemTable.getRowCount();
					    double total=0;
					    for(int i=0;i<itemNum;i++){
						PurchaseBillVO.PurchaseBillItemVO items=vo.new PurchaseBillItemVO((String)commodityItemTableModel.getValueAt(i, 0),(String)commodityItemTableModel.getValueAt(i, 1),(int)commodityItemTableModel.getValueAt(i, 2),(double)commodityItemTableModel.getValueAt(i, 3),(double)commodityItemTableModel.getValueAt(i, 4),(String)commodityItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    total=total+Double.parseDouble((String)commodityItemTable.getValueAt(i, 4));
					    }
					    vo.setTotal(total);
					    vo.setList(itemList);
					    vo.setId(purchase.getNewBillID(utility.getDate()));
					    vos.add(vo);
					    
					    ResultMessage result=purchase.sendBill(vos);
					    if(result==ResultMessage.Success){
					    	record.saveBillAddDelRecord(Operation.PurchaseBill, ActionType.Add, operator, vo.getId());
					    	JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
					    	importListFrame.dispose();
					    }
					    else
					    	JOptionPane.showMessageDialog(null, "�ύʧ��");
					    
					}
				});
				
				
				jbtSave.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Utility utility=new Utility();
						PurchaseController purchase=new PurchaseController();
						PurchaseBillVO vo=new PurchaseBillVO(purchase.getNewBillID(utility.getDate()),supplierField.getText(),storehouseField.getText(),"didi",null,0,"");
						ArrayList<PurchaseBillVO.PurchaseBillItemVO> itemList=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
					    int itemNum=commodityItemTable.getRowCount();
					    double total=0;
					    for(int i=0;i<itemNum;i++){
						PurchaseBillVO.PurchaseBillItemVO items=vo.new PurchaseBillItemVO((String)commodityItemTableModel.getValueAt(i, 0),(String)commodityItemTableModel.getValueAt(i, 1),(int)commodityItemTableModel.getValueAt(i, 2),(double)commodityItemTableModel.getValueAt(i, 3),(double)commodityItemTableModel.getValueAt(i, 4),(String)commodityItemTableModel.getValueAt(i, 5));
					    itemList.add(items);
					    total=total+Double.parseDouble((String)commodityItemTable.getValueAt(i, 4));
					    }
					    vo.setTotal(total);
					    vo.setList(itemList);
					    
					    ResultMessage result=purchase.save(vo);
					    if(result==ResultMessage.Success)
					    {
					    	
					    	JOptionPane.showMessageDialog(null, "����ɹ�");
					    	importListFrame.dispose();
					    }
					   	else
					    	JOptionPane.showMessageDialog(null, "����ʧ��");
					}
				});
			//	*.*δʵ����������
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
						importTipArea.setText("��ע");
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
				returnSearch=new JLabel("�˻ؽ������ı��");
				returnSearchField=new JTextField();
				jbtReturnSearch=new JButton("����");
				jbtReturnAssure=new JButton("ȷ��");
				jbtReturnCancel=new JButton("ȡ��");
				returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
				PurchaseController purchase=new PurchaseController();
				allBills=purchase.getAllBills();
				int billNum=allBills.size();
				for(int i=0;i<billNum;i++)
				{
					
					PurchaseBillVO insvo=allBills.get(i);
					Object[] newRow={insvo.getId(),insvo.getSupplier(),insvo.getOperator(),insvo.getStorehouse(),insvo.getTotal()};
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
				
				jbtReturnAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						PurchaseController purchase=new PurchaseController();
					    Utility utility=new Utility();
					    int selectedRow=commodityItemTable.getSelectedRow();
					    PurchaseBillVO oldvo=allBills.get(selectedRow);
					    ArrayList<PurchaseBillItemVO> oldItems=oldvo.getList();
					    PurchaseReturnBillVO insvo=new PurchaseReturnBillVO();
					    ArrayList<PurchaseReturnBillItemVO> list=new ArrayList<PurchaseReturnBillItemVO>();
					    PurchaseReturnBillVO vo=new PurchaseReturnBillVO(purchase.getNewReturnBillID(utility.getDate()),oldvo.getSupplier(),oldvo.getStorehouse(),oldvo.getOperator(),list,oldvo.getTotal(),oldvo.getNote());
						int itemNum=oldItems.size();
						for(int i=0;i<itemNum;i++)
						{
							PurchaseReturnBillItemVO newItem=insvo.new PurchaseReturnBillItemVO(oldItems.get(i).getCommodity(),oldItems.get(i).getModel(),oldItems.get(i).getNumber(),oldItems.get(i).getPrice(),oldItems.get(i).getTotal(),oldItems.get(i).getNote());
							list.add(newItem);
						}
						vo.setList(list);
						ArrayList<PurchaseReturnBillVO> voarray=new ArrayList<PurchaseReturnBillVO>();
						voarray.add(vo);
					    ResultMessage result=purchase.sendReturnBill(voarray);
					    if(result==ResultMessage.Success)
					    {
					    	record.saveBillAddDelRecord(Operation.PurchaseReturnBill, ActionType.Add, operator, vo.getId());
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

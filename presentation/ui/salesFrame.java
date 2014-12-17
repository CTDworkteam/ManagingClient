package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class salesFrame extends JFrame{
	private JTabbedPane salesGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("������Ŷ�Ǻ�");
	private JLabel UserPosition=new JLabel("ְλ������Ա");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("�˳�");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private salesHomePage homePage=new salesHomePage();
	private salesCustomerManagement customerManagement=new salesCustomerManagement();
	private salesImportPanel importPanel=new salesImportPanel();
	
	public salesFrame(){
		salesGuide.setTabPlacement(JTabbedPane.LEFT);
		salesGuide.addTab("��ҳ", homePage);
		salesGuide.addTab("�ͻ�����",customerManagement);
		salesGuide.addTab("���۹���", importPanel);
		salesGuide.setSelectedIndex(0);
		textPanel.add(salesGuide);
		topInfoPanel.add(UserName);
		topInfoPanel.add(UserPosition);
		topTotalPanel.add(topInfoPanel,BorderLayout.WEST);
		topTotalPanel.add(jbtExit,BorderLayout.EAST);
		framePanel.add(topTotalPanel,BorderLayout.NORTH);
		framePanel.add(textPanel,BorderLayout.CENTER);
		add(framePanel);
	}
	public static void main(String[] args){
		salesFrame frame=new salesFrame();
		frame.pack();
		frame.setTitle("����Ա");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}

class salesHomePage extends JPanel{
	String information="������Ա����ע�����";
	JTextArea salesInformation=new JTextArea(information);
	JScrollPane salesJscrollPane=new JScrollPane(salesInformation);
	
	salesHomePage(){
		salesInformation.setEditable(false);
		setLayout(new BorderLayout());
		add(salesJscrollPane,BorderLayout.CENTER);
	}
}

class salesCustomerManagement extends JPanel{
	JPanel customerSearch1=new JPanel(new BorderLayout());
	JPanel customerSearch2=new JPanel(new BorderLayout());
	JPanel customerSearch3=new JPanel(new GridLayout(2,1));
	JPanel customerSearch4=new JPanel(new BorderLayout());
	JPanel buttonsPanel=new JPanel();
	JPanel totalPanel=new JPanel(new BorderLayout());
	JButton jbtSearch=new JButton("����");
	JButton jbtAdd=new JButton("����");
	JButton jbtDelete=new JButton("ɾ��");
	JButton jbtUpdate=new JButton("�޸�");
	JLabel customerID=new JLabel("�ͻ����");
	JLabel customerName=new JLabel("�⻧����");
	JTextField customerIDField=new JTextField();
	JTextField customerNameField=new JTextField();
	String[] column={"���","����","����","����","�绰","��ַ","�ʱ�","����","Ĭ��ҵ��Ա"};
	Object[][] rowData={{"0001","������",1,"��","XX","XX","XX","XX","XX"}};
	DefaultTableModel customerTableModel=new DefaultTableModel(rowData,column);
	JTable customerTable=new JTable(customerTableModel);
	JScrollPane customerJScrollPane=new JScrollPane(customerTable);
	
	//newCustomerFrame:
	JFrame newCustomerFrame=new JFrame();
	JLabel newCustomerTitle=new JLabel("����������",SwingConstants.RIGHT);
	JLabel newCustomerID=new JLabel("�⻧���",SwingConstants.RIGHT);
	JLabel newCustomerRank=new JLabel("�⻧����",SwingConstants.RIGHT);
	JLabel newCustomerCounterman=new JLabel("Ĭ��ҵ��Ա",SwingConstants.RIGHT);
	JLabel newCustomerName=new JLabel("�ͻ�����",SwingConstants.RIGHT);
	JLabel newCustomerTel=new JLabel("�绰",SwingConstants.RIGHT);
	JLabel newCustomerEmail=new JLabel("����",SwingConstants.RIGHT);
	JLabel newCustomerAddress=new JLabel("��ַ",SwingConstants.RIGHT);
	JLabel newCustomerPostcode=new JLabel("�ʱ�",SwingConstants.RIGHT);
	JTextField newCustomerIDField=new JTextField();
	String[] rankType={"��","��","��","��","��"};
	JComboBox newCustomerRankBox=new JComboBox(rankType);
	String[] counterman={"��","�ϵ�","������"};
	JComboBox newCustomerCountermanBox=new JComboBox(counterman);
	JTextField newCustomerNameField=new JTextField();
	JTextField newCustomerTelField=new JTextField();
	JTextField newCustomerEmailField=new JTextField();
	JTextField newCustomerAddressField=new JTextField();
	JTextField newCustomerPostcodeField=new JTextField();
	JButton jbtCreate=new JButton("ȷ��");
	JButton jbtNotCreate=new JButton("ȡ��");
	JPanel infoPanel=new JPanel(new GridLayout(8,2));
	JPanel createButtonsPanel=new JPanel();
	JPanel createTotalPanel=new JPanel(new BorderLayout());
	
	salesCustomerManagement(){
		setLayout(new BorderLayout());
		customerSearch1.add(customerID,BorderLayout.WEST);
		customerSearch1.add(customerIDField,BorderLayout.CENTER);
		customerSearch2.add(customerName,BorderLayout.WEST);
		customerSearch2.add(customerNameField,BorderLayout.CENTER);
		customerSearch3.add(customerSearch1);
		customerSearch3.add(customerSearch2);
		customerSearch4.add(customerSearch3,BorderLayout.CENTER);
		customerSearch4.add(jbtSearch,BorderLayout.EAST);
		buttonsPanel.add(jbtAdd);
		buttonsPanel.add(jbtDelete);
		buttonsPanel.add(jbtUpdate);
		totalPanel.add(customerSearch4,BorderLayout.NORTH);
		totalPanel.add(customerJScrollPane,BorderLayout.CENTER);
		totalPanel.add(buttonsPanel,BorderLayout.SOUTH);
		add(totalPanel,BorderLayout.CENTER);
		
		//δʵ��:
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newCustomerFrame=new JFrame();
				newCustomerTitle=new JLabel("����������",SwingConstants.RIGHT);
				newCustomerID=new JLabel("�⻧���",SwingConstants.RIGHT);
				newCustomerRank=new JLabel("�⻧����",SwingConstants.RIGHT);
				newCustomerCounterman=new JLabel("Ĭ��ҵ��Ա",SwingConstants.RIGHT);
				newCustomerName=new JLabel("�ͻ�����",SwingConstants.RIGHT);
				newCustomerTel=new JLabel("�绰",SwingConstants.RIGHT);
				newCustomerEmail=new JLabel("����",SwingConstants.RIGHT);
				newCustomerAddress=new JLabel("��ַ",SwingConstants.RIGHT);
		        newCustomerPostcode=new JLabel("�ʱ�",SwingConstants.RIGHT);
				newCustomerIDField=new JTextField();
			    newCustomerRankBox=new JComboBox(rankType);
			    newCustomerCountermanBox=new JComboBox(counterman);
				newCustomerNameField=new JTextField();
				newCustomerTelField=new JTextField();
				newCustomerEmailField=new JTextField();
				newCustomerAddressField=new JTextField();
				newCustomerPostcodeField=new JTextField();
				jbtCreate=new JButton("ȷ��");
				jbtNotCreate=new JButton("ȡ��");
				infoPanel=new JPanel(new GridLayout(8,2));
				createButtonsPanel=new JPanel();
				createTotalPanel=new JPanel(new BorderLayout());
				
				newCustomerIDField.setText("");
				newCustomerRankBox.setSelectedIndex(0);
				newCustomerCountermanBox.setSelectedIndex(0);
				newCustomerNameField.setText("");
		        newCustomerTelField.setText("");
				newCustomerEmailField.setText("");
				newCustomerAddressField.setText("");
				newCustomerPostcodeField.setText("");
				infoPanel.add(newCustomerID);
				infoPanel.add(newCustomerIDField);
				infoPanel.add(newCustomerRank);
				infoPanel.add(newCustomerRankBox);
				infoPanel.add(newCustomerCounterman);
				infoPanel.add(newCustomerCountermanBox);
				infoPanel.add(newCustomerName);
				infoPanel.add(newCustomerNameField);
				infoPanel.add(newCustomerTel);
				infoPanel.add(newCustomerTelField);
				infoPanel.add(newCustomerEmail);
				infoPanel.add(newCustomerEmailField);
				infoPanel.add(newCustomerAddress);
				infoPanel.add(newCustomerAddressField);
				infoPanel.add(newCustomerPostcode);
				infoPanel.add(newCustomerPostcodeField);
				createButtonsPanel.add(jbtCreate);
				createButtonsPanel.add(jbtNotCreate);
				createTotalPanel.add(newCustomerTitle,BorderLayout.NORTH);
				createTotalPanel.add(infoPanel,BorderLayout.CENTER);
				createTotalPanel.add(createButtonsPanel,BorderLayout.SOUTH);
				newCustomerFrame.add(createTotalPanel);
				newCustomerFrame.pack();
				newCustomerFrame.setLocationRelativeTo(null);
				newCustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				newCustomerFrame.setTitle("����������");
				newCustomerFrame.setVisible(true);
				
				jbtCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText()};
						customerTableModel.addRow(newRow);
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						newCustomerFrame.dispose();
					}
				});
				jbtNotCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						newCustomerFrame.dispose();
					}
				});
			}
		});
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(customerTable.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(null, "δѡ��ɾ��Ŀ��");
				}
				else
				{
				customerTableModel.removeRow(customerTable.getSelectedRow());
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}
			}
		});
		//=��=ûʵ����ŶҮ~~
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}

class salesImportPanel extends JPanel{
	JButton jbtImport=new JButton("����");
	JButton jbtImportReturn=new JButton("�����˻�");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JLabel importTitle=new JLabel("�½����۵�");
	JLabel importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
	JLabel importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
	JLabel importID=new JLabel("���",SwingConstants.RIGHT); 
	JLabel importNum=new JLabel("����",SwingConstants.RIGHT);
	JLabel importPrice=new JLabel("����",SwingConstants.RIGHT);
	JTextField importNameField=new JTextField("���ѡ����Ʒ");
	JTextField importTypeField=new JTextField();
	JTextField importIDField=new JTextField();
	JTextField importNumField=new JTextField();
	JTextField importPriceField=new JTextField();
	JTextArea importTipArea=new JTextArea("��ע");
	JPanel importTopPlusTitle=new JPanel(new BorderLayout());
	JPanel importTop=new JPanel(new GridLayout(5,2));
	JPanel importBottom=new JPanel(new BorderLayout());
	JPanel importButtons=new JPanel();
	JPanel importTotal=new JPanel(new GridLayout(2,1));
	JScrollPane TipJS=new JScrollPane(importTipArea);
	JButton jbtAssure=new JButton("�ύ");
	JButton jbtCancel=new JButton("ȡ��");
	
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
	String[] returnColumn={"���۵����","��Ʒ��","��Ʒ�ͺ�","����","����"};
	Object[][] returnRowData={{"xxx_xxx","di","XX",30,30}};
	DefaultTableModel returnTableModel=new DefaultTableModel(returnRowData,returnColumn);
	JTable returnTable=new JTable(returnTableModel);
	JScrollPane returnJS=new JScrollPane(returnTable);
	
	salesImportPanel(){
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
				importTitle=new JLabel("�½����۵�");
				importName=new JLabel("��Ʒ��",SwingConstants.RIGHT);
				importType=new JLabel("�ͺ�",SwingConstants.RIGHT);
				importID=new JLabel("���",SwingConstants.RIGHT); 
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
				importTop.add(importID);
				importTop.add(importIDField);
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
				importListFrame.add(importTotal);
				
				importListFrame.pack();
				importListFrame.setLocationRelativeTo(null);
				importListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				importListFrame.setTitle("����");
				importListFrame.setVisible(true);
				
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
						importListFrame.dispose();
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
				returnSearch=new JLabel("�˻����۵��ı��");
				returnSearchField=new JTextField();
				jbtReturnSearch=new JButton("����");
				jbtReturnAssure=new JButton("ȷ��");
				jbtReturnCancel=new JButton("ȡ��");
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
				importReturnFrame.setTitle("�ƶ������˻���");
				importReturnFrame.setVisible(true);
				//δʵ�֣�
				jbtReturnSearch.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
					}
				});
				
				jbtReturnAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JOptionPane.showMessageDialog(null, "�ύ�ɹ�");
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


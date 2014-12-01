package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class salesFrame extends JFrame{
	private JTabbedPane salesGuide=new JTabbedPane();
	private JLabel UserName=new JLabel("姓名：哦呵呵");
	private JLabel UserPosition=new JLabel("职位：销售员");
	private JPanel topInfoPanel=new JPanel();
	private JPanel framePanel=new JPanel(new BorderLayout());
	private JButton jbtExit=new JButton("退出");
	private JPanel topTotalPanel=new JPanel(new BorderLayout());
	private JPanel textPanel=new JPanel();
	private salesHomePage homePage=new salesHomePage();
	private salesCustomerManagement customerManagement=new salesCustomerManagement();
	private salesImportPanel importPanel=new salesImportPanel();
	
	public salesFrame(){
		salesGuide.setTabPlacement(JTabbedPane.LEFT);
		salesGuide.addTab("首页", homePage);
		salesGuide.addTab("客户管理",customerManagement);
		salesGuide.addTab("销售管理", importPanel);
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
		frame.setTitle("销售员");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}

class salesHomePage extends JPanel{
	String information="销售人员操作注意事项：";
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
	JButton jbtSearch=new JButton("搜索");
	JButton jbtAdd=new JButton("增加");
	JButton jbtDelete=new JButton("删除");
	JButton jbtUpdate=new JButton("修改");
	JLabel customerID=new JLabel("客户编号");
	JLabel customerName=new JLabel("库户名称");
	JTextField customerIDField=new JTextField();
	JTextField customerNameField=new JTextField();
	String[] column={"编号","类型","级别","名称","电话","地址","邮编","邮箱","默认业务员"};
	Object[][] rowData={{"0001","销售商",1,"迪","XX","XX","XX","XX","XX"}};
	DefaultTableModel customerTableModel=new DefaultTableModel(rowData,column);
	JTable customerTable=new JTable(customerTableModel);
	JScrollPane customerJScrollPane=new JScrollPane(customerTable);
	
	//newCustomerFrame:
	JFrame newCustomerFrame=new JFrame();
	JLabel newCustomerTitle=new JLabel("新增销售商",SwingConstants.RIGHT);
	JLabel newCustomerID=new JLabel("库户编号",SwingConstants.RIGHT);
	JLabel newCustomerRank=new JLabel("库户级别",SwingConstants.RIGHT);
	JLabel newCustomerCounterman=new JLabel("默认业务员",SwingConstants.RIGHT);
	JLabel newCustomerName=new JLabel("客户姓名",SwingConstants.RIGHT);
	JLabel newCustomerTel=new JLabel("电话",SwingConstants.RIGHT);
	JLabel newCustomerEmail=new JLabel("邮箱",SwingConstants.RIGHT);
	JLabel newCustomerAddress=new JLabel("地址",SwingConstants.RIGHT);
	JLabel newCustomerPostcode=new JLabel("邮编",SwingConstants.RIGHT);
	JTextField newCustomerIDField=new JTextField();
	String[] rankType={"Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ"};
	JComboBox newCustomerRankBox=new JComboBox(rankType);
	String[] counterman={"迪","迪迪","嘀嘀嘀"};
	JComboBox newCustomerCountermanBox=new JComboBox(counterman);
	JTextField newCustomerNameField=new JTextField();
	JTextField newCustomerTelField=new JTextField();
	JTextField newCustomerEmailField=new JTextField();
	JTextField newCustomerAddressField=new JTextField();
	JTextField newCustomerPostcodeField=new JTextField();
	JButton jbtCreate=new JButton("确定");
	JButton jbtNotCreate=new JButton("取消");
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
		
		//未实现:
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newCustomerFrame=new JFrame();
				newCustomerTitle=new JLabel("新增销售商",SwingConstants.RIGHT);
				newCustomerID=new JLabel("库户编号",SwingConstants.RIGHT);
				newCustomerRank=new JLabel("库户级别",SwingConstants.RIGHT);
				newCustomerCounterman=new JLabel("默认业务员",SwingConstants.RIGHT);
				newCustomerName=new JLabel("客户姓名",SwingConstants.RIGHT);
				newCustomerTel=new JLabel("电话",SwingConstants.RIGHT);
				newCustomerEmail=new JLabel("邮箱",SwingConstants.RIGHT);
				newCustomerAddress=new JLabel("地址",SwingConstants.RIGHT);
		        newCustomerPostcode=new JLabel("邮编",SwingConstants.RIGHT);
				newCustomerIDField=new JTextField();
			    newCustomerRankBox=new JComboBox(rankType);
			    newCustomerCountermanBox=new JComboBox(counterman);
				newCustomerNameField=new JTextField();
				newCustomerTelField=new JTextField();
				newCustomerEmailField=new JTextField();
				newCustomerAddressField=new JTextField();
				newCustomerPostcodeField=new JTextField();
				jbtCreate=new JButton("确定");
				jbtNotCreate=new JButton("取消");
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
				newCustomerFrame.setTitle("新增销售商");
				newCustomerFrame.setVisible(true);
				
				jbtCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText()};
						customerTableModel.addRow(newRow);
						JOptionPane.showMessageDialog(null, "添加成功");
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
					JOptionPane.showMessageDialog(null, "未选择删除目标");
				}
				else
				{
				customerTableModel.removeRow(customerTable.getSelectedRow());
				JOptionPane.showMessageDialog(null, "删除成功");
				}
			}
		});
		//=。=没实现呢哦耶~~
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}

class salesImportPanel extends JPanel{
	JButton jbtImport=new JButton("销售");
	JButton jbtImportReturn=new JButton("销售退货");
	JPanel mainPanel=new JPanel(new GridLayout(17,1));
	
	//importListFrame:
	JFrame importListFrame=new JFrame();
	JLabel importTitle=new JLabel("新建销售单");
	JLabel importName=new JLabel("商品名",SwingConstants.RIGHT);
	JLabel importType=new JLabel("型号",SwingConstants.RIGHT);
	JLabel importID=new JLabel("编号",SwingConstants.RIGHT); 
	JLabel importNum=new JLabel("数量",SwingConstants.RIGHT);
	JLabel importPrice=new JLabel("单价",SwingConstants.RIGHT);
	JTextField importNameField=new JTextField("点击选择商品");
	JTextField importTypeField=new JTextField();
	JTextField importIDField=new JTextField();
	JTextField importNumField=new JTextField();
	JTextField importPriceField=new JTextField();
	JTextArea importTipArea=new JTextArea("备注");
	JPanel importTopPlusTitle=new JPanel(new BorderLayout());
	JPanel importTop=new JPanel(new GridLayout(5,2));
	JPanel importBottom=new JPanel(new BorderLayout());
	JPanel importButtons=new JPanel();
	JPanel importTotal=new JPanel(new GridLayout(2,1));
	JScrollPane TipJS=new JScrollPane(importTipArea);
	JButton jbtAssure=new JButton("提交");
	JButton jbtCancel=new JButton("取消");
	
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
				importTitle=new JLabel("新建销售单");
				importName=new JLabel("商品名",SwingConstants.RIGHT);
				importType=new JLabel("型号",SwingConstants.RIGHT);
				importID=new JLabel("编号",SwingConstants.RIGHT); 
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
				importListFrame.setTitle("销售");
				importListFrame.setVisible(true);
				
				jbtAssure.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JOptionPane.showMessageDialog(null, "提交成功");
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
				returnSearch=new JLabel("退回销售单的编号");
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


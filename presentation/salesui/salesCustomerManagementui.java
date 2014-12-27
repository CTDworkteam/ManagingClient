package salesui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import vo.ClientVO;
import clientbl.ClientController;
import enumType.ClientType;
import enumType.ResultMessage;

class salesCustomerManagementui extends JPanel{
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
	String[] column={"编号","类型","级别","名称","电话","地址","邮编","邮箱","默认业务员","应收数量","应收金额","应付金额","折扣","代金卷"};
	Object[][] rowData={{}};
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
	
	salesCustomerManagementui(){
		/*
		 * 
		 * 
		 * 初始化表格
		 * 
		 * 
		 * 
		 */
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
		
		//12.26
		jbtSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ClientController client=new ClientController();
				if(!customerIDField.getText().equals(""))
				{
					Object[][] emptyRow={{}};
					customerTableModel=new DefaultTableModel(emptyRow,column);
					customerTable=new JTable(customerTableModel);
					ClientVO vo=client.find(Long.parseLong(customerIDField.getText()));
					
					//"编号","类型","级别","名称","电话","地址","邮编","邮箱","默认业务员","应收数量","应收金额","应付金额","折扣","代金卷"
					Object[] newRow={vo.getId(),vo.getType(),vo.getRank(),vo.getName(),vo.getTelephone(),vo.getAddress(),vo.getPostcode(),vo.getEmail(),vo.getCourterman(),vo.getAmountReserved(),vo.getMoneyReserved(),vo.getMoneyToPay(),vo.getDiscount(),vo.getVoucher()};
					customerTableModel.addRow(newRow);
				}
				else
				{
					Object[][] emptyRow={{}};
					customerTableModel=new DefaultTableModel(emptyRow,column);
					customerTable=new JTable(customerTableModel);
					ArrayList<ClientVO> vos=client.finds(customerNameField.getText());
					int voNum=vos.size();
					for(int i=0;i<voNum;i++)
					{
						Object[] newRow={vos.get(i).getId(),vos.get(i).getType(),vos.get(i).getRank(),vos.get(i).getName(),vos.get(i).getTelephone(),vos.get(i).getAddress(),vos.get(i).getPostcode(),vos.get(i).getEmail(),vos.get(i).getCourterman(),vos.get(i).getAmountReserved(),vos.get(i).getMoneyReserved(),vos.get(i).getMoneyToPay(),vos.get(i).getDiscount(),vos.get(i).getVoucher()};
						customerTableModel.addRow(newRow);
					}
				}
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
			//12.26	
				jbtCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//注意修改rank 为阿拉伯数字
						ClientVO vo=new ClientVO(Long.parseLong(newCustomerIDField.getText()),newCustomerNameField.getText(),ClientType.Supplier,Integer.parseInt(newCustomerRankBox.getToolTipText()),newCustomerTelField.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),newCustomerEmailField.getText(),0,0,0,newCustomerCountermanBox.getToolTipText(),0,0);
						ClientController client=new ClientController();
						ResultMessage result=client.add(vo);
						if(result==ResultMessage.Success)
						{
						    Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),0,0,0,0,0};
						    customerTableModel.addRow(newRow);
						    JOptionPane.showMessageDialog(null, "添加成功");
						    newCustomerFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "添加失败");
						}
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
					ClientController client=new ClientController();
					int row=customerTable.getSelectedRow();
					ClientVO vo=new ClientVO(Long.parseLong((String)customerTable.getValueAt(row, 0)),(String)customerTable.getValueAt(row, 3),ClientType.Supplier,Integer.parseInt((String)customerTable.getValueAt(row, 2)),(String)customerTable.getValueAt(row, 4),(String)customerTable.getValueAt(row, 5),(String)customerTable.getValueAt(row, 6),(String)customerTable.getValueAt(row, 7),Double.parseDouble((String)customerTable.getValueAt(row, 9)),Double.parseDouble((String)customerTable.getValueAt(row, 10)),Double.parseDouble((String)customerTable.getValueAt(row, 11)),(String)customerTable.getValueAt(row, 8),Double.parseDouble((String)customerTable.getValueAt(row, 12)),Double.parseDouble((String)customerTable.getValueAt(row, 13)));
					ResultMessage result=client.delete(vo);
					if(result==ResultMessage.Success)
					{
						 customerTableModel.removeRow(customerTable.getSelectedRow());
				         JOptionPane.showMessageDialog(null, "删除成功");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				   
				}
			}
		});
		//12.26
		jbtUpdate.addActionListener(new ActionListener(){
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
				
				newCustomerIDField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),0));
				newCustomerRankBox.setSelectedIndex(0);
				newCustomerCountermanBox.setSelectedIndex(0);
				newCustomerNameField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),3));
		        newCustomerTelField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),4));
				newCustomerEmailField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),5));
				newCustomerAddressField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),6));
				newCustomerPostcodeField.setText((String)customerTable.getValueAt(customerTable.getSelectedRow(),7));
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
						//注意修改rank 为阿拉伯数字
						ClientVO vo=new ClientVO(Long.parseLong(newCustomerIDField.getText()),newCustomerNameField.getText(),ClientType.Supplier,Integer.parseInt(newCustomerRankBox.getToolTipText()),newCustomerTelField.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),newCustomerEmailField.getText(),0,0,0,newCustomerCountermanBox.getToolTipText(),0,0);
						ClientController client=new ClientController();
						ResultMessage result=client.update(vo);
						if(result==ResultMessage.Success)
						{
						//    Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),0,0,0,0,0};
						//    customerTableModel.addRow(newRow);
							//flash table here!!!!!
						    JOptionPane.showMessageDialog(null, "修改成功");
						    newCustomerFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "修改失败");
						}
					}
				});
				jbtNotCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						newCustomerFrame.dispose();
					}
				});
			}
		});
	}
}

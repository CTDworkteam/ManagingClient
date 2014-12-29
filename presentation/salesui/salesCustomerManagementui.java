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
	JButton jbtSearch=new JButton("����");
	JButton jbtAdd=new JButton("����");
	JButton jbtDelete=new JButton("ɾ��");
	JButton jbtUpdate=new JButton("�޸�");
	JLabel customerID=new JLabel("�ͻ����");
	JLabel customerName=new JLabel("�⻧����");
	JTextField customerIDField=new JTextField();
	JTextField customerNameField=new JTextField();
	String[] column={"���","����","����","����","�绰","��ַ","�ʱ�","����","Ĭ��ҵ��Ա","Ӧ������","Ӧ�ս��","Ӧ�����","�ۿ�","�����"};
	Object[][] rowData={{}};
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
	
	salesCustomerManagementui(){
		/*
		 * 
		 * 
		 * ��ʼ�����
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
					
					//"���","����","����","����","�绰","��ַ","�ʱ�","����","Ĭ��ҵ��Ա","Ӧ������","Ӧ�ս��","Ӧ�����","�ۿ�","�����"
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
			//12.26	
				jbtCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//ע���޸�rank Ϊ����������
						ClientVO vo=new ClientVO(Long.parseLong(newCustomerIDField.getText()),newCustomerNameField.getText(),ClientType.Supplier,Integer.parseInt(newCustomerRankBox.getToolTipText()),newCustomerTelField.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),newCustomerEmailField.getText(),0,0,0,newCustomerCountermanBox.getToolTipText(),0,0);
						ClientController client=new ClientController();
						ResultMessage result=client.add(vo);
						if(result==ResultMessage.Success)
						{
						    Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),0,0,0,0,0};
						    customerTableModel.addRow(newRow);
						    JOptionPane.showMessageDialog(null, "��ӳɹ�");
						    newCustomerFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "���ʧ��");
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
					JOptionPane.showMessageDialog(null, "δѡ��ɾ��Ŀ��");
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
				         JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
					}
				   
				}
			}
		});
		//12.26
		jbtUpdate.addActionListener(new ActionListener(){
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
				newCustomerFrame.setTitle("����������");
				newCustomerFrame.setVisible(true);
				jbtCreate.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//ע���޸�rank Ϊ����������
						ClientVO vo=new ClientVO(Long.parseLong(newCustomerIDField.getText()),newCustomerNameField.getText(),ClientType.Supplier,Integer.parseInt(newCustomerRankBox.getToolTipText()),newCustomerTelField.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),newCustomerEmailField.getText(),0,0,0,newCustomerCountermanBox.getToolTipText(),0,0);
						ClientController client=new ClientController();
						ResultMessage result=client.update(vo);
						if(result==ResultMessage.Success)
						{
						//    Object[] newRow={newCustomerIDField.getText(),newCustomerRankBox.getSelectedItem(),newCustomerCountermanBox.getSelectedItem(),newCustomerNameField.getText(),newCustomerTelField.getText(),newCustomerEmail.getText(),newCustomerAddressField.getText(),newCustomerPostcode.getText(),0,0,0,0,0};
						//    customerTableModel.addRow(newRow);
							//flash table here!!!!!
						    JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						    newCustomerFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "�޸�ʧ��");
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

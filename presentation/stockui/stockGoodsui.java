package stockui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vo.CommodityModelVO;
import vo.CommodityVO;

import commoditybl.CommodityController;

class stockGoodsui extends JPanel{
	private String[] columnName={"���","����","�ͺ�","����","��汨����","�������","����","���ۼ�","�������","������ۼ�"};
	private Object[][] rowData={
			{00001,"������","hehe",5,10,0,0,0,0}
	};
	private DefaultTableModel tableModel=new DefaultTableModel(rowData,columnName);
	private JTable jTable=new JTable(tableModel);
	private JLabel tip=new JLabel("������Ʒ�ؼ���");
	private JTextField keyField=new JTextField();
	private JButton jbtSearch=new JButton("����");
	private JButton jbtSee=new JButton("�鿴");
	private JButton jbtAdd=new JButton("����");
	private JButton jbtDelete=new JButton("ɾ��");
	private JButton jbtUpdate=new JButton("�޸�");
	private JScrollPane jScrollPane=new JScrollPane(jTable);
	
	JFrame insFrame;
	JLabel newName=new JLabel("����Ʒ����");
	JTextField nameField=new JTextField();
	JLabel newType=new JLabel("����Ʒ�ͺ�");
	JTextField typeField=new JTextField();
	JLabel newTipLine=new JLabel("��汨����");
	JTextField TipLineField=new JTextField();
	JButton jbtAssure=new JButton("ȷ��");
	JButton jbtCancel=new JButton("ȡ��");
	
	public stockGoodsui(){
		setLayout(new BorderLayout());
		JPanel top=new JPanel(new GridLayout(1,3));
		JPanel bottom=new JPanel(new GridLayout(1,3));
		top.add(tip);
		top.add(keyField);
		top.add(jbtSearch);
		bottom.add(jbtSee);
		bottom.add(jbtAdd);
		bottom.add(jbtDelete);
		bottom.add(jbtUpdate);
		add(top,BorderLayout.NORTH);
		add(jScrollPane,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		//δʵ��
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
						Object[] resultRow={vo.getId(),vo.getName(),modelvo.getModel(),vo.getType(),modelvo.getNoticeNumber(),modelvo.getStockNumber(),modelvo.getPurchasePrice(),modelvo.getRetailPrice(),modelvo.getRecentPurchasePrice(),modelvo.getRecentRetailPrice()};
					}
				}
			}
		});
		//δʵ��
		jbtSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		//δ��������
		jbtAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				insFrame=new JFrame();
				insFrame.pack();
				newName=new JLabel("����Ʒ����");
				nameField=new JTextField();
				newType=new JLabel("����Ʒ�ͺ�");
				typeField=new JTextField();
				newTipLine=new JLabel("��汨����");
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
						
						String nameInfo=nameField.getText();
						String typeInfo=typeField.getText();
						String warmInfo=TipLineField.getText();
						Object[] newRow={"00002",nameInfo,typeInfo," ",0,0,0,0,0,warmInfo};
						tableModel.addRow(newRow);
						insFrame.dispose();
					}
				});
				jbtCancel.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						insFrame.dispose();
					}
				});
			}
		});
		//δ�������ݣ�
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jTable.getSelectedRow()>=0)
					tableModel.removeRow(jTable.getSelectedRow());
			}
		});
		//δʵ�֣�
		jbtUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}

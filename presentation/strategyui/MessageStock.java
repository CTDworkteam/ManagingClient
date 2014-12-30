package strategyui;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import commoditybl.CommodityController;
import vo.*;

public class MessageStock {
	
	public JPanel panel=new JPanel();
	
	String[][] data=new String[200][9];
	String[] heading={"�ֿ���","��Ʒ���","��Ʒ��","��Ʒ�ͺ�","�������","����","�ۼ�","�������","����ۼ�"};
	JTable table=new JTable(data,heading);
	
	public MessageStock(){
		
		JButton button=new JButton("ˢ��");//ˢ�¿����Ϣ�б�
		button.addActionListener(new newListener());
		
		//��ȡ�����Ϣ�������
		CommodityController controller=new CommodityController();
		ArrayList<CommodityVO> commodities=controller.getAllCommodity();
		for(int t=0;t<commodities.size();t++){
			ArrayList<CommodityModelVO> commodityModels=new ArrayList<CommodityModelVO>();
			for(int k=0;k<commodityModels.size();k++){
				data[k][0]=commodities.get(t).getList().get(k).getStorehouse();
				data[k][1]=commodities.get(t).getList().get(k).getCommodity();
				data[k][2]=commodities.get(t).getName();
				data[k][3]=commodities.get(t).getList().get(k).getModel();
				data[k][4]=Integer.toString(commodities.get(t).getList().get(k).getStockNumber());
				data[k][5]=Double.toString(commodities.get(t).getList().get(k).getPurchasePrice());
				data[k][6]=Double.toString(commodities.get(t).getList().get(k).getRetailPrice());
				data[k][7]=Double.toString(commodities.get(t).getList().get(k).getRecentPurchasePrice());
				data[k][8]=Double.toString(commodities.get(t).getList().get(k).getRecentRetailPrice());
			}
		}
		//���ñ���ѡ��
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		//��������������ñ���п�
		JScrollPane scroller=new JScrollPane();
		scroller.getViewport().add(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		panel.setLayout(null);
		button.setBounds(330,3,65,25);
		scroller.setBounds(0,40,410,420);
		
		panel.add(button);
		panel.add(scroller);
	}
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			//��ȡ�����Ϣ�������
			CommodityController controller=new CommodityController();
			ArrayList<CommodityVO> commodities=controller.getAllCommodity();
			for(int t=0;t<commodities.size();t++){
				ArrayList<CommodityModelVO> commodityModels=new ArrayList<CommodityModelVO>();
				for(int k=0;k<commodityModels.size();k++){
					data[k][0]=commodities.get(t).getList().get(k).getStorehouse();
					data[k][1]=commodities.get(t).getList().get(k).getCommodity();
					data[k][2]=commodities.get(t).getName();
					data[k][3]=commodities.get(t).getList().get(k).getModel();
					data[k][4]=Integer.toString(commodities.get(t).getList().get(k).getStockNumber());
					data[k][5]=Double.toString(commodities.get(t).getList().get(k).getPurchasePrice());
					data[k][6]=Double.toString(commodities.get(t).getList().get(k).getRetailPrice());
					data[k][7]=Double.toString(commodities.get(t).getList().get(k).getRecentPurchasePrice());
					data[k][8]=Double.toString(commodities.get(t).getList().get(k).getRecentRetailPrice());
				}
			}
		}
	}

}

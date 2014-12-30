package initialui;
import javax.swing.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import initialbl.Initial;
import vo.*;
import enumType.ResultMessage;
import confirmui.*;
import commoditybl.CommodityController;

public class InitialCommodity {
	
	public JPanel panelCommodity=new JPanel();
	
	String[] heading={"商品编号","商品类别","商品名称","总量","型号","仓库","警戒数量","库存数量","进价","售价","最近进价","最近售价"};
	String[][] data=new String[100][12];
	JTable table=new JTable(data,heading);
	
	public InitialCommodity(){
		JButton button=new JButton("导入");
		
		button.addActionListener(new buttonListener());
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		panelCommodity.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelCommodity.add(button);
		panelCommodity.add(scroller);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Initial initial=new Initial();
			CommodityController controller=new CommodityController();
			ArrayList<CommodityVO> commodity=controller.getAllCommodity();
			ResultMessage result=initial.addCommodity(commodity);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("导入失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				int count=0;
				for(int t=0;t<commodity.size();t++){
					ArrayList<CommodityModelVO> model=commodity.get(t).getList();
					int k=0;
					for(k=0;k<model.size();k++){
						data[k+count][0]=commodity.get(t).getId();
						data[k+count][1]=commodity.get(t).getType();
						data[k+count][2]=commodity.get(t).getName();
						data[k+count][3]=Integer.toString(commodity.get(t).getTotal());
						data[k+count][4]=model.get(k).getModel();
						data[k+count][5]=model.get(k).getStorehouse();
						data[k+count][6]=Integer.toString(model.get(k).getNoticeNumber());
						data[k+count][7]=Integer.toString(model.get(k).getStockNumber());
						data[k+count][8]=Double.toString(model.get(k).getPurchasePrice());
						data[k+count][9]=Double.toString(model.get(k).getRetailPrice());
						data[k+count][10]=Double.toString(model.get(k).getRecentPurchasePrice());
						data[k+count][11]=Double.toString(model.get(k).getRecentRetailPrice());
					}
					count=count+k;
				}
			}
		}
	}
}

package initialui;

import java.util.*;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import vo.*;

public class LookCommodityType {
    
	JPanel panelCommodityType=new JPanel();
	
	String[] heading={"类名","类名","类名","类名","类名"};
	String[][] data=new String[100][5];
	JTable table=new JTable(data,heading);
	
	public LookCommodityType(ArrayList<CommodityTypeVO> type){
		
		for(int t=0;t<type.size();t++){
			data[t][0]=type.get(t).getFather().getName();
			ArrayList<CommodityTypeVO> child=type.get(t).getChild();
			for(int k=0;k<child.size();k++){
				data[t][k+1]=child.get(k).getName();
			}
		}
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelCommodityType.setLayout(null);		
		scroller.setBounds(0,35,820,500);
		
		panelCommodityType.add(scroller);
	}
}

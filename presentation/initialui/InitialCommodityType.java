package initialui;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import enumType.ResultMessage;
import confirmui.*;
import initialbl.Initial;
import commoditytypebl.CommodityTypeController;
import vo.*;

public class InitialCommodityType {

	JPanel panelCommodityType=new JPanel();
	
	String[] heading={"类名","类名","类名","类名","类名"};
	String[][] data=new String[100][5];
	JTable table=new JTable(data,heading);
	
	public InitialCommodityType(){
		
        JButton button=new JButton("导入");
        
        button.addActionListener(new buttonListener());
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(460,60));
		
		panelCommodityType.setLayout(null);
		button.setBounds(600,3,65,25);
		scroller.setBounds(0,35,820,500);
		
		panelCommodityType.add(button);
		panelCommodityType.add(scroller);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Initial initial=new Initial();
			CommodityTypeController controller=new CommodityTypeController();
			ArrayList<CommodityTypeVO> commodityType=controller.getAllCommodityType();
			ResultMessage result=initial.addCommodityType(commodityType);
			if(result==ResultMessage.Failure){
				Runnable r=new Confirmui("导入失败");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				for(int t=0;t<commodityType.size();t++){
					data[t][0]=commodityType.get(t).getFather().getName();
					ArrayList<CommodityTypeVO> child=commodityType.get(t).getChild();
					for(int k=0;k<child.size();k++){
						data[t][k+1]=child.get(k).getName();
					}
				}
			}
		}
	}
}

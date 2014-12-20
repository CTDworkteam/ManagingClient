package strategyui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import vo.*;
import vo.CombinationStrategyVO.CombinationItemVO;
import vo.GiftBasedOnTotalMoneyVO.GBOTMItemVO;
import vo.GiftStrategyVO.GiftItemVO;
import strategybl.StrategyController;

/*
 * 已有促销策略列表
 */
public class MessageStrategy {
	
	public JPanel panel=new JPanel();
	
	String[] heading={"编号","策略内容"};
	String[][] data;
	JTable table=new JTable(data,heading);
	
	public MessageStrategy(){
		
		JButton button=new JButton("刷新");
		button.addActionListener(new newListener());
		
		//获取表格数据信息
		StrategyController controller=new StrategyController();
		int count=0;
		ArrayList<DiscountStrategyVO> discounts=controller.getAllDiscounts();
		for(int t=0;t<discounts.size();t++){
			ArrayList<String> clients=discounts.get(t).getClientList();
			String client="";
			for(int k=0;k<clients.size();k++){
				client=client+clients.get(k)+";";
			}
			data[t][0]=discounts.get(t).getId();
			data[t][1]="折扣："+Double.toString(discounts.get(t).getDiscount())+"      "+"客户："+client;
			count++;
		}
		ArrayList<VoucherStrategyVO> vouchers=controller.getAllVouchers();
		for(int t=0;t<vouchers.size();t++){
			ArrayList<String> clients=vouchers.get(t).getClientList();
			String client="";
			for(int k=0;k<clients.size();k++){
				client=client+clients.get(k)+";";
			}
			data[count][0]=vouchers.get(t).getId();
			data[count][1]="代金券："+Double.toString(vouchers.get(t).getVoucher())+"      "+"客户："+client;
			count++;
		}
		ArrayList<CombinationStrategyVO> combinations=controller.getAllCombinations();
		for(int t=0;t<combinations.size();t++){
			ArrayList<CombinationItemVO> comdities=combinations.get(t).getList();
			String comdity="";
			for(int k=0;k<comdities.size();k++){
				comdity=comdity+comdities.get(k).getCommodity()+","+comdities.get(k).getModel()+","+Integer.toString(comdities.get(k).getNumber())+";";
			}
			data[count][0]=combinations.get(t).getId();
			data[count][1]="组合商品:"+comdity+"     "+"原价："+Double.toString(combinations.get(t).getInitialMoney())+"     "+"现价："+Double.toString(combinations.get(t).getLaterMoney());
			count++;
		}
		ArrayList<GiftStrategyVO> giftClient=controller.getAllGifts();
		for(int t=0;t<giftClient.size();t++){
			ArrayList<String> clients=giftClient.get(t).getClientList();
			String client="";
			for(int k=0;k<clients.size();k++){
				client=client+clients.get(k)+";";
			}
			ArrayList<GiftItemVO> items=giftClient.get(t).getList();
			String giftItem="";
			for(int k=0;k<items.size();k++){
				giftItem=giftItem+items.get(k).getCommodity()+","+items.get(k).getModel()+","+Integer.toString(items.get(k).getNumber())+";";
			}
			data[count][0]=giftClient.get(t).getId();
			data[count][1]="客户："+client+"     "+"赠品："+giftItem;
			count++;
		}
		ArrayList<GiftBasedOnTotalMoneyVO> giftMoney=controller.getAllGBOTMs();
		for(int t=0;t<giftMoney.size();t++){
			ArrayList<GBOTMItemVO> items=giftMoney.get(t).getList();
			String giftItem="";
			for(int k=0;k<items.size();k++){
				giftItem=giftItem+items.get(k).getCommodity()+","+items.get(k).getModel()+","+Integer.toString(items.get(k).getNumber())+";";
			}
			data[count][0]=giftMoney.get(t).getId();
			data[count][1]="价格下限："+Double.toString(giftMoney.get(t).getLower())+"     "+"价格上限："+Double.toString(giftMoney.get(t).getUpper())+"     "+"赠品："+giftItem;
			count++;
		}
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		
		JScrollPane scroller=new JScrollPane();
		scroller.getViewport().add(table);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table.getColumnModel().getColumn(1).setPreferredWidth(800);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		panel.setLayout(null);
		button.setBounds(330,3,65,25);
		scroller.setBounds(0,40,410,420);
		
		panel.add(scroller);
	}
	
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//获取表格数据信息
			StrategyController controller=new StrategyController();
			int count=0;
			ArrayList<DiscountStrategyVO> discounts=controller.getAllDiscounts();
			for(int t=0;t<discounts.size();t++){
				ArrayList<String> clients=discounts.get(t).getClientList();
				String client="";
				for(int k=0;k<clients.size();k++){
					client=client+clients.get(k)+";";
				}
				data[t][0]=discounts.get(t).getId();
				data[t][1]="折扣："+Double.toString(discounts.get(t).getDiscount())+"      "+"客户："+client;
				count++;
			}
			ArrayList<VoucherStrategyVO> vouchers=controller.getAllVouchers();
			for(int t=0;t<vouchers.size();t++){
				ArrayList<String> clients=vouchers.get(t).getClientList();
				String client="";
				for(int k=0;k<clients.size();k++){
					client=client+clients.get(k)+";";
				}
				data[count][0]=vouchers.get(t).getId();
				data[count][1]="代金券："+Double.toString(vouchers.get(t).getVoucher())+"      "+"客户："+client;
				count++;
			}
			ArrayList<CombinationStrategyVO> combinations=controller.getAllCombinations();
			for(int t=0;t<combinations.size();t++){
				ArrayList<CombinationItemVO> comdities=combinations.get(t).getList();
				String comdity="";
				for(int k=0;k<comdities.size();k++){
					comdity=comdity+comdities.get(k).getCommodity()+","+comdities.get(k).getModel()+","+Integer.toString(comdities.get(k).getNumber())+";";
				}
				data[count][0]=combinations.get(t).getId();
				data[count][1]="组合商品:"+comdity+"     "+"原价："+Double.toString(combinations.get(t).getInitialMoney())+"     "+"现价："+Double.toString(combinations.get(t).getLaterMoney());
				count++;
			}
			ArrayList<GiftStrategyVO> giftClient=controller.getAllGifts();
			for(int t=0;t<giftClient.size();t++){
				ArrayList<String> clients=giftClient.get(t).getClientList();
				String client="";
				for(int k=0;k<clients.size();k++){
					client=client+clients.get(k)+";";
				}
				ArrayList<GiftItemVO> items=giftClient.get(t).getList();
				String giftItem="";
				for(int k=0;k<items.size();k++){
					giftItem=giftItem+items.get(k).getCommodity()+","+items.get(k).getModel()+","+Integer.toString(items.get(k).getNumber())+";";
				}
				data[count][0]=giftClient.get(t).getId();
				data[count][1]="客户："+client+"     "+"赠品："+giftItem;
				count++;
			}
			ArrayList<GiftBasedOnTotalMoneyVO> giftMoney=controller.getAllGBOTMs();
			for(int t=0;t<giftMoney.size();t++){
				ArrayList<GBOTMItemVO> items=giftMoney.get(t).getList();
				String giftItem="";
				for(int k=0;k<items.size();k++){
					giftItem=giftItem+items.get(k).getCommodity()+","+items.get(k).getModel()+","+Integer.toString(items.get(k).getNumber())+";";
				}
				data[count][0]=giftMoney.get(t).getId();
				data[count][1]="价格下限："+Double.toString(giftMoney.get(t).getLower())+"     "+"价格上限："+Double.toString(giftMoney.get(t).getUpper())+"     "+"赠品："+giftItem;
				count++;
			}
		}
	}

}

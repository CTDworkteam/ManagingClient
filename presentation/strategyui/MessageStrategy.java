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
 * ���д��������б�
 */
public class MessageStrategy {
	
	public JPanel panel=new JPanel();
	
	String[] heading={"���","��������"};
	String[][] data;
	JTable table=new JTable(data,heading);
	
	public MessageStrategy(){
		
		JButton button=new JButton("ˢ��");
		button.addActionListener(new newListener());
		
		//��ȡ���������Ϣ
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
			data[t][1]="�ۿۣ�"+Double.toString(discounts.get(t).getDiscount())+"      "+"�ͻ���"+client;
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
			data[count][1]="����ȯ��"+Double.toString(vouchers.get(t).getVoucher())+"      "+"�ͻ���"+client;
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
			data[count][1]="�����Ʒ:"+comdity+"     "+"ԭ�ۣ�"+Double.toString(combinations.get(t).getInitialMoney())+"     "+"�ּۣ�"+Double.toString(combinations.get(t).getLaterMoney());
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
			data[count][1]="�ͻ���"+client+"     "+"��Ʒ��"+giftItem;
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
			data[count][1]="�۸����ޣ�"+Double.toString(giftMoney.get(t).getLower())+"     "+"�۸����ޣ�"+Double.toString(giftMoney.get(t).getUpper())+"     "+"��Ʒ��"+giftItem;
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
			//��ȡ���������Ϣ
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
				data[t][1]="�ۿۣ�"+Double.toString(discounts.get(t).getDiscount())+"      "+"�ͻ���"+client;
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
				data[count][1]="����ȯ��"+Double.toString(vouchers.get(t).getVoucher())+"      "+"�ͻ���"+client;
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
				data[count][1]="�����Ʒ:"+comdity+"     "+"ԭ�ۣ�"+Double.toString(combinations.get(t).getInitialMoney())+"     "+"�ּۣ�"+Double.toString(combinations.get(t).getLaterMoney());
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
				data[count][1]="�ͻ���"+client+"     "+"��Ʒ��"+giftItem;
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
				data[count][1]="�۸����ޣ�"+Double.toString(giftMoney.get(t).getLower())+"     "+"�۸����ޣ�"+Double.toString(giftMoney.get(t).getUpper())+"     "+"��Ʒ��"+giftItem;
				count++;
			}
		}
	}

}

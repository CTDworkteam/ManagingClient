package billui;
import javax.swing.*;

/*
 * 审批单据界面
 */
public class Billui {
	
	public JPanel panelBill=new JPanel();
	
	public Billui(){
		
		ImageIcon iconMoney=new ImageIcon("currency_yuan_red.png");
		JButton buttonMoney=new JButton("财务单据");
		buttonMoney.setIcon(iconMoney);
		
		ImageIcon iconStock=new ImageIcon("storehouse.png");
		JButton buttonStock=new JButton("库存单据");
		buttonStock.setIcon(iconStock);
		
		ImageIcon iconBuy=new ImageIcon("buy.png");
		JButton buttonBuy=new JButton("进货单据");
		buttonBuy.setIcon(iconBuy);
		
		ImageIcon iconSale=new ImageIcon("sale.png");
		JButton buttonSale=new JButton("销售单据");
		buttonSale.setIcon(iconSale);
		
		panelBill.setLayout(null);
		buttonMoney.setBounds(100,200,90,90);
		buttonStock.setBounds(290,200,90,90);
		buttonBuy.setBounds(480,100,90,90);
		buttonSale.setBounds(480,300,90,90);
		
		panelBill.add(buttonMoney);
		panelBill.add(buttonStock);
		panelBill.add(buttonBuy);
		panelBill.add(buttonSale);
	}

}

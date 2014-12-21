package billui;
import javax.swing.*;

/*
 * 审批单据界面
 */
public class Billui {
	
	public JPanel panelBill=new JPanel();
	
	public Billui(){
		JButton buttonMoney=new JButton("财务单据");
		JButton buttonStock=new JButton("库存单据");
		JButton buttonBuy=new JButton("进货单据");
		JButton buttonSale=new JButton("销售单据");
		
		panelBill.setLayout(null);
		buttonMoney.setBounds(100,200,100,25);
		buttonStock.setBounds(290,200,100,25);
		buttonBuy.setBounds(480,100,100,25);
		buttonSale.setBounds(480,300,100,25);
		
		panelBill.add(buttonMoney);
		panelBill.add(buttonStock);
		panelBill.add(buttonBuy);
		panelBill.add(buttonSale);
	}

}

package billui;
import javax.swing.*;

/*
 * �������ݽ���
 */
public class Billui {
	
	public JPanel panelBill=new JPanel();
	
	public Billui(){
		JButton buttonMoney=new JButton("���񵥾�");
		JButton buttonStock=new JButton("��浥��");
		JButton buttonBuy=new JButton("��������");
		JButton buttonSale=new JButton("���۵���");
		
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

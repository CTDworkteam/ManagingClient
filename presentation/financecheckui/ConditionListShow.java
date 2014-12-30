package financecheckui;
import javax.swing.*;
import java.awt.event.*;
import vo.*;
import confirmui.*;
import financecheckbl.FinanceCheckController;
import enumType.ResultMessage;

public class ConditionListShow {
	
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	
	JLabel label=new JLabel("经营情况表");
	
	JTextField fieldDest=new JTextField();
	
	ConditionListVO vo=new ConditionListVO(null,null,null,null, 0);
	
	public void go(ConditionListVO vo){
		
		this.vo=vo;
		
		int wide=frame.getToolkit().getScreenSize().width;
		int high=frame.getToolkit().getScreenSize().height;
		
		frame.setSize(wide/3,high-250);
		frame.setLocation(wide/3,high/6);
		
		JLabel labelStart=new JLabel("开始时间："+vo.getStart());
		JLabel labelEnd=new JLabel("结束时间："+vo.getEnd());
		JLabel labelIn=new JLabel("收入：");
		JLabel labelOut=new JLabel("支出：");
		JLabel labelTotal=new JLabel("总额："+Double.toString(vo.getTotal()));
		
		fieldDest=new JTextField();
		JButton button=new JButton("导出");
		
		button.addActionListener(new buttonListener());
		
		String[] headingIn={"销售收入","商品报溢收入","成本调价收入","进货退货差价","代金券与实际收款差额收入","折让","总计"};
		InVO in=vo.getIn();
		String[][] dataIn={{Double.toString(in.getSalesIn()),Double.toString(in.getOverflowIn()),Double.toString(in.getBaseChangeIn()),Double.toString(in.getReturnIn()),Double.toString(in.getVoucherIn()),Double.toString(in.getDiscount()),Double.toString(in.getTotal())}};
		JTable tableIn=new JTable(dataIn,headingIn);
		tableIn.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableIn.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableIn.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableIn.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableIn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollerIn=new JScrollPane(tableIn);
		scrollerIn.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		String[] headingOut={"销售成本","商品报损","商品赠出","总计"};
		OutVO out=vo.getOut();
		String[][] dataOut={{Double.toString(out.getSalesBase()),Double.toString(out.getUnderflowOut()),Double.toString(out.getGiftOut()),Double.toString(out.getTotal())}};
		JTable tableOut=new JTable(dataOut,headingOut);
		JScrollPane scrollerOut=new JScrollPane(tableOut);
		scrollerOut.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		panel.setLayout(null);
		
		label.setBounds(200,10,100,50);
		labelStart.setBounds(30,130,150,25);
		labelEnd.setBounds(200,130,150,25);
		labelIn.setBounds(30,190,65,25);
		scrollerIn.setBounds(30,225,400,60);
		labelOut.setBounds(30,315,65,25);
		scrollerOut.setBounds(30,350,400,60);
		labelTotal.setBounds(380,450,80,25);
		button.setBounds(300,495,65,25);
		
		panel.add(label);
		panel.add(labelStart);
		panel.add(labelEnd);
		panel.add(labelIn);
		panel.add(scrollerIn);
		panel.add(labelOut);
		panel.add(scrollerOut);
		panel.add(labelTotal);
		panel.add(button);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FinanceCheckController controller=new FinanceCheckController();
			ResultMessage result=controller.export(vo, fieldDest.getText());
			String message="";
			if(result==ResultMessage.Failure){
				message="导出失败";
			}else{
				message="已成功导出";
			}
			Runnable r=new Confirmui(message);
			Thread thread=new Thread(r);
			thread.start();
		}
	}
	
}

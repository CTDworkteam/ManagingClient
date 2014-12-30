package financecheckui;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;

import financecheckbl.FinanceCheckController;
import commoditybl.CommodityController;
import clientbl.ClientController;
import userbl.UserController;
import vo.*;
import vo.DetailListVO.DetailListItemVO;
import confirmui.*;

/*
 * 销售明细表审批界面
 */
public class DetailListCheck {

	JPanel panel=new JPanel();
	
	JTextField fieldStart=new JTextField();
	JTextField fieldEnd=new JTextField();
	JComboBox<String> boxCommodity=new JComboBox<String>();
	JComboBox<String> boxClient=new JComboBox<String>();
	JComboBox<String> boxOperator=new JComboBox<String>();
	JTextField fieldStorehouse=new JTextField();
	
	ArrayList<CommodityVO> commodities=new ArrayList<CommodityVO>();
	ArrayList<ClientVO> clients=new ArrayList<ClientVO>();
	ArrayList<UserVO> operators=new ArrayList<UserVO>();
	
	public DetailListCheck(){
		
		JLabel labelStart=new JLabel("开始时间：");
		fieldStart.setText("年/月/日");
		JLabel labelEnd=new JLabel("结束时间：");
		fieldEnd.setText("年/月/日");
		
		JLabel labelCommodity=new JLabel("商品名：");
		boxCommodity.addItem(null);
		CommodityController commodityController=new CommodityController();
		commodities=commodityController.getAllCommodity();
		for(int t=0;t<commodities.size();t++){
			boxCommodity.addItem(commodities.get(t).getName());
		}
		
		JLabel labelClient=new JLabel("客户：");
		boxClient.addItem(null);
		ClientController clientController=new ClientController();
		clients=clientController.getList();
		for(int t=0;t<clients.size();t++){
			boxClient.addItem(clients.get(t).getName());
		}
		
		JLabel labelOperator=new JLabel("操作员：");
		boxOperator.addItem(null);
		UserController userController=new UserController();
		operators=userController.getAll().getSalesmanager();
		for(int t=0;t<operators.size();t++){
			boxOperator.addItem(operators.get(t).getName());
		}
		
		JLabel labelStorehouse=new JLabel("仓库");
		JButton button=new JButton("查询");
		
		panel.setLayout(null);
		
		labelStart.setBounds(20,20,80,25);
		fieldStart.setBounds(100,20,80,25);
		labelEnd.setBounds(210,20,80,25);
		fieldStart.setBounds(290,20,80,25);
		labelStorehouse.setBounds(20,60,80,25);
		fieldStorehouse.setBounds(100,60,80,25);
		labelCommodity.setBounds(20,95,80,25);
		boxCommodity.setBounds(100,95,80,25);
		labelClient.setBounds(210,100,60,25);
		boxClient.setBounds(270,100,80,25);
		labelOperator.setBounds(370,100,60,25);
		boxOperator.setBounds(430,100,80,25);
		button.setBounds(350,200,65,65);
		
		panel.add(labelStart);
		panel.add(fieldStart);
		panel.add(labelEnd);
		panel.add(fieldEnd);
		panel.add(labelStorehouse);
		panel.add(fieldStorehouse);
		panel.add(labelCommodity);
		panel.add(boxCommodity);
		panel.add(labelClient);
		panel.add(boxClient);
		panel.add(labelOperator);
		panel.add(boxOperator);
		panel.add(button);
	}
	
	class buttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(fieldStart.getText().equals(null)&&fieldStorehouse.getText().equals(null)&&((String)boxCommodity.getSelectedItem()).equals(null)&&((String)boxClient.getSelectedItem()).equals(null)&&((String)boxOperator.getSelectedItem()).equals(null)){
				Runnable r=new Confirmui("请填写查询条件");
				Thread thread=new Thread(r);
				thread.start();
			}else{
				FinanceCheckController controller=new FinanceCheckController();
				
				ArrayList<DetailListItemVO> listTime=new ArrayList<DetailListItemVO>();
				if(fieldStart.getText()!=null||fieldEnd.getText()!=null){
					if(fieldStart.getText()!=null&&fieldEnd.getText()!=null){
						GregorianCalendar start=new GregorianCalendar();
						String[] theStart=fieldStart.getText().split("/");
						start.set(Integer.parseInt(theStart[0]), Integer.parseInt(theStart[1]), Integer.parseInt(theStart[2]));
						GregorianCalendar end=new GregorianCalendar();
						String[] theEnd=fieldEnd.getText().split("/");
						end.set(Integer.parseInt(theEnd[0]), Integer.parseInt(theEnd[1]), Integer.parseInt(theEnd[2]));
						listTime=controller.getDetailList(start, end).getList();
					}else{
						Runnable r=new Confirmui("请完整填写查询时间区间");
						Thread thread=new Thread(r);
						thread.start();
					}
				}
				
				String storehouse=fieldStorehouse.getText();
				ArrayList<DetailListItemVO> listStorehouse=new ArrayList<DetailListItemVO>();
				if(!storehouse.equals(null)){
					listStorehouse=controller.getDetailListInStorehouse(storehouse).getList();
				}
				
				String commodity=(String)boxCommodity.getSelectedItem();
				ArrayList<DetailListItemVO> listCommodity=new ArrayList<DetailListItemVO>();
				if(commodity!=null){
					listCommodity=controller.getDetailList(commodity).getList();
				}
				
				ArrayList<DetailListItemVO> listClient=new ArrayList<DetailListItemVO>();
				if(boxClient.getSelectedItem()!=null){
					ClientVO client=new ClientVO();
					for(int t=0;t<clients.size();t++){
						if(clients.get(t).getName()==(String)boxClient.getSelectedItem()){
							client=clients.get(t);
						}
					}
					listClient=controller.getDetailList(client).getList();
				}
				
				ArrayList<DetailListItemVO> listOperator=new ArrayList<DetailListItemVO>();
				if(!((String)boxOperator.getSelectedItem()).equals(null)){
					UserVO operator=new UserVO();
					for(int t=0;t<operators.size();t++){
						if(operators.get(t).getName().equals((String)boxOperator.getSelectedItem())){
							operator=operators.get(t);
						}
					}
					listOperator=controller.getDetailList(operator).getList();
				}
				
				ArrayList<DetailListItemVO> list=new ArrayList<DetailListItemVO>();
				int sizeTime=listTime.size();
				int sizeStorehouse=listStorehouse.size();
				int sizeCommodity=listCommodity.size();
				int sizeClient=listClient.size();
				int sizeOperator=listOperator.size();
				if(sizeTime>0){
					list=listTime;
				}else{
					if(sizeStorehouse>0){
						list=listStorehouse;
					}else{
						if(sizeCommodity>0){
							list=listCommodity;
						}else{
							if(sizeClient>0){
								list=listClient;
							}else{
								list=listOperator;
							}
						}
					}
				}
				
				if(sizeTime>0){
					for(int t=0;t<list.size();){
						for(int k=0;k<sizeTime;k++){
							if(list.get(t).equals(listTime.get(k))){
								t++;
								break;
							}else{
								if(k==sizeTime-1){
									list.remove(t);
								}
							}
						}
					}
				}
				
				if(sizeStorehouse>0){
					for(int t=0;t<list.size();){
						for(int k=0;k<sizeStorehouse;k++){
							if(list.get(t).equals(listStorehouse.get(k))){
								t++;
								break;
							}else{
								if(k==sizeStorehouse-1){
									list.remove(t);
								}
							}
						}
					}
				}
				
				if(sizeCommodity>0){
					for(int t=0;t<list.size();){
						for(int k=0;k<sizeCommodity;k++){
							if(list.get(t).equals(listCommodity.get(k))){
								t++;
								break;
							}else{
								if(k==sizeCommodity-1){
									list.remove(t);
								}
							}
						}
					}
				}
				
				if(sizeClient>0){
					for(int t=0;t<list.size();){
						for(int k=0;k<sizeClient;k++){
							if(list.get(t).equals(listClient.get(k))){
								t++;
								break;
							}else{
								if(k==sizeClient-1){
									list.remove(t);
								}
							}
						}
					}
				}
				
				if(sizeOperator>0){
					for(int t=0;t<list.size();){
						for(int k=0;k<sizeOperator;k++){
							if(list.get(t).equals(listClient.get(k))){
								t++;
								break;
							}else{
								if(k==sizeOperator-1){
									list.remove(t);
								}
							}
						}
					}
				}
				
				DetailListVO vo=new DetailListVO(fieldStart.getText(),fieldEnd.getText(),(String)boxCommodity.getSelectedItem(),(String)boxOperator.getSelectedItem(),(String)boxClient.getSelectedItem(),fieldStorehouse.getText(),list);
				DetailListShow show=new DetailListShow();
				show.go(vo);
			}
			
			
		}
	}
}

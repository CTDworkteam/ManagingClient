package mainui;
import javax.swing.*;

import purchaseui.Purchaseui;
import financemanagerui.Financemanagerui;
import managerui.Managerui;
import enumType.UserJob;
import salesui.Salesui;
import stockui.Stockui;
import vo.*;

/*
 * 各工作人员工作界面跳转
 */
public class Mainui {
	
	JFrame frame;
	JPanel panel;
	
	Financemanagerui finance=new Financemanagerui();
	Managerui manager=new Managerui();
	Stockui stock=new Stockui();
	Purchaseui purchase=new Purchaseui();
	Salesui sales=new Salesui();
	
	public void go(UserVO vo){
		
		UserJob job=vo.getRole();
		if(job==UserJob.FinanceManager){
			finance.go(vo.getName());
		}
		if(job==UserJob.PurchaseManager){
			purchase.go(vo.getName());
		}
		if(job==UserJob.StockManager){
			stock.go(vo.getName());
		}
		if(job==UserJob.SalesManager){
			sales.go(vo.getName());
		}
		if(job==UserJob.Manager){
			manager.go(vo.getName());
		}
	}

}

package mainui;
import javax.swing.*;
import financemanagerui.Financemanagerui;
import managerui.Managerui;
import enumType.UserJob;
import vo.*;

/*
 * 各工作人员工作界面跳转
 */
public class Mainui {
	
	JFrame frame;
	JPanel panel;
	
	Financemanagerui finance=new Financemanagerui();
	Managerui manager=new Managerui();
	
	public void go(UserVO vo){
		
		UserJob job=vo.getRole();
		if(job==UserJob.FinanceManager){
			finance.go(vo.getName());
		}
		if(job==UserJob.PurchaseManager){
			
		}
		if(job==UserJob.StockManager){
			
		}
		if(job==UserJob.SalesManager){
			
		}
		if(job==UserJob.Manager){
			manager.go(vo.getName());
		}
	}

}

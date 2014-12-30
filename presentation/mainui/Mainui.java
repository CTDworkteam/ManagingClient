package mainui;
import financemanagerui.Financemanagerui;
import managerui.Managerui;
import enumType.UserJob;
import vo.*;

/*
 * ��������Ա����������ת
 */
public class Mainui {
	
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

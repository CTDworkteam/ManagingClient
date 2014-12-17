package mainui;
import financemanagerui.Financemanagerui;
import managerui.Managerui;

public class Mainui {
	
	Financemanagerui finance=new Financemanagerui();
	Managerui manager=new Managerui();
	
	public void Jump(String work){
		if(work=="财务人员"){
			finance.go();
		}
		if(work=="进货人员"){
			
		}
		if(work=="库存管理员"){
			
		}
		if(work=="销售人员"){
			
		}
		if(work=="总经理"){
			manager.go();
		}
	}

}

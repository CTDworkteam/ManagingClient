package financecheckbl;
import vo.*;
import java.util.*;
public class FinanceCheckTester {
	public void detailListTester1(ClientVO vo){
		DetailListVO list=new MockFinanceCheck().getDetailList(vo);
		showDetaiList(list);
	}
	public void detailListTester2(GregorianCalendar start,GregorianCalendar end){
		DetailListVO list=new MockFinanceCheck().getDetailList(start,end);
		showDetaiList(list);
	}
	public void detailListTester3(String commodity){
		DetailListVO list=new MockFinanceCheck().getDetailList(commodity);
		showDetaiList(list);
	}
	public void detaiListTester4(String storehouse){
		DetailListVO list=new MockFinanceCheck().getDetailList(storehouse);
		showDetaiList(list);
	}
	public void detaiListTester5(ClientVO vo){
		DetailListVO list=new MockFinanceCheck().getDetailList(vo);
		showDetaiList(list);
	}
	public void detailListTester6(UserVO vo){
		DetailListVO list=new MockFinanceCheck().getDetailList(vo);
		showDetaiList(list);
	}
	public void showDetaiList(DetailListVO list){
		if(list.getList().size()==0){
			System.out.println("NULL");
			return;
		}
		System.out.println("Start Time:"+list.getStart().toString());
		System.out.println("End Time:"+list.getEnd().toString());
		System.out.println("Client:"+list.getClient());
		System.out.println("Commodity:"+list.getCommodity());
		System.out.println("Operator:"+list.getOperator());
		System.out.println("Storehouse:"+list.getStorehouse());
		for(int i=0;i<=list.getList().size()-1;i++){
			System.out.println(list.getList().get(i).getDate()+" "+list.getList().get(i).getCommodity()
					+" "+list.getList().get(i).getModel()+" "+list.getList().get(i).getCommodity()+" "+list.getList().get(i).getModel()
					+" "+list.getList().get(i).getNumber()+" "+list.getList().get(i).getPrice()+" "+list.getList().get(i).getTotal());
		}
	}
}

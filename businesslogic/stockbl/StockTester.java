package stockbl;
import enumType.*;
import vo.*;

public class StockTester {
	public void testSend(GiftBillVO bill){
		MockStock stock=new MockStock();
		if(stock.send(bill)==ResultMessage.Failure)
			System.out.println("We have failed to send the gift bill");
		else
			System.out.println("We have succeeded to send the gift bill");
	}
	public void testSend(OverflowBillVO bill){
		MockStock stock=new MockStock();
		if(stock.send(bill)==ResultMessage.Failure)
			System.out.println("We have failed to send the overflow bill");
		else
			System.out.println("We have succeeded to send the overflow bill");
	}
	public void testSend(UnderflowBillVO bill){
		MockStock stock=new MockStock();
		if(stock.send(bill)==ResultMessage.Failure)
			System.out.println("We have failed to send the underflow bill");
		else
			System.out.println("We have succeeded to send the underflow bill");
	}
	public void testSend(NoticeBillVO bill){
		MockStock stock=new MockStock();
		if(stock.send(bill)==ResultMessage.Failure)
			System.out.println("We have failed to send the notice bill");
		else
			System.out.println("We have succeeded to send the notice bill");
	}
}

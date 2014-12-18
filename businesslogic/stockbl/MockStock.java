package stockbl;
import java.util.*;
import vo.*;
import enumType.*;
import userbl.User;
import commoditybl.Commodity;

public class MockStock extends Stock{
	/*private static Commodity[] commodity={new Commodity(),new Commodity()};
	public MockStock(){
	}
	public MockStock(HashMap<String,GiftBill> listOfGiftBill,HashMap<String,OverflowBill> listOfOverflowBill,HashMap<String,UnderflowBill> listOfUnderflowBill,HashMap<String,NoticeBill> listOfNoticeBill,User operator){
		this.listOfGiftBill=listOfGiftBill;
		this.listOfOverflowBill=listOfOverflowBill;
		this.listOfUnderflowBill=listOfUnderflowBill;
		this.listOfNoticeBill=listOfNoticeBill;
		this.operator=operator;
	}
	public ResultMessage send(GiftBillVO bill){
		for(int i=0;i<bill.getList().size();i++){
			if(!(bill.getList().get(i).getCommodity()==commodity[0].id||bill.getList().get(i).getCommodity()==commodity[1].id))
				return ResultMessage.Failure;
		}
		return ResultMessage.Success;
	}
	public ResultMessage send(OverflowBillVO bill){
	    if(!(bill.getCommodity()==commodity[0].id||bill.getCommodity()==commodity[1].id))
			return ResultMessage.Failure;
		return ResultMessage.Success;
	}
	public ResultMessage send(UnderflowBillVO bill){
		if(!(bill.getCommodity()==commodity[0].id||bill.getCommodity()==commodity[1].id))
			return ResultMessage.Failure;
		return ResultMessage.Success;
	}
	public ResultMessage send(NoticeBillVO bill){
		if(!(bill.getCommodity()==commodity[0].id||bill.getCommodity()==commodity[1].id))
			return ResultMessage.Failure;
		return ResultMessage.Success;
	}
	public void execute(GiftBillVO bill){
		for(int i=0;i<bill.getList().size();i++){
			if(!(bill.getList().get(i).getCommodity()==commodity[0].id||bill.getList().get(i).getCommodity()==commodity[1].id)){
				System.out.println("error");
				break;
			}	
		}	
		System.out.println("success");
	}
	public void execute(OverflowBillVO bill){
		if(!(bill.getCommodity()==commodity[0].id||bill.getCommodity()==commodity[1].id))
			System.out.println("error");
		System.out.println("success");
	}
	public void execute(UnderflowBillVO bill){
		if(!(bill.getCommodity()==commodity[0].id||bill.getCommodity()==commodity[1].id))
			System.out.println("error");
		System.out.println("success");
	}*/
}

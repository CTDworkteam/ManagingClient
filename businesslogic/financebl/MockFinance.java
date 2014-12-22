package financebl;
import java.util.ArrayList;
import accountbl.Account;
import userbl.*;
import clientbl.*;
import vo.*;
import enumType.*;

public class MockFinance extends Finance{
	public MockFinance(){
		
	}
	/*private static Account[] account={new Account(1,"A",1000),new Account(2,"B",2000)};
	private static Client[] client={new Client(),new Client()};
	private static Payment[] payment={new Payment("FKD2014111500001",new Client(),new User(),new ArrayList<FinanceItem>(),100),new Payment("FKD2014111500002",new Client(),new User(),new ArrayList<FinanceItem>(),100)};
	private static Recipt[] recipt={new Recipt("SKD2014111500001",new Client(),new User(),new ArrayList<FinanceItem>(),100),new Recipt("SKD2014111500002",new Client(),new User(),new ArrayList<FinanceItem>(),100)};
	ArrayList<FinanceItemVO> list=new ArrayList<FinanceItemVO>();
	public ResultMessage addRecipt(ReciptVO vo){
		list=vo.getList();
		int size=list.size();
		for(int i=0;i<size;i++){
			if((list.get(i).getAccount().equals(account[0].name)||list.get(i).getAccount().equals(account[1].name))&&(vo.getClient().equals(client[0].id)||vo.getClient().equals(client[1].id))){
				return ResultMessage.Success;
			}
		}
		return ResultMessage.Failure;
	}
	public ResultMessage addPayment(PaymentVO vo){
		list=vo.getList();
		int size=list.size();
		for(int i=0;i<size;i++){
			if(((list.get(i).getAccount().equals(account[0].name)&&vo.getTotal()<=account[0].money)||(list.get(i).getAccount().equals(account[1].name)&&vo.getTotal()<=account[1].money))&&(vo.getClient().equals(client[0].id)||vo.getClient().equals(client[1].id))){
				return ResultMessage.Success;
			}
		}
		return ResultMessage.Failure;
	}
	public ResultMessage deleteRecipt(ReciptVO vo){
		if(vo.getId().equals(recipt[0].id)||vo.getId().equals(recipt[1].id))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	public ResultMessage deletePayment(PaymentVO vo){
		if(vo.getId().equals(payment[0].id)||vo.getId().equals(payment[1].id))
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	public ResultMessage sendRecipt(ArrayList<ReciptVO> bills){
		int size=bills.size();
		for(int i=0;i<size;i++){
			if(!(bills.get(i).getId().equals(recipt[0].id)||bills.get(i).getId().equals(recipt[1].id)))
				return ResultMessage.Failure;
		}
		return ResultMessage.Success;
	}
	public ResultMessage sendPayment(ArrayList<PaymentVO> bills){
		int size=bills.size();
		for(int i=0;i<size;i++){
			if(!(bills.get(i).getId().equals(payment[0].id)||bills.get(i).getId().equals(payment[1].id)))
				return ResultMessage.Failure;
		}
		return ResultMessage.Success;
	}
	public ResultMessage save(){
		return ResultMessage.Success;
	}
	public ResultMessage executeBill(ReciptVO vo){
		list=vo.getList();
		int size=list.size();
		for(int i=0;i<size;i++){
			if((list.get(i).getAccount().equals(account[0].name)||list.get(i).getAccount().equals(account[1].name))&&(vo.getClient().equals(client[0].id)||vo.getClient().equals(client[1].id))){
				return ResultMessage.Success;
			}
		}
		return ResultMessage.Failure;
	}
	public ResultMessage executeBill(PaymentVO vo){
		list=vo.getList();
		int size=list.size();
		for(int i=0;i<size;i++){
			if(((list.get(i).getAccount().equals(account[0].name)&&vo.getTotal()<=account[0].money)||(list.get(i).getAccount().equals(account[1].name)&&vo.getTotal()<=account[1].money))&&(vo.getClient().equals(client[0].id)||vo.getClient().equals(client[1].id))){
				return ResultMessage.Success;
			}
		}
		return ResultMessage.Failure;
	}*/
}

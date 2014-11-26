package accountbl;
import enumType.ResultMessage;
import vo.*;
public class AccountTester {
	public void testAdder(AccountVO vo){
		MockAccount account=new MockAccount();
		if(account.add(vo)==ResultMessage.Failure){
			System.out.println("We have failed to add the new account");
		}
		else{
			System.out.println("We have succeeded to add the account");
		}
	}
	public void testDelete(AccountVO vo){
		MockAccount account=new MockAccount();
		if(account.delete(vo)==ResultMessage.Failure){
			System.out.println("We have failed to delete the account");
		}
		else{
			System.out.println("We have succeeded to delete the account");
		}
	}
	public void testUpdate(AccountVO vo){
		MockAccount account=new MockAccount();
		if(account.update(vo)==ResultMessage.Failure){
			System.out.println("We have failed to updated the account");
		}
		else{
			System.out.println("We have succeeded to updated the account");
		}
	}
	public void testFind(String name){
		MockAccount account=new MockAccount();
		AccountVO vo=account.find(name);
		if(vo.getId()==-1){
			System.out.println("The account does not exist");
		}
		else{
			System.out.println("Account Information");
			System.out.println("ID:"+vo.getId());
			System.out.println("Name:"+vo.getName());
			System.out.println("Money:"+vo.getMoney());
		}
	}
}

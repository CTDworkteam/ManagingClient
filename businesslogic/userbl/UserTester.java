package userbl;

import enumType.ResultMessage;
import vo.*;

public class UserTester {
	public void testAdd(UserVO vo){
		MockUser u=new MockUser();
		if(u.addUser(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to add the new user");
		}
		else{
			System.out.println("We have failed to add the new user");
		}
	}
	
	public void testDel(long id){
		MockUser u=new MockUser();
		if(u.deleteUser(id)==ResultMessage.Success){
			System.out.println("We have succeeded to delete the new user");
		}
		else{
			System.out.println("We have failed to delete the new user");
		}
	}
	
	public void testFind(long id){
		MockUser u=new MockUser();
		UserVO v=u.findUser(id);
		if(v==null){
			System.out.println("the user doesn't exist!");
		}
		else{
			System.out.println("User Information");
			System.out.println("ID:"+v.getId());
			System.out.println("Name:"+v.getName());
			System.out.println("role:"+v.getRole());
		}
	}
	
	public void testCheck(RegisterInfoVO r){
		MockUser u=new MockUser();
		if(u.checkRegister(r)==ResultMessage.Success){
			System.out.println("We have succeeded to find the new user");
		}
		else{
			System.out.println("We have failed to find the new user");
		}
	}
}

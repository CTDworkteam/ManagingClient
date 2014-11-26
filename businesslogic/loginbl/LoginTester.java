package loginbl;

import enumType.ResultMessage;
import enumType.UserJob;

public class LoginTester {
	public void testVerify(){
		MockLogin ml=new MockLogin(10010,"f");
		if(ml.verify(ml.id,ml.password)==ResultMessage.Failure){
			System.out.println("we have failed to verify the new login");
		}
		else{
			System.out.println("we have succeeded to verify the new login");
		}
	}
	
	public void testRegister(){
		MockLogin ml=new MockLogin(10010,"f");
		if(ml.name=="123"){
			System.out.println("we have succeeded to register the new login");
		}
		else{
			System.out.println("we have failed to register the new login");
		}
	}
	
	public void testPassword(){
		MockLogin ml=new MockLogin(10010,"f");
		if(ml.getPassword(ml.id,"123",UserJob.SalesManager)==ml.password){
			System.out.println("we have succeeded to get the password of the new login");
		}
		else{
			System.out.println("we have failed to get the password of the new login");
		}
	}
}

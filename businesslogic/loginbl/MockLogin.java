package loginbl;

import enumType.*;

public class MockLogin extends Login{
	private static Login l=new Login(10010,"f");
	private UserJob s=UserJob.SalesManager;
	String name="123";
	
	public MockLogin(){
	}
	
	public 	MockLogin(long i,String p){
		this.id=i;
		this.password=p;
	}
	
	public ResultMessage verify(long id,String password){
		if(id!=l.id){
			return ResultMessage.Failure;
		}
		else if(id==l.id&&password==l.password){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Failure;
		}
	}
	
	public void register(String name,String password,UserJob role){
		if(name!=this.name){
			this.name=name;
			this.password=password;
			this.s=role;
		}
	}
	
	public String getPassword(long id,String name,UserJob role){
		if(id==l.id&&name==this.name&&role==s){
			return l.password;
		}
		else{
			return "–≈œ¢–ÈºŸ£¨’“ªÿ ß∞‹£°";
		}
	}
}

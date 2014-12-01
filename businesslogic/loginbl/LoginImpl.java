package loginbl;

import java.rmi.Naming;

import po.UserPO;
import dataservice.UserDataService;
import enumType.ResultMessage;
import enumType.UserJob;

public class LoginImpl {
	public ResultMessage verify(long id,String password){
		try{
			UserDataService service=(UserDataService) Naming.lookup("");
			if(!service.contain(id)){
				return ResultMessage.Failure;
			}
			else if(!service.find(id).getPassword().equals(password)){
				return ResultMessage.Failure;
			}
			else{
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage register(String name,String password,UserJob role){
		try{
			UserDataService service=(UserDataService) Naming.lookup("");
			RegisterInfo register=new RegisterInfo(name,password,role);
			service.insert(register);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public String getPassword(long id,String name,UserJob role){
		try{
			UserDataService service=(UserDataService) Naming.lookup("");
			if(service.contain(id)&&service.find(id).getName().equals(name)
					&&service.find(id).getRole().equals(role)){
				return service.find(id).getPassword();
			}
			return "信息虚假，返回失败";
		}catch(Exception ex){
			ex.printStackTrace();
			return "系统错误";
		}
	}
}

package blservice_stub;

import po.*;
import enumType.*;
import dataservice_stub.*;
import blservice.*;
public class LoginBLServiceStub implements LoginBLservice{
	private UserDataServiceStub service = new UserDataServiceStub();
	public LoginBLServiceStub(){
		
	}
	public ResultMessage verify(long id,String password){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(service.find(id)==null){
				return ResultMessage.Failure;
			}
			else{
				if(service.find(id).getPassword().equals(password)){
					return ResultMessage.Success;
				}
				else{
					return ResultMessage.Failure;
				}
			}
		}
	}
	
	public ResultMessage register(String name,String password,UserJob role){
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(new RegisterInfoPO(name,password,role));
			return ResultMessage.Success;
		}
	}
	
	public String getPassword(long id,String name,UserJob role){
		if(service==null){
			return "网络连接失败";
		}
		else{
			if(service.find(id)==null){
				return "不存在相关用户";
			}
			else{
				return service.find(id).getPassword();
			}
		}
	}
}

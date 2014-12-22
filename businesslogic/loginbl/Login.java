package loginbl;
import po.RegisterInfoPO;
import blservice.LoginBLservice;
import config.RMI;
import dataservice.UserDataService;
import enumType.*;
public class Login{
	public long id;
	public String password;
	public Login(){
	}
	public Login(long i,String p){
		this.id=i;
		this.password=p;
	}
	public ResultMessage verify(long id,String password){
		UserDataService service=RMI.getUserDataService();
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
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(new RegisterInfoPO(name,password,role));
			return ResultMessage.Success;
		}
	}
	
	public String getPassword(long id,String name,UserJob role){
		UserDataService service=RMI.getUserDataService();
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
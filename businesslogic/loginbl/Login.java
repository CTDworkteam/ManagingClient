package loginbl;
import config.RMI;
import dataservice.UserDataService;
import enumType.*;
public class Login {
	public long id;
	public String password;
	public Login(){
	}
	public Login(long i,String p){
		this.id=i;
		this.password=p;
	}
	public ResultMessage verify(long id,String password){
		try{
			UserDataService service=RMI.getUserDataService();
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
			UserDataService service=RMI.getUserDataService();
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
			UserDataService service=RMI.getUserDataService();
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

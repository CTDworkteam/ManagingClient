package loginbl;

import enumType.UserJob;

public class RegisterInfo {
	public String name;
	public String password;
	public UserJob role;
	public RegisterInfo(String name,String password,UserJob role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
}

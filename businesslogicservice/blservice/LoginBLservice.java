package blservice;

import enumType.ResultMessage;
import enumType.UserJob;

public interface LoginBLservice {
	public ResultMessage verify(long id,String password);
	public void register(String name,String password,UserJob role);
	public String getPassword(long id,String name,UserJob role);
}

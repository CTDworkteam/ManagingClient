package userbl;

import vo.RegisterInfoVO;
import vo.UserListVO;
import vo.UserVO;
import enumType.ResultMessage;
import enumType.UserJob;

public class UserController implements UserBLService{
	public User user;
	public UserController(){
		user=new User();
	}
	public ResultMessage addUser(UserVO vo) {
		return user.addUser(vo);
	}
	public ResultMessage deleteUser(long id) {
		return user.deleteUser(id);
	}
	public UserVO findUser(long id) {
		return user.findUser(id);
	}
	public ResultMessage updateUser(UserVO user) {
		return user.updateUser(user);
	}
	public UserListVO getAll() {
		return user.getAll();
	}
	public ResultMessage checkRegister(RegisterInfoVO info) {
		return UserJob.checkRegister(info);
	}
	
}
package userbl;

import vo.RegisterInfoVO;
import vo.UserListVO;
import vo.UserVO;
import enumType.ResultMessage;
import enumType.UserJob;

public class UserController implements blservice.UserBLService{
	public User user;
	public UserController(){
		user=new User();
	}
	@Override
	public ResultMessage addUser(UserVO vo) {
		return user.addUser(vo);
	}
	@Override
	public ResultMessage deleteUser(long id) {
		return user.deleteUser(id);
	}
	@Override
	public UserVO findUser(long id) {
		return user.findUser(id);
	}
	@Override
	public ResultMessage updateUser(UserVO user) {
		return this.user.updateUser(user);
	}
	@Override
	public UserListVO getAll() {
		return user.getAll();
	}
	@Override
	public long getNewUserID() {
		return user.getNewUserID();
	}
}
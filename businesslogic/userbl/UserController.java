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
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage deleteUser(long id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public UserVO findUser(long id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public ResultMessage updateUser(UserVO user) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public UserListVO getAll() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public long getNewUserID() {
		// TODO 自动生成的方法存根
		return 0;
	}
}
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
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ResultMessage deleteUser(long id) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public UserVO findUser(long id) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public ResultMessage updateUser(UserVO user) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public UserListVO getAll() {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public long getNewUserID() {
		// TODO �Զ����ɵķ������
		return 0;
	}
}
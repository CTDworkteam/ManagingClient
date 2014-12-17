package blservice;

import vo.UserListVO;
import vo.UserVO;
import enumType.ResultMessage;

public interface UserBLService {
	public ResultMessage addUser(UserVO vo);
	public ResultMessage deleteUser(long id);
	public UserVO findUser(long id);
	public ResultMessage updateUser(UserVO user);
	public UserListVO getAll();
<<<<<<< HEAD
=======
	
>>>>>>> refs/remotes/origin/master
}

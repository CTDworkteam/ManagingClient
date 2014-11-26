package userbl;
import vo.*;
import enumType.*;
public interface UserBLService {
	public ResultMessage addUser(UserVO vo);
	public ResultMessage deleteUser(long id);
	public UserVO findUser(long id);
	public ResultMessage updateUser(UserVO user);
	public UserListVO getAll();
	public ResultMessage checkRegister (RegisterInfoVO info);
}

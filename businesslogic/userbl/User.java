package userbl;

import java.rmi.Naming;
import java.util.*;

import config.RMI;
import convert.Convert;
import po.UserPO;
import vo.*;
import dataservice.UserDataService;
import enumType.ResultMessage;

public class User implements blservice.UserBLService{
	public User(){
	}
	public ResultMessage addUser(UserVO vo) {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			service.insert(Convert.convert(vo));
			if(service.find(vo.getId())==null){
				return ResultMessage.Failure;
			}
			else{
				return ResultMessage.Success;
			}
		}
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
}
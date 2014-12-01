package userbl;

import java.util.*;
import enumType.ResultMessage;
import vo.*;

public class MockUser extends User{
	private RegisterInfo r;
	private User u=new User(12345,r);
	
	public MockUser(){	
	}
	
	public MockUser(long i,RegisterInfo r){
		this.id=i;
		this.register=r;
	}
	public ResultMessage addUser(UserVO vo){
		if(vo.getId()==u.id){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage deleteUser(long id){
		if(u.id==id){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Failure;
		}
	}
	
	public UserVO findUser(long id){
		if(id==u.id){
			return new UserVO(u.id,"12345", null, null);
		}
		else{
			return null;
		}
	}
	
	public ResultMessage updateUser(UserVO vo){
		if(vo.getId()==u.id){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Failure;
		}
	}
	
	public UserListVO getAll(){
		UserListVO list=new UserListVO(null, null, null, null, null, null);
		ArrayList<UserVO> al=new ArrayList<UserVO>();
		al.add(new UserVO(u.id,"12345", null, null));
		list.setSalesmanager(al);
		return list;
	}
	
	public ResultMessage checkRegister (RegisterInfoVO info){
		if(info.equals(u.register)){
			return ResultMessage.Success;
		}
		else{
			return ResultMessage.Failure;
		}
	}
}

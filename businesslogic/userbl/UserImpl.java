package userbl;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import po.UserPO;
import dataservice.*;
import vo.*;
import enumType.ResultMessage;
import enumType.UserJob;

public class UserImpl extends UserController{
	public ResultMessage addUser(UserVO vo){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/addUser");
			boolean result=service.isMax(vo.getRole());
			if(!result){
				UserPO po=exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deleteUser(long id){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/delUser");
			boolean result=service.contain(id);
			if(result){
				UserPO po=service.find(id);
				service.delete(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public UserVO findUser(long id){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/findUser");
			boolean result=service.contain(id);
			if(result){
				UserPO po=service.find(id);
				UserVO vo=exchange(po);
				return vo;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return null;
		}
	}
	
	public ResultMessage updateUser(UserVO user){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/findUser");
			boolean result=service.contain(user.getId());
			if(result){
				UserPO po=exchange(user);
				service.update(po);
				return ResultMessage.Success;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return ResultMessage.Failure;
		}
	}
	
	public UserListVO getAll(){
		try{
			UserDataService service=(UserDataService) Naming.lookup("rmi://localhost:1099/getUserList");
			boolean result=service.isEmpty();
			if(!result){
				TreeSet<UserPO> list=service.getList();
				UserListVO vo=add(list.iterator());
				return vo;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return null;
		}
	}
	
/*	public ResultMessage checkRegister (RegisterInfoVO info){
		
	}*/
	
	private UserListVO add(Iterator<UserPO> i) {
		ArrayList<UserVO> purchasemanager=new ArrayList<UserVO>();
		ArrayList<UserVO> salesmanager=new ArrayList<UserVO>();
		ArrayList<UserVO> manager=new ArrayList<UserVO>();
		ArrayList<UserVO> stockmanager=new ArrayList<UserVO>();
		ArrayList<UserVO> financemanager=new ArrayList<UserVO>();
		ArrayList<UserVO> systemmanager=new ArrayList<UserVO>();
		while(i.hasNext()){
			UserVO vo=exchange(i.next());
			switch(vo.getRole()){
			case SystemManager:{
				systemmanager.add(vo);
				break;
			}
			case PurchaseManager:{
				purchasemanager.add(vo);
				break;
			}
			case SalesManager:{
				salesmanager.add(vo);
				break;
			}
			case StockManager:{
				stockmanager.add(vo);
				break;
			}
			case FinanceManager:{
				financemanager.add(vo);
			}
			case Manager:{
				manager.add(vo);
			}
			}
		}
		UserListVO list=new UserListVO(purchasemanager,salesmanager,
				manager,stockmanager,financemanager,systemmanager);
		return list;
	}

	private UserPO exchange(UserVO vo) {
		UserPO po=new UserPO(vo.getId(),vo.getName(),vo.getPassword(),
				vo.getRole());
		return po;
	}

	private UserVO exchange(UserPO po){
		UserVO vo=new UserVO(po.getId(),po.getName(),po.getPassword(),
				po.getRole());
		return vo;
	}
}

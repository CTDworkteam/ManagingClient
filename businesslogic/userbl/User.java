package userbl;

import java.rmi.Naming;
import java.util.*;

import config.RMI;
import convert.Convert;
import po.UserPO;
import vo.*;
import dataservice.UserDataService;
import enumType.ResultMessage;
import enumType.UserJob;

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
	public ResultMessage deleteUser(long id) {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(service.find(id)==null){
				return ResultMessage.No_Exist;
			}
			else{
				service.delete(service.find(id));
				if(service.find(id)!=null){
					return ResultMessage.Failure;
				}
				else{
					return ResultMessage.Success;
				}
			}
		}
	}
	public UserVO findUser(long id) {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return null;
		}
		else{
			if(service.find(id)==null){
				return null;
			}
			else{
				return Convert.convert(service.find(id));
			}
		}
	}
	public ResultMessage updateUser(UserVO user) {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(service.find(user.getId())==null){
				return ResultMessage.No_Exist;
			}
			else{
				service.update(Convert.convert(user));
				UserPO po=service.find(user.getId());
				if(po.getId()==user.getId()&&po.getName().equals(user.getName())
						&&po.getPassword().equals(user.getPassword())&&user.getRole()==user.getRole()){
					return ResultMessage.Success;
				}
				else{
					return ResultMessage.Failure;
				}
			}
		}
	}
	public UserListVO getAll() {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return null;
		}
		else{
			if(!service.getList().hasNext()){
				return null;
			}
			else{
				UserListVO vo=new UserListVO();
				Iterator<UserPO> iterator=service.getList();
				ArrayList<UserVO> listSystem=new ArrayList<UserVO>();
				ArrayList<UserVO> listStock=new ArrayList<UserVO>();
				ArrayList<UserVO> listSales=new ArrayList<UserVO>();
				ArrayList<UserVO> listPurchase=new ArrayList<UserVO>();
				ArrayList<UserVO> listManager=new ArrayList<UserVO>();
				ArrayList<UserVO> listFinance=new ArrayList<UserVO>();
				while(iterator.hasNext()){
					UserVO user=Convert.convert(iterator.next());
					if(user.getRole()==UserJob.FinanceManager){
						listFinance.add(user);
					}
					else if(user.getRole()==UserJob.SalesManager){
						listSales.add(user);
					}
					else if(user.getRole()==UserJob.Manager){
						listManager.add(user);
					}
					else if(user.getRole()==UserJob.PurchaseManager){
						listPurchase.add(user);
					}
					else if(user.getRole()==UserJob.StockManager){
						listStock.add(user);
					}
					else if(user.getRole()==UserJob.SystemManager){
						listSystem.add(user);
					}
				}
				return vo;
			}
		}
		
	}
	public long getNewUserID() {
		UserDataService service=RMI.getUserDataService();
		if(service==null){
			return -1;
		}
		else{
			return service.size()+1;
		}
	}
}
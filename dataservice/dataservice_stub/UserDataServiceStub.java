package dataservice_stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import po.RegisterInfoPO;
import po.UserPO;
import dataservice.*;
public class UserDataServiceStub implements UserDataService{
	private List<UserPO> userList;
	private List<RegisterInfoPO> registerInfo;
	public UserDataServiceStub(){
		//////
		userList=new ArrayList<UserPO>();
		registerInfo=new ArrayList<RegisterInfoPO>();
	}
	public void insert(UserPO po) {
		userList.add(po);
	}
	public void insert(RegisterInfoPO po) {
		registerInfo.add(po);
	}
	public UserPO find(long id) {
		for(UserPO po:userList){
			if(po.getId()==id){
				return po;
			}
		}
		return null;
	}
	public UserPO find(String name) {
		for(UserPO po:userList){
			if(po.getName().equals(name)){
				return po;
			}
		}
		return null;
	}
	public void delete(UserPO po) {
		Iterator<UserPO> iterator=userList.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId()==po.getId()){
				iterator.remove();
			}
		}
	}
	public void update(UserPO po) {
		delete(po);
		insert(po);
	}
	public Iterator<UserPO> getList() {
		return userList.iterator();
	}
	public Iterator<RegisterInfoPO> getRegisterInfo() {
		return registerInfo.iterator();
	}
	public int size() {
		return userList.size();
	}
}
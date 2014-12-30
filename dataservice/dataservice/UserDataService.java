package dataservice;
import po.*;
import java.util.*;
public interface UserDataService {
	public void insert(UserPO po);
	public void insert(RegisterInfoPO po);
	public UserPO find(long id);
	public UserPO find(String name);
	public void delete(UserPO po);
	public void update(UserPO po);
	public Iterator<UserPO> getList();
	public Iterator<RegisterInfoPO> getRegisterInfo();
	public int size();
}

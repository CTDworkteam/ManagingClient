package dataservice;
import po.AccountPO;
import java.util.*;
public interface AccountDataService {
	public void init();
	public void save();
	public void insert(AccountPO po);
	public void delete(AccountPO po);
	public boolean contain(String name);
	public AccountPO find(String name);
	public AccountPO find(long id);
	public void update(AccountPO po);
	public Iterator<AccountPO> list();
	public int number();
}

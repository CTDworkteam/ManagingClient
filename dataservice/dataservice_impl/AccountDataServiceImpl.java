package dataservice_impl;
import java.util.*;
import dataservice.AccountDataService;
import po.*;
public class AccountDataServiceImpl implements AccountDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -574940943136283635L;
	private List<AccountPO> list;
	public AccountDataServiceImpl(ArrayList<AccountPO> newList){
		this.list = newList;
	}
	public AccountDataServiceImpl() {
		list = new ArrayList<AccountPO>();
	}
	public void insert(AccountPO po) {
		list.add(po);
	}
	public void delete(AccountPO po) {
		list.remove((int)po.getId()-1);
		for(int i=(int)po.getId()-1;i<=list.size()-1;i++){
			list.get(i).setId(list.get(i).getId()-1);
		}
	}
	public boolean contain(String name) {
		for(AccountPO po:list){
			if(po.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	public AccountPO find(String name) {
		for(AccountPO po:list){
			if(po.getName().equals(name)){
				return po;
			}
		}
		return null;
	}
	public AccountPO find(long id) {
		int size = list.size();
		for(int i = 0;i<=size-1;i++){
			if(list.get(i).getId()==id){
				return list.get(i);
			}
		}
		return null;
	}
	public void update(AccountPO po) {
		for(AccountPO account:list){
			if(account.getName().equals(po.getName())){
				account.setName(po.getName());
				account.setMoney(po.getMoney());
			}
		}
	}
	public Iterator<AccountPO> list() {
		return list.iterator();
	}
	public int number() {
		return list.size();
	}
}
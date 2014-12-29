package dataservice_stub;
import dataservice.*;
import po.*;
import java.util.*;
public class AccountDataServiceStub implements AccountDataService{
	private ArrayList<AccountPO> list;
	public AccountDataServiceStub(){
		list = new ArrayList<AccountPO>();
		list.add(new AccountPO(1,"工行账户",200000));
		list.add(new AccountPO(2,"农行账户",200000));
		list.add(new AccountPO(3,"中行账户",200000));
	}
	public void init() {
		System.out.println("The data of accounts:Inited Success");
	}
	public void save() {
		System.out.println("The data of accounts:Saved Success");
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
		return list.get((int)id);
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
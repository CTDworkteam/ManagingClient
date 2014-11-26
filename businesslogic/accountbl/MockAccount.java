package accountbl;
import java.util.ArrayList;

import enumType.*;
import vo.*;
public class MockAccount extends Account{
	private static Account[] account={new Account(1,"A",1000),new Account(2,"B",0)};
	public MockAccount(long id,String name,double money){
		this.id=id;
		this.name=name;
		this.money=money;
	}
	public MockAccount() {
		// TODO 自动生成的构造函数存根
	}
	public ResultMessage add(AccountVO vo){
		if(vo.getName().equals(account[0].name)||vo.getName().equals(account[1].name)){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	public ResultMessage delete(AccountVO vo){
		int i=0;
		if(account[1].id==vo.getId())
			i++;
		if(account[i].money!=0){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	public ResultMessage update(AccountVO vo){
		int i=0;
		if(account[1].id==vo.getId())
			i++;
		if(vo.getName().equals(account[(i+1)%2])){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	public AccountVO find(String name){
		AccountVO vo=new AccountVO();
		int i=-1;
		if(account[0].name.equals(name)){
			i=0;
		}
		else if(account[1].name.equals(name)){
			i=1;
		}
		if(i!=-1){
			vo.setId(account[i].id);
			vo.setMoney(account[i].money);
			vo.setName(account[i].name);
		}
		return vo;
	}
	public ArrayList<AccountVO> getList(){
		ArrayList<AccountVO> list=new ArrayList<AccountVO>();
		list.add(new AccountVO(account[0].id,account[0].name,account[0].money));
		list.add(new AccountVO(account[1].id,account[1].name,account[1].money));
		return list;
	}
}

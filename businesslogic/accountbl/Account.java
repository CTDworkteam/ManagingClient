package accountbl;
import java.util.*;
import java.util.Map.Entry;

import config.RMI;
import dataservice.AccountDataService;
import enumType.ResultMessage;
import po.*;
import vo.AccountVO;
public class Account {  //?/////
	public long id;
	public String name;
	public double money;
	public AccountPO accountpo; 
	public Account(){
	}
	public Account(long id,String name,double money){
		this.id=id;
		this.name=name;
		this.money=money;
	}
	public Account(AccountPO po){
		this.id=po.getId();
		this.name=po.getName();
		this.money=po.getMoney();
		this.accountpo=po;
	}
	public ResultMessage add(AccountVO vo) {    //该方法用于添加账户
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(!service.contain(vo.getName())) {  //查看数据层是否已存在该名字，不存在则添加，存在则返回错误信息
				AccountPO po = exchange(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	public ResultMessage delete(AccountVO vo) {    //该方法用于删除账户
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(vo.getName())) {   //查看数据层是否已存在该名字，不存在则返回错误信息，存在则删除
				AccountPO po = exchange(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	public ResultMessage update(AccountVO vo) {   //该方法用于更新账户
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(vo.getName())) {   //查看数据层是否已存在该名字，不存在则返回错误信息，存在则更新
				AccountPO po = exchange(vo);
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	public AccountVO find(String name) {      //该方法用于查找账户
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(name)) {     //查看数据层是否已存在该名字，不存在则返回null，存在则返回VO对象
				AccountPO po = service.find(name);
				AccountVO vo = exchange(po);
				return vo;
			}
			return null;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<AccountVO> getList() {    //该方法用于获得账户列表
		AccountDataService service=RMI.getAccountDataService();
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		try {
			TreeMap<Long,AccountPO> temp = service.list();
			Set<Map.Entry<Long,AccountPO>> po = temp.entrySet();
			Iterator<Entry<Long, AccountPO>> i = po.iterator();    //迭代器遍历
			while(i.hasNext()){
				vo.add(exchange(i.next().getValue()));
			}
			return vo;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public AccountPO exchange(AccountVO vo) {   //该方法用于将VO对象转化为PO对象
		AccountPO po = new AccountPO(vo.getId(),vo.getName(),vo.getMoney());
		return po;
	}
	public AccountVO exchange(AccountPO po){   //该方法用于将PO对象转化为VO对象
		AccountVO vo = new AccountVO(po.getId(),po.getName(),po.getMoney());
		return vo;
	}
}

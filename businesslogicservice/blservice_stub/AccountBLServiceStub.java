package blservice_stub;
import java.util.ArrayList;
import java.util.Iterator;
import po.AccountPO;
import vo.AccountVO;
import convert.*;
import dataservice_stub.*;
import enumType.ResultMessage;
import blservice.*;
public class AccountBLServiceStub implements AccountBLService{
	private AccountDataServiceStub service = new AccountDataServiceStub();
	public AccountBLServiceStub(){
	}
	public ResultMessage add(AccountVO vo) {    //该方法用于添加账户	
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(!service.contain(vo.getName())) {  //查看数据层是否已存在该名字，不存在则添加，存在则返回错误信息
				AccountPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public ResultMessage delete(AccountVO vo) {    //该方法用于删除账户
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getName()) && 
			service.find(vo.getName()).getMoney() != 0) {   //查看数据层是否已存在该名字，不存在则返回错误信息，存在则删除
				AccountPO po = Convert.convert(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public ResultMessage update(AccountVO vo) {   //该方法用于更新账户
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getName())) {   //查看数据层是否已存在该名字，不存在则返回错误信息，存在则更新
				AccountPO po = Convert.convert(vo);
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public AccountVO find(String name) {      //该方法用于查找账户
		if(service == null){
			return null;
		}
		
		else{
			if(service.contain(name)) {     //查看数据层是否已存在该名字，不存在则返回null，存在则返回VO对象
				AccountPO po = service.find(name);
				AccountVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<AccountVO> getList() {    //该方法用于获得账户列表
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<AccountPO> i = service.list();   //迭代器遍历
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}
	
	public long getNewAccountID() {
		if(service == null){
			return -1;
		}
		
		else{
			return service.number()+1;
		}
	}
}

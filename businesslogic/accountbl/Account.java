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
	public ResultMessage add(AccountVO vo) {    //�÷�����������˻�
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(!service.contain(vo.getName())) {  //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣�����������ӣ������򷵻ش�����Ϣ
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
	public ResultMessage delete(AccountVO vo) {    //�÷�������ɾ���˻�
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(vo.getName())) {   //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻ش�����Ϣ��������ɾ��
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
	public ResultMessage update(AccountVO vo) {   //�÷������ڸ����˻�
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(vo.getName())) {   //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻ش�����Ϣ�����������
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
	public AccountVO find(String name) {      //�÷������ڲ����˻�
		AccountDataService service=RMI.getAccountDataService();
		try {
			if(service.contain(name)) {     //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻�null�������򷵻�VO����
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
	public ArrayList<AccountVO> getList() {    //�÷������ڻ���˻��б�
		AccountDataService service=RMI.getAccountDataService();
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		try {
			TreeMap<Long,AccountPO> temp = service.list();
			Set<Map.Entry<Long,AccountPO>> po = temp.entrySet();
			Iterator<Entry<Long, AccountPO>> i = po.iterator();    //����������
			while(i.hasNext()){
				vo.add(exchange(i.next().getValue()));
			}
			return vo;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	public AccountPO exchange(AccountVO vo) {   //�÷������ڽ�VO����ת��ΪPO����
		AccountPO po = new AccountPO(vo.getId(),vo.getName(),vo.getMoney());
		return po;
	}
	public AccountVO exchange(AccountPO po){   //�÷������ڽ�PO����ת��ΪVO����
		AccountVO vo = new AccountVO(po.getId(),po.getName(),po.getMoney());
		return vo;
	}
}

package accountbl;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import po.*;
import dataservice.AccountDataService;
import vo.*;
import enumType.ResultMessage;

public class AccountImpl extends AccountController {
	public ResultMessage add(AccountVO vo) {    //�÷�����������˻�
		try {
			AccountDataService service = (AccountDataService) Naming.lookup("rmi://localhost:1099/addAccount");
		
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
		try {
			AccountDataService service = (AccountDataService) Naming.lookup("rmi://localhost:1099/delAccount");
			
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
		try {
			AccountDataService service = (AccountDataService) Naming.lookup("rmi://localhost:1099/updateAccount");
			
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
		try {
			AccountDataService service = (AccountDataService) Naming.lookup("rmi://localhost:1099/findAccount");
			
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
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		
		try {
			AccountDataService service = (AccountDataService) Naming.lookup("rmi://localhost:1099/getAccountList");
			
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

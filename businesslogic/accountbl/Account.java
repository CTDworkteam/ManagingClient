package accountbl;
import java.util.*;
import java.util.Map.Entry;

import blservice.AccountBLService;
import config.RMI;
import convert.Convert;
import dataservice.AccountDataService;
import enumType.ResultMessage;
import po.*;
import vo.AccountVO;
public class Account implements AccountBLService{
	public Account(){
	}
	
	public ResultMessage add(AccountVO vo) {    //�÷�����������˻�
		AccountDataService service=RMI.getAccountDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(!service.contain(vo.getName())) {  //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣�����������ӣ������򷵻ش�����Ϣ
				AccountPO po = Convert.convert(vo);
				service.insert(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public ResultMessage delete(AccountVO vo) {    //�÷�������ɾ���˻�
		AccountDataService service=RMI.getAccountDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getName()) && 
			service.find(vo.getName()).getMoney() != 0) {   //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻ش�����Ϣ��������ɾ��
				AccountPO po = Convert.convert(vo);
				service.delete(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public ResultMessage update(AccountVO vo) {   //�÷������ڸ����˻�
		AccountDataService service=RMI.getAccountDataService();
		
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			if(service.contain(vo.getName())) {   //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻ش�����Ϣ�����������
				AccountPO po = Convert.convert(vo);
				service.update(po);
				return ResultMessage.Success;
			}
			return ResultMessage.No_Exist;
		}
	}
	
	public AccountVO find(String name) {      //�÷������ڲ����˻�
		AccountDataService service=RMI.getAccountDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.contain(name)) {     //�鿴���ݲ��Ƿ��Ѵ��ڸ����֣��������򷵻�null�������򷵻�VO����
				AccountPO po = service.find(name);
				AccountVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<AccountVO> getList() {    //�÷������ڻ���˻��б�
		AccountDataService service=RMI.getAccountDataService();
		ArrayList<AccountVO> vo = new ArrayList<AccountVO>();
		
		if(service == null){
			return null;
		}
		
		else{
			Iterator<AccountPO> i = service.list();   //����������
			while(i.hasNext()){
				vo.add(Convert.convert(i.next()));
			}
			return vo;
		}
	}
	
	public long getNewAccountID() {
		AccountDataService service=RMI.getAccountDataService();
		
		if(service == null){
			return -1;
		}
		
		else{
			return service.number();
		}
	}
}

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
	public ResultMessage add(AccountVO vo) {    //�÷�����������˻�	
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
		if(service == null){
			return -1;
		}
		
		else{
			return service.number()+1;
		}
	}
}

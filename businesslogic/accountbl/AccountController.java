package accountbl;
import java.util.ArrayList;

import vo.AccountVO;
import enumType.ResultMessage;
import blservice.*;
public class AccountController implements AccountBLService{
	private Account account;
	public AccountController(){
		account=new Account();
	}
	public ResultMessage add(AccountVO vo) {
		return account.add(vo);
	}
	public ResultMessage delete(AccountVO vo) {
		return account.delete(vo);
	}
	public ResultMessage update(AccountVO vo) {
		return account.update(vo);
	}
	public AccountVO find(String name) {
		return account.find(name);
	}
	public ArrayList<AccountVO> getList() {
		return account.getList();
	}
}

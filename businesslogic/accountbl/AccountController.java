package accountbl;
import java.util.ArrayList;
import vo.AccountVO;
import enumType.ResultMessage;
import blservice.*;

public class AccountController implements AccountBLService{
	
	private Account account;
	public static final int ZERO=48;
	public static final int NINE=57;
	public static final int POINT=250;
	
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
	public ResultMessage JudgeMoney(String money){
		ResultMessage result=ResultMessage.Success;
		int length=money.length();
		char a=money.charAt(0);
		if(a<ZERO||a>NINE){
			result=ResultMessage.Failure;
		}
		for(int i=1;i<length;i++){
			a=money.charAt(i);
			if(a<ZERO||(a>NINE&&a!=POINT)){
				result=ResultMessage.Failure;
			}
		}
		return result;
	}
}

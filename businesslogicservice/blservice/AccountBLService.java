package blservice;
import enumType.*;
import vo.*;
import java.util.*;
public interface AccountBLService {
	public ResultMessage add(AccountVO vo);
	public ResultMessage delete(AccountVO vo);
	public ResultMessage update(AccountVO vo);
	public AccountVO find(String name);
	public ArrayList<AccountVO> getList();
}

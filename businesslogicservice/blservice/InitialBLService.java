package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface InitialBLService {
	public ResultMessage addCommodityType(ArrayList<CommodityTypeVO> tree);
	public ResultMessage addCommodity(ArrayList<CommodityVO> list);
	public ResultMessage addClient(ArrayList<ClientVO> client);
	public ResultMessage addAccount(ArrayList<AccountVO> account);
	public InitialVO getInitialInfo(String id);
	public ArrayList<InitialVO> getList();
	public String getNewID(GregorianCalendar date);
}

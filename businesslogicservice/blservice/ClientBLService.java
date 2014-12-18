package blservice;
import java.util.*;
import vo.*;
import enumType.*;
public interface ClientBLService {
	public ResultMessage add(ClientVO vo);
    public ResultMessage delete(ClientVO vo);
    public ResultMessage update(ClientVO vo);
    public ClientVO find(String id);
    public ArrayList<ClientVO> finds(String key);
    public ArrayList<ClientVO> getList();
    public long getNewClientID();
}

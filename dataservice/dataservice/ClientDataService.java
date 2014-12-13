package dataservice;
import po.*;
import java.util.*;
public interface ClientDataService {
	public void insert(ClientPO po);
    public void delete(ClientPO po);
    public boolean contain(String name);
    public boolean contain(long id);
    public ClientPO find(String name);
    public ClientPO find(long id);
    public void update(ClientPO po);
    public Iterator<ClientPO> list();
    public int number();
    public void init();
    public void save();
}

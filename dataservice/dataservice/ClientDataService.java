package dataservice;
import po.*;

import java.util.*;
public interface ClientDataService {
	/**
	 * @author 殷迪
	 * @param po 需要添加的新的客户信息的数据对象
	 * 在系统数据中没有重名或者重ID的客户ClientPO数据对象的前置条件下，向系统数据中加入一个新的ClientPO数据对象
	 */
	public void insert(ClientPO po);
	/**
	 * @author 殷迪
	 * @param po 需要删除的旧的客户信息的数据对象
	 * 在系统数据中存在相应的ClientPO数据对象的前置条件下，删除系统数据中
	 */
    public void delete(ClientPO po);
    /**
     * @author 殷迪
     * @param name
     * @return 当存在相关的
     */
    public boolean contain(String name);
    public boolean contain(long id);
    public ClientPO find(String name);
    public ClientPO find(long id);
    public void update(ClientPO po);
    public Iterator<ClientPO> list();
    public int number();
    public void init();
    public void save();
	public ArrayList<ClientPO> findInKeyword(String key);
	public ArrayList<ClientPO> findInRank(int rank);
}

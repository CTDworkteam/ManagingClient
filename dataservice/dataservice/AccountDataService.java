package dataservice;
import po.AccountPO;
import java.util.*;
public interface AccountDataService {
	/**
	 * @author 殷迪
	 * 用于初始化数据
	 */
	public void init();
	/**
	 * @author 殷迪
	 * 用于使用完成后保存数据
	 */
	public void save();
	/**
	 * @author 殷迪
	 * @param po 需要添加的新的银行账户AccountPO对象
	 * 在不存在同名银行账户的前置条件下，添加一个新的AccountPO对象到系统数据中
	 */
	public void insert(AccountPO po);
	/**
	 * @author 殷迪
	 * @param po 需要从系统数据中删除的银行账户AccountPO数据对象
	 * 在系统存在该银行账户的AccountPO数据对象的前置条件下，删除系统数据中对应的AccountPO对象
	 */
	public void delete(AccountPO po);
	/**
	 * @author 殷迪
	 * @param name 需要检测是否存在相关数据对象的账户名
	 * @return 存在则true，不存在则false
	 * 用于在删除或者添加银行账户信息时检测是否存在或者是否已经存在同名账户
	 */
	public boolean contain(String name);
	/**
	 * @author 殷迪
	 * @param name 需要获得的AccountPO银行账户数据对象的账户名
	 * @return 对应账户名的账户AccountPO数据对象
	 * 在存在对应账户名的账户数据对象的前置条件下，获取账户名对应的AccountPO数据对象
	 */
	public AccountPO find(String name);
	/**
	 * @author 殷迪
	 * @param id 需要获得的AccountPO银行账户数据对象的账户编号
	 * @return 对应账户ID的账户AccountPO数据对象
	 * 在存在对应账户ID的账户数据对象的前置条件下，获取账户ID对应的AccountPO数据对象
	 */
	public AccountPO find(long id);
	/**
	 * @author 殷迪
	 * @param po 需要进行系统数据更新的AccountPO对象
	 * 在存在相同账户ID的原有系统AccountPO数据对象的前置条件下，更新系统数据中的AccountPO数据对象
	 */
	public void update(AccountPO po);
	/**
	 * @author 殷迪
	 * @return 可以遍历系统数据中所有银行账户AccountPO对象的迭代器
	 * 在系统数据中存在银行账户数据的前置条件下，获取全部的银行账户信息的系统数据的迭代器
	 */
	public Iterator<AccountPO> list();
	/**
	 * @author 殷迪
	 * @return 系统中存在的银行账户数据对象的数量
	 * 用于返回系统数据中存在的银行账户数据对象的数量
	 */
	public int number();
}

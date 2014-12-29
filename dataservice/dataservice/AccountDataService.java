package dataservice;
import po.AccountPO;
import java.util.*;
public interface AccountDataService {
	/**
	 * @author ���
	 * ���ڳ�ʼ������
	 */
	public void init();
	/**
	 * @author ���
	 * ����ʹ����ɺ󱣴�����
	 */
	public void save();
	/**
	 * @author ���
	 * @param po ��Ҫ��ӵ��µ������˻�AccountPO����
	 * �ڲ�����ͬ�������˻���ǰ�������£����һ���µ�AccountPO����ϵͳ������
	 */
	public void insert(AccountPO po);
	/**
	 * @author ���
	 * @param po ��Ҫ��ϵͳ������ɾ���������˻�AccountPO���ݶ���
	 * ��ϵͳ���ڸ������˻���AccountPO���ݶ����ǰ�������£�ɾ��ϵͳ�����ж�Ӧ��AccountPO����
	 */
	public void delete(AccountPO po);
	/**
	 * @author ���
	 * @param name ��Ҫ����Ƿ����������ݶ�����˻���
	 * @return ������true����������false
	 * ������ɾ��������������˻���Ϣʱ����Ƿ���ڻ����Ƿ��Ѿ�����ͬ���˻�
	 */
	public boolean contain(String name);
	/**
	 * @author ���
	 * @param name ��Ҫ��õ�AccountPO�����˻����ݶ�����˻���
	 * @return ��Ӧ�˻������˻�AccountPO���ݶ���
	 * �ڴ��ڶ�Ӧ�˻������˻����ݶ����ǰ�������£���ȡ�˻�����Ӧ��AccountPO���ݶ���
	 */
	public AccountPO find(String name);
	/**
	 * @author ���
	 * @param id ��Ҫ��õ�AccountPO�����˻����ݶ�����˻����
	 * @return ��Ӧ�˻�ID���˻�AccountPO���ݶ���
	 * �ڴ��ڶ�Ӧ�˻�ID���˻����ݶ����ǰ�������£���ȡ�˻�ID��Ӧ��AccountPO���ݶ���
	 */
	public AccountPO find(long id);
	/**
	 * @author ���
	 * @param po ��Ҫ����ϵͳ���ݸ��µ�AccountPO����
	 * �ڴ�����ͬ�˻�ID��ԭ��ϵͳAccountPO���ݶ����ǰ�������£�����ϵͳ�����е�AccountPO���ݶ���
	 */
	public void update(AccountPO po);
	/**
	 * @author ���
	 * @return ���Ա���ϵͳ���������������˻�AccountPO����ĵ�����
	 * ��ϵͳ�����д��������˻����ݵ�ǰ�������£���ȡȫ���������˻���Ϣ��ϵͳ���ݵĵ�����
	 */
	public Iterator<AccountPO> list();
	/**
	 * @author ���
	 * @return ϵͳ�д��ڵ������˻����ݶ��������
	 * ���ڷ���ϵͳ�����д��ڵ������˻����ݶ��������
	 */
	public int number();
}

package dataservice;

import java.util.*;

import po.ClientPO;
public interface ClientDataService {
	/**
	 * @author ���
	 * @param po ��Ҫ��ӵ��µĿͻ���Ϣ�����ݶ���
	 * ��ϵͳ������û������������ID�Ŀͻ�ClientPO���ݶ����ǰ�������£���ϵͳ�����м���һ���µ�ClientPO���ݶ���
	 */
	public void insert(ClientPO po);
	/**
	 * @author ���
	 * @param po ��Ҫɾ���ľɵĿͻ���Ϣ�����ݶ���
	 * ��ϵͳ�����д�����Ӧ��ClientPO���ݶ����ǰ�������£�ɾ��ϵͳ������
	 */
    public void delete(ClientPO po);
    /**
     * @author ���
     * @param name
     * @return ��������ص�
     */
    public boolean contain(String name);
    public boolean contain(long id);
    public ClientPO find(String name);
    public ClientPO find(long id);
    public void update(ClientPO po);
    public Iterator<ClientPO> list();
    public int number();
	public ArrayList<ClientPO> findInKeyword(String key);
	public ArrayList<ClientPO> findInRank(int rank);
}

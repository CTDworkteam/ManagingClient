package dataservice_stub;
import po.*;
import dataservice.*;
import java.util.*;
import enumType.*;
public class ClientDataServiceStub implements ClientDataService{
	private ArrayList<ClientPO> list;
	public ClientDataServiceStub(){
		list = new ArrayList<ClientPO>();
		list.add(new ClientPO(1,"张三",ClientType.Supplier,5,"025-123456789","南京大学仙林校区",
				"210046","zhang3@163.com",10000,0,0,"王一琦",1,0));
		list.add(new ClientPO(2,"李四",ClientType.Seller,5,"025-123456780","东南大学九龙湖校区",
				"222222","li4@163.com",10000,0,0,"冯鑫",1,0));
		list.add(new ClientPO(3,"王麻子",ClientType.Seller,5,"025-12456787","南京航空航天大学将军路校区",
				"222222","wangmz@163.com",10000,0,0,"王一琦",1,0));
	}
	public void insert(ClientPO po) {
		list.add(po);
	}
	public void delete(ClientPO po) {
		Iterator<ClientPO> iterator=list();
		while(iterator.hasNext()){
			if(iterator.next().getId()==po.getId()){
				iterator.remove();break;
			}
		}
	}
	public boolean contain(String name) {
		Iterator<ClientPO> iterator=list();
		while(iterator.hasNext()){
			if(iterator.next().getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	public boolean contain(long id){
		Iterator<ClientPO> iterator=list();
		while(iterator.hasNext()){
			if(iterator.next().getId()==id){
				return true;
			}
		}
		return false;
	}
	public ClientPO find(String name) {
		Iterator<ClientPO> iterator=list();
		ClientPO output=null;
		while(iterator.hasNext()){
			output=iterator.next();
			if(output.getName().equals(name)){
				return output;
			}
		}
		return null;
	}
	public ClientPO find(long id) {
		Iterator<ClientPO> iterator=list();
		ClientPO output=null;
		while(iterator.hasNext()){
			output=iterator.next();
			if(output.getId()==id){
				return output;
			}
		}
		return null;
	}
	public void update(ClientPO po) {
		delete(po);
		insert(po);
	}
	public Iterator<ClientPO> list() {
		return list.iterator();
	}
	public int number() {
		return list.size();
	}
	public void init() {
		System.out.println("Inited Success");
	}
	public void save() {
		System.out.println("Saved Success");
	}
	public ArrayList<ClientPO> findInKeyword(String key) {
		ArrayList<ClientPO> output = new ArrayList<ClientPO>();
		Iterator<ClientPO> iterator = list.iterator();
		while(iterator.hasNext()){
			ClientPO client = iterator.next();
			if(client.getName().contains(key) || new Long(client.getId()).toString().contains(key)){
				output.add(client);
			}
		}
		return output;
	}
	public ArrayList<ClientPO> findInRank(int rank) {
		ArrayList<ClientPO> output = new ArrayList<ClientPO>();
		Iterator<ClientPO> iterator = list.iterator();
		while(iterator.hasNext()){
			ClientPO client = iterator.next();
			if(client.getRank() ==  rank){
				output.add(client);
			}
		}
		return output;
	}
}

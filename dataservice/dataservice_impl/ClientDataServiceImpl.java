package dataservice_impl;
import java.util.*;
import po.*;
import comparator.*;
import dataservice.ClientDataService;
public class ClientDataServiceImpl implements ClientDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6158431791951315198L;
	private Set<ClientPO> list;
	public ClientDataServiceImpl(){
		list=new TreeSet<ClientPO>(new ClientComparator());
	}
	public ClientDataServiceImpl(TreeSet<ClientPO> newSet){
		list = newSet;
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
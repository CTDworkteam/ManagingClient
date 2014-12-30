package dataservice_impl;
import java.util.*;
import po.InitialPO;
import dataservice.InitialDataService;
public class InitialDataServiceImpl implements InitialDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5915825502841631026L;
	private List<InitialPO> list;
	public InitialDataServiceImpl(){
		list=new ArrayList<InitialPO>();
	}
	public InitialDataServiceImpl(ArrayList<InitialPO> newList){
		list = newList;
	}
	public void insert(InitialPO po) {
		list.add(po);
	}
	public boolean contain(String id) {
		Iterator<InitialPO> iterator=list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public InitialPO find(String id) {
		int index=0;
		while(!list.get(index).getId().equals(id)){
			index++;
		}
		return list.get(index);
	}
	public boolean isEmpty() {
		return list.size()==0?true:false;
	}
	public Iterator<InitialPO> getAllInitials() {
		return list.iterator();
	}
}
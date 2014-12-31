package dataservice_stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.InitialPO;
import dataservice.*;
public class InitialDataServiceStub implements InitialDataService{
	private List<InitialPO> list;
	public InitialDataServiceStub(){
		list=new ArrayList<InitialPO>();
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
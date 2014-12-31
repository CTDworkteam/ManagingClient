package dataservice_stub;
import java.util.*;

import dataservice.*;
import po.*;
public class CommodityTypeDataServiceStub implements CommodityTypeDataService{
	public ArrayList<CommodityTypePO> list;
	public CommodityTypeDataServiceStub(){
		list = new ArrayList<CommodityTypePO>();
		ArrayList<String> commoditys1 = new ArrayList<String>();
		ArrayList<String> commoditys2 = new ArrayList<String>();
		ArrayList<String> commoditys3 = new ArrayList<String>();
		ArrayList<String> childs = new ArrayList<String>();
		
		commoditys1.add("20101000000001");
		commoditys1.add("20101000000002");
		commoditys2.add("20102000000001");
		commoditys2.add("20102000000002");
		commoditys3.add("20103000000001");
		commoditys3.add("20103000000002");
		
		childs.add("20101000000");
		childs.add("20102000000");
		childs.add("20103000000");
		
		list.add(new CommodityTypePO("10100000000","灯具总类",true,false,null,null,childs));
		list.add(new CommodityTypePO("20101000000","灯具种类1",false,true,commoditys1,"10100000000",new ArrayList<String>()));
		list.add(new CommodityTypePO("20102000000","灯具种类2",false,true,commoditys2,"10100000000",new ArrayList<String>()));
		list.add(new CommodityTypePO("20103000000","灯具种类3",false,true,commoditys3,"10100000000",new ArrayList<String>()));
	}
	public void insert(CommodityTypePO po) {
		list.add(po);
	}
	public void delete(CommodityTypePO po) {
		Iterator<CommodityTypePO> iterator=list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public boolean containInID(String id){
		Iterator<CommodityTypePO> iterator=list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public boolean containInKey(String key){
		Iterator<CommodityTypePO> iterator=list.iterator();
		while(iterator.hasNext()){
			CommodityTypePO po=iterator.next();
			if(po.getId().contains(key)||po.getName().contains(key)){
				return true;
			}
		}
		return false;
	}
	public void update(CommodityTypePO po) {
		delete(po);
		insert(po);
	}
	public CommodityTypePO findByName(String name) {
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getName().equals(name)){
				return list.get(i);
			}
		}
		return null;
	}
	public CommodityTypePO findByID(String ID) {
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getId().equals(ID)){
				return list.get(i);
			}
		}
		return null;
	}
	public Iterator<CommodityTypePO> findByKeyword(String key) {
		ArrayList<CommodityTypePO> output=new ArrayList<CommodityTypePO>();
		for(int i=0;i<=list.size()-1;i++){
			if(list.get(i).getId().contains(key)||list.get(i).getName().contains(key)){
				output.add(list.get(i));
			}
		}
		return output.iterator();
	}
	public Iterator<CommodityTypePO> getAllCommodityTypes() {
		return list.iterator();
	}
	public boolean hasCommodityType() {
		return list.size()==0?false:true;
	}
}
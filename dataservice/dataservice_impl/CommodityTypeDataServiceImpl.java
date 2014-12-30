package dataservice_impl;
import java.util.*;
import po.CommodityTypePO;
import dataservice.CommodityTypeDataService;
public class CommodityTypeDataServiceImpl implements CommodityTypeDataService{
	private List<CommodityTypePO> list;
	public CommodityTypeDataServiceImpl(){
		list=new ArrayList<CommodityTypePO>();
	}
	public CommodityTypeDataServiceImpl(ArrayList<CommodityTypePO> newList){
		this.list = newList;
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
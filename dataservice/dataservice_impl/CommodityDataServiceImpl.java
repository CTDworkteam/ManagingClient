package dataservice_impl;
import java.util.*;
import dataservice.CommodityDataService;
import po.CommodityPO;
import comparator.*;
public class CommodityDataServiceImpl implements java.io.Serializable,  CommodityDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7342945069927030752L;
	private Set<CommodityPO> set;
	public CommodityDataServiceImpl(){
		set=new TreeSet<CommodityPO>(new CommodityComparator());
	}
	public CommodityDataServiceImpl(TreeSet<CommodityPO> newSet){
		set = newSet;
	}
	public void insert(CommodityPO po) {
		set.add(po);
	}
	public void delete(CommodityPO po) {
		Iterator<CommodityPO> iterator=set.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(po.getId())){
				iterator.remove();
				break;
			}
		}
	}
	public void update(CommodityPO po) {
		delete(po);
		insert(po);
	}
	public CommodityPO findCommodityInID(String id) {
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getId().equals(id)){
				return po;
			}
		}
		return null;
	}
	public CommodityPO findCommodityInName(String name) {
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getName().equals(name)){
				return po;
			}
		}
		return null;
	}
	public Iterator<CommodityPO> findCommoditiesInKeyword(String key) {
		ArrayList<CommodityPO> output=new ArrayList<CommodityPO>();
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getId().contains(key)||po.getName().contains(key)){
				output.add(po);
			}
			else{
				Iterator<CommodityPO.CommodityModelPO> it=po.getList().iterator();
				while(it.hasNext()){
					if(it.next().getName().contains(key)
							||it.next().getStorehouse().contains(key)){
						output.add(po);
					}
				}
			}
		}
		return output.iterator();
	}
	public Iterator<CommodityPO> findCommoditiesInType(String id) {
		ArrayList<CommodityPO> list=new ArrayList<CommodityPO>();
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getId().substring(0,11).equals(id)){
				list.add(po);
			}
		}
		return list.iterator();
	}
	public Iterator<CommodityPO> getAllCommodities() {
		return set.iterator();
	}
	public boolean hasCommodity() {
		return set.size()==0?false:true;
	}
	
	public boolean containInId(String id) {
		Iterator<CommodityPO> iterator=set.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public boolean containInName(String name) {
		Iterator<CommodityPO> iterator=set.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	public boolean containInKeyword(String key) {
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getId().contains(key)||po.getName().contains(key)){
				return true;
			}
			else{
				Iterator<CommodityPO.CommodityModelPO> it=po.getList().iterator();
				while(it.hasNext()){
					if(it.next().getName().contains(key)
							||it.next().getStorehouse().contains(key)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean containInType(String id) {
		Iterator<CommodityPO> iterator=set.iterator();
		CommodityPO po=null;
		while(iterator.hasNext()){
			po=iterator.next();
			if(po.getId().substring(0,11).equals(id)){
				return true;
			}
		}
		return false;
	}
}
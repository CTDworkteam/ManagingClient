package dataservice_stub;
import dataservice.*;
import po.*;

import java.util.*;
public class CommodityDataServiceStub implements CommodityDataService{
	private ArrayList<CommodityPO> list;
	public CommodityDataServiceStub(){
		list = new ArrayList<CommodityPO>();
		ArrayList<CommodityPO.CommodityModelPO> models = 
				new ArrayList<CommodityPO.CommodityModelPO>();
		models.add(new CommodityPO().new CommodityModelPO("SR101",20,"南京仓库",10,100,120,105,200));
		models.add(new CommodityPO().new CommodityModelPO("SR102",30,"上海仓库",10,120,230,110,123));
		CommodityPO commodity = new CommodityPO();
		commodity.setName("灯具1");
		commodity.setId("20101000000001");
		commodity.setTotal(50);
		commodity.setType("20101000000");
	}
	public void insert(CommodityPO po) {
		list.add(po);
		System.out.println("The new commodity has been added into the list.");
	}
	public void delete(CommodityPO po) {
		Iterator<CommodityPO> iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getId().equals(po.getId())){
				iter.remove();
				break;
			}
		}
		System.out.println("The commodity has been removed.");
	}
	public void update(CommodityPO po) {
		delete(po);
		insert(po);
		System.out.println("The commodity has been updated.");
	}
	public boolean containInId(String id) {
		Iterator<CommodityPO> iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public CommodityPO findCommodityInID(String id) {
		int size = list.size();
		int index = 0;
		for(index = 0;index <= size-1;index ++){
			if(list.get(index).getId().equals(id)){
				return list.get(index);
			}
		}
		return null;
	}
	public boolean containInName(String name) {
		Iterator<CommodityPO> iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	public CommodityPO findCommodityInName(String name) {
		int size = list.size();
		int index = 0;
		for(index = 0;index <= size-1;index ++){
			if(list.get(index).getName().equals(name)){
				return list.get(index);
			}
		}
		return null;
	}
	public boolean containInKeyword(String key) {
		int size = list.size();
		for(int index = 0;index <= size-1;index ++){
			if(list.get(index).getId().contains(key)||list.get(index).getName().contains(key)){
				return true;
			}
		}
		return false;
	}
	public Iterator<CommodityPO> findCommoditiesInKeyword(String key) {
		ArrayList<CommodityPO> output = new ArrayList<CommodityPO>();
		for(int index = 0;index<=list.size()-1;index++){
			if(list.get(index).getId().contains(key)||list.get(index).getName().contains(key)){
				output.add(list.get(index));
			}
		}
		return output.iterator();
	}
	public boolean containInType(String id) {
		Iterator<CommodityPO> iter = list.iterator();
		while(iter.hasNext()){
			if(iter.next().getType().equals(id)){
				return true;
			}
		}
		return false;
	}
	public Iterator<CommodityPO> findCommoditiesInType(String id) {
		ArrayList<CommodityPO> output = new ArrayList<CommodityPO>();
		for(int index = 0;index <= list.size()-1;index ++){
			if(list.get(index).getType().equals(id)){
				output.add(list.get(index));
			}
		}
		return output.iterator();
	}
	public Iterator<CommodityPO> getAllCommodities() {
		return list.iterator();
	}
	public boolean hasCommodity() {
		return list.size()==0?false:true;
	}
	public void init() {
		System.out.println("Inited Success");
	}
	public void save() {
		System.out.println("Saved Success");
	}

}

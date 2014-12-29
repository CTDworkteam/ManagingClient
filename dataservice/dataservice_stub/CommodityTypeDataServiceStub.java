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
		System.out.println();
		
	}

	@Override
	public void delete(CommodityTypePO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(CommodityTypePO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean containInID(String id) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean containInKey(String key) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public CommodityTypePO findByName(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CommodityTypePO findByID(String ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<CommodityTypePO> findByKeyword(String key) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Iterator<CommodityTypePO> getAllCommodityTypes() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean hasCommodityType() {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void init() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void save() {
		// TODO 自动生成的方法存根
		
	}

}

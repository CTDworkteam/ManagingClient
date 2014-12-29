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
		
		list.add(new CommodityTypePO("10100000000","�ƾ�����",true,false,null,null,childs));
		list.add(new CommodityTypePO("20101000000","�ƾ�����1",false,true,commoditys1,"10100000000",new ArrayList<String>()));
		list.add(new CommodityTypePO("20102000000","�ƾ�����2",false,true,commoditys2,"10100000000",new ArrayList<String>()));
		list.add(new CommodityTypePO("20103000000","�ƾ�����3",false,true,commoditys3,"10100000000",new ArrayList<String>()));
	}
	public void insert(CommodityTypePO po) {
		list.add(po);
		System.out.println();
		
	}

	@Override
	public void delete(CommodityTypePO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void update(CommodityTypePO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public boolean containInID(String id) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public boolean containInKey(String key) {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public CommodityTypePO findByName(String name) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public CommodityTypePO findByID(String ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Iterator<CommodityTypePO> findByKeyword(String key) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public Iterator<CommodityTypePO> getAllCommodityTypes() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean hasCommodityType() {
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public void init() {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void save() {
		// TODO �Զ����ɵķ������
		
	}

}

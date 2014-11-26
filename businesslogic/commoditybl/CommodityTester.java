package commoditybl;

import enumType.ResultMessage;
import vo.CommodityModelVO;
import vo.CommodityVO;

public class CommodityTester {
	public void testAddC(CommodityVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.addCommodity(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to add the new commodity");
		}
		else{
			System.out.println("We have failed to add the new commodity");
		}
	}
	
	public void testDelC(CommodityVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.deleteCommodity(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to delete the new commodity");
		}
		else{
			System.out.println("We have failed to delete the new commodity");
		}
	}
	
	public void testUpdateC(CommodityVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.updateCommodity(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to update the new commodity");
		}
		else{
			System.out.println("We have failed to update the new commodity");
		}
	}
	
	public void testAddM(CommodityModelVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.addModel(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to add the new commodity model");
		}
		else{
			System.out.println("We have failed to add the new commodity model");
		}
	}
	
	public void testDelM(CommodityModelVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.deleteModel(vo)==ResultMessage.Success){
			System.out.println("We have succeeded to delete the new commodity model");
		}
		else{
			System.out.println("We have failed to delete the new commodity model");
		}
	}
	
	public void testUpdateM(String beforeName,CommodityModelVO vo){
		MockCommodity commodity=new MockCommodity();
		if(commodity.updateModel(beforeName, vo)==ResultMessage.Success){
			System.out.println("We have succeeded to update the new commodity model");
		}
		else{
			System.out.println("We have failed to update the new commodity model");
		}
	}
	
	public void testFindID(String id){
		MockCommodity commodity=new MockCommodity();
		if(commodity.findCommodityInID(id)==null){
			System.out.println("We have failed to find the new commodity");
		}
		else{
			System.out.println("We have succeeded to find the new commodity");
		}
	}
	
	public void testGet(CommodityVO vo,String model){
		MockCommodity commodity=new MockCommodity();
		if(commodity.getModel(vo, model)==null){
			System.out.println("We have failed to find the new commodity model");
		}
		else{
			System.out.println("We have succeeded to find the new commodity model");
		}
	}
}

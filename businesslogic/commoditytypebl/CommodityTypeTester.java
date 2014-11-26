package commoditytypebl;
import java.util.ArrayList;
import vo.*;
import enumType.*;
public class CommodityTypeTester {
	public void testAdder(CommodityTypeVO vo){
		MockCommodityType mock=new MockCommodityType();
		ResultMessage rm=mock.addType(vo);
		if(rm==ResultMessage.Success){
			System.out.println("We have succeeded to add the new commodity type");
		}
		else{
			System.out.println("We have failed to add the new commodity type");
		}
	}
	public void testDelete(CommodityTypeVO vo){
		MockCommodityType mock=new MockCommodityType();
		ResultMessage rm=mock.deleteType(vo);
		if(rm==ResultMessage.Success){
			System.out.println("We have succeeded to delete the commodity type");
		}
		else{
			System.out.println("We have failed to delete the commodity type");
		}
	}
	public void testUpdate(CommodityTypeVO vo){
		MockCommodityType mock=new MockCommodityType();
		ResultMessage rm=mock.updateType(vo);
		if(rm==ResultMessage.Success){
			System.out.println("We have succeeded to update the commodity type");
		}
		else{
			System.out.println("We have failed to update the commodity type");
		}
	}
	public CommodityTypeVO testFind(String id){
		MockCommodityType  mock=new MockCommodityType();
		return mock.findInID(id);
	}
	public ArrayList<CommodityTypeVO> testKey(String key){
		MockCommodityType mock=new MockCommodityType();
		return mock.findInKeyword(key);
	}
}

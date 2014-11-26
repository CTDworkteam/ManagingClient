package commoditybl;

import java.util.*;

import enumType.ResultMessage;
import vo.CommodityModelVO;
import vo.CommodityVO;

public class MockCommodity extends Commodity{
	ArrayList<CommodityModel> model=new ArrayList<CommodityModel>();
	MockCommodity m=new MockCommodity("123","asd","www",200,model);
	public MockCommodity(String id, String name, String type, int total,
			ArrayList<CommodityModel> list) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.total=total;
		this.list=list;
	}

	public MockCommodity(){	
	}
	
	public ResultMessage addCommodity(CommodityVO vo){
		if(vo.getName().equals(m.name)&&vo.getType().equals(m.type)){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage deleteCommodity(CommodityVO vo){
		for(int i=0;i<vo.getList().size();i++){
			if(vo.getList().get(i).getRecentPurchasePrice()!=0){
				return ResultMessage.Failure;
			}
		}
		return ResultMessage.Success;
	}
	
	public ResultMessage updateCommodity(CommodityVO vo){
		if(vo.getName().equals(m.name)&&vo.getType().equals(m.type)){
			return ResultMessage.Failure;
		}
		else{
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage addModel(CommodityModelVO vo){
		if(vo.getModel().equals(m.model)){
			return ResultMessage.Failure;
		}
		return ResultMessage.Success;
	}
	
	public ResultMessage deleteModel(CommodityModelVO vo){
		if(vo.getRecentRetailPrice()!=0){
			return ResultMessage.Failure;
		}
		return ResultMessage.Success;
	}
	
	public ResultMessage updateModel(String beforeName,CommodityModelVO vo){
		if(vo.getModel()!=beforeName)
			return ResultMessage.Success;
		return ResultMessage.Failure;
	}
	
	public CommodityVO findCommodityInID(String id){
		if(m.id.equals(id)){
			return new CommodityVO(m.id,m.name,m.type,m.total,null);
		}
		return null;
	}
	
	/*public ArrayList<CommodityVO> findCommodityInKeyword(String key){
		
	}*/
	
	public CommodityModelVO getModel(CommodityVO vo,String model){
		for(int i=0;i<vo.getList().size();i++){
			if(vo.getList().get(i).getModel().equals(model)){
				return new CommodityModelVO(vo.getList().get(i).getCommodity(),
						vo.getList().get(i).getModel(),vo.getList().get(i).getStorehouse(),
						vo.getList().get(i).getNoticeNumber(),vo.getList().get(i).getStockNumber(),
						vo.getList().get(i).getPurchasePrice(),vo.getList().get(i).getRetailPrice(),
						vo.getList().get(i).getRecentPurchasePrice(),vo.getList().get(i).getRecentRetailPrice());
			}
		}
		return null;
	}
}

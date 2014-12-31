package blservice_stub;
import java.util.*;
import po.*;
import utility.Utility;
import vo.*;
import config.RMI;
import convert.Convert;
import dataservice_stub.*;
import enumType.ResultMessage;
import blservice.*;
public class CommodityBLServiceStub implements CommodityBLService{
	private CommodityDataServiceStub commoditydata = new CommodityDataServiceStub();
	private CommodityTypeDataServiceStub commoditytypedata = new CommodityTypeDataServiceStub();
	public ResultMessage addCommodity(CommodityVO vo) {      //该方法用于增加商品		
		if(commoditydata==null||commoditytypedata==null){
			return ResultMessage.Failure;
		}
		else{
			if(commoditytypedata.findByID(vo.getId().substring(0,11)).isLeafNode()==false){
				return ResultMessage.Failure;
			}
			if(commoditydata.containInId(vo.getId())||commoditydata.containInName(vo.getName())){
				return ResultMessage.Failure;
			}
			commoditydata.insert(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage deleteCommodity(CommodityVO vo) {		//该方法用于删除商品
		if(commoditydata==null){
			return ResultMessage.Failure;
		}
		else{
			if((!commoditydata.containInId(vo.getId()))||(!commoditydata.containInName(vo.getName()))){
				return ResultMessage.Failure;
			}
			if(vo.getTotal()!=0){
				return ResultMessage.Failure;
			}
			commoditydata.delete(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage updateCommodity(CommodityVO vo) {		 //该方法用于更新商品
		if(commoditydata==null){
			return ResultMessage.Failure;
		}
		else{
			if((!commoditydata.containInId(vo.getId()))){
				return ResultMessage.Failure;
			}
			commoditydata.update(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage addModel(CommodityModelVO vo){
		if(commoditydata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!commoditydata.containInId(vo.getCommodity())){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=commoditydata.findCommodityInID(vo.getCommodity());
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					if(iterator.next().getName().equals(vo.getModel())){
						return ResultMessage.Failure;
					}
				}
				po.getList().add(Convert.convert(vo));
				commoditydata.update(po);
				return ResultMessage.Success;
			}
		}
		
	}	
	public ResultMessage deleteModel(String commodityID,String modelName){
		if(commoditydata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!commoditydata.containInId(commodityID)){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=commoditydata.findCommodityInID(commodityID);
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					if(iterator.next().getName().equals(modelName)){
						iterator.remove();
						return ResultMessage.Success;
					}
				}
				return ResultMessage.Failure;
			}
		}
	}
	public ResultMessage updateModel(String beforeName, CommodityModelVO vo){
		if(commoditydata==null){
			return ResultMessage.Failure;
		}
		else{
			if(!commoditydata.containInId(vo.getCommodity())){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=commoditydata.findCommodityInID(vo.getCommodity());
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					if(iterator.next().equals(beforeName)){
						iterator.remove();
						po.getList().add(Convert.convert(vo));
						commoditydata.update(po);
						return ResultMessage.Success;
					}
				}
				return ResultMessage.Failure;
			}
		}
	}
	public CommodityVO findCommodityByID(String id){
		if(commoditydata==null){
			return null;
		}
		else{
			if(!commoditydata.containInId(id)){
				return null;
			}
			else{
				CommodityPO po=commoditydata.findCommodityInID(id);
				return Convert.convert(po);
			}
		}
	}
	public CommodityVO findCommodityByName(String name){
		if(commoditydata==null){
			return null;
		}
		else{
			if(!commoditydata.containInName(name)){
				return null;
			}
			else{
				return Convert.convert(commoditydata.findCommodityInName(name));
			}
		}
	}
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {     //该方法用于模糊查找商品
		if(commoditydata==null){
			return null;
		}
		else{
			if(!commoditydata.containInKeyword(key)){
				return null;
			}
			else{
				ArrayList<CommodityVO> list=new ArrayList<CommodityVO>();
				Iterator<CommodityPO> iterator=commoditydata.findCommoditiesInKeyword(key);
				while(iterator.hasNext()){
					list.add(Convert.convert(iterator.next()));
				}
				return list;
			}
		}
	}
	public CommodityModelVO getModel(String commodityID, String model){
		if(commoditydata==null){
			return null;
		}
		else{
			if(!commoditydata.containInId(commodityID)){
				return null;
			}
			else{
				CommodityPO po=commoditydata.findCommodityInID(commodityID);
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					CommodityPO.CommodityModelPO m=iterator.next();
					if(m.getName().equals(model)){
						return Convert.convert(po.getId(),m);
					}
				}
				return null;
			}
		}
	}
	public ArrayList<CommodityVO> getAllCommodity(){
		if(commoditydata==null){
			return null;
		}
		else{
			ArrayList<CommodityVO> list=new ArrayList<CommodityVO>();
			Iterator<CommodityPO> iterator=commoditydata.getAllCommodities();
			while(iterator.hasNext()){
				list.add(Convert.convert(iterator.next()));
			}
			return list;
		}
	}
	public String getNewID(String typeID) {
		if(commoditydata==null||commoditytypedata==null){
			return "网络故障";
		}
		else{
			if(!commoditytypedata.containInID(typeID)){
				return "不存在相关分类";
			}
			else{
				CommodityTypePO type=commoditytypedata.findByID(typeID);
				if(type.getChilds().size()!=0){
					return "无法添加商品";
				}
				else{
					int number=type.getCommodityList().size()+1;
					String ID=typeID+Utility.getIntegerString(number,3);
					return ID;
				}
			}
		}
	}
}

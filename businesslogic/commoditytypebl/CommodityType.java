package commoditytypebl;
import java.util.*;

import commoditybl.*;
import config.RMI;
import convert.Convert;
import po.*;
import dataservice.*;
import datafactory.*;
import vo.*;
import enumType.ResultMessage;
import blservice.*;

import java.net.MalformedURLException;
import java.rmi.*;
public class CommodityType {
	public CommodityType(){
	}
	public ResultMessage addType(CommodityTypeVO vo){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		if(service.containInKey(vo.getName())){
			return ResultMessage.Failure;
		}
		else{
			if(vo.getFather()==null){
				return ResultMessage.Failure;
			}
			else{
				CommodityTypePO po=service.findByName(vo.getFather());
				if(po.isLeafNode()&&po.getCommodityList().size()!=0){
					return ResultMessage.Failure;
				}
				else{
					if(Integer.parseInt(po.getId().substring(0,1))>5){
						return ResultMessage.Failure;
					}
					else{
						CommodityTypePO output=Convert.convert(vo);
						service.insert(output);
						return ResultMessage.Success;
					}
				}
			}
		}
	}

	public ResultMessage deleteType(CommodityTypeVO vo){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		if(vo.getChild()!=null||vo.getCommodityList()!=null){
			return ResultMessage.Failure;
		}
		else{
			CommodityTypePO po=Convert.convert(vo);
			service.delete(po);
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage updateType(CommodityTypeVO vo){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		if(!service.containInID(vo.getId())){
			return ResultMessage.Failure;
		}
		else{
			CommodityTypePO po=Convert.convert(vo);
			service.update(po);
			return ResultMessage.Success;
		}
	}
	
	public CommodityTypeVO findInID(String id){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return null;
		}
		if(!service.containInID(id)){
			return null;
		}
		else{
			CommodityTypePO po=service.findByID(id);
			return Convert.convert(po);
		}
	}
	
	public ArrayList<CommodityTypeVO> findInKeyword(String key){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return null;
		}
		if(service.containInKey(key)){
			return null;
		}
		else{
			Iterator<CommodityTypePO> iterator=service.findByKeyword(key);
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			while(iterator.hasNext()){
				list.add(Convert.convert(iterator.next()));
			}
			return list;
		}
	}
	
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo){
		CommodityTypeDataService service = RMI.getCommodityTypeDataService();
		if(service==null){
			return null;
		}
		if(vo.getChild().size()==0){
			return null;
		}
		else{
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			Iterator<String> childs=vo.getChild().iterator();
			while(childs.hasNext()){
				list.add(Convert.convert(service.findByName(childs.next())));
			}
			return list;
		}
	}
	
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo){
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return null;
		}
		if(!service.hasCommodityType()){
			return null;
		}
		else{
			ArrayList<CommodityVO> list=new ArrayList<CommodityVO>();
			Iterator<String> iterator=vo.getCommodityList().iterator();
			Commodity commodity=new Commodity();
			while(iterator.hasNext()){
				list.add(commodity.findCommodityByName(iterator.next()));
			}
			return list;
		}
	}
	public ArrayList<CommodityTypeVO> getAllCommodityType() {
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return null;
		}
		if(!service.hasCommodityType()){
			return null;
		}
		else{
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			Iterator<CommodityTypePO> iterator=service.getAllCommodityTypes();
			while(iterator.hasNext()){
				list.add(Convert.convert(iterator.next()));
			}
			return list;
		}
	}
}

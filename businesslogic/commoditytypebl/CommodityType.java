package commoditytypebl;
import java.util.*;

import commoditybl.*;
import config.RMI;
import convert.Convert;
import po.*;
import dataservice.*;
import datafactory.*;
import utility.Utility;
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
				CommodityTypePO po=Convert.convert(vo);
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
			return vo.getChild();
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
			return vo.getCommodityList();
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
	public String getNewID(String fatherID) {
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		if(service==null){
			return "网络连接不稳定";
		}
		else{
			if(!service.containInID(fatherID)){
				return "不存在相关父类";
			}
			else{
				CommodityTypePO po=service.findByID(fatherID);
				if(po.getCommodityList().size()!=0){
					return "由于有商品，无法添加";
				}
				else{
					int number=po.getChilds().size()+1;
					int depthOfFather=Integer.parseInt(fatherID.substring(0,1));
					int depth=depthOfFather+1;
					String ID=new Integer(depth).toString();
					ID+=fatherID.substring(1,2*depthOfFather+1);
					ID+=Utility.getIntegerString(number,3);
					while(ID.length()<11){
						ID+="0";
					}
					return ID;
				}
			}
		}
	}
}
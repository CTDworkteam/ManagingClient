package commoditybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

import blservice.*;
import datafactory.*;
import config.RMI;
import convert.Convert;
import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;

public class Commodity{
	public Commodity(){
	}
	public ResultMessage addCommodity(CommodityVO vo) {      //该方法用于增加商品		
		CommodityDataService service=RMI.getCommodityDataService();
		CommodityTypeDataService typeservice=RMI.getCommodityTypeDataService();
		if(service==null||typeservice==null){
			return ResultMessage.Failure;
		}
		else{
			if(typeservice.findByID(vo.getId().substring(0,11)).isLeafNode()==false){
				return ResultMessage.Failure;
			}
			if(service.containInId(vo.getId())||service.containInName(vo.getName())){
				return ResultMessage.Failure;
			}
			service.insert(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage deleteCommodity(CommodityVO vo) {		//该方法用于删除商品
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if((!service.containInId(vo.getId()))||(!service.containInName(vo.getName()))){
				return ResultMessage.Failure;
			}
			if(vo.getTotal()!=0){
				return ResultMessage.Failure;
			}
			service.delete(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage updateCommodity(CommodityVO vo) {		 //该方法用于更新商品
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if((!service.containInId(vo.getId()))){
				return ResultMessage.Failure;
			}
			service.update(Convert.convert(vo));
			return ResultMessage.Success;
		}
	}
	public ResultMessage addModel(CommodityModelVO vo){
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service.containInId(vo.getCommodity())){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=service.findCommodityInID(vo.getCommodity());
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					if(iterator.next().getName().equals(vo.getModel())){
						return ResultMessage.Failure;
					}
				}
				po.getList().add(Convert.convert(vo));
				service.update(po);
				return ResultMessage.Success;
			}
		}
		
	}	
	public ResultMessage deleteModel(String commodityID,String modelName){
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service.containInId(commodityID)){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=service.findCommodityInID(commodityID);
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
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return ResultMessage.Failure;
		}
		else{
			if(!service.containInId(vo.getCommodity())){
				return ResultMessage.Failure;
			}
			else{
				CommodityPO po=service.findCommodityInID(vo.getCommodity());
				Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
				while(iterator.hasNext()){
					if(iterator.next().equals(beforeName)){
						iterator.remove();
						po.getList().add(Convert.convert(vo));
						service.update(po);
						return ResultMessage.Success;
					}
				}
				return ResultMessage.Failure;
			}
		}
	}
	public CommodityVO findCommodityByID(String id){
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return null;
		}
		else{
			if(!service.containInId(id)){
				return null;
			}
			else{
				CommodityPO po=service.findCommodityInID(id);
				return Convert.convert(po);
			}
		}
	}
	public CommodityVO findCommodityByName(String name){
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return null;
		}
		else{
			if(!service.containInName(name)){
				return null;
			}
			else{
				return Convert.convert(service.findCommodityInName(name));
			}
		}
	}
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {     //该方法用于模糊查找商品
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return null;
		}
		else{
			if(!service.containInKeyword(key)){
				return null;
			}
			else{
				ArrayList<CommodityVO> list=new ArrayList<CommodityVO>();
				Iterator<CommodityPO> iterator=service.findCommoditiesInKeyword(key);
				while(iterator.hasNext()){
					list.add(Convert.convert(iterator.next()));
				}
				return list;
			}
		}
	}
	public CommodityModelVO getModel(String commodityID, String model){
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return null;
		}
		else{
			if(!service.containInId(commodityID)){
				return null;
			}
			else{
				CommodityPO po=service.findCommodityInID(commodityID);
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
		CommodityDataService service=RMI.getCommodityDataService();
		if(service==null){
			return null;
		}
		else{
			ArrayList<CommodityVO> list=new ArrayList<CommodityVO>();
			Iterator<CommodityPO> iterator=service.getAllCommodities();
			while(iterator.hasNext()){
				list.add(Convert.convert(iterator.next()));
			}
			return list;
		}
	}
	public String getNewID(String typeID) {
		CommodityTypeDataService service1=RMI.getCommodityTypeDataService();
		CommodityDataService service2=RMI.getCommodityDataService();
		if(service1==null||service2==null){
			return "网络故障";
		}
		else{
			if(!service1.containInID(typeID)){
				return "不存在相关分类";
			}
			else{
				CommodityTypePO type=service1.findByID(typeID);
				if(type.getChilds().size()!=0){
					return "无法添加商品";
				}
				else{
					int number=type.getCommodityList().size()+1;
					String ID=typeID+String.format("%3d",number);
					return ID;
				}
			}
		}
	}
}
package commoditybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

import datafactory.*;
import config.RMI;
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
			service.insert(exchange(vo));
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
			service.delete(exchange(vo));
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
			service.update(exchange(vo));
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
				po.getList().add(exchange(vo));
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
						po.getList().add(exchange(vo));
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
				return exchange(po);
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
				return exchange(service.findCommodityInName(name));
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
					list.add(exchange(iterator.next()));
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
						return exchange(po.getId(),m);
					}
				}
				return null;
			}
		}
	}
	private CommodityModelVO exchange(String commodityID,CommodityPO.CommodityModelPO po) {
		CommodityModelVO vo=new CommodityModelVO(po.getName(),po.getModel(),
				po.getStorehouse(),po.getNoticeNumber(),po.getStock(),
				po.getPurchasePrice(),po.getRetailPrice(),
				po.getRecentPurchasePrice(),po.getRecentRetailPrice());
		return vo;
	}

	public CommodityPO exchange(CommodityVO vo) {        //VO转化为PO
		try{
			CommodityTypeDataService service = (CommodityTypeDataService) Naming.lookup("");
			ArrayList<CommodityModelPO> list=new ArrayList<CommodityModelPO>();
			ArrayList<CommodityModelVO> list2=vo.getList();
			for(int i=0;i<list2.size();i++){
				CommodityModelPO a=new CommodityModelPO(list2.get(i).getCommodity(),list2.get(i).getModel(),list2.get(i).getStockNumber(),
						list2.get(i).getStorehouse(),list2.get(i).getNoticeNumber(),
						list2.get(i).getPurchasePrice(),list2.get(i).getRetailPrice(),
						list2.get(i).getRecentPurchasePrice(),list2.get(i).getRecentRetailPrice());
				list.add(a);
			}
			CommodityTypePO type=service.findCommodityTypeInName(vo.getType());
			CommodityPO po=new CommodityPO(vo.getId(),vo.getName(),type,vo.getTotal(),list);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public CommodityVO exchange(CommodityPO po){          //PO转化为VO
		try{
			CommodityTypeDataService service = (CommodityTypeDataService) Naming.lookup("");
			ArrayList<CommodityModelPO> list=po.getList();
			ArrayList<CommodityModelVO> list2=new ArrayList<CommodityModelVO>();
			for(int i=0;i<list.size();i++){
				CommodityModelVO a=new CommodityModelVO(list.get(i).getName(),list.get(i).getModel(),
						list.get(i).getStorehouse(),list.get(i).getNoticeNumber(),list.get(i).getStock(),
						list.get(i).getPurchasePrice(),list.get(i).getRetailPrice(),
						list.get(i).getRecentPurchasePrice(),list.get(i).getRecentRetailPrice());
				list2.add(a);
			}
			String type = po.getType().getName();
			CommodityVO vo=new CommodityVO(po.getId(),po.getName(),type,po.getTotal(),list2);
			return vo;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	private CommodityPO.CommodityModelPO exchange(CommodityModelVO vo) {
		CommodityModelPO po=new CommodityModelPO(vo.getCommodity(),vo.getModel(),
				vo.getStockNumber(),vo.getStorehouse(),vo.getNoticeNumber(),
				vo.getPurchasePrice(),vo.getRetailPrice(),
				vo.getRecentPurchasePrice(),vo.getRecentRetailPrice());
		return po;
	}
}
package commoditytypebl;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import po.*;
import dataservice.*;
import vo.*;
import enumType.ResultMessage;

public class CommodityTypeImpl extends CommodityTypeController{
	public ResultMessage addType(CommodityTypeVO vo){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("rmi://localhost:1099/addCommodityType");
			
			String father=vo.getFather();
			CommodityTypePO po=service.findCommodityTypeInName(father);
			String temp=po.getId().substring(0,1);
			if(temp.equals("5"))
				return ResultMessage.Failure;
			else if(service.findCommodityTypeInName(vo.getName())!=null){
				return ResultMessage.Failure;
			}
			else if(po.isLeafNode()){
				return ResultMessage.Failure;
			}
			else{
				CommodityTypePO result=exchange(vo);
				service.insertCommodityType(result);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public ResultMessage deleteType(CommodityTypeVO vo){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("rmi://localhost:1099/addCommodityType");
			
			if((vo.getChild()!=null)||(vo.getCommodityList()!=null)){
				return ResultMessage.Failure;
			}
			else{
				CommodityTypePO po=exchange(vo);
				service.deleteCommodityType(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage updateType(CommodityTypeVO vo){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			
			CommodityTypePO po=exchange(vo);
			if(service.findCommodityTypeInName(vo.getName())!=null){
				return ResultMessage.Failure;
			}
			else{
				service.updateCommodityType(po);
				return ResultMessage.Success;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public CommodityTypeVO findInID(String id){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			
			CommodityTypePO po=service.findCommodityType(id);
			CommodityTypeVO vo=exchange(po);
			
			return vo;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CommodityTypeVO> findInKeyword(String key){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			
			TreeSet<CommodityTypePO> po=service.findCommodityTypes(key);
			ArrayList<CommodityTypeVO> vo=new ArrayList<CommodityTypeVO>();
			Iterator i=po.iterator();
			while(i.hasNext()){
				vo.add(exchange((CommodityTypePO) i.next()));
			}
			return vo;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo){
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			
			ArrayList<String> child=vo.getChild();
			ArrayList<CommodityTypeVO> result=new ArrayList<CommodityTypeVO>();
			
			for(int i=0;i<child.size();i++){
				result.add(exchange(service.findCommodityTypeInName(child.get(i))));
			}
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo){
		try{
			CommodityDataService service=(CommodityDataService) Naming.lookup("");
			
			ArrayList<String> sub=vo.getCommodityList();
			ArrayList<CommodityVO> result=new ArrayList<CommodityVO>();
			
			for(int i=0;i<sub.size();i++){
				result.add(exchange(service.findCommodityInName(sub.get(i))));
			}
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	private CommodityVO exchange(CommodityPO po) {
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

	private CommodityTypeVO exchange(CommodityTypePO po) {
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			CommodityDataService service2=(CommodityDataService) Naming.lookup("");
			
			ArrayList<CommodityPO> list=po.getCommodityList();
			ArrayList<String> list2=new ArrayList<String>();
			ArrayList<CommodityTypePO> list3=po.getChild();
			ArrayList<String> list4=new ArrayList<String>();
			
			for(int i=0;i<list.size();i++){
				list2.add(list.get(i).getName());
			}
			
			for(int i=0;i<list3.size();i++){
				list4.add(list3.get(i).getName());
			}
			
			String father=po.getFather().getName();
			
			CommodityTypeVO vo=new CommodityTypeVO(po.getId(),po.getName(),
					po.isRootNode(),po.isLeafNode(),list2,father,list4);
			return vo;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private CommodityTypePO exchange(CommodityTypeVO vo) {
		try{
			CommodityTypeDataService service=(CommodityTypeDataService) Naming.lookup("");
			CommodityDataService service2=(CommodityDataService) Naming.lookup("");
			
			ArrayList<CommodityPO> list=new ArrayList<CommodityPO>();
			ArrayList<String> list2=vo.getCommodityList();
			ArrayList<CommodityTypePO> list3=new ArrayList<CommodityTypePO>();
			
			for(int i=0;i<list2.size();i++){
				list.add(service2.findCommodityInName(list2.get(i)));
			}
		
			CommodityTypePO type=service.findCommodityTypeInName(vo.getFather());
			
			list2=vo.getChild();
			for(int i=0;i<list2.size();i++){
				list3.add(service.findCommodityTypeInName(list2.get(i)));
			}
			
			CommodityTypePO po=new CommodityTypePO(vo.getId(),vo.getName(),
					vo.isRootNode(),vo.isLeafNode(),list,type,list3);
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

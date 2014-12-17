package commoditytypebl;
import java.util.*;

import commoditybl.*;
import config.RMI;
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
		DataFactoryService factory=null;
		try {
			factory = (DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		CommodityTypeDataService service=null;
		try {
			service = factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
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
						CommodityTypePO output=exchange(vo);
						service.insert(output);
						return ResultMessage.Success;
					}
				}
			}
		}
	}

	public ResultMessage deleteType(CommodityTypeVO vo){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		if(vo.getChild()!=null||vo.getCommodityList()!=null){
			return ResultMessage.Failure;
		}
		else{
			CommodityTypePO po=exchange(vo);
			service.delete(po);
			return ResultMessage.Success;
		}
	}
	
	public ResultMessage updateType(CommodityTypeVO vo){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		if(!service.containInID(vo.getId())){
			return ResultMessage.Failure;
		}
		else{
			CommodityTypePO po=exchange(vo);
			service.update(po);
			return ResultMessage.Success;
		}
	}
	
	public CommodityTypeVO findInID(String id){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(!service.containInID(id)){
			return null;
		}
		else{
			CommodityTypePO po=service.findByID(id);
			return exchange(po);
		}
	}
	
	public ArrayList<CommodityTypeVO> findInKeyword(String key){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(service.containInKey(key)){
			return null;
		}
		else{
			Iterator<CommodityTypePO> iterator=service.findByKeyword(key);
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			while(iterator.hasNext()){
				list.add(exchange(iterator.next()));
			}
			return list;
		}
	}
	
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(vo.getChild().size()==0){
			return null;
		}
		else{
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			Iterator<String> childs=vo.getChild().iterator();
			while(childs.hasNext()){
				list.add(exchange(service.findByName(childs.next())));
			}
			return list;
		}
	}
	
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo){
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
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
	private CommodityTypeVO exchange(CommodityTypePO po) {
		CommodityTypeVO vo=null;
		try{
			vo=new CommodityTypeVO(po.getId(),po.getName(),po.isRootNode(),po.isLeafNode(),
					po.getCommodityList(),po.getFather(),po.getChilds());
			return vo;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	private CommodityTypePO exchange(CommodityTypeVO vo) {
		CommodityTypePO po=null;
		try{
			po=new CommodityTypePO(vo.getId(),vo.getName(),vo.isRootNode(),vo.isLeafNode(),
					vo.getCommodityList(),vo.getFather(),vo.getChild());
			return po;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public ArrayList<CommodityTypeVO> getAllCommodityType() {
		DataFactoryService factory=null;
		try {
			factory=(DataFactoryService)Naming.lookup(RMI.URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		} catch (NotBoundException e) {
			e.printStackTrace();
			return null;
		}
		CommodityTypeDataService service=null;
		try {
			service=factory.getCommodityTypeDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(!service.hasCommodityType()){
			return null;
		}
		else{
			ArrayList<CommodityTypeVO> list=new ArrayList<CommodityTypeVO>();
			Iterator<CommodityTypePO> iterator=service.getAllCommodityTypes();
			while(iterator.hasNext()){
				list.add(exchange(iterator.next()));
			}
			return list;
		}
	}
}

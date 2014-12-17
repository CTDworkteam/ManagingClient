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
	/*public ResultMessage addCommodity(CommodityVO vo);
	public ResultMessage deleteCommodity(CommodityVO vo);
	public ResultMessage updateCommodity(CommodityVO vo);
	public ResultMessage addModel(CommodityModelVO model);
	public ResultMessage deleteModel(CommodityVO commodity,String modelName);
	public ResultMessage updateModel(String beforeName,CommodityModelVO vo);
	public CommodityVO findCommodityByID(String id);
	public CommodityVO findCommodityByName(String name);
	public ArrayList<CommodityVO> findCommodityInKeyword(String key);
	public CommodityModelVO getModel(CommodityVO vo,String model);*/
	public ResultMessage addCommodity(CommodityVO vo) {      //�÷�������������Ʒ		
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
		CommodityDataService service=null;
		try {
			service=factory.getCommodityDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
		if(service.containInId(vo.getId())||service.containInName(vo.getName())){
			return ResultMessage.Failure;
		}
		else{
			try {
				CommodityTypeDataService typeservice=factory.getCommodityTypeDataService();
				if(!typeservice.findByID(vo.getType()).isLeafNode()){
					return ResultMessage.Failure;
				}
				else{
					service.insert(exchange(vo));
					return ResultMessage.Success;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return ResultMessage.Failure;
			}
			
		}
	}
	public ResultMessage deleteCommodity(CommodityVO vo) {		//�÷�������ɾ����Ʒ
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
		CommodityDataService service=null;
		try {
			service=factory.getCommodityDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage updateCommodity(CommodityVO vo) {		 //�÷������ڸ�����Ʒ
		try{
			CommodityDataService service = RMI.getCommodityDataService();
		
			if(service.containCommodity(vo.getName())){      //�ж��Ƿ���ڸ���Ʒ
				CommodityPO po = exchange(vo);
				service.updateCommodity(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage addModel(CommodityModelVO vo){
		try{
			CommodityDataService service = RMI.getCommodityDataService();
			
			if(service.findCommodityInName(vo.getCommodity())!=null){
				CommodityPO po=service.findCommodityInName(vo.getCommodity());
				ArrayList<CommodityModelPO> temp=po.getList();
				for(int i=0;i<temp.size();i++){
					if(temp.get(i).getModel().equals(vo.getModel()))
						return ResultMessage.Failure;
				}
				temp.add(exchange(vo));
				po.setList(temp);
				service.updateCommodity(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteModel(CommodityModelVO vo){
		try{
			CommodityDataService service = RMI.getCommodityDataService();
			
			if(service.findCommodityInName(vo.getCommodity())!=null){
				CommodityPO po=service.findCommodityInName(vo.getCommodity());
				ArrayList<CommodityModelPO> temp=po.getList();
				for(int i=0;i<temp.size();i++){
					if(temp.get(i).getModel().equals(vo.getModel())){
						temp.remove(i);
						po.setList(temp);
						service.updateCommodity(po);
						return ResultMessage.Success;
					}
				}
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage updateModel(String beforeName, CommodityModelVO vo){
		try{
			CommodityDataService service = RMI.getCommodityDataService();
			
			if(service.findCommodityInName(vo.getCommodity())!=null){
				CommodityPO po=service.findCommodityInName(vo.getCommodity());
				ArrayList<CommodityModelPO> temp=po.getList();
				int position=0;
				for(int i=0;i<temp.size();i++){
					if(temp.get(i).getModel().equals(beforeName)){
						return ResultMessage.Failure;
					}
					else if(temp.get(i).getModel().equals(vo.getModel()))
						position=i;
				}
				temp.get(position).setModel(beforeName);
				po.setList(temp);
				service.updateCommodity(po);
				return ResultMessage.Success;
			}
			return ResultMessage.Failure;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}

	public CommodityVO findCommodityInID(String id) {      //�÷������ڲ�����Ʒ
		try {
			CommodityDataService service = RMI.getCommodityDataService();
			if(service.containCommodity(id)) {
				CommodityPO po = service.findCommodity(id);
				CommodityVO vo = exchange(po);
				return vo;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return null;
		}
	}
	
	public ArrayList<CommodityVO> findCommodityInKeyword(String key) {     //�÷�������ģ��������Ʒ
		try{
			CommodityDataService service = RMI.getCommodityDataService();
			if(service.containCommodities(key)) {
				TreeSet<CommodityPO> po = service.findCommodities(key);
				ArrayList<CommodityVO> vo = new ArrayList<CommodityVO>();
				Iterator<CommodityPO> i = po.iterator();            //����������
				while(i.hasNext()){
					vo.add(exchange((CommodityPO) i.next()));
				}
				return vo;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return null;
		}
	}
	
	public CommodityModelVO getModel(CommodityVO vo, String model){
		try{
			CommodityDataService service = RMI.getCommodityDataService();
			
			if(service.containCommodity(vo.getId())){
				CommodityPO po=service.findCommodity(vo.getId());
				ArrayList<CommodityModelPO> temp=po.getList();
				for(int i=0;i<temp.size();i++){
					if(temp.get(i).getModel().equals(model)){
						CommodityModelVO m=exchange(temp.get(i));
						return m;
					}
				}
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public CommodityVO findCommodityByName(String name){
		
	}
	private CommodityModelVO exchange(CommodityModelPO po) {
		CommodityModelVO vo=new CommodityModelVO(po.getName(),po.getModel(),
				po.getStorehouse(),po.getNoticeNumber(),po.getStock(),
				po.getPurchasePrice(),po.getRetailPrice(),
				po.getRecentPurchasePrice(),po.getRecentRetailPrice());
		return vo;
	}

	public CommodityPO exchange(CommodityVO vo) {        //VOת��ΪPO
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
	
	public CommodityVO exchange(CommodityPO po){          //POת��ΪVO
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
	
	private CommodityModelPO exchange(CommodityModelVO vo) {
		CommodityModelPO po=new CommodityModelPO(vo.getCommodity(),vo.getModel(),
				vo.getStockNumber(),vo.getStorehouse(),vo.getNoticeNumber(),
				vo.getPurchasePrice(),vo.getRetailPrice(),
				vo.getRecentPurchasePrice(),vo.getRecentRetailPrice());
		return po;
	}
}
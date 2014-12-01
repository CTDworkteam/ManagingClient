package commoditybl;

import java.rmi.Naming;
import java.util.*;
import dataservice.*;
import po.*;
import vo.*;
import enumType.*;

public class CommodityImpl extends CommodityController {
	public ResultMessage addCommodity(CommodityVO vo) {      //�÷�������������Ʒ		
		try {
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/addCommodity");
			
			CommodityPO po = exchange(vo);
			ArrayList<CommodityModelPO> list = po.getList();
			if(service.findCommodityInName(vo.getName()) == null) {  //�ж��Ƿ���ڸ���Ʒ
				service.insertCommodity(po);
				return ResultMessage.Success;
			}
			else {
				CommodityPO temp = service.findCommodityInName(vo.getName());
				ArrayList<CommodityModelPO> list2 = temp.getList();
				for(int i = 0;i < list.size();i++) {
					for(int j = 0;j < list2.size();j++) {        //�ж��ͺ��Ƿ�һ����һ���򷵻ش���
						if(list.get(i).getModel().equals(list2.get(i).getModel()))
							return ResultMessage.Failure;
					}			
				}
				service.insertCommodity(po);
				return ResultMessage.Success;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage deleteCommodity(CommodityVO vo) {		//�÷�������ɾ����Ʒ
		try {
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/delCommodity");
		
			if(service.containCommodity(vo.getName())){      //�鿴�Ƿ��и���Ʒ
				CommodityPO po = service.findCommodity(vo.getName());
				if(po.getTotal() != 0) {            //���Ƿ��н�����Ϊ
					service.deleteCommodity(po);
					return ResultMessage.Success;
				}
			}
			return ResultMessage.Failure;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage updateCommodity(CommodityVO vo) {		 //�÷������ڸ�����Ʒ
		try{
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/updateCommodity");
		
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/updateCommodity");
			
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/updateCommodity");
			
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/updateCommodity");
			
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/findCommodityInID");
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("rmi://localhost:1099/findCommodityInKeyword");
			if(service.containCommodities(key)) {
				TreeSet<CommodityPO> po = service.findCommodities(key);
				ArrayList<CommodityVO> vo = new ArrayList<CommodityVO>();
				Iterator i = po.iterator();            //����������
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
			CommodityDataService service = (CommodityDataService) Naming.lookup("");
			
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

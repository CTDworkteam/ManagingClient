package financecheckbl;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import po.ClientPO;
import po.SalesBillPO;
import po.UserPO;
import po.SalesBillPO.SalesBillItemPO;
import dataservice.SalesDataService;
import enumType.*;
import userbl.*;
import vo.*;
import vo.DetailListVO.DetailListItemVO;
import blservice.*;
public class FinanceCheck{
	public User operator;
	public FinanceCheck(User operator){
		this.operator=operator;
	}
	public FinanceCheck(){
		
	}
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end){
		try{
			SalesDataService service=(SalesDataService) Naming.lookup("");
			if(service.contains1(start, end)){
				TreeSet<SalesBillPO> temp=service.finds1(start, end);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				Iterator i=temp.iterator();
				while(i.hasNext()){
					SalesBillPO sales=(SalesBillPO) i.next();
					String date=sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list=sales.getList();
					for(int j=0;j<list.size();j++){
						vo.add(exchange(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(start.toString(),end.toString(),
						null,null,null,null,vo);
				return result;
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public DetailListVO getDetailList(String commodity){
		try{
			SalesDataService service=(SalesDataService) Naming.lookup("");
			if(service.containCommodity(commodity)){
				ArrayList<SalesBillItemPO> sales=service.findCommodity1(commodity);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
		
				for(int i=0;i<sales.size();i++){
					
					vo.add(exchange(date,sales.get(i)));
				}
				DetailListVO result=new DetailListVO(null,null,commodity,
						null,null,null,vo);
				return result;
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public DetailListVO getDetailList(ClientVO client){
		try{
			SalesDataService service=(SalesDataService) Naming.lookup("");
			ClientPO po=exchange(client);
			if(service.containsClient(po)){
				ArrayList<SalesBillPO> temp=service.findClient1(po);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				for(int i=0;i<temp.size();i++){
					SalesBillPO sales=temp.get(i);
					String date=sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list=sales.getList();
					for(int j=0;j<list.size();j++){
						vo.add(exchange(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,null,
						client.getName(),null,vo);
				return result;
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public DetailListVO getDetailList(UserVO operator){
		try{
			SalesDataService service=(SalesDataService) Naming.lookup("");
			UserPO po=exchange(operator);
			if(service.containsOperator(po)){
				ArrayList<SalesBillPO> temp=service.findOperator(po);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				for(int i=0;i<temp.size();i++){
					SalesBillPO sales=temp.get(i);
					String date=sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list=sales.getList();
					for(int j=0;j<list.size();j++){
						vo.add(exchange(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,operator.getName(),
						null,null,vo);
				return result;
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public DetailListVO getDetailListInStorehouse(String storehouse){
		
	}
	
	private ClientPO exchange(ClientVO vo) {  //VO对象转化为PO对象
		ClientPO po = new ClientPO(vo.getId(),vo.getName(),vo.getType(),
				vo.getRank(),vo.getTelephone(),vo.getAddress(),vo.getPostcode(),
				vo.getEmail(),vo.getAmountReserved(),vo.getMoneyReserved(),
				vo.getMoneyToPay(),vo.getCourterman(),vo.getDiscount(),
				vo.getVoucher());
		return po;
	}
	private DetailListItemVO exchange(String date, SalesBillItemPO sales) {
		DetailListVO.DetailListItemVO v=new DetailListVO().new DetailListItemVO(date,sales.getCommodity().getName(),
				sales.getModel(),sales.getNumber(),sales.getPrice(),sales.getTotal());
		return v;
	}
	private UserPO exchange(UserVO vo) {
		UserPO po=new UserPO(vo.getId(),vo.getName(),vo.getPassword(),
				vo.getRole());
		return po;
	}
}

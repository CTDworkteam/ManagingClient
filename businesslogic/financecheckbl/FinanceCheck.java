package financecheckbl;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import config.RMI;
import convert.Convert;
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
public class FinanceCheck implements FinanceCheckBLService{
	public FinanceCheck(){
	}
	
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.contains1(start, end)){
				Iterator<SalesBillPO> i = service.finds1(start, end);
			
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					ArrayList<SalesBillItemPO> list=sales.getList();
					for(int j=0;j<list.size();j++){
						vo.add(Convert.convert());
					}
				}
				DetailListVO result=new DetailListVO(start,end,
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

	@Override
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(BillType type) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(UserVO operator) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(ClientVO client) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ProcessListVO getProcessList(String storehouse) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(ProcessListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(ConditionListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage export(DetailListVO list, String dest) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ReciptVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(PaymentVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		// TODO 自动生成的方法存根
		return null;
	}
}

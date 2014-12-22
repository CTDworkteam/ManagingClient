package financecheckbl;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import config.RMI;
import convert.Convert;
import po.SalesBillPO;
import po.SalesBillPO.SalesBillItemPO;
import dataservice.SalesDataService;
import enumType.*;
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
				ArrayList<DetailListItemVO> list2 = new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					ArrayList<SalesBillItemPO> list = sales.getList();
					String date = sales.getId().substring(3,11);
					
					for(int j = 0; j<list.size(); j++){
						list2.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(start.toString(),end.toString(),
						null,null,null,null,list2);
				return result;
			}
			return null;
		}
	}
	
	public DetailListVO getDetailList(String commodity){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containCommodity(commodity)){
				Iterator<SalesBillPO> i = service.findCommodity1(commodity);
				ArrayList<DetailListItemVO> vo = new ArrayList<DetailListItemVO>();
		
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					ArrayList<SalesBillItemPO> list = sales.getList();
					String date = sales.getId().substring(3,11);
					
					for(int j = 0; j<list.size();j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,commodity,
						null,null,null,vo);
				return result;
			}
			return null;
		}
	}
	
	public DetailListVO getDetailList(ClientVO client){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containsClient(client.getId())){
				Iterator<SalesBillPO> i = service.findClient1(client.getId());
				ArrayList<DetailListItemVO> vo = new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
					
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,null,
						client.getName(),null,vo);
				return result;
			}
			return null;
		}
	}

	public DetailListVO getDetailList(UserVO operator){
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containsOperator(operator.getName())){
				Iterator<SalesBillPO> i = service.findOperator(operator.getName());
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
				
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,operator.getName(),
						null,null,vo);
				return result;
			}
			return null;
		}
	}


	public DetailListVO getDetailListInStorehouse(String storehouse) {
		SalesDataService service = RMI.getSalesDataService();
		
		if(service == null){
			return null;
		}
		
		else{
			if(service.containStorehouse(storehouse)){
				Iterator<SalesBillPO> i = service.findStorehouse(storehouse);
				ArrayList<DetailListItemVO> vo=new ArrayList<DetailListItemVO>();
				
				while(i.hasNext()){
					SalesBillPO sales = i.next();
					String date = sales.getId().substring(3,11);
					ArrayList<SalesBillItemPO> list = sales.getList();
				
					for(int j = 0; j<list.size(); j++){
						vo.add(Convert.convert(date,list.get(j)));
					}
				}
				DetailListVO result=new DetailListVO(null,null,null,null,
						null,storehouse,vo);
				return result;
			}
			return null;
		}
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

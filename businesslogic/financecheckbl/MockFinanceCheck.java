package financecheckbl;
import java.util.*;
import vo.*;
import enumType.BillType;
import enumType.ResultMessage;
import commoditybl.*;
public class MockFinanceCheck extends FinanceCheck{
	private ArrayList<DetailListItem> saleslist;
	private Commodity commodity=new Commodity();
	public MockFinanceCheck(){
		saleslist=new ArrayList<DetailListItem>();
		GregorianCalendar date1=new GregorianCalendar();
		date1.set(2014,11,11);
		GregorianCalendar date2=new GregorianCalendar();
		date2.set(2014,11,12);
		GregorianCalendar date3=new GregorianCalendar();
		date3.set(2014,11,8);
		String model="SR01";
		saleslist.add(new DetailListItem(date1,commodity,model,10,100));
		saleslist.add(new DetailListItem(date2,commodity,model,50,33));
		saleslist.add(new DetailListItem(date3,commodity,model,9,99));
	}
	@Override
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end) {
		DetailListVO vo=new DetailListVO();
		vo.setClient("David");
		vo.setCommodity(commodity.name);
		vo.setStart(start.toString());
		vo.setEnd(end.toString());
		vo.setOperator("王一琦");
		vo.setStorehouse("南京仓库");
		vo.setList(new ArrayList<DetailListVO.DetailListItemVO>());
		for(int i=0;i<=saleslist.size()-1;i++){
			if(saleslist.get(i).date.after(end)||saleslist.get(i).date.before(start)){
				continue;
			}
			else{
				DetailListVO.DetailListItemVO item=new DetailListVO().new DetailListItemVO();
				item.update(saleslist.get(i));
				vo.getList().add(item);
			}
		}
		return vo;
	}

	@Override
	public DetailListVO getDetailList(String commodity) {
		DetailListVO vo=new DetailListVO();
		vo.setClient("David");
		vo.setCommodity(commodity);
		vo.setStart(saleslist.get(2).date.toString());
		vo.setEnd(saleslist.get(1).date.toString());
		vo.setOperator("王一琦");
		vo.setStorehouse("南京仓库");
		vo.setList(new ArrayList<DetailListVO.DetailListItemVO>());
		for(int i=0;i<=saleslist.size()-1;i++){
			DetailListVO.DetailListItemVO item=new DetailListVO().new DetailListItemVO();
			item.update(saleslist.get(i));
			vo.getList().add(item);
		}
		return vo;
	}

	@Override
	public DetailListVO getDetailList(ClientVO client) {
		DetailListVO vo=new DetailListVO();
		vo.setClient(client.getName());
		vo.setCommodity(commodity.name);
		vo.setStart(saleslist.get(2).date.toString());
		vo.setEnd(saleslist.get(1).date.toString());
		vo.setOperator("王一琦");
		vo.setStorehouse("南京仓库");
		vo.setList(new ArrayList<DetailListVO.DetailListItemVO>());
		for(int i=0;i<=saleslist.size()-1;i++){
			DetailListVO.DetailListItemVO item=new DetailListVO().new DetailListItemVO();
			item.update(saleslist.get(i));
			vo.getList().add(item);
		}
		return vo;
	}

	@Override
	public DetailListVO getDetailList(UserVO operator) {
		DetailListVO vo=new DetailListVO();
		vo.setClient("David");
		vo.setCommodity(commodity.name);
		vo.setStart(saleslist.get(2).date.toString());
		vo.setEnd(saleslist.get(1).date.toString());
		vo.setOperator(operator.getName());
		vo.setStorehouse("南京仓库");
		vo.setList(new ArrayList<DetailListVO.DetailListItemVO>());
		for(int i=0;i<=saleslist.size()-1;i++){
			DetailListVO.DetailListItemVO item=new DetailListVO().new DetailListItemVO();
			item.update(saleslist.get(i));
			vo.getList().add(item);
		}
		return vo;
	}

	@Override
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		DetailListVO vo=new DetailListVO();
		vo.setClient("David");
		vo.setCommodity(commodity.name);
		vo.setStart(saleslist.get(2).date.toString());
		vo.setEnd(saleslist.get(1).date.toString());
		vo.setOperator("王一琦");
		vo.setStorehouse(storehouse);
		vo.setList(new ArrayList<DetailListVO.DetailListItemVO>());
		for(int i=0;i<=saleslist.size()-1;i++){
			DetailListVO.DetailListItemVO item=new DetailListVO().new DetailListItemVO();
			item.update(saleslist.get(i));
			vo.getList().add(item);
		}
		return vo;
	}

	@Override
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		ProcessListVO vo=new ProcessListVO();
		return vo;
	}

	@Override
	public ProcessListVO getProcessList(BillType type) {
		ProcessListVO vo=new ProcessListVO();
		return vo;
	}

	@Override
	public ProcessListVO getProcessList(UserVO operator) {
		ProcessListVO vo=new ProcessListVO();
		return vo;
	}

	@Override
	public ProcessListVO getProcessList(ClientVO client) {
		ProcessListVO vo=new ProcessListVO();
		return vo;
	}

	@Override
	public ProcessListVO getProcessList(String storehouse) {
		ProcessListVO vo=new ProcessListVO();
		return vo;
	}

	@Override
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		InVO in=new InVO(10,10,10,10,10,10,10);
		OutVO out=new OutVO(10,10,10,10);
		ConditionListVO vo=new ConditionListVO(start.toString(),end.toString(),in,out,30);
		return vo;
	}

	@Override
	public ResultMessage export(ProcessListVO list, String dest) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage export(ConditionListVO list, String dest) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage export(DetailListVO list, String dest) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(ReciptVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(PaymentVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		return ResultMessage.Success;
	}

	@Override
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		return ResultMessage.Success;
	}


}

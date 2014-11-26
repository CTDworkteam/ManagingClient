package blservice;
import vo.*;
import enumType.*;
public interface StockBLService {
	public ResultMessage send(GiftBillVO bill);
	public ResultMessage send(OverflowBillVO bill);
	public ResultMessage send(UnderflowBillVO bill);
	public ResultMessage send(NoticeBillVO bill);
	public void execute(GiftBillVO bill);
	public void execute(OverflowBillVO bill);
	public void execute(UnderflowBillVO bill);
}

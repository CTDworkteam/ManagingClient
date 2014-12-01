package blservice;
import vo.*;
import enumType.*;
public interface StockBLService {
	public ResultMessage send(GiftBillVO bill);
	public ResultMessage send(OverflowBillVO bill);
	public ResultMessage send(UnderflowBillVO bill);
	public ResultMessage send(NoticeBillVO bill);
	public ResultMessage execute(GiftBillVO bill);
	public ResultMessage execute(OverflowBillVO bill);
	public ResultMessage execute(UnderflowBillVO bill);
}

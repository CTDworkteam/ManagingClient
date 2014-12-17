package blservice;
import vo.*;
import enumType.*;
import java.util.*;
public interface StockBLService {
	public ResultMessage send(GiftBillVO bill);
	public ResultMessage send(OverflowBillVO bill);
	public ResultMessage send(UnderflowBillVO bill);
	public ResultMessage send(NoticeBillVO bill);
	public ArrayList<GiftBillVO> getAllGiftBills();
	public ArrayList<OverflowBillVO> getAllOverflowBills();
	public ArrayList<UnderflowBillVO> getAllUnderflowBills();
	public ArrayList<NoticeBillVO> getAllNoticeBills();
}

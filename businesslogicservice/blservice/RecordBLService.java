package blservice;

import enumType.Attribute;
import enumType.BillType;
import vo.*;
public interface RecordBLService {
	public void saveCommodityTypeRecord(String operation,String typeNumber); 
	public void saveCommodityTypeModifyRecord(Attribute attribute,String initial,String modify);
	public void saveCommodityRecord(String operation,String commodityNum,String model);
	public void saveCommodityModifyRecord(Attribute attribute,String initial,String modify);
	public void saveStockRecord(String number,String model,Attribute attribute,String initial,String modify);
	public void saveClientRecord(String operation,String number);
	public void saveClientModifyRecord(String number,Attribute attribute,String initial,String modify);    
	public void savePurchaseBillRecord(BillType type,String number);
	public void saveSalesBillRecord(BillType type,String number);
	public void saveAccountRecord(String operation,String name);
	public void saveAccountModifyRecord(AccountVO account,String before,String after);
	public void saveReceiveRecord(String client,String operator,String account,double money,String note);
	public void savePaymentRecord(String client,String operator,String account,double money,String note);
	public void saveExpenseRecord(String account,String item,double money,String note);
}

package recordbl;

import vo.AccountVO;
import enumType.*;

public class MockRecord extends Record{
	MockRecord re=new MockRecord(Operation.Commodity,"asdf",ActionType.Add);
	
	public MockRecord(Operation o,String n,ActionType a){
		this.operation=o;
		this.note=n;
		this.action=a;
	}
	
	public MockRecord(){
	}
	
	public void saveCommodityTypeRecord(String operation,String typeNumber){
	}

	public void saveCommodityTyprModifyRecord(Attribute attribute,
			String initial,String modify){
	}
	
	public void saveCommodityRecord(String operation,String commodityNum,
			String model){
	}
	
	public void saveCommodityModifyRecord(Attribute attribute,
			String initial,String modify){
	}
	
	public void saveStockRecord(String number,String model,
			Attribute attribute,String initial,String modify){
	}
	
	public void saveClientRecord(String operation,String number){
	}
	
	public void saveClientModifyRecord(String number,Attribute attribute,
			String initial,String modify){
	}
	
	public void savePurchaseBillRecord(BillType type,String number){
	}
	
	public void saveSalesBillRecord(BillType type,String number){
	}
	
	public void saveAccountRecord(String operation,String name){
	}
	
	public void saveAccountModifyRecord(AccountVO account,String before,String after){
	}
	
	public void saveReceiveRecord(String client,String operator,
			String account,double money,String note){
	}
	
	public void savePaymentRecord(String client,String operator,
			String account,double money,String note){
	}
	
	public void saveExpenseRecord(String account,String item,double money,String note){
	}
}

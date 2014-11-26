package recordbl;

import vo.AccountVO;
import enumType.Attribute;
import enumType.BillType;
import blservice.RecordBLService;

public class RecordController implements RecordBLService{

	@Override
	public void saveCommodityTypeRecord(String operation, String typeNumber) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveCommodityTypeModifyRecord(Attribute attribute,
			String initial, String modify) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveCommodityRecord(String operation, String commodityNum,
			String model) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveCommodityModifyRecord(Attribute attribute, String initial,
			String modify) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveStockRecord(String number, String model,
			Attribute attribute, String initial, String modify) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveClientRecord(String operation, String number) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveClientModifyRecord(String number, Attribute attribute,
			String initial, String modify) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void savePurchaseBillRecord(BillType type, String number) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveSalesBillRecord(BillType type, String number) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveAccountRecord(String operation, String name) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveAccountModifyRecord(AccountVO account, String before,
			String after) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveReceiveRecord(String client, String operator,
			String account, double money, String note) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void savePaymentRecord(String client, String operator,
			String account, double money, String note) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveExpenseRecord(String account, String item, double money,
			String note) {
		// TODO 自动生成的方法存根
		
	}
	
}
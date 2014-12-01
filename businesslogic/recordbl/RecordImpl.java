package recordbl;

import java.rmi.Naming;

import po.RecordPO;
import dataservice.RecordDataService;
import enumType.*;

public class RecordImpl {
	public void saveCommodityTypeRecord(String operation, String typeNumber){
		try{
			RecordDataService service=(RecordDataService) Naming.lookup("");
			Operation o=exchange(operation);
			ActionType a=exchangeAction(typeNumber);
			RecordPO po=new RecordPO(o,null,a);
			service.insert(po);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void saveCommodityTypeModifyRecord(Attribute attribute,
			String initial, String modify){
		try{
			RecordDataService service=(RecordDataService) Naming.lookup("");
			
		}
	}

	private ActionType exchangeAction(String typeNumber) {
		switch(typeNumber){
		case "Add":
			return ActionType.Add;
		case "Modify":
			return ActionType.Modify;
		case "Approve":
			return ActionType.approve;
		case "Delete":
			return ActionType.Delete;
		default :
			return null;
		}
	}

	private Operation exchange(String operation) {
		switch(operation){
		case "CommodityType":
			return Operation.CommodityType;
		case "Commodity":
			return Operation.Commodity;
		case "Stock":
			return Operation.Stock;
		case "Client":
			return Operation.Client;
		case "PurchaseBill":
			return Operation.PurchaseBill;
		case "SalesBill":
			return Operation.SalesBill;
		case "Account":
			return Operation.Account;
		case "Receive":
			return Operation.Receive;
		case "Payment":
			return Operation.Payment;
		case "Expense":
			return Operation.Expense;
		default :
			return null;
		}
	}
}

package blservice_stub;

import java.util.*;
import po.*;
import vo.*;
import convert.Convert;
import enumType.*;
import dataservice_stub.*;
import blservice.*;

public class RecordBLServiceStub implements RecordBLService{
	private RecordDataServiceStub service = new RecordDataServiceStub();
	public RecordBLServiceStub(){
		
	}
	public void saveDataAddDelRecord(Operation operation, ActionType action,
			String operator, String ID, String name) {
		String newID = calculateDataAddDelRecordID();
		service.addRecord(new DataAddDelRecordPO(newID,operator,operation,ID,name));
	}

	public void saveBillAddDelRecord(Operation operation, ActionType action,
			String operator, String ID) {
		String newID = calculateDataAddDelRecordID();
		String name = null;
		switch(operation){
		case Expense:name = "现金消费单";break;
		case Payment:name = "付款单";break;
		case PurchaseBill:name = "进货单";break;
		case PurchaseReturnBill:name = "进货退货单";break;
		case Receive:name = "收款单";break;
		case SalesBill:name = "销售单";break;
		case SalesReturnBill:name = "销售退货单";break;
		case Stock:
			if(ID.substring(0,2).equals("BY")){
				name = "库存报溢单";
			}
			else if(ID.substring(0,2).equals("BS")){
				name = "库存报损单";
			}
			else if(ID.substring(0,2).equals("ZS")){
				name = "库存赠送单";
			}
			break;
		default:break;
		}
		service.addRecord(new DataAddDelRecordPO(newID,operator,operation,ID,name));
	}

	public void saveDataModifyRecord(String operator,Operation operation, String objectID,
			String objectName, Attribute attribute, String beforeData,String modifyData) {
		String newID = calculateDataModifyRecordID();
		service.addRecord(new DataModifyRecordPO(newID,operator,operation,objectID,objectName,attribute,beforeData,modifyData));
	}

	public void saveBillExecuteRecord(String operator,Operation operation, BillType type,String billID) {
		/* BillRecordPO(String ID,String operator,Operation operation,BillType billtype,String billID)*/
		String newID = calculateBillExecuteRecordID();
		service.addRecord(new BillRecordPO(newID,operator,operation,type,billID));
	}

	public ArrayList<RecordVO> list() {
		ArrayList<RecordVO> list = new ArrayList<RecordVO>();
		Iterator<DataAddDelRecordPO> iter1 = service.getDataAddDelRecordList();
		Iterator<DataModifyRecordPO> iter2 = service.getDataModifyRecordList();
		Iterator<BillRecordPO> iter3 = service.getBillRecordList();
		while(iter1.hasNext()){
			list.add(Convert.convert(iter1.next()));
		}
		while(iter2.hasNext()){
			list.add(Convert.convert(iter2.next()));
		}
		while(iter3.hasNext()){
			list.add(Convert.convert(iter3.next()));
		}
		return list;
	}
	
	private String calculateDataAddDelRecordID(){
		int size = service.numOfDataAddDelRecordPO();
		String ID = "A" + new Integer(size + 1).toString();
		return ID;
	}
	private String calculateDataModifyRecordID(){
		int size = service.numOfDataModifyRecordPO();
		String ID = "M" + new Integer(size + 1).toString();
		return ID;
	}
	private String calculateBillExecuteRecordID(){
		int size = service.numOfBillRecordPO();
		String ID = "B" + new Integer(size + 1).toString();
		return ID;
	}
}

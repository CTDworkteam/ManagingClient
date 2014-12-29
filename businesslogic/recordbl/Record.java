package recordbl;

import java.util.*;

import dataservice.*;
import config.RMI;
import convert.Convert;
import vo.RecordVO;
import blservice.RecordBLService;
import enumType.*;
import po.*;
public class Record implements RecordBLService{
	public void saveDataAddDelRecord(Operation operation, ActionType action,
			String operator, String ID, String name) {
		RecordDataService service = RMI.getRecordDataService();
		String newID = calculateDataAddDelRecordID();
		service.addRecord(new DataAddDelRecordPO(newID,operator,operation,ID,name,action));
	}

	public void saveBillAddDelRecord(Operation operation, ActionType action,
			String operator, String ID) {
		RecordDataService service = RMI.getRecordDataService();
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
		service.addRecord(new DataAddDelRecordPO(newID,operator,operation,ID,name,action));
	}

	public void saveDataModifyRecord(String operator,Operation operation, String objectID,
			String objectName, Attribute attribute, String beforeData,String modifyData) {
		RecordDataService service = RMI.getRecordDataService();
		String newID = calculateDataModifyRecordID();
		service.addRecord(new DataModifyRecordPO(newID,operator,operation,objectID,objectName,attribute,beforeData,modifyData));
	}

	public void saveBillExecuteRecord(String operator,Operation operation, BillType type,String billID) {
		/* BillRecordPO(String ID,String operator,Operation operation,BillType billtype,String billID)*/
		RecordDataService service = RMI.getRecordDataService();
		String newID = calculateBillExecuteRecordID();
		service.addRecord(new BillRecordPO(newID,operator,operation,type,billID));
	}

	public ArrayList<RecordVO> list() {
		RecordDataService service = RMI.getRecordDataService();
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
		RecordDataService service = RMI.getRecordDataService();
		int size = service.numOfDataAddDelRecordPO();
		String ID = "A" + new Integer(size + 1).toString();
		return ID;
	}
	private String calculateDataModifyRecordID(){
		RecordDataService service = RMI.getRecordDataService();
		int size = service.numOfDataModifyRecordPO();
		String ID = "M" + new Integer(size + 1).toString();
		return ID;
	}
	private String calculateBillExecuteRecordID(){
		RecordDataService service = RMI.getRecordDataService();
		int size = service.numOfBillRecordPO();
		String ID = "B" + new Integer(size + 1).toString();
		return ID;
	}
}
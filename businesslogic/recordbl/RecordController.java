package recordbl;

import java.util.ArrayList;

import vo.AccountVO;
import vo.RecordVO;
import enumType.ActionType;
import enumType.Attribute;
import enumType.BillType;
import enumType.Operation;
import blservice.RecordBLService;

public class RecordController implements RecordBLService{
	private Record record;

	@Override
	public void saveDataAddDelRecord(Operation operation, ActionType action,
			String operator, String ID, String name) {
		record.saveDataAddDelRecord(operation, action, operator, ID, name);
		
	}

	@Override
	public void saveBillAddDelRecord(Operation operation, ActionType action,
			String operator, String ID) {
		record.saveBillAddDelRecord(operation, action, operator, ID);
		
	}

	@Override
	public void saveDataModifyRecord(String operator, Operation operation,
			String objectID, String objectName, Attribute attribute,
			String beforeData, String modifyData) {
		record.saveDataModifyRecord(operator, operation, objectID, objectName, attribute, beforeData, modifyData);
	
	}

	@Override
	public void saveBillExecuteRecord(String operator, Operation operation,
			BillType type, String billID) {
		record.saveBillExecuteRecord(operator, operation, type, billID);
		
	}

	@Override
	public ArrayList<RecordVO> list() {
		return record.list();
	}
}
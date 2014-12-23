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

	@Override
	public void saveDataAddDelRecord(Operation operation, ActionType action,
			String operator, String ID, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveBillAddDelRecord(Operation operation, ActionType action,
			String operator, String ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDataModifyRecord(String operator, String objectID,
			String objectName, Attribute attribute, String modifyData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveBillExecuteRecord(String operator, BillType type,
			String billID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<RecordVO> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
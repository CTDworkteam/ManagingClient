package blservice;
import java.util.*;
import enumType.*;
import vo.*;
public interface RecordBLService {
	public void saveDataAddDelRecord(Operation operation,ActionType action,String operator,String ID,String name);
	public void saveBillAddDelRecord(Operation operation,ActionType action,String operator,String ID);
	public void saveDataModifyRecord(String operator,Operation operation,String objectID,
			String objectName,Attribute attribute,String beforeData,String modifyData);
	public void saveBillExecuteRecord(String operator,Operation operation,BillType type,String billID);
	public ArrayList<RecordVO> list();
}

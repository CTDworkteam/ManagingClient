package dataservice;
import java.util.Iterator;
import po.*;
import enumType.ResultMessage;
public interface RecordDataService {
	public ResultMessage addRecord(BillRecordPO po);
	public ResultMessage addRecord(DataModifyRecordPO po);
	public Iterator<BillRecordPO> getBillRecordList();
	public Iterator<DataModifyRecordPO> getDataModifyRecordList();
	public void init();
	public void save();
}

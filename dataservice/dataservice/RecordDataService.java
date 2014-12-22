package dataservice;
import java.util.Iterator;
import po.*;
import enumType.ResultMessage;
public interface RecordDataService {
	public ResultMessage addRecord(BillRecordPO po);
	public ResultMessage addRecord(DataModifyRecordPO po);
	public ResultMessage addRecord(DataAddDelRecordPO po);
	public Iterator<BillRecordPO> getBillRecordList();
	public Iterator<DataModifyRecordPO> getDataModifyRecordList();
	public Iterator<DataAddDelRecordPO> getDataAddDelRecordList();
	public void init();
	public void save();
}

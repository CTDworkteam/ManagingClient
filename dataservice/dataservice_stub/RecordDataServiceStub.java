package dataservice_stub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.BillRecordPO;
import po.DataAddDelRecordPO;
import po.DataModifyRecordPO;
import dataservice.*;
import enumType.ResultMessage;
public class RecordDataServiceStub implements RecordDataService{
	private List<BillRecordPO> list1;
	private List<DataModifyRecordPO> list2;
	private List<DataAddDelRecordPO> list3;
	public RecordDataServiceStub(){
		////
		list1=new ArrayList<BillRecordPO>();
		list2=new ArrayList<DataModifyRecordPO>();
		list3=new ArrayList<DataAddDelRecordPO>();
	}
	public ResultMessage addRecord(BillRecordPO po) {
		list1.add(po);
		return ResultMessage.Success;
	}
	public ResultMessage addRecord(DataModifyRecordPO po) {
		list2.add(po);
		return ResultMessage.Success;
	}
	public Iterator<BillRecordPO> getBillRecordList() {
		return list1.iterator();
	}
	public Iterator<DataModifyRecordPO> getDataModifyRecordList() {
		return list2.iterator();
	}
	public ResultMessage addRecord(DataAddDelRecordPO po) {
		list3.add(po);
		return ResultMessage.Success;
	}
	public Iterator<DataAddDelRecordPO> getDataAddDelRecordList() {
		return list3.iterator();
	}
	public int numOfBillRecordPO() {
		return list1.size();
	}
	public int numOfDataModifyRecordPO() {
		return list2.size();
	}
	public int numOfDataAddDelRecordPO() {
		return list3.size();
	}
}

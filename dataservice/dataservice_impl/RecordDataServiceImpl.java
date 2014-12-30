package dataservice_impl;
import java.util.*;
import po.*;
import dataservice.RecordDataService;
import enumType.ResultMessage;
public class RecordDataServiceImpl implements RecordDataService,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7229340701644930941L;
	private List<BillRecordPO> list1;
	private List<DataModifyRecordPO> list2;
	private List<DataAddDelRecordPO> list3;
	public RecordDataServiceImpl(){
		list1=new ArrayList<BillRecordPO>();
		list2=new ArrayList<DataModifyRecordPO>();
		list3=new ArrayList<DataAddDelRecordPO>();
	}
	public RecordDataServiceImpl(ArrayList<BillRecordPO> newList1,ArrayList<DataModifyRecordPO> newList2,
			ArrayList<DataAddDelRecordPO> newList3){
		list1 = newList1;
		list2 = newList2;
		list3 = newList3;
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
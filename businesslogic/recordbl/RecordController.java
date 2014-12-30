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
	
	public String changeOperation(Operation operation){
		String result="";
		if(operation==Operation.CommodityType){
			result="��Ʒ�������";
		}else{
			if(operation==Operation.Commodity){
				result="��Ʒ����";
			}else{
				if(operation==Operation.Stock){
					result="������";
				}else{
					if(operation==Operation.Client){
						result="�ͻ�����";
					}else{
						if(operation==Operation.PurchaseBill){
							result="������";
						}else{
							if(operation==Operation.PurchaseReturnBill){
								result="�����˻���";
							}else{
								if(operation==Operation.SalesBill){
									result="���۵�";
								}else{
									if(operation==Operation.SalesReturnBill){
										result="�����˻���";
									}else{
										if(operation==Operation.Account){
											result="�˻�����";
										}else{
											if(operation==Operation.Payment){
												result="���";
											}else{
												if(operation==Operation.Receive){
													result="�տ";
												}else{
													result="�ֽ���õ�";
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public String changeAction(ActionType action){
		String result="";
		if(action==ActionType.Add){
			result="����";
		}else{
			if(action==ActionType.Modify){
				result="�޸�";
			}else{
				if(action==ActionType.Delete){
					result="ɾ��";
				}else{
					result="�ύ";
				}
			}
		}
		return result;
	}
}

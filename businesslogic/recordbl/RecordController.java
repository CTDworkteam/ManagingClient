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
			result="商品分类管理";
		}else{
			if(operation==Operation.Commodity){
				result="商品管理";
			}else{
				if(operation==Operation.Stock){
					result="库存管理";
				}else{
					if(operation==Operation.Client){
						result="客户管理";
					}else{
						if(operation==Operation.PurchaseBill){
							result="进货单";
						}else{
							if(operation==Operation.PurchaseReturnBill){
								result="进货退货单";
							}else{
								if(operation==Operation.SalesBill){
									result="销售单";
								}else{
									if(operation==Operation.SalesReturnBill){
										result="销售退货单";
									}else{
										if(operation==Operation.Account){
											result="账户管理";
										}else{
											if(operation==Operation.Payment){
												result="付款单";
											}else{
												if(operation==Operation.Receive){
													result="收款单";
												}else{
													result="现金费用单";
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
			result="增加";
		}else{
			if(action==ActionType.Modify){
				result="修改";
			}else{
				if(action==ActionType.Delete){
					result="删除";
				}else{
					result="提交";
				}
			}
		}
		return result;
	}
}

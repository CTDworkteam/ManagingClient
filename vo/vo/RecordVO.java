package vo;

import enumType.*;

public class RecordVO {
	private Operation operation;
	private ActionType action;
	private String note;
	private String operator;
	public RecordVO(){
	}
	
	public RecordVO(Operation operation, ActionType action, String note,
			String operator) {
		super();
		this.operation = operation;
		this.action = action;
		this.note = note;
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public void setOperation(Operation o){
		this.operation=o;
	}
	
	public Operation getOperation(){
		return operation;
	}
	
	public void setNote(String n){
		this.note=n;
	}
	
	public String getNote(){
		return note;
	}
	
	public ActionType getAction(){
		return action;
	}
	
	public void setAction(ActionType a){
		this.action=a;
	}
}

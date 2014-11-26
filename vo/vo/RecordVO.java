package vo;

import enumType.*;

public class RecordVO {
	private Operation operation;
	private ActionType action;
	private String note;
	
	public RecordVO(Operation o,String n,ActionType a){
		super();
		this.operation=o;
		this.note=n;
		this.action=a;
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

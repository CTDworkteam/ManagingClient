package recordbl;

import enumType.ActionType;
import enumType.Operation;

public class Record{
	public Operation operation;
	public ActionType action;
	public String note;
	
	public Record(Operation o,String n,ActionType a){
		this.operation=o;
		this.note=n;
		this.action=a;
	}
	
	public Record(){
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
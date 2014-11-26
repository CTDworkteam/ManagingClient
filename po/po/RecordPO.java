package po;

import enumType.*;

public class RecordPO implements java.io.Serializable{
	private String id;
	private Operation operation;
	private ActionType action;
	private String note;
	
	public RecordPO(Operation o,String n,ActionType a){
		this.operation=o;
		this.note=n;
		this.action=a;
	}
	public String getID(){
		return id;
	}
	public void setID(String id){
		this.id=id;
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

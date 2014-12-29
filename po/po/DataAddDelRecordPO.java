package po;
import enumType.*;
public class DataAddDelRecordPO {
	private String id;
	private String operator;
	private Operation operation;
	private ActionType action;
	private String objectID;
	private String objectName;
	public DataAddDelRecordPO(){
	}
	public DataAddDelRecordPO(String id, String operator, Operation operation,
			String objectID, String objectName,ActionType action) {
		super();
		this.action = action;
		this.id = id;
		this.operator = operator;
		this.operation = operation;
		this.objectID = objectID;
		this.objectName = objectName;
	}
	public ActionType getAction() {
		return action;
	}
	public void setAction(ActionType action) {
		this.action = action;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
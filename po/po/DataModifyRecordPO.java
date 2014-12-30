package po;
import enumType.*;
public class DataModifyRecordPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3716014843863848155L;
	private String ID;
	private String operator;
	private Operation operation;
	private String objectID;
	private String objectName;
	private Attribute attribute;
	private String beforeData;
	private String afterData;
	public DataModifyRecordPO(){
	}
	public DataModifyRecordPO(String iD, String operator, Operation operation,
			String objectID, String objectName, Attribute attribute,
			String beforeData, String afterData) {
		super();
		ID = iD;
		this.operator = operator;
		this.operation = operation;
		this.objectID = objectID;
		this.objectName = objectName;
		this.attribute = attribute;
		this.beforeData = beforeData;
		this.afterData = afterData;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	public String getBeforeData() {
		return beforeData;
	}
	public void setBeforeData(String beforeData) {
		this.beforeData = beforeData;
	}
	public String getAfterData() {
		return afterData;
	}
	public void setAfterData(String afterData) {
		this.afterData = afterData;
	}
}

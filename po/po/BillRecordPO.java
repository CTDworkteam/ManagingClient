package po;
import enumType.*;
public class BillRecordPO implements java.io.Serializable{
	private String ID;
	private String operator;
	private Operation operation;
	private BillType billtype;
	private String billID;
	public BillRecordPO(String ID,String operator,Operation operation,BillType billtype,String billID){
		this.ID=ID;
		this.operator=operator;
		this.operation=operation;
		this.billtype=billtype;
		this.billID=billID;
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
	public BillType getBilltype() {
		return billtype;
	}
	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
}

package po;

public class UnderflowBillPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private String storehouse;
	private String commodityID;
	private String model;
	private int recordNumber;
	private int actualNumber;
	private String operator;
	private String note;
	public UnderflowBillPO(){
	}
	public UnderflowBillPO(boolean isPassed, String id, String storehouse,
			String commodityID, String model, int recordNumber,
			int actualNumber, String operator, String note) {
		this.isPassed = isPassed;
		this.id = id;
		this.storehouse = storehouse;
		this.commodityID = commodityID;
		this.model = model;
		this.recordNumber = recordNumber;
		this.actualNumber = actualNumber;
		this.operator = operator;
		this.note = note;
	}
	public boolean isPassed() {
		return isPassed;
	}
	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public String getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	public int getActualNumber() {
		return actualNumber;
	}
	public void setActualNumber(int actualNumber) {
		this.actualNumber = actualNumber;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}

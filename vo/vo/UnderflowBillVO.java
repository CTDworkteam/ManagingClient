package vo;

public class UnderflowBillVO {
	private boolean isPassed;
	private String id;
	private String storehouse;
	private String commodity;
	private String model;
	private int recordNumber;
	private int actualNumber;
	private String note;
	private String operator;
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public UnderflowBillVO(String id, String storehouse, String commodity,
			String model, int recordNumber, int actualNumber) {
		super();
		this.id = id;
		this.storehouse = storehouse;
		this.commodity = commodity;
		this.model = model;
		this.recordNumber = recordNumber;
		this.actualNumber = actualNumber;
		this.isPassed=false;
	}
	public UnderflowBillVO() {
		// TODO 自动生成的构造函数存根
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
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
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
}

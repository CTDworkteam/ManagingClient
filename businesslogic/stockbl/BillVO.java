package stockbl;

public class BillVO {
	protected boolean isPassed;
	protected static String id;
	protected static String storehouse;
	protected static String commodity;
	protected static String model;
	protected static int recordNumber;
	protected static int actualNumber;
	
	public BillVO(){
		this(id,storehouse,commodity,model,recordNumber,actualNumber);
	}
	public BillVO(String id, String storehouse, String commodity,
			String model, int recordNumber, int actualNumber) {
		this.id = id;
		this.storehouse = storehouse;
		this.commodity = commodity;
		this.model = model;
		this.recordNumber = recordNumber;
		this.actualNumber = actualNumber;
		this.isPassed=false;
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

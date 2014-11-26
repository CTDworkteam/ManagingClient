package po;

public class UnderflowBillPO implements java.io.Serializable{
	private boolean isPassed;
	private String id;
	private String storehouse;
	private CommodityPO commodity;
	private String model;
	private int recordNumber;
	private int actualNumber;
	public UnderflowBillPO(String id, String storehouse, CommodityPO commodity,
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
	public CommodityPO getCommodity() {
		return commodity;
	}
	public void setCommodity(CommodityPO commodity) {
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

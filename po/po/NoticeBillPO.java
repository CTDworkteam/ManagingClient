package po;

public class NoticeBillPO implements java.io.Serializable{
	private String id;
	private String storehouse;
	private String commodityID;
	private String model;
	private int noticeNumber;
	private int actualNumber;
	public NoticeBillPO(String id, String storehouse, String commodityID,
			String model, int noticeNumber, int actualNumber) {
		this.id = id;
		this.storehouse = storehouse;
		this.commodityID = commodityID;
		this.model = model;
		this.noticeNumber = noticeNumber;
		this.actualNumber = actualNumber;
	}
	public NoticeBillPO() {
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public int getActualNumber() {
		return actualNumber;
	}
	public void setActualNumber(int actualNumber) {
		this.actualNumber = actualNumber;
	}
	public String getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID;
	}
}

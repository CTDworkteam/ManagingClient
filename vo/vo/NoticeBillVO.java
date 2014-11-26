package vo;

public class NoticeBillVO {
	private String id;
	private String storehouse;
	private String commodity;
	private String model;
	private int noticeNumber;
	private int actualNumber;
	public NoticeBillVO(String id, String storehouse, String commodity,
			String model, int noticeNumber, int actualNumber) {
		super();
		this.id = id;
		this.storehouse = storehouse;
		this.commodity = commodity;
		this.model = model;
		this.noticeNumber = noticeNumber;
		this.actualNumber = actualNumber;
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
}

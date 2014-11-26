package vo;
import java.util.ArrayList;
public class CommodityVO {
	private String id;
	private String name;
	private String type;
	private int total;
	private ArrayList<CommodityModelVO> list;
	public CommodityVO(String id, String name, String type, int total,
			ArrayList<CommodityModelVO> list) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.total = total;
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<CommodityModelVO> getList() {
		return list;
	}
	public void setList(ArrayList<CommodityModelVO> list) {
		this.list = list;
	}
}

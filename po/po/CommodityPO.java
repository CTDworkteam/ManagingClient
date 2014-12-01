package po;
import java.util.ArrayList;
public class CommodityPO implements java.io.Serializable{
	private String id;
	private String name;
	private CommodityTypePO type;
	private int total;
	private ArrayList<CommodityModelPO> list;
	public CommodityPO(String id, String name, CommodityTypePO type, int total,
			ArrayList<CommodityModelPO> list) {
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
	public CommodityTypePO getType() {
		return type;
	}
	public void setType(CommodityTypePO type) {
		this.type = type;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<CommodityModelPO> getList() {
		return list;
	}
	public void setList(ArrayList<CommodityModelPO> list) {
		this.list = list;
	}
}

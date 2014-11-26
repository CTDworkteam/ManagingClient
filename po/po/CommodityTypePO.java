package po;
import java.util.ArrayList;;
public class CommodityTypePO implements java.io.Serializable{
	private String id;
	private String name;
	private boolean isRootNode;
	private boolean isLeafNode;
	private ArrayList<CommodityPO> commodityList;
	private CommodityTypePO father;
    private ArrayList<CommodityTypePO> child;
	public CommodityTypePO(String id, String name, boolean isRootNode,
			boolean isLeafNode, ArrayList<CommodityPO> commodityList,
			CommodityTypePO father, ArrayList<CommodityTypePO> child) {
		this.id = id;
		this.name = name;
		this.isRootNode = isRootNode;
		this.isLeafNode = isLeafNode;
		this.commodityList = commodityList;
		this.father = father;
		this.child = child;
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
	public boolean isRootNode() {
		return isRootNode;
	}
	public void setRootNode(boolean isRootNode) {
		this.isRootNode = isRootNode;
	}
	public boolean isLeafNode() {
		return isLeafNode;
	}
	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}
	public ArrayList<CommodityPO> getCommodityList() {
		return commodityList;
	}
	public void setCommodityList(ArrayList<CommodityPO> commodityList) {
		this.commodityList = commodityList;
	}
	public CommodityTypePO getFather() {
		return father;
	}
	public void setFather(CommodityTypePO father) {
		this.father = father;
	}
	public ArrayList<CommodityTypePO> getChild() {
		return child;
	}
	public void setChild(ArrayList<CommodityTypePO> child) {
		this.child = child;
	}
}

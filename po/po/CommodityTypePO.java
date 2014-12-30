package po;
import java.util.ArrayList;;
public class CommodityTypePO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8092702191209861190L;
	private String id;
	private String name;
	private boolean isRootNode;
	private boolean isLeafNode;
	private ArrayList<String> commodityList;
	private String father;
    private ArrayList<String> childs;
	public CommodityTypePO(){
	}
	public CommodityTypePO(String id, String name, boolean isRootNode,
			boolean isLeafNode, ArrayList<String> commodityList, String father,
			ArrayList<String> childs) {
		this.id = id;
		this.name = name;
		this.isRootNode = isRootNode;
		this.isLeafNode = isLeafNode;
		this.commodityList = commodityList;
		this.father = father;
		this.childs = childs;
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
	public ArrayList<String> getCommodityList() {
		return commodityList;
	}
	public void setCommodityList(ArrayList<String> commodityList) {
		this.commodityList = commodityList;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public ArrayList<String> getChilds() {
		return childs;
	}
	public void setChilds(ArrayList<String> childs) {
		this.childs = childs;
	}
}
package vo;
import java.util.ArrayList;
import commoditytypebl.*;
public class CommodityTypeVO {
	private String id;
	private String name;
	private boolean isRootNode;
	private boolean isLeafNode;
	private ArrayList<String> commodityList;
	private String father;
    private ArrayList<String> child;
	public CommodityTypeVO(String id, String name, boolean isRootNode,
			boolean isLeafNode, ArrayList<String> commodityList, String father,
			ArrayList<String> child) {
		super();
		this.id = id;
		this.name = name;
		this.isRootNode = isRootNode;
		this.isLeafNode = isLeafNode;
		this.commodityList = commodityList;
		this.father = father;
		this.child = child;
	}
	public CommodityTypeVO() {
		// TODO 自动生成的构造函数存根
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
	public ArrayList<String> getChild() {
		return child;
	}
	public void setChild(ArrayList<String> child) {
		this.child = child;
	}
	public void update(CommodityType type){
		
	}
	public CommodityType makeCommodityType(){
		return null;
	}
}

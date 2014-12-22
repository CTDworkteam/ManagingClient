package vo;
import java.util.ArrayList;

import commoditytypebl.*;
public class CommodityTypeVO {
	private String id;
	private String name;
	private boolean isRootNode;
	private boolean isLeafNode;
	private ArrayList<CommodityVO> commodityList;
	private CommodityTypeVO father;
    private ArrayList<CommodityTypeVO> child;
	public CommodityTypeVO(){
	}
	public CommodityTypeVO(String id, String name, boolean isRootNode,
			boolean isLeafNode, ArrayList<CommodityVO> commodityList,
			CommodityTypeVO father, ArrayList<CommodityTypeVO> child) {
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
	public ArrayList<CommodityVO> getCommodityList() {
		return commodityList;
	}
	public void setCommodityList(ArrayList<CommodityVO> commodityList) {
		this.commodityList = commodityList;
	}
	public CommodityTypeVO getFather() {
		return father;
	}
	public void setFather(CommodityTypeVO father) {
		this.father = father;
	}
	public ArrayList<CommodityTypeVO> getChild() {
		return child;
	}
	public void setChild(ArrayList<CommodityTypeVO> child) {
		this.child = child;
	}
}

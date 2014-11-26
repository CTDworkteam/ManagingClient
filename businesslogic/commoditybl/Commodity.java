package commoditybl;

import java.util.ArrayList;

public class Commodity{
	public String id;
	public String name;
	public String type;
	public int total;
	public ArrayList<CommodityModel> list;
	
	public Commodity(){
	}
	
	public Commodity(String id, String name, String type, int total,
			ArrayList<CommodityModel> list) {
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
	public ArrayList<CommodityModel> getList() {
		return list;
	}
	public void setList(ArrayList<CommodityModel> list) {
		this.list = list;
	}
}
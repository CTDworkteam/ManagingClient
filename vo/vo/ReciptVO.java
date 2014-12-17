package vo;

import java.util.ArrayList;

public class ReciptVO {
	private boolean isPassed;
	private String id;
	private String operator;
	private String client;
	private ArrayList<FinanceItemVO> list;
	private double total;
	public ReciptVO(String id, String operator, String client,
			ArrayList<FinanceItemVO> list, double total) {
		super();
		this.id = id;
		this.operator = operator;
		this.client = client;
		this.list = list;
		this.total = total;
		this.isPassed=false;
	}
	public ReciptVO() {
		// TODO 自动生成的构造函数存根
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public ArrayList<FinanceItemVO> getList() {
		return list;
	}
	public void setList(ArrayList<FinanceItemVO> list) {
		this.list = list;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}

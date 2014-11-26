package po;

public class AccountPO implements java.io.Serializable{
	private long id;
	private String name;
	private double money;
	public AccountPO(long id,String name, double money) {
		this.id=id;
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}

package po;

public class AccountPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2028781596317182138L;
	private long id;
	private String name;
	private double money;
	public AccountPO(long id,String name, double money) {
		this.id=id;
		this.name = name;
		this.money = money;
	}
	public AccountPO() {
		// TODO 自动生成的构造函数存根
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

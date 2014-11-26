package accountbl;

public class Account {
	public long id;
	public String name;
	public double money;
	public Account(){
	}
	public Account(long id,String name,double money){
		this.id=id;
		this.money=money;
		this.name=name;
	}
}

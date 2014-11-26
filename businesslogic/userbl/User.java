package userbl;

public class User{
	long id;
	RegisterInfo register;
	
	public User(){
	}
	
	public User(long i,RegisterInfo r){
		this.id=i;
		this.register=r;
	}
}
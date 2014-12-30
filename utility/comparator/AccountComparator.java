package comparator;
import po.*;
public class AccountComparator implements java.util.Comparator<AccountPO>,java.io.Serializable{
	public AccountComparator(){
	}
	@Override
	public int compare(AccountPO o1, AccountPO o2) {
		if(o1.getId()<o2.getId())
			return -1;
		else if(o2.getId()<o1.getId())
			return 1;
		else
			return 0;
	}

}

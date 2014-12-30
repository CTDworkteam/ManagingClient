package comparator;
import java.util.*;
import po.*;
public class UserComparator implements Comparator<UserPO>,java.io.Serializable{
	public UserComparator(){}
	public int compare(UserPO o1,UserPO o2){
		return (int)(o2.getId()-o1.getId());
	}
}

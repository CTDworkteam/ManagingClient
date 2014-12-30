package comparator;
import java.util.*;
import po.*;
public class InitialComparator implements Comparator<InitialPO>,java.io.Serializable{
	public InitialComparator(){}
	public int compare(InitialPO o1,InitialPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

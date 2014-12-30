package comparator;
import java.util.*;
import po.*;
public class ReciptComparator implements Comparator<ReciptPO>,java.io.Serializable{
	public ReciptComparator(){}
	public int compare(ReciptPO o1,ReciptPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

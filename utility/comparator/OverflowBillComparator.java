package comparator;
import java.util.*;
import po.*;
public class OverflowBillComparator implements Comparator<OverflowBillPO>,java.io.Serializable{
	public OverflowBillComparator(){}
	public int compare(OverflowBillPO o1,OverflowBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

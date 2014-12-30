package comparator;
import java.util.*;
import po.*;
public class GiftBillComparator implements Comparator<GiftBillPO>,java.io.Serializable{
	public GiftBillComparator(){}
	public int compare(GiftBillPO o1,GiftBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

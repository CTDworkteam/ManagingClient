package comparator;
import java.util.*;
import po.*;
public class PurchaseBillComparator implements Comparator<PurchaseBillPO>,java.io.Serializable{
	public PurchaseBillComparator(){}
	public int compare(PurchaseBillPO o1,PurchaseBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

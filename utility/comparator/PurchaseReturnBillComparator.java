package comparator;
import java.util.*;
import po.*;
public class PurchaseReturnBillComparator implements Comparator<PurchaseReturnBillPO>,java.io.Serializable{
	public PurchaseReturnBillComparator(){}
	public int compare(PurchaseReturnBillPO o1,PurchaseReturnBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

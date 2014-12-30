package comparator;
import java.util.*;
import po.*;
public class SalesReturnBillComparator implements Comparator<SalesReturnBillPO>,java.io.Serializable{
	public SalesReturnBillComparator(){}
	public int compare(SalesReturnBillPO o1,SalesReturnBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

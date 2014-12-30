package comparator;
import java.util.*;
import po.*;
public class PaymentComparator implements Comparator<PaymentPO>,java.io.Serializable{
	public PaymentComparator(){}
	public int compare(PaymentPO o1,PaymentPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

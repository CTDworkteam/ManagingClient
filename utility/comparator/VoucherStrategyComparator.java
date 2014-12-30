package comparator;
import java.util.*;
import po.*;
public class VoucherStrategyComparator implements Comparator<VoucherStrategyPO>,java.io.Serializable{
	public VoucherStrategyComparator(){}
	public int compare(VoucherStrategyPO o1,VoucherStrategyPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

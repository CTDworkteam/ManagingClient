package comparator;
import java.util.*;
import po.*;
public class DiscountStrategyComparator implements Comparator<DiscountStrategyPO>,java.io.Serializable{
	public DiscountStrategyComparator(){}
	public int compare(DiscountStrategyPO o1,DiscountStrategyPO o2){
		return o1.getId().compareTo(o2.getId());
	}

}

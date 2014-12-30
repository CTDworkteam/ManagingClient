package comparator;
import java.util.*;
import po.*;
public class CombinationStrategyComparator implements Comparator<CombinationStrategyPO>,java.io.Serializable{
	public CombinationStrategyComparator(){
	}
	@Override
	public int compare(CombinationStrategyPO o1, CombinationStrategyPO o2) {
		return o1.getId().compareTo(o2.getId());
	}

}

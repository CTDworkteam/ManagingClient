package comparator;
import java.util.*;
import po.*;
public class GiftStrategyComparator implements Comparator<GiftStrategyPO>,java.io.Serializable{
	public GiftStrategyComparator(){}
	public int compare(GiftStrategyPO o1,GiftStrategyPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

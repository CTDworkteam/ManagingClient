package comparator;
import java.util.*;
import po.*;
public class CommodityTypeComparator implements Comparator<CommodityTypePO>,java.io.Serializable{
	public CommodityTypeComparator(){}
	@Override
	public int compare(CommodityTypePO o1, CommodityTypePO o2) {
		return o1.getId().compareTo(o2.getId());
	}
	
}

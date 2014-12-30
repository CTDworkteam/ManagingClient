package comparator;
import java.util.*;

import po.*;
public class SalesBillComparator implements Comparator<SalesBillPO>,java.io.Serializable{
	public SalesBillComparator(){}
	@Override
	public int compare(SalesBillPO o1, SalesBillPO o2) {
		return o1.getId().compareTo(o2.getId());
	}

}

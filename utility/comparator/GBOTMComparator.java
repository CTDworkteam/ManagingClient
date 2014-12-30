package comparator;
import java.util.*;
import po.*;
public class GBOTMComparator implements Comparator<GiftBasedOnTotalMoneyPO>,java.io.Serializable{
	public GBOTMComparator(){}
	public int compare(GiftBasedOnTotalMoneyPO o1,GiftBasedOnTotalMoneyPO o2){
		return o1.getID().compareTo(o2.getID());
	}

}

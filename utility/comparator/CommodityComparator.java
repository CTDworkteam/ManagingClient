package comparator;
import po.*;
public class CommodityComparator implements java.util.Comparator<CommodityPO>,java.io.Serializable{
	public CommodityComparator(){}
	@Override
	public int compare(CommodityPO o1, CommodityPO o2) {
		if(o1.getId().substring(0,11).compareTo(o2.getId().substring(0,11))>0){
			return -1;
		}
		else if(o1.getId().substring(0,11).compareTo(o2.getId().substring(0,11))<0){
			return 1;
		}
		else{
			if(new Integer(o1.getId().substring(11)).intValue()>new Integer(o2.getId().substring(11))){
				return -1;
			}
			else{
				return 1;
			}
		}
	}

}

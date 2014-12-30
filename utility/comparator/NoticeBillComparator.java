package comparator;
import java.util.*;
import po.*;
public class NoticeBillComparator implements Comparator<NoticeBillPO>,java.io.Serializable{
	public NoticeBillComparator(){}
	public int compare(NoticeBillPO o1,NoticeBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

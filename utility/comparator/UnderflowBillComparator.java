package comparator;
import java.util.*;
import java.io.*;
import po.*;
public class UnderflowBillComparator implements Serializable,Comparator<UnderflowBillPO>{
	public UnderflowBillComparator(){}
	public int compare(UnderflowBillPO o1,UnderflowBillPO o2){
		return o1.getId().compareTo(o2.getId());
	}
}

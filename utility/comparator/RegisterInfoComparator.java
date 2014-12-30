package comparator;
import java.util.*;
import po.*;
public class RegisterInfoComparator implements Comparator<RegisterInfoPO>{
	public int compare(RegisterInfoPO o1, RegisterInfoPO o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

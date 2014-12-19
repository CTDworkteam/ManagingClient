package utility;
import java.util.*;
public class Utility {
	public static GregorianCalendar getDate(){
		Calendar today=GregorianCalendar.getInstance();
		GregorianCalendar date=new GregorianCalendar();
		date.set(Calendar.YEAR,date.YEAR);
		date.set(Calendar.MONTH,date.MONTH);
		date.set(Calendar.DAY_OF_MONTH,date.DAY_OF_MONTH);
		return date;
	}
}

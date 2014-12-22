package utility;
import java.util.*;
import java.text.*;
public class Utility {
	public static GregorianCalendar getDate(){
		Calendar today=GregorianCalendar.getInstance();
		GregorianCalendar date=new GregorianCalendar();
		date.set(Calendar.YEAR,date.YEAR);
		date.set(Calendar.MONTH,date.MONTH);
		date.set(Calendar.DAY_OF_MONTH,date.DAY_OF_MONTH);
		return date;
	}
	public static String getIntegerString(int integer,int n){
		String formatString = "0";
		for(int i=2;i<=n;i++){
			formatString+="0";
		}
		DecimalFormat format = new DecimalFormat(formatString);
		String output = format.format(integer);
		return output;
	}
}

package comparator;
import po.*;
import java.util.*;
public class ExpenseComparator implements java.util.Comparator<ExpensePO>,java.io.Serializable{
	public ExpenseComparator(){}
	@Override
	public int compare(ExpensePO o1, ExpensePO o2) {
		GregorianCalendar calendar1=getCalendar(o1.getId());
		GregorianCalendar calendar2=getCalendar(o2.getId());
		if(calendar1.before(calendar2)){
			return -1;
		}
		else if(calendar1.after(calendar2)){
			return 1;
		}
		else{
			String number1=o1.getId().substring(13);
			String number2=o2.getId().substring(13);
			if(new Integer(number1).intValue()>new Integer(number2).intValue()){
				return 1;
			}
			else if(new Integer(number1).intValue()<new Integer(number2).intValue()){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	public GregorianCalendar getCalendar(String id){
		GregorianCalendar calendar=new GregorianCalendar();
		String date=id.substring(5,13);
		calendar.set(Calendar.YEAR,new Integer(date.substring(0,4)).intValue());
		calendar.set(Calendar.MONTH,new Integer(date.substring(4,6)).intValue());
		calendar.set(Calendar.DAY_OF_MONTH,new Integer(date.substring(6)).intValue());
		return calendar;
	}
}

package financecheckbl;
import java.util.*;
public class ConditionList{
	public GregorianCalendar start;
	public GregorianCalendar end;
	public In in;
	public Out out;
	public double total;
	public ConditionList(GregorianCalendar start,GregorianCalendar end,In in,Out out){
		this.start=start;
		this.end=end;
		this.in=in;
		this.out=out;
		this.total=calculateTotal();
	}
	public double calculateTotal(){
		return this.in.total-this.out.total;
	}
	public class In{
		public double salesIn;
		public double overflowIn;
		public double baseChangeIn;
		public double returnIn;
		public double voucherIn;
		public double discount;
		public double total;
		public In(double salesIn, double overflowIn, double baseChangeIn,
				double returnIn, double voucherIn, double discount,double total) {
			this.salesIn = salesIn;
			this.overflowIn = overflowIn;
			this.baseChangeIn = baseChangeIn;
			this.returnIn = returnIn;
			this.voucherIn = voucherIn;
			this.discount = discount;
			this.total=total;
		}
	}
	public class Out{
		public double salesBase;
		public double underflowOut;
		public double giftOut;
		public double total;
		public Out(double salesBase, double underflowOut, double giftOut,
				double total) {
			this.salesBase = salesBase;
			this.underflowOut = underflowOut;
			this.giftOut = giftOut;
			this.total = total;
		}
	}
}
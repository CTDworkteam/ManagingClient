package vo;

public class ConditionListVO {
	private String start;
	private String end;
	private InVO in;
	private OutVO out;
	private double total;
	public ConditionListVO(String start, String end, InVO in, OutVO out,
			double total) {
		super();
		this.start = start;
		this.end = end;
		this.in = in;
		this.out = out;
		this.total = total;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public InVO getIn() {
		return in;
	}
	public void setIn(InVO in) {
		this.in = in;
	}
	public OutVO getOut() {
		return out;
	}
	public void setOut(OutVO out) {
		this.out = out;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}

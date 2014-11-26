package purchasebl;

import java.util.ArrayList;

import vo.PurchaseBillVO.PurchaseBillItemVO;

public class PurchaseBill {
	private boolean isPassed;
	private String id;
	private String supplier;
	private String storehouse;
	private String operator;
	private ArrayList<PurchaseBillItem> list;
	private double total;
	private String note;	
	public PurchaseBill(String id, String supplier, String storehouse,
			String operator, ArrayList<PurchaseBillItem> list, double total,
			String note) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.storehouse = storehouse;
		this.operator = operator;
		this.list = list;
		this.total = total;
		this.note = note;
		this.isPassed=false;
	}
	public class PurchaseBillItem{
		private String commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public PurchaseBillItem(String commodity, String model, int number,
				double price, double total, String note) {
			super();
			this.commodity = commodity;
			this.model = model;
			this.number = number;
			this.price = price;
			this.total = total;
			this.note = note;
		}
	}
}
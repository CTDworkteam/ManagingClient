package purchasebl;

import java.util.ArrayList;

import vo.PurchaseReturnBillVO.PurchaseReturnBillItemVO;

public class PurchaseReturnBill {
	private boolean isPassed;
	private String id;
	private String supplier;
	private String storehouse;
	private String operator;
	private ArrayList<PurchaseReturnBillItemVO> list;
	private double total;
	private String note;
	public PurchaseReturnBill(String id, String supplier, String storehouse,
			String operator, ArrayList<PurchaseReturnBillItemVO> list,
			double total, String note) {
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
	public class PurchaseReturnBillItem{
		private String commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public PurchaseReturnBillItem(String commodity, String model,
				int number, double price, double total, String note) {
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
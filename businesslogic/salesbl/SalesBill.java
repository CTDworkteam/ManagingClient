package salesbl;

import java.util.ArrayList;



public class SalesBill{
	private boolean isPassed;
	private String id;
	private String client;
	private String defaultOperator;
	private String operator;
	private String storehouse;
	private ArrayList<SalesBillItemVO> list;
	private double initialTotal;
	private double discount;
	private double voucher;
	private double total;
	private String note;
	public SalesBill(String id, String client, String defaultOperator,
			String operator, String storehouse,
			ArrayList<SalesBillItemVO> list, double initialTotal,
			double discount, double voucher, double total, String note) {
		super();
		this.id = id;
		this.client = client;
		this.defaultOperator = defaultOperator;
		this.operator = operator;
		this.storehouse = storehouse;
		this.list = list;
		this.initialTotal = initialTotal;
		this.discount = discount;
		this.voucher = voucher;
		this.total = total;
		this.note = note;
		this.isPassed=false;
	}
	public class SalesBillItemVO{
		private String commodity;
		private String model;
		private int number;
		private double price;
		private double total;
		private String note;
		public SalesBillItemVO(String commodity, String model, int number,
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
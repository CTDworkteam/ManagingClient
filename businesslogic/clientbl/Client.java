package clientbl;


import enumType.ClientType;

public class Client{
	public String id;
	public ClientType type;
	public int rank;
	public String name;
	public String telephone;
	public String address;
	public String postcode;
	public String email;
	public double amountReserved;
	public double moneyReserved;
	public double moneyToPay;
	public String counterman;
	public double discount;
	public double voucher;
	
	public Client()
	{
	}
	public Client(String id, String name, ClientType type, int rank,
			String telephone, String address, String postcode, String email,
			double amountReserved, double moneyReserved, double moneyToPay,
			String courterman, double discount, double voucher) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.rank = rank;
		this.telephone = telephone;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.amountReserved = amountReserved;
		this.moneyReserved = moneyReserved;
		this.moneyToPay = moneyToPay;
		this.counterman = courterman;
		this.discount = discount;
		this.voucher = voucher;
	}
	
}
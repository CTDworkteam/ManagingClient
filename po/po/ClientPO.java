package po;
import enumType.ClientType;
public class ClientPO implements java.io.Serializable{
	private long id;
	private String name;
	private ClientType type;
	private int rank;
	private String telephone;
	private String address;
	private String postcode;
	private String email;
	private double amountReserved;
	private double moneyReserved;
	private double moneyToPay;
	private String courterman;
	private double discount;
	private double voucher;
	public ClientPO(long id, String name, ClientType type, int rank,
			String telephone, String address, String postcode, String email,
			double amountReserved, double moneyReserved, double moneyToPay,
			String courterman, double discount, double voucher) {
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
		this.courterman = courterman;
		this.discount = discount;
		this.voucher = voucher;
	}
	public ClientPO() {
		// TODO 自动生成的构造函数存根
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClientType getType() {
		return type;
	}
	public void setType(ClientType type) {
		this.type = type;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAmountReserved() {
		return amountReserved;
	}
	public void setAmountReserved(double amountReserved) {
		this.amountReserved = amountReserved;
	}
	public double getMoneyReserved() {
		return moneyReserved;
	}
	public void setMoneyReserved(double moneyReserved) {
		this.moneyReserved = moneyReserved;
	}
	public double getMoneyToPay() {
		return moneyToPay;
	}
	public void setMoneyToPay(double moneyToPay) {
		this.moneyToPay = moneyToPay;
	}
	public String getCourterman() {
		return courterman;
	}
	public void setCourterman(String courterman) {
		this.courterman = courterman;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	
}

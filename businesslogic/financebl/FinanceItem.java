package financebl;

public class FinanceItem {
	public String account;//帐户名
	public double money;//转账金额
	public String note;//备注信息
	public FinanceItem(){
	}
	public FinanceItem(String account,double money,String note){
		this.account=account;
		this.money=money;
		this.note=note;
	}
}

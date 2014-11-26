package financebl;
import java.util.*;
import clientbl.Client;
import userbl.User;

public class Payment {
	
	public String id;//单据编号
	public Client client;//客户名
	public User operator;//系统操作员
	public ArrayList<FinanceItem> list;//付款条目
	public double total;//转账总额
	public Payment(){
	}
	public Payment(String id,Client client,User operator,ArrayList<FinanceItem> list,double total){
		this.id=id;
		this.client=client;
		this.operator=operator;
		this.list=list;
		this.total=total;
	}
}

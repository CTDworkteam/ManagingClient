package stockbl;
import userbl.User;

import java.util.HashMap;

public class Stock{
	HashMap<String,GiftBill> listOfGiftBill;
	HashMap<String,OverflowBill> listOfOverflowBill;
	HashMap<String,UnderflowBill> listOfUnderflowBill;
	HashMap<String,NoticeBill> listOfNoticeBill;
	User operator;
	public Stock(){
	}
	public Stock(HashMap<String,GiftBill> listOfGiftBill,HashMap<String,OverflowBill> listOfOverflowBill,HashMap<String,UnderflowBill> listOfUnderflowBill,HashMap<String,NoticeBill> listOfNoticeBill,User operator){
		this.listOfGiftBill=listOfGiftBill;
		this.listOfOverflowBill=listOfOverflowBill;
		this.listOfUnderflowBill=listOfUnderflowBill;
		this.listOfNoticeBill=listOfNoticeBill;
		this.operator=operator;
	}
}
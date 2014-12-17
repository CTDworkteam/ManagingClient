package stockcheckbl;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import config.RMI;
import po.CommodityPO;
import po.GiftBillPO;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import po.SalesBillPO;
import po.SalesReturnBillPO;
import po.GiftBillPO.GiftBillItemPO;
import po.PurchaseBillPO.PurchaseBillItemPO;
import po.PurchaseReturnBillPO.PurchaseReturnBillItemPO;
import po.SalesBillPO.SalesBillItemPO;
import po.SalesReturnBillPO.SalesReturnBillItemPO;
import dataservice.CommodityDataService;
import dataservice.PurchaseDataService;
import dataservice.SalesDataService;
import dataservice.StockDataService;
import userbl.*;
import vo.StockCheckListVO;
import vo.StockCommodityListVO;
import blservice.*;
public class StockCheck {
	public User operator;
	public StockCheckListVO check(String storehouse, GregorianCalendar start,
			GregorianCalendar end){
		try{
			StockDataService service=RMI.getStockDataService();
			
			int s=Integer.parseInt(start.toString());
			int e=Integer.parseInt(end.toString());
			if(s>e){
				return new StockCheckListVO("0","0", 0, 0, 0, 0, 0, 0, 0,0,0,0);
			}
			
			double purchase[]=getPurchase(start,end);
			double sales[]=getSales(start,end);	
			int gift=getGift(start,end);
			
			int inNumber=(int) purchase[1];
			int outNumber=gift+(int) sales[1];
			int total=inNumber-outNumber;
			int salesNumber=(int) sales[1];
			
			return new StockCheckListVO(start.toString(),end.toString(),inNumber,
					outNumber,purchase[0],sales[0],inNumber,salesNumber,
					purchase[0],sales[0],total,purchase[0]-sales[0]);
		}catch(Exception ex){
			ex.printStackTrace();
			return new StockCheckListVO("0","0", 0, 0, 0, 0, 0, 0, 0,0,0,0);
		}
	}
	
	public StockCommodityListVO lookover(String storehouse){
		try{
			CommodityDataService service=RMI.getCommodityDataService();
			
			TreeMap<String,TreeSet<CommodityPO>> list=service.getCommodityList();
			
			Iterator it = list.keySet().iterator();
			while(it.hasNext()){
				TreeSet<CommodityPO> temp=list.get(it.next());
				
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private int getGift(GregorianCalendar start, GregorianCalendar end) {
		try{
			StockDataService service=RMI.getStockDataService();
			
			int giftNumber=0;
			TreeSet<GiftBillPO> out=service.finds1(start, end);
			
			Iterator i=out.iterator();
			while(i.hasNext()){
				GiftBillPO temp=(GiftBillPO) i.next();
				ArrayList<GiftBillItemPO> list=temp.getList();
				for(int j=0;j<list.size();j++){
					giftNumber+=list.get(j).getNumber();
				}
			}
			return giftNumber;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	public double[] getPurchase(GregorianCalendar start,
			GregorianCalendar end){
		try{
			PurchaseDataService service2=RMI.getPurchaseDataService();
			
			TreeSet<PurchaseBillPO> in=service2.finds1(start,end);
			TreeSet<PurchaseReturnBillPO> out=service2.finds2(start, end);
			
			double purchaseMoney=0;
			double purchaseNumber=0;
			
			Iterator i=in.iterator();
			while(i.hasNext()){
				PurchaseBillPO m=(PurchaseBillPO) i.next();
				purchaseMoney+=m.getTotal();
			
				ArrayList<PurchaseBillItemPO> temp=m.getList();
				for(int j=0;j<temp.size();j++){
					purchaseNumber+=temp.get(j).getNumber();
				}
			}
			i=out.iterator();
			while(i.hasNext()){
				PurchaseReturnBillPO m=(PurchaseReturnBillPO) i.next();
				purchaseMoney-=m.getTotal();
				
				ArrayList<PurchaseReturnBillItemPO> temp=m.getList();
				for(int j=0;j<temp.size();j++){
					purchaseNumber-=temp.get(j).getNumber();
				}
			}
			
			double result[]=new double[2];
			result[0]=purchaseMoney;
			result[1]=purchaseNumber;
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public double[] getSales(GregorianCalendar start,
			GregorianCalendar end){
		try{
			SalesDataService service3=RMI.getSalesDataService();
			
			TreeSet<SalesBillPO> in2=service3.finds1(start, end);
			TreeSet<SalesReturnBillPO> out2=service3.finds2(start, end);
			double salesMoney=0;
			double salesNumber=0;
			
			Iterator i=in2.iterator();
			while(i.hasNext()){
				SalesBillPO m=(SalesBillPO) i.next();
				salesMoney+=m.getTotal();
			
				ArrayList<SalesBillItemPO> temp=m.getList();
				for(int j=0;j<temp.size();j++){
					salesNumber+=temp.get(j).getNumber();
				}
			}
			i=out2.iterator();
			while(i.hasNext()){
				SalesReturnBillPO m=(SalesReturnBillPO) i.next();
				salesMoney-=m.getTotal();
			
				ArrayList<SalesReturnBillItemPO> temp=m.getList();
				for(int j=0;j<temp.size();j++){
					salesNumber-=temp.get(j).getNumber();
				}
			}
			
			double result[]=new double[2];
			result[0]=salesMoney;
			result[1]=salesNumber;
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			double a[]={0,0};
			return a;
		}
	}
	
}
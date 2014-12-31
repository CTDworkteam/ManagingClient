package blservice_stub;

import java.util.*;
import po.*;
import utility.Utility;
import vo.*;
import dataservice_stub.*;
import blservice.*;
import enumType.ResultMessage;

public class StockCheckBLServiceStub implements StockCheckBLService{
	private StockDataServiceStub stockdata = new StockDataServiceStub();
	private PurchaseDataServiceStub purchasedata = new PurchaseDataServiceStub();
	private SalesDataServiceStub salesdata = new SalesDataServiceStub();
	private CommodityDataServiceStub commoditydata = new CommodityDataServiceStub();
	public StockCheckBLServiceStub(){
		
	}
	public StockCheckListVO check(String storehouse, GregorianCalendar start,
			GregorianCalendar end){
		if(stockdata==null){
			return null;
		}
		else{
			if(start.after(end)){
				return new StockCheckListVO("0","0",0,0,0,0,0,0,0,0,0,0);
			}
			double[] purchase=getPurchase(start,end);
			double[] sales=getSales(start,end);
			int gift=getGift(start,end);
			int inNumber=(int)purchase[1];
			int outNumber=(int)gift+(int)sales[1];
			int total=inNumber-outNumber;
			int salesNumber=(int)sales[1];
			return new StockCheckListVO(start.toString(),end.toString(),
					inNumber,outNumber,purchase[0],sales[0],inNumber,
					salesNumber,purchase[0],sales[0],total,purchase[0]-sales[0]);
		}
	}
	
	public StockCommodityListVO lookover(String storehouse){
		if(commoditydata==null){
			return null;
		}
		else{
			Iterator<CommodityPO> iterator=commoditydata.getAllCommodities();
			ArrayList<StockCommodityInfoVO> list=new ArrayList<StockCommodityInfoVO>();
			while(iterator.hasNext()){
				CommodityPO po=iterator.next();
				ArrayList<CommodityPO.CommodityModelPO> models = po.getList();
				for(int i = 0;i < models.size();i++){
					if(models.get(i).getStorehouse().equals(storehouse)){
						list.add(new StockCommodityInfoVO(po.getName(),models.get(i).getName(),models.get(i).getStock(),
								models.get(i).getRecentRetailPrice(),0,0,Utility.getDate().toString()));
					}
				}
			}
			StockCommodityListVO vo = new StockCommodityListVO();
			vo.setList(list);
			return vo;
		}
	}
	
	public ResultMessage export(StockCommodityListVO list,String dest){
		return ResultMessage.Failure;
	}
	private int getGift(GregorianCalendar start, GregorianCalendar end) {
		if(stockdata==null){
			return -1;
		}
		else{
			int giftNumber=0;
			Iterator<GiftBillPO> iterator=stockdata.finds1(start,end);
			while(iterator.hasNext()){
				GiftBillPO temp=(GiftBillPO)iterator.next();
				Iterator<GiftBillPO.GiftBillItemPO> it=temp.getList().iterator();
				while(it.hasNext()){
					giftNumber+=it.next().getNumber();
				}
			}
			return giftNumber;
		}
	}

	public double[] getPurchase(GregorianCalendar start,
			GregorianCalendar end){
		if(purchasedata==null){
			return null;
		}
		else{
			Iterator<PurchaseBillPO> in=purchasedata.finds1(start, end);
			Iterator<PurchaseReturnBillPO> out=purchasedata.finds2(start, end);
			double purchaseMoney=0;
			double purchaseNumber=0;
			while(in.hasNext()){
				PurchaseBillPO po=in.next();
				purchaseMoney+=po.getTotal();
				Iterator<PurchaseBillPO.PurchaseBillItemPO> item=po.getList().iterator();
				while(item.hasNext()){
					purchaseNumber+=item.next().getNumber();
				}
			}
			while(out.hasNext()){
				PurchaseReturnBillPO po=out.next();
				purchaseMoney-=po.getTotal();
				Iterator<PurchaseReturnBillPO.PurchaseReturnBillItemPO> item=po.getList().iterator();
				while(item.hasNext()){
					purchaseNumber-=item.next().getNumber();
				}
			}
			double[] result=new double[2];
			result[0]=purchaseMoney;
			result[1]=purchaseNumber;
			return result;
		}
	}
	
	public double[] getSales(GregorianCalendar start,
			GregorianCalendar end){
		if(salesdata==null){
			return null;
		}
		else{
			Iterator<SalesBillPO> in=salesdata.finds1(start, end);
			Iterator<SalesReturnBillPO> out=salesdata.finds2(start, end);
			double salesMoney=0;
			double salesNumber=0;
			while(in.hasNext()){
				SalesBillPO m=(SalesBillPO)in.next();
				salesMoney+=m.getTotal();
				Iterator<SalesBillPO.SalesBillItemPO> item=m.getList().iterator();
				while(item.hasNext()){
					salesNumber+=item.next().getNumber();
				}
			}
			while(out.hasNext()){
				SalesReturnBillPO m=(SalesReturnBillPO)out.next();
				salesMoney-=m.getTotal();
				Iterator<SalesReturnBillPO.SalesReturnBillItemPO> item=m.getList().iterator();
				while(item.hasNext()){
					salesNumber-=item.next().getNumber();
				}
			}
			double[] result=new double[2];
			result[0]=salesMoney;
			result[1]=salesNumber;
			return result;
		}
	}
}
package financecheckbl;
import java.util.GregorianCalendar;
import java.util.*;

import vo.*;
import enumType.BillType;
import enumType.ResultMessage;
import blservice.*;
public class FinanceCheckController implements FinanceCheckBLService{
	public FinanceCheck check;
	public FinanceCheckController(){
		check=new FinanceCheck();
	}
	public DetailListVO getDetailList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getDetailList(start, end);
	}
	public DetailListVO getDetailList(String commodity) {
		return check.getDetailList(commodity);
	}
	public DetailListVO getDetailList(ClientVO client) {
		return check.getDetailList(client);
	}
	public DetailListVO getDetailList(UserVO operator) {
		return check.getDetailList(operator);
	}
	public DetailListVO getDetailListInStorehouse(String storehouse) {
		return check.getDetailListInStorehouse(storehouse);
	}
	public ProcessListVO getProcessList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getProcessList(start,end);
	}
	public ProcessListVO getProcessList(BillType type) {
		return check.getProcessList(type);
	}
	public ProcessListVO getProcessList(UserVO operator) {
		return check.getProcessList(operator);
	}
	public ProcessListVO getProcessList(ClientVO client) {
		return check.getProcessList(client);
	}
	public ProcessListVO getProcessList(String storehouse) {
		return check.getProcessList(storehouse);
	}
	public ArrayList<SalesBillVO> getSales(ArrayList<SalesBillVO> listSalesTime,ArrayList<SalesBillVO> listSalesType,ArrayList<SalesBillVO> listSalesClient,ArrayList<SalesBillVO> listSalesOperator,ArrayList<SalesBillVO> listSalesStorehouse){
		ArrayList<SalesBillVO> listSales=new ArrayList<SalesBillVO>();
		int sizeTime=listSalesTime.size();
		int sizeType=listSalesType.size();
		int sizeClient=listSalesClient.size();
		int sizeOperator=listSalesOperator.size();
		int sizeStorehouse=listSalesStorehouse.size();
		if(sizeTime>0){
			listSales=listSalesTime;
		}else{
			if(sizeType>0){
				listSales=listSalesType;
			}else{
				if(sizeClient>0){
					listSales=listSalesClient;
				}else{
					if(sizeOperator>0){
						listSales=listSalesOperator;
					}else{
						listSales=listSalesStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listSales.size();){
				for(int k=0;k<sizeTime;k++){
					if(listSales.get(t).equals(listSalesTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listSales.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listSales.size();){
				for(int k=0;k<sizeType;k++){
					if(listSales.get(t).equals(listSalesType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listSales.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listSales.size();){
				for(int k=0;k<sizeClient;k++){
					if(listSales.get(t).equals(listSalesClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listSales.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listSales.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listSales.get(t).equals(listSalesOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listSales.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listSales.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listSales.get(t).equals(listSalesStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listSales.remove(t);
						}
					}
				}
			}
		}
		return listSales;
	}
	public ArrayList<SalesReturnBillVO> getSalesReturn(ArrayList<SalesReturnBillVO> listSalesReturnTime,ArrayList<SalesReturnBillVO> listSalesReturnType,ArrayList<SalesReturnBillVO> listSalesReturnClient,ArrayList<SalesReturnBillVO> listSalesReturnOperator,ArrayList<SalesReturnBillVO> listSalesReturnStorehouse){
		ArrayList<SalesReturnBillVO> listSalesReturn=new ArrayList<SalesReturnBillVO>();
		int sizeTime=listSalesReturnTime.size();
		int sizeType=listSalesReturnType.size();
		int sizeClient=listSalesReturnClient.size();
		int sizeOperator=listSalesReturnOperator.size();
		int sizeStorehouse=listSalesReturnStorehouse.size();
		
		if(sizeTime>0){
			listSalesReturn=listSalesReturnTime;
		}else{
			if(sizeType>0){
				listSalesReturn=listSalesReturnType;
			}else{
				if(sizeClient>0){
					listSalesReturn=listSalesReturnClient;
				}else{
					if(sizeOperator>0){
						listSalesReturn=listSalesReturnOperator;
					}else{
						listSalesReturn=listSalesReturnStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listSalesReturn.size();){
				for(int k=0;k<sizeTime;k++){
					if(listSalesReturn.get(t).equals(listSalesReturnTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listSalesReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listSalesReturn.size();){
				for(int k=0;k<sizeType;k++){
					if(listSalesReturn.get(t).equals(listSalesReturnType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listSalesReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listSalesReturn.size();){
				for(int k=0;k<sizeClient;k++){
					if(listSalesReturn.get(t).equals(listSalesReturnClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listSalesReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listSalesReturn.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listSalesReturn.get(t).equals(listSalesReturnOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listSalesReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listSalesReturn.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listSalesReturn.get(t).equals(listSalesReturnStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listSalesReturn.remove(t);
						}
					}
				}
			}
		}
		return listSalesReturn;
	}
	public ArrayList<PurchaseBillVO> getPurchase(ArrayList<PurchaseBillVO> listPurchaseTime,ArrayList<PurchaseBillVO> listPurchaseType,ArrayList<PurchaseBillVO> listPurchaseClient,ArrayList<PurchaseBillVO> listPurchaseOperator,ArrayList<PurchaseBillVO> listPurchaseStorehouse){
		ArrayList<PurchaseBillVO> listPurchase=new ArrayList<PurchaseBillVO>();
		int sizeTime=listPurchaseTime.size();
		int sizeType=listPurchaseType.size();
		int sizeClient=listPurchaseClient.size();
		int sizeOperator=listPurchaseOperator.size();
		int sizeStorehouse=listPurchaseStorehouse.size();
		
		if(sizeTime>0){
			listPurchase=listPurchaseTime;
		}else{
			if(sizeType>0){
				listPurchase=listPurchaseType;
			}else{
				if(sizeClient>0){
					listPurchase=listPurchaseClient;
				}else{
					if(sizeOperator>0){
						listPurchase=listPurchaseOperator;
					}else{
						listPurchase=listPurchaseStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listPurchase.size();){
				for(int k=0;k<sizeTime;k++){
					if(listPurchase.get(t).equals(listPurchaseTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listPurchase.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listPurchase.size();){
				for(int k=0;k<sizeType;k++){
					if(listPurchase.get(t).equals(listPurchaseType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listPurchase.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listPurchase.size();){
				for(int k=0;k<sizeClient;k++){
					if(listPurchase.get(t).equals(listPurchaseClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listPurchase.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listPurchase.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listPurchase.get(t).equals(listPurchaseOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listPurchase.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listPurchase.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listPurchase.get(t).equals(listPurchaseStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listPurchase.remove(t);
						}
					}
				}
			}
		}
		return listPurchase;
	}
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturn(ArrayList<PurchaseReturnBillVO> listPurchaseReturnTime,ArrayList<PurchaseReturnBillVO> listPurchaseReturnType,ArrayList<PurchaseReturnBillVO> listPurchaseReturnClient,ArrayList<PurchaseReturnBillVO> listPurchaseReturnOperator,ArrayList<PurchaseReturnBillVO> listPurchaseReturnStorehouse){
		ArrayList<PurchaseReturnBillVO> listPurchaseReturn=new ArrayList<PurchaseReturnBillVO>();
		int sizeTime=listPurchaseReturnTime.size();
		int sizeType=listPurchaseReturnType.size();
		int sizeClient=listPurchaseReturnClient.size();
		int sizeOperator=listPurchaseReturnOperator.size();
		int sizeStorehouse=listPurchaseReturnStorehouse.size();
		
		if(sizeTime>0){
			listPurchaseReturn=listPurchaseReturnTime;
		}else{
			if(sizeType>0){
				listPurchaseReturn=listPurchaseReturnType;
			}else{
				if(sizeClient>0){
					listPurchaseReturn=listPurchaseReturnClient;
				}else{
					if(sizeOperator>0){
						listPurchaseReturn=listPurchaseReturnOperator;
					}else{
						listPurchaseReturn=listPurchaseReturnStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listPurchaseReturn.size();){
				for(int k=0;k<sizeTime;k++){
					if(listPurchaseReturn.get(t).equals(listPurchaseReturnTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listPurchaseReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listPurchaseReturn.size();){
				for(int k=0;k<sizeType;k++){
					if(listPurchaseReturn.get(t).equals(listPurchaseReturnType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listPurchaseReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listPurchaseReturn.size();){
				for(int k=0;k<sizeClient;k++){
					if(listPurchaseReturn.get(t).equals(listPurchaseReturnClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listPurchaseReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listPurchaseReturn.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listPurchaseReturn.get(t).equals(listPurchaseReturnOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listPurchaseReturn.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listPurchaseReturn.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listPurchaseReturn.get(t).equals(listPurchaseReturnStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listPurchaseReturn.remove(t);
						}
					}
				}
			}
		}
		return listPurchaseReturn;
	}
	public ArrayList<ReciptVO> getRecipt(ArrayList<ReciptVO> listReciptTime,ArrayList<ReciptVO> listReciptType,ArrayList<ReciptVO> listReciptClient,ArrayList<ReciptVO> listReciptOperator,ArrayList<ReciptVO> listReciptStorehouse){
		ArrayList<ReciptVO> listRecipt=new ArrayList<ReciptVO>();
		int sizeTime=listReciptTime.size();
		int sizeType=listReciptType.size();
		int sizeClient=listReciptClient.size();
		int sizeOperator=listReciptOperator.size();
		int sizeStorehouse=listReciptStorehouse.size();
		
		if(sizeTime>0){
			listRecipt=listReciptTime;
		}else{
			if(sizeType>0){
				listRecipt=listReciptType;
			}else{
				if(sizeClient>0){
					listRecipt=listReciptClient;
				}else{
					if(sizeOperator>0){
						listRecipt=listReciptOperator;
					}else{
						listRecipt=listReciptStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listRecipt.size();){
				for(int k=0;k<sizeTime;k++){
					if(listRecipt.get(t).equals(listReciptTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listRecipt.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listRecipt.size();){
				for(int k=0;k<sizeType;k++){
					if(listRecipt.get(t).equals(listReciptType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listRecipt.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listRecipt.size();){
				for(int k=0;k<sizeClient;k++){
					if(listRecipt.get(t).equals(listReciptClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listRecipt.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listRecipt.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listRecipt.get(t).equals(listReciptOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listRecipt.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listRecipt.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listRecipt.get(t).equals(listReciptStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listRecipt.remove(t);
						}
					}
				}
			}
		}
		return listRecipt;
	}
	public ArrayList<PaymentVO> getPayment(ArrayList<PaymentVO> listPaymentTime,ArrayList<PaymentVO> listPaymentType,ArrayList<PaymentVO> listPaymentClient,ArrayList<PaymentVO> listPaymentOperator,ArrayList<PaymentVO> listPaymentStorehouse){
		ArrayList<PaymentVO> listPayment=new ArrayList<PaymentVO>();
		int sizeTime=listPaymentTime.size();
		int sizeType=listPaymentType.size();
		int sizeClient=listPaymentClient.size();
		int sizeOperator=listPaymentOperator.size();
		int sizeStorehouse=listPaymentStorehouse.size();
		
		if(sizeTime>0){
			listPayment=listPaymentTime;
		}else{
			if(sizeType>0){
				listPayment=listPaymentType;
			}else{
				if(sizeClient>0){
					listPayment=listPaymentClient;
				}else{
					if(sizeOperator>0){
						listPayment=listPaymentOperator;
					}else{
						listPayment=listPaymentStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listPayment.size();){
				for(int k=0;k<sizeTime;k++){
					if(listPayment.get(t).equals(listPaymentTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listPayment.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listPayment.size();){
				for(int k=0;k<sizeType;k++){
					if(listPayment.get(t).equals(listPaymentType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listPayment.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listPayment.size();){
				for(int k=0;k<sizeClient;k++){
					if(listPayment.get(t).equals(listPaymentClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listPayment.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listPayment.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listPayment.get(t).equals(listPaymentOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listPayment.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listPayment.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listPayment.get(t).equals(listPaymentStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listPayment.remove(t);
						}
					}
				}
			}
		}
		return listPayment;
	}
	public ArrayList<ExpenseVO> getExpense(ArrayList<ExpenseVO> listExpenseTime,ArrayList<ExpenseVO> listExpenseType,ArrayList<ExpenseVO> listExpenseClient,ArrayList<ExpenseVO> listExpenseOperator,ArrayList<ExpenseVO> listExpenseStorehouse){
		ArrayList<ExpenseVO> listExpense=new ArrayList<ExpenseVO>();
		int sizeTime=listExpenseTime.size();
		int sizeType=listExpenseType.size();
		int sizeClient=listExpenseClient.size();
		int sizeOperator=listExpenseOperator.size();
		int sizeStorehouse=listExpenseStorehouse.size();
		
		if(sizeTime>0){
			listExpense=listExpenseTime;
		}else{
			if(sizeType>0){
				listExpense=listExpenseType;
			}else{
				if(sizeClient>0){
					listExpense=listExpenseClient;
				}else{
					if(sizeOperator>0){
						listExpense=listExpenseOperator;
					}else{
						listExpense=listExpenseStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listExpense.size();){
				for(int k=0;k<sizeTime;k++){
					if(listExpense.get(t).equals(listExpenseTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listExpense.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listExpense.size();){
				for(int k=0;k<sizeType;k++){
					if(listExpense.get(t).equals(listExpenseType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listExpense.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listExpense.size();){
				for(int k=0;k<sizeClient;k++){
					if(listExpense.get(t).equals(listExpenseClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listExpense.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listExpense.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listExpense.get(t).equals(listExpenseOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listExpense.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listExpense.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listExpense.get(t).equals(listExpenseStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listExpense.remove(t);
						}
					}
				}
			}
		}
		return listExpense;
	}
	public ArrayList<OverflowBillVO> getOverflow(ArrayList<OverflowBillVO> listOverflowTime,ArrayList<OverflowBillVO> listOverflowType,ArrayList<OverflowBillVO> listOverflowClient,ArrayList<OverflowBillVO> listOverflowOperator,ArrayList<OverflowBillVO> listOverflowStorehouse){
		ArrayList<OverflowBillVO> listOverflow=new ArrayList<OverflowBillVO>();
		int sizeTime=listOverflowTime.size();
		int sizeType=listOverflowType.size();
		int sizeClient=listOverflowClient.size();
		int sizeOperator=listOverflowOperator.size();
		int sizeStorehouse=listOverflowStorehouse.size();
		
		if(sizeTime>0){
			listOverflow=listOverflowTime;
		}else{
			if(sizeType>0){
				listOverflow=listOverflowType;
			}else{
				if(sizeClient>0){
					listOverflow=listOverflowClient;
				}else{
					if(sizeOperator>0){
						listOverflow=listOverflowOperator;
					}else{
						listOverflow=listOverflowStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listOverflow.size();){
				for(int k=0;k<sizeTime;k++){
					if(listOverflow.get(t).equals(listOverflowTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listOverflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listOverflow.size();){
				for(int k=0;k<sizeType;k++){
					if(listOverflow.get(t).equals(listOverflowType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listOverflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listOverflow.size();){
				for(int k=0;k<sizeClient;k++){
					if(listOverflow.get(t).equals(listOverflowClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listOverflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listOverflow.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listOverflow.get(t).equals(listOverflowOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listOverflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listOverflow.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listOverflow.get(t).equals(listOverflowStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listOverflow.remove(t);
						}
					}
				}
			}
		}
		return listOverflow;
	}
	public ArrayList<UnderflowBillVO> getUnderflow(ArrayList<UnderflowBillVO> listUnderflowTime,ArrayList<UnderflowBillVO> listUnderflowType,ArrayList<UnderflowBillVO> listUnderflowClient,ArrayList<UnderflowBillVO> listUnderflowOperator,ArrayList<UnderflowBillVO> listUnderflowStorehouse){
		ArrayList<UnderflowBillVO> listUnderflow=new ArrayList<UnderflowBillVO>();
		int sizeTime=listUnderflowTime.size();
		int sizeType=listUnderflowType.size();
		int sizeClient=listUnderflowClient.size();
		int sizeOperator=listUnderflowOperator.size();
		int sizeStorehouse=listUnderflowStorehouse.size();
		
		if(sizeTime>0){
			listUnderflow=listUnderflowTime;
		}else{
			if(sizeType>0){
				listUnderflow=listUnderflowType;
			}else{
				if(sizeClient>0){
					listUnderflow=listUnderflowClient;
				}else{
					if(sizeOperator>0){
						listUnderflow=listUnderflowOperator;
					}else{
						listUnderflow=listUnderflowStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listUnderflow.size();){
				for(int k=0;k<sizeTime;k++){
					if(listUnderflow.get(t).equals(listUnderflowTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listUnderflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listUnderflow.size();){
				for(int k=0;k<sizeType;k++){
					if(listUnderflow.get(t).equals(listUnderflowType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listUnderflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listUnderflow.size();){
				for(int k=0;k<sizeClient;k++){
					if(listUnderflow.get(t).equals(listUnderflowClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listUnderflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listUnderflow.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listUnderflow.get(t).equals(listUnderflowOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listUnderflow.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listUnderflow.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listUnderflow.get(t).equals(listUnderflowStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listUnderflow.remove(t);
						}
					}
				}
			}
		}
		return listUnderflow;
	}
	public ArrayList<GiftBillVO> getGift(ArrayList<GiftBillVO> listGiftTime,ArrayList<GiftBillVO> listGiftType,ArrayList<GiftBillVO> listGiftClient,ArrayList<GiftBillVO> listGiftOperator,ArrayList<GiftBillVO> listGiftStorehouse){
		ArrayList<GiftBillVO> listGift=new ArrayList<GiftBillVO>();
		int sizeTime=listGiftTime.size();
		int sizeType=listGiftType.size();
		int sizeClient=listGiftClient.size();
		int sizeOperator=listGiftOperator.size();
		int sizeStorehouse=listGiftStorehouse.size();
		
		if(sizeTime>0){
			listGift=listGiftTime;
		}else{
			if(sizeType>0){
				listGift=listGiftType;
			}else{
				if(sizeClient>0){
					listGift=listGiftClient;
				}else{
					if(sizeOperator>0){
						listGift=listGiftOperator;
					}else{
						listGift=listGiftStorehouse;
					}
				}
			}
		}
		
		if(sizeTime>0){
			for(int t=0;t<listGift.size();){
				for(int k=0;k<sizeTime;k++){
					if(listGift.get(t).equals(listGiftTime.get(k))){
						t++;
						break;
					}else{
						if(k==sizeTime-1){
							listGift.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeType>0){
			for(int t=0;t<listGift.size();){
				for(int k=0;k<sizeType;k++){
					if(listGift.get(t).equals(listGiftType.get(k))){
						t++;
						break;
					}else{
						if(k==sizeType-1){
							listGift.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeClient>0){
			for(int t=0;t<listGift.size();){
				for(int k=0;k<sizeClient;k++){
					if(listGift.get(t).equals(listGiftClient.get(k))){
						t++;
						break;
					}else{
						if(k==sizeClient-1){
							listGift.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeOperator>0){
			for(int t=0;t<listGift.size();){
				for(int k=0;k<sizeOperator;k++){
					if(listGift.get(t).equals(listGiftOperator.get(k))){
						t++;
						break;
					}else{
						if(k==sizeOperator-1){
							listGift.remove(t);
						}
					}
				}
			}
		}
		
		if(sizeStorehouse>0){
			for(int t=0;t<listGift.size();){
				for(int k=0;k<sizeStorehouse;k++){
					if(listGift.get(t).equals(listGiftStorehouse.get(k))){
						t++;
						break;
					}else{
						if(k==sizeStorehouse-1){
							listGift.remove(t);
						}
					}
				}
			}
		}
		return listGift;
	}
	public ConditionListVO getConditionList(GregorianCalendar start,
			GregorianCalendar end) {
		return check.getConditionList(start,end);
	}
	public ResultMessage export(ProcessListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage export(ConditionListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage export(DetailListVO list, String dest) {
		return check.export(list,dest);
	}
	public ResultMessage deficitInvoice(SalesBillVO vo) {
		return check.deficitInvoice(vo);
	}
	public ResultMessage deficitInvoice(SalesReturnBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PurchaseBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PurchaseReturnBillVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(ReciptVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(PaymentVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(ExpenseVO vo) {
		return check.defictInvoice(vo);
	}
	public ResultMessage deficitInvoice(GiftBillVO vo) {
		return check.defictInvoice(vo);
	}
}

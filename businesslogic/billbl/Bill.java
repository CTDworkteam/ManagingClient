package billbl;

import java.util.ArrayList;

import po.*;
import vo.*;
import dataservice.*;
import enumType.ResultMessage;
import config.RMI;
public class Bill{
	private AccountDataService accountdataservice;
	private ClientDataService clientdataservice;
	private CommodityDataService commoditydataservice;
	private FinanceDataService financedataservice;
	private PurchaseDataService purchasedataservice;
	private SalesDataService salesdataservice;
	private StockDataService stockdataservice;
	public Bill(){
		accountdataservice=RMI.getAccountDataService();
		clientdataservice=RMI.getClientDataService();
		commoditydataservice=RMI.getCommodityDataService();
		financedataservice=RMI.getFinanceDataService();
		purchasedataservice=RMI.getPurchaseDataService();
		salesdataservice=RMI.getSalesDataService();
		stockdataservice=RMI.getStockDataService();
	}
	public ResultMessage approveGiftBill(GiftBillVO vo) {   //�÷����������͵�ͨ�����������ش���
		try{
			GiftBillPO po = stockdataservice.find1(vo.getId());
			ArrayList<GiftBillVO.GiftBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++) {    //�ҵ���Ӧ��Ʒ
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();  
			
				for(int j = 0;j<list2.size();j++) {   //�ҵ���Ӧ��Ʒ���ͺ�
					if(list2.get(j).getModel().equals(list.get(i).getModel())){
						list2.get(j).setStock(list2.get(j).getStock()-list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //������Ʒ����
				commoditydataservice.updateCommodity(commodity);  //������Ʒ
			}
			po.setPassed(true);
			stockdataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	/*public ResultMessage updateGiftBill(GiftBillVO vo){
		try{
			GiftBillPO temp=exchange(vo);
			GiftBillPO po=stockdataservice.find1(vo.getId());
			for(int i=0;i<po.getList().size();i++){
				po.getList().get(i).setCommodity(temp.getList().get(i).getCommodity());
				po.getList().get(i).setModel(temp.getList().get(i).getModel());
				po.getList().get(i).setNumber(temp.getList().get(i).getNumber());
			}
			stockdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	public ResultMessage approveOverflowBill(OverflowBillVO vo) {   //�÷�������������汨�絥
		try {
			OverflowBillPO po = stockdataservice.find(vo.getId());
			CommodityPO commodity = commoditydataservice.findCommodityInName(vo.getCommodity());
			commodity.setTotal(vo.getActualNumber());   //����Ʒ����ͬ��
			commoditydataservice.updateCommodity(commodity);
			po.setPassed(true);
			stockdataservice.update(po);      //���¿�汨�絥
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateOverflowBill(OverflowBillVO vo){
		try{
			OverflowBillPO temp=exchange(vo);
			OverflowBillPO po=stockdataservice.find(vo.getId());
			po.setCommodity(temp.getCommodity());
			return ResultMessage.Success;
		}catch(Exception ex){
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}*/
	
	public ResultMessage approveUnderflowBill(UnderflowBillVO vo) {    //�÷�������������汨�絥
		try {
			UnderflowBillPO po = stockdataservice.find2(vo.getId());
			CommodityPO commodity = commoditydataservice.findCommodityInName(vo.getCommodity());
			commodity.setTotal(vo.getActualNumber());   //����Ʒ����ͬ��
			commoditydataservice.updateCommodity(commodity);
			po.setPassed(true);     //���¿�汨��
			stockdataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updateUnderflowBill(UnderflowBillVO vo){
 * 
 */
	
	public ResultMessage approvePurchaseBill(PurchaseBillVO vo) {    //�÷�����������������
		try{
			PurchaseBillPO po = purchasedataservice.find1(vo.getId());
			ClientPO client = clientdataservice.find(vo.getSupplier());       //���¿ͻ���Ӧ������
			client.setMoneyReserved(client.getMoneyReserved()+vo.getTotal());
			clientdataservice.update(client);
			
			ArrayList<PurchaseBillVO.PurchaseBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++) {        //���¶�Ӧ��Ʒ�ͺŵĿ������
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
			
				for(int j = 0;j<list2.size();j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())){
						list2.get(j).setStock(list2.get(j).getStock()+list.get(i).getNumber());
						list2.get(j).setRecentPurchasePrice(list.get(i).getPrice());
						break;
					}
				}
				
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal() + list.get(i).getNumber());  //���¸���Ʒ��������
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			purchasedataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
/*	public ResultMessage updatePurchaseBill(PurchaseBillVO vo){
		
	}
	*/
	
	public ResultMessage approvePurchaseReturnBill(PurchaseReturnBillVO vo) {   //�÷����������������˻���
		try {
			PurchaseBillPO po = purchasedataservice.find1(vo.getId());
			ClientPO client = clientdataservice.find(vo.getSupplier());      //���¿ͻ���Ӧ������
			client.setMoneyToPay(client.getMoneyReserved() + vo.getTotal());
			clientdataservice.update(client);
			
			ArrayList<PurchaseReturnBillVO.PurchaseReturnBillItemVO> list = vo.getList();
			for(int i = 0;i<list.size();i++){       //���¶�Ӧ��Ʒ�ͺŵĿ������
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				
				for(int j = 0;j<list2.size();j++){
					if(list.get(i).getModel().equals(list2.get(j).getModel())){
						list2.get(j).setStock(list2.get(j).getStock() - list.get(i).getNumber());
						break;
					}
				}
				commodity.setList(list2);
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());   //������Ʒ������
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			purchasedataservice.update(po);
			return ResultMessage.Success;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesBill(SalesBillVO vo) {      //�÷��������������۵�
		try {
			SalesBillPO po = salesdataservice.find1(vo.getId());
			ClientPO client = commoditydataservice.find(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() + vo.getTotal());   //���¿ͻ�Ӧ�����
			clientdataservice.update(client);
			
			ArrayList<SalesBillVO.SalesBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {    //���¶�Ӧ��Ʒ�ͺŵ�����
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
		
				for(int j = 0;j < list2.size(); j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())) {
						list2.get(j).setStock(list2.get(j).getStock()-list.get(i).getNumber());
						list2.get(j).setRecentRetailPrice(list.get(i).getPrice());
						break;
					}
				}

				commodity.setList(list2);          //������Ӧ��Ʒ��������
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());
				commoditydataservice.updateCommodity(commodity);
			}
		
			po.setPassed(true);
			salesdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveSalesReturnBill(SalesReturnBillVO vo) {
		try {
			SalesReturnBillPO po = salesdataservice.find2(vo.getId());
			ClientPO client = clientdataservice.find(vo.getClient());
			client.setMoneyReserved(client.getMoneyToPay() + vo.getTotal());     //���¿ͻ�Ӧ������
			clientdataservice.update(client);
			
			ArrayList<SalesReturnBillVO.SalesReturnBillItemVO> list = vo.getList();
			for(int i = 0;i < list.size(); i++) {     //���¶�Ӧ��Ʒ�ͺŵ�����
				CommodityPO commodity = commoditydataservice.findCommodityInName(list.get(i).getCommodity());
				ArrayList<CommodityModelPO> list2 = commodity.getList();
				for(int j = 0;j < list2.size();j++) {
					if(list.get(i).getModel().equals(list2.get(j).getModel())) {
						list2.get(j).setStock(list2.get(j).getStock()+list.get(i).getNumber());
						break;
					}
				}
			
				commodity.setList(list2);              //������Ʒ������
				commodity.setTotal(commodity.getTotal()-list.get(i).getNumber());
				commoditydataservice.updateCommodity(commodity);
			}
			
			po.setPassed(true);
			salesdataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approveRecipt(ReciptVO vo) {     //�÷������������տ
		try{
			ClientPO client = financedataservice.findClient1(vo.getClient());
			client.setMoneyToPay(client.getMoneyToPay() - vo.getTotal());  //���¿ͻ�Ӧ�����
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {       //�鿴�˻��������˻��Ľ��
				AccountPO account = financedataservice.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() + temp.get(i).getMoney());
				accountdataservice.update(account);
			}
			ReciptPO po = financedataservice.find1(vo.getId());
			po.setPassed(true);      //����ͨ���տ
			financedataservice.update(po);
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
	
	public ResultMessage approvePayment(PaymentVO vo) {      //�÷��������������
		try{
			ClientPO client =financedataservice.findClient1(vo.getClient());
			client.setMoneyReserved(client.getMoneyReserved() - vo.getTotal());    //���¿ͻ�Ӧ�ս��
			
			ArrayList<FinanceItemVO> temp = vo.getList();
			for(int i = 0;i < temp.size();i++) {     //�����˻���Ϣ
				AccountPO account = financedataservice.findAccount1(temp.get(i).getAccount());
				account.setMoney(account.getMoney() - temp.get(i).getMoney());
				accountdataservice.update(account);
			}
		
			PaymentPO po = financedataservice.find2(vo.getId());
			po.setPassed(true);
			financedataservice.update(po);          //���¸��
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}	
	
	public ResultMessage approveExpense(ExpenseVO vo) {    //�÷������������ֽ���õ�
		try {
			AccountPO account = accountdataservice.find(vo.getAccount());
			account.setMoney(account.getMoney()-vo.getTotal());   //�޸Ķ�Ӧ�˻�����Ϣ
			accountdataservice.update(account);
			
			return ResultMessage.Success;
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResultMessage.Failure;
		}
	}
}
package convert;
import vo.*;
import po.*;
import dataservice.*;

import java.util.*;

import config.RMI;
public class Convert {
	public static AccountVO convert(AccountPO po){
		AccountVO vo=new AccountVO();
		vo.setId(po.getId());
		vo.setMoney(po.getMoney());
		vo.setName(po.getName());
		return vo;
	}
	public static AccountPO convert(AccountVO vo){
		AccountPO po=new AccountPO();
		po.setId(vo.getId());
		po.setMoney(vo.getMoney());
		po.setName(vo.getName());
		return po;
	}
	public static ClientVO convert(ClientPO po){
		ClientVO vo=new ClientVO();
		vo.setAddress(po.getAddress());
		vo.setAmountReserved(po.getAmountReserved());
		vo.setCourterman(po.getCourterman());
		vo.setDiscount(po.getDiscount());
		vo.setEmail(po.getEmail());
		vo.setId(po.getId());
		vo.setMoneyReserved(po.getMoneyReserved());
		vo.setMoneyToPay(po.getMoneyToPay());
		vo.setName(po.getName());
		vo.setPostcode(po.getPostcode());
		vo.setRank(po.getRank());
		vo.setTelephone(po.getTelephone());
		vo.setType(po.getType());
		vo.setVoucher(po.getVoucher());
		return vo;
	}
	public static ClientPO convert(ClientVO vo){
		ClientPO po=new ClientPO();
		po.setAddress(vo.getAddress());
		po.setAmountReserved(vo.getAmountReserved());
		po.setCourterman(vo.getCourterman());
		po.setDiscount(vo.getDiscount());
		po.setEmail(vo.getEmail());
		po.setId(vo.getId());
		po.setMoneyReserved(vo.getMoneyReserved());
		po.setMoneyToPay(vo.getMoneyToPay());
		po.setName(vo.getName());
		po.setPostcode(vo.getPostcode());
		po.setRank(vo.getRank());
		po.setTelephone(vo.getTelephone());
		po.setType(vo.getType());
		po.setVoucher(vo.getVoucher());
		return po;
	}
	public static CommodityVO convert(CommodityPO po){
		CommodityVO vo=new CommodityVO();
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setTotal(po.getTotal());
		vo.setType(service.findByID(po.getType()).getName());
		Iterator<CommodityPO.CommodityModelPO> iterator=po.getList().iterator();
		ArrayList<CommodityModelVO> list=new ArrayList<CommodityModelVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(po.getId(),iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static CommodityPO convert(CommodityVO vo){
		CommodityPO po=new CommodityPO();
		CommodityTypeDataService service=RMI.getCommodityTypeDataService();
		po.setId(vo.getId());
		po.setName(vo.getName());
		po.setTotal(vo.getTotal());
		po.setType(service.findByName(vo.getType()).getId());
		Iterator<CommodityModelVO> iterator=vo.getList().iterator();
		ArrayList<CommodityPO.CommodityModelPO> list=new ArrayList<CommodityPO.CommodityModelPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static CommodityModelVO convert(String commodityID,CommodityPO.CommodityModelPO po){
		CommodityModelVO vo=new CommodityModelVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(commodityID).getName());
		vo.setModel(po.getName());
		vo.setNoticeNumber(po.getNoticeNumber());
		vo.setPurchasePrice(po.getPurchasePrice());
		vo.setRecentPurchasePrice(po.getRecentPurchasePrice());
		vo.setRecentRetailPrice(po.getRecentRetailPrice());
		vo.setRetailPrice(po.getRetailPrice());
		vo.setStockNumber(po.getStock());
		vo.setStorehouse(po.getStorehouse());
		return vo;
	}
	public static CommodityPO.CommodityModelPO convert(CommodityModelVO vo){
		CommodityPO.CommodityModelPO po=new CommodityPO().new CommodityModelPO();
		po.setName(vo.getModel());
		po.setNoticeNumber(vo.getNoticeNumber());
		po.setPurchasePrice(vo.getPurchasePrice());
		po.setRecentPurchasePrice(vo.getRecentPurchasePrice());
		po.setRecentRetailPrice(vo.getRecentRetailPrice());
		po.setRetailPrice(vo.getRetailPrice());
		po.setStock(vo.getStockNumber());
		po.setStorehouse(vo.getStorehouse());
		return po;
	}
	public static CommodityTypeVO convert(CommodityTypePO po){
		CommodityTypeVO vo=new CommodityTypeVO();
		CommodityTypeDataService service1=RMI.getCommodityTypeDataService();
		CommodityDataService service2=RMI.getCommodityDataService();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setRootNode(po.isRootNode());
		vo.setLeafNode(po.isLeafNode());
		vo.setFather(Convert.convert(service1.findByID(po.getFather())));
		Iterator<String> it1=po.getChilds().iterator();
		Iterator<String> it2=po.getCommodityList().iterator();
		ArrayList<CommodityTypeVO> list1=new ArrayList<CommodityTypeVO>();
		ArrayList<CommodityVO> list2=new ArrayList<CommodityVO>();
		while(it1.hasNext()){
			list1.add(Convert.convert(service1.findByID(it1.next())));
		}
		while(it2.hasNext()){
			list2.add(Convert.convert(service2.findCommodityInID(it2.next())));
		}
		vo.setChild(list1);
		vo.setCommodityList(list2);
		return vo;
	}
	public static CommodityTypePO convert(CommodityTypeVO vo){
		CommodityTypePO po=new CommodityTypePO();
		po.setId(vo.getId());
		po.setName(vo.getName());
		po.setLeafNode(vo.isLeafNode());
		po.setRootNode(vo.isRootNode());
		po.setFather(vo.getFather().getId());
		Iterator<CommodityTypeVO> it1=vo.getChild().iterator();
		Iterator<CommodityVO> it2=vo.getCommodityList().iterator();
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		while(it1.hasNext()){
			list1.add(vo.getId());
		}
		while(it2.hasNext()){
			list2.add(vo.getId());
		}
		po.setChilds(list1);
		po.setCommodityList(list2);
		return po;
	}
	public static CombinationStrategyVO convert(CombinationStrategyPO po){
		CombinationStrategyVO vo=new CombinationStrategyVO();
		vo.setId(po.getId());
		vo.setInitialMoney(po.getTotal());
		vo.setLaterMoney(po.getTotal());
		ArrayList<CombinationStrategyVO.CombinationItemVO> list=new ArrayList<CombinationStrategyVO.CombinationItemVO>();
		Iterator<CombinationStrategyPO.CombinationItemPO> iterator=po.getList().iterator();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static CombinationStrategyPO convert(CombinationStrategyVO vo){
		CombinationStrategyPO po=new CombinationStrategyPO();
		po.setId(vo.getId());
		po.setTotal(vo.getLaterMoney());
		ArrayList<CombinationStrategyPO.CombinationItemPO> list=new ArrayList<CombinationStrategyPO.CombinationItemPO>();
		Iterator<CombinationStrategyVO.CombinationItemVO> iterator=vo.getList().iterator();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static CombinationStrategyVO.CombinationItemVO convert(CombinationStrategyPO.CombinationItemPO po){
		CombinationStrategyVO.CombinationItemVO vo=new CombinationStrategyVO().new CombinationItemVO();
		vo.setCommodity(po.getCommodityID());
		vo.setModel(po.getModel());
		vo.setNumber(po.getNumber());
		return vo;
	}
	public static CombinationStrategyPO.CombinationItemPO convert(CombinationStrategyVO.CombinationItemVO vo){
		CombinationStrategyPO.CombinationItemPO po=new CombinationStrategyPO().new CombinationItemPO();
		po.setCommodityID(vo.getCommodity());
		po.setModel(vo.getModel());
		po.setNumber(vo.getNumber());
		return po;
	}
	public static DiscountStrategyVO convert(DiscountStrategyPO po){
		DiscountStrategyVO vo=new DiscountStrategyVO();
		vo.setId(po.getId());
		vo.setDiscount(po.getDiscount());
		vo.setRank(po.getRank());
		return vo;
	}
	public static DiscountStrategyPO convert(DiscountStrategyVO vo){
		DiscountStrategyPO po=new DiscountStrategyPO();
		po.setRank(vo.getRank());
		po.setDiscount(vo.getDiscount());
		po.setId(vo.getId());
		return po;
	}
	public static ExpenseVO convert(ExpensePO po){
		ExpenseVO vo=new ExpenseVO();
		vo.setAccount(po.getAccountname());
		vo.setId(po.getId());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setTotal(po.getTotal());
		Iterator<ExpensePO.ExpenseItemPO> iterator=po.getList().iterator();
		ArrayList<ExpenseVO.ExpenseItemVO> list=new ArrayList<ExpenseVO.ExpenseItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static ExpensePO convert(ExpenseVO vo){
		ExpensePO po=new ExpensePO();
		po.setAccountname(vo.getAccount());
		po.setId(vo.getId());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setTotal(vo.getTotal());
		Iterator<ExpenseVO.ExpenseItemVO> iterator=vo.getList().iterator();
		ArrayList<ExpensePO.ExpenseItemPO> list=new ArrayList<ExpensePO.ExpenseItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static ExpenseVO.ExpenseItemVO convert(ExpensePO.ExpenseItemPO po){
		ExpenseVO.ExpenseItemVO vo=new ExpenseVO().new ExpenseItemVO();
		vo.setItemName(po.getItemName());
		vo.setMoney(po.getMoney());
		vo.setNote(po.getNote());
		return vo;
	}
	public static ExpensePO.ExpenseItemPO convert(ExpenseVO.ExpenseItemVO vo){
		ExpensePO.ExpenseItemPO po=new ExpensePO().new ExpenseItemPO();
		po.setItemName(vo.getItemName());
		po.setMoney(vo.getMoney());
		po.setNote(vo.getNote());
		return po;
	}
	public static GiftBasedOnTotalMoneyVO convert(GiftBasedOnTotalMoneyPO po){
		GiftBasedOnTotalMoneyVO vo=new GiftBasedOnTotalMoneyVO();
		vo.setId(po.getID());
		vo.setLower(po.getLower());
		vo.setUpper(po.getUpper());
		Iterator<GiftBasedOnTotalMoneyPO.GBOTMItemPO> iterator=po.getList().iterator();
		ArrayList<GiftBasedOnTotalMoneyVO.GBOTMItemVO> list=new ArrayList<GiftBasedOnTotalMoneyVO.GBOTMItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static GiftBasedOnTotalMoneyPO convert(GiftBasedOnTotalMoneyVO vo){
		GiftBasedOnTotalMoneyPO po=new GiftBasedOnTotalMoneyPO();
		po.setID(vo.getId());
		po.setLower(vo.getLower());
		po.setUpper(vo.getUpper());
		Iterator<GiftBasedOnTotalMoneyVO.GBOTMItemVO> iterator=vo.getList().iterator();
		ArrayList<GiftBasedOnTotalMoneyPO.GBOTMItemPO> list=new ArrayList<GiftBasedOnTotalMoneyPO.GBOTMItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static GiftBasedOnTotalMoneyVO.GBOTMItemVO convert(GiftBasedOnTotalMoneyPO.GBOTMItemPO po){
		GiftBasedOnTotalMoneyVO.GBOTMItemVO vo=new GiftBasedOnTotalMoneyVO().new GBOTMItemVO();
		vo.setCommodity(po.getCommodityid());
		vo.setModel(po.getModel());
		vo.setNumber(po.getNumber());
		return vo;
	}
	public static GiftBasedOnTotalMoneyPO.GBOTMItemPO convert(GiftBasedOnTotalMoneyVO.GBOTMItemVO vo){
		GiftBasedOnTotalMoneyPO.GBOTMItemPO po=new GiftBasedOnTotalMoneyPO().new GBOTMItemPO();
		po.setCommodityid(vo.getCommodity());
		po.setModel(vo.getModel());
		po.setNumber(vo.getNumber());
		return po;
	}
	public static GiftBillVO convert(GiftBillPO po){
		GiftBillVO vo=new GiftBillVO();
		ClientDataService service=RMI.getClientDataService();
		String client=service.find(po.getClientID()).getName();
		vo.setClient(client);
		vo.setId(po.getId());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setStorehouse(po.getStorehouse());
		Iterator<GiftBillPO.GiftBillItemPO> iterator=po.getList().iterator();
		ArrayList<GiftBillVO.GiftBillItemVO> list=new ArrayList<GiftBillVO.GiftBillItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static GiftBillPO convert(GiftBillVO vo){
		GiftBillPO po=new GiftBillPO();
		ClientDataService service=RMI.getClientDataService();
		long client=service.find(vo.getClient()).getId();
		po.setId(vo.getId());
		po.setClientID(client);
		po.setNote(null);
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setStorehouse(vo.getStorehouse());
		Iterator<GiftBillVO.GiftBillItemVO> iterator=vo.getList().iterator();
		ArrayList<GiftBillPO.GiftBillItemPO> list=new ArrayList<GiftBillPO.GiftBillItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static GiftBillVO.GiftBillItemVO convert(GiftBillPO.GiftBillItemPO po){
		GiftBillVO.GiftBillItemVO vo=new GiftBillVO().new GiftBillItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNumber(po.getNumber());
		return vo;
	}
	public static GiftBillPO.GiftBillItemPO convert(GiftBillVO.GiftBillItemVO vo){
		GiftBillPO.GiftBillItemPO po=new GiftBillPO().new GiftBillItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setModel(vo.getModel());
		po.setNumber(vo.getNumber());
		return po;
	}
	public static GiftStrategyVO convert(GiftStrategyPO po){
		GiftStrategyVO vo=new GiftStrategyVO();
		vo.setRank(po.getRank());
		vo.setId(po.getId());
		vo.setOperator(po.getOperator());
		Iterator<GiftStrategyPO.GiftItemPO> iterator=po.getItemlist().iterator();
		ArrayList<GiftStrategyVO.GiftItemVO> list=new ArrayList<GiftStrategyVO.GiftItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static GiftStrategyPO convert(GiftStrategyVO vo){
		GiftStrategyPO po=new GiftStrategyPO();
		po.setRank(vo.getRank());
		po.setId(vo.getId());
		po.setOperator(vo.getOperator());
		Iterator<GiftStrategyVO.GiftItemVO> iterator=vo.getList().iterator();
		ArrayList<GiftStrategyPO.GiftItemPO> list=new ArrayList<GiftStrategyPO.GiftItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setItemlist(list);
		return po;
	}
	public static GiftStrategyVO.GiftItemVO convert(GiftStrategyPO.GiftItemPO po){
		GiftStrategyVO.GiftItemVO vo=new GiftStrategyVO().new GiftItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		String commodity=service.findCommodityInID(po.getCommodityID()).getName();
		vo.setCommodity(commodity);
		vo.setModel(po.getModel());
		vo.setNumber(po.getNumber());
		return vo;
	}
	public static GiftStrategyPO.GiftItemPO convert(GiftStrategyVO.GiftItemVO vo){
		GiftStrategyPO.GiftItemPO po=new GiftStrategyPO().new GiftItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		String commodityID=service.findCommodityInName(vo.getCommodity()).getId();
		po.setCommodityID(commodityID);
		po.setModel(vo.getModel());
		po.setNumber(vo.getNumber());
		return po;
	}
	public static VoucherBasedOnTotalMoneyPO convert(VoucherBasedOnTotalMoneyVO vo){
		VoucherBasedOnTotalMoneyPO po=new VoucherBasedOnTotalMoneyPO();
		po.setId(vo.getId());
		po.setLower(vo.getLower());
		po.setUpper(vo.getUpper());
		po.setMoney(vo.getMoney());
		return po;
	}
	public static VoucherBasedOnTotalMoneyVO convert(VoucherBasedOnTotalMoneyPO po){
		VoucherBasedOnTotalMoneyVO vo=new VoucherBasedOnTotalMoneyVO();
		vo.setId(po.getId());
		vo.setLower(po.getLower());
		vo.setMoney(po.getMoney());
		vo.setUpper(po.getUpper());
		return vo;
	}
	public static InitialVO convert(InitialPO po){
		InitialVO vo=new InitialVO();
		AccountDataService service1=RMI.getAccountDataService();
		ClientDataService service2=RMI.getClientDataService();
		CommodityDataService service3=RMI.getCommodityDataService();
		CommodityTypeDataService service4=RMI.getCommodityTypeDataService();
		ArrayList<AccountVO> list1=new ArrayList<AccountVO>();
		ArrayList<ClientVO> list2=new ArrayList<ClientVO>();
		ArrayList<CommodityVO> list3=new ArrayList<CommodityVO>();
		ArrayList<CommodityTypeVO> list4=new ArrayList<CommodityTypeVO>();
		Iterator<String> it1=po.getAccount().iterator();
		Iterator<String> it2=po.getClient().iterator();
		Iterator<String> it3=po.getCommodity().iterator();
		Iterator<String> it4=po.getType().iterator();
		while(it1.hasNext()){
			list1.add(Convert.convert(service1.find(it1.next())));
		}
		while(it2.hasNext()){
			list2.add(Convert.convert(service2.find(it2.next())));
		}
		while(it3.hasNext()){
			list3.add(Convert.convert(service3.findCommodityInID(it3.next())));
		}
		while(it4.hasNext()){
			list4.add(Convert.convert(service4.findByID(it4.next())));
		}
		vo.setAccountList(list1);
		vo.setClientList(list2);
		vo.setCommodityList(list3);
		vo.setCommodityTypeList(list4);
		vo.setId(po.getId());
		return vo;
	}
	public static InitialPO convert(InitialVO vo){
		Iterator<AccountVO> it1=vo.getAccountList().iterator();
		Iterator<ClientVO> it2=vo.getClientList().iterator();
		Iterator<CommodityVO> it3=vo.getCommodityList().iterator();
		Iterator<CommodityTypeVO> it4=vo.getCommodityTypeList().iterator();
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		ArrayList<String> list3=new ArrayList<String>();
		ArrayList<String> list4=new ArrayList<String>();
		while(it1.hasNext()){
			list1.add(it1.next().getName());
		}
		while(it2.hasNext()){
			list2.add(it2.next().getName());
		}
		while(it3.hasNext()){
			list3.add(it3.next().getId());
		}
		while(it4.hasNext()){
			list4.add(it4.next().getId());
		}
		InitialPO po=new InitialPO();
		po.setAccount(list1);
		po.setClient(list2);
		po.setCommodity(list3);
		po.setType(list4);
		po.setId(vo.getId());
		return po;
	}
	public static NoticeBillVO convert(NoticeBillPO po){
		NoticeBillVO vo=new NoticeBillVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setId(po.getId());
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNoticeNumber(po.getNoticeNumber());
		vo.setActualNumber(po.getActualNumber());
		vo.setStorehouse(po.getStorehouse());
		return vo;
	}
	public static NoticeBillPO convert(NoticeBillVO vo){
		NoticeBillPO po=new NoticeBillPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setId(vo.getId());
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setActualNumber(vo.getActualNumber());
		po.setNoticeNumber(vo.getNoticeNumber());
		po.setStorehouse(vo.getStorehouse());
		return po;
	}
	public static OverflowBillVO convert(OverflowBillPO po){
		OverflowBillVO vo=new OverflowBillVO();
		vo.setActualNumber(po.getActualNumber());
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setId(po.getCommodityID());
		vo.setModel(po.getModel());
		vo.setPassed(po.isPassed());
		vo.setRecordNumber(po.getRecordNumber());
		vo.setStorehouse(po.getStorehouse());
		vo.setOperator(po.getOperator());
		vo.setNote(po.getNote());
		return vo;
	}
	public static OverflowBillPO convert(OverflowBillVO vo){
		OverflowBillPO po=new OverflowBillPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setActualNumber(vo.getActualNumber());
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setId(vo.getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setRecordNumber(vo.getRecordNumber());
		po.setStorehouse(vo.getStorehouse());
		return po;
	}
	public static UnderflowBillVO convert(UnderflowBillPO po){
		UnderflowBillVO vo=new UnderflowBillVO();
		vo.setActualNumber(po.getActualNumber());
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setId(po.getCommodityID());
		vo.setModel(po.getModel());
		vo.setPassed(po.isPassed());
		vo.setRecordNumber(po.getRecordNumber());
		vo.setStorehouse(po.getStorehouse());
		vo.setOperator(po.getOperator());
		vo.setNote(po.getNote());
		return vo;
	}
	public static UnderflowBillPO convert(UnderflowBillVO vo){
		UnderflowBillPO po=new UnderflowBillPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setActualNumber(vo.getActualNumber());
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setId(vo.getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setRecordNumber(vo.getRecordNumber());
		po.setStorehouse(vo.getStorehouse());
		return po;
	}
	public static PaymentVO convert(PaymentPO po){
		PaymentVO vo=new PaymentVO();
		ClientDataService service=RMI.getClientDataService();
		vo.setClient(service.find(po.getClientID()).getName());
		vo.setId(po.getId());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setTotal(po.getTotal());
		Iterator<PaymentPO.PaymentItemPO> iterator=po.getList().iterator();
		ArrayList<FinanceItemVO> list=new ArrayList<FinanceItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static PaymentPO convert(PaymentVO vo){
		PaymentPO po=new PaymentPO();
		ClientDataService service=RMI.getClientDataService();
		po.setClientID(service.find(vo.getClient()).getId());
		po.setId(vo.getId());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setTotal(vo.getTotal());
		Iterator<FinanceItemVO> iterator=vo.getList().iterator();
		ArrayList<PaymentPO.PaymentItemPO> list=new ArrayList<PaymentPO.PaymentItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convertFinanceItemVO1(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static ReciptVO convert(ReciptPO po){
		ReciptVO vo=new ReciptVO();
		ClientDataService service=RMI.getClientDataService();
		vo.setClient(service.find(po.getClientID()).getName());
		vo.setId(po.getId());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setTotal(po.getTotal());
		Iterator<ReciptPO.ReciptItemPO> iterator=po.getList().iterator();
		ArrayList<FinanceItemVO> list=new ArrayList<FinanceItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static ReciptPO convert(ReciptVO vo){
		ReciptPO po=new ReciptPO();
		ClientDataService service=RMI.getClientDataService();
		po.setClientID(service.find(vo.getClient()).getId());
		po.setId(vo.getId());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setTotal(vo.getTotal());
		Iterator<FinanceItemVO> iterator=vo.getList().iterator();
		ArrayList<ReciptPO.ReciptItemPO> list=new ArrayList<ReciptPO.ReciptItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convertFinanceItemVO2(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static FinanceItemVO convert(PaymentPO.PaymentItemPO po){
		FinanceItemVO vo=new FinanceItemVO();
		vo.setAccount(po.getAccount());
		vo.setMoney(po.getMoney());
		vo.setNote(po.getNote());
		return vo;
	}
	public static FinanceItemVO convert(ReciptPO.ReciptItemPO po){
		FinanceItemVO vo=new FinanceItemVO();
		vo.setAccount(po.getAccount());
		vo.setMoney(po.getMoney());
		vo.setNote(po.getNote());
		return vo;
	}
	public static PaymentPO.PaymentItemPO convertFinanceItemVO1(FinanceItemVO vo){
		PaymentPO.PaymentItemPO po=new PaymentPO().new PaymentItemPO();
		po.setAccount(vo.getAccount());
		po.setMoney(vo.getMoney());
		po.setNote(vo.getNote());
		return po;
	}
	public static ReciptPO.ReciptItemPO convertFinanceItemVO2(FinanceItemVO vo){
		ReciptPO.ReciptItemPO po=new ReciptPO().new ReciptItemPO();
		po.setAccount(vo.getAccount());
		po.setMoney(vo.getMoney());
		po.setNote(vo.getNote());
		return po;
	}
	public static PurchaseBillVO convert(PurchaseBillPO po){
		PurchaseBillVO vo=new PurchaseBillVO();
		vo.setId(po.getId());
		vo.setNote(po.getNote());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setStorehouse(po.getStorehouse());
		vo.setSupplier(po.getSupplier());
		vo.setTotal(po.getTotal());
		Iterator<PurchaseBillPO.PurchaseBillItemPO> iterator=po.getList().iterator();
		ArrayList<PurchaseBillVO.PurchaseBillItemVO> list=new ArrayList<PurchaseBillVO.PurchaseBillItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static PurchaseBillPO convert(PurchaseBillVO vo){
		PurchaseBillPO po=new PurchaseBillPO();
		po.setId(vo.getId());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setStorehouse(vo.getStorehouse());
		po.setSupplier(vo.getSupplier());
		po.setTotal(vo.getTotal());
		Iterator<PurchaseBillVO.PurchaseBillItemVO> iterator=vo.getList().iterator();
		ArrayList<PurchaseBillPO.PurchaseBillItemPO> list=new ArrayList<PurchaseBillPO.PurchaseBillItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		return po;
	}
	public static PurchaseBillVO.PurchaseBillItemVO convert(PurchaseBillPO.PurchaseBillItemPO po){
		PurchaseBillVO.PurchaseBillItemVO vo=new PurchaseBillVO().new PurchaseBillItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNote(po.getNote());
		vo.setNumber(po.getNumber());
		vo.setPrice(po.getPrice());
		vo.setTotal(po.getTotal());
		return vo;
	}
	public static PurchaseBillPO.PurchaseBillItemPO convert(PurchaseBillVO.PurchaseBillItemVO vo){
		PurchaseBillPO.PurchaseBillItemPO po=new PurchaseBillPO().new PurchaseBillItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setNumber(vo.getNumber());
		po.setPrice(vo.getPrice());
		po.setTotal(vo.getTotal());
		return po;
	}
	public static PurchaseReturnBillVO convert(PurchaseReturnBillPO po){
		PurchaseReturnBillVO vo=new PurchaseReturnBillVO();
		vo.setId(po.getId());
		vo.setNote(po.getNote());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setStorehouse(po.getStorehouse());
		vo.setSupplier(po.getSupplier());
		vo.setTotal(po.getTotal());
		Iterator<PurchaseReturnBillPO.PurchaseReturnBillItemPO> iterator=po.getList().iterator();
		ArrayList<PurchaseReturnBillVO.PurchaseReturnBillItemVO> list=
				new ArrayList<PurchaseReturnBillVO.PurchaseReturnBillItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		return vo;
	}
	public static PurchaseReturnBillPO convert(PurchaseReturnBillVO vo){
		PurchaseReturnBillPO po=new PurchaseReturnBillPO();
		po.setId(vo.getId());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setStorehouse(vo.getStorehouse());
		po.setSupplier(vo.getSupplier());
		po.setTotal(vo.getTotal());
		Iterator<PurchaseReturnBillVO.PurchaseReturnBillItemVO> iterator=vo.getList().iterator();
		ArrayList<PurchaseReturnBillPO.PurchaseReturnBillItemPO> list=new ArrayList<PurchaseReturnBillPO.PurchaseReturnBillItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		return po;
	}
	public static PurchaseReturnBillVO.PurchaseReturnBillItemVO convert(PurchaseReturnBillPO.PurchaseReturnBillItemPO po){
		PurchaseReturnBillVO.PurchaseReturnBillItemVO vo=new PurchaseReturnBillVO().new PurchaseReturnBillItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNote(po.getNote());
		vo.setNumber(po.getNumber());
		vo.setPrice(po.getPrice());
		vo.setTotal(po.getTotal());
		return vo;
	}
	public static PurchaseReturnBillPO.PurchaseReturnBillItemPO convert(PurchaseReturnBillVO.PurchaseReturnBillItemVO vo){
		PurchaseReturnBillPO.PurchaseReturnBillItemPO po=new PurchaseReturnBillPO().new PurchaseReturnBillItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setNumber(vo.getNumber());
		po.setPrice(vo.getPrice());
		po.setTotal(vo.getTotal());
		return po;
	}
	public static RegisterInfoVO convert(RegisterInfoPO po){
		RegisterInfoVO vo=new RegisterInfoVO();
		vo.setJob(po.getRole());
		vo.setName(po.getName());
		vo.setPassword(po.getPassword());
		return vo;
	}
	public static RegisterInfoPO convert(RegisterInfoVO vo){
		RegisterInfoPO po=new RegisterInfoPO();
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		po.setRole(vo.getJob());
		return po;
	}
	public static SalesBillVO convert(SalesBillPO po){
		SalesBillVO vo=new SalesBillVO();
		ClientDataService service1=RMI.getClientDataService();
		vo.setClient(service1.find(po.getClientID()).getName());
		vo.setDefaultOperator(po.getDefaultOperator());
		vo.setDiscount(po.getDiscount());
		vo.setId(po.getId());
		vo.setInitialTotal(po.getInitialTotal());
		vo.setNote(po.getNote());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setStorehouse(po.getStorehouse());
		vo.setTotal(po.getTotal());
		vo.setVoucher(po.getVoucher());
		Iterator<SalesBillPO.SalesBillItemPO> iterator=po.getList().iterator();
		ArrayList<SalesBillVO.SalesBillItemVO> list=new ArrayList<SalesBillVO.SalesBillItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		vo.setVoucher(po.getVoucher());
		return vo;
	}
	public static SalesBillPO convert(SalesBillVO vo){
		SalesBillPO po=new SalesBillPO();
		ClientDataService service=RMI.getClientDataService();
		po.setClientID(service.find(vo.getClient()).getId());
		po.setDefaultOperator(vo.getDefaultOperator());
		po.setDiscount(vo.getDiscount());
		po.setId(vo.getId());
		po.setInitialTotal(vo.getInitialTotal());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setStorehouse(vo.getStorehouse());
		po.setTotal(vo.getTotal());
		po.setVoucher(vo.getVoucher());
		Iterator<SalesBillVO.SalesBillItemVO> iterator=vo.getList().iterator();
		ArrayList<SalesBillPO.SalesBillItemPO> list=new ArrayList<SalesBillPO.SalesBillItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static SalesBillVO.SalesBillItemVO convert(SalesBillPO.SalesBillItemPO po){
		SalesBillVO.SalesBillItemVO vo=new SalesBillVO().new SalesBillItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNote(po.getNote());
		vo.setNumber(po.getNumber());
		vo.setPrice(po.getPrice());
		vo.setTotal(po.getTotal());
		return vo;
	}
	public static SalesBillPO.SalesBillItemPO convert(SalesBillVO.SalesBillItemVO vo){
		SalesBillPO.SalesBillItemPO po=new SalesBillPO().new SalesBillItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setNumber(vo.getNumber());
		po.setPrice(vo.getPrice());
		po.setTotal(vo.getTotal());
		return po;
	}
	public static SalesReturnBillVO convert(SalesReturnBillPO po){
		SalesReturnBillVO vo=new SalesReturnBillVO();
		ClientDataService service1=RMI.getClientDataService();
		vo.setClient(service1.find(po.getClientID()).getName());
		vo.setDefaultOperator(po.getDefaultOperator());
		vo.setDiscount(po.getDiscount());
		vo.setId(po.getId());
		vo.setInitialTotal(po.getInitialTotal());
		vo.setNote(po.getNote());
		vo.setOperator(po.getOperator());
		vo.setPassed(po.isPassed());
		vo.setStorehouse(po.getStorehouse());
		vo.setTotal(po.getTotal());
		vo.setVoucher(po.getVoucher());
		Iterator<SalesReturnBillPO.SalesReturnBillItemPO> iterator=po.getList().iterator();
		ArrayList<SalesReturnBillVO.SalesReturnBillItemVO> list=new ArrayList<SalesReturnBillVO.SalesReturnBillItemVO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		vo.setList(list);
		vo.setVoucher(po.getVoucher());
		return vo;
	}
	public static SalesReturnBillPO convert(SalesReturnBillVO vo){
		SalesReturnBillPO po=new SalesReturnBillPO();
		ClientDataService service=RMI.getClientDataService();
		po.setClientID(service.find(vo.getClient()).getId());
		po.setDefaultOperator(vo.getDefaultOperator());
		po.setDiscount(vo.getDiscount());
		po.setId(vo.getId());
		po.setInitialTotal(vo.getInitialTotal());
		po.setNote(vo.getNote());
		po.setOperator(vo.getOperator());
		po.setPassed(vo.isPassed());
		po.setStorehouse(vo.getStorehouse());
		po.setTotal(vo.getTotal());
		po.setVoucher(vo.getVoucher());
		Iterator<SalesReturnBillVO.SalesReturnBillItemVO> iterator=vo.getList().iterator();
		ArrayList<SalesReturnBillPO.SalesReturnBillItemPO> list=new ArrayList<SalesReturnBillPO.SalesReturnBillItemPO>();
		while(iterator.hasNext()){
			list.add(Convert.convert(iterator.next()));
		}
		po.setList(list);
		return po;
	}
	public static SalesReturnBillVO.SalesReturnBillItemVO convert(SalesReturnBillPO.SalesReturnBillItemPO po){
		SalesReturnBillVO.SalesReturnBillItemVO vo=new SalesReturnBillVO().new SalesReturnBillItemVO();
		CommodityDataService service=RMI.getCommodityDataService();
		vo.setCommodity(service.findCommodityInID(po.getCommodityID()).getName());
		vo.setModel(po.getModel());
		vo.setNote(po.getNote());
		vo.setNumber(po.getNumber());
		vo.setPrice(po.getPrice());
		vo.setTotal(po.getTotal());
		return vo;
	}
	public static SalesReturnBillPO.SalesReturnBillItemPO convert(SalesReturnBillVO.SalesReturnBillItemVO vo){
		SalesReturnBillPO.SalesReturnBillItemPO po=new SalesReturnBillPO().new SalesReturnBillItemPO();
		CommodityDataService service=RMI.getCommodityDataService();
		po.setCommodityID(service.findCommodityInName(vo.getCommodity()).getId());
		po.setModel(vo.getModel());
		po.setNote(vo.getNote());
		po.setNumber(vo.getNumber());
		po.setPrice(vo.getPrice());
		po.setTotal(vo.getTotal());
		return po;
	}
	public static UserVO convert(UserPO po){
		UserVO vo=new UserVO();
		vo.setId(po.getId());
		vo.setName(po.getName());
		vo.setPassword(po.getPassword());
		vo.setRole(po.getRole());
		return vo;
	}
	public static UserPO convert(UserVO vo){
		UserPO po=new UserPO();
		po.setId(vo.getId());
		po.setName(vo.getName());
		po.setPassword(vo.getPassword());
		po.setRole(vo.getRole());
		return po;
	}
	public static VoucherStrategyVO convert(VoucherStrategyPO po){
		VoucherStrategyVO vo=new VoucherStrategyVO();
		vo.setRank(po.getRank());
		vo.setId(po.getId());
		vo.setVoucher(po.getVoucher());
		return vo;
	}
	public static VoucherStrategyPO convert(VoucherStrategyVO vo){
		VoucherStrategyPO po=new VoucherStrategyPO();
		po.setId(vo.getId());
		po.setRank(vo.getRank());
		po.setVoucher(vo.getVoucher());
		return po;
	}
	public static RecordVO convert(DataAddDelRecordPO po){
		RecordVO vo=new RecordVO();
		vo.setOperator(po.getOperator());
		vo.setOperation(po.getOperation());
		vo.setAction(po.getAction());
		String note=null;
		switch(po.getOperation()){
		case Account:note="银行账户 ";break;
		case Client:note="客户 ";break;
		case Commodity:note="商品 ";break;
		case CommodityType:note="商品分类 ";break;
		case Expense:note="现金消费单 ";break;
		case Payment:note="付款单 ";break;
		case PurchaseBill:note="进货单 ";break;
		case PurchaseReturnBill:note="进货退货单 ";break;
		case SalesBill:note="销售单 ";break;
		case SalesReturnBill:note="销售退货单 ";break;
		case Receive:note="收款单 ";break;
		case Stock:
			if(po.getObjectID().substring(0,2).equals("BY")){
				note="库存报溢单 ";
			}
			else if(po.getObjectID().substring(0,2).equals("BS")){
				note="库存报损单 ";
			}
			else if(po.getObjectID().substring(0,2).equals("ZS")){
				note="库存赠送单 ";
			}
			break;
		}
		note+=po.getObjectID();
		note+=po.getObjectName();
		vo.setNote(note);
		return vo;
	}
	public static RecordVO convert(DataModifyRecordPO po){
		RecordVO vo=new RecordVO();
		
	}
	public static RecordVO convert(BillRecordPO po){
		RecordVO vo=new RecordVO();
	}
}
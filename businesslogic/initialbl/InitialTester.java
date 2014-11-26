package initialbl;

import java.util.ArrayList;

import enumType.ResultMessage;
import object.TypeTree;
import vo.AccountVO;
import vo.ClientVO;
import vo.CommodityTypeVO;
import vo.CommodityVO;

public class InitialTester {
	public void testAddCT(TypeTree<CommodityTypeVO> tree){
		MockInitial initial=new MockInitial();
		if(initial.addCommodityType(tree)==ResultMessage.Success){
			System.out.println("We have succeeded to initial the new commodityType");
		}
		else{
			System.out.println("We have failed to initial the new commodityType");
		}
	}
	
	public void testAddC(ArrayList<CommodityVO> list){
		MockInitial initial=new MockInitial();
		if(initial.addCommodity(list)==ResultMessage.Success){
			System.out.println("We have succeeded to initial the new commodity");
		}
		else{
			System.out.println("We have failed to initial the new commodity");
		}
	}
	
	public void testAddCL(ArrayList<ClientVO> c){
		MockInitial initial=new MockInitial();
		if(initial.addClient(c)==ResultMessage.Success){
			System.out.println("We have succeeded to initial the new client");
		}
		else{
			System.out.println("We have failed to initial the new client");
		}
	}
	
	public void testAddA(ArrayList<AccountVO> a){
		MockInitial initial=new MockInitial();
		if(initial.addAccount(a)==ResultMessage.Success){
			System.out.println("We have succeeded to initial the new account");
		}
		else{
			System.out.println("We have failed to initial the new account");
		}
	}
}

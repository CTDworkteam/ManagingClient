package blservice_stub;
import java.io.*;
import java.util.*;
import convert.Convert;
import utility.Utility;
import vo.*;
import po.*;
import dataservice_stub.*;
import enumType.ResultMessage;
import blservice.*;
public class ExpenseBLServiceStub implements ExpenseBLService{
	private ExpenseDataServiceStub service = new ExpenseDataServiceStub();
	public ExpenseBLServiceStub(){
		
	}
	public ResultMessage save(ExpenseVO vo){
		try {
			FileWriter fr = new FileWriter("saveForExpense.txt",true);
			BufferedWriter bf = new BufferedWriter(fr);
			
			bf.write(vo.getId()+":"+vo.getOperator()+":"+vo.getAccount()+
					":"+vo.getTotal()+":");
			
			ArrayList<ExpenseVO.ExpenseItemVO> list=vo.getList();
			for(int i = 0;i<list.size();i++){
				if(i == list.size()-1){
					bf.write(list.get(i).getItemName()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+'\n');
				}
				else{
					bf.write(list.get(i).getItemName()+","+
				list.get(i).getMoney()+","+list.get(i).getNote()+":");
				}
			}
			bf.close();
			fr.close();
			return ResultMessage.Success;
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.Failure;
		}	
	}
	
	public ResultMessage send(ExpenseVO vo){
		if(service == null){
			return ResultMessage.Failure;
		}
		
		else{
			ExpensePO po = Convert.convert(vo);		
			service.insert(po);
			return ResultMessage.Success;
		}
	}
	public ExpenseVO find(String id){
		if(service == null){
			return null;
		}
		
		else{
			if(service.contain(id)){
				ExpensePO po = service.find(id);
				ExpenseVO vo = Convert.convert(po);
				return vo;
			}
			return null;
		}
	}
	
	public ArrayList<ExpenseVO> findByCalendar(GregorianCalendar before,GregorianCalendar after){
		if(service == null){
			return null;
		}
		
		else{
			Iterator<ExpensePO> i = service.finds(before, after);
			ArrayList<ExpenseVO> list = new ArrayList<ExpenseVO>();
			
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			return list;
		}
	}
	
	public ArrayList<ExpenseVO> getList(){
		if(service == null){
			return null;
		}
		
		else{
			ArrayList<ExpenseVO> list = new ArrayList<ExpenseVO>();
			TreeMap<String,ExpensePO> list2 = service.getDataList();
			Iterator<ExpensePO> i = list2.values().iterator();
			
			while(i.hasNext()){
				list.add(Convert.convert(i.next()));
			}
			return list;
		}
	}

	public String getNewID(GregorianCalendar date) {
		if(service == null){
			return null;
		}
		
		else{
			String id="XJXFD";
			id+=Utility.getDate();
			int number = service.numberOfExpenses(date);
			id+=Utility.getIntegerString(number,5);
			return id;
		}
	}
}

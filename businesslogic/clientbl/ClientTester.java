/*package clientbl;

import java.util.ArrayList;

import enumType.ResultMessage;
import vo.ClientVO;

public class ClientTester {
	public void testAdder(ClientVO vo){
		MockClient client=new MockClient();
		if(client.add(vo)==ResultMessage.Failure)
			System.out.println("We have failed to add the new client");
		else
			System.out.println("We have succeeded to add the new client");
	}
	public void testDelete(ClientVO vo){
		MockClient client=new MockClient();
		if(client.delete(vo)==ResultMessage.Failure)
			System.out.println("We have failed to delete the client");
		else
			System.out.println("We have succeeded to delete the client");
	}
	public void testUpdate(ClientVO vo){
		MockClient client=new MockClient();
		if(client.update(vo)==ResultMessage.Failure)
			System.out.println("We have failed to update the client");
		else
			System.out.println("We have succeeded to update the client");
	}
	public void testFind(String id){
		MockClient client=new MockClient();
		ClientVO vo=client.find(id);
		if(vo.getId().equals("0000"))
			System.out.println("The client does not exist");
		else{
			System.out.println("Client Information");
			System.out.println("ID:"+vo.getId());
			System.out.println("NAme:"+vo.getName());
		}
	}
    public void testFinds(String name){
    	MockClient client=new MockClient();
    	ArrayList<ClientVO> list=client.finds(name);
    	if(list.isEmpty())
    		System.out.println("The client does not exist");
    	else
    	{
    		System.out.println("Client Information");
    		System.out.println("ID:"+list.get(0).getId());
    		System.out.println("Name:"+list.get(0).getName());
    	}
    		
    
	}
}*/

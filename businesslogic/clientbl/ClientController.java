package clientbl;

import java.util.ArrayList;

import vo.ClientVO;
import enumType.ResultMessage;
import blservice.ClientBLService;
public class ClientController implements ClientBLService{
	public Client client;
	public ClientController(){
		client=new Client();
	}
	public ResultMessage add(ClientVO vo) {
		return client.add(vo);
	}
	public ResultMessage delete(ClientVO vo) {
		return client.delete(vo);
	}
	public ResultMessage update(ClientVO vo) {
		return client.update(vo);
	}
	public ClientVO find(long id) {
		return client.find(id);
	}
	public ArrayList<ClientVO> finds(String key) {
		return client.finds(key);
	}
	public ArrayList<ClientVO> getList() {
		return client.getList();
	}
	@Override
	public long getNewClientID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
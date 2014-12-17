/*package clientbl;

import java.util.ArrayList;

import vo.ClientVO;
import enumType.ClientType;
import enumType.ResultMessage;

public class MockClient extends Client {
	private static Client[] client={new Client("0001","A", null, 0, null, null, null, null, 0, 0, 0, null, 0, 0)};
	public MockClient(String id, String name, ClientType type, int rank,
			String telephone, String address, String postcode, String email,
			double amountReserved, double moneyReserved, double moneyToPay,
			String courterman, double discount, double voucher) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.rank = rank;
		this.telephone = telephone;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.amountReserved = amountReserved;
		this.moneyReserved = moneyReserved;
		this.moneyToPay = moneyToPay;
		this.counterman = courterman;
		this.discount = discount;
		this.voucher = voucher;
	}
	public MockClient()
	{
	}
	public ResultMessage add(ClientVO vo) {
		if(vo.getId().equals(client[0].id))
			return ResultMessage.Failure;
		else
			return ResultMessage.Success;
	}

	public ResultMessage delete(ClientVO vo) {
		if(vo.getId().equals(client[0].id))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	
	public ResultMessage update(ClientVO vo) {
		if(vo.getId().equals(client[0].id))
			return ResultMessage.Success;
		else
			return ResultMessage.Failure;
	}

	
	public ClientVO find(String id) {
	    if(client[0].id.equals(id))
	    	return new ClientVO(client[0].id, client[0].name, type, rank, id, id, id, id, amountReserved, amountReserved, amountReserved, id, amountReserved, amountReserved);
	    else
	    	return new ClientVO("0000", id, type, rank, id, id, id, id, amountReserved, amountReserved, amountReserved, id, amountReserved, amountReserved);
	}

	
	public ArrayList<ClientVO> finds(String key) {
		ClientVO cli=new ClientVO("0001",key, type, rank, key, key, key, key, amountReserved, amountReserved, amountReserved, key, amountReserved, amountReserved);
		ArrayList<ClientVO> ins=new ArrayList<ClientVO>();
		ins.add(cli);
		if(client[0].name.equals(key))
			return ins;
		else
			return new ArrayList<ClientVO>();
			
	}

	
	public ArrayList<ClientVO> getList() {
		ArrayList<ClientVO> list=new ArrayList<ClientVO>();
		list.add(new ClientVO(client[0].id,client[0].name, type, rank, address, address, address, address, amountReserved, amountReserved, amountReserved, address, amountReserved, amountReserved));
		return list;
	}
}*/

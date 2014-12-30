package comparator;
import po.*;
public class ClientComparator implements java.util.Comparator<ClientPO>,java.io.Serializable{
	public ClientComparator(){	
	}
	@Override
	public int compare(ClientPO o1, ClientPO o2) {
		if(o1.getId()>o2.getId())
			return 1;
		else if(o2.getId()>o1.getId())
			return -1;
		else
			return 0;
	}

}

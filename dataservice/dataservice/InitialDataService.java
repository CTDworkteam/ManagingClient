package dataservice;
import java.util.Iterator;
import po.InitialPO;
public interface InitialDataService {
	public void insert(InitialPO po);
	public boolean contain(String id);
	public InitialPO find(String id);
	public boolean isEmpty();
	public Iterator<InitialPO> getAllInitials();
}

package dataservice;
import po.*;
import java.util.*;
public interface CommodityTypeDataService {
	public void insert(CommodityTypePO po);
	public void delete(CommodityTypePO po);
	public void update(CommodityTypePO po);
	public boolean containInID(String id);
	public boolean containInKey(String key);
	public CommodityTypePO findByName(String name);
	public CommodityTypePO findByID(String ID);
	public Iterator<CommodityTypePO> findByKeyword(String key);
	public Iterator<CommodityTypePO> getAllCommodityTypes();
	public boolean hasCommodityType();
}

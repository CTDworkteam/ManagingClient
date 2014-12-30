package dataservice;
import java.util.*;
import po.CommodityPO;
public interface CommodityDataService {
	public void insert(CommodityPO po);
	public void delete(CommodityPO po);
	public void update(CommodityPO po);
	public boolean containInId(String id);
	public CommodityPO findCommodityInID(String id);
	public boolean containInName(String name);
	public CommodityPO findCommodityInName(String name);
	public boolean containInKeyword(String key);
	public Iterator<CommodityPO> findCommoditiesInKeyword(String key);
	public boolean containInType(String id);
	public Iterator<CommodityPO> findCommoditiesInType(String id);
	public Iterator<CommodityPO> getAllCommodities();
	public boolean hasCommodity();
}

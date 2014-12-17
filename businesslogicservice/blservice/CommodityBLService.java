package blservice;
import enumType.*;
import vo.*;
import java.util.*;
public interface CommodityBLService {
	public ResultMessage addCommodity(CommodityVO vo);
	public ResultMessage deleteCommodity(CommodityVO vo);
	public ResultMessage updateCommodity(CommodityVO vo);
	public ResultMessage addModel(CommodityModelVO model);
	public ResultMessage deleteModel(String commodityID,String modelName);
	public ResultMessage updateModel(String beforeName,CommodityModelVO vo);
	public CommodityVO findCommodityByID(String id);
	public CommodityVO findCommodityByName(String name);
	public ArrayList<CommodityVO> findCommodityInKeyword(String key);
	public CommodityModelVO getModel(String commodityID,String model);
	public ArrayList<CommodityVO> getAllCommodity();
}

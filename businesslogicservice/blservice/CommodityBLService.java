package blservice;
import enumType.*;
import vo.*;
import java.util.*;
public interface CommodityBLService {
	public ResultMessage addCommodity(CommodityVO vo);
	public ResultMessage deleteCommodity(CommodityVO vo);
	public ResultMessage updateCommodity(CommodityVO vo);
	public ResultMessage addModel(CommodityModelVO vo);
	public ResultMessage deleteModel(CommodityModelVO vo);
	public ResultMessage updateModel(String beforeName,CommodityModelVO vo);
	public CommodityVO findCommodityInID(String id);
	public ArrayList<CommodityVO> findCommodityInKeyword(String key);
	public CommodityModelVO getModel(CommodityVO vo,String model);
}

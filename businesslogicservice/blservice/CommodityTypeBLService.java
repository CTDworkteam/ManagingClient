package blservice;
import enumType.*;
import vo.*;
import java.util.*;
public interface CommodityTypeBLService {
	public ResultMessage addType(CommodityTypeVO vo);
	public ResultMessage deleteType(CommodityTypeVO vo);
	public ResultMessage updateType(CommodityTypeVO vo);
	public CommodityTypeVO findInID(String id);
	public ArrayList<CommodityTypeVO> findInKeyword(String key);
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo);
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo);
	public ArrayList<CommodityTypeVO> getAllCommodityType();
}

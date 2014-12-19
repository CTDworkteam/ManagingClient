package commoditytypebl;
import java.util.ArrayList;

import vo.CommodityTypeVO;
import vo.CommodityVO;
import enumType.ResultMessage;
import blservice.*;
public class CommodityTypeController implements CommodityTypeBLService{
	public CommodityType type;
	public CommodityTypeController(){
		type=new CommodityType();
	}
	public ResultMessage addType(CommodityTypeVO vo) {
		return type.addType(vo);
	}
	public ResultMessage deleteType(CommodityTypeVO vo) {
		return type.deleteType(vo);
	}
	public ResultMessage updateType(CommodityTypeVO vo) {
		return type.updateType(vo);
	}
	public CommodityTypeVO findInID(String id) {
		return type.findInID(id);
	}
	public ArrayList<CommodityTypeVO> findInKeyword(String key) {
		return type.findInKeyword(key);
	}
	public ArrayList<CommodityTypeVO> getAllSubType(CommodityTypeVO vo) {
		return type.getAllSubType(vo);
	}
	public ArrayList<CommodityVO> getAllCommodity(CommodityTypeVO vo) {
		return type.getAllCommodity(vo);
	}
	public ArrayList<CommodityTypeVO> getAllCommodityType() {
		return null;
	}
	@Override
	public String getNewID(String fatherID) {
		// TODO 自动生成的方法存根
		return null;
	}
}